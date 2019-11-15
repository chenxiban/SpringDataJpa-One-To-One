package com.cyj.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cyj.springboot.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

}
