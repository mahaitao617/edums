package com.jsoft.edums.system.entity;

import com.jsoft.edums.common.entity.Page;

/**
 * 权限与角色的关系实体类
 * @author 李成
 *
 */
public class Competence {
	
	private Integer competenceId;//主键id
	private Integer role_id;//角色id 用于标志是哪一种角色
	private Integer menu_id;//菜单id用于标志这个角色可以访问的菜单
	private Integer isDelete;//表示是否删除
	private Page page;  //用于分写插件
	
	/*
	 *get set 方法
	 */
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	
	public Integer getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	public Integer getCompetenceId() {
		return competenceId;
	}
	public void setCompetenceId(Integer competenceId) {
		this.competenceId = competenceId;
	}
	public Integer getRole_id() {
		return role_id;
	}
	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}
	public Integer getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(Integer menu_id) {
		this.menu_id = menu_id;
	}
	
	
}
