package com.jsoft.edums.classmnt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.jsoft.edums.base.service.BaseService;
import com.jsoft.edums.classmnt.mapper.UtilMapper;
import com.jsoft.edums.classmnt.service.ClassToolService;

public class ClassToolServiceImpl extends BaseService implements ClassToolService{
	@Autowired
	private UtilMapper utilMapper;
	
	public String createStuNo(String archivesNo) {
		String stuNo = null;
		String year = utilMapper.getBuildTime(archivesNo).toString();
		year = year.substring(year.length() - 2, year.length());// 获取时间的年的最后两位
		String classNo = String.valueOf(utilMapper.getMaxClassNo() + 1);
		if (classNo.length() == 1){// 如果长度为1，则小于10
			classNo = "0" + classNo;
		}
		stuNo = year + classNo + (Integer.valueOf(utilMapper.getMaxStuNo(Integer.valueOf(classNo))) + 1);
		return stuNo;
	}

	public String createStuNo(String archivesNo, int classNo) {
		String stuNo = null;
		String year = utilMapper.getBuildTime(archivesNo).toString();
		year = year.substring(year.length() - 2, year.length());// 获取时间的年的最后两位
		stuNo = utilMapper.getMaxStuNo(classNo);
		if (Integer.valueOf(stuNo) < 30){
			stuNo = year + classNo + (Integer.valueOf(stuNo) + 1);
		}else {
			// 班级人数已满，新建一个班级分配学号
			stuNo = year + (Integer.valueOf(classNo) + 1) + "01";
		}
		return stuNo;
	}
	
	
	
}
