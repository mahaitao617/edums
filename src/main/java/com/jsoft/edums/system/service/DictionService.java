package com.jsoft.edums.system.service;

import java.util.List;

import com.jsoft.edums.system.entity.Diction;

/**
 * 对字典操作的service
 * @author 李成
 *
 */
public interface DictionService {
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
	 * <b>功能：</b>根据childId 获得字典值<br>
	 * <b>作者：</b>李成<br>
	 * <b>日期：</b>2014-11-21 <br>
	 * <br>
	 * @param 
	 * @return 
	 */
	public Diction queryDictionByChildId(String childId) ;
	/**
	 * <br>
	 * <b>功能：</b>根据Id 获得字典值<br>
	 * <b>作者：</b>李成<br>
	 * <b>日期：</b>2014-11-21 <br>
	 * <br>
	 * @param 
	 * @return 所有子类字典的集合
	 */
	public Diction queryDictionById(Integer dictionId);
	/**
	 * *  <br>
	 * <b>功能：</b>得到所有父类字典<br>
	 * <b>作者：</b>周晨<br>
	 * <b>日期：</b> 2014-11-18 <br>
	 * @return
	 */
	List<Diction> listAllParentDiction();
    
	/**
	 * *  <br>
	 * <b>功能：</b>保存字典项<br>
	 * <b>作者：</b>周晨<br>
	 * <b>日期：</b> 2014-11-18 <br>
	 * @param describle 
	 * @param dictionName 
	 * @param fatherId 
	 * @return
	 */
	void saveDiction(Diction diction, String fatherId, String dictionName, String describle);
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
    String selectMaxId(Diction diction);


	/**
	 * <br>
	 * <b>功能：</b>根据父类字典的id 查出所有的子类字典<br>
	 * <b>作者：</b>李成<br>
	 * <b>日期：</b>2014-11-19 <br>
	 * <br>
	 * @param fatherid
	 * @return 所有子类字典的集合
	 */
	List<Diction> queryByChildId(String fatherId);
	
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
	 * <b>功能：</b>保存对字典项的修改<br>
	 * <b>作者：</b>尚忠艳<br>
	 * <b>日期：</b>2014-11-21 <br>
	 * <br>
	 * @param 
	 * @return 
	 */
	public void saveEdit(String childId,String fatherName,String dictionName,String remark);

}
