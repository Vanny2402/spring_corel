package com.jv.crud_operation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jv.crud_operation.model.entity.OrderEntity;
import com.jv.crud_operation.model.entity.reuest.oder.OrderRequest;
import com.jv.crud_operation.service.OrderService;

@RestController
@RequestMapping("order")
public class OrderContrller {
	private final OrderService orderService;

	@Autowired
	public OrderContrller(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@PostMapping()
	public ResponseEntity<Object> save(@RequestBody OrderRequest request) throws Exception{
		OrderEntity data = this.orderService.save(request);
		return ResponseEntity.ok(null);
	}
	
}
