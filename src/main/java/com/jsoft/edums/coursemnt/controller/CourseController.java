package com.jsoft.edums.coursemnt.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsoft.edums.base.controller.BaseController;
import com.jsoft.edums.common.entity.Page;
import com.jsoft.edums.coursemnt.entity.CourseInfo;
import com.jsoft.edums.coursemnt.service.CourseService;
import com.jsoft.edums.system.entity.Diction;

@Controller
@RequestMapping(value="/course")
public class CourseController extends BaseController {
	@Autowired
	private CourseService courseService;


	
	/**
	 * 批量增加课程
	 * */
	/**
	 * 功能：增加单个课程
	 * 作者:车波
	 * 日期:2014-11-16
	 * @param no 课程编号
	 * @param name 课程名称
	 * @param hour 课时
	 * @param describle 课程描述
	 * @param type 课程类型
	 * @param state 课程状态
	 * 方法已测试，正确
	 * @
	 * */
	@RequestMapping
	public String welcomeGet()
	{
		System.err.println("课程管理的welcome页面");
		return "coursemnt/welcome";
	}
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String insertCourse(@RequestParam String no,@RequestParam String name,@RequestParam String courseHour,@RequestParam String describe,@RequestParam String type,@RequestParam String state,Page page,Model model){
	   System.err.println("no"+no);
	   System.err.println("name"+name);
	   System.err.println("courseHour"+courseHour);
	   System.err.println("describe"+describe);
	   System.err.println("type"+type);
	   System.err.println("state"+state);
		courseService.insertCourse(no, name, courseHour, describe, type,state);
		List<CourseInfo> courseList=courseService.queryCourse(page);
		model.addAttribute("courseList", courseList);
		model.addAttribute("page",page);
		return "coursemnt/query";
	}
	/**
	 * 删除若干门课程,然后返回queryCourse页面，显示现在的课程信息列表
	 * 作者:车波
	 * 日期:2014-11-16
	 * @param 若干门课程的id集合
	 * 方法已测试，但是在删除若干的课程的时候，jsp传来的参数需要改变
	 * */
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String deleteCourse(@RequestParam String courseId,Page page,Model model){
		System.err.println(" hello deleteCourse");
		List <Integer>temp=new ArrayList();
		temp.add(10001);
		temp.add(10002);
		if(courseId!="")
		{
			temp.add(Integer.parseInt(courseId));
		}
	
		System.err.println("courseId" +temp.size());
		courseService.deleteCourse(temp);
		System.err.println("delete next query");
		List<CourseInfo> courseList=courseService.queryCourse(page);
		model.addAttribute("courseList", courseList);
		model.addAttribute("page",page);
		return "coursemnt/query";
	}
	/**
	 * 作者:车波
	 * 日期:2014-11-16
	 * 更改某门课程的信息
	 * 有待修改，批量修改课程信息，例如批量修改课程所属的类别，课时等等
	 * 方法未测试
	 * */
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String updateCourse(@RequestParam String Id,@RequestParam String no,@RequestParam String name,@RequestParam String hour,@RequestParam String describle,@RequestParam String type,@RequestParam String state){
		
		courseService.updateCourse( Id,no, name, hour, describle, type, state);
		return "coursemnt/second";
	}
	/**
	 * 查询所有的课程
	 * 作者：车波
	 * 日期:2014-11-16
	 * 方法已测试，正确，但没有往前台传递结果集合
	 * */
	@RequestMapping(value="/queryAll",method=RequestMethod.GET)
	public String queryCourse(Page page,Model model){
		List<CourseInfo> courseList=courseService.queryCourse(page);
		//ModelAndView mv=new ModelAndView();
		System.err.println("queryAll123345");
		
		
		System.err.println(courseList.size());
		//mv.setViewName("coursemnt/second");
				//mv.addObject("page",page);
				//mv.addObject("courseList",courseList);
	//return mv;
		model.addAttribute("courseList", courseList);
		model.addAttribute("page",page);
		return "coursemnt/query";
	}
	/**
	 * 按条件查询课程表
	 * 作者:车波
	 * 日期:2014-11-16
	 * @param courseId课程id
	 * @param courseName课程名称
	 * @param courseType课程类别
	 * @param courseState课程状态
	 * @param key关键字
	 * 方法未测试
	 * */
	@RequestMapping(value="/queryByParams",method=RequestMethod.GET)
	public ModelAndView queryCourseByParams(@RequestParam String courseNo,@RequestParam String courseName,@RequestParam String courseType,@RequestParam String courseState,Page page){
		List<CourseInfo> courseList=courseService.queryCourseByParams( courseNo, courseName, courseType,courseState,  page);
		ModelAndView mv=new ModelAndView();
		System.err.println("courseNo"+courseNo);
		System.err.println("courseName"+courseName);
		System.err.println("courseType"+courseType);
		System.err.println("courseState"+courseState);
		
		System.err.println("courseList.size()"+courseList.size());
		mv.setViewName("coursemnt/second");
		mv.addObject("page",page);
		mv.addObject("courseList",courseList);
	return mv;
	}
	/**
	 * 模糊查询
	 * 作者:车波
	 * 日期:2014-11-21
	 * 方法未测试
	 * 
	 * */
	@RequestMapping(value="/queryByKeys",method=RequestMethod.GET)
	public ModelAndView queryCourseByKeys(@RequestParam String key,Page page){
		List<CourseInfo> courseList=courseService.queryCourseByKeys(  key, page);
		ModelAndView mv=new ModelAndView();
		System.err.println("key"+key);
		System.err.println("courseList.size()"+courseList.size());
		mv.setViewName("coursemnt/query");
		mv.addObject("page",page);
		mv.addObject("courseList",courseList);
	return mv;
	}
	/**
	 * 查询课程的具体信息
	 * 作者:车波
	 * 日期:2014-11-16
	 * 方法已测试，正确
	 * */
	@RequestMapping(value="/queryOneInfo",method=RequestMethod.GET)
	public ModelAndView queryCourseById(@RequestParam String courseNo){
		CourseInfo courseInfo=courseService.queryCourseById(courseNo);
		ModelAndView mv=new ModelAndView();
		System.err.println("queryOneInfo");
		System.err.println("courseNo" +courseNo);
		mv.setViewName("coursemnt/second");
		mv.addObject("courseInfo",courseInfo);
	return mv;
	}
	/**
	 * 跳转到增加课程的页面
	 * 作者:车波
	 * 日期：2014-11-21
	 * */
	@RequestMapping(value="/addCourse",method=RequestMethod.GET)
	public String toAddJsp()
	{
		System.err.println("课程管理的add页面");
		return "coursemnt/add";
	}
	
}
