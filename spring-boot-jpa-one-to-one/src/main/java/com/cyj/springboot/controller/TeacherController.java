package com.cyj.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cyj.springboot.entity.Teacher;
import com.cyj.springboot.service.TeacherService;

/**
 * SpringMVC控制器
 * @Description:   子模块
 * @author         ChenYongJia 
 * @Date           2017-10-4 下午8:04:34  
 * @Email          867647213@qq.com
 */
@RestController
@RequestMapping("/teacher")
public class TeacherController {
	
	
	@Autowired	
	private TeacherService service;
	
	
	
	/**
	 * http://localhost:8080/teacher/queryById?id=1
	 * @param id
	 * @return User
	 */
	@RequestMapping("/queryById")
	public Teacher queryById(Integer id) {
		Teacher teacher = service.queryById(id);
		teacher.setTeacherParam();
		System.out.println("queryById teacher=>"+teacher.showTeacherAndCourse());
		return teacher;
	}
	
	
	
	
	
	

}
