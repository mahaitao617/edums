package com.jsoft.edums.coursemnt.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsoft.edums.classmnt.entity.Classes;
import com.jsoft.edums.common.entity.Page;
import com.jsoft.edums.common.util.Tools;
import com.jsoft.edums.coursemnt.entity.Timetable;
import com.jsoft.edums.coursemnt.mapper.TimetableMapper;
import com.jsoft.edums.coursemnt.service.TimetableService;
import com.jsoft.edums.teamnt.entity.Teacher;
/**
 * 针对于排课的所有service操作
 * @author 李成
 *
 */
@Service
public class TimetableServiceImpl implements TimetableService{
	@Autowired
	private TimetableMapper timetableMapper;
	
	/**
	 * <br>
	 * <b>功能：</b>根据当前时间查询在本周内的所有的课表<br>
	 * <b>作者：</b>李成<br>
	 * <b>日期：</b>2014-11-17 <br>
	 * <br>
	 * @return 本周课表
	 */
	public List<Timetable> queryByTime() {
		Map<String, Object> map = new HashMap<String, Object>();
		Date Fdate = Tools.getMon();//得到本周的星期一的日期
		Date Ldate = Tools.getSun();//得到本周星期日的日期
		map.put("Ldate", Ldate);
		map.put("Fdate", Fdate);
		List<Timetable> timetables = timetableMapper.queryByTime(map);
		/*for (int i = 0; i < timetables.size(); i++) {
			timetables.get(i).setDate(Tools.date2Str(timetables.get(i).getDate(), "yyyy-MM-dd"));
		}*/
		
		return timetables;
	}
	/**
	 * <br>
	 * <b>功能：</b>根据时间 校区查询在那一周内的所有的课表<br>
	 * <b>作者：</b>李成<br>
	 * <b>日期：</b>2014-11-21 <br>
	 * <br>
	 * @return 本周课表
	 */
	public List<Timetable> queryByTime(String campus,Date date) {
		Map<String, Object> map = new HashMap<String, Object>();
		Date Fdate = Tools.getMon(date);//得到本周的星期一的日期
		Date Ldate = Tools.getSun(date);//得到本周星期日的日期
		map.put("Ldate", Ldate);
		map.put("Fdate", Fdate);
		map.put("campus", campus);
		List<Timetable> timetables = timetableMapper.queryByTimeAndCampus(map);
		/*for (int i = 0; i < timetables.size(); i++) {
			timetables.get(i).setDate(Tools.date2Str(timetables.get(i).getDate(), "yyyy-MM-dd"));
		}*/
		
		return timetables;
	}
	
	/**
	 * <br>
	 * <b>功能：</b>根据timetable 条件查询所有的课表<br>
	 * <b>作者：</b>李成<br>
	 * <b>日期：</b>2014-11-20 <br>
	 * <br>
	 * @return 本周课表
	 */
	public List<Timetable> queryByTimetable(Timetable timetable) {
		
		return timetableMapper.queryByTimetable(timetable);
	}

