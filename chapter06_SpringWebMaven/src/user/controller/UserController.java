package user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import user.bean.UserDTO;
import user.service.UserService;

@Controller
@RequestMapping("/user") 
// 만약 /user/write로 들어갈때, 이 클래스로 들어온 순간 /user는 기본으로 깔고 간다.
// 다음으로 write 메소드가 실행될때 /write가 추가된다.
public class UserController {
	@Autowired
	private UserService userService;
	
	//@RequestMapping(value="/user/writeForm", method=RequestMethod.GET)
	@RequestMapping(value="/writeForm", method=RequestMethod.GET)
	public String writeForm() {
		return "/user/writeForm";
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list() {
		return "/user/list";
	}
	

	
	@RequestMapping(value="getUserList", method=RequestMethod.POST)
	@ResponseBody // getUserList.jsp 로 가는게 아니라 list로 돌아가야 함.
	public Object getUserList() {
		List<UserDTO> list = userService.getList();
		System.out.println(list);
		
		JSONObject json = new JSONObject();
//		JSONObject json = (JSONArray) list;
		
		if(list != null) {
			JSONArray array = new JSONArray();
			
			for(int i = 0; i < list.size(); i++) {
				UserDTO dto = list.get(i);
				
				JSONObject temp = new JSONObject();
				temp.put("name", dto.getName());
				temp.put("id", dto.getId());
				temp.put("pwd", dto.getPwd());
				
				array.add(i, temp);
				
			}//for
			
			json.put("list", array);
			System.out.println(json);
			
			return json;
		}
		
		return json;
	}
	
//		if(list != null) {
//			for(UserDTO data : list) {
//				System.out.println(data);
//			}
//		}
//		
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("list", list);
//		mav.setViewName("/user/list");
//		return mav;
	
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public @ResponseBody void write(@ModelAttribute UserDTO userDTO) {
		userService.write(userDTO);
		// ajax로  페이지를 이동하지 않고 데이터를 db에 저장 후, writeForm으로 돌아오기 떄문에  return은 쓰이지 않는다.
//		return "/user/write";
	}
	
	@RequestMapping(value="/checkId", 
			produces="application/String;charset=UTF-8", 
			method=RequestMethod.GET)
	@ResponseBody // viewResolver의 영향을 받지않고 불러온 곳(writeForm)으로 다시 돌아간다.
	public String checkId(String id) {
		
		String result = userService.checkId(id);
		
			System.out.println(result);
		
			return result;
		
	}	
	
	
	@RequestMapping(value="/modifyForm", method=RequestMethod.GET)
	public String modifyForm() {
		return "/user/modifyForm";
	}
	
	@RequestMapping(value="/getUser", method=RequestMethod.POST)
	@ResponseBody 
	public JSONObject getUser(@RequestParam String id) { // RequestParam 데이터 하나 받을 때.
		UserDTO dto = userService.getUser(id);
		JSONObject json = new JSONObject();
		
		if(dto != null) {
			json.put("name", dto.getName());
			json.put("id", dto.getId());
			json.put("pwd", dto.getPwd());
		}
		
		return json;
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	@ResponseBody
	public void modify(@ModelAttribute UserDTO userDTO) {
		userService.modify(userDTO);
	}
	
}

