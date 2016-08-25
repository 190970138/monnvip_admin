/**
 * tzdesk系统平台
 * moonvip_admin
 * com.tz.service.adminstat
 * IAdminStatService.java
 * 创建人:liu 
 * 时间：2016年08月12日 17:04:42
 * 2015潭州教育公司-版权所有
 */
package com.tz.service.adminstat.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tz.bean.AdminStat;
import com.tz.bean.TzParams;
import com.tz.dao.adminstat.IAdminStatMapper;
import com.tz.service.adminstat.IAdminStatService;
import com.tz.util.TmStringUtils;

/**
 * 日记管理serviceImpl
 * IAdminStatService
 * 创建人:liu 
 * 时间：2016年08月12日 17:04:42
 * @version 1.0.0
 * 
 */
@Service
public class AdminStatServiceImpl implements IAdminStatService{

	@Autowired
	private IAdminStatMapper adminstatMapper;
	
	@Override
	public List<AdminStat> findAdminStats(TzParams params){
		if(TmStringUtils.isEmpty(params.getOrder()))params.setOrder("create_time desc");
		return adminstatMapper.findAdminStats(params);
	}
	
	@Override
	public int count(TzParams params){
		return adminstatMapper.count(params);
	}

	@Override
	public AdminStat get(Integer id) {
		return adminstatMapper.get(id);
	}

	@Override
	public int save(AdminStat adminstat) {
		return adminstatMapper.save(adminstat);
	}

	@Override
	public int update(AdminStat adminstat) {
		return adminstatMapper.update(adminstat);
	}

	@Override
	public int delete(TzParams params) {
		return adminstatMapper.delete(params);
	}
}
