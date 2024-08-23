package com.jv.crud_operation.model.entity.reuest;

import java.io.Serializable;

import com.jv.crud_operation.model.entity.CategoryEntity;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CategoryRequest implements Serializable {
	
//	@Schema(name = "nm")
//	@JsonProperty("nm")
	@Schema(requiredMode =RequiredMode.REQUIRED,example = "test",maxLength = 30)
	@NotNull(message = "this is not null")
	@Size(max = 30,min = 1,message = "this is not null")
	@NotEmpty(message = "Name is not empty!")
	private String name;
	
	@Schema(example = "testDescription",maxLength = 100,nullable = true)
	private String description;
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public CategoryEntity toEntity() {
		CategoryEntity category=new CategoryEntity();
		category.setName(this.name);
		category.setDescription(this.description);
		return category;
	}

}
