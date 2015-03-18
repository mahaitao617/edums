package com.jsoft.edums.stumnt.service;

import org.springframework.stereotype.Service;

import com.jsoft.edums.stumnt.entity.ArchivesQueryDropDownMenu;

public interface ArchivesService {
	/**
	 *  <br>
	 * <b>功能：</b>获取所需字典值<br>
	 * <b>作者：</b>夏瑀<br>
	 * <b>日期：</b> 2014-11-20 <br>
	 * 获取所需查询学生档案的条件的 可选项 
	 * @param String
	 * @return
	 */
	public ArchivesQueryDropDownMenu getDiction();
}
