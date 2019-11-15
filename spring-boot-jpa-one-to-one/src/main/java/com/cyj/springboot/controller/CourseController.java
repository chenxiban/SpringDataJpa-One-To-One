package com.cyj.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cyj.springboot.entity.Course;
import com.cyj.springboot.service.CourseService;

/**
 * SpringMVC控制器
 * 
 * @Description: 子模块
 * @author ChenYongJia
 * @Date 2017-10-4 下午8:04:34
 * @Email 867647213@qq.com
 */

@RestController
@RequestMapping("/course")
public class CourseController {

	@Autowired
	private CourseService service;

	/**
	 * http://localhost:8080/course/queryById?id=1
	 * 
	 * @param id
	 * @return User
	 */
	@RequestMapping("/queryById")
	public Course queryById(Integer id) {
		Course course = service.queryById(id);
		course.setCourseParam();
		System.out.println("queryById user=>" + course.showCourseAndTeacher());
		return course;
	}

}
