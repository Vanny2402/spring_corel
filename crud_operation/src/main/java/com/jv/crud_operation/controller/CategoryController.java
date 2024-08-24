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
import com.jv.crud_operation.model.entity.reuest.RestoerCategoryRequest;
import com.jv.crud_operation.service.CategoryService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Backend Category Controller", description = "Testing")
@RestController
@RequestMapping("category")
public class CategoryController {

	private final CategoryService categoryService;

	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	@Operation(summary = "Create Category!", description = "Admin craete Category", responses = {
			@ApiResponse(responseCode = "201", description = "Create Success", content = @Content(schema = @Schema(implementation = CategoryResponse.class), mediaType = "application/json")),
			@ApiResponse(responseCode = "400-500", description = "Error", content = @Content(schema = @Schema(implementation = CategoryResponse.class), mediaType = "application/json"))}
			)
	@PostMapping("")
	public ResponseEntity<BaseBodyResponse> creat(@Valid @RequestBody CategoryRequest request) throws Exception {
		CategoryEntity category = this.categoryService.create(request);
		return BaseBodyResponse.createsuccess(CategoryResponse.fromEntity(category), "Succcess Created!");
		// return ResponseEntity.ok(CategoryResponse.fromEntity(category));
	}

	@PutMapping("/{id}")
	public ResponseEntity<BaseBodyResponse> update(@PathVariable Long id, @RequestBody CategoryRequest request)
			throws Exception {
		CategoryEntity category = this.categoryService.update(id, request);
		return BaseBodyResponse.success(CategoryResponse.fromEntity(category), "Updated Success!");
	}

	
	@GetMapping("")
	public ResponseEntity<BaseBodyResponse> findAll(
			@RequestParam(name = "page", required = true,defaultValue = "1") int page,
			@RequestParam(name = "limit", required = true,defaultValue = "3") int limit,
			@RequestParam(name = "isPage", required = false, defaultValue = "true") Boolean isPage,
			@RequestParam(name = "sort", required = false, defaultValue = "id:desc") String sort,
			@RequestParam(name="isTrash",required =  false,defaultValue = "false") Boolean isTrash,
			@RequestParam Map<String, String> reqParam_serch) throws Exception {
//		List<CategoryResponse> category = this.categoryService.findAll(page, limit,Objects.equals(isPage,"true"),sort,reqParam).stream()
//				.map(CategoryResponse::fromEntity).toList();
		Page<BaseResponse> category = this.categoryService
				.findAll(page, limit,isPage, sort,isTrash, reqParam_serch).map(CategoryResponse::fromEntity);
		return BaseBodyResponse.success(category, "success");
	}

	@Operation(summary = "Hello Brother I love you !", description = "Hi Brother!", responses = {
			@ApiResponse(responseCode = "200", description = "Success Man", content = @Content(schema = @Schema(implementation = CategoryResponse.class), mediaType = "application/json")) })
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

	@Operation(summary = "Hello Brother this is function to resoter!", description = "Hi Restore!", responses = {
			@ApiResponse(responseCode = "200", description = "Success Man", content = @Content(schema = @Schema(implementation = CategoryResponse.class), mediaType = "application/json")) })
	@PutMapping("/restore/{id}")
	public ResponseEntity<BaseBodyResponse> restore(@PathVariable Long id,@Valid @RequestBody RestoerCategoryRequest req)
			throws Exception {
		CategoryEntity category = this.categoryService.restore(id,req);
		return BaseBodyResponse.success(CategoryResponse.fromEntity(category), "Restored Success!");
	}
	
	
	
	
	
}
