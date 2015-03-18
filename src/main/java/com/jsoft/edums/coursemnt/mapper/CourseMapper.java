 package com.jsoft.edums.coursemnt.mapper;

import java.util.List;
import java.util.Map;

import com.jsoft.edums.common.annotation.MyBatisDao;
import com.jsoft.edums.common.entity.Page;
import com.jsoft.edums.coursemnt.entity.CourseInfo;
import com.jsoft.edums.system.entity.Diction;


@MyBatisDao
public interface CourseMapper {
	
	
	/**
	 * addCourse 添加课程
	 * * 作者:车波
	 * 日期:2014-11-16
	 * @param c 一个课程对象
	 */
	void insertCourse(CourseInfo courseInfo);
	/**
	 * delCourse 根据课程Id删除课程
	 * @param cId 课程Id
	 *  作者:车波
	 * 日期:2014-11-16
	 */
	void deleteCourse(int courseId);
	/**
	 * updateCourse 更新课程信息
	 * @param c 新的课程对象
	 */
	void updateCourse(CourseInfo courseInfo);
	/**
	 * queryCourse 查询所有课程
	 *  作者:车波
	 * 日期:2014-11-16
	 * @return 返回所有课程信息对象
	 */
	List<CourseInfo> queryCourse(Page page);
	/**
	 * 查询单门的具体信息
	 * * 作者:车波
	 * 日期:2014-11-16
	 * */
	CourseInfo queryCourseById(int courseId);
	/**
	 * 按条件查询课程
	 * * 作者:车波
	 * 日期:2014-11-16
	 * */
	List<CourseInfo> queryCourseByParams(Map Params);
/**
 * 模糊查询，没有设置分页
 * @Params key 关键字
 * @return  返回course的结果集
 * 作者:车波
 * 日期:2014-11-21
 * 方法已测试成功
 * **/
	List queryCourseByKeys(String  key);

}
