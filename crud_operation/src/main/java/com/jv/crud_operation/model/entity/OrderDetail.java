package com.jv.crud_operation.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="order_details")
public class OrderDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 50,nullable = false)
	private String productName;
	
	@Column(nullable = false)
	private Long qty;
	
	@Column(nullable = false)
	private Double price;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="orderId",nullable = false,referencedColumnName = "id")
	private OrderEntity order;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
	
	public OrderEntity getOrder() {
		return order;
	}

	public void setOrder(OrderEntity order) {
		this.order = order;
	}




	

	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
//	@Column(name="productName",nullable = false)
//	private String productName;
//	@Column(name="qty",nullable = false)
//	private Long qty;
//	@Column(name="price",nullable = false)
//	private Double price;
//	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name="order_id")
//	private OrderEntity order;
//	
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getProductName() {
//		return productName;
//	}
//
//	public void setProductName(String productName) {
//		this.productName = productName;
//	}
//
//	public Long getQty() {
//		return qty;
//	}
//
//	public void setQty(Long qty) {
//		this.qty = qty;
//	}
//
//	public Double getPrice() {
//		return price;
//	}
//
//	public void setPrice(Double price) {
//		this.price = price;
//	}
//
//	public OrderEntity getOrder() {
//		return order;
//	}
//
//	public void setOrder(OrderEntity order) {
//		this.order = order;
//	}


	
	
}
