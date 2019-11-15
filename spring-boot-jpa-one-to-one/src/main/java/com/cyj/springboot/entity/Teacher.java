package com.cyj.springboot.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "teachertb")
public class Teacher implements Serializable {

	@Id // 实体类的主键
	@GeneratedValue // 自动增长列
	@OrderBy // 数据加载顺序
	@Column(columnDefinition = "int unsigned NOT NULL comment '备注:教师自动增长主键'  ")
	private Integer teacherId;
	@Column(length = 20) // 字符长度20
	private String teacherName;
	@Column(columnDefinition = "char(1) comment '备注:教师姓名' ")
	private String teacherSex;
	@Column(columnDefinition = "int unsigned DEFAULT 0 comment '备注:教师年龄'  ")
	private Integer teacherAge;

	private Date teacherBirthday;
//	@CreationTimestamp@UpdateTimestamp	//插入,修改时自动维护时间戳
	@Column(columnDefinition = "TIMESTAMP", nullable = false, updatable = false, insertable = false)
	private Timestamp teacherTime;
	@Transient // 临时参数,不映射到数据库表字段
	private String teacherParam;

	@JsonIgnore
	// mappedBy配置映射关系:映射到当前Teacher对象的哪个字段course
	// //外键所在的表为副表,在主表上设置级联规则cascade,即设置了cascade属性的表没有外键;没有设置cascade属性的表会建外键
//	@OneToOne(optional = false,mappedBy="teacher", fetch = FetchType.LAZY)		// 默认值optional = true表示是否可以为空
	@OneToOne(optional = false, mappedBy = "teacher", cascade = CascadeType.ALL, fetch = FetchType.EAGER) // 不建外键
																											// //optional是否可以为空
//	@OneToOne(fetch = FetchType.EAGER)		// 默认值optional = true表示是否可以为空
	@JoinColumn(name = "teacher_course_id", unique = true) //// 副表中的外键字段名称 // unique=true确保了一对一关系
	private Course course;

	// ----------------------------- 以下是构造方法 ------------------------

	// ----------------------------- 以下是Getter和setter方法 ------------------------
	public Integer getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getTeacherSex() {
		return teacherSex;
	}

	public void setTeacherSex(String teacherSex) {
		this.teacherSex = teacherSex;
	}

	public Integer getTeacherAge() {
		return teacherAge;
	}

	public void setTeacherAge(Integer teacherAge) {
		this.teacherAge = teacherAge;
	}

	public Date getTeacherBirthday() {
		return teacherBirthday;
	}

	public void setTeacherBirthday(Date teacherBirthday) {
		this.teacherBirthday = teacherBirthday;
	}

	public Timestamp getTeacherTime() {
		return teacherTime;
	}

	public void setTeacherTime(Timestamp teacherTime) {
		this.teacherTime = teacherTime;
	}

	public String getTeacherParam() {
		return teacherParam;
	}

	public void setTeacherParam(String teacherParam) {
		this.teacherParam = teacherParam;
	}

	/**
	 * 把教师所教课程名称设置到临时参数中
	 */
	public void setTeacherParam() {
		this.teacherParam = course.getCourseName();// 把教师所教课程名称设置到临时参数中
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	// ----------------------------- 以下是重写的toString方法 ------------------------

	@Override
	public String toString() {
		return "Teacher [teacherId=" + teacherId + ", teacherName=" + teacherName + ", teacherSex=" + teacherSex
				+ ", teacherAge=" + teacherAge + ", teacherBirthday=" + teacherBirthday + ", teacherTime=" + teacherTime
				+ ", teacherParam=" + teacherParam + "]";
	}

	public String showTeacherAndCourse() {
		return "Teacher [teacherId=" + teacherId + ", teacherName=" + teacherName + ", teacherSex=" + teacherSex
				+ ", teacherAge=" + teacherAge + ", teacherBirthday=" + teacherBirthday + ", teacherTime=" + teacherTime
				+ ", teacherParam=" + teacherParam + ", course=" + course + "]";
	}

}
