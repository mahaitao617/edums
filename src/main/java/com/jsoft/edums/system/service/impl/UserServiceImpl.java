package com.jsoft.edums.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsoft.edums.base.service.BaseService;
import com.jsoft.edums.common.entity.Page;
import com.jsoft.edums.system.entity.User;
import com.jsoft.edums.system.mapper.UserMapper;
import com.jsoft.edums.system.service.UserService;
/**
 * 对于service 的所有实现
 * @author 李成
 *
 */
@Service
public class UserServiceImpl extends BaseService implements UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	public User getUserById(Integer userId) {
		
		return userMapper.getUserById(userId);
	}

	public boolean insertUser(User user) {
		
		int count = userMapper.getCountByName(user.getLoginname());
		if(count>0){
			return false;
		}else{
			userMapper.insertUser(user);
			return true;
		}
		
	}
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
	public List<User> listPageUser(User user){
		return userMapper.listPageUser(user);
	}

	public void updateUser(User user) {
		
		userMapper.updateUser(user);
	}

	public void updateUserBaseInfo(User user){
		userMapper.updateUserBaseInfo(user);
	}
	
	public void updateUserRights(User user){
		userMapper.updateUserRights(user);
	}
	
	public User getUserByNameAndPwd(String loginname, String password) {
		
		User user = new User();
		user.setLoginname(loginname);
		user.setPassword(password);
		return userMapper.getUserInfo(user);
	}

	public void deleteUser(int userId){
		userMapper.deleteUser(userId);
	}

	public User getUserAndRoleById(Integer userId) {
		
		return userMapper.getUserAndRoleById(userId);
	}

	public void updateLastLogin(User user) {
	
		userMapper.updateLastLogin(user);
	}

	public List<User> listAllUser() {
		
		return userMapper.listAllUser();
	}

	public List<User> listPageUser(Page page) {
		
		
		return userMapper.listPageUser(page);
	}
	
}
