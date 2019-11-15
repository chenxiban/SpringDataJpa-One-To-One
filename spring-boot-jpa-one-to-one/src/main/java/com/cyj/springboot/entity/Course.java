package com.cyj.springboot.entity;

import java.io.Serializable;
import java.math.BigDecimal;

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
@Table(name = "coursetb")
public class Course implements Serializable {

	@Id // 实体类主键
	@OrderBy // 数据加载排序字段
	@GeneratedValue // 自动增长列
	@Column(columnDefinition = "int unsigned NOT NULL comment '备注:课程自动增长主键'  ") // 自定义字段类型
	private Integer courseId;

	@Column(length = 20) // 字符长度20
	private String courseName;
//	@Column(columnDefinition="decimal(5,2)  ")	//自定义字段类型:5位有效数字,小数点后保留2位
	@Column(precision = 5, scale = 2) // 5位有效数字,小数点后保留2位
	private BigDecimal coursePrice;
	@Transient // 临时参数,不映射到数据库表字段
	private String courseParam;
	@JsonIgnore
	// mappedBy配置映射关系:映射到当前Teacher对象的哪个字段course
	// //外键所在的表为副表,在主表上设置级联规则cascade,即设置了cascade属性的表没有外键;没有设置cascade属性的表会建外键
//	@OneToOne(optional = false, mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.EAGER)		//optional是否可以为空
	@OneToOne(fetch = FetchType.EAGER) // 默认值optional = true表示是否可以为空
	@JoinColumn(name = "course_teacher_id", unique = true) //// 副表中的外键字段名称 // unique=true确保了一对一关系
	private Teacher teacher;

	// ----------------------------- 以下是构造方法 ------------------------

	// ----------------------------- 以下是Getter和setter方法 ------------------------
	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public BigDecimal getCoursePrice() {
		return coursePrice;
	}

	public void setCoursePrice(BigDecimal coursePrice) {
		this.coursePrice = coursePrice;
	}

	public String getCourseParam() {
		return courseParam;
	}

	public void setCourseParam(String courseParam) {
		this.courseParam = courseParam;
	}

	/**
	 * 把课程所属教师名称设置到临时参中
	 */
	public void setCourseParam() {
		this.courseParam = teacher.getTeacherName();// 把课程所属教师名称设置到临时参中
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	// ----------------------------- 以下是重写的toString方法 ------------------------

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", coursePrice=" + coursePrice
				+ ", courseParam=" + courseParam + "]";
	}

	public String showCourseAndTeacher() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", coursePrice=" + coursePrice
				+ ", courseParam=" + courseParam + ", teacher=" + teacher + "]";
	}

}
