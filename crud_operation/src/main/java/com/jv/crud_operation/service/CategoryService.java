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
import com.jv.crud_operation.model.entity.CategoryEntity;
import com.jv.crud_operation.model.entity.reuest.CategoryRequest;
import com.jv.crud_operation.repository.CategoryRepository;

import jakarta.persistence.criteria.Predicate;

@Service
public class CategoryService {

	private final CategoryRepository categoryRepository;

	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	public CategoryEntity create(CategoryRequest request) throws Exception {
		// Prepare request
		CategoryEntity data = request.toEntity();
		// check name from request if exist in database or not
		if (this.categoryRepository.existsByNameAndDeletedAtIsNull(data.getName())) {
//			throw new Exception("Category name already exist! ");
			throw new AlreadyExistException("Category name "+request.getName()+" already exist! ");
		}

		// Save Data
		try {
			return categoryRepository.save(request.toEntity());
		} catch (Exception ex) {

			throw new Exception(ex);
		}

	}

	public CategoryEntity update(Long id, CategoryRequest request) throws Exception {
		// #1 To find if Category exist or not
		CategoryEntity dataFilter =this.findOne(id);
		if(this.categoryRepository.existsByNameAndDeletedAtIsNull(request.getName())) {
			throw new AlreadyExistException("Category name: "+request.getName() + " Alredy exist!");
		}else {
			dataFilter.setName(request.getName() == null ? dataFilter.getName() : request. getName());
			dataFilter.setDescription(
					request.getDescription() == null ? dataFilter.getDescription() : request.getDescription());
		}
		return this.categoryRepository.save(dataFilter);
	}

	public CategoryEntity findOne(Long id) throws NotFoundException {
		return this.categoryRepository.findByIdAndDeletedAtIsNull(id)
				.orElseThrow(() -> new NotFoundException("This is category is not exist"));
	}

	public CategoryEntity delete(Long id) throws NotFoundException {
		// #1 To find Category
		CategoryEntity category = findOne(id);
//		this.categoryRepository.deleteById(category.getId());
		category.setDeletedAt(new Date());
		this.categoryRepository.save(category);
		return category;
	}

	public Page<CategoryEntity> findAll(int page, int limit, Boolean isPage, String sort,
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

		return this.categoryRepository.findAll((Specification<CategoryEntity>) (root, query, criteriaBuilder) -> {
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
			return criteriaBuilder.and(criteriaBuilder.isNull(root.get("deletedAt")),
					criteriaBuilder.or(predicate.toArray(Predicate[]::new)));
//			return criteriaBuilder.or(predicate.toArray(Predicate[]::new));

		}, pageable);
	}

}
