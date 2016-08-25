/**
 * tzdesk系统平台
 * springmvc2
 * com.tz.test
 * TestApplicationContext.java
 * 创建人:xuchengfei 
 * 时间：2015年11月18日-上午11:35:24 
 * 2015潭州教育公司-版权所有
 */
package com.tz.test;

import java.util.HashMap;
import java.util.List;

import javax.management.loading.PrivateClassLoader;

import org.apache.ibatis.session.SqlSession;
import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.druid.pool.DruidDataSource;
import com.tz.bean.AdminStat;
import com.tz.bean.AdminUser;
import com.tz.bean.Content;
import com.tz.bean.TzParams;
import com.tz.bean.User;
import com.tz.dao.adminstat.IStatMapper;
import com.tz.dao.user.IUserMapper;

import sun.net.www.content.text.plain;

import com.tz.service.adminstat.IAdminStatService;
import com.tz.service.adminstat.IStatService;
import com.tz.service.adminstat.impl.StatService;
import com.tz.service.adminuser.IAdminUserService;
import com.tz.service.content.impl.ContentServiceimpl;
import com.tz.service.user.IUserService;
import com.tz.service.user.impl.UserServiceImpl;

/**
 * 
 * TestApplicationContext
 * 创建人:xuchengfei 
 * 时间：2015年11月18日-上午11:35:24 
 * @version 1.0.0
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class TestApplicationContext {
	@Autowired
	private IUserMapper mapper;
	@Autowired
	private UserServiceImpl userService;
	@Autowired
	private ContentServiceimpl contentService;
	@Autowired
	private IAdminStatService adminStatser;
	
	@Autowired
	private IStatService statSer;
	
	@Autowired
	private IStatMapper statMa;
	
	@Autowired
	private IAdminUserService adminUserSer;
//	@Autowired
//	IUserService service;
//	@Autowired
//	ICorpInfoService corpInfoService;
	@Test
	public void handler() throws JSONException{
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
//		DruidDataSource dataSource = context.getBean(DruidDataSource.class);
//		System.out.println("============"+dataSource);
//		SqlSession session = context.getBean(SqlSession.class);
//		SqlSession session2 =(SqlSession) context.getBean("sqlSession");
//		System.out.println("====="+session);
//		System.out.println("====="+session2);
//		System.out.println("====="+session3);
		
//		IUserMapper mapper = context.getBean(IUserMapper.class);
//		System.out.println(mapper+"======================");		
				
//		TzParams params = new TzParams();
//		params.setAccount("1212");
//		params.setPassword("123213");
//		User user = mapper.getLogin(params);
//		System.out.println("======++++======="+user.getUsername());		
		
		
//		TzParams params1 = new TzParams();
//		params1.setAccount("1212");
//		params1.setPassword("123213");
//		AdminUser user1 = userService.getLogin(params1);
//		System.out.println("======++++======="+user1.getUsername());		
				
//		TzParams params = new TzParams();
//		params.setAccount("keke");
//		params.setPassword("123");
//		User user = service.getLogin(params);
//		System.out.println("======++++======="+user.getUsername());				
		
		
//		TzParams params = new TzParams();
//		params.setId(1);
//		params.setPackageId(1);;
//		CorpInfo corplnfo2 =corpInfoService.findSelet(params);
//		System.out.println("======="+corplnfo2.getCorpName());
		
		TzParams params = new TzParams();
		List<Content> list = contentService.findContents(params);
		for (Content content : list) {
			System.out.println(content.getTitle());
		}
	}
	
	@Test
	public  void handler1() throws JSONException{
		TzParams params = new TzParams();
		params.setKeyword("w");
		List<Content> list = contentService.findContents(params);
		JSONUtil.serialize(list);
		
	}
	@Test
	public void handler2(){
		Content content = new Content();
		content.setIsDelete(1);
		content.setId(1);
		content.setPush(0);
		contentService.update(content);
	}
	
	@Test
	public void handler3(){
		TzParams params = new  TzParams();
		params.setId(1);
		params.setId(2);
		contentService.delete(params);
	}
	
	
	@Test
	public void handler4(){
		AdminStat adminStat = new AdminStat();
		adminStat.setClassname("2121");
		adminStat.setIp("21221234");
		adminStat.setIpAddress("33455");
		adminStat.setMethod("33455");
		adminStat.setTime((long) 33455);
		adminStat.setUserId(2121);
		adminStat.setUsername("33455");
		adminStat.setModel("33455");
		adminStat.setDescription("33455");
		
	
		adminStatser.save(adminStat);
	}
	
	@Test
	public void handler5() throws JSONException{
		TzParams params = new TzParams();
		params.setYear(2016);
		List<HashMap<String , Object>>  list= statSer.groupContent(params);
		System.out.println(JSONUtil.serialize(list));
		
//		[{"num":1,"M":"06"},{"num":23,"M":"07"}]
//		[{num=1, M=06}, {num=23, M=07}]
	}
	
	
	@Test
	public void handler6() {
		TzParams params = new TzParams();
		params.setId(2);
		adminUserSer.delete(params);
		
	}
	
	
	@Test
	public void handler7() {
		TzParams params = new TzParams();
		params.setId(1);
		statMa.groupContent(params);
		
	}
}

