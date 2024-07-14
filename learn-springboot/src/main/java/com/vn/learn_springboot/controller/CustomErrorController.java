package com.vn.learn_springboot.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomErrorController implements ErrorController{

	 @GetMapping("/error")
	public ResponseEntity<Map<String,Object>> handleErrorpage(){
		Map<String,Object> error=new HashMap<>();
		error.put("error",404);
		error.put("message", "Not Found!");
		return ResponseEntity.status(404).body(error);
	}
	
}
