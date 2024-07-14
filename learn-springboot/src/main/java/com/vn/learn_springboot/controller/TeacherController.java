package com.vn.learn_springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("Teacher")
@RestController
public class TeacherController {

	@GetMapping
	public String getTeacher(@RequestParam Long id,@RequestParam String name) {
		return "Teacher: " +id +" Name : "+name;
		//http://localhost:8080/Teacher?id=23&name=VANNY
	}
	
	
	@GetMapping("/t")
	public String getTeacher2(@RequestParam("id") Long teacherId,@RequestParam("name") String teacherName,@RequestParam("address") String teacherAddress) {
		return "Teacher: " +teacherId +" Name : "+teacherName+ " Address: "+teacherAddress;
		//http://localhost:8080/Teacher/t?id=23213&name=Tola&address=PP
	}
}
