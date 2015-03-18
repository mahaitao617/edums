package com.jsoft.edums.common.util;

import com.jsoft.edums.system.service.MenuService;
import com.jsoft.edums.system.service.RoleService;
import com.jsoft.edums.system.service.UserService;


/**
 * @author Administrator
 * 获取Spring容器中的service bean
 */
public final class ServiceHelper {
	
	public static Object getService(String serviceName){
		//WebApplicationContextUtils.
		/*System.err.println(Const.WEB_APP_CONTEXT+"   =web_app_content");
		System.out.println(Const.WEB_APP_CONTEXT.containsBean("menuServiceImpl"));
		System.err.println(Const.WEB_APP_CONTEXT.getDisplayName());
	*/
		return Const.WEB_APP_CONTEXT.getBean(serviceName);
	}
	
	public static UserService getUserService(){
		return (UserService) getService("userServiceImpl");
	}
	
	public static RoleService getRoleService(){
		return (RoleService) getService("roleServiceImpl");
	}
	
	public static MenuService getMenuService(){
		return (MenuService) getService("menuServiceImpl");
	}
}
