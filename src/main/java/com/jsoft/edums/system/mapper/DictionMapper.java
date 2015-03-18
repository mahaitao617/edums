package com.jsoft.edums.system.mapper;

import java.util.List;

import com.jsoft.edums.common.annotation.MyBatisDao;
import com.jsoft.edums.system.entity.Diction;

/**
 * 对数据库字典的操作
 * @author 李成
 *
 */
@MyBatisDao
public interface DictionMapper {

	/**
	 * <br>
	 * <b>功能：</b>根据父类字典的名 查出所有的子类字典<br>
	 * <b>作者：</b>李成<br>
	 * <b>日期：</b>2014-11-18 <br>
	 * <br>
	 * @param fatherName
	 * @return 所有子类字典的集合
	 */
	public List<Diction> queryByFatherName(String fatherName);
	/**
	 * <br>
	 * <b>功能：</b>根据字典的Id查出该字典项<br>
	 * <b>作者：</b>尚忠艳<br>
	 * <b>日期：</b>2014-11-21 <br>
	 * <br>
	 * @param dictionId
	 * @return diction
	 */
	public Diction queryById(int dictionId);

	

	/**
	 * <br>
	 * <b>功能：</b>根据字典的名 查出所有的字典<br>
	 * <b>作者：</b>李成<br>
	 * <b>日期：</b>2014-11-20 <br>
	 * <br>
	 * @param dictionName
	 * @return 
	 */
	public Diction queryByDictionName(String dictionName);

	/**
	 * <br>
	 * <b>功能：</b>查询出字典表中的所有父类字典， 也就是没有父字典的字典<br>
	 * <b>作者：</b>周晨<br>
	 * <b>日期：</b>2014-11-18 <br>
	 * <br>
	 *@return 所有没有父字典的字典集合
	 */
	 List<Diction> listAllParentDiction();
	 /**
		 * <br>
		 * <b>功能：</b>插入字典项<br>
		 * <b>作者：</b>周晨<br>
		 * <b>日期：</b>2014-11-18 <br>
		 * <br>
		 */
	 void insertDiciton(Diction diction);
	 /**
		 * <br>
		 * <b>功能：</b>更新字典项<br>
		 * <b>作者：</b>周晨<br>
		 * <b>日期：</b>2014-11-18 <br>
		 * <br>
		 */
	 void updateDiction(Diction diction);
	 /**
		 * *  <br>
		 * <b>功能：</b>查找当前字典表中父字典最大childId<br>
		 * <b>功能：</b>查找当前字典表中某一父字典最大childId<br>
		 * <b>作者：</b>周晨<br>
		 * <b>日期：</b> 2014-11-19 <br>
		 * 如果增加的是父字典，则找查找当前字典表中父字典最大fatherId
		 * 如果增加的是子字典，则找查找当前字典表中其父字典最大childId
		 * @return
		 */

	 String selectMaxChildId(Diction diction);
	 String selectMaxFatherId();

	List<Diction> queryByDiction(Diction diction);
	

}
