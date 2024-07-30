package com.jv.crud_operation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jv.crud_operation.model.entity.UserEntity;
import com.jv.crud_operation.model.entity.reuest.user.UserEntityRequuest;
import com.jv.crud_operation.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	private final UserService userService;

	@Autowired
	public AuthController(UserService userService) {
		this.userService = userService;
	}

	
	@PostMapping("/register")
	public ResponseEntity<UserEntity> register(@RequestBody UserEntityRequuest request) throws Exception{
		
		UserEntity user= userService.rgister(request);
		
		return ResponseEntity.ok(user);
	}
}
