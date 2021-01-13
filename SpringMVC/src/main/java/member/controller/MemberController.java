package member.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import member.service.MemberService;

@Controller
@RequestMapping(value="member")
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="loginForm", method=RequestMethod.GET)
	public String loginForm() {
		return "/member/loginForm";
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	@ResponseBody
	public String login(@RequestParam Map<String, String> map, HttpSession session) {
		return memberService.login(map, session);
	}
	
	@RequestMapping(value="logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "/index";
	}
}












