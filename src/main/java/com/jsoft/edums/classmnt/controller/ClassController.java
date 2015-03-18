package com.jsoft.edums.classmnt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jsoft.edums.base.controller.BaseController;
import com.jsoft.edums.classmnt.entity.Classes;
import com.jsoft.edums.classmnt.service.ClassService;
import com.jsoft.edums.common.entity.Page;


/**
 * 班级controller继承BaseController
 * @author 赵开永
 *
 */
@Controller
@RequestMapping(value="/class")
public class ClassController extends BaseController{
	@Autowired
	private ClassService ClassService;
	
	/**
	 * 查询所有的班级
	 * @param page 用于分页
	 * @return ModelAndView
	 */
	@RequestMapping(value="/queryAll", method=RequestMethod.GET)
	public ModelAndView quertAll(Page page){
		List<Classes> classList = ClassService.listPageClasses(page);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("classmnt/welcome");
		mv.addObject("page", page);
		mv.addObject("classList", classList);
		for (Classes classes : classList) {
			System.err.println(classes.toString() );
		}
		System.err.println(page);
		return mv;
	}
	
	@RequestMapping(value="/welcome")
	public ModelAndView welcome(Page page){
		List<Classes> classList = ClassService.listPageClasses(page);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("classmnt/welcome");
		mv.addObject("page", page);
		mv.addObject("classList", classList);
		for (Classes classes : classList){// 输出所有的班级对象到控制台，便于测试
			System.err.println(classes);
		}
		return mv;
	}
}
