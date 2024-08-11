package com.jv.crud_operation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

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

	@Transactional
	public OrderEntity update(Long id, OrderRequest reg) throws Exception {
	    // #1. Validate if the order exists in the database
	    OrderEntity foundOrder = this.findOne(id);
	    Double totalPrice = 0.00;
	    List<OrderDetail> existingOrderDetails = foundOrder.getOrderDetails();
	    // Create a list to track which existing details should be removed
	    List<OrderDetail> detailsToRemove = new ArrayList<>(existingOrderDetails);
	    // #2. Update or create new OrderDetail entities
	    for (OderDetailRequest detailRequest : reg.getOrderDetail()) {
	        totalPrice += detailRequest.getPrice() * detailRequest.getQty();
	        // Find an existing OrderDetail by productName (or another unique identifier)
	        OrderDetail existingDetail = existingOrderDetails.stream()
	            .filter(od -> od.getProductName().equals(detailRequest.getProductName()))
	            .findFirst().orElse(null);
	        if (existingDetail != null) {
	            // Update the existing detail
	            existingDetail.setPrice(detailRequest.getPrice());
	            existingDetail.setQty(detailRequest.getQty());
	            detailsToRemove.remove(existingDetail); // Mark this detail as not to be removed
	        } else {
	            // Create a new OrderDetail
	            OrderDetail newDetail = new OrderDetail();
	            newDetail.setProductName(detailRequest.getProductName());
	            newDetail.setPrice(detailRequest.getPrice());
	            newDetail.setQty(detailRequest.getQty());
	            newDetail.setOrder(foundOrder);
	            existingOrderDetails.add(newDetail); 
	        }
	    }

	    // #3. Remove details that are no longer in the request
	    existingOrderDetails.removeAll(detailsToRemove);

	    // #4. Update the order details and other fields
	    foundOrder.setCustomerName(reg.getCustomerName());
	    foundOrder.setTotalPrice(totalPrice);

	    try {
	        return this.orderRepository.save(foundOrder);
	    } catch (Exception ex) {
	        throw new Exception("Failed to update order: " + ex.getMessage(), ex);
	    }
	}
	
	
	public OrderEntity delete(Long id) throws Exception {
		OrderEntity foundOrder=this.findOne(id);
		
		try {
			this.orderRepository.deleteById(id);
			return foundOrder;
		} catch (Exception e) {
			throw new Exception(e);
		}
	}


}
