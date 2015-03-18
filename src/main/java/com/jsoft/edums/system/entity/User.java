package com.jsoft.edums.system.entity;

import java.util.Date;

import com.jsoft.edums.common.entity.Page;
/**
 * 表示用户实体类
 * @author 李成
 *
 */
public class User {
	private static final long serialVersionUID = 1L;//表示网络序列号
	private Integer userId;//表示用户的id
	private String loginname;//表示用户的登录名
	private String username;//表示用户的昵称
	private String password;//表示用户的密码
	private Date registerTime;//表示用户的注册时间
	private Date lastLogTime;//表示用户的上次登录时间
	private Integer roleId;//表示用户所属角色的角色id
	private Integer isDelete;//表示是否删除
	
	private Role role;//表示用户所属角色的角色实体类
	private Page page;//分页所用

	
	public Date getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}
	public Date getLastLogTime() {
		return lastLogTime;
	}
	public void setLastLogTime(Date lastLogTime) {
		this.lastLogTime = lastLogTime;
	}
	public Integer getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}


	public Page getPage() {
		if(page==null)
			page = new Page();
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
}
