package com.jv.crud_operation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jv.crud_operation.model.entity.TagEntity;

@Repository
public interface TagRepository extends JpaRepository<TagEntity, Long> {
	boolean existsByTagName(String TagName);
	
}