package com.jv.crud_operation.model.entity.reuest.oder;

import java.io.Serializable;
import java.util.List;

import com.jv.crud_operation.model.entity.OrderEntity;
import com.jv.crud_operation.model.entity.reuest.oderdetail.OderDetailRequest;

public class OrderRequest implements Serializable{
	
	private String customerName;
	private List<OderDetailRequest> orderDetail;

	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public List<OderDetailRequest> getOrderDetail() {
		return orderDetail;
	}
	public void setOrderDetail(List<OderDetailRequest> orderDetail) {
		this.orderDetail = orderDetail;
	}

	
	public OrderEntity toEntity() {
		
		OrderEntity order=new OrderEntity();
		order.setCustomerName(this.customerName);		
		return order;
		
	}
	


	
}
