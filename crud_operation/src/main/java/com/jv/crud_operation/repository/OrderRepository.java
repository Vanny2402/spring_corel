package com.jv.crud_operation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jv.crud_operation.model.entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long>{

}
