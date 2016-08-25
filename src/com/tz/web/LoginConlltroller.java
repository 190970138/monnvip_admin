package com.tz.web;

import static com.tz.util.TzConstant.SESSION_USER;
import static com.tz.util.TzConstant.SESSION_USER_USERNAME;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tz.bean.AdminUser;
import com.tz.bean.TzParams;
import com.tz.core.BaseController;
import com.tz.service.role.IRoleService;
import com.tz.service.user.IUserService;
import com.tz.util.TmStringUtils;


@Controller
public class LoginConlltroller extends BaseController{

	@Autowired
	private IUserService userService;
	@Autowired
	private IRoleService roleService;

	@RequestMapping("/login")
	public String index() {
		return "login";
	}

	@ResponseBody
	@RequestMapping(value="/logined",method=RequestMethod.POST)
	public String getlogin(TzParams params){
		
		if (params !=null) {
			if (TmStringUtils.isNotEmpty(params.getAccount()) && TmStringUtils.isNotEmpty(params.getPassword())) {
				params.setPassword(TmStringUtils.md5Base64(params.getPassword()));
				AdminUser user = userService.getLogin(params);
				if (user != null) {
					if (user.getForbiden() == 0) {
						return "forbiden";
					} else {
//						HashMap<String, Object> roleMap = roleService.findRolesByUserId(user.getId());
						request.getSession().setAttribute(SESSION_USER, user);
//						session.setAttribute(SESSION_USER_ROLE, roleMap);
						request.getSession().setAttribute(SESSION_USER_USERNAME, user.getUsername());
						//日记监控用户行为和获取请求参数
						request.getServletContext().setAttribute("user_log", user);
						request.getServletContext().setAttribute("request_log", request);
						return "success";
					}
				} else {
					return "fail";
				}
			} else {
				return "null";
			}
		} else {
			return "error";
		}
	}
	@RequestMapping("/logout")
	public String logout(){
		session.invalidate();
		return "redirect:login";
	}
}
