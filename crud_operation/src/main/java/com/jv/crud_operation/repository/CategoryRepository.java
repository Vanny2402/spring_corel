package com.jv.crud_operation.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jv.crud_operation.model.entity.CategoryEntity;

public interface CategoryRepository extends  JpaRepository<CategoryEntity,Long>,JpaSpecificationExecutor<CategoryEntity> {
	
	boolean existsByName(String name);
	
	@Query("SELECT c FROM CategoryEntity c WHERE UPPER(c.name) LIKE UPPER(CONCAT('%', :text, '%')) OR UPPER(c.description) LIKE UPPER(CONCAT('%', :text, '%'))")
	List<CategoryEntity>findAllByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(@Param("text")String name);
	
	
	@Query(value="SELECT * FROM category",nativeQuery =true)
	List<CategoryEntity>findAllByUsingNativeQurey();
	
	@Query("SELECT c FROM CategoryEntity c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :name, '%')) ORDER BY c.name ASC")
	List<CategoryEntity>findAllByNameContainingIgnoreCaseOrderByNameAsc(@Param("name") String name);
	
	
	@Query("SELECT c FROM CategoryEntity c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :name, '%')) ORDER BY c.name DESC")
	List<CategoryEntity>findAllByNameContainingIgnoreCaseOrderByNameDesc(@Param("name") String name);
	
	
	@Query("SELECT c FROM CategoryEntity c ORDER BY c.name ASC")
	List<CategoryEntity> findAllOrderByNameAsc();

	
	@Query("SELECT c FROM CategoryEntity c ORDER BY c.name DESC")
	List<CategoryEntity> findAllOrderByNameDesc();
	
	
	@Query(value="SELECT * FROM category_entity c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :name, '%')) ORDER BY c.name ASC",nativeQuery=true)
	List<CategoryEntity>findAllByNameContainingIgnoreCaseOrderByNameAscNativQuery(@Param("name") String name);
	
	
	@Query(value="SELECT * FROM category_entity c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :name, '%')) ORDER BY c.name DESC",nativeQuery=true)
	List<CategoryEntity>findAllByNameContainingIgnoreCaseOrderByNameDescNativQuery(@Param("name") String name);
	
	
	@Query(value="SELECT*FROM category ORDER BY name ASC",nativeQuery =true)
	List<CategoryEntity> findAllOrderByNameAscNativeQuery();

	
	@Query(value="SELECT*FROM category ORDER BY name DESC",nativeQuery =true)
	List<CategoryEntity> findAllOrderByNameDescNativeQuery();
	
	
//	@Query("SELECT c FROM CategoryEntity c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :name, '%'))")
	List<CategoryEntity>findAllCategoriesByNameContainingIgnoreCase(String name,Sort sort);
		
	Page<CategoryEntity> findAllCategoriesByNameContainingIgnoreCase(Pageable pageable,String q);
	
//	Page<CategoryEntity>finAll(Specification<CategoryEntity> spec,Pageable pgeable);
	
	
	
	
	
	
	
	
	
	
}