package com.jsoft.edums.classmnt.service;

import java.util.List;

import com.jsoft.edums.classmnt.entity.Classes;
import com.jsoft.edums.common.entity.Page;
/**
 * 班级管理的Service层
 * @author 赵开永
 *
 */
public interface ClassService {
	/**
	 * 查询所有的班级 返回一个List
	 * @param page 用于分页
	 * @return List班级对象
	 */
	public List<Classes> listPageClasses(Page page);
	/**
	 * <br>
	 * <b>功能：</b>查询所有的班级<br>
	 * <b>作者：</b>李成<br>
	 * <b>日期：</b> 2014-11-21 <br>
	 * 返回所有的班级 
	 * @param 
	 * @return 返回所有的班级对象
	 */
	public List<Classes> queryAllClass();
}
