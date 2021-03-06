/**
 * kekeblog系统平台
 * moonvip_admin
 * com.tz.dao.role
 * IRoleMapper.java
 * 创建人:liu 
 * 时间：2015年11月28日-下午10:47:13 
 * 2015潭州教育公司-版权所有
 */
package com.tz.dao.role;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tz.bean.Role;
import com.tz.bean.TzParams;

/**
 * 角色管理Mapper
 * IRoleMapper
 * 创建人:liu 
 * 时间：2016年08月18日 11:55:19
 * @version 1.0.0
 * 
 */
public interface IRoleMapper {

	/**
	 * 
	 * com.tz.dao.role 
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
	 * com.tz.dao.role 
	 * 方法名：getRole
	 * 创建人：liu 
	 * 手机号码:15074816437
	 * 时间：2016年08月18日 11:55:19
	 * @param id
	 * @return 
	 * 返回类型：List<Role>
	 * @exception 
	 * @since  1.0.0
	 */
	public Role get(Integer id);
	
	/**
	 * 保存角色管理
	 * com.tz.dao.role 
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
	 * com.tz.dao.role 
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
	 * com.tz.dao.role 
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
	
	public int saveRoleUser(@Param("userId") Integer userId,@Param("roleId") Integer roleId);
	public int saveRolePermission(@Param("roleId") Integer roleId,@Param("permissionId") Integer permissionId);
	public int deleteRolePermission(@Param("roleId") Integer roleId);
	
	
	public List<HashMap<String,Object>> findFilterUsers (TzParams params);
	public int countFilterUsers(TzParams params);
	
	/**
	 * 根据用户查询对应角色 
	 * @param userId
	 * @return
	 */
	public HashMap<String, Object>findRolesByUserId(Integer userId);
	
}
