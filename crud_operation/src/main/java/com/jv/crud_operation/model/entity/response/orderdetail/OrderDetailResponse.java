package com.jv.crud_operation.model.entity.response.orderdetail;

import java.io.Serializable;

import com.jv.crud_operation.model.entity.OrderDetail;

public class OrderDetailResponse implements Serializable {

	private Long id;
	private String productName;
	private Long qty;
	private Double price;
	
	public OrderDetailResponse(Long id, String productName, Long qty, Double price) {
		this.id = id;
		this.productName = productName;
		this.qty = qty;
		this.price = price;
	}
	public Long getId() {
		return id;
	}

	public String getProductName() {
		return productName;
	}
	public Long getQty() {
		return qty;
	}

	public Double getPrice() {
		return price;
	}


	public static OrderDetailResponse fromEntity(OrderDetail orderDetail) {
		return new OrderDetailResponse(orderDetail.getId(),orderDetail.getProductName(), orderDetail.getQty(), orderDetail.getPrice());
	}
	
	
}
