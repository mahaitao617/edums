package com.jsoft.edums.stumnt.controller;

import java.util.List;




import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jsoft.edums.base.controller.BaseController;
import com.jsoft.edums.stumnt.entity.Stuinfo;
import com.jsoft.edums.stumnt.service.StuinfoService;
import com.jsoft.edums.system.service.CompetenceService;
import com.jsoft.edums.system.service.MenuService;
import com.jsoft.edums.system.service.UserService;
@Controller
@RequestMapping(value="/stuInfo")
public class stuInfoController extends BaseController{

	@Autowired
	private UserService userService;
	@Autowired
	private MenuService menuService;
	@Autowired
	private CompetenceService competenceSevice;
	@Autowired
	private StuinfoService stuinfoService;
	
	/**
	 * 访问学生信息管理页
	 * @return stuInfo/query.jsp
	 */
	@RequestMapping(value="",method=RequestMethod.GET)
	public String enterStuInfo(){
		return "student/stuInfo/manage";
	}
	/**
	 * 访问学生信息查询页
	 * @return stuInfo/query.jsp
	 */
	@RequestMapping(value="/queryStuInfo",method=RequestMethod.GET)
	public String queryStuInfo(){
		return "student/stuInfo/query";
	}
	/**
	 * 按姓名查询学生信息
	 * 
	 * @param session
	 * @param stuName
	 * @return
	 */

	@RequestMapping(value = "/queryStuInfoByName", method = RequestMethod.GET)
	public ModelAndView queryStuInfoByName(HttpSession session,
			@RequestParam String stuName) {
		ModelAndView mv = new ModelAndView();
		List<Stuinfo> stuinfoList = stuinfoService.listStuinfoByName(stuName);
		if (stuinfoList.size() == 0) {			
			mv.addObject("result", "0");
		} else {
			boolean showTable=true;
			mv.addObject("showTable", showTable);
			mv.addObject("stuinfoList", stuinfoList);
		}
		mv.setViewName("student/stuInfo/query");
		return mv;
	}
	/**
	 * 按学号显示学生详细信息
	 * @param session
	 * @param stuNo
	 * @return
	 */
	@RequestMapping(value = "/showDetailStuInfoByStuNo", method = RequestMethod.GET)
	public ModelAndView showDetailStuInfoByStuNo(HttpSession session,
			@RequestParam String stuNo) {
		ModelAndView mv = new ModelAndView();
		Stuinfo stuinfo=stuinfoService.getStuinfoByStuNo(stuNo);
		mv.addObject("stuinfo",stuinfo);
		mv.setViewName("student/stuInfo/showDetail");
		return mv;
	}
	/**
	 * 按学号查询学生信息
	 * @param session
	 * @param stuNo
	 * @return
	 */
	@RequestMapping(value="/queryStuInfoByStuNo",method=RequestMethod.GET)
	public ModelAndView getStuInfoByStuNo(HttpSession session,@RequestParam String stuNo){
	System.out.println("getStuInfoByStuNo");
		ModelAndView mv = new ModelAndView();
		Stuinfo stuinfo=stuinfoService.getStuinfoByStuNo(stuNo);
		
		boolean warns;
			if(stuinfo==null){
				mv.addObject("result", "0");
				
			}else{
				 warns=true;	
			mv.addObject("stuinfo",stuinfo);
			mv.addObject("showTable",warns);
			}
			mv.setViewName("student/stuInfo/query");
		
		return mv;
	}
	/**
	 * 查询条件分类
	 * @param session
	 * @param condition
	 * @return
	 */
	@RequestMapping(value="/queryStuInfoByCondition",method=RequestMethod.GET)
	public ModelAndView queryStuInfoByCondition(HttpSession session,@RequestParam String condition){
		
		boolean flag=stuinfoService.isNumeric(condition);
		
		if(flag==true){
			
			
	        return new ModelAndView("redirect:/stuInfo/queryStuInfoByStuNo.html?stuNo="+condition);

			
		}else{
			
			return new ModelAndView("redirect:/stuInfo/queryStuInfoByName.html").addObject("stuName",condition);
		}
		
	}
	
}
