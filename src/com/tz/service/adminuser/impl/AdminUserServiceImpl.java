/**
 * tzdesk系统平台
 * moonvip_admin
 * com.tz.service.adminuser
 * IAdminUserService.java
 * 创建人:liu 
 * 时间：2016年08月17日 10:17:48
 * 2015潭州教育公司-版权所有
 */
package com.tz.service.adminuser.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tz.bean.AdminUser;
import com.tz.bean.TzParams;
import com.tz.dao.adminuser.IAdminUserMapper;
import com.tz.service.adminuser.IAdminUserService;
import com.tz.util.TmStringUtils;

/**
 * 日记管理serviceImpl
 * IAdminUserService
 * 创建人:liu 
 * 时间：2016年08月17日 10:17:48
 * @version 1.0.0
 * 
 */
@Service
public class AdminUserServiceImpl implements IAdminUserService{

	@Autowired
	private IAdminUserMapper adminuserMapper;
	
	@Override
	public List<AdminUser> findAdminUsers(TzParams params){
		if(TmStringUtils.isEmpty(params.getOrder()))params.setOrder("create_time desc");
		return adminuserMapper.findAdminUsers(params);
	}
	
	@Override
	public int count(TzParams params){
		return adminuserMapper.count(params);
	}

	@Override
	public AdminUser get(Integer id) {
		return adminuserMapper.get(id);
	}

	@Override
	public int save(AdminUser adminuser) {
		return adminuserMapper.save(adminuser);
	}

	@Override
	public int update(AdminUser adminuser) {
		return adminuserMapper.update(adminuser);
	}

	@Override
	public int delete(TzParams params) {
		return adminuserMapper.delete(params);
	}
}
