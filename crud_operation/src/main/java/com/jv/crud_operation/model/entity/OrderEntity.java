package com.jv.crud_operation.model.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="orders")
public class OrderEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="customerName",length = 30)
	private String customerName;
	
	@Column(nullable = false)
	private Double totalPrice;
	
	@OneToMany(mappedBy = "order",fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
	private List<OrderDetail> orderDetails;
	
	
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

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}


	
	
	
	
	
	
	
	
	
//	public Double getTotal() {
//		return total;
//	}
//
//	@Column(name="toal")
//	private Double total;
//	
//	@Column(name="orderdetail_id")
//	@OneToMany(mappedBy = "order",cascade =CascadeType.ALL,orphanRemoval = true)
//	private List<OrderDetail> orderDetail;
//	
//	public List<OrderDetail> getOrderDetail() {
//		return orderDetail;
//	}
//
//	public void setOrderDetail(List<OrderDetail> orderDetail) {
//		this.orderDetail = orderDetail;
//	}
//
//	public void setTotal(Double total) {
//		this.total = total;
//	}
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getCustomerName() {
//		return customerName;
//	}
//
//	public void setCustomerName(String customerName) {
//		this.customerName = customerName;
//	}
//


}
