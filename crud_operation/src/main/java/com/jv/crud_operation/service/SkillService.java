package com.jv.crud_operation.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.jv.crud_operation.exception.AlreadyExistException;
import com.jv.crud_operation.exception.BadRequestException;
import com.jv.crud_operation.exception.NotFoundException;
import com.jv.crud_operation.model.entity.SkillEntity;
import com.jv.crud_operation.model.entity.response.category.RestoreSkillRequest;
import com.jv.crud_operation.model.entity.reuest.RestoerCategoryRequest;
import com.jv.crud_operation.model.entity.reuest.skill.Skillrequest;
import com.jv.crud_operation.repository.SkillRepository;

import jakarta.persistence.criteria.Predicate;

@Service
public class SkillService {

	private final SkillRepository skillRepository;

	public SkillService(SkillRepository categoryRepository) {
		this.skillRepository = categoryRepository;
	}

	public SkillEntity create(Skillrequest request) throws Exception {
		// Prepare request
		SkillEntity data = request.toEntity();
		// check name from request if exist in database or not
		if (this.skillRepository.existsByName(data.getName())) {
		//throw new Exception("Category name already exist! ");
			throw new AlreadyExistException("Skill name " + request.getName() + " already exist! ");
		}
		// Save Data
		try {
			return skillRepository.save(request.toEntity());
		} catch (Exception ex) {

			throw new Exception(ex);
		}

	}

	public SkillEntity update(Long id, Skillrequest request) throws Exception {
		// #1 To find if Category exist or not
		SkillEntity dataFilter = this.findOne(id);
		if (this.skillRepository.existsByName(request.getName())) {
			throw new AlreadyExistException("Skill name: " + request.getName() + " Alredy exist!");
		} else {
			dataFilter.setName(request.getName() == null ? dataFilter.getName() : request.getName());
			dataFilter.setDescription(
					request.getDescription() == null ? dataFilter.getDescription() : request.getDescription());
		}
		return this.skillRepository.save(dataFilter);
	}

	public SkillEntity findOne(Long id) throws NotFoundException {
		return this.skillRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("This Skill is not exist"));
	}

	private SkillEntity findOneWithSoftDeleted(Long id) throws Exception {
		return this.skillRepository.findById(id).orElseThrow(() -> new NotFoundException("Skill not found!"));

	}

	public SkillEntity restore(Long id, RestoreSkillRequest request) throws Exception {
		// 1.Get category from DB by id
		SkillEntity category = this.findOneWithSoftDeleted(id);
		// 2.Check name from request if exist or not in DB
		if (this.skillRepository.existsByName(request.getName()))
			throw new AlreadyExistException("Name " + request.getName() + " already Exist!");
		// 2.remove deleted_at null value
		category.setDeletedAt(null);
		category.setName(request.getName());
		try {

			return this.skillRepository.save(category);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	public SkillEntity delete(Long id) throws Exception {
		SkillEntity skill = findOne(id);
		try {
			this.skillRepository.deleteById(id);
		} catch (Exception e) {

			throw new Exception(e);
		}
		return skill;
	}

	public Page<SkillEntity> findAll(int page, int limit, Boolean isPage, String sort, Boolean isTrash,
			Map<String, String> reqParam) {
		List<Sort.Order> lsSort = new ArrayList<>();
		for (String item : sort.split(",")) {
			String[] str = item.split(":");
			if (str.length != 2)
				throw new BadRequestException("Invalid Sort");
			String direction = str[1].toLowerCase();
			String field = str[0];
			lsSort.add(new Sort.Order(direction.equals("desc") ? Sort.Direction.DESC : Sort.Direction.ASC, field));
		}
		if (page <= 0 || limit <= 0)
			throw new BadRequestException("Invalid Pagination!");
		Pageable pageable;
		if (isPage)
			pageable = PageRequest.of(page - 1, limit, Sort.by(lsSort));
		else
			pageable = Pageable.unpaged();

		return this.skillRepository.findAll((Specification<SkillEntity>) (root, query, criteriaBuilder) -> {
			List<Predicate> predicate = new ArrayList<>();
			for (Map.Entry<String, String> entry : reqParam.entrySet()) {
				if (entry.getKey().startsWith("q_")) {

					String qKey = entry.getKey().split("q_", 2)[1];
					String qValue = entry.getValue() == null ? "" : entry.getValue();
					predicate.add(criteriaBuilder.like(criteriaBuilder.upper(root.get(qKey).as(String.class)),
							"%" + qValue.toUpperCase() + "%"));
				}
			}
			if (predicate.size() == 0)
				predicate.add(
						criteriaBuilder.like(criteriaBuilder.upper(root.get("name").as(String.class)), "%" + "" + "%"));
			return criteriaBuilder.and(
					isTrash ? criteriaBuilder.isNotNull(root.get("deletedAt"))
							: criteriaBuilder.isNull(root.get("deletedAt")),
					criteriaBuilder.or(predicate.toArray(Predicate[]::new)));
//			return criteriaBuilder.or(predicate.toArray(Predicate[]::new));

		}, pageable);
	}

}
