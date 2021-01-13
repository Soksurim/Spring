package member.service;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import member.bean.MemberDTO;
import member.dao.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDAO memberDAO;

	@Override
	public String login(Map<String, String> map, HttpSession session) {
		MemberDTO memberDTO = memberDAO.login(map);
		
		if(memberDTO == null) {
			return "fail";
		}else {
			//세션
			session.setAttribute("memName", memberDTO.getName());
			session.setAttribute("memId", map.get("id"));
			session.setAttribute("memEmail", memberDTO.getEmail1()+"@"+memberDTO.getEmail2());
			
			return "success";
		}
	}

}




