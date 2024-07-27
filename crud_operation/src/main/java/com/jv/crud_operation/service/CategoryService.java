package com.jv.crud_operation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jv.crud_operation.model.entity.CategoryEntity;
import com.jv.crud_operation.model.entity.request.CategoryRequest;
import com.jv.crud_operation.repository.CategoryRepository;

@Service
public class CategoryService {
	
	private final CategoryRepository categoryRepository;
	
	@Autowired
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	public CategoryEntity create(CategoryRequest request) {
		return this.categoryRepository.save(request.toEntity());
	}
}
