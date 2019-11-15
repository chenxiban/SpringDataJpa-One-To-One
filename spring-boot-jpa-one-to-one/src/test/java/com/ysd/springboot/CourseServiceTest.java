package com.ysd.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ysd.springboot.entity.Course;
import com.ysd.springboot.service.CourseService;

@SpringBootTest		//提供Spring测试环境
@RunWith(SpringRunner.class)	//Spring集成Junit单元测试
public class CourseServiceTest {
	
	
	@Autowired
	private CourseService service;
	
	
	@Test
	public void queryById() {
		Course course = service.queryById(1);
		System.err.println("CourseServiceTest queryById 查询出的 course对象 =>"+course.showCourseAndTeacher());
	}

}
