package com.vn.learn_springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Sample")
public class SampleController {

	@GetMapping
	public String getGreeting() {
		return "Hello marry";
	}
	
	@GetMapping({"/inside","/in"})
	public String getInsideApplicatin() {
		return "Hi This is Inside the Application";
	}
	
	@GetMapping("/Sample/outside")
	public String getOutsideApplicatin() {
		return "Hi This is outside the Application";
	}
}

