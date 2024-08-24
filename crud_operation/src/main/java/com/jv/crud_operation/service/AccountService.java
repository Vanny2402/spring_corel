package com.jv.crud_operation.service;

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jv.crud_operation.exception.AlreadyExistException;
import com.jv.crud_operation.exception.NotFoundException;
import com.jv.crud_operation.model.entity.AccountEntity;
import com.jv.crud_operation.model.entity.reuest.RestoerCategoryRequest;
import com.jv.crud_operation.model.entity.reuest.account.AccountRequest;
import com.jv.crud_operation.repository.AccountRepository;

@Service
@Transactional(readOnly = true)
public class AccountService {
	private final AccountRepository accountRepository;

	
	public AccountService(AccountRepository categoryRepository) {
		this.accountRepository = categoryRepository;
	}

	@Transactional
	public AccountEntity create(AccountRequest request) throws Exception {

		AccountEntity data=request.toEntity();
		if(this.accountRepository.existsByNameAndDeletedAtIsNull(data.getName()))
			throw new AlreadyExistException("Account Name "+request.getName() +" Alreaduy Exist!");
		try {
			return this.accountRepository.save(data);
		} catch (Exception e) {

			throw new Exception(e);
		}
	}

	
	public AccountEntity update(Long id, AccountRequest request) throws Exception {
		return null;
	}

	public AccountEntity findOne(Long id) throws NotFoundException {
		return null;
	}

	private AccountEntity findOneWithSoftDeleted(Long id) throws Exception {
		return this.accountRepository.findById(id).orElseThrow(()-> new NotFoundException("Category not found!"));
		
	}
	
	public AccountEntity restore(Long id,RestoerCategoryRequest request) throws Exception{
		return null;
	}
	public AccountEntity delete(Long id) throws NotFoundException {

		return null;
	}

	public Page<AccountEntity> findAll(int page, int limit, Boolean isPage, String sort,Boolean isTrash,
			Map<String, String> reqParam) {
		return null;
	}

}
