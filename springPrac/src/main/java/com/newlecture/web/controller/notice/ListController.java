package com.newlecture.web.controller.notice;

import java.lang.annotation.Annotation;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;


import com.newlecture.web.entity.Notice;
import com.newlecture.web.service.NoticeService;

@Controller("root.index")
public class ListController {

	@Autowired
	private NoticeService noticeService;

	

//	@Override
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
//
//		ModelAndView mv = new ModelAndView("notice.list");
//		// mv.setViewName("/WEB-INF/view/notice/list.jsp");
//		List<Notice> list = noticeService.getList(1, "TITLE", "");
//		mv.addObject("list", list);
//
//		return mv;
//	}



}
