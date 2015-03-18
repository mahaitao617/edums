package com.jsoft.edums.classmnt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsoft.edums.base.service.BaseService;
import com.jsoft.edums.classmnt.entity.Classes;
import com.jsoft.edums.classmnt.mapper.ClassMapper;
import com.jsoft.edums.classmnt.service.ClassService;
import com.jsoft.edums.common.entity.Page;

/**
 * classService的实现类，继承BaseService
 * @author 赵开永
 *
 */
@Service
public class ClassServiceImpl extends BaseService implements ClassService{
	@Autowired
	private ClassMapper classMapper;

	public List<Classes> listPageClasses(Page page) {
		List<Classes> classList = classMapper.listPageClasses(page);
		return classList;
	}

	/**
	 * <br>
	 * <b>功能：</b>查询所有的班级<br>
	 * <b>作者：</b>李成<br>
	 * <b>日期：</b> 2014-11-21 <br>
	 * 返回所有的班级 
	 * @param 
	 * @return 返回所有的班级对象
	 */
	public List<Classes> queryAllClass(){
		List<Classes> classList = classMapper.queryAll();
		return classList;
	}
	
}
