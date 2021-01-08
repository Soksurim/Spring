package com.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bean.SumDTO;

@Controller
public class SumController {
//	@RequestMapping(value="input.do", method=RequestMethod.GET)
//	public ModelAndView input() {
//		ModelAndView mav = new ModelAndView();
//		//mav.setViewName("input");
//		mav.setViewName("/sum/input");
//		return mav;
//	}
	
	@RequestMapping(value="input.do", method=RequestMethod.GET)
	//리턴 타입이 String이면 단순 문자열이 아니라 뷰이름으로 사용된다
	//뷰이름이 아니라 실제 문자열로 리턴하고 싶을 때는 @ResponseBody를 붙인다.
	public String input() {
		return "/sum/input";
	}
	//-------------------
	
//	@RequestMapping(value="result.do", method=RequestMethod.GET)
//	public ModelAndView result() {
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("/sum/result");
//		return mav;
//	}
	
//	@RequestMapping(value="result.do", method=RequestMethod.GET)
//	public ModelAndView result(@RequestParam int x, @RequestParam int y) {
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("x", x);
//		mav.addObject("y", y);
//		mav.addObject("sum", x+y);
//		mav.setViewName("/sum/result");
//		return mav;
//	}
	
//	@RequestMapping(value="result.do", method=RequestMethod.GET)
//	public ModelAndView result(
//			@RequestParam(required=false, defaultValue = "0") String x, 
//			@RequestParam(required=false, defaultValue = "0") String y) {
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("x", x);
//		mav.addObject("y", y);
//		mav.addObject("sum", Integer.parseInt(x) + Integer.parseInt(y));
//		mav.setViewName("/sum/result");
//		return mav;
//	}
	
//	@RequestMapping(value="result.do", method=RequestMethod.GET)
//	public String result(@RequestParam Map<String, String> map, ModelMap modelMap) {
//		int x = Integer.parseInt(map.get("x"));
//		int y = Integer.parseInt(map.get("y"));
//		int sum = x+y;
//		
//		modelMap.put("x", map.get("x"));
//		modelMap.put("y", map.get("y"));
//		modelMap.put("sum", sum);
//		
//		return "/sum/result";
//	}

	@RequestMapping(value="result.do", method=RequestMethod.GET)
	public String result(@ModelAttribute SumDTO sumDTO, Model model) {
		model.addAttribute("x", sumDTO.getX());
		model.addAttribute("y", sumDTO.getY());
		model.addAttribute("sum", sumDTO.getX() + sumDTO.getY());
		
		return "/sum/result";
	}
}

















