/**
 * tzdesk系统平台
 * moonvip_admin
 * com.tz.dao.user
 * IUserMapper.java
 * 创建人:xuchengfei 
 * 时间：2015年11月24日-上午12:40:28 
 * 2015潭州教育公司-版权所有
 */
package com.tz.dao.content;

import java.util.List;

import com.tz.bean.Content;
import com.tz.bean.TzParams;

/**
 * 
 * IUserMapper
 * 创建人:xuchengfei 
 * 时间：2015年11月24日-上午12:40:28 
 * @version 1.0.0
 * 
 */
public interface IContentMapper {

	/**
	 * 查询所有内容
	 * com.tz.dao.user 
	 * 方法名：getLogin
	 * 创建人：xuchengfei 
	 * 手机号码:15074816437
	 * 时间：2015年11月24日-上午12:41:22 
	 * @param account
	 * @param password
	 * @return 
	 * 返回类型：User
	 * @exception 
	 * @since  1.0.0
	 */
	public List<Content> findContents(TzParams params);
	
	/**
	 * 求总数
	 * @param params
	 * @return
	 */
	public int countContent(TzParams params);
	
	/**
	 * 更新状态
	 * @param content
	 * @return
	 */
	public int update(Content content);
	
	/**
	 * 删除
	 * @param params
	 * @return
	 */
	public int delete(TzParams params);
}
