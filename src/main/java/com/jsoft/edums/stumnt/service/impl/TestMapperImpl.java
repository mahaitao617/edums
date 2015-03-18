package com.jsoft.edums.stumnt.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsoft.edums.base.service.BaseService;
import com.jsoft.edums.common.entity.Page;
import com.jsoft.edums.stumnt.entity.Archives;
import com.jsoft.edums.stumnt.entity.Stuinfo;
import com.jsoft.edums.stumnt.mapper.ArchivesMapper;
import com.jsoft.edums.stumnt.mapper.StuinfoMapper;
import com.jsoft.edums.stumnt.service.TestMapperService;

@Service
public class TestMapperImpl extends BaseService implements TestMapperService {
	@Autowired
	private ArchivesMapper archivesMapper;
	@Autowired
	private StuinfoMapper stuinfoMapper;

	
	public String test(Page page){
		System.out.println("!test");
		
		//List<Stuinfo> st=stuinfoMapper.listPageStuinfo(page);
		//System.out.println(st.isEmpty());
		Stuinfo st1=stuinfoMapper.getStuinfoByStuNo("1");
		System.out.println(st1.getArchives_id());
		System.out.println(st1.getEmail());
		System.out.println(st1.getArchives().getStuName());
//		List<Archives> stu= archivesMapper.listPageArchives(page);
//		Archives stu1 =archivesMapper.getArchivesByArchivesNo("1");
//		Archives stu2 =archivesMapper.getArchivesByStuName("qwe");
//		List<Archives> stu3 =archivesMapper.listArchivesByStuName("w");
//		System.out.println(stu1.getStuName());
//		System.out.println(stu2.getStuName());
//		System.out.println(stu3.isEmpty());
//		System.out.println(stu.isEmpty());
		return null;
	}
}
