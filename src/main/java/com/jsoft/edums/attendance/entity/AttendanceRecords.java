package com.jsoft.edums.attendance.entity;

import com.jsoft.edums.common.entity.Page;
import com.jsoft.edums.coursemnt.entity.Timetable;
import com.jsoft.edums.stumnt.entity.Stuinfo;

/**
 * AtterdanceRecords 出勤管理实体类，对应数据库中的出勤管理阿atterdanceRecords表
 * 
 * @author Michael
 *
 */
public class AttendanceRecords {
	
	private static final long serialVersionUID = 1L;
	
	private Integer ARId;  // 出勤记录id  
	private Integer stu_id;  // 学生信息id
	private Integer timetable_id;  // 排课id
	private String ARState;  // 出勤状态
	private String leaveReason;  // 请假原因
	private Integer isDelete;
	
	private Stuinfo stuinfo; // 学生实体
	private Timetable timetable; // 排课实体
	
	
	
	public Stuinfo getStuinfo() {
		return stuinfo;
	}

	public void setStuinfo(Stuinfo stuinfo) {
		this.stuinfo = stuinfo;
	}

	public Timetable getTimetable() {
		return timetable;
	}

	public void setTimetable(Timetable timetable) {
		this.timetable = timetable;
	}

	private Page page;  // 分页用

	public Integer getARId() {
		return ARId;
	}

	public void setARId(Integer aRId) {
		ARId = aRId;
	}

	public Integer getStu_id() {
		return stu_id;
	}

	public void setStu_id(Integer stu_id) {
		this.stu_id = stu_id;
	}

	public Integer getTimetable_id() {
		return timetable_id;
	}

	public void setTimetable_id(Integer timetable_id) {
		this.timetable_id = timetable_id;
	}

	public String getARState() {
		return ARState;
	}

	public void setARState(String aRState) {
		ARState = aRState;
	}

	public String getLeaveReason() {
		return leaveReason;
	}

	public void setLeaveReason(String leaveReason) {
		this.leaveReason = leaveReason;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
