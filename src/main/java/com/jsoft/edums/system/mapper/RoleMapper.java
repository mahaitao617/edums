package com.jsoft.edums.system.mapper;

import java.util.List;

import com.jsoft.edums.common.annotation.MyBatisDao;
import com.jsoft.edums.system.entity.Role;
/**
 * 对于角色的数据库操作
 * @author zhuyuwaiting
 *
 */
@MyBatisDao
public interface RoleMapper {
	List<Role> listAllRoles();
	Role getRoleById(int roleId);
	void insertRole(Role role);
	void updateRoleBaseInfo(Role role);
	void deleteRoleById(int roleId);
	int getCountByName(Role role);
	void updateRoleRights(Role role);
}
