package com.jv.crud_operation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jv.crud_operation.model.entity.CategoryEntity;

public interface CategoryRepository extends  JpaRepository<CategoryEntity,Long> {
	boolean existsByName(String name);
}
