package com.jsoft.edums.coursemnt.mapper;

import java.util.List;
import java.util.Map;

import com.jsoft.edums.common.annotation.MyBatisDao;
import com.jsoft.edums.coursemnt.entity.Timetable;
/**
 * 对课表的基本dao 操作
 * @author 李成
 *
 */
@MyBatisDao
public interface TimetableMapper {
	/**
	 * <br>
	 * <b>功能：</b>查询出周一为一个时间的 所有课<br>
	 * <b>作者：</b>李成<br>
	 * <b>日期：</b>2014-11-17 <br>
	 * <br>
	 * 传入一个map参数 里面应该有Page 和时间
	 * @param map
	 * @return
	 */
	public List<Timetable> queryByTime(Map<String,Object> map);
	/**
	 * <br>
	 * <b>功能：</b>查询出周一为一个时间的 所有课<br>
	 * <b>作者：</b>李成<br>
	 * <b>日期：</b>2014-11-17 <br>
	 * <br>
	 * 传入一个map参数 里面应该有Page 和时间
	 * @param map
	 * @return
	 */
	public List<Timetable> queryByTimeAndCampus(Map<String,Object> map);
	
	/**
	 * <br>
	 * <b>功能：</b>根据传过来的参数查询所有的课程<br>
	 * <b>作者：</b>李成<br>
	 * <b>日期：</b>2014-11-20 <br>
	 * <br>
	 * 
	 * @param 
	 * @return 
	 */
	public List<Timetable> queryByTimetable(Timetable timetable);
	/**
	 * <br>
	 * <b>功能：</b>根据传过来的参数查询插入一个课程<br>
	 * <b>作者：</b>李成<br>
	 * <b>日期：</b>2014-11-20 <br>
	 * <br>
	 * 
	 * @param 
	 * @return 
	 */
	public void insertTimetable(Timetable timetable);
	
	/**
	 * <br>
	 * <b>功能：</b>根据传过来的参数查询更新一个课程<br>
	 * <b>作者：</b>李成<br>
	 * <b>日期：</b>2014-11-20 <br>
	 * <br>
	 * 
	 * @param 
	 * @return 
	 */
	public void updateTimetable(Timetable timetable);
}
