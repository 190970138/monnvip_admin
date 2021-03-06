/**
 * tzdesk系统平台
 * moonvip_admin
 * com.tz.service.adminstat
 * IAdminStatService.java
 * 创建人:liu 
 * 时间：2016年08月12日 17:04:42
 * 2015潭州教育公司-版权所有
 */
package com.tz.service.adminstat;

import java.util.List;

import com.tz.bean.AdminStat;
import com.tz.bean.TzParams;

/**
 * 
 * IAdminStatService
 * 创建人:liu 
 * 时间：2016年08月12日 17:04:42
 * @version 1.0.0
 * 
 */
public interface IAdminStatService {


	/**
	 * 
	 * com.tz.service.adminstat 
	 * 方法名：findAdminStats
	 * 创建人：liu 
	 * 手机号码:15074816437
	 * 时间：2016年08月12日 17:04:42
	 * @param params
	 * @return 
	 * 返回类型：List<AdminStat>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<AdminStat> findAdminStats(TzParams params);
	
	/**
	 * 求总数
	 * com.tz.dao.adminstat 
	 * 方法名：count
	 * 创建人：liu 
	 * 手机号码:15074816437
	 * 时间：2016年08月12日 17:04:42
	 * @param id
	 * @return 
	 * 返回类型：List<AdminStat>
	 * @exception 
	 * @since  1.0.0
	 */
	public int count(TzParams params);
	
	/**
	 * 
	 * com.tz.service.adminstat 
	 * 方法名：findAdminStats
	 * 创建人：liu 
	 * 手机号码:15074816437
	 * 时间：2016年08月12日 17:04:42
	 * @param params
	 * @return 
	 * 返回类型：List<AdminStat>
	 * @exception 
	 * @since  1.0.0
	 */
	public AdminStat get(Integer id);
	
	/**
	 * 保存日记管理
	 * com.tz.service.adminstat 
	 * 方法名：save
	 * 创建人：liu 
	 * 手机号码:15074816437
	 * 时间：2016年08月12日 17:04:42 
	 * @param adminstat
	 * @return 
	 * 返回类型：AdminStat
	 * @exception 
	 * @since  1.0.0
	 */
	public int save(AdminStat adminstat);
	
	/**
	 * 更新日记管理
	 * com.tz.service.adminstat 
	 * 方法名：update
	 * 创建人：liu 
	 * 手机号码:15074816437
	 * 时间：2016年08月12日 17:04:42
	 * @param adminstat
	 * @return 
	 * 返回类型：int
	 * @exception 
	 * @since  1.0.0
	 */
	public int update(AdminStat adminstat);
	
	/**
	 * 删除日记管理
	 * com.tz.service.adminstat 
	 * 方法名：delete
	 * 创建人：liu 
	 * 手机号码:15074816437
	 * 时间：2016年08月12日 17:04:42
	 * @param params
	 * @return 
	 * 返回类型：int
	 * @exception 
	 * @since  1.0.0
	 */
	public int delete(TzParams params);
}
