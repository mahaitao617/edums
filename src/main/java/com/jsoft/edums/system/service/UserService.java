package com.jsoft.edums.system.service;

import java.util.List;

import com.jsoft.edums.common.entity.Page;
import com.jsoft.edums.system.entity.User;
/**
 * 对于用户的service操作
 * @author 李成
 *
 */
public interface UserService {
	/**
	 *  <br>
	 * <b>功能：</b>根据page 返回当前页的所有的user<br>
	 * <b>作者：</b>李成<br>
	 * <b>日期：</b> 2014-11-16 <br>
	 * 列举所有的子类菜单
	 * 根据page 返回当前页的所有的user
	 * @param page
	 * @return
	 */
	public List<User> listPageUser(Page page);
	
	
	/*
	 * 等待修正
	 */
	User getUserById(Integer userId);
	
	boolean insertUser(User user);
	
	void updateUser(User user);
	
	User getUserByNameAndPwd(String username,String password);
	
	void updateUserBaseInfo(User user);
	
	void updateUserRights(User user);
	
	void deleteUser(int userId);
	
	List<User> listPageUser(User user);
	
	void updateLastLogin(User user);
	
	User getUserAndRoleById(Integer userId);
	
	List<User> listAllUser();
}
