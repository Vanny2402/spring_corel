package com.vn.learn_springboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vn.learn_springboot.dto.LoginDTO;
import com.vn.learn_springboot.model.request.LoginFormRequest;
import com.vn.learn_springboot.service.util.Mapper;

@RestController
@RequestMapping("/auth")
public class LoginController {

	@PostMapping(value ="/login")
//	public ResponseEntity<LoginFormResponse> login(@RequestBody LoginFormRequest loginForm) {
//		LoginFormResponse ls = new LoginFormResponse();
//		ls.setUsername(loginForm.getUserName());
//		
//		return ResponseEntity.ok(ls);
//	}
	public ResponseEntity<?> Loign(@RequestBody LoginFormRequest loginFormRequest){
		return ResponseEntity.ok(Mapper.toLoginForm(loginFormRequest));
	}
	
	
}
