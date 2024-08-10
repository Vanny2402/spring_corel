package com.jv.crud_operation.model.entity.reuest.oder;

import java.io.Serializable;
import java.util.List;

import com.jv.crud_operation.model.entity.OrderDetail;
import com.jv.crud_operation.model.entity.OrderEntity;
import com.jv.crud_operation.model.entity.reuest.oderdetail.OderDetailRequest;

public class OrderRequest implements Serializable{

	private String customerName;
	private Double total;
	private List<OderDetailRequest> orderDetails;
	

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
	public List<OderDetailRequest> getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(List<OderDetailRequest> orderDetails) {
		this.orderDetails = orderDetails;
	}
	
	public OrderEntity toEntity() {
		OrderEntity orderEntity=new OrderEntity();
		orderEntity.setCustomerName(this.customerName);
		orderEntity.setTotal(this.total);
		
		List<OrderDetail>orderDetails=this.orderDetails.stream().map(OderDetailRequest::toEntity).toList();
		orderDetails.forEach(orderDetail -> orderDetail.setOrder(orderEntity));
		orderEntity.setOrderDetail(orderDetails);
		return orderEntity;
		
	}

	
}
