package com.jsoft.edums.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.jsoft.edums.common.util.Const;
import com.jsoft.edums.system.entity.User;

public class LoginHandlerInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		String path = request.getServletPath();
		if(path.matches(Const.NO_INTERCEPTOR_PATH)){
			return true;
		}else{
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute(Const.SESSION_USER);
			if(user!=null){
				return true;
			}else{
				response.sendRedirect(request.getContextPath()+"/login.html");
				return false;
			}
		}
	}
	
}
