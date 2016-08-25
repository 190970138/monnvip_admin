/**
 * tzdesk系统平台
 * moonvip_admin
 * com.tz.web.role
 * RoleController.java
 * 创建人:liu
 * 时间：2016年08月18日 11:55:19
 * 2015潭州教育公司-版权所有
 */
package com.tz.web.role;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tz.bean.Role;
import com.tz.bean.TzParams;
import com.tz.service.role.IRoleService;
import com.tz.util.TmStringUtils;

/**
 * 角色管理web
 * RoleController
 * 创建人:liu
 * 时间：2016年08月18日 11:55:19
 * @version 1.0.0
 * 
 */
@Controller
@RequestMapping("/admin/role")
public class RoleController {
	
	@Autowired
	private IRoleService roleService;
	/*列表查询*/
	@RequestMapping("/list")
	public String list(TzParams params){
		return "role/list";
	}
	
	/*列表查询*/
	@RequestMapping("/user/{rid}")
	public ModelAndView user(@PathVariable("rid") Integer roleId,TzParams params){
		ModelAndView modelAndView = new ModelAndView();
		params.setIsDelete(0);
		params.setRoleId(roleId);
		params.setPageSize(30);
		List<HashMap<String,Object>> adminUsers = roleService.findFilterUsers(params);
		int totalCount = roleService.countFilterUsers(params);
		modelAndView.addObject("datas", adminUsers);
		modelAndView.addObject("count", totalCount);
		modelAndView.setViewName("role/user");
		return modelAndView;
	}
	
	/*列表查询*/
	@RequestMapping("/permission/{rid}")
	public ModelAndView permission(@PathVariable("rid") Integer roleId,TzParams params){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("role/permission");
		return modelAndView;
	}
	
	/*模板页面*/
	@RequestMapping("/template")
	public ModelAndView template(TzParams params){
		ModelAndView modelAndView = new ModelAndView();
		List<Role> roles = roleService.findRoles(params);
		int count = roleService.count(params);
		modelAndView.setViewName("role/template");
		modelAndView.addObject("datas",roles);
		modelAndView.addObject("itemCount",count);
		return modelAndView;
	}
	
	@ResponseBody
	@RequestMapping(value="/saveUserRole",method=RequestMethod.POST)
	public String saveUserRole(HttpServletRequest request){
		//获取所有的分配用户
		String userSring  = request.getParameter("users");
		//角色ID
		String rid = request.getParameter("rid");
		if (TmStringUtils.isNotEmpty(userSring) && TmStringUtils.isNotEmpty(rid)) {
			//分配角色给用户
			String[] users = userSring.split(",");
			for (String string : users) {
				roleService.saveRoleUser(Integer.parseInt(string), Integer.parseInt(rid));
			}
			return "success";
		} else {
			return "fail";
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/saveRolePermission",method=RequestMethod.POST)
	public String saveRolePermission(HttpServletRequest request){
		//获取所有权限
		String userSring  = request.getParameter("permissions");
		//获取分配的角色
		String roleId = request.getParameter("rid");
		//如果权限有，角色不为空
		if (TmStringUtils.isNotEmpty(userSring) && TmStringUtils.isNotEmpty(roleId)) {
			Integer rid = Integer.parseInt(roleId);
			//删除角色对应的权限
			roleService.deleteRolePermission(rid);
			//重新分配
			String[] users = userSring.split(",");
			for (String string : users) {
				roleService.saveRolePermission( Integer.parseInt(roleId),Integer.parseInt(string));
			}
			return "success";
		} else {
			return "fail";
		}
	}
}
