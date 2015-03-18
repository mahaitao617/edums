package com.jsoft.edums.system.controller;

import java.io.PrintWriter;

import java.util.Date;

import java.sql.Timestamp;
import java.util.Date;

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
import com.jsoft.edums.common.util.Const;
import com.jsoft.edums.common.util.Tools;
import com.jsoft.edums.system.entity.Menu;
import com.jsoft.edums.system.entity.User;
import com.jsoft.edums.system.service.MenuService;

@Controller
@RequestMapping(value = "/menu")
public class MenuController extends BaseController {

	@Autowired
	private MenuService menuService;

	/**
	 * <br>
	 * <b>功能：分页显示菜单列表<br>
	 * <b>作者：王利双<br>
	 * <b>日期：2013-11-17 <br>
	 * @param model
	 * @return system/menus
	 *
	 **/
	/*public ModelAndView list(Menu menu, Page page) {
		List<Menu> menuList = menuService.listPageMenu(page);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("system/menus");
		mv.addObject("menuList", menuList);
		mv.addObject("page", page);
		return mv;
	}*/
	/**
	 * <br>
	 * <b>功能：显示菜单列表<br>
	 * <b>作者：王利双<br>
	 * <b>日期：2013-11-17 <br>
	 * @param model
	 * @return system/menus
	 *
	 **/
	@RequestMapping
	public String list(Model model) {
		List<Menu> menuList = menuService.listAllMenu();
		model.addAttribute("menuList", menuList);
		return "system/menus";
	}

	/**
	 * 
	 * <br>
	 * <b>功能：请求新增菜单项<br>
	 * <b>作者：尚忠艳<br>
	 * <b>日期：2013-11-16 <br>
	 * 
	 * @param response
	 * @param startTime
	 * @param endTime
	 * @param chartsName
	 * @param type
	 */

	@RequestMapping(value="/toAdd",method=RequestMethod.GET)
	public String toAdd(Model model){

		List<Menu> menuList = menuService.listAllParentMenu();
		model.addAttribute("menuList", menuList);
		return "system/addmenu";
	}

	/**
	 * 
	 * <br>
	 * <b>功能：在数据库中插入新的菜单项<br>
	 * <b>作者：尚忠艳<br>
	 * <b>日期：2013-11-16 <br>
	 * 
	 * @param response
	 * @param startTime
	 * @param endTime
	 * @param chartsName
	 * @param type
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String toSave(Model model, @RequestParam int parentid,
			@RequestParam String menuName, @RequestParam String linkPath,
			@RequestParam String remark) {
		Menu menu = new Menu();
		menu.setMenuName(menuName);
		menu.setRemark(remark);
		menu.setUrl(linkPath);
		Timestamp ts = new Timestamp(new Date().getTime());
		menu.setBuildTime(ts);

		if (parentid != 0) {
			menu.setFatherId(parentid);
		}

		menuService.saveMenu(menu);
		String s = "保存成功！";
		model.addAttribute("s", s);
		System.err.println("save");
		return "redirect:../menu.html";
	}

	/**
	 * <br>
	 * <b>功能：</b>请求编辑菜单页面<br>
	 * <b>作者：</b>周晨<br>
	 * <b>日期:</b>2014-11-16<br>
	 * 
	 **/
	@RequestMapping(value = "/edit")
	public String toEdit(@RequestParam Integer menuId, Model model) {
		List<Menu> menuList = menuService.listAllMenu();
		model.addAttribute("menuList", menuList);
		Menu menu = menuService.getMenuById(menuId);
		model.addAttribute("menu", menu);
		System.err.println(menu.getFatherId());
		if (menu.getFatherId() != null && menu.getFatherId().intValue() > 0) {
			menu.setParentMenu(menuService.getMenuById(menu.getFatherId()));
		}// 如果menuId的fatherId不为空，就把fatherId对应的菜单对象的集合加入menu中
		return "system/editmenu";
	}

	/**
	 * <br>
	 * <b>功能：</b>接收菜单返回信息页面<br>
	 * <b>作者：</b>周晨<br>
	 * <b>日期:</b>2014-11-16<br>
	 * 
	 * @param menuId
	 * @param menuName
	 * @param menuUrl
	 * @param remark
	 * @param fatherId
	 * @param model 
	 * @return
	 **/
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public ModelAndView Edit(HttpSession session, @RequestParam Integer menuId,
			@RequestParam String menuName, @RequestParam String menuUrl,
			@RequestParam String remark, @RequestParam Integer fatherId) {
		ModelAndView mv = new ModelAndView();
		Menu menu = menuService.getMenuById(menuId);
		menuService.savesMenu(menu,menuId,menuName,menuUrl,remark,fatherId);
		System.err.println("edit");
		
		   mv.setViewName("redirect:../menu.html");
		   return mv;
	}

	/**
	 * 保存菜单信息
	 * 
	 * @param menu
	 * @param model
	 * @return
	 */
	/*
	 * @RequestMapping(value="/save") public String save(Menu menu,Model model){
	 * menuService.saveMenu(menu); model.addAttribute("msg", "success"); return
	 * "system/save_result"; }
	 *//**
	 * 获取当前菜单的所有子菜单
	 * 
	 * @param menuId
	 * @param response
	 */
	/*
	 * @RequestMapping(value="/sub") public void getSub(@RequestParam Integer
	 * menuId,HttpServletResponse response){ List<Menu> subMenu =
	 * menuService.listSubMenuByParentId(menuId); Gson gson = new Gson(); String
	 * menuStr = gson.toJson(subMenu); PrintWriter out; try {
	 * response.setCharacterEncoding("utf-8"); out = response.getWriter();
	 * out.write(menuStr); out.flush(); out.close(); } catch (IOException e) {
	 * 
	 * e.printStackTrace(); } }
	 *//**
	 * 删除菜单 作者：袁鑫 时间：2014-11-16
	 * 
	 * @param menuId
	 * @param out
	 */
	@RequestMapping(value = "deleteMenu")
	public String deleteMenu(@RequestParam Integer menuId, PrintWriter out) {
		menuService.deleteMenuById(menuId);
		/*out.write("success");
		out.flush();
		out.close();*/
		System.err.println("del");
		return "redirect:../menu.html";
	}
}
