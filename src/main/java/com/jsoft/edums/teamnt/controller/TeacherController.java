package com.jsoft.edums.teamnt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsoft.edums.base.controller.BaseController;
import com.jsoft.edums.common.entity.Page;
import com.jsoft.edums.system.entity.Diction;
import com.jsoft.edums.system.service.DictionService;
import com.jsoft.edums.teamnt.entity.Teacher;
import com.jsoft.edums.teamnt.service.TeacherService;
/**
 * 
 * @author 何聪
 *
 */
@Controller
@RequestMapping(value="/teacher")
public class TeacherController extends BaseController {

	@Autowired
	private TeacherService teaService;
	@Autowired
	private DictionService dicService;

	/**
	 * 教师的修改功能 传入教师类，跳转到教师查找功能（未完成）
	 * 教师查找功能已写完
	 * */
	@RequestMapping(value = "/teacher")
	public ModelAndView list(Teacher tea, Page page) {
		teaService.updateTea(tea);
		return queryTeacher(tea);
	}

	/**
	 * 跳转到页面上，填写增加教师信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/addTeacher1")
	public ModelAndView addTea() {
		ModelAndView mv=new ModelAndView();
		List<Diction> sex=dicService.queryByFatherName("性别");
		List<Diction> teaLevel=dicService.queryByFatherName("教师等级");
		List<Diction> teaState=dicService.queryByFatherName("教师状态");
        mv.addObject("sex",sex);
        mv.addObject("teaLevel",teaLevel);
        mv.addObject("teaState",teaState);
        mv.setViewName("teacher/addTea");
		return mv;

	}
	/**
	 * 教师查询
	 * @param tea 教师的各种条件，在界面上填入
	 * @return 按条件查询的教师信息
	 */
	@RequestMapping(value = "/teacherIndex")
	public ModelAndView queryTeacher(Teacher tea) {
		System.out.println("**********");
		System.out.println(tea.getTeaNo());
		System.out.println("********");
		checkTea(tea);
		List<Teacher> teachers = teaService.queryTea(tea);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("teacher/index");
		mv.addObject("teachers", teachers);
		mv.addObject("page", tea.getPage());
		return mv;
	}

	/**
	 * 增加教师
	 * @param courseId
	 * @param sex
	 * @param specialty
	 * @param teaLevel
	 * @param teaName
	 * @param teaState
	 * @param telephone
	 * @return
	 */
	@RequestMapping(value = "/addTeacher2")
	public String addTea(@RequestParam Integer courseId,
			@RequestParam String sex, @RequestParam String specialty,
			@RequestParam String teaLevel, @RequestParam String teaName,
			@RequestParam String teaState, @RequestParam String telephone) {

		teaService.insertTeacher(courseId, sex, specialty, teaLevel, teaName,
				teaState, telephone);
		return "system/index";
	}

	/**
	 * 跳转到页面，填写要删除的教师
	 * 
	 * @return
	 */
	@RequestMapping(value = "/delete_1")
	public String deleteTea() {

		return "teacher/deleteTea";
	}

	/**
	 * 教师删除
	 * 
	 * @param teaNo
	 * @return
	 */
	@RequestMapping(value = "/delete_2")
	public String deleteTea(@RequestParam String teaNo) {
		teaService.deleteTeacher(teaNo);
		return "system/index";
	}
	/**
	 * 按条件查询，将未填写部分设置为空
	 * @param tea 条件
	 */
	private void checkTea(Teacher tea){
		if("".equals(tea.getTeaNo())){
			tea.setTeaNo(null);
		}
		if("".equals(tea.getTeaName())){
			tea.setTeaName(null);
		}
		if("".equals(tea.getSex())){
			tea.setSex(null);
		}
		if("".equals(tea.getSpecialty())){
			tea.setSpecialty(null);
		}
		if("".equals(tea.getTelephone())){
			tea.setTelephone(null);
		}
		if("".equals(tea.getTeaLevel())){
			tea.setTeaLevel(null);
		}
		if("".equals(tea.getTeaState())){
			tea.setTeaState(null);
		}
	}
}
