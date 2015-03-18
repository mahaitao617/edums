package com.jsoft.edums.coursemnt.entity;

import com.jsoft.edums.common.entity.Page;

/**
 * 课程信息表 为数据库中的courseInfo 
 * 
 * @author Michael
 *
 */
public class CourseInfo {
	private static final long serialVersionUID = 1L;
	
	private Integer courseId;  // 课程id
	private String courseNo;   // 课程编号
	private String courseName; // 课程名称
	private Integer courseHour;  // 课时
	private String describe;  // 描述
	private String courseType;   // 课程类型
	private String courseState;  // 课程状态
	private Integer isDelete;         
	
	private Page page;      // 分页用

	
	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public String getCourseNo() {
		return courseNo;
	}

	public void setCourseNo(String courseNo) {
		this.courseNo = courseNo;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Integer getCourseHour() {
		return courseHour;
	}

	public void setCourseHour(Integer courseHour) {
		this.courseHour = courseHour;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public String getCourseType() {
		return courseType;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}

	public String getCourseState() {
		return courseState;
	}

	public void setCourseState(String courseState) {
		this.courseState = courseState;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
