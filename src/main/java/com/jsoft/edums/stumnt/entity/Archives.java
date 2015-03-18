package com.jsoft.edums.stumnt.entity;

import java.util.Date;

import com.jsoft.edums.common.entity.Page;

public class Archives {
	
	private int archivesId; //主键
	private String archivesNo; //档案号
	private String stuName; //姓名
	private String sex; // 性别
	private String IDCardNo; // 身份证号
	private String university;// 学校
	private String college;//学院
	private String major; //专业
	private Date inTime; //入学时间
	private Date buildTime; //入党时间
	private String politicalAffilation; //政治面貌
	private String eduBackground; //教育背景
	private String englishLevel; // 英语水平
	private String nation; //籍贯
	private String birthplace; //出生地
	private String photo;// 照片
	private String address;// 家庭住址
	private String archivesState; //档案状态
	private int isDelete; //是否被删除
	private Page page;
	
	/**
	 * 
	 * 以下是set get方法
	 * @return 
	 */
	public int getArchivesId() {
		return archivesId;
	}
	public void setArchivesId(int archivesId) {
		this.archivesId = archivesId;
	}
	public String getArchivesNo() {
		return archivesNo;
	}
	public void setArchivesNo(String archivesNo) {
		this.archivesNo = archivesNo;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getIDCardNo() {
		return IDCardNo;
	}
	public void setIDCardNo(String iDCardNo) {
		IDCardNo = iDCardNo;
	}
	public String getUniversity() {
		return university;
	}
	public void setUniversity(String university) {
		this.university = university;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public Date getInTime() {
		return inTime;
	}
	public void setInTime(Date inTime) {
		this.inTime = inTime;
	}
	public Date getBuildTime() {
		return buildTime;
	}
	public void setBuildTime(Date buildTime) {
		this.buildTime = buildTime;
	}
	public String getPoliticalAffilation() {
		return politicalAffilation;
	}
	public void setPoliticalAffilation(String politicalAffilation) {
		this.politicalAffilation = politicalAffilation;
	}
	public String getEduBackground() {
		return eduBackground;
	}
	public void setEduBackground(String eduBackground) {
		this.eduBackground = eduBackground;
	}
	public String getEnglishLevel() {
		return englishLevel;
	}
	public void setEnglishLevel(String englishLevel) {
		this.englishLevel = englishLevel;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getBirthplace() {
		return birthplace;
	}
	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getArchivesState() {
		return archivesState;
	}
	public void setArchivesState(String archivesState) {
		this.archivesState = archivesState;
	}
	public int getisDelete() {
		return isDelete;
	}
	public void setisDelete(int isDelete) {
		this.isDelete = isDelete;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	
	
	

}
