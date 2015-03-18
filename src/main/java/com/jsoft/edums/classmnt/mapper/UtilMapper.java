package com.jsoft.edums.classmnt.mapper;


import java.sql.Timestamp;

import com.jsoft.edums.common.annotation.MyBatisDao;

/**
 * 班级管理模块需要用到的辅助dao操作
 * @author zky
 *
 */
@MyBatisDao
public interface UtilMapper {
	/**
	 * 根据学号获取学生信息表中的档案号，再根据档案号获取入档时间
	 * @param stuNo 学号
	 * @return 返回入档时间
	 */
	public Timestamp getBuildTime(String stuNo);
	
	/**
	 * 获取当前班级的最大编号
	 * @return
	 */
	public int getMaxClassNo();
	
	/**
	 * 根据课程编号获取最大的学生编号
	 * @param classNo
	 * @return
	 */
	public String getMaxStuNo(int classNo);
	
	/**
	 * 为班级分配教师  需要根据班级的类型选择相应的授课教师
	 * @return
	 */
	public String addTeacher2Class();
}
