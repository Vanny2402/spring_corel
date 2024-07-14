package com.vn.learn_springboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RequestMapping("Student")
@RestController
public class StudentController {

	@RequestMapping(value = "/{id}", method = RequestMethod.GET,headers = "key=val") // Required to have header running on Posmand 
	public ResponseEntity<?> getStudent(@PathVariable("id") Long StudentId,HttpServletRequest request){
		
		System.out.print("Hello token: "+request.getHeader("hello"));// Required to insert param in herader os Posman
		return ResponseEntity.ok("Student Id: "+StudentId);
	}
}
