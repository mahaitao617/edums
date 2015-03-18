package com.jsoft.edums.stumnt.service;

import java.util.List;

import com.jsoft.edums.stumnt.entity.Stuinfo;

public interface StuinfoService {
	/**
	 * 根据学号返回学生对象，从而得到学生的个人信息
	 * @param stuNo
	 * @return Stuinfo
	 */
	public Stuinfo getStuinfoByStuNo(String stuNo);
	/**
	 * 根据姓名查询学生信息
	 * @param stuName学生姓名
	 * @return 一个或多个学生信息Stuinfo对象
	 */
	public List<Stuinfo> listStuinfoByName(String stuName);
	/**
	 * 根据班级号查询该班级所有学生信息
	 * @param classesNo班级号
	 * @return 一个或多个学生信息Stuinfo对象
	 */
	public List<Stuinfo> listStuinfoByClass(int classesNo);
	/**
	 * 判断输入是否为数字
	 * @param str
	 * @return true or false
	 */
	public boolean isNumeric(String str);


}
