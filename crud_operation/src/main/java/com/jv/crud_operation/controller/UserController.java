package com.jv.crud_operation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jv.crud_operation.exception.BadRequestException;
import com.jv.crud_operation.exception.NotFoundException;
import com.jv.crud_operation.model.entity.UserEntity;
import com.jv.crud_operation.model.entity.response.user.UserLoginResponse;
import com.jv.crud_operation.model.entity.response.user.UserRegisterResponse;
import com.jv.crud_operation.model.entity.reuest.user.UserEntityRequuest;
import com.jv.crud_operation.model.entity.reuest.user.UserLoginRequest;
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

	@PostMapping("/login")
	public ResponseEntity<UserLoginResponse>login(@RequestBody UserLoginRequest request) throws BadRequestException{
		UserEntity data=this.userService.login(request);
		return ResponseEntity.ok(UserLoginResponse.fromEntity(data));
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UserRegisterResponse> update(@PathVariable Long id,@RequestBody UserEntityRequuest request) throws Exception{
		
		UserEntity data =userService.update(id, request);
		UserRegisterResponse response = UserRegisterResponse.fromEntity(data);
		return ResponseEntity.ok(response);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String,Object>> delete(@PathVariable Long id) throws Exception{
		Map<String,Object> response=new HashMap<>();
		response.put("Messageg", "Delete Success");
		this.userService.delete(id);
		return ResponseEntity.ok(response);
		
	}
}