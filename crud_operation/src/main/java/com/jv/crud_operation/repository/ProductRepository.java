package com.jv.crud_operation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jv.crud_operation.model.entity.ProductEnitty;

@Repository
public interface ProductRepository extends JpaRepository<ProductEnitty,Long>{

}
