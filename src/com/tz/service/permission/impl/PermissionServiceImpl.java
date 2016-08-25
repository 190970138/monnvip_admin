/**
 * tzdesk系统平台
 * moonvip_admin
 * com.tz.service.permission
 * IPermissionService.java
 * 创建人:liu 
 * 时间：2016年08月17日 14:47:46
 * 2015潭州教育公司-版权所有
 */
package com.tz.service.permission.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tz.bean.Permission;
import com.tz.bean.TzParams;
import com.tz.dao.permission.IPermissionMapper;
import com.tz.service.permission.IPermissionService;

/**
 * 权限管理serviceImpl
 * IPermissionService
 * 创建人:liu 
 * 时间：2016年08月17日 14:47:46
 * @version 1.0.0
 * 
 */
@Service
public class PermissionServiceImpl implements IPermissionService{

	@Autowired
	private IPermissionMapper permissionMapper;
	
	//子类
	TreeMap<String, List<HashMap<String, Object>>> childrenMap = childrenMap = null;
	@Override
	public HashMap<String, Object> findPermissionsRoot(TzParams params){
		//返回类型
		HashMap<String, Object> datas = new HashMap<>();
		//装载所有的子元素
		childrenMap = new TreeMap<>();
		//所有的根目录
		List<Permission> permissions = permissionMapper.findPermissionsRoot(params);
		if (permissions!=null && permissions.size()>0) {
			List<HashMap<String, Object>> maps = new ArrayList<>();
			for (Permission permission : permissions) {
				HashMap<String, Object> map = new HashMap<>();
				map.put("name",permission.getName());
				map.put("url", "javascript:void(0);");
				map.put("opid", permission.getId());
				map.put("pid", permission.getId());
				maps.add(map);
//				childrenMap.put(permission.getId()+"", getChildrenData(permission.getId()));
				getChildrenData(permission.getId());
			
			}
			datas.put("root", maps);
			datas.put("children", childrenMap);
			System.out.println("================"+childrenMap);
			return datas;
		} else {
			return null;
		}		
	}
	
	private void getChildrenData(Integer pid){
		//查询所有子类
		List<Permission> childrenPermissions = permissionMapper.findPermissionsChildren(pid);
		//判断是否还有子类对象
		if (childrenPermissions!=null && childrenPermissions.size()>0) {
			//数据类型接受
			List<HashMap<String, Object>> maps = new ArrayList<>();
			// 开始循环所有子类
			for (Permission permission : childrenPermissions) {
				HashMap<String, Object> map = new HashMap<>();
				map.put("name",permission.getName());
				map.put("url", "javascript:void(0);");
				map.put("opid", permission.getId());
				map.put("pid", permission.getId());
				//添加到返回值中
				maps.add(map);
				//递归
				getChildrenData(permission.getId());
			}
			childrenMap.put(pid+"", maps);
			
//			return maps;
//		} else {
//			return null;
		}		
		
	}
	
	
	
	
/**

					只能两级权限，没有加递归
	@Override
	public HashMap<String, Object> findPermissionsRoot(TzParams params){
		HashMap<String, Object> datas = new HashMap<>();
		//所有的根目录
		List<Permission> permissions = permissionMapper.findPermissionsRoot(params);
		//子类
		TreeMap<String, List<HashMap<String, Object>>> childrenMap = new TreeMap<>();
		if (permissions!=null && permissions.size()>0) {
			List<HashMap<String, Object>> maps = new ArrayList<>();
			for (Permission permission : permissions) {
				HashMap<String, Object> map = new HashMap<>();
				map.put("name",permission.getName());
				map.put("url", permission.getUrl());
				map.put("opid", permission.getId());
				map.put("pid", permission.getId());
				maps.add(map);
				childrenMap.put(permission.getId()+"", getChildrenData(permission.getId()));
			}
			datas.put("root", maps);
			datas.put("children", childrenMap);
			return datas;
		} else {
			return null;
		}		
	}
	
	
	private List<HashMap<String, Object>> getChildrenData(Integer pid){
		List<Permission> childrenPermissions = permissionMapper.findPermissionsChildren(pid);
		if (childrenPermissions!=null && childrenPermissions.size()>0) {
			List<HashMap<String, Object>> maps = new ArrayList<>();
			for (Permission permission : childrenPermissions) {
				HashMap<String, Object> map = new HashMap<>();
				map.put("name",permission.getName());
				map.put("url", permission.getUrl());
				map.put("opid", permission.getId());
				map.put("pid", permission.getId());
				maps.add(map);
			}
			return maps;
		} else {
			return null;
		}		
		
	}
	
 */
	
	
	
	
	@Override
	public int count(TzParams params){
		return permissionMapper.count(params);
	}

	@Override
	public Permission get(Integer id) {
		return permissionMapper.get(id);
	}

	@Override
	public int save(Permission permission) {
		return permissionMapper.save(permission);
	}

	@Override
	public int update(Permission permission) {
		return permissionMapper.update(permission);
	}

	@Override
	public int delete(TzParams params) {
		return permissionMapper.delete(params);
	}
}
