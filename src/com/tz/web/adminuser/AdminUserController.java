/**
 * tzdesk系统平台
 * moonvip_admin
 * com.tz.web.adminuser
 * AdminUserController.java
 * 创建人:liu
 * 时间：2016年08月17日 10:17:48
 * 2015潭州教育公司-版权所有
 */
package com.tz.web.adminuser;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tz.bean.AdminUser;
import com.tz.bean.TzParams;
import com.tz.service.adminuser.IAdminUserService;

/**
 * 日记管理web
 * AdminUserController
 * 创建人:liu
 * 时间：2016年08月17日 10:17:48
 * @version 1.0.0
 * 
 */
@Controller
@RequestMapping("/admin/adminuser")
public class AdminUserController {
	
	@Autowired
	private IAdminUserService adminuserService;
	
	/*列表查询*/
	@RequestMapping("/list")
	public String list(TzParams params){
		return "adminuser/list";
	}
	
	/*模板页面*/
	@RequestMapping("/template")
	public ModelAndView template(TzParams params){
		ModelAndView modelAndView = new ModelAndView();
		params.setIsDelete(0);
		params.setOrder("create_time desc");
		List<AdminUser> adminusers = adminuserService.findAdminUsers(params);
		int count = adminuserService.count(params);
		modelAndView.setViewName("adminuser/template");
		modelAndView.addObject("datas",adminusers);
		modelAndView.addObject("itemCount",count);
		return modelAndView;
	}
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.POST,value="/delete")
	public String delete(TzParams params){
		
		try {
			adminuserService.delete(params);
			return "success";
		} catch (Exception e) {
			return "error";
		
		}
		
	}
	
	
}
