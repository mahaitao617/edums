package com.jsoft.edums.stumnt.mapper;

import java.util.List;

import com.jsoft.edums.common.annotation.MyBatisDao;
import com.jsoft.edums.common.entity.Page;
import com.jsoft.edums.stumnt.entity.Archives;

@MyBatisDao
public interface ArchivesMapper {
	/**
	 * 利用它的分页工具进行分页查询 所有的Archives对象
	 * @param page
	 * @return List<Archives>
	 */
	public List<Archives> listPageArchives(Page page);
	/**
	 * 根据archivesNo 得到一个Archives的具体信息
	 * @param String
	 * @return Archives
	 */
	Archives getArchivesByArchivesNo(String archivesNo);
	/**
	 * 根据stuName 得到一个Archives的具体信息
	 * @param String
	 * @return Archives
	 */
	Archives getArchivesByStuName(String stuName);
	/**
	 * 模糊查询
	 * 根据stuName的一部分 得到一些Archives的具体信息
	 * @param String
	 * @return Archives
	 */
	List<Archives> listArchivesByStuName(String stuName);

}
