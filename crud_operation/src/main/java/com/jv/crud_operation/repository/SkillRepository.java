package com.jv.crud_operation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.jv.crud_operation.model.entity.SkillEntity;

public interface SkillRepository extends  JpaRepository<SkillEntity,Long>,JpaSpecificationExecutor<SkillEntity> {
	
	boolean existsByName(String name);
	
}