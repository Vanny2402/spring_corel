package com.jv.crud_operation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jv.crud_operation.model.entity.OrderEntity;
import com.jv.crud_operation.model.entity.response.order.OrderResponse;
import com.jv.crud_operation.model.entity.reuest.oder.OrderRequest;
import com.jv.crud_operation.service.OrderService;

@RestController
@RequestMapping("order")
public class OrderContrller {
	private final OrderService orderService;

	public OrderContrller(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@PostMapping()
	public ResponseEntity<OrderResponse> save(@RequestBody OrderRequest request){
		OrderEntity data=orderService.save(request);
		return ResponseEntity.ok(OrderResponse.fromEntity(data));
	}
	
}
