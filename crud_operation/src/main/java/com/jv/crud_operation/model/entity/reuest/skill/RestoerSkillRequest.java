package com.jv.crud_operation.model.entity.reuest.skill;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class RestoerSkillRequest {
	@Schema(requiredMode =RequiredMode.REQUIRED,example = "test",maxLength = 30)
	@NotNull(message = "this is not null")
	@Size(max = 30,min = 1,message = "this is not null")
	@NotEmpty(message = "Name is not empty!")
	private String name;
	

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}


}
