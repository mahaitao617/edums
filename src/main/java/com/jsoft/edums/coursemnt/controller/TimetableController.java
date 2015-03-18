package com.jsoft.edums.coursemnt.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.jsoft.edums.base.controller.BaseController;
import com.jsoft.edums.classmnt.entity.Classes;
import com.jsoft.edums.classmnt.service.ClassService;
import com.jsoft.edums.common.util.Const;
import com.jsoft.edums.common.util.Tools;
import com.jsoft.edums.coursemnt.entity.Timetable;
import com.jsoft.edums.coursemnt.service.TimetableService;
import com.jsoft.edums.system.entity.Diction;
import com.jsoft.edums.system.entity.User;
import com.jsoft.edums.system.mapper.DictionMapper;
import com.jsoft.edums.system.service.DictionService;
import com.jsoft.edums.teamnt.entity.Teacher;
import com.jsoft.edums.teamnt.service.TeacherService;

/**
 * 对于排课的controller
 * 
 * @author 李成
 *
 */
@Controller
@RequestMapping(value = "/timetable")
public class TimetableController extends BaseController {
	@Autowired
	private TimetableService timetableService;
	@Autowired
	private DictionService dictionService;
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private ClassService classService;

	/**
	 * <br>
	 * <b>功能：</b>方位排课表首页<br>
	 * <b>作者：</b>李成<br>
	 * <b>日期：</b> 2014-11-16 <br>
	 * 访问登录页 <br>
	 * 
	 * @return 排课表首页
	 */
	@RequestMapping
	public String jumpTimetable(Model model,String givecampus,String givedate) {
		System.err.println("timetable");
		System.err.println("givecampus="+givecampus);
		System.err.println("givedate="+givedate);
		// 查出了本周的课表
		// 第一次进入只显示一个校区就可以了 然后通过ajax让其选择校区
		// 查出所有的校区
		List<Diction> campuses = dictionService.queryByChildId(Const.CAMPUSID);
		for (int i = 0; i < campuses.size(); i++) {
			System.err.println(campuses.get(i).getDictionName());
		}
		// 给出本周的星期一的日期
		Date date = new Date();
				
		// 一开始显示的校区
		Diction campus = campuses.get(0);

		if(givecampus!=null&&givecampus!=""){
			campus = dictionService.queryDictionByChildId(givecampus);
		}
				
		if(givedate!=null&&givedate!=""){
			date = Tools.str2Date(givedate+" 00:00:00");
		}
		
		
	
		// 得到显示校区的所有教室
		List<Diction> rooms = new ArrayList<Diction>();
		if (campuses.size() != 0) {
			rooms = dictionService.queryByFatherName(campus
					.getDictionName());
			for (int i = 0; i < rooms.size(); i++) {
				System.err.println(rooms.get(i).getDictionName());
			}
		}
		// 查出上下午的字典值
		List<Diction> classTimes = dictionService
				.queryByChildId(Const.CLASSTIMEID);
		for (int i = 0; i < classTimes.size(); i++) {
			System.err.println(classTimes.get(i).getDictionName());
		}
		
		List<String> dates = Tools.getAllDateThisWeek(date);
		for (int i = 0; i < dates.size(); i++) {
			System.err.println(dates.get(i));
		}
		List<Timetable> timetables = timetableService.queryByTime(campus.getChildId(), date);
		for (int i = 0; i < timetables.size(); i++) {
			System.err.println(timetables.get(i));
		}
		
		model.addAttribute("campus", campus);
		model.addAttribute("dates", dates);
		model.addAttribute("classTimes", classTimes);
		model.addAttribute("campuses", campuses);
		model.addAttribute("rooms", rooms);
		model.addAttribute("timetables", timetables);
		return "coursemnt/timetable";
	}

