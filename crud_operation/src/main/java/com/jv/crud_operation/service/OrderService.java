package com.jv.crud_operation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jv.crud_operation.model.entity.OrderEntity;
import com.jv.crud_operation.model.entity.reuest.oder.OrderRequest;
import com.jv.crud_operation.repository.OrderRepository;

@Service
public class OrderService {

	private final OrderRepository orderRepository;
	
	@Autowired
	public OrderService(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}
	
//	@Transactional
//	public OrderEntity save(OrderRequest request) {
//		OrderEntity orderEntity=orderRepository.save(request.toEntity());
//		return orderEntity;
//		
//	}
}
