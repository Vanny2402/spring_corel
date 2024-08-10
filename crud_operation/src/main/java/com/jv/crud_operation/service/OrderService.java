package com.jv.crud_operation.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jv.crud_operation.model.entity.OrderDetail;
import com.jv.crud_operation.model.entity.OrderEntity;
import com.jv.crud_operation.model.entity.reuest.oder.OrderRequest;
import com.jv.crud_operation.model.entity.reuest.oderdetail.OderDetailRequest;
import com.jv.crud_operation.repository.OrderRepository;

@Service
public class OrderService {
	private final OrderRepository orderRepository;
	
	@Autowired
	public OrderService(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}
	
	@Transactional
	public OrderEntity save(OrderRequest request) throws Exception {
		//Casting Request to Entity
		OrderEntity order=request.toEntity();
		
		//Create variable to store total price and orderDetail
		Double totalPrice=0.0;
		ArrayList<OrderDetail> orderDetail=new ArrayList<>();
		for(OderDetailRequest detail: request.getOrderDetail()) {
			totalPrice+=(detail.getPrice()*detail.getQty());
			OrderDetail rd=new OrderDetail();
		
			rd.setProductName(detail.getProductName());
			rd.setPrice(detail.getPrice());
			rd.setQty(detail.getQty());
			rd.setOrder(order);
			orderDetail.add(rd);
		}

		//Prepare Data 
		order.setTotalPrice(totalPrice);
		order.setOrderDetails(orderDetail);
		
		try {
			return this.orderRepository.save(order);
			
		} catch (Exception ex) {

			throw new Exception(ex);
		}		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
