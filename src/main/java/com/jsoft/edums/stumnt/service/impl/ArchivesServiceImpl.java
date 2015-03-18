package com.jsoft.edums.stumnt.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsoft.edums.base.service.BaseService;
import com.jsoft.edums.classmnt.entity.Classes;
import com.jsoft.edums.classmnt.mapper.ClassMapper;
import com.jsoft.edums.stumnt.entity.ArchivesQueryDropDownMenu;
import com.jsoft.edums.stumnt.mapper.ArchivesMapper;
import com.jsoft.edums.stumnt.service.ArchivesService;
import com.jsoft.edums.system.entity.Diction;
import com.jsoft.edums.system.mapper.DictionMapper;
import com.jsoft.edums.system.service.DictionService;
/**
 * 对于service 的所有实现
 * @author 夏瑀
 *
 */
@Service
public class ArchivesServiceImpl extends BaseService implements ArchivesService{
	@Autowired
	private ArchivesMapper archivesMapper;
	@Autowired
	private DictionMapper dictMapper;
	@Autowired
	private ClassMapper classMapper;
	@Autowired
	private DictionService dictionService;

	public ArchivesQueryDropDownMenu getDiction(){
		ArchivesQueryDropDownMenu aqddm=new ArchivesQueryDropDownMenu();
		aqddm.setSex(dictMapper.queryByFatherName("性别"));
		System.err.println(dictionService.queryByFatherName("学校"));
		aqddm.setClasstype(dictMapper.queryByFatherName("班级类型"));
		aqddm.setUniversity(dictMapper.queryByFatherName("学校"));
		aqddm.setCollege(dictMapper.queryByFatherName("学院"));
		aqddm.setMajor(dictMapper.queryByFatherName("专业"));
		aqddm.setNation(dictMapper.queryByFatherName("民族"));
		aqddm.setStustate(dictMapper.queryByFatherName("学生状态"));
		
		aqddm.setArchivesstate(dictMapper.queryByFatherName("档案状态"));
		List<Classes> classes =classMapper.queryAll();
		List<String> classname=new ArrayList();
		for (Classes classes2 : classes) {
			Diction diction= dictionService.queryDictionByChildId(classes2.getClassesType());
			classname.add(diction.getDictionName()+classes2.getClassesNo()+"班");
		}//得到型如 JAVA19班这样的班级名称
		aqddm.setClasses(classname);
		return aqddm;
	}
}
