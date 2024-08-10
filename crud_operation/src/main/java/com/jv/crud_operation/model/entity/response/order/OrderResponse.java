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
	public void setId(Long id) {
		this.id = id;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public List<OrderDetailResponse> getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(List<OrderDetailResponse> orderDetails) {
		this.orderDetails = orderDetails;
	}

	
//	public static OrderResponse fromEntity(OrderEntity orderEntity) {
//		List<OrderDetailResponse> orderDetailResponse=orderEntity.getOrderDetail().stream().map(OrderDetailResponse::fromEntity).toList();
//		
//		return new OrderResponse(orderEntity.getId(), orderEntity.getCustomerName(),orderEntity.getTotal(),orderDetailResponse);
//	}
	

}
