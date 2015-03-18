package com.jsoft.edums.system.entity;

import java.util.Date;
import java.util.List;

/**
 * 字典实体
 * @author 李成
 *
 */
public class Diction {
	private int dictionId;//id
	private String childId;//子类id
	private String fatherId;//父类id
	private String dictionName;//字典名
	private String describle;//描述
	private Date buildTime;//创建时间
	private int isDelete;//是否删除
	
	
	private List<Diction> subDiction;//子类字典
	private Diction fatherDiction;//父类字典值
	
	public List<Diction> getSubDiction() {
		return subDiction;
	}
	public void setSubDiction(List<Diction> subDiction) {
		this.subDiction = subDiction;
	}
	public Diction getFatherDiction() {
		return fatherDiction;
	}
	public void setFatherDiction(Diction fatherDiction) {
		this.fatherDiction = fatherDiction;
	}
	public int getDictionId() {
		return dictionId;
	}
	public void setDictionId(int dictionId) {
		this.dictionId = dictionId;
	}
	public String getChildId() {
		return childId;
	}
	public void setChildId(String childId) {
		this.childId = childId;
	}
	public String getFatherId() {
		return fatherId;
	}
	public void setFatherId(String fatherId) {
		this.fatherId = fatherId;
	}
	public String getDictionName() {
		return dictionName;
	}
	public void setDictionName(String dictionName) {
		this.dictionName = dictionName;
	}
	public String getDescrible() {
		return describle;
	}
	public void setDescrible(String describle) {
		this.describle = describle;
	}
	public Date getBuildTime() {
		return buildTime;
	}
	public void setBuildTime(Date buildTime) {
		this.buildTime = buildTime;
	}
	public int getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
	
	
}
