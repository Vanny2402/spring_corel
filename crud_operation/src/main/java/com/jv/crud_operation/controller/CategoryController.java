package com.jv.crud_operation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jv.crud_operation.model.entity.CategoryEntity;
import com.jv.crud_operation.model.entity.request.CategoryRequest;
import com.jv.crud_operation.model.entity.response.category.CategoryResponse;
import com.jv.crud_operation.service.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
	private final CategoryService categoryService;
	
	@Autowired
	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@PostMapping("")
	public ResponseEntity<CategoryResponse>create(@RequestBody CategoryRequest request){
		
		CategoryEntity category= this.categoryService.create(request);
		
		return ResponseEntity.ok(CategoryResponse.fromEntity(category));
	}
}
