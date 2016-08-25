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

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tz.bean.TzParams;
import com.tz.dao.adminstat.IStatMapper;
import com.tz.service.adminstat.IStatService;

/**
 * 日记管理serviceImpl
 * IAdminStatService
 * 创建人:liu 
 * 时间：2016年08月12日 17:04:42
 * @version 1.0.0
 * 
 */
@Service
public class StatService implements IStatService{

	@Autowired
	private IStatMapper statMapper;

	@Override
	public List<HashMap<String, Object>> groupContent(TzParams params) {
		// TODO Auto-generated method stub
		return statMapper.groupContent(params);
	}
	
	
}
