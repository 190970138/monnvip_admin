package com.tz.service.user;

import com.tz.bean.AdminUser;
import com.tz.bean.TzParams;

public interface IUserService {
	
	public AdminUser getLogin(TzParams params);
}


