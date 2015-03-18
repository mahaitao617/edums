package com.jsoft.edums.classmnt.service;

/**
 * 班级管理模块用到的
 * @author 赵开永
 *
 */
public interface ClassToolService {
	/**
	 * 分班的时候根据学生档案号创建学生学号
	 * @param archivesNo
	 * @return
	 */
	public String createStuNo(String archivesNo);
	
	/**
	 * 分班的时候根据学生档案号创建学生学号  
	 * 生成学号的时候，需要判断该班级是不是人数已满30
	 * 如果人数已满30，则是下一个班的班号
	 * @param archivesNo
	 * @param classNo 分配近已经存在的班级
	 * @return
	 */
	public String createStuNo(String archivesNo, int classNo);
}
