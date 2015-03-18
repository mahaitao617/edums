package com.jsoft.edums.teamnt.mapper;

import java.util.List;

import com.jsoft.edums.common.annotation.MyBatisDao;
import com.jsoft.edums.coursemnt.entity.CourseInfo;
import com.jsoft.edums.teamnt.entity.Teacher;



@MyBatisDao
public interface TeacherMapper{
    /**
     * 
     * 功能：增加教师
     * @param tea
     */
	void insertTeacher(Teacher tea);
	/**
     * 
     * 功能：删除教师
     * @param tea
     */
    void deleteTeacher(String teaNo);
   
    
	/*修改学生信息*/
	void updateTea(Teacher tea);
    //void updateTeaBaseInfo(Teacher tea);
	

	void updateTeaRights(Teacher tea);
	/**
	 * 查询教师
	 * @param teacher 条件
	 * @return 教师
	 */
	List<Teacher> listPageGetTeacher(Teacher teacher);
	
	CourseInfo queryCourseById(Integer courseId);
}
