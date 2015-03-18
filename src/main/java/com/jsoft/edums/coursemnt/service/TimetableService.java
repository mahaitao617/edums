package com.jsoft.edums.coursemnt.service;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import com.jsoft.edums.classmnt.entity.Classes;
import com.jsoft.edums.coursemnt.entity.Timetable;
import com.jsoft.edums.teamnt.entity.Teacher;

/**
 * 针对于排课的所有service操作
 * 
 * @author 李成
 *
 */
public interface TimetableService {
	/**
	 * <br>
	 * <b>功能：</b>根据当前时间查询在本周内的所有的课表<br>
	 * <b>作者：</b>李成<br>
	 * <b>日期：</b>2014-11-17 <br>
	 * <br>
	 * 
	 * @return 本周课表
	 */
	public List<Timetable> queryByTime();
	/**
	 * <br>
	 * <b>功能：</b>根据时间 校区查询在那一周内的所有的课表<br>
	 * <b>作者：</b>李成<br>
	 * <b>日期：</b>2014-11-21 <br>
	 * <br>
	 * @return 本周课表
	 */
	public List<Timetable> queryByTime(String campus,Date date);
	/**
	 * <br>
	 * <b>功能：</b>根据timetable 条件查询所有的课表<br>
	 * <b>作者：</b>李成<br>
	 * <b>日期：</b>2014-11-20 <br>
	 * <br>
	 * 
	 * @return 本周课表
	 */
	public List<Timetable> queryByTimetable(Timetable timetable);

	/**
	 * <br>
	 * <b>功能：</b>根据时间地点 条件查询所有的课表<br>
	 * <b>作者：</b>李成<br>
	 * <b>日期：</b>2014-11-20 <br>
	 * <br>
	 * 
	 * @return 本周课表
	 */
	public List<Timetable> queryTimetableByTimeClass(String campus,
			String classTime, String classroom, String date);

	/**
	 * <br>
	 * <b>功能：</b>根据时间地点 条件查询所有的课表<br>
	 * <b>作者：</b>李成<br>
	 * <b>日期：</b>2014-11-20 <br>
	 * <br>
	 * 
	 * @return 本周课表
	 */
	public List<Timetable> queryTimetableByTime(String classTime, String date);

	/**
	 * <br>
	 * <b>功能：</b>给一个课程项 返回所有的teacher集合<br>
	 * <b>作者：</b>李成<br>
	 * <b>日期：</b>2014-11-20 <br>
	 * <br>
	 * 
	 * @return 本周课表
	 */
	public List<Teacher> getAllTeacher(List<Timetable> timetables);

	/**
	 * <br>
	 * <b>功能：</b>给一个课程项 返回所有的class集合<br>
	 * <b>作者：</b>李成<br>
	 * <b>日期：</b>2014-11-20 <br>
	 * <br>
	 * 
	 * @return 本周课表
	 */
	public List<Classes> getAllclass(List<Timetable> timetables);

	/**
	 * <br>
	 * <b>功能：</b>给一个课程项 和一个教师集合 从教师集合中除掉所有的课程项中有的教师集合<br>
	 * <b>作者：</b>李成<br>
	 * <b>日期：</b>2014-11-20 <br>
	 * <br>
	 * 
	 * @return 本周课表
	 */
	public void removeTeacher(List<Timetable> timetables, List<Teacher> teachers);

	/**
	 * <br>
	 * <b>功能：</b>给一个课程项 和一个班级集合 从教师集合中除掉所有的课程项中有的班级集合<br>
	 * <b>作者：</b>李成<br>
	 * <b>日期：</b>2014-11-20 <br>
	 * <br>
	 * 
	 * @return 本周课表
	 */
	public void removeClass(List<Timetable> timetables, List<Classes> classes);

	/**
	 * <br>
	 * <b>功能：</b>根据给定的条件 新增一条记录 或者修改哪些记录<br>
	 * <b>作者：</b>李成<br>
	 * <b>日期：</b>2014-11-21 <br>
	 * <br>
	 * 
	 * @return 本周课表
	 */
	public void saveTimetable(String timetableId, String campus,
			String classroom, String date, String classTime, String teacher,
			String classes, String remark,Integer buildUserId);

}
