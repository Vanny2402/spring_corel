package com.jv.crud_operation.model.entity.reuest.oderdetail;

import java.io.Serializable;

import com.jv.crud_operation.model.entity.OrderDetail;
import com.jv.crud_operation.model.entity.OrderEntity;

public class OderDetailRequest implements Serializable {

	private String productName;
	private Long qty;
	private Double price;
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Long getQty() {
		return qty;
	}
	public void setQty(Long qty) {
		this.qty = qty;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}


	
//	private String productName;
//	private Long qty;
//	private Double price;
//
//	public String getProductName() {
//		return productName;
//	}
//	public void setProductName(String productName) {
//		this.productName = productName;
//	}
//	public Long getQty() {
//		return qty;
//	}
//	public void setQty(Long qty) {
//		this.qty = qty;
//	}
//	public Double getPrice() {
//		return price;
//	}
//	public void setPrice(Double price) {
//		this.price = price;
//	}

//	
//	public OrderDetail toEntity() {
//		
//		OrderDetail orderDetail=new OrderDetail();
//		orderDetail.setProductName(this.productName);
//		orderDetail.setQty(this.qty);
//		orderDetail.setPrice(this.price);
//		orderDetail.setOrder(null);
//		return orderDetail;
//	}
	
}
