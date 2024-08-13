package com.jv.crud_operation.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jv.crud_operation.exception.NotFoundException;
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
	
	@GetMapping()
	public ResponseEntity<List<ProductResponse>>findAll(){ 
		List<ProductResponse> product=this.productService.findAll().stream().map(ProductResponse::fromEntity).toList();
		return ResponseEntity.ok(product);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductResponse> findOne(@PathVariable Long id) throws Exception{
		ProductEnitty product=this.productService.finOne(id);
	return ResponseEntity.ok(ProductResponse.fromEntity(product));
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<ProductResponse>updateItem(@PathVariable Long id,@RequestBody ProductRequest request) throws Exception{
		ProductEnitty data=this.productService.update(id, request);
		return ResponseEntity.ok(ProductResponse.fromEntity(data));
	}
	
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<HashMap>deleteItem(@PathVariable Long id) throws NotFoundException{

		HashMap<String,Object> message =new HashMap<>();
		message.put("Msg","Prduct successfully deleted!");
		this.productService.delete(id);
		return ResponseEntity.ok(message);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
}
	