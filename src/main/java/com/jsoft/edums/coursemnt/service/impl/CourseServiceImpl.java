package com.jsoft.edums.coursemnt.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsoft.edums.base.service.BaseService;
import com.jsoft.edums.common.entity.Page;
import com.jsoft.edums.coursemnt.entity.CourseInfo;
import com.jsoft.edums.coursemnt.mapper.CourseMapper;
import com.jsoft.edums.coursemnt.service.CourseService;
import com.jsoft.edums.system.entity.Diction;
import com.jsoft.edums.system.mapper.UserMapper;
import com.jsoft.edums.system.service.UserService;
@Service
public class CourseServiceImpl extends BaseService implements CourseService{
	@Autowired
	private CourseMapper courseMapper;
	
	

	

	public void deleteCourse(List<Integer> cId) {
		//courseMapper.delCourse(cId);
		System.err.println("service courseIdList.size"+cId.size());
		for (int i = 0; i < cId.size(); i++) {
			int courseId=cId.get(i);
			System.err.println("d"+courseId);
			System.err.println("i"+i);
			courseMapper.deleteCourse(courseId);
		}
	}

	

	public List<CourseInfo> queryCourse(Page page) {
		List<CourseInfo> course=courseMapper.queryCourse(page);
		return course;
	}



	
	public void insertCourse(String no, String name, String hour,
			String describe, String type, String state) {
		System.err.println("service addCourse");
		CourseInfo courseInfo=new CourseInfo();
		courseInfo.setCourseHour(Integer.parseInt(hour));
		courseInfo.setCourseName(name);
		courseInfo.setCourseNo(no);
		courseInfo.setCourseState(state);
		courseInfo.setCourseType(type);
		courseInfo.setDescribe(describe);
		/*System.err.println("courseInfo.name"+name);
		System.err.println("courseInfo.no"+no);
		System.err.println("courseInfo.state"+state);
		System.err.println("courseInfo.type"+type);
		System.err.println("courseInfo.describe"+describe);
		System.err.println("courseInfo.hour"+hour);*/
		courseMapper.insertCourse(courseInfo);
		
	}



/**
 * 根据id找到相应的课程，然后更新相关信息
 * */
	public void updateCourse(String Id,String no, String name, String hour,
			String describe, String type, String state) {
		CourseInfo courseInfo=new CourseInfo();
		courseInfo.setCourseHour(Integer.parseInt(hour));
		courseInfo.setCourseName(name);
		courseInfo.setCourseNo(no);
		courseInfo.setCourseState(state);
		courseInfo.setCourseType(type);
		courseInfo.setDescribe(describe);
		courseMapper.updateCourse(courseInfo);
		
	}








	
	public List<CourseInfo> queryCourseByParams(String courseNo,
			String courseName, String courseType, String courseState,
			 Page page) {
		
		List <CourseInfo>courseList=new ArrayList();
		/**
		 * 按条件查询
		 * */
		
	
	
		return courseList;
	}



	
	public CourseInfo queryCourseById(String courseNo) {
		CourseInfo courseInfo=new CourseInfo();
		courseInfo=courseMapper.queryCourseById(Integer.parseInt(courseNo));
		System.err.println("courseInfo.name"+courseInfo.getCourseName());
		return courseInfo;
	}



	
	public List<CourseInfo> queryCourseByKeys(String key, Page page) {
		// TODO Auto-generated method stub
		List<CourseInfo> courseList=new ArrayList();
	courseList =courseMapper.queryCourseByKeys(key);
		return courseList;
	}

}
