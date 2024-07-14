package com.vn.learn_springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Book")
public class BooController {

	@GetMapping("/one/{id}")
	public String getBook(@PathVariable("id") Long ids) {
		return "Book : " +ids;
	}
	
	
	@GetMapping("/{id}/{age}")
	public String getBooks(@PathVariable Long id, @PathVariable String age) {
		return "Hello Id: "+id+"age: "+age;
		
		
	}
}
