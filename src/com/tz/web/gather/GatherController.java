/**
 * tzdesk系统平台
 * moonvip_admin
 * com.tz.web.gather
 * GatherController.java
 * 创建人:liu
 * 时间：2016年08月25日 15:56:09
 * 2015潭州教育公司-版权所有
 */
package com.tz.web.gather;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tz.bean.TzParams;

/**
 * 数据抓取web
 * GatherController
 * 创建人:liu
 * 时间：2016年08月25日 15:56:09
 * @version 1.0.0
 * 
 */
@Controller
@RequestMapping("/admin/gather")
public class GatherController {
	
	/*列表查询*/
	@RequestMapping("/list")
	public String list(TzParams params){
		return "gather/list";
	}
	
	
	public static void main(String[] args) {
		
	}
	
}
