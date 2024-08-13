package com.jv.crud_operation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jv.crud_operation.model.entity.CategoryEntity;

public interface CategoryRepository extends  JpaRepository<CategoryEntity,Long> {
	
	boolean existsByName(String name);
	
	@Query("select c from CategoryEntity c where upper(c.name) like upper(concat('%',?1,'%'))")
	List<CategoryEntity>findAllByNameContainingIgnoreCase(String name); 
}