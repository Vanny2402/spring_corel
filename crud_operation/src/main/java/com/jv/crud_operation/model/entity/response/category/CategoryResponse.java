package com.jv.crud_operation.model.entity.response.category;

import com.jv.crud_operation.model.entity.CategoryEntity;
import com.jv.crud_operation.model.entity.response.infra.BaseResponse;

public class CategoryResponse extends BaseResponse {

	private String name;
	private String description;
	
	public String getDescription() {
		return description;
	}
	public String getName() {
		return name;
	}
	
	
	public CategoryResponse(String name, String description) {
		this.name=name;
		this.description=description;
	}
	
	public static CategoryResponse fromEntity(CategoryEntity entity) {
		return new CategoryResponse(entity.getName(),entity.getDescription());
	}

	
}