	/**
	 * <br>
	 * <b>功能：</b>根据时间地点 条件查询所有的课表<br>
	 * <b>作者：</b>李成<br>
	 * <b>日期：</b>2014-11-20 <br>
	 * <br>
	 * @return 本周课表
	 */
	public List<Timetable> queryTimetableByTimeClass(String campus,
			String classTime, String classroom, String date) {
		Timetable timetable = new Timetable();
		timetable.setCampus(campus);
		timetable.setDate(Tools.str2Date(date+" 00:00:00"));
		timetable.setTime(classTime);
		timetable.setClassroom(classroom);
		return timetableMapper.queryByTimetable(timetable);
	}
	/**
	 * <br>
	 * <b>功能：</b>根据时间 条件查询所有的课表<br>
	 * <b>作者：</b>李成<br>
	 * <b>日期：</b>2014-11-20 <br>
	 * <br>
	 * @return 本周课表
	 */
	public List<Timetable> queryTimetableByTime(String classTime,String date){
		Timetable timetable = new Timetable();
		timetable.setDate(Tools.str2Date(date+" 00:00:00"));
		timetable.setTime(classTime);
		return timetableMapper.queryByTimetable(timetable);
	}
	/**
	 * <br>
	 * <b>功能：</b>给一个课程项 返回所有的teacher集合<br>
	 * <b>作者：</b>李成<br>
	 * <b>日期：</b>2014-11-20 <br>
	 * <br>
	 * @return 本周课表
	 */
	public List<Teacher> getAllTeacher(List<Timetable> timetables){
		List<Teacher> teachers = new ArrayList<Teacher>();
		for (int i = 0; i < timetables.size(); i++) {
			teachers.add(timetables.get(i).getTeacher());
		}
		for (int i = 0; i < teachers.size(); i++) {
			System.err.println(teachers.get(i).getTeaName());
		}
		return teachers;
	}
	
	/**
	 * <br>
	 * <b>功能：</b>给一个课程项 返回所有的class集合<br>
	 * <b>作者：</b>李成<br>
	 * <b>日期：</b>2014-11-20 <br>
	 * <br>
	 * @return 本周课表
	 */
	public List<Classes> getAllclass(List<Timetable> timetables){
		List<Classes> classes = new ArrayList<Classes>();
		for (int i = 0; i < timetables.size(); i++) {
			classes.add(timetables.get(i).getClasses());
		}
		for (int i = 0; i < classes.size(); i++) {
			System.err.println(classes.get(i).getClassesNo());
		}
		return classes;
	}
	
	/**
	 * <br>
	 * <b>功能：</b>给一个课程项 和一个教师集合  从教师集合中除掉所有的课程项中有的教师集合<br>
	 * <b>作者：</b>李成<br>
	 * <b>日期：</b>2014-11-20 <br>
	 * <br>
	 * @return 本周课表
	 */
	public void removeTeacher(List<Timetable> timetables,List<Teacher> teachers){
		for (int i = 0; i < teachers.size(); i++) {
			for (int j = 0; j < timetables.size(); j++) {
				if(teachers.get(i).getTeaId()==timetables.get(j).getTea_id()){
					teachers.remove(i);
					i--;
				}
			}
		}
	}
	/**
	 * <br>
	 * <b>功能：</b>给一个课程项 和一个班级集合  从教师集合中除掉所有的课程项中有的班级集合<br>
	 * <b>作者：</b>李成<br>
	 * <b>日期：</b>2014-11-20 <br>
	 * <br>
	 * @return 本周课表
	 */
	public void removeClass(List<Timetable> timetables,List<Classes> classes){
		for (int i = 0; i < classes.size(); i++) {
			for (int j = 0; j < timetables.size(); j++) {
				if(classes.get(i).getClassesId()==timetables.get(j).getClasses_id()){
					classes.remove(i);
					i--;
				}
			}
		}
	}

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
			String classes, String remark,Integer buildUserId){
		Timetable timetable = new Timetable();
		if(timetableId!=null&&timetableId!=""){
			timetable.setTimeTableId(Integer.parseInt(timetableId));
		}
		
		timetable.setCampus(campus);
		timetable.setClassroom(classroom);
		timetable.setDate(Tools.str2Date(date+" 00:00:00.0"));
		timetable.setTime(classTime);
		timetable.setTea_id(Integer.parseInt(teacher));
		timetable.setClasses_id(Integer.parseInt(classes));
		timetable.setBuildTime(new Date());
		timetable.setRemark(remark);
		timetable.setBuildUserId(buildUserId);
		timetable.setIsDelete(0);
		System.err.println(timetable);
		if(timetableId==null||timetableId==""){
			timetableMapper.insertTimetable(timetable);
		}else{
			timetableMapper.updateTimetable(timetable);
		}
		
		
	}
	

}
