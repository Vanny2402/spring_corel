package com.jv.crud_operation.model.entity.request;

import java.io.Serializable;

import com.jv.crud_operation.model.entity.CategoryEntity;

public class CategoryRequest implements Serializable {

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	private String name;
	private String description;
	
	public CategoryEntity toEntity() {
		CategoryEntity category=new CategoryEntity();
		category.setName(this.name);
		category.setDescription(this.description);
		return category;
	}

}

