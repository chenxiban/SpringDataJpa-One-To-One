package com.ysd.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ysd.springboot.entity.Teacher;
import com.ysd.springboot.service.TeacherService;

@SpringBootTest		//提供Spring测试环境
@RunWith(SpringRunner.class)	//Spring集成Junit单元测试
public class TeacherServiceTest {
	
	@Autowired
	private TeacherService service;
	
	@Test
	public void queryById() {
		Teacher teacher = service.queryById(1);
		System.err.println("TeacherServiceTest queryById 查询出的 teacher对象 =>"+teacher.showTeacherAndCourse());
	}

}
