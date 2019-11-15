package com.cyj.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cyj.springboot.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

}
