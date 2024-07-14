package com.vn.learn_springboot.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("Teacher")
@RestController
public class TeacherController {

	@GetMapping
	public String getTeacher(@RequestParam long id,@RequestParam String name) {
		return "Teacher: " +id +" Name : "+name;
		//http://localhost:8080/Teacher?id=23&name=VANNY
	}
	
	@GetMapping("/t")
	public String getTeacher2(@RequestParam(value="id",required = false) Optional<Long> teacherId,
							  @RequestParam(value ="name",defaultValue = "HengLyna",required = false) String teacherName,
							  @RequestParam("address")String teacherAddress)
							  
	{
		long getTeacherId=teacherId.orElse((long)Math.floor(Math.random()*10000));
		return "Teacher: " +getTeacherId +" Name : "+teacherName+ " Address: "+teacherAddress;
		//http://localhost:8080/Teacher/t?id=23213&name=Tola&address=PP
	}
	
	@GetMapping("/t3")
	public String getTeacher3(@RequestParam Map<String,Object> params)
							  
	{
		return "TeacherId: "+params.get("id")+" Name: "+params.get("name")+" Address: "+params.get("address");
		//http://localhost:8080/Teacher/t3?id=12&name=Vanny&address=pp
	}
	
	
	@GetMapping("/t4")
	public String getTeacher4(@RequestParam (required = false,defaultValue = "1,2,3,4,5") List<String> p)
							  
	{
		return "Itemlist: " + p;
		//http://localhost:8080/Teacher/t4?p=1,3,4,4,5,6,7,88,8
	}
}
