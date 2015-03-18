package com.jsoft.edums.system.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jsoft.edums.common.entity.Page;
/**
 * 表示菜单实体类
 * @author 李成
 *
 */
public class Menu {
	private static final long serialVersionUID = 1L;  //网络序列号
	private Integer menuId;//菜单的id 表示这是哪一个菜单
	private String menuName;//菜单名
	private Integer fatherId;//菜单的父类id
	private String url;//表示菜单链接的url
	private Date buildTime;//表示这个菜单创建的时间
	private String remark;//表示对于这个菜单的描述
	private Integer isDelete;//表示是否删除
	
	private Menu parentMenu;
	private List<Menu> subMenu=new ArrayList<Menu>();
	
	
	private Page page;
	
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
	private boolean hasMenu = false;
	
	public Integer getMenuId() {
		return menuId;
	}
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public Integer getFatherId() {
		return fatherId;
	}
	public void setFatherId(Integer fatherId) {
		this.fatherId = fatherId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	public Date getBuildTime() {
		return buildTime;
	}

	public void setBuildTime(Date buildTime) {
		this.buildTime = buildTime;
	}

	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
	public Menu getParentMenu() {
		return parentMenu;
	}
	public void setParentMenu(Menu parentMenu) {
		this.parentMenu = parentMenu;
	}
	public List<Menu> getSubMenu() {
		return subMenu;
	}
	public void setSubMenu(List<Menu> subMenu) {
		this.subMenu = subMenu;
	}
	public boolean isHasMenu() {
		return hasMenu;
	}
	public void setHasMenu(boolean hasMenu) {
		this.hasMenu = hasMenu;
	}
}
