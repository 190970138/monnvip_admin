package com.tz.service.content;

import java.util.List;

import com.tz.bean.Content;
import com.tz.bean.TzParams;

public interface IContentService {
	
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
