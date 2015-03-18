package com.jsoft.edums.stumnt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jsoft.edums.common.entity.Page;
import com.jsoft.edums.stumnt.service.TestMapperService;

@Controller
public class TestMapperController {
	
	@Autowired
	private TestMapperService testMapperService;
	
	@RequestMapping(value="/testmapper",method=RequestMethod.GET)
	public String testmapper(Page page){
		testMapperService.test(page);
		return "student/testmapper";
	}
}
