package com.tz.web.content;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tz.bean.Content;
import com.tz.bean.TzParams;
import com.tz.service.content.impl.ContentServiceimpl;

@Controller
@RequestMapping("/admin/content")
public class ContentController {
	
	@Autowired
	private ContentServiceimpl contentService;
	@RequestMapping("/list")
	public String  list(TzParams params){
		
		return "content/list";
	}
	
	@RequestMapping("/template")
	public ModelAndView template(TzParams params){
		ModelAndView modelAndView = new ModelAndView();
		params.setIsDelete(0);
		List<Content> contents = contentService.findContents(params);
		int count = contentService.countContent(params);
		modelAndView.setViewName("content/template");
		modelAndView.addObject("datas",contents);
		modelAndView.addObject("itemCount",count);
		return modelAndView;
	}
	
	@ResponseBody
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(Content content){
		contentService.update(content);
		return "success";
	}
	
	@ResponseBody
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public String delete(TzParams params){
		contentService.delete(params);
		return "success";
	}
}
