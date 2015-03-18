package com.jsoft.edums.teamnt.service;


import java.util.List;

import com.jsoft.edums.teamnt.entity.Teacher;





public interface TeacherService {


	
	public void updateTea(Teacher tea);
	/**
	 * 查询教师
	 * @param tea 条件
	 * @return 教师
	 */
	public List<Teacher> queryTea(Teacher tea);


	/**
	 * 
	 * 功能：增加教师信息
	 * @param courseId
	 * @param sex
	 * @param specialty
	 * @param teaLevel
	 * @param teaName
	 * @param teaState
	 * @param telephone
	 */
	void insertTeacher(Integer courseId, String sex, String specialty,
			String teaLevel, String teaName, String teaState, String telephone);

	/**
	 * 
	 * 功能：删除教师
	 * 
	 * @param tea
	 */
	void deleteTeacher(String teaNo);
	

}
