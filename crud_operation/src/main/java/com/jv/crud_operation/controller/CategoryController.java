package com.jv.crud_operation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jv.crud_operation.model.entity.CategoryEntity;
import com.jv.crud_operation.model.entity.response.category.CategoryResponse;
import com.jv.crud_operation.model.entity.reuest.CategoryRequest;
import com.jv.crud_operation.service.CategoryService;

@RestController
@RequestMapping("category")
public class CategoryController {

	private final CategoryService categoryService;

	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@PostMapping("")
	public ResponseEntity<CategoryResponse>creat(@RequestBody CategoryRequest request) throws Exception{
		CategoryEntity category=this.categoryService.create(request);
		return ResponseEntity.ok(CategoryResponse.fromEntity(category));
	}
}
