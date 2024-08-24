package com.jv.crud_operation.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.jv.crud_operation.model.entity.SkillEntity;

public interface SkillRepository extends  JpaRepository<SkillEntity,Long>,JpaSpecificationExecutor<SkillEntity> {
	
	boolean existsByNameAndDeletedAtIsNull(String name);
	Optional<SkillEntity>findByIdAndDeletedAtIsNull(Long id);
	
}