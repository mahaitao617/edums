package com.jsoft.edums.system.service;

import java.util.List;

import com.jsoft.edums.system.entity.Competence;
/**
 * 对于权限关系的service操作
 * @author 李成
 *
 */
public interface CompetenceService {
	/**
	 *  *  <br>
	 * <b>功能：</b>根据角色id 返回所有角色与关系对象  从而可以得到这个角色可以访问的所有的菜单id<br>
	 * <b>作者：</b>李成<br>
	 * <b>日期：</b> 2014-11-16 <br>
	 * 根据角色id 返回所有角色与关系对象  从而可以得到这个角色可以访问的所有的菜单id
	 * @param role_id
	 * @return
	 */
	public List<Competence> getCompetenceByRoleId(int role_id);
	/**
	 *   <br>
	 * <b>功能：</b>根据一个角色的Id 返回所有的可以访问的菜单的id<br>
	 * <b>作者：</b>李成<br>
	 * <b>日期：</b> 2014-11-16 <br>
	 * 根据一个角色的Id 返回所有的可以访问的菜单的id 
	 * @param role_id
	 * @return
	 */
	public List<Integer> getAllMenuId(int role_id);
}
