package com.jsoft.edums.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsoft.edums.system.entity.Competence;
import com.jsoft.edums.system.mapper.CompetenceMapper;
import com.jsoft.edums.system.service.CompetenceService;
/**
 * 权限角色关系实现类
 * @author 李成
 *
 */
@Service
public class CompetenceServiceImpl implements CompetenceService {
	@Autowired
	private CompetenceMapper competenceMapper;//权限角色关系dao 
	/**
	 *  *  <br>
	 * <b>功能：</b>根据角色id 返回所有角色与关系对象  从而可以得到这个角色可以访问的所有的菜单id<br>
	 * <b>作者：</b>李成<br>
	 * <b>日期：</b> 2014-11-16 <br>
	 * 根据角色id 返回所有角色与关系对象  从而可以得到这个角色可以访问的所有的菜单id
	 * @param role_id
	 * @return
	 */
	public List<Competence> getCompetenceByRoleId(int role_id){
		return competenceMapper.getCompetenceById(role_id);
	}
	/**
	 *   <br>
	 * <b>功能：</b>根据一个角色的Id 返回所有的可以访问的菜单的id<br>
	 * <b>作者：</b>李成<br>
	 * <b>日期：</b> 2014-11-16 <br>
	 * 根据一个角色的Id 返回所有的可以访问的菜单的id 
	 * @param role_id
	 * @return
	 */
	public List<Integer> getAllMenuId(int role_id){
		List<Competence> competences = getCompetenceByRoleId(role_id);
		List<Integer> menuIds = new ArrayList<Integer>();
		for (int i = 0; i < competences.size(); i++) {
			menuIds.add(competences.get(i).getMenu_id());
		}
		return menuIds;
	}
}
