package com.jsoft.edums.system.service;

import java.util.List;

import com.jsoft.edums.system.entity.Role;
/*
 * 等待修正
 */
public interface RoleService {
	List<Role> listAllRoles();
	Role getRoleById(int roleId);
	boolean insertRole(Role role);
	boolean updateRoleBaseInfo(Role role);
	void deleteRoleById(int roleId);
	void updateRoleRights(Role role);
}
