package com.jv.crud_operation.model.entity.response.skill;

import com.jv.crud_operation.model.entity.SkillEntity;
import com.jv.crud_operation.model.entity.response.infra.BaseResponse;

public class SkillResponse extends BaseResponse {

	private String name;
	private String description;
	
	public String getDescription() {
		return description;
	}
	public String getName() {
		return name;
	}
	
	public SkillResponse(String name, String description) {
		this.name=name;
		this.description=description;
	}
	
	public static SkillResponse fromEntity(SkillEntity entity) {
		return new SkillResponse(entity.getName(),entity.getDescription());
	}

	
}
