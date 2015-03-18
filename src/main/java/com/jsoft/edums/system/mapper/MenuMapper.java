package com.jsoft.edums.system.mapper;

import java.util.List;

import com.jsoft.edums.common.annotation.MyBatisDao;
import com.jsoft.edums.common.entity.Page;
import com.jsoft.edums.system.entity.Menu;
import com.jsoft.edums.system.entity.User;
/**
 * 对菜单数据表的各种操作
 * @author 李成
 *
 */
@MyBatisDao
public interface MenuMapper {
	/**
	 * 利用它的分页工具进行分页查询 所有的menu对象
	 * @param page
	 * @return
	 */
	public List<Menu> listPageMenu(Page page);
	/**
	 * 查询出菜单表中的所有一级菜单 也就是没有父菜单的菜单
	 * @return 所有没有父菜单的菜单集合
	 */
	List<Menu> listAllParentMenu();
	/**
	 * 根据父菜单 得到其所有的子菜单
	 * @param fatherId
	 * @return 所有字菜单的集合
	 */
	List<Menu> listSubMenuByParentId(Integer fatherId);
	/**
	 * 根据给定的menuId 得到一个Menu的对象
	 * @param menuId
	 * @return
	 */
	Menu getMenuById(Integer menuId);
	
	

	/*
	 * 等待修正
	 */
	void insertMenu(Menu menu);
	void updateMenu(Menu menu);
	void deleteMenuById(Integer menuId);
	List<Menu> listAllSubMenu();
}
