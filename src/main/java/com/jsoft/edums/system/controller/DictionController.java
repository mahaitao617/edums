package com.jsoft.edums.system.controller;



import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.jsoft.edums.base.controller.BaseController;
import com.jsoft.edums.system.entity.Diction;
import com.jsoft.edums.system.service.DictionService;


/**
 * 字段的controller
 * @author 李成
 *
 */
@Controller
@RequestMapping(value="/diction")
public class DictionController extends BaseController{

	
	

	@Autowired
	private DictionService dictionService;
	/**
	 * <br>
	 * <b>功能：测试字典表<br>
	 * <b>作者：周晨<br>
	 * <b>日期：2013-11-18 <br>
	 * @param model
	 * @return system/dictionmenus
	 *
	 **/	
	@RequestMapping
	public String list(Model model) {
		
		return "system/dictionmenus";
	}






	/**
	 * 
	 * <br>
	 * <b>功能：请求新增字典项<br>
	 * <b>作者：周晨<br>
	 * <b>日期：2013-11-18 <br>
	 * 
	 * @param model
	 * @return system/adddiction
	 */
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String toAdd(Model model){
		List<Diction> dictionList=dictionService.listAllParentDiction();
		model.addAttribute("dictionList",dictionList );
		return "system/adddiction";
	}
	
	/**
	 * 
	 * <br>
	 * <b>功能：在数据库中插入新的字典项<br>
	 * <b>作者：周晨<br>
	 * <b>日期：2013-11-18 <br>
	 * 
	 * @param model
	 * @param fatherId
	 * @param dictionName
	 * @param describle
	 * return system/adddiction
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String toSave(Model model, @RequestParam String fatherId,
			@RequestParam String dictionName,@RequestParam String describle) {
		Diction diction = new Diction();
		dictionService.saveDiction(diction,fatherId,dictionName,describle);
		String s = "保存成功！";
		model.addAttribute("s", s);
		return "system/adddiction";
	}
	/**
	 * 跳到字典的编辑页面
	 * @author 尚忠艳
	 *
	 */
@RequestMapping(value="/toEdit", method = RequestMethod.GET)
public String toEdit(@RequestParam String childId,Model model){
	
	Diction diction=dictionService.queryDictionByChildId(childId);
	
	if(diction.getFatherId()==null){
		
	}else{
		
		Diction father=dictionService.queryDictionByChildId(diction.getFatherId());
		model.addAttribute("father",father);
	}
	
	model.addAttribute("diction",diction);
	return "system/editdiction";
	}
/**
 * 保存对字典项的修改
 * @author 尚忠艳
 *
 */
@RequestMapping(value="/saveEdit", method = RequestMethod.POST)
public String saveEdit(Model model,@RequestParam String childId,@RequestParam String fatherName,@RequestParam String dictionName,@RequestParam String remark){
		
	dictionService.saveEdit(childId, fatherName, dictionName, remark);
	String s="保存成功！";
	model.addAttribute("s",s);
	return "system/editdiction";
}
}
