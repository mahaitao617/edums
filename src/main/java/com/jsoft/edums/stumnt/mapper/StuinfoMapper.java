
package com.jsoft.edums.stumnt.mapper;

import java.util.List;

import com.jsoft.edums.common.annotation.MyBatisDao;
import com.jsoft.edums.common.entity.Page;
import com.jsoft.edums.stumnt.entity.Stuinfo;

@MyBatisDao
public interface StuinfoMapper {
	/**
	 * 利用它的分页工具进行分页查询 所有的Archives对象
	 * @param page
	 * @return List<Archives>
	 */
	public List<Stuinfo> listPageStuinfo(Page page);
	/**
	 * 根据stuNo 得到一个Stuinfo的具体对象信息 
	 * @param String
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
	 * 根据班级查询学生信息
	 * @param classesNo班级编号
	 * @return 一个或多个学生信息Stuinfo对象
	 */
	public List<Stuinfo> listStuinfoByClass(int classesNo);
}

