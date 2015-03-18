package com.jsoft.edums.system.controller;

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

import com.google.gson.Gson;
import com.jsoft.edums.base.controller.BaseController;
import com.jsoft.edums.common.util.Const;
import com.jsoft.edums.common.util.RightsHelper;
import com.jsoft.edums.common.util.Tools;
import com.jsoft.edums.system.entity.Menu;
import com.jsoft.edums.system.entity.Role;
import com.jsoft.edums.system.entity.User;
import com.jsoft.edums.system.service.CompetenceService;
import com.jsoft.edums.system.service.MenuService;
import com.jsoft.edums.system.service.UserService;

/**
 * 登录的各种操作
 * @author 李成
 *
 */
@Controller
public class LoginController extends BaseController {

	@Autowired
	private UserService userService;
	@Autowired
	private MenuService menuService;
	@Autowired
	private CompetenceService competenceSevice;
	/**
	 *  <br>
	 * <b>功能：</b>访问登录页<br>
	 * <b>作者：</b>李成<br>
	 * <b>日期：</b> 2014-11-16 <br>
	 * 访问登录页
	 * <br>
	 * @return 登录页面
	 */
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String loginGet(){
		return "system/login";
	}
	/*@RequestMapping(value="/add")
	public String loginGet1(){
		return "system/users";
	}*/
	/**
	 *  <br>
	 * <b>功能：</b>登录验证 <br>
	 * <b>作者：</b>李成<br>
	 * <b>日期：</b> 2014-11-16 <br>
	 * 请求登录，验证用户
	 * @param session
	 * @param loginname
	 * @param password
	 * @param code 验证码
	 * @return 成功去显示主页的方法 失败返回登录的页面
	 */
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView loginPost(HttpSession session,@RequestParam String loginname,@RequestParam String password,@RequestParam String code){
		System.err.println("asese");
		System.err.println(userService+"=userService");
		System.err.println(menuService+"=menuService");
		String sessionCode = (String)session.getAttribute(Const.SESSION_SECURITY_CODE);
		ModelAndView mv = new ModelAndView();
		String errInfo = "";
		if(Tools.notEmpty(sessionCode) && sessionCode.equalsIgnoreCase(code)){
			User user = userService.getUserByNameAndPwd(loginname, password);
			if(user!=null){
				user.setLastLogTime(new Date());
				userService.updateLastLogin(user);
				session.setAttribute(Const.SESSION_USER, user);
				session.removeAttribute(Const.SESSION_SECURITY_CODE);
			}else{
				errInfo = "用户名或密码有误！";
			}
		}else{
			errInfo = "验证码输入有误！";
		}
		if(Tools.isEmpty(errInfo)){
			
			mv.setViewName("redirect:index.html");
			/*mv.setViewName("system/index");*/
		}else{
			System.err.println(errInfo);
			mv.addObject("errInfo", errInfo);
			mv.addObject("loginname",loginname);
			mv.addObject("password",password);
			mv.setViewName("system/login");
		}
		return mv;
	}
	
	/**
	 * 访问系统首页
	 * @param session
	 * @param model
	 * @return
	 */
	/*@RequestMapping(value="/index")
	public String index(HttpSession session,Model model){
		System.err.println("index");
		User user = (User)session.getAttribute(Const.SESSION_USER);
		user = userService.getUserAndRoleById(user.getUserId());
		Role role = user.getRole();
		String roleRights = role!=null ? role.getRights() : "";
		String userRights = user.getRights();
		//避免每次拦截用户操作时查询数据库，以下将用户所属角色权限、用户权限限都存入session
		session.setAttribute(Const.SESSION_ROLE_RIGHTS, roleRights); //将角色权限存入session
		session.setAttribute(Const.SESSION_USER_RIGHTS, userRights); //将用户权限存入session
		
		List<Menu> menuList = menuService.listAllMenu();
		if(Tools.notEmpty(userRights) || Tools.notEmpty(roleRights)){
			for(Menu menu : menuList){
				menu.setHasMenu(RightsHelper.testRights(userRights, menu.getMenuId()) || RightsHelper.testRights(roleRights, menu.getMenuId()));
				if(menu.isHasMenu()){
					List<Menu> subMenuList = menu.getSubMenu();
					for(Menu sub : subMenuList){
						sub.setHasMenu(RightsHelper.testRights(userRights, sub.getMenuId()) || RightsHelper.testRights(roleRights, sub.getMenuId()));
					}
				}
			}
		}
		model.addAttribute("user", user);
		model.addAttribute("menuList", menuList);
		return "system/index";
	}*/
	/**
	 *  <br>
	 * <b>功能：</b>访问主页的方法 取出显示的菜单<br>
	 * <b>作者：</b>李成<br>
	 * <b>日期：</b> 2014-11-16 <br>
	 * 访问系统首页 
	 * @param session
	 * @param model
	 * @return 返回到主页
	 */
	@RequestMapping(value="/index")
	public String index(HttpSession session,Model model){
		System.err.println("index");
		//登录完毕 得到session中存储的user对象 session中放的user名 是放在const.SESSION_USER中的
		User user = (User)session.getAttribute(Const.SESSION_USER);
		//根据user中存储的roleId 可以在competence中找到他所能访问的menuId 从而得到这个用户可以访问的菜单
		List<Integer> menuIds = competenceSevice.getAllMenuId(user.getRoleId());
		for (int i = 0; i < menuIds.size(); i++) {
			System.err.println(menuIds.get(i));
		}
		//得到所有的并且没有删除的menuId
		menuService.ListAllStillAt(menuIds);
		
		//将用户可以访问的菜单id组合放到session中
		session.setAttribute(Const.ROLE_MENU_ID,Tools.getStringByList(menuIds));
		//开始根据list<Integer> 中存放的menuId得到所有的菜单对象
		List<Menu> menus = menuService.getAllMenuThatCanView(menuIds);
		for (int i = 0; i < menus.size(); i++) {
			System.err.println(menus.get(i).getMenuName());
		}
		Gson gson = new Gson();
		String menuStr = gson.toJson(menus);
		System.err.println(menuStr);
		model.addAttribute("menuStr", menuStr);
		return "system/index";
	}
	
	/**
	 *  <br>
	 * <b>功能：</b>取得默认页面的菜单<br>
	 * <b>作者：</b>李成<br>
	 * <b>日期：</b> 2014-11-16 <br>
	 * 进入首页后范文的默认页面的默认页面
	 * @return 主页的默认页面
	 */
	@RequestMapping(value="/default")
	public String defaultPage(){
		return "default";
	}
	
	/**
	 *  <br>
	 * <b>功能：</b>登出注销页面<br>
	 * <b>作者：</b>李成<br>
	 * <b>日期：</b> 2014-11-16 <br>
	 * 用户注销 用户退出
	 * @param session
	 * @return 返回到登录页面
	 */
	@RequestMapping(value="/logout")
	public String logout(HttpSession session){
		session.removeAttribute(Const.SESSION_USER);
	/*	session.removeAttribute(Const.SESSION_ROLE_RIGHTS);
		session.removeAttribute(Const.SESSION_USER_RIGHTS);*/
		return "system/login";
	}
}
