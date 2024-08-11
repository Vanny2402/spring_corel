package com.jv.crud_operation.controller;

import java.util.List;

import org.aspectj.weaver.ast.Literal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jv.crud_operation.exception.NotFoundException;
import com.jv.crud_operation.model.entity.OrderEntity;
import com.jv.crud_operation.model.entity.response.order.OrderResponse;
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
	public ResponseEntity<OrderResponse> save(@RequestBody OrderRequest request) throws Exception{
		OrderEntity data = this.orderService.save(request);
		return ResponseEntity.ok(OrderResponse.fromEntity(data));
	}
	
	@GetMapping()
	public ResponseEntity<List<OrderResponse>>findAll(){
		List<OrderResponse> data=this.orderService.finAll().stream().map(OrderResponse::fromEntity).toList();
		return ResponseEntity.ok(data);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<OrderResponse> findOne(@PathVariable Long id) throws NotFoundException{
		OrderEntity data=this.orderService.findOne(id);
		return ResponseEntity.ok(OrderResponse.fromEntity(data));
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<OrderResponse> update(@PathVariable Long id,@RequestBody OrderRequest request) throws Exception{
		OrderEntity data=this.orderService.update(id, request);
		return ResponseEntity.ok(OrderResponse.fromEntity(data));
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<OrderResponse> delete(@PathVariable Long id) throws Exception{
		OrderEntity data=this.orderService.delete(id);
		return ResponseEntity.ok(OrderResponse.fromEntity(data));
	}
	
}
