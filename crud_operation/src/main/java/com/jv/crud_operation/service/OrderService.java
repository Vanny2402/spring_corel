package com.jv.crud_operation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jv.crud_operation.exception.NotFoundException;
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
		// Casting Request to Entity
		OrderEntity order = request.toEntity();

		// Create variable to store total price and orderDetail
		Double totalPrice = 0.0;
		ArrayList<OrderDetail> orderDetail = new ArrayList<>();
		for (OderDetailRequest detail : request.getOrderDetail()) {
			totalPrice += (detail.getPrice() * detail.getQty());
			OrderDetail rd = new OrderDetail();

			rd.setProductName(detail.getProductName());
			rd.setPrice(detail.getPrice());
			rd.setQty(detail.getQty());
			rd.setOrder(order);
			orderDetail.add(rd);
		}

		// Prepare Data
		order.setTotalPrice(totalPrice);
		order.setOrderDetails(orderDetail);

		try {
			return this.orderRepository.save(order);

		} catch (Exception ex) {
	
			throw new Exception(ex);
		}
	}

	public List<OrderEntity> finAll() {
		return this.orderRepository.findAll();
	}

	public OrderEntity findOne(Long id) throws NotFoundException {

		return this.orderRepository.findById(id).orElseThrow(() -> new NotFoundException("Order is not found "));

	}

	public OrderEntity upadate(Long id, OrderRequest reg) throws Exception {
		// #1.Validate id if exist in DB or not
		OrderEntity foundOrder = this.findOne(id);

		// #2.Create veriable
		Double totalPrice = 0.00;
	    ArrayList<OrderDetail> newOrderDetails = new ArrayList<>();
		
		for (OderDetailRequest detals : reg.getOrderDetail()) {
			totalPrice += detals.getPrice() * detals.getQty();

			OrderDetail rn = new OrderDetail();
			rn.setPrice(detals.getPrice());
			rn.setQty(detals.getQty());
			rn.setProductName(detals.getProductName());
			rn.setOrder(foundOrder);
			newOrderDetails.add(rn);
		}
	    
	    //#3.Prepare Data
		foundOrder.setCustomerName(reg.getCustomerName());
		foundOrder.setTotalPrice(totalPrice);
		// #3.1. Clear the existing order details and set the new ones
	    foundOrder.getOrderDetails().clear();
	    foundOrder.getOrderDetails().addAll(newOrderDetails); 

		// #5.Save
		try {
			return this.orderRepository.save(foundOrder);
		} catch (Exception ex) {
			throw new Exception(ex);
		}

	}

}
