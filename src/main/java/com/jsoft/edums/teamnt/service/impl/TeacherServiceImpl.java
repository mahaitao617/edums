package com.jsoft.edums.teamnt.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsoft.edums.base.service.BaseService;
import com.jsoft.edums.coursemnt.entity.CourseInfo;
import com.jsoft.edums.coursemnt.mapper.CourseMapper;
import com.jsoft.edums.teamnt.entity.Teacher;
import com.jsoft.edums.teamnt.mapper.TeacherMapper;
import com.jsoft.edums.teamnt.service.TeacherService;

@Service

public class TeacherServiceImpl extends BaseService implements TeacherService {

	@Autowired
	private TeacherMapper teamapper;
	/**
	 * 
	 * 增加一个教师(教师编号没写好)
	 * 
	 */
	public void insertTeacher( Integer courseId,
			 String sex,  String specialty,
			 String teaLevel,  String teaName,
			 String teaState,  String telephone) {
		// TODO Auto-generated method stub
		Teacher tea = new Teacher();
		tea.setCourseId(courseId);
		tea.setIsDelete(0);
		tea.setSex(sex);
		tea.setSpecialty(specialty);
		tea.setTeaLevel(teaLevel);
		tea.setTeaName(teaName);
		tea.setTeaNo("20002");// 教师编号还没写
		tea.setTeaState(teaState);
		tea.setTelephone(telephone);
		teamapper.insertTeacher(tea);
	}
	/**
	 * 查询教师
	 * @param tea 条件
	 * @return 教师
	 */
	public List<Teacher> queryTea(Teacher tea) {
		List<Teacher>ts=teamapper.listPageGetTeacher(tea);
		for(int i=0;i<ts.size();i++){
			CourseInfo course=teamapper.queryCourseById(ts.get(i).getCourseId());
			ts.get(i).setCourse(course);
		}
		return ts;
	}
	

	/**
	 * @param teaNo
	 * 删除教师
	 */
	public void deleteTeacher(String teaNo) {
		// TODO Auto-generated method stub
		teamapper.deleteTeacher(teaNo);
	}

	

	public void updateTea(Teacher tea) {
		// TODO Auto-generated method stub
		
	}



}