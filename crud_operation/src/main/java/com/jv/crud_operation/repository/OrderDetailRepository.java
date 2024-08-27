package com.jv.crud_operation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jv.crud_operation.model.entity.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail,Long> {

}
