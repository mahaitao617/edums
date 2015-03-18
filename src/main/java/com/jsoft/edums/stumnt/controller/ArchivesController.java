package com.jsoft.edums.stumnt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jsoft.edums.base.controller.BaseController;
import com.jsoft.edums.common.entity.Page;
import com.jsoft.edums.stumnt.entity.ArchivesQueryDropDownMenu;
import com.jsoft.edums.stumnt.service.ArchivesService;
import com.jsoft.edums.system.entity.User;

@Controller
public class ArchivesController extends BaseController{
	@Autowired
	private ArchivesService archivesService;
	
	@RequestMapping(value="/archives")
	public ModelAndView query(Page page){
		ArchivesQueryDropDownMenu aqqddm= archivesService.getDiction();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("student/archives/query");
		mv.addObject("MenuList", aqqddm);
		mv.addObject("page", page);
		return mv;
	}
}
