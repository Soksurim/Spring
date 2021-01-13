package member.service;

import java.util.Map;

import javax.servlet.http.HttpSession;

public interface MemberService {

	public String login(Map<String, String> map, HttpSession session);

}
