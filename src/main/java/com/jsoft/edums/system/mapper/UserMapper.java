package com.jsoft.edums.system.mapper;

import java.util.List;

import com.jsoft.edums.common.annotation.MyBatisDao;
import com.jsoft.edums.common.entity.Page;
import com.jsoft.edums.system.entity.User;
/**
 * 对于用户的数据库操作
 * @author 李成
 *
 */
@MyBatisDao
public interface UserMapper  {
	/**
	 * 利用它的分页工具进行分页查询 所有的user对象
	 * @param page
	 * @return
	 */
	public List<User> listPageUser(Page page);
	/**
	 * 得到一个user的具体对象信息 根据传入的user对象中的不同的信息
	 * @param user
	 * @return
	 */
	User getUserInfo(User user);
	/**
	 * 更新一个user对象的上次登录时间这个字段
	 * @param user
	 */
	void updateLastLogin(User user);
	
	
	
	/*
	 * 等待修正
	 */
	List<User> listAllUser();
	
	User getUserById(Integer userId);
	
	void insertUser(User user);
	
	void updateUser(User user);
	
	
	
	void updateUserBaseInfo(User user);
	
	void updateUserRights(User user);
	
	int getCountByName(String loginname);
	
	void deleteUser(int userId);
	
	int getCount(User user);
	
	List<User> listPageUser(User user);
	
	User getUserAndRoleById(Integer userId);
	
	
}
