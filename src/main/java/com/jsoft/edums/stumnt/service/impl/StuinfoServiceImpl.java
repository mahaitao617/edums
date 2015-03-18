package com.jsoft.edums.stumnt.service.impl;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsoft.edums.stumnt.entity.Stuinfo;
import com.jsoft.edums.stumnt.mapper.StuinfoMapper;
import com.jsoft.edums.stumnt.service.StuinfoService;
@Service
public class StuinfoServiceImpl implements StuinfoService {
	@Autowired
	private StuinfoMapper stuinfoMapper;
	/**
	 *  *  <br>
	 * <b>功能：</b>根据学号 返回学生信息对象<br>
	 * <b>作者：</b>肖猛<br>
	 * <b>日期：</b> 2014-11-16 <br>
	 * 根据学号 返回学生信息对象  
	 * @param stuNo
	 * @return
	 */
	public Stuinfo getStuinfoByStuNo(String stuNo) {
		
		return stuinfoMapper.getStuinfoByStuNo(stuNo);
		
	}
	public List<Stuinfo> listStuinfoByName(String stuName) {
		return stuinfoMapper.listStuinfoByName(stuName);
	}
	public List<Stuinfo> listStuinfoByClass(int classesNo) {
		
		return stuinfoMapper.listStuinfoByClass(classesNo);
	}
	/**
	 *  *  <br>
	 * <b>功能：</b>判断输入是否为数字<br>
	 * <b>作者：</b>肖猛<br>
	 * <b>日期：</b> 2014-11-20 <br>
	 * @param str
	 * @return
	 */
	public boolean isNumeric(String str){ 
	    Pattern pattern = Pattern.compile("[0-9]*"); 
	    return pattern.matcher(str).matches();    
	 } 


}
