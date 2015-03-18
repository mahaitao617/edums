package com.jsoft.edums.classmnt.mapper;

import com.jsoft.edums.common.annotation.MyBatisDao;
import com.jsoft.edums.stumnt.entity.Stuinfo;

@MyBatisDao
public interface ChangeClassMapper {
	
	/**
	 * 
	 * @param std
	 * @param common
	 * @param oldClassNo
	 */
	void changeClass(Stuinfo std,String common,int oldClassNo);

}
