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
	
//	@RequestMapping(value="/input.do", method=RequestMethod.GET)
//	public ModelAndView input() {
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("/sum/input");
//		return mav;
//	}
	
	@RequestMapping(value="/input.do", method=RequestMethod.GET)
	//@ResponseBody 뷰의 이름이 아니라 실제 문자열로 리턴할때 쓴다.
	public String input() { //리턴 타입이 string이면 단순 문자열이 아니라 뷰의 이름으로 인식/사용된다. 여기선 jsp 파일 명으로 인식한당
		return "/sum/input";
	}
	
	
	
//	@RequestMapping(value="/result.do", method=RequestMethod.GET)
//	public ModelAndView result() {
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("/sum/result");
//		return mav;		
//	}
	
//	@RequestMapping(value="/result.do", method=RequestMethod.GET)
//	public ModelAndView result(@RequestParam(required=false, defaultValue="0") String x,  //=>입력값이 없을 때 값을 0으로 만들어 준다. 값을 int로 받는 것 보다 string으로 받는 것이 좋다. 
//							   @RequestParam(required=false, defaultValue="0") String y ) { // NumberFormatException 예방.
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("x", x);
//		mav.addObject("y", y);
//		mav.setViewName("/sum/result");
//		return mav;		
//	}
	
//	@RequestMapping(value="/result.do", method=RequestMethod.GET) //맵으로 해도 되고 dto로 들어와도 된다. map은 모든 name을 키값으로 만들기때문에 특정 속성만 쓰고싶으면 dto로 잡으면된다.
//	public String result(@RequestParam Map<String, String> map, ModelMap modelMap) { //name 속성에 x라는 값이 들어오면 spring이 알아서 키 값을 x 로 만들어서 맵핑해준다.
//		modelMap.put("x", map.get("x"));
//		modelMap.put("y", map.get("y"));
//		return "/sum/result";		
//	}
	
	@RequestMapping(value="/result.do", method=RequestMethod.GET)
	public String result(@ModelAttribute SumDTO sumDTO, Model model) {
		model.addAttribute("sumDTO", sumDTO);
		return "/sum/result";		
	}
	
}
