package com.jsoft.edums.attendance.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsoft.edums.attendance.entity.AttendanceRecords;
import com.jsoft.edums.attendance.mapper.AttendanceMapper;
import com.jsoft.edums.attendance.service.AttendanceService;
import com.jsoft.edums.base.service.BaseService;
import com.jsoft.edums.common.entity.Page;
import com.jsoft.edums.system.entity.Diction;

@Service
public class AttendanceServiceImpl extends BaseService implements AttendanceService{

	@Autowired
	private AttendanceMapper attendanceMapper;
	
	public List<AttendanceRecords> listRequiredAttendance(String requiredInfo , Page page) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("requiredInfo", requiredInfo);
		map.put("page", page);
		
		List<AttendanceRecords> attendanceRecords = this.attendanceMapper.listPageRequiredAttendance(map);
		
		return attendanceRecords;
	}

	public void deleteAttendanceById(Integer ARId) {
		// TODO Auto-generated method stub
	}

	public void updateAttendanceById(Integer ARId, String ARState,
			String leaveReason) {
		AttendanceRecords attendanceRecords=new AttendanceRecords();
		attendanceRecords.setARId(ARId);
		Diction diction=attendanceMapper.setARState(ARState);//根据ARState查到这个Diction，目的是得到他的childId
		attendanceRecords.setARState(diction.getChildId());
		attendanceRecords.setLeaveReason(leaveReason);
		attendanceMapper.updateAttendanceById(attendanceRecords);
	}
	
	public AttendanceRecords findSingle(int ARId){
		AttendanceRecords attendanceRecords = attendanceMapper.findSingle(ARId);
		return attendanceRecords;
	}

	public List<Diction> findARStates() {
		List<Diction> ls=attendanceMapper.findARStates();
		return ls;
	}

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
	public long insertAttendance(String tempString) {
		// TODO Auto-generated method stub
		String temp[] = tempString.split(",");// 截取字符串，获得各个checkBox的值
		List<AttendanceRecords> attendanceRecords=new ArrayList<AttendanceRecords>();
		
		for(int i=1;i<temp.length;i++){
			AttendanceRecords attendance=new AttendanceRecords();
			attendance.setStu_id(Integer.parseInt(temp[i]));
			attendanceRecords.add(attendance);
		}
		return attendanceMapper.insertAttendance(attendanceRecords);
	}

	public List<AttendanceRecords> listAttendanceRecordsAll(Page page) {
		List<AttendanceRecords> attendanceRecords = this.attendanceMapper.listPageAttendanceAll(page);	
		return attendanceRecords;
	}
	
	

	
}
