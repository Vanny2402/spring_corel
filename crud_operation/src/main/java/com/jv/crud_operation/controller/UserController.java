package com.jv.crud_operation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jv.crud_operation.model.entity.UserEntity;
import com.jv.crud_operation.model.entity.reuest.user.UserRequest;
import com.jv.crud_operation.service.UserService;

@RestController
@RequestMapping("/auth")
public class UserController {
	
	private final UserService userService;
	public UserController(UserService userService) {
		this.userService = userService;
	}

	
	@PostMapping("/register")
	public ResponseEntity<UserEntity> register(@RequestBody UserRequest request){
	
		UserEntity u=userService.register(request);
		return ResponseEntity.ok(u);
	}
	
}
