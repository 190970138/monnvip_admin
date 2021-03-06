/**
 * tzdesk系统平台
 * moonvip_admin
 * com.tz.service.role
 * IRoleService.java
 * 创建人:liu 
 * 时间：2016年08月18日 11:55:19
 * 2015潭州教育公司-版权所有
 */
package com.tz.service.role.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tz.bean.Role;
import com.tz.bean.TzParams;
import com.tz.dao.role.IRoleMapper;
import com.tz.service.role.IRoleService;
import com.tz.util.TmStringUtils;

/**
 * 角色管理serviceImpl
 * IRoleService
 * 创建人:liu 
 * 时间：2016年08月18日 11:55:19
 * @version 1.0.0
 * 
 */
@Service
public class RoleServiceImpl implements IRoleService{

	@Autowired
	private IRoleMapper roleMapper;
	
	@Override
	public List<Role> findRoles(TzParams params){
		if(TmStringUtils.isEmpty(params.getOrder()))params.setOrder("create_time desc");
		return roleMapper.findRoles(params);
	}
	
	@Override
	public int count(TzParams params){
		return roleMapper.count(params);
	}

	@Override
	public Role get(Integer id) {
		return roleMapper.get(id);
	}

	@Override
	public int save(Role role) {
		return roleMapper.save(role);
	}

	@Override
	public int update(Role role) {
		return roleMapper.update(role);
	}

	@Override
	public int delete(TzParams params) {
		return roleMapper.delete(params);
	}

	@Override
	public int saveRoleUser(Integer userId, Integer roleId) {
		return roleMapper.saveRoleUser(userId, roleId);
	}

	@Override
	public List<HashMap<String, Object>> findFilterUsers(TzParams params) {
		return roleMapper.findFilterUsers(params);
	}

	@Override
	public int countFilterUsers(TzParams params) {
		return roleMapper.countFilterUsers(params);
	}

	@Override
	public int saveRolePermission(Integer roleId, Integer permissionId) {
		return roleMapper.saveRolePermission(roleId, permissionId);
	}

	@Override
	public int deleteRolePermission(Integer roleId) {
		return roleMapper.deleteRolePermission(roleId);
	}

	@Override
	public HashMap<String, Object> findRolesByUserId(Integer userId) {
		return roleMapper.findRolesByUserId(userId);
	}
}
