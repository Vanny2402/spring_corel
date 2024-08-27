package com.jv.crud_operation.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.crypto.Data;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jv.crud_operation.constant.CrudTypeEnum;
import com.jv.crud_operation.exception.AlreadyExistException;
import com.jv.crud_operation.exception.BadRequestException;
import com.jv.crud_operation.exception.NotFoundException;
import com.jv.crud_operation.model.entity.AccountEntity;
import com.jv.crud_operation.model.entity.AccountHistoryEntity;
import com.jv.crud_operation.model.entity.reuest.RestoerCategoryRequest;
import com.jv.crud_operation.model.entity.reuest.account.AccountRequest;
import com.jv.crud_operation.repository.AccountRepository;

import jakarta.persistence.criteria.Predicate;

@Service
@Transactional(readOnly = true)
public class AccountService {
	private final AccountRepository accountRepository;

	public AccountService(AccountRepository categoryRepository) {
		this.accountRepository = categoryRepository;
	}

	@Transactional
	public AccountEntity create(AccountRequest request) throws Exception {

		AccountEntity data = request.toEntity();
		Set<AccountHistoryEntity>accountHistories=new HashSet<>();
		AccountHistoryEntity accountHistory=new AccountHistoryEntity();
		accountHistory.setName(data.getName());
		accountHistory.setType(CrudTypeEnum.CREATE);
		accountHistory.setBalance(data.getBalance());
		accountHistories.add(accountHistory);
		data.setAccountHistory(accountHistories);
		if (this.accountRepository.existsByNameAndDeletedAtIsNull(data.getName()))
			throw new AlreadyExistException("Account Name " + request.getName() + " Alreaduy Exist!");
		try {
			return this.accountRepository.save(data);
		} catch (Exception e) {

			throw new Exception(e);
		}
	}

	@Transactional
	public AccountEntity update(Long id, AccountRequest request) throws Exception {
		//1.To check if account exist or not 
		AccountEntity account=this.findOne(id);
		Set<AccountHistoryEntity>history=new HashSet<>();
		AccountHistoryEntity accountHistory=new AccountHistoryEntity();
		accountHistory.setType(CrudTypeEnum.UPDATE);
		accountHistory.setName(account.getName());
		accountHistory.setBalance(account.getBalance());
	
		account.setName(request.getName());
		account.setBalance(request.getBalance());
		history.add(accountHistory);
		account.setAccountHistory(history);
		
		try {
			return this.accountRepository.save(account);
		} catch (Exception e) {
			throw new Exception(e);
		}			
	}

	public AccountEntity findOne(Long id) throws NotFoundException {
		return this.accountRepository.findById(id).orElseThrow(()->new NotFoundException("The account doesn't exist in system!"));
	}

	private AccountEntity findOneWithSoftDeleted(Long id) throws Exception {
		return this.accountRepository.findById(id).orElseThrow(() -> new NotFoundException("Category not found!"));

	}

	public AccountEntity restore(Long id, RestoerCategoryRequest request) throws Exception {
		return null;
	}

	public AccountEntity delete(Long id) throws NotFoundException {

		return null;
	}

	public Page<AccountEntity> findAll(int page, int limit, Boolean isPage, String sort, Boolean isTrash,
			Map<String, String> reqParam) {
		// 1.To detect if parameter is correct or not
		if (page <= 0 || limit <= 0)
			throw new BadRequestException("Invalid Pagination !");
		// 2.Prepare for list of parameter sort
		List<Sort.Order> sortByList = new ArrayList<>();
		Pageable pageable;
		for (String item : sort.split(",")) {
			String[] srt = item.split(":");
			if (srt.length != 2)
				continue;

			String direction = srt[1].toLowerCase();
			String field = srt[0];

			sortByList.add(new Sort.Order(direction.equals("desc") ? Sort.Direction.DESC : Sort.Direction.ASC, field));
		}
		
		// 3.To check if request as page or not
		if (isPage)
			pageable = PageRequest.of(page - 1, limit, Sort.by(sortByList));
		else
			pageable = Pageable.unpaged();
		
		return this.accountRepository.findAll((Specification<AccountEntity>) (root, query, criteriBuiilder) -> {
			List<Predicate> prediicates = new ArrayList<>();
			for (Map.Entry<String, String> entry : reqParam.entrySet()) {
				if (entry.getKey().startsWith("q_")) {
					String qKey = entry.getKey().split("q_", 2)[1];
					String qVal = entry.getValue() == null ? "" : entry.getValue();
					prediicates.add(criteriBuiilder.like(criteriBuiilder.upper(root.get(qKey).as(String.class)),
							"%" + qVal.toUpperCase() + "%"));
				}
			}

			if (prediicates.size() == 0)
				prediicates.add(
						criteriBuiilder.like(criteriBuiilder.upper(root.get("name").as(String.class)), "%" + "" + "%"));
			return criteriBuiilder.and(
					isTrash ? criteriBuiilder.isNotNull(root.get("deletedAt"))
							: criteriBuiilder.isNull(root.get("deletedAt")),
					criteriBuiilder.or(prediicates.toArray(Predicate[]::new)));
		}, pageable);
	}

}
