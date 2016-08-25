/**
 * tzdesk系统平台
 * moonvip_admin
 * com.tz.web.adminstat
 * AdminStatController.java
 * 创建人:liu
 * 时间：2016年08月12日 17:04:42
 * 2015潭州教育公司-版权所有
 */
package com.tz.web.adminstat;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tz.bean.AdminStat;
import com.tz.bean.TzParams;
import com.tz.service.adminstat.IAdminStatService;

/**
 * 日记管理web
 * AdminStatController
 * 创建人:liu
 * 时间：2016年08月12日 17:04:42
 * @version 1.0.0
 * 
 */
@Controller
@RequestMapping("/admin/adminstat")
public class AdminStatController {
	
	@Autowired
	private IAdminStatService adminstatService;
	
	/*列表查询*/
	@RequestMapping("/list")
	public String list(TzParams params){
		return "adminstat/list";
	}
	
	/*模板页面*/
	@RequestMapping("/template")
	public ModelAndView template(TzParams params){
		ModelAndView modelAndView = new ModelAndView();
		List<AdminStat> adminstats = adminstatService.findAdminStats(params);
		int count = adminstatService.count(params);
		modelAndView.setViewName("adminstat/template");
		modelAndView.addObject("datas",adminstats);
		modelAndView.addObject("itemCount",count);
		return modelAndView;
	}
	
	/**
	 * 用户统计查询
	 * @param params
	 * @return
	 */
	@RequestMapping("/userlist")
	public String userlist(){
		
		return "adminstat/userlist";
	}
	/**
	 * 内容统计查询
	 * @param params
	 * @return
	 */
	@RequestMapping("/contentlist")
	public String contentlist(){
		
		return "adminstat/contentlist";
	}
}
