package com.cyj.springboot.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cyj.springboot.dao.CourseRepository;
import com.cyj.springboot.entity.Course;
import com.cyj.springboot.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository repository;

	@Override
	public Course queryById(Integer id) {
		return repository.findOne(id);
	}

}
