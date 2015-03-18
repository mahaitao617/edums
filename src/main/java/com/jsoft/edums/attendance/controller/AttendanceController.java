package com.jsoft.edums.attendance.controller;

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

import com.jsoft.edums.attendance.entity.AttendanceRecords;
import com.jsoft.edums.attendance.service.AttendanceService;
import com.jsoft.edums.base.controller.BaseController;
import com.jsoft.edums.common.entity.Page;
import com.jsoft.edums.stumnt.entity.Stuinfo;
import com.jsoft.edums.system.entity.Diction;
import com.jsoft.edums.system.service.DictionService;


@Controller
@RequestMapping(value="/attendance")
public class AttendanceController extends BaseController{
	
	@Autowired
	private AttendanceService attendanceService;
	@Autowired
	private DictionService dictionService;
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String save(Model model,@RequestParam String tempString){
		System.out.println("save");
		long saveResult=attendanceService.insertAttendance(tempString);
		System.out.println("添加"+saveResult+"行");
		model.addAttribute("tempString",tempString);
		return "redirect:showClass.html";
	}
	

	@RequestMapping(value="/showClass",method=RequestMethod.GET)
	public ModelAndView showClass(){
		List<Stuinfo> stuList=new ArrayList<Stuinfo>();
		Stuinfo stu1=new Stuinfo();
		Stuinfo stu2=new Stuinfo();
		Stuinfo stu3=new Stuinfo();
		Stuinfo stu4=new Stuinfo();
		Stuinfo stu5=new Stuinfo();
		stu1.setStuInfoId(1);
		stu2.setStuInfoId(2);
		stu3.setStuInfoId(3);
		stu4.setStuInfoId(4);
		stu5.setStuInfoId(5);
		stu1.setStuNo("stu1");
		stu2.setStuNo("stu2");
		stu3.setStuNo("stu3");
		stu4.setStuNo("stu4");
		stu5.setStuNo("stu5");
		stuList.add(stu1);
		stuList.add(stu2);
		stuList.add(stu3);
		stuList.add(stu4);
		stuList.add(stu5);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("attendance/attAdd");
		mv.addObject("stuList",stuList);
		return mv;
	}
	
	@RequestMapping(value="/listRequiredAttendance",method=RequestMethod.POST)
	public ModelAndView listRequiredAttendance(HttpSession session,@RequestParam String requiredInfo , Page page ){  // 根据条件查询出勤记录
		System.err.println();
		ModelAndView mv = new ModelAndView();	
		List<AttendanceRecords> attendanceRecords = attendanceService.listRequiredAttendance(requiredInfo , page);
		mv.addObject("attendanceRecords", attendanceRecords);
		mv.setViewName("attendance/attMain");
		return mv;
	}
	
	@RequestMapping
	public ModelAndView firstJumpInto(Page page ){
		System.err.println();
		// 第一次跳入 默认查询所有
		ModelAndView mv = new ModelAndView();	
		List<AttendanceRecords> attendanceRecords = attendanceService.listAttendanceRecordsAll(page);
		
		for(AttendanceRecords a : attendanceRecords){
			a.setARState(this.dictionService.queryDictionByChildId(a.getARState()).getDictionName());
			a.getTimetable().setClassroom(this.dictionService.queryDictionByChildId(a.getTimetable().getClassroom()).getDictionName());
		}
		
		mv.addObject("attendanceRecords", attendanceRecords);
		mv.addObject("page", page);
		mv.setViewName("attendance/attMain");
		return mv;
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(@RequestParam int ARId,@RequestParam String ARState,@RequestParam String leaveReason){
		System.err.println("进入了controller的update");
		attendanceService.updateAttendanceById(ARId, ARState, leaveReason);
		return "redirect:../attendance.html";//这里必须../，因为要先跳出这个controller，再进来
	}

	
	@RequestMapping(value="/findSingle",method=RequestMethod.GET)
	public ModelAndView findSingle(@RequestParam int ARId){
		ModelAndView mv = new ModelAndView();	
		System.err.println("进入了controller的findSingle");
		AttendanceRecords attendanceRecordsLs=attendanceService.findSingle(ARId);
		List<Diction> ARStateLs=attendanceService.findARStates();
		mv.addObject("attendanceRecordsLs", attendanceRecordsLs);
		mv.addObject("ARStateLs", ARStateLs);
		mv.setViewName("attendance/attUpdate");
		return mv;
	}
	
}
