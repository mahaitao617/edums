package com.jsoft.edums.system.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsoft.edums.base.service.BaseService;
import com.jsoft.edums.common.entity.Page;
import com.jsoft.edums.system.entity.Menu;
import com.jsoft.edums.system.entity.User;
import com.jsoft.edums.system.mapper.MenuMapper;
import com.jsoft.edums.system.service.MenuService;
/**
 * 菜单的service实现类
 * @author 李成
 *
 */
@Service
public class MenuServiceImpl extends BaseService implements MenuService {

	@Autowired
	private MenuMapper menuMapper;//菜单的dao
	/**
	 * *  <br>
	 * <b>功能：</b>得到所有菜单<br>
	 * <b>作者：</b>李成<br>
	 * <b>日期：</b> 2014-11-16 <br>
	 * 
	 * 返回所有的菜单
	 * @return
	 */
	public List<Menu> listAllParentMenu() {

		return menuMapper.listAllParentMenu();
	}
	/**
	 * *  <br>
	 * <b>功能：</b>得到所有一级菜单<br>
	 * <b>作者：</b>李成<br>
	 * <b>日期：</b> 2014-11-16 <br>
	 * 访问登录页
	 * 得到所有的一级菜单 也就是父菜单
	 * @return
	 */
	public List<Menu> listSubMenuByParentId(Integer parentId) {

		return menuMapper.listSubMenuByParentId(parentId);
	}

	/**
	 * *  <br>
	 * <b>功能：</b>根据父类惨淡得到所有子菜单<br>
	 * <b>作者：</b>李成<br>
	 * <b>日期：</b> 2014-11-16 <br>
	 * 
	 * 根据父菜单得到所有的字级菜单
	 * @param parentId
	 * @return
	 */
	public List<Menu> listAllMenu() {

		List<Menu> rl = this.listAllParentMenu();
		for (Menu menu : rl) {
			List<Menu> subList = this.listSubMenuByParentId(menu.getMenuId());
			menu.setSubMenu(subList);
		}
		return rl;
	}
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
	public List<Menu> getAllMenuThatCanView(List<Integer> menuIds) {
		List<Menu> AllFather = listAllParentMenu();
		for (int i = 0; i < AllFather.size(); i++) {
			System.out.println(AllFather.get(i).getMenuName());
		}
		List<Menu> menus = getMenuByListId(menuIds);
		for (int i = 0; i < AllFather.size(); i++) {
			Menu fatherMenu = AllFather.get(i);
			for (int j = 0; j < menus.size(); j++) {
				Menu menu = menus.get(j);
				if (fatherMenu.getMenuId() == menu.getFatherId()) {
					fatherMenu.getSubMenu().add(menu);
				}

			}
		}
		for (int i = 0; i < AllFather.size(); i++) {
			if (AllFather.get(i).getSubMenu().size() == 0) {
				AllFather.remove(i);
				i--;
			}
		}
		return AllFather;
	}
	/**
	 *  *  <br>
	 * <b>功能：</b>根据给定的menuId集合得到一个菜单对象的集合<br>
	 * <b>作者：</b>李成<br>
	 * <b>日期：</b> 2014-11-16 <br>
	 * 
	 * 根据给定的menuId集合得到一个菜单对象的集合
	 * @return
	 */
	public List<Menu> getMenuByListId(List<Integer> menuIds){
		List<Menu> menus = new ArrayList<Menu>();
		for (int i = 0; i < menuIds.size(); i++) {
			Menu menu = getMenuById(menuIds.get(i));
			menus.add(menu);
		}
		return menus;
	}
	/**
	 *  *  <br>
	 * <b>功能：</b>列举所有的子类菜单<br>
	 * <b>作者：</b>李成<br>
	 * <b>日期：</b> 2014-11-16 <br>
	 * 列举所有的子类菜单
	 * @return
	 */
	public void ListAllStillAt(List<Integer> menuIds) {
		for (int i = 0; i < menuIds.size(); i++) {
			if(menuMapper.getMenuById(menuIds.get(i))==null){
				menuIds.remove(i);
				i--;
			}
		}
		
	}

	public void deleteMenuById(Integer menuId) {

		menuMapper.deleteMenuById(menuId);
	}

	public Menu getMenuById(Integer menuId) {

		return menuMapper.getMenuById(menuId);
	}

	public void saveMenu(Menu menu) {
		if (menu.getMenuId() != null && menu.getMenuId().intValue() > 0) {

			menuMapper.updateMenu(menu);
		} else {
			menuMapper.insertMenu(menu);
		}
	}

	public List<Menu> listAllSubMenu() {
		return menuMapper.listAllSubMenu();
	}
	/**
	 * <br>
	 * <b>功能：</b>根据page 返回当前页的所有的menu<br>
	 * <b>作者：</b>王利双<br>
	 * <b>日期：</b> 2014-11-17 <br>
	 * @param page
	 * @return List<Menu>
	 */
	public List<Menu> listPageMenu(Page page) {
		// TODO Auto-generated method stub
		List<Menu> rl = menuMapper.listPageMenu(page);
		for (Menu menu : rl) {
			List<Menu> subList = this.listSubMenuByParentId(menu.getMenuId());
			menu.setSubMenu(subList);
		}
		return rl;
	}
	/**
	 *  *  <br>
	 * <b>功能：</b>保存修改的菜单项<br>
	 * <b>作者：</b>周晨<br>
	 * <b>日期：</b> 2014-11-21 <br>
	 * 
	 * @return
	 */
	public void savesMenu(Menu menu, Integer menuId, String menuName,
			String menuUrl, String remark, Integer fatherId) {
		if (menu.getFatherId() != null && menu.getFatherId().intValue() > 0) {
			menu.setMenuName(menuName);
			menu.setFatherId(fatherId);
			menu.setUrl(menuUrl);
			menu.setBuildTime(new Date());
			menu.setRemark(remark);
		} else {
			menu.setMenuName(menuName);
			menu.setRemark(remark);
			menu.setBuildTime(new Date());
		}
		menuMapper.updateMenu(menu);
	}


}
