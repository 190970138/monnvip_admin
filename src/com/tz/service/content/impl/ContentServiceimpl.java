package com.tz.service.content.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tz.bean.Content;
import com.tz.bean.TzParams;
import com.tz.dao.content.IContentMapper;
import com.tz.service.content.IContentService;
import com.tz.util.TmStringUtils;

@Service
public class ContentServiceimpl implements IContentService {
	@Autowired
	private IContentMapper contentMapper;
	@Override
	public List<Content> findContents(TzParams params) {
		if (TmStringUtils.isEmpty(params.getOrder())){
			params.setOrder("create_time desc");
		}
		return contentMapper.findContents(params);
	}
	@Override
	public int countContent(TzParams params) {
		return contentMapper.countContent(params);
	}
	@Override
	public int update(Content content) {
		return contentMapper.update(content);
	}
	@Override
	public int delete(TzParams params) {
		
		return contentMapper.delete(params);
	}

}
