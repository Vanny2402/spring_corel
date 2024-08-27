package com.jv.crud_operation.model.entity.listener;

import java.util.logging.Logger;

import com.jv.crud_operation.model.entity.CategoryEntity;

import jakarta.persistence.PostLoad;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostRemove;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;
import jakarta.persistence.PreUpdate;

public class CategoryEntityListener {

	private final Logger log=Logger.getLogger(this.getClass().getName());
	
	@PrePersist
	public void beforeSave(CategoryEntity entity) {

		log.info("Before Category Persisted: "+" ID: "+entity.getId()+" Name: "+entity.getName() +" Description: "+entity.getDescription());
	}
	
	@PostPersist
	public void afterSave(CategoryEntity entity) {

		log.info("After Category Persisted: "+" ID: "+entity.getId()+" Name: "+entity.getName() +" Description: "+entity.getDescription());
	}
	
	
	@PreUpdate
	public void beforeUpdate(CategoryEntity entity) {

		log.info("Before Category Merged: "+" ID: "+entity.getId()+" Name: "+entity.getName() +" Description: "+entity.getDescription());
	}
	
	@PostUpdate
	public void afterUpdate(CategoryEntity entity) {

		log.info("After Category Merged: "+" ID: "+entity.getId()+" Name: "+entity.getName() +" Description: "+entity.getDescription());
	}
	
	
	@PreRemove
	public void beforeRemove(CategoryEntity entity) {

		log.info("Before Category Delete: "+" ID: "+entity.getId()+" Name: "+entity.getName() +" Description: "+entity.getDescription());
	}
	
	@PostRemove
	public void afterRemove(CategoryEntity entity) {

		log.info("After Category Delete: "+" ID: "+entity.getId()+" Name: "+entity.getName() +" Description: "+entity.getDescription());
	}
	
	@PostLoad
	public void load(CategoryEntity entity) {

		log.info("Category Load: "+" ID: "+entity.getId()+" Name: "+entity.getName() +" Description: "+entity.getDescription());
	}
	
	
}
