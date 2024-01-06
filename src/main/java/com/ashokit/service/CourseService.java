package com.ashokit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ashokit.binding.Course;
@Service
public interface CourseService {

	public String upsert(Course course);
	
	public Course getById(Integer cid);
	
	public List<Course> getAllCourses();
	
	public String deleteById(Integer cid);
}
