package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	// request.setAttribute() 와 같은 기능
	@RequestMapping(value = "/hello.do", method = RequestMethod.GET)
	public ModelAndView hello() {// 사용자가 만든 콜백메소드
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", "Hello Spring...");
		mav.setViewName("hello"); // 이름만 적기. 뒤에 확장자는 필요 없다.
		return mav;

	}
}
