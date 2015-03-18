package com.jsoft.edums.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsoft.edums.base.service.BaseService;
import com.jsoft.edums.system.entity.Role;
import com.jsoft.edums.system.mapper.RoleMapper;
import com.jsoft.edums.system.service.RoleService;

@Service
public class RoleServiceImpl extends BaseService implements RoleService{
	
	@Autowired
	private RoleMapper roleMapper;
	
	public List<Role> listAllRoles() {
		
		return roleMapper.listAllRoles();
	}

	public void deleteRoleById(int roleId) {
		
		roleMapper.deleteRoleById(roleId);
	}

	public Role getRoleById(int roleId) {
		
		return roleMapper.getRoleById(roleId);
	}

	public boolean insertRole(Role role) {
		
		if(roleMapper.getCountByName(role)>0)
			return false;
		else{
			roleMapper.insertRole(role);
			return true;
		}
	}

	public boolean updateRoleBaseInfo(Role role) {
		
		if(roleMapper.getCountByName(role)>0)
			return false;
		else{
			roleMapper.updateRoleBaseInfo(role);
			return true;
		}
	}
	
	public void updateRoleRights(Role role) {
		
		roleMapper.updateRoleRights(role);
	}

}
