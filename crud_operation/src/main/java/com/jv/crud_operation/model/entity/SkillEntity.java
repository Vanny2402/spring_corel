package com.jv.crud_operation.model.entity;

import org.hibernate.annotations.SQLDelete;

import com.jv.crud_operation.model.entity.response.infra.BaseSoftDeleteEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="skills")
@SQLDelete(sql="Update skills SET deleted_at = NOW() where id=?")
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
