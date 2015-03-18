package com.jsoft.edums.attendance.service;

import java.util.List;

import com.jsoft.edums.attendance.entity.AttendanceRecords;
import com.jsoft.edums.common.entity.Page;
import com.jsoft.edums.system.entity.Diction;


/**
 * AttendanceService接口，功能为声明所有的出勤管理service层方法
 * 
 * @author Michael
 *
 */
public interface AttendanceService {
	
	/**
	 * listAllAtterdanceRecords方法，功能为根据条件查询到相应的出勤记录集合，并分页
	 * @param page 分页处理
	 * @return 查询到的 AtterdanceRecords出勤记录的集合
	 */
	public List<AttendanceRecords> listRequiredAttendance(String requiredInfo , Page page);
	

	/**
	 * listAttendanceRecordsAll 功能为列出所有的出勤记录
	 * @return 查出来的出勤记录
	 */
	public List<AttendanceRecords> listAttendanceRecordsAll( Page page);
	
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
	public void updateAttendanceById(Integer ARId , String ARState , String leaveReason );
	public AttendanceRecords findSingle(int ARId);
	public List<Diction> findARStates();
	/**
	 * 
	 * <br>
	 * <b>功能：</b>添加多条出勤记录<br>
	 * <b>作者：</b>许福冬<br>
	 * <b>日期：</b> 2014-11-16 <br>
	 * 
	 * @param String tempString选中学生的stuInfoId构成的字符串
	 *	@return 添加的行数
	 */
	public long insertAttendance(String tempString);

}
