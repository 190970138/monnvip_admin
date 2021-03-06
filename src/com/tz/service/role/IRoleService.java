/**
 * tzdesk系统平台
 * moonvip_admin
 * com.tz.service.role
 * IRoleService.java
 * 创建人:liu 
 * 时间：2016年08月18日 11:55:19
 * 2015潭州教育公司-版权所有
 */
package com.tz.service.role;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tz.bean.Role;
import com.tz.bean.TzParams;

/**
 * 
 * IRoleService
 * 创建人:liu 
 * 时间：2016年08月18日 11:55:19
 * @version 1.0.0
 * 
 */
public interface IRoleService {


	/**
	 * 
	 * com.tz.service.role 
	 * 方法名：findRoles
	 * 创建人：liu 
	 * 手机号码:15074816437
	 * 时间：2016年08月18日 11:55:19
	 * @param params
	 * @return 
	 * 返回类型：List<Role>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<Role> findRoles(TzParams params);
	
	/**
	 * 求总数
	 * com.tz.dao.role 
	 * 方法名：count
	 * 创建人：liu 
	 * 手机号码:15074816437
	 * 时间：2016年08月18日 11:55:19
	 * @param id
	 * @return 
	 * 返回类型：List<Role>
	 * @exception 
	 * @since  1.0.0
	 */
	public int count(TzParams params);
	
	/**
	 * 
	 * com.tz.service.role 
	 * 方法名：findRoles
	 * 创建人：liu 
	 * 手机号码:15074816437
	 * 时间：2016年08月18日 11:55:19
	 * @param params
	 * @return 
	 * 返回类型：List<Role>
	 * @exception 
	 * @since  1.0.0
	 */
	public Role get(Integer id);
	
	/**
	 * 保存角色管理
	 * com.tz.service.role 
	 * 方法名：save
	 * 创建人：liu 
	 * 手机号码:15074816437
	 * 时间：2016年08月18日 11:55:19 
	 * @param role
	 * @return 
	 * 返回类型：Role
	 * @exception 
	 * @since  1.0.0
	 */
	public int save(Role role);
	
	/**
	 * 更新角色管理
	 * com.tz.service.role 
	 * 方法名：update
	 * 创建人：liu 
	 * 手机号码:15074816437
	 * 时间：2016年08月18日 11:55:19
	 * @param role
	 * @return 
	 * 返回类型：int
	 * @exception 
	 * @since  1.0.0
	 */
	public int update(Role role);
	
	/**
	 * 删除角色管理
	 * com.tz.service.role 
	 * 方法名：delete
	 * 创建人：liu 
	 * 手机号码:15074816437
	 * 时间：2016年08月18日 11:55:19
	 * @param params
	 * @return 
	 * 返回类型：int
	 * @exception 
	 * @since  1.0.0
	 */
	public int delete(TzParams params);
	
	
	public int saveRoleUser(Integer userId,Integer roleId);
	public int saveRolePermission(@Param("roleId") Integer roleId,@Param("permissionId") Integer permissionId);
	public int deleteRolePermission(@Param("roleId") Integer roleId);
	/**
	 * 过滤用户查询
	 * @param params
	 * @return
	 */
	public List<HashMap<String,Object>> findFilterUsers (TzParams params);
	public int countFilterUsers(TzParams params);


	public HashMap<String, Object>findRolesByUserId(Integer userId);


}
