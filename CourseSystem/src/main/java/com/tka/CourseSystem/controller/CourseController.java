package com.tka.CourseSystem.controller;

import java.util.List;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tka.CourseSystem.entity.Course;
import com.tka.CourseSystem.service.CourseService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CourseController {
	
	@Autowired
	CourseService service;
	
	@PostMapping("/addcourse")
	public String AddCourseData(@RequestBody Course c) {
		
	String msg=	service.AddCourseData(c);
		
		return msg;
	}

	
	@PutMapping("/updatecourse/{id}")
	public String UpdateCourse(@PathVariable int id, @RequestBody Course c) {
		
	String msg=	service.UpdateCourse(id,c);
		return msg;
		
		
		
	}
	
	@DeleteMapping("/deletecourse/{id}")
	public String DeleteCourse(@PathVariable int id) {
		String msg=service.DeleteCourse(id);
		return msg;
	}
	
	
	@GetMapping("/getAllcourses")
	public List<Course> getAllData(){
		List<Course> list=service.getAllData();
		return list;
		
	}
	
	@GetMapping("/getcoursebyid/{id}")
    public Course getperticularcourseById(@PathVariable int id) {
  	  Course c=service. getperticularcourseById(id);
  	  return c;
    }
	
}
