package com.ashokit.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.binding.Course;
import com.ashokit.service.CourseService;

@RestController
public class CourseRestController {

	@Autowired
	private CourseService courseservice ;
	
	@PostMapping("/course")
	private ResponseEntity<String> createcourse(@RequestBody Course course){
		String status = courseservice.upsert(course);
		return new ResponseEntity<>(status, HttpStatus.CREATED);
	}
	
	@GetMapping("/course/{cid}")
	private ResponseEntity<Course> getcourse(@PathVariable Integer cid){
		Course course = courseservice.getById(cid);
		return new ResponseEntity<>(course,HttpStatus.OK);
	}
	@GetMapping("/courses")
	private ResponseEntity<List<Course>> getallcourses(){
		 List<Course>  allcourses =   courseservice.getAllCourses();
		 return new ResponseEntity<>(allcourses, HttpStatus.OK);
	}
	@PutMapping("/course")
	private ResponseEntity<String> updatecourse(@RequestBody Course course){
		String status = courseservice.upsert(course);
		return new ResponseEntity<>(status, HttpStatus.OK);
	}
	@DeleteMapping("/course/{cid}")
	private ResponseEntity<String> deletecourse(@PathVariable Integer cid){
		String status = courseservice.deleteById(cid);
		return new ResponseEntity<> (status ,HttpStatus.OK);
	}
}
