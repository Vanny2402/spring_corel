package com.jv.crud_operation.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jv.crud_operation.exception.NotFoundException;
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
	
	@PutMapping("/{id}")
	public ResponseEntity<CategoryResponse> update(@PathVariable Long id,@RequestBody CategoryRequest request) throws NotFoundException{
		
		CategoryEntity category=this.categoryService.update(id, request);
		return ResponseEntity.ok(CategoryResponse.fromEntity(category));
	}
	
	@GetMapping("")
	public ResponseEntity<List<CategoryResponse>> getAll(){
		List<CategoryResponse> category=this.categoryService.getAll().stream().map(CategoryResponse::fromEntity).toList();
		return ResponseEntity.ok(category);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<CategoryResponse> getOne(@PathVariable Long id) throws NotFoundException{
		CategoryEntity category=this.categoryService.getOne(id);
		return ResponseEntity.ok(CategoryResponse.fromEntity(category));
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<CategoryResponse> delete(@PathVariable Long id) throws NotFoundException{
		CategoryEntity category=this.categoryService.delete(id);
		return ResponseEntity.ok(CategoryResponse.fromEntity(category));
	}
}
