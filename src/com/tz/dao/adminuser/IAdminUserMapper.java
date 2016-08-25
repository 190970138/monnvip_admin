/**
 * kekeblog系统平台
 * moonvip_admin
 * com.tz.dao.adminuser
 * IAdminUserMapper.java
 * 创建人:liu 
 * 时间：2015年11月28日-下午10:47:13 
 * 2015潭州教育公司-版权所有
 */
package com.tz.dao.adminuser;

import java.util.List;

import com.tz.bean.AdminUser;
import com.tz.bean.TzParams;

/**
 * 日记管理Mapper
 * IAdminUserMapper
 * 创建人:liu 
 * 时间：2016年08月17日 10:17:48
 * @version 1.0.0
 * 
 */
public interface IAdminUserMapper {

	/**
	 * 
	 * com.tz.dao.adminuser 
	 * 方法名：findAdminUsers
	 * 创建人：liu 
	 * 手机号码:15074816437
	 * 时间：2016年08月17日 10:17:48
	 * @param params
	 * @return 
	 * 返回类型：List<AdminUser>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<AdminUser> findAdminUsers(TzParams params);
	
	/**
	 * 求总数
	 * com.tz.dao.adminuser 
	 * 方法名：count
	 * 创建人：liu 
	 * 手机号码:15074816437
	 * 时间：2016年08月17日 10:17:48
	 * @param id
	 * @return 
	 * 返回类型：List<AdminUser>
	 * @exception 
	 * @since  1.0.0
	 */
	public int count(TzParams params);
	
	/**
	 * 
	 * com.tz.dao.adminuser 
	 * 方法名：getAdminUser
	 * 创建人：liu 
	 * 手机号码:15074816437
	 * 时间：2016年08月17日 10:17:48
	 * @param id
	 * @return 
	 * 返回类型：List<AdminUser>
	 * @exception 
	 * @since  1.0.0
	 */
	public AdminUser get(Integer id);
	
	/**
	 * 保存日记管理
	 * com.tz.dao.adminuser 
	 * 方法名：save
	 * 创建人：liu 
	 * 手机号码:15074816437
	 * 时间：2016年08月17日 10:17:48
	 * @param adminuser
	 * @return 
	 * 返回类型：AdminUser
	 * @exception 
	 * @since  1.0.0
	 */
	public int save(AdminUser adminuser);
	
	/**
	 * 更新日记管理
	 * com.tz.dao.adminuser 
	 * 方法名：update
	 * 创建人：liu 
	 * 手机号码:15074816437
	 * 时间：2016年08月17日 10:17:48
	 * @param adminuser
	 * @return 
	 * 返回类型：int
	 * @exception 
	 * @since  1.0.0
	 */
	public int update(AdminUser adminuser);
	
	/**
	 * 删除日记管理
	 * com.tz.dao.adminuser 
	 * 方法名：delete
	 * 创建人：liu 
	 * 手机号码:15074816437
	 * 时间：2016年08月17日 10:17:48 
	 * @param params
	 * @return 
	 * 返回类型：int
	 * @exception 
	 * @since  1.0.0
	 */
	public int delete(TzParams params);
	
}
