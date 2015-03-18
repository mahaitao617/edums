package com.jsoft.edums.base.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 控制器基类
 * @author Sukki
 *
 */
public abstract class BaseController {
	@Autowired
	private HttpServletRequest httpServletRequest;
	
	/**
	 * <br>
	 * <b>功能：</b>得到当前项目的请求地址 直到项目名下<br>
	 * <b>作者：</b>李成<br>
	 * <b>日期：</b> 2014-11-21 <br>
	 * 
	 * @return
	 */
	public String getPath(){
		String path = httpServletRequest.getContextPath();
		String basePath = httpServletRequest.getScheme()+"://"+httpServletRequest.getServerName()+":"+httpServletRequest.getServerPort()+path+"/";
		return basePath;
	}
}
