package com.jsoft.edums.common.util;

import org.springframework.context.ApplicationContext;

public class Const {
	public static final String SESSION_SECURITY_CODE = "sessionSecCode";
	public static final String SESSION_USER = "sessionUser";
	public static final String SESSION_USER_RIGHTS = "sessionUserRights";
	public static final String SESSION_ROLE_RIGHTS = "sessionRoleRights";
	public static final String NO_INTERCEPTOR_PATH = ".*/((login)|(logout)|(code)).*";	//不对匹配该值的访问路径拦截（正则）
	public static  final String ROLE_MENU_ID = "sessionMenuCanView";//用户可以浏览的菜单id组合
	public static ApplicationContext WEB_APP_CONTEXT = null; //该值会在web容器启动时由WebAppContextListener初始化
	public static String CAMPUS="校区";
	public static String CAMPUSID="1017";
	public static String CLASSTIME="上课时间";
	public static String CLASSTIMEID="1019";
	
}
