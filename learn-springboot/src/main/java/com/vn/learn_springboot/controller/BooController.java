package com.vn.learn_springboot.controller;

import java.util.Map;
import java.util.Optional;

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
	
	@GetMapping("/{id}/{age}/{address}")
	public String getBook(@PathVariable Map<String,String> map) {
		String id=map.get("id");
		String age=map.get("age");
		String address=map.get("address");
		return "Here is Data ID:  "+id +" Age: "+age+ " Address: "+address;
		
		
	}
	
	@GetMapping("/{id}")
	public String getBooks3(@PathVariable(value="id") Optional<Long> bookId) {
		if(bookId.isPresent()) {
			return "Book id: "+bookId.get()+" Is still present";
		}else {
			return"There is no this book";
		}
	}
}
