package com.jsoft.edums.teamnt.entity;

import com.jsoft.edums.common.entity.Page;
import com.jsoft.edums.coursemnt.entity.CourseInfo;

/**
 * 教师实体类
 * 
 * @author 何聪
 *
 */
public class Teacher {
	private Integer teaId; // 教师实体类表的id
	private String teaNo; // 教师编号
	private String teaName; // 教师姓名
	private String sex; // 性别
	private Integer courseId; // 所教课程编号
	private CourseInfo course;//所教课程
	private String specialty; // 特长
	private String telephone; // 电话号码
	private String teaLevel; // 教师等级
	private String teaState; // 教师状态，在职等 字典值
	private Integer isDelete;// 是否删除 默认0 不删除，1删除
	private Page page;

	public Integer getTeaId() {
		return teaId;
	}

	public void setTeaId(Integer teaId) {
		this.teaId = teaId;
	}

	public String getTeaNo() {
		return teaNo;
	}

	public void setTeaNo(String teaNo) {
		this.teaNo = teaNo;
	}

	public String getTeaName() {
		return teaName;
	}

	public void setTeaName(String teaName) {
		this.teaName = teaName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public CourseInfo getCourse() {
		return course;
	}
	
	public void setCourse(CourseInfo course) {
		this.course = course;
	}
	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getTeaLevel() {
		return teaLevel;
	}

	public void setTeaLevel(String teaLevel) {
		this.teaLevel = teaLevel;
	}

	public String getTeaState() {
		return teaState;
	}

	public void setTeaState(String teaState) {
		this.teaState = teaState;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public Page getPage() {
		if (page == null)
			page = new Page();
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}
}
