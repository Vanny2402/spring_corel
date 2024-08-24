package com.jv.crud_operation.model.entity;

import com.jv.crud_operation.model.entity.listener.CategoryEntityListener;
import com.jv.crud_operation.model.entity.response.infra.BaseSoftDeleteEntity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Table;

@Table(name="skills")
@EntityListeners(CategoryEntityListener.class)
public class SkillEntity extends BaseSoftDeleteEntity<Long> {

	
	@Column(nullable = false)
	private String name;
	
	@Column(length =  100)
	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
