package com.jsoft.edums.coursemnt.entity;



import java.util.Date;

import com.jsoft.edums.classmnt.entity.Classes;
import com.jsoft.edums.common.entity.Page;
import com.jsoft.edums.teamnt.entity.Teacher;

/**
 * 排课类 为数据库中timetable的实体类
 * 
 * @author Michael
 * @update 李成
 *
 */
public class Timetable {
	private static final long serialVersionUID = 1L;
	

	private Integer timeTableId;  // 排课id
	private Integer classes_id;  // 班级id
	private Integer course_id;  // 课程id
	private Integer tea_id; // 教师id
	private String campus; // 校区
	private String classroom;  // 教室
	private Date date;  // 上课日期
	private String time; // 时间
	private Date buildTime;//建立时间
	private Integer buildUserId;//建立人的id
	private Date updateTime;//更新时间
	private String remark;//备注
	private Integer isDelete;       
	
	private Page page;    // 分页用
	private Classes classes;//班级实体
	private CourseInfo courseInfo;//课程实体
	private Teacher teacher;//教师实体
	
	
	public Classes getClasses() {
		return classes;
	}

	public void setClasses(Classes classes) {
		this.classes = classes;
	}

	public CourseInfo getCourseInfo() {
		return courseInfo;
	}

	public void setCourseInfo(CourseInfo courseInfo) {
		this.courseInfo = courseInfo;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Date getBuildTime() {
		return buildTime;
	}

	public void setBuildTime(Date buildTime) {
		this.buildTime = buildTime;
	}

	public Integer getBuildUserId() {
		return buildUserId;
	}

	public void setBuildUserId(Integer buildUserId) {
		this.buildUserId = buildUserId;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getTimeTableId() {
		return timeTableId;
	}

	public void setTimeTableId(Integer timeTableId) {
		this.timeTableId = timeTableId;
	}

	public Integer getClasses_id() {
		return classes_id;
	}

	public void setClasses_id(Integer classes_id) {
		this.classes_id = classes_id;
	}

	public Integer getCourse_id() {
		return course_id;
	}

	public void setCourse_id(Integer course_id) {
		this.course_id = course_id;
	}

	public Integer getTea_id() {
		return tea_id;
	}

	public void setTea_id(Integer tea_id) {
		this.tea_id = tea_id;
	}

	public String getCampus() {
		return campus;
	}

	public void setCampus(String campus) {
		this.campus = campus;
	}

	public String getClassroom() {
		return classroom;
	}

	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
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

	@Override
	public String toString() {
		return "Timetable [timeTableId=" + timeTableId + ", classes_id="
				+ classes_id + ", course_id=" + course_id + ", tea_id="
				+ tea_id + ", campus=" + campus + ", classroom=" + classroom
				+ ", date=" + date + ", time=" + time + ", buildTime="
				+ buildTime + ", buildUserId=" + buildUserId + ", updateTime="
				+ updateTime + ", remark=" + remark + ", isDelete=" + isDelete
				+ ", page=" + page + ", classes=" + classes + ", courseInfo="
				+ courseInfo + ", teacher=" + teacher + "]";
	}
	
	


}
