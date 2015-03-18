package com.jsoft.edums.system.entity;

import com.jsoft.edums.common.entity.Page;
/**
 * 角色实体类
 * @author 李成
 *
 */
public class Role {
	private static final long serialVersionUID = 1L;//网路序列号
	private Integer roleId;//表示角色id
	private String roleName;//表示角色名称
	private String describle;//表示对于角色的描述
	private Integer isDelete;//表示是否删除
	
	private Page page;//分页所用
	
	
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getDescrible() {
		return describle;
	}
	public void setDescrible(String describle) {
		this.describle = describle;
	}
	public int getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	
}
