package com.jv.crud_operation.controller;

import java.util.Map;
import java.util.Objects;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jv.crud_operation.exception.NotFoundException;
import com.jv.crud_operation.model.entity.CategoryEntity;
import com.jv.crud_operation.model.entity.response.category.CategoryResponse;
import com.jv.crud_operation.model.entity.response.infra.BaseBodyResponse;
import com.jv.crud_operation.model.entity.response.infra.BaseResponse;
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
	public ResponseEntity<BaseBodyResponse> creat(@RequestBody CategoryRequest request) throws Exception {
		CategoryEntity category = this.categoryService.create(request);
		return BaseBodyResponse.success(CategoryResponse.fromEntity(category),"Succcess Created!");
		//		return ResponseEntity.ok(CategoryResponse.fromEntity(category));
	}

	@PutMapping("/{id}")
	public ResponseEntity<BaseBodyResponse> update(@PathVariable Long id, @RequestBody CategoryRequest request)
			throws NotFoundException {
		CategoryEntity category = this.categoryService.update(id, request);
		return BaseBodyResponse.success(CategoryResponse.fromEntity(category), "Updated Success!");
	}

	@GetMapping("")
	public ResponseEntity<BaseBodyResponse> findAll(
			@RequestParam(name = "q", required = false) String q,
			@RequestParam(name = "page", required = true) int page,
			@RequestParam(name = "limit", required = true) int limit,
			@RequestParam(name="isPage",required = false,defaultValue ="true") String isPage,
			@RequestParam(name="sort",required = false,defaultValue = "id:desc") String sort,
			@RequestParam Map<String,String> reqParam ) throws Exception{
//		List<CategoryResponse> category = this.categoryService.findAll(page, limit,Objects.equals(isPage,"true"),sort,reqParam).stream()
//				.map(CategoryResponse::fromEntity).toList();
		Page<BaseResponse>category=this.categoryService.findAll(page, limit, Objects.equals(isPage,"true"), sort, reqParam).map(CategoryResponse::fromEntity);
		return BaseBodyResponse.success(category, "success");
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CategoryResponse> findOne(@PathVariable Long id) throws NotFoundException {
		CategoryEntity category = this.categoryService.findOne(id);
		return ResponseEntity.ok(CategoryResponse.fromEntity(category));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<CategoryResponse> delete(@PathVariable Long id) throws NotFoundException {
		CategoryEntity category = categoryService.delete(id);
		return ResponseEntity.ok(CategoryResponse.fromEntity(category));
	}

}

