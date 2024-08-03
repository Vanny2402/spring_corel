package com.jv.crud_operation.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jv.crud_operation.exception.NotFoundException;
import com.jv.crud_operation.model.entity.UserEntity;
import com.jv.crud_operation.model.entity.response.user.UserRegisterResponse;
import com.jv.crud_operation.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	
	@GetMapping
	public ResponseEntity<List<UserRegisterResponse>>findAll(){
		
		List<UserRegisterResponse> data=userService.findAll().stream().map(UserRegisterResponse::fromEntity).toList();
		return ResponseEntity.ok(data);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserRegisterResponse>findOne(@PathVariable Long id) throws NotFoundException{
		UserEntity data = this.userService.findOne(id);
		
		return ResponseEntity.ok(UserRegisterResponse.fromEntity(data));
	} 
}
