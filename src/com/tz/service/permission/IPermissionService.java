/**
 * tzdesk系统平台
 * moonvip_admin
 * com.tz.service.permission
 * IPermissionService.java
 * 创建人:liu 
 * 时间：2016年08月17日 14:47:46
 * 2015潭州教育公司-版权所有
 */
package com.tz.service.permission;

import java.util.HashMap;

import com.tz.bean.Permission;
import com.tz.bean.TzParams;

/**
 * 
 * IPermissionService
 * 创建人:liu 
 * 时间：2016年08月17日 14:47:46
 * @version 1.0.0
 * 
 */
public interface IPermissionService {


	/**
	 * 
	 * com.tz.service.permission 
	 * 方法名：findPermissions
	 * 创建人：liu 
	 * 手机号码:15074816437
	 * 时间：2016年08月17日 14:47:46
	 * @param params
	 * @return 
	 * 返回类型：List<Permission>
	 * @exception 
	 * @since  1.0.0
	 */
	public HashMap<String, Object> findPermissionsRoot(TzParams params);
	
	/**
	 * 求总数
	 * com.tz.dao.permission 
	 * 方法名：count
	 * 创建人：liu 
	 * 手机号码:15074816437
	 * 时间：2016年08月17日 14:47:46
	 * @param id
	 * @return 
	 * 返回类型：List<Permission>
	 * @exception 
	 * @since  1.0.0
	 */
	public int count(TzParams params);
	
	/**
	 * 
	 * com.tz.service.permission 
	 * 方法名：findPermissions
	 * 创建人：liu 
	 * 手机号码:15074816437
	 * 时间：2016年08月17日 14:47:46
	 * @param params
	 * @return 
	 * 返回类型：List<Permission>
	 * @exception 
	 * @since  1.0.0
	 */
	public Permission get(Integer id);
	
	/**
	 * 保存权限管理
	 * com.tz.service.permission 
	 * 方法名：save
	 * 创建人：liu 
	 * 手机号码:15074816437
	 * 时间：2016年08月17日 14:47:46 
	 * @param permission
	 * @return 
	 * 返回类型：Permission
	 * @exception 
	 * @since  1.0.0
	 */
	public int save(Permission permission);
	
	/**
	 * 更新权限管理
	 * com.tz.service.permission 
	 * 方法名：update
	 * 创建人：liu 
	 * 手机号码:15074816437
	 * 时间：2016年08月17日 14:47:46
	 * @param permission
	 * @return 
	 * 返回类型：int
	 * @exception 
	 * @since  1.0.0
	 */
	public int update(Permission permission);
	
	/**
	 * 删除权限管理
	 * com.tz.service.permission 
	 * 方法名：delete
	 * 创建人：liu 
	 * 手机号码:15074816437
	 * 时间：2016年08月17日 14:47:46
	 * @param params
	 * @return 
	 * 返回类型：int
	 * @exception 
	 * @since  1.0.0
	 */
	public int delete(TzParams params);
}
