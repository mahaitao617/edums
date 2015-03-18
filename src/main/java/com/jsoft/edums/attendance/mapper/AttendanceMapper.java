package com.jsoft.edums.attendance.mapper;

import java.util.List;
import java.util.Map;

import com.jsoft.edums.attendance.entity.AttendanceRecords;
import com.jsoft.edums.common.annotation.MyBatisDao;
import com.jsoft.edums.common.entity.Page;
import com.jsoft.edums.coursemnt.entity.Timetable;
import com.jsoft.edums.system.entity.Diction;

@MyBatisDao
public interface AttendanceMapper {
	
	/**
	 * listTimetableByTimeAndClass根据日期和班级查询排课
	 * @param beginDate 查询的起始日期
	 * @param endDate 查询的结束日期
	 * @param classesId 查询的班级集合
	 * @param page 分页选项
	 * @return 查询到的timetable集合
	 */
	public List<Timetable> listTimetableByTimeAndClass(String beginDate , String endDate ,  List<Integer> classesId , Page page  );
	
	/**
	 * listAttendanceAll 查询所有的出勤记录
	 * @param timetableId 需要查询的出勤记录
	 * @return 查询到的出勤记录的集合
	 */
	public List<AttendanceRecords> listPageAttendanceAll(Page page);
	

	/**
	 * 根据要求查询出勤记录
	 * @param map 将要被查询的条件集合 包含分页
	 * @return 查询到的出勤记录集合
	 */
	public List<AttendanceRecords> listPageRequiredAttendance(Map<String,Object> map);

//	/**
//	 * 
//	 * <br>
//	 * <b>功能：</b>添加一条出勤记录<br>
//	 * <b>作者：</b>许福冬<br>
//	 * <b>日期：</b> 2014-11-21 <br>
//	 * @param AtterdanceRecords 要增加出勤记录
//	 *	@return 添加的行数
//	 */
//	public void insertAttendance(AttendanceRecords attendanceRecords);

	/**
	 * deleteAttendanceById 根据id删除一条出勤记录 
	 * @param ARId 将要删除的出勤记录的id
	 * @return 如果删除成功则返回true，否则返回false
	 */
	public void deleteAttendanceById(Integer ARId);
	
	/**
	 * updateAttendanceById 根据id修改一条出勤记录
	 * @param ARId 将要删除的出勤记录的id
	 * @param ARState 新的出勤状态
	 * @param leaveReason 新的请假原因
	 * @return 如果增加成功则返回true，否则返回false
	 */
	public void updateAttendanceById(AttendanceRecords attendanceRecords );
	
	/**
	 * 
	 * <br>
	 * <b>功能：</b>添加多条出勤记录<br>
	 * <b>作者：</b>许福冬<br>
	 * <b>日期：</b> 2014-11-16 <br>
	 * insertAttendance 功能为批量增加出勤记录   
	 * @param List<AtterdanceRecords> 要增加出勤记录list
	 *	@return 添加的行数
	 */
	public long insertAttendance(List<AttendanceRecords> attendanceRecords);
	
	public List<Diction> findARStates();
	public Diction setARState(String ARState);
	public AttendanceRecords findSingle(int ARId);

}
