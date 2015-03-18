package com.jsoft.edums.stumnt.entity;

import java.util.List;

import com.jsoft.edums.system.entity.Diction;

/**
 * 查询学生档案的条件的下拉选项的 所有值 
 * @author 夏瑀
 *
 */
public class ArchivesQueryDropDownMenu {
	
	private List<Diction> sex;
	private List<String> classes;
	private List<Diction> classtype;
	private List<Diction> university;
	private List<Diction> college;
	private List<Diction> nation;
	private List<Diction> major;
	private List<Diction> stustate;
	private List<Diction> archivesstate;
	
	public List<Diction> getSex() {
		return sex;
	}
	public void setSex(List<Diction> sex) {
		this.sex = sex;
	}
	public List<String> getClasses() {
		return classes;
	}
	public void setClasses(List<String> classes) {
		this.classes = classes;
	}
	public List<Diction> getClasstype() {
		return classtype;
	}
	public void setClasstype(List<Diction> classtype) {
		this.classtype = classtype;
	}
	public List<Diction> getUniversity() {
		return university;
	}
	public void setUniversity(List<Diction> university) {
		this.university = university;
	}
	public List<Diction> getCollege() {
		return college;
	}
	public void setCollege(List<Diction> college) {
		this.college = college;
	}
	public List<Diction> getNation() {
		return nation;
	}
	public void setNation(List<Diction> nation) {
		this.nation = nation;
	}
	public List<Diction> getMajor() {
		return major;
	}
	public void setMajor(List<Diction> major) {
		this.major = major;
	}
	public List<Diction> getStustate() {
		return stustate;
	}
	public void setStustate(List<Diction> stustate) {
		this.stustate = stustate;
	}
	public List<Diction> getArchivesstate() {
		return archivesstate;
	}
	public void setArchivesstate(List<Diction> archivesstate) {
		this.archivesstate = archivesstate;
	}
	
	
}