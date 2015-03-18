package com.jsoft.edums.coursemnt.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import com.jsoft.edums.common.entity.Page;
import com.jsoft.edums.coursemnt.entity.CourseInfo;



public interface CourseService {
	/**
	 * queryDiction 查询字典，填充下拉框等固定信息
	 * @return 返回所有字典对象
	 */
	
	/**
	 * 功能：增加单个课程
	 * @param no 课程编号
	 * @param name 课程名称
	 * @param hour 课时
	 * @param describle 课程描述
	 * @param type 课程类型
	 * @param state 课程状态
	 *  作者:车波
	 * 日期:2014-11-16
	 * @
	 * */
	void insertCourse(String no, String name, String hour, String describe,String type, String state);
	/** 作者:车波
	 * 日期:2014-11-16
	 * delCourse 根据课程Id删除课程
	 * @param cId 课程Id集合
	 */
	void deleteCourse(List<Integer> cId);
	/**
	 * 作者:车波
	 * 日期:2014-11-16
	 * updateCourse 更新课程信息
	 * @param c 新的课程对象
	 */
	void updateCourse( String Id,String no, String name, String hour, String describe, String type, String state);
	/**
	* 作者:车波
	 * 日期:2014-11-16 
	 * queryCourse 查询所有课程
	 * @return 返回所有课程信息对象
	 */
	List<CourseInfo> queryCourse(Page page);
	/**
	 * 作者:车波
	 * 日期:2014-11-16
	 * queryCourseByParams按条件查询课程
	 * @return 返回符合条件的课程list
	 * @param 各种查询条件
	 * 
	 * */
	List<CourseInfo> queryCourseByParams(String courseNo, String courseName,
			String courseType, String courseState, Page page);
	/**
	 * 作者:车波
	 * 日期:2014-11-16
	 * 查询单门课程的详细信息
	 * @return courseInfo对象
	 * @param courseId 课程id
	 * */
	CourseInfo queryCourseById(String courseId);
	/**
	 * 作者:车波
	 * 日期:2014-11-16
	 * 模糊查询
	 * */
	List<CourseInfo> queryCourseByKeys(String key, Page page);

}
