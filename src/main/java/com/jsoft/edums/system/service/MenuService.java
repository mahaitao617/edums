package com.jsoft.edums.system.service;

import java.util.List;

import com.jsoft.edums.common.entity.Page;
import com.jsoft.edums.system.entity.Menu;
import com.jsoft.edums.system.entity.User;


/**
 * 对于菜单的service操作
 * @author 李成
 *
 */

public interface MenuService {
	/**
	 * <br>
	 * <b>功能：</b>根据page 返回当前页的所有的menu<br>
	 * <b>作者：</b>王利双<br>
	 * <b>日期：</b> 2014-11-17 <br>
	 * @param page
	 * @return List<Menu>
	 */
	public List<Menu> listPageMenu(Page page);
	/**
	 * *  <br>
	 * <b>功能：</b>得到所有菜单<br>
	 * <b>作者：</b>李成<br>
	 * <b>日期：</b> 2014-11-16 <br>
	 * 
	 * 返回所有的菜单
	 * @return
	 */
	List<Menu> listAllMenu();
	/**
	 *   <br>
	 * <b>功能：</b>根据一个角色的Id 返回所有的可以访问的菜单的id<br>
	 * <b>作者：</b>李成<br>
	 * <b>日期：</b> 2014-11-16 <br>
	 * 根据一个角色的Id 返回所有的可以访问的菜单的id 
	 * @param role_id
	 * @return
	 */
	List<Menu> listAllParentMenu();
	/**
	 * *  <br>
	 * <b>功能：</b>得到所有一级菜单<br>
	 * <b>作者：</b>李成<br>
	 * <b>日期：</b> 2014-11-16 <br>
	 * 访问登录页
	 * 得到所有的一级菜单 也就是父菜单
	 * @return
	 */
	List<Menu> listSubMenuByParentId(Integer parentId);
	/**
	 * *  <br>
	 * <b>功能：</b>根据父类菜单得到所有子菜单<br>
	 * <b>作者：</b>李成<br>
	 * <b>日期：</b> 2014-11-16 <br>
	 * 
	 * 根据父菜单得到所有的字级菜单
	 * @param parentId
	 * @return
	 */
	List<Menu> getAllMenuThatCanView(List<Integer> menus);
	/**
	 * *  <br>
	 * <b>功能：</b>根据给定的menuId集合 符合这个集合的所有菜单<br>
	 * <b>作者：</b>李成<br>
	 * <b>日期：</b> 2014-11-16 <br>
	 * 
	 * 根据给定的menuId集合 符合这个集合的所有菜单
	 * @param menus
	 * @return
	 */
	public List<Menu> getMenuByListId(List<Integer> menus);
	/**
	 *  *  <br>
	 * <b>功能：</b>根据给定的menuId集合得到一个菜单对象的集合<br>
	 * <b>作者：</b>李成<br>
	 * <b>日期：</b> 2014-11-16 <br>
	 * 
	 * 根据给定的menuId集合得到一个菜单对象的集合
	 * @return
	 */
	List<Menu> listAllSubMenu();
	/**
	 *  *  <br>
	 * <b>功能：</b>列举所有的子类菜单<br>
	 * <b>作者：</b>李成<br>
	 * <b>日期：</b> 2014-11-16 <br>
	 * 列举所有的子类菜单
	 * @return
	 */
	public void ListAllStillAt(List<Integer> menuIds);
	
	/*
	 * 等待修正
	 */
	Menu getMenuById(Integer menuId);
	void saveMenu(Menu menu);
	void deleteMenuById(Integer menuId);
	/**
	 *  *  <br>
	 * <b>功能：</b>保存修改的菜单项<br>
	 * <b>作者：</b>周晨<br>
	 * <b>日期：</b> 2014-11-21 <br>
	 * 
	 * @return
	 */
    void savesMenu(Menu menu, Integer menuId, String menuName,
			String menuUrl, String remark, Integer fatherId);
	
}
