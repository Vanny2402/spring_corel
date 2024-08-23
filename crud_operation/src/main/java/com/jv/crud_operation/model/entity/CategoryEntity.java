package com.jv.crud_operation.model.entity;

import com.jv.crud_operation.model.entity.listener.CategoryEntityListener;
import com.jv.crud_operation.model.entity.response.infra.BaseAuditEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Table;

@Entity
@Table(name="category")
@EntityListeners(CategoryEntityListener.class)
public class CategoryEntity extends BaseAuditEntity<Long> {

	
	@Column(nullable = false,unique = true)
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
