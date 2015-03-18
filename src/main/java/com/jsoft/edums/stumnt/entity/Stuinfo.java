package com.jsoft.edums.stumnt.entity;

import com.jsoft.edums.common.entity.Page;

public class Stuinfo {

	private int stuInfoId; //主键
	private String stuNo; //学生编号
	private int archives_id; //档案号 外键  
	private int classes; // 班级
	private String qqNumber; //qq号
	private String mobilePhone; //电话号
	private String telephone; //固定电话
	private String emergencyContact; //紧急联系人
	private String emergencyContactPhone; //紧急联系人联系方式
	private String email; // email
	private String stuState; //学生状态
	private int isDelete;// 是否被删除
	
	private Archives archives;//学生信息对应的 档案表
	private Page page;
	
	/**
	 * 
	 * 以下是set get方法
	 * @return
	 */
	public int getStuInfoId() {
		return stuInfoId;
	}
	public void setStuInfoId(int stuInfoId) {
		this.stuInfoId = stuInfoId;
	}
	public String getStuNo() {
		return stuNo;
	}
	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}
	public int getArchives_id() {
		return archives_id;
	}
	public void setArchives_id(int archives_id) {
		this.archives_id = archives_id;
	}
	public int getClasses() {
		return classes;
	}
	public void setClasses(int classes) {
		this.classes = classes;
	}
	public String getQqNumber() {
		return qqNumber;
	}
	public void setQqNumber(String qqNumber) {
		this.qqNumber = qqNumber;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmergencyContact() {
		return emergencyContact;
	}
	public void setEmergencyContact(String emergencyContact) {
		this.emergencyContact = emergencyContact;
	}
	public String getEmergencyContactPhone() {
		return emergencyContactPhone;
	}
	public void setEmergencyContactPhone(String emergencyContactPhone) {
		this.emergencyContactPhone = emergencyContactPhone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStuState() {
		return stuState;
	}
	public void setStuState(String stuState) {
		this.stuState = stuState;
	}
	public int getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public Archives getArchives() {
		return archives;
	}
	public void setArchives(Archives archives) {
		this.archives = archives;
	}
	
	
	
	
}
