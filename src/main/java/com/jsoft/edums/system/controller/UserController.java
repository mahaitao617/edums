package com.jsoft.edums.system.controller;

import java.io.PrintWriter;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.jsoft.edums.base.controller.BaseController;
import com.jsoft.edums.common.entity.Page;
import com.jsoft.edums.common.util.RightsHelper;
import com.jsoft.edums.common.util.Tools;
import com.jsoft.edums.common.view.UserExcelView;
import com.jsoft.edums.system.entity.Menu;
import com.jsoft.edums.system.entity.Role;
import com.jsoft.edums.system.entity.User;
import com.jsoft.edums.system.service.MenuService;
import com.jsoft.edums.system.service.RoleService;
import com.jsoft.edums.system.service.UserService;

@Controller
@RequestMapping(value="/user")
public class UserController extends BaseController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private MenuService menuService;
	
	/**
	 * 显示用户列表
	 * @param user
	 * @return
	 */
	@RequestMapping
	public ModelAndView list(User user,Page page){
		//List<User> userList = userService.listAllUser(page);
	/*	List<User> userList = userService.listPageUser(user);
		List<Role> roleList = roleService.listAllRoles();*/
		List<User> userList = userService.listPageUser(page);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("system/users");
		mv.addObject("userList", userList);
		mv.addObject("page", page);
/*		mv.addObject("userList", userList);
		mv.addObject("roleList", roleList);
		mv.addObject("user", user);*/
		return mv;
	}
	
	/**
	 * 请求新增用户页面
	 * @param model
	 * @return
	 */
	/*@RequestMapping(value="/add")
	public String toAdd(Model model){
		System.err.println("to add");
		List<Role> roleList = roleService.listAllRoles();
		model.addAttribute("roleList", roleList);
		return "system/user_info";
	}
	*/
	/**
	 * 保存用户信息
	 * @param user
	 * @return
	 */
	/*@RequestMapping(value="/save",method=RequestMethod.POST)
	public ModelAndView saveUser(User user){
		ModelAndView mv = new ModelAndView();
		if(user.getUserId()==null || user.getUserId().intValue()==0){
			if(userService.insertUser(user)==false){
				mv.addObject("msg","failed");
			}else{
				mv.addObject("msg","success");
			}
		}else{
			userService.updateUserBaseInfo(user);
		}
		mv.setViewName("system/save_result");
		return mv;
	}*/
	
	/**
	 * 请求编辑用户页面
	 * @param userId
	 * @return
	 */
	/*@RequestMapping(value="/edit")
	public ModelAndView toEdit(@RequestParam int userId){
		ModelAndView mv = new ModelAndView();
		User user = userService.getUserById(userId);
		List<Role> roleList = roleService.listAllRoles();
		mv.addObject("user", user);
		mv.addObject("roleList", roleList);
		mv.setViewName("system/user_info");
		return mv;
	}*/
	
	/**
	 * 删除某个用户
	 * @param userId
	 * @param out
	 */
	/*@RequestMapping(value="/delete")
	public void deleteUser(@RequestParam int userId,PrintWriter out){
		userService.deleteUser(userId);
		out.write("success");
		out.close();
	}*/
	
	/**
	 * 请求用户授权页面
	 * @param userId
	 * @param model
	 * @return
	 */
	/*@RequestMapping(value="/auth")
	public String auth(@RequestParam int userId,Model model){
		List<Menu> menuList = menuService.listAllMenu();
		User user = userService.getUserById(userId);
		String userRights = user.getRights();
		if(Tools.notEmpty(userRights)){
			for(Menu menu : menuList){
				menu.setHasMenu(RightsHelper.testRights(userRights, menu.getMenuId()));
				if(menu.isHasMenu()){
					List<Menu> subRightsList = menu.getSubMenu();
					for(Menu sub : subRightsList){
						sub.setHasMenu(RightsHelper.testRights(userRights, sub.getMenuId()));
					}
				}
			}
		}
		Gson gson = new Gson();
		String menuStr = gson.toJson(menuList);
		menuStr = menuStr.replaceAll("menuId", "id").replaceAll("menuName", "name").replaceAll("subMenu", "nodes").replaceAll("hasMenu", "checked");
		model.addAttribute("zTreeNodes", menuStr);
		model.addAttribute("userId", userId);
		return "system/authorization";
	}*/
	
	/**
	 * 保存用户权限
	 * @param userId
	 * @param menuIds
	 * @param out
	 */
	/*@RequestMapping(value="/auth/save")
	public void saveAuth(@RequestParam int userId,@RequestParam String menuIds,PrintWriter out){
		BigInteger rights = RightsHelper.sumRights(Tools.str2StrArray(menuIds));
		User user = userService.getUserById(userId);
		user.setRights(rights.toString());
		userService.updateUserRights(user);
		out.write("success");
		out.close();
	}*/
	
	/**
	 * 导出用户信息到excel
	 * @return
	 */
	/*@RequestMapping(value="/excel")
	public ModelAndView export2Excel(){
		Map<String,Object> dataMap = new HashMap<String,Object>();
		List<String> titles = new ArrayList<String>();
		titles.add("用户名");
		titles.add("名称");
		titles.add("角色");
		titles.add("最近登录");
		dataMap.put("titles", titles);
		List<User> userList = userService.listAllUser();
		dataMap.put("userList", userList);
		UserExcelView erv = new UserExcelView();
		ModelAndView mv = new ModelAndView(erv,dataMap);
		return mv;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format,true));
	}*/
}
