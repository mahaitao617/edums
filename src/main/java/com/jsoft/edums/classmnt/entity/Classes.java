package com.jsoft.edums.classmnt.entity;

import java.util.Date;

/**
 * 班级实体类
 * @author 赵开永
 *
 */
public class Classes {
	private Integer classesId;// 实体类classes 的 id
	private Integer classesNo;// 班级编号
	private Date buildTime;// 建班时间
	private Date closeTime;// 封班时间
	private String classesType;// 班级类型，java班，嵌入式等
	private Integer numLimit;// 班级人数限制，默认30
	private Integer buildPerson;// 创建人，user id
	private Integer headerTea;//  班主任 teacher id
	private String describle;//  班级描述
	private String classState;// 班级状态   字典值
	private Integer isDelete;// 1删 0 不删
	
	
	public Integer getClassesId() {
		return classesId;
	}
	public void setClassesId(Integer classesId) {
		this.classesId = classesId;
	}
	public Integer getClassesNo() {
		return classesNo;
	}
	public void setClassesNo(Integer classesNo) {
		this.classesNo = classesNo;
	}
	public Date getBuildTime() {
		return buildTime;
	}
	public void setBuildTime(Date buildTime) {
		this.buildTime = buildTime;
	}
	public Date getCloseTime() {
		return closeTime;
	}
	public void setCloseTime(Date closeTime) {
		this.closeTime = closeTime;
	}
	public String getClassesType() {
		return classesType;
	}
	public void setClassesType(String classesType) {
		this.classesType = classesType;
	}
	public Integer getNumLimit() {
		return numLimit;
	}
	public void setNumLimit(Integer numLimit) {
		this.numLimit = numLimit;
	}
	public Integer getBuildPerson() {
		return buildPerson;
	}
	public void setBuildPerson(Integer buildPerson) {
		this.buildPerson = buildPerson;
	}
	public Integer getHeaderTea() {
		return headerTea;
	}
	public void setHeaderTea(Integer headerTea) {
		this.headerTea = headerTea;
	}
	public String getDescrible() {
		return describle;
	}
	public void setDescrible(String describle) {
		this.describle = describle;
	}
	public String getClassState() {
		return classState;
	}
	public void setClassState(String classState) {
		this.classState = classState;
	}
	public Integer getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	
	public Classes(Integer classesId, Integer classesNo, Date buildTime,
			Date closeTime, String classesType, Integer numLimit,
			Integer buildPerson, Integer headerTea, String describle,
			String classState, Integer isDelete) {
		super();
		this.classesId = classesId;
		this.classesNo = classesNo;
		this.buildTime = buildTime;
		this.closeTime = closeTime;
		this.classesType = classesType;
		this.numLimit = numLimit;
		this.buildPerson = buildPerson;
		this.headerTea = headerTea;
		this.describle = describle;
		this.classState = classState;
		this.isDelete = isDelete;
	}
	
	public Classes() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 用于测试
	 */
	@Override
	public String toString() {
		return "Classes [classesId=" + classesId + ", classesNo=" + classesNo
				+ ", buildTime=" + buildTime + ", closeTime=" + closeTime
				+ ", classesType=" + classesType + ", numLimit=" + numLimit
				+ ", buildPerson=" + buildPerson + ", headerTea=" + headerTea
				+ ", describle=" + describle + ", classState=" + classState
				+ ", isDelete=" + isDelete + "]";
	}
	
}
