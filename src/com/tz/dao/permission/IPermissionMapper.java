/**
 * kekeblog系统平台
 * moonvip_admin
 * com.tz.dao.permission
 * IPermissionMapper.java
 * 创建人:liu 
 * 时间：2015年11月28日-下午10:47:13 
 * 2015潭州教育公司-版权所有
 */
package com.tz.dao.permission;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tz.bean.Permission;
import com.tz.bean.TzParams;

/**
 * 权限管理Mapper
 * IPermissionMapper
 * 创建人:liu 
 * 时间：2016年08月17日 14:47:46
 * @version 1.0.0
 * 
 */
public interface IPermissionMapper {

	/**
	 * 
	 * com.tz.dao.permission 
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
	public List<Permission> findPermissionsRoot(TzParams params);
	public List<Permission> findPermissionsChildren(@Param("id")Integer parentId);
	
	
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
	 * com.tz.dao.permission 
	 * 方法名：getPermission
	 * 创建人：liu 
	 * 手机号码:15074816437
	 * 时间：2016年08月17日 14:47:46
	 * @param id
	 * @return 
	 * 返回类型：List<Permission>
	 * @exception 
	 * @since  1.0.0
	 */
	public Permission get(Integer id);
	
	/**
	 * 保存权限管理
	 * com.tz.dao.permission 
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
	 * com.tz.dao.permission 
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
	 * com.tz.dao.permission 
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