	/**
	 * <br>
	 * <b>功能：</b>得到前台ajax传来的时间地点等 判断可以再这个时间地点上课的班级 以及上课<br>
	 * <b>作者：</b>李成<br>
	 * <b>日期：</b> 2014-11-19 <br>
	 * 
	 * <br>
	 * 
	 * @return JSON 字符串
	 */
	@RequestMapping(value = "/dataCanArrang")
	public void saveAuth(@RequestParam String campus,
			@RequestParam String classTime, @RequestParam String classroom,
			@RequestParam String date, PrintWriter out) {
		System.err.println("campus=" + campus);
		System.err.println("classTime=" + classTime);
		System.err.println("classroom=" + classroom);
		System.err.println("date=" + date);
		Diction campusDiction = dictionService.queryByDictionName(campus);
		Diction classTimeDiction = dictionService.queryByDictionName(classTime);
		Diction classroomDiction = dictionService.queryByDictionName(classroom);

		// 返回所有的教师
		List<Teacher> teachers = teacherService.queryTea(new Teacher());
		for (int i = 0; i < teachers.size(); i++) {
			System.err.println("allteacher" + teachers.get(i).getTeaName());
		}

		// 返回所有的班级
		List<Classes> classes = classService.queryAllClass();
		for (int i = 0; i < classes.size(); i++) {
			System.err.println("allclasses" + classes.get(i).getClassesNo());
		}
		// 返回所有的在这个时间段的所有的课程项 只要这个老师班级在这个时间断没有课就可以给这个老师班级安排课程
		List<Timetable> timetables = timetableService.queryTimetableByTime(
				classTimeDiction.getChildId(), date);
		// 得到这个时间段可以上课的老师和班级
		timetableService.removeTeacher(timetables, teachers);
		timetableService.removeClass(timetables, classes);
		// 将teacher 和classes 放到一个List里面
		List<List> objects = new ArrayList<List>();
		objects.add(teachers);
		objects.add(classes);
		// 现在得到了选中的这个框的时间和地点 然后该得到在这个时间地点可以上课的班级和老师？？或者还需不需要可以上的课程
		Gson gson = new Gson();
		String object = gson.toJson(objects);
		out.write(object);
		// 所谓的这个 教师可以在这个时间地点可以上课 也就是说 教师在这个时间没有授课就行 给一个教师名 和一个时间
		// 查出来的所有的课程项中的老师都排除 就可以得到所有的可以排课的老师
		// 然后就是 老师 课程 和 班级 都是有一个授课类型来对应的吧 选择一个老师后 选择的班级就会变成他可以教的班级
		// 然后选择的课程就应该变成他们可以上的课程吧
		// 一步一步ajax实现 是可以实现 遗留的问题就是老师 课程 班级 之间的关系究竟是什么样的
		out.close();
	}

	/**
	 * <br>
	 * <b>功能：</b>方位排课表首页<br>
	 * <b>作者：</b>李成<br>
	 * <b>日期：</b> 2014-11-16 <br>
	 * 访问登录页 <br>
	 * 
	 * @return 排课表首页
	 */
	@RequestMapping(value = "save")
	public String saveTimetable(@RequestParam String timetableId,
			@RequestParam String campus, @RequestParam String classroom,
			@RequestParam String date, @RequestParam String classTime,
			@RequestParam String teacher, @RequestParam String classes,
			@RequestParam String remark,HttpSession session, Model model) {
		System.err.println("timetable="+timetableId);
		
		System.err.println("campus="+campus);
		System.err.println("classroom="+classroom);
		System.err.println("date="+date);
		System.err.println("classTime="+classTime);
		System.err.println("teacher="+teacher);
		System.err.println("classes="+classes);
		System.err.println("remark="+remark);
		System.err.println("save timetable");
		//开始保存 如果timetableId 为空 则新增一条 否则修改原来的记录
		//得到校区字典
		Diction campusDiction = dictionService.queryByDictionName(campus);
		//得到上课时间字典
		Diction classTimeDiction = dictionService.queryByDictionName(classTime);
		//得到教室字典
		Diction classroomDiction = dictionService.queryByDictionName(classroom);
		timetableService.saveTimetable(timetableId, campusDiction.getChildId(), classroomDiction.getChildId(), date, classTimeDiction.getChildId(), teacher, classes, remark,((User)session.getAttribute(Const.SESSION_USER)).getUserId() );
		
		return "redirect:../timetable.html?givecampus="+campusDiction.getChildId()+"&givedate="+date;
	}

}
