package com.cyj.springboot.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cyj.springboot.dao.TeacherRepository;
import com.cyj.springboot.entity.Teacher;
import com.cyj.springboot.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService{
	
	@Autowired
	private TeacherRepository repository;

	@Override
	public Teacher queryById(Integer id) {
		return repository.findOne(id);
	}

}
