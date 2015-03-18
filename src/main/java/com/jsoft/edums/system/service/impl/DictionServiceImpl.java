package com.jsoft.edums.system.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsoft.edums.system.entity.Diction;
import com.jsoft.edums.system.mapper.DictionMapper;
import com.jsoft.edums.system.service.DictionService;

/**
 * 字典service 实现类
 * @author 李成
 *
 */
@Service
public class DictionServiceImpl implements DictionService{
	@Autowired
	private DictionMapper dictionMapper;
	/**
	 * <br>
	 * <b>功能：</b>根据父类字典的名 查出所有的子类字典<br>
	 * <b>作者：</b>李成<br>
	 * <b>日期：</b>2014-11-18 <br>
	 * <br>
	 * @param fatherName
	 * @return 所有子类字典的集合
	 */
	public List<Diction> queryByFatherName(String fatherName) {
		return dictionMapper.queryByFatherName(fatherName);
	}

	
	/**
	 * *  <br>
	 * <b>功能：</b>得到所有父类字典<br>
	 * <b>作者：</b>周晨<br>
	 * <b>日期：</b> 2014-11-18 <br>
	 * @return
	 */
	public List<Diction> listAllParentDiction() {
		return dictionMapper.listAllParentDiction();
	}
	/**
	 * *  <br>
	 * <b>功能：</b>查找当前字典表中父字典最大childId<br>
	 * <b>功能：</b>查找当前字典表中某一父字典最大childId<br>
	 * <b>作者：</b>周晨<br>
	 * <b>日期：</b> 2014-11-19 <br>
	 * 如果增加的是父字典，则找查找当前字典表中父字典最大fatherId
	 * 如果增加的是子字典，则找查找当前字典表中其父字典最大childId
	 * @return 
	 * @return
	 */
	public String selectMaxId(Diction diction) {
		if(diction.getFatherId()!=null){
			return dictionMapper.selectMaxChildId(diction);
		}else{
			return dictionMapper.selectMaxFatherId();
		}
		
	}

	

	/**
	 * <br>
	 * <b>功能：</b>根据父类字典的id 查出所有的子类字典<br>
	 * <b>作者：</b>李成<br>
	 * <b>日期：</b>2014-11-19 <br>
	 * <br>
	 * @param fatherid
	 * @return 所有子类字典的集合
	 */
	public List<Diction> queryByChildId(String fatherId) {
		Diction diction = new Diction();
		diction.setFatherId(fatherId);
		return dictionMapper.queryByDiction(diction);
	}
	
	/**
	 * <br>
	 * <b>功能：</b>根据childId 获得字典值<br>
	 * <b>作者：</b>李成<br>
	 * <b>日期：</b>2014-11-21 <br>
	 * <br>
	 * @param 
	 * @return 所有子类字典的集合
	 */
	public Diction queryDictionByChildId(String childId) {
		Diction diction = new Diction();
		diction.setChildId(childId);
		if(dictionMapper.queryByDiction(diction).size()>0){
			return dictionMapper.queryByDiction(diction).get(0);
		}else{
			return null;
		}
		
	}
	/**
	 * <br>
	 * <b>功能：</b>根据Id 获得字典值<br>
	 * <b>作者：</b>李成<br>
	 * <b>日期：</b>2014-11-21 <br>
	 * <br>
	 * @param 
	 * @return 
	 */
	public Diction queryDictionById(Integer dictionId) {
		Diction diction = new Diction();
		diction.setDictionId(dictionId);
		if(dictionMapper.queryByDiction(diction).size()>0){
			return dictionMapper.queryByDiction(diction).get(0);
		}else{
			return null;
		}
	}

	/**
	 * <br>
	 * <b>功能：</b>根据字典的名 查出所有的字典<br>
	 * <b>作者：</b>李成<br>
	 * <b>日期：</b>2014-11-20 <br>
	 * <br>
	 * @param dictionName
	 * @return 
	 */
	public Diction queryByDictionName(String dictionName){
		return dictionMapper.queryByDictionName(dictionName);
	}

	/**
	 * *  <br>
	 * <b>功能：</b>保存字典项<br>
	 * <b>作者：</b>周晨<br>
	 * <b>日期：</b> 2014-11-18 <br>
	 * @return
	 */
	public void saveDiction(Diction diction, String fatherId,
			String dictionName, String describle) {
		diction.setDictionName(dictionName);
		diction.setDescrible(describle);
		diction.setBuildTime(new Date());
		if ("a".equals(fatherId)) { //fatherId 为空
			fatherId=null;
			diction.setFatherId(fatherId);
			diction.setChildId(selectMaxId(diction));
		}else{    //fatherId不 为空
			diction.setFatherId(fatherId);
			diction.setChildId(selectMaxId(diction));
		}
		dictionMapper.insertDiciton(diction);
	}
	/**
	 * *  <br>
	 * <b>功能：</b>保存对字典项的修改<br>
	 * <b>作者：</b>尚忠艳<br>
	 * <b>日期：</b> 2014-11-21 <br>
	 * @return
	 */
	public void saveEdit(String childId,String fatherName,String dictionName,String remark) {
		
		Diction diction=new Diction();
		Diction father=new Diction();
		if("".equals(fatherName)){
			
			
		}else{
			father=queryByDictionName(fatherName);
			diction.setFatherId(father.getChildId());
		}
		diction.setChildId(childId);
		diction.setDictionName(dictionName);
		diction.setDescrible(remark);
		diction.setBuildTime(new Date());
		dictionMapper.updateDiction(diction);
	}

	

}
