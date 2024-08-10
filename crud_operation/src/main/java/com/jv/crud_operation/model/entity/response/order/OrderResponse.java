package com.jv.crud_operation.model.entity.response.order;

import java.io.Serializable;
import java.util.List;

import com.jv.crud_operation.model.entity.OrderEntity;
import com.jv.crud_operation.model.entity.response.orderdetail.OrderDetailResponse;

public class OrderResponse implements Serializable{
	
	private Long id;
	private String customerName;
	private Double total;
	private List<OrderDetailResponse> orderDetails;
	
	public OrderResponse(Long id, String customerName, Double total, List<OrderDetailResponse> orderDetails) {
		this.id = id;
		this.customerName = customerName;
		this.total = total;
		this.orderDetails = orderDetails;
	}
	public Long getId() {
		return id;
	}
	public String getCustomerName() {
		return customerName;
	}
	public Double getTotal() {
		return total;
	}
	public List<OrderDetailResponse> getOrderDetails() {
		return orderDetails;
	}
	public static OrderResponse fromEntity(OrderEntity orderEntity) {		
		return new OrderResponse(orderEntity.getId(),orderEntity.getCustomerName(),orderEntity.getTotalPrice(),orderEntity.getOrderDetails().stream().map(OrderDetailResponse::fromEntity).toList());
	}
	

}
