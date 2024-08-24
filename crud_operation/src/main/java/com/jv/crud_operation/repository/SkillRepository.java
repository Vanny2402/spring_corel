package com.jv.crud_operation.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jv.crud_operation.model.entity.SkillEntity;
import com.jv.crud_operation.model.entity.SkillEntity;

public interface SkillRepository extends  JpaRepository<SkillEntity,Long>,JpaSpecificationExecutor<SkillEntity> {
	
	boolean existsByName(String name);
	boolean existsByNameAndDeletedAtIsNull(String name);
	
	@Query("SELECT c FROM CategoryEntity c WHERE UPPER(c.name) LIKE UPPER(CONCAT('%', :text, '%')) OR UPPER(c.description) LIKE UPPER(CONCAT('%', :text, '%'))")
	List<SkillEntity>findAllByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(@Param("text")String name);
	
	
	@Query(value="SELECT * FROM category",nativeQuery =true)
	List<SkillEntity>findAllByUsingNativeQurey();
	
	@Query("SELECT c FROM CategoryEntity c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :name, '%')) ORDER BY c.name ASC")
	List<SkillEntity>findAllByNameContainingIgnoreCaseOrderByNameAsc(@Param("name") String name);
	
	
	@Query("SELECT c FROM CategoryEntity c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :name, '%')) ORDER BY c.name DESC")
	List<SkillEntity>findAllByNameContainingIgnoreCaseOrderByNameDesc(@Param("name") String name);
	
	
	@Query("SELECT c FROM CategoryEntity c ORDER BY c.name ASC")
	List<SkillEntity> findAllOrderByNameAsc();

	
	@Query("SELECT c FROM CategoryEntity c ORDER BY c.name DESC")
	List<SkillEntity> findAllOrderByNameDesc();
	
	
	@Query(value="SELECT * FROM category_entity c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :name, '%')) ORDER BY c.name ASC",nativeQuery=true)
	List<SkillEntity>findAllByNameContainingIgnoreCaseOrderByNameAscNativQuery(@Param("name") String name);
	
	
	@Query(value="SELECT * FROM category_entity c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :name, '%')) ORDER BY c.name DESC",nativeQuery=true)
	List<SkillEntity>findAllByNameContainingIgnoreCaseOrderByNameDescNativQuery(@Param("name") String name);
	
	
	@Query(value="SELECT*FROM category ORDER BY name ASC",nativeQuery =true)
	List<SkillEntity> findAllOrderByNameAscNativeQuery();

	
	@Query(value="SELECT*FROM category ORDER BY name DESC",nativeQuery =true)
	List<SkillEntity> findAllOrderByNameDescNativeQuery();
	
	
//	@Query("SELECT c FROM CategoryEntity c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :name, '%'))")
	List<SkillEntity>findAllCategoriesByNameContainingIgnoreCase(String name,Sort sort);
		
	Page<SkillEntity> findAllCategoriesByNameContainingIgnoreCase(Pageable pageable,String q);
	
//	Page<CategoryEntity>finAll(Specification<CategoryEntity> spec,Pageable pgeable);
	
	Optional<SkillEntity>findByIdAndDeletedAtIsNull(Long id);
	
	
	
	
	
	
	
	
}