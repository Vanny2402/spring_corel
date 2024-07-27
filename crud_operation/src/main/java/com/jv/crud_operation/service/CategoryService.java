package com.jv.crud_operation.service;

import org.springframework.stereotype.Service;

import com.jv.crud_operation.model.entity.CategoryEntity;
import com.jv.crud_operation.model.entity.reuest.CategoryRequest;
import com.jv.crud_operation.repository.CategoryRepository;

@Service
public class CategoryService {

	private final CategoryRepository categoryRepository;
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	public CategoryEntity create(CategoryRequest request) throws Exception {
		
		//Prepare request
		CategoryEntity data=request.toEntity();
		
		//check name from reuest if exist in db or not 
		
		if(this.categoryRepository.existsByName(data.getName())) {
			throw new Exception("Category name already exist! ");
		}
		return categoryRepository.save(request.toEntity());
	}
}
