package com.ashokit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokit.binding.Course;
import com.ashokit.repo.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository courserepo;
	
	@Override
	public String upsert(Course course) {
		
		courserepo.save(course);
		return "success";
	}

	@Override
	public Course getById(Integer cid) {
		
	Optional<Course> findbyid = courserepo.findById(cid);
	
	if(findbyid.isPresent()) {
		return findbyid.get();
	}
		return null;
	}

	@Override
	public List<Course> getAllCourses() {
	
		return courserepo.findAll();
	}

	@Override
	public String deleteById(Integer cid) {
		if(courserepo.existsById(cid)) {
			courserepo.deleteById(cid);
			return "delete success";
		}else {
			return "no record found";
		}
	}

}
