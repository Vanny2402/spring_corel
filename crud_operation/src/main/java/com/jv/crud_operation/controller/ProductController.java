package com.jv.crud_operation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jv.crud_operation.model.entity.ProductEnitty;
import com.jv.crud_operation.model.entity.response.product.ProductResponse;
import com.jv.crud_operation.model.entity.reuest.product.ProductRequest;
import com.jv.crud_operation.service.ProductService;

@RestController
@RequestMapping("product")
public class ProductController {

	private final ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	
	@PostMapping()
	public ResponseEntity<ProductResponse> saveproduct(@RequestBody ProductRequest request) throws Exception{
		ProductEnitty product = this.productService.saveProduct(request);
		return ResponseEntity.ok(ProductResponse.fromEntity(product));
	}
}
	