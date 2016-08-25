package com.tz.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tz.bean.AdminUser;
import com.tz.bean.TzParams;
import com.tz.dao.user.IUserMapper;
import com.tz.service.user.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private IUserMapper userMapper;
	@Override
	public AdminUser getLogin(TzParams params) {
		// TODO Auto-generated method stub
		return userMapper.getLogin(params);
	}

	

}
