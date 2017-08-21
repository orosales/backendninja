package com.udemy.backendninja.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.udemy.backendninja.entity.Course;
import com.udemy.backendninja.repository.CourseJpaRepository;
import com.udemy.backendninja.service.CourseService;

public class CourseServiceImpl implements CourseService{

	@Autowired
	@Qualifier("courseJpaRepository")
	CourseJpaRepository courseJpaRepository;
	
	@Override
	public List<Course> listAllCourses() {
		// TODO Auto-generated method stub
		return courseJpaRepository.findAll();
		
	}

	@Override
	public Course addCourse(Course course) {
		// TODO Auto-generated method stub
		return courseJpaRepository.save(course);
	}

	@Override
	public int removeCourse(int id) {
		// TODO Auto-generated method stub
		courseJpaRepository.delete(id);
		return 0;
	}

	@Override
	public Course updateCourse(Course course) {
		// TODO Auto-generated method stub
		return courseJpaRepository.save(course);
	}

}
