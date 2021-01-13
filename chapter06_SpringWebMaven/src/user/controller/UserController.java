package user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
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
public class UserController {
	@Autowired
	private UserService userService;
	
	//@RequestMapping(value="/user/writeForm", method=RequestMethod.GET)
	@RequestMapping(value="/writeForm", method=RequestMethod.GET)
	public String writeForm() {
		return "/user/writeForm";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	@ResponseBody
	public void write(@ModelAttribute UserDTO userDTO) {
		userService.write(userDTO);
	}
	
	@RequestMapping(value="/checkId", 
					produces = "application/String;charset=UTF-8",
					method=RequestMethod.POST)
	public @ResponseBody String checkId(String id) {
		String result = userService.checkId(id);
		return result;
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list() {
		return "/user/list";
	}
	
//	@RequestMapping(value="getUserList", method=RequestMethod.POST)
//	@ResponseBody
//	public JSONObject getUserList(){
//		List<UserDTO> list = userService.getUserList();
//		
//		JSONObject json = new JSONObject();
//		if(list != null) {
//			JSONArray array = new JSONArray();
//			
//			for(int i=0; i<list.size(); i++) {
//				UserDTO userDTO = list.get(i);
//				
//				JSONObject temp = new JSONObject();
//				temp.put("name", userDTO.getName());
//				temp.put("id", userDTO.getId());
//				temp.put("pwd", userDTO.getPwd());
//				
//				array.add(i, temp);
//			}//for
//			
//			json.put("list", array);
//		}
//		
//		System.out.println(json);
//		return json;
//	}
	
//	@RequestMapping(value="getUserList", method=RequestMethod.POST)
//	@ResponseBody
//	public Map getUserList(){
//		List<UserDTO> list = userService.getUserList();
//		
//		JSONArray array = JSONArray.fromObject(list);
//		Map map = new HashMap();
//		map.put("list", array);
//		return map;
//	}
	
	@RequestMapping(value="getUserList", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView getUserList(){
		List<UserDTO> list = userService.getUserList();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.setViewName("jsonView");
		return mav;
	}
	
	@RequestMapping(value="/modifyForm", method=RequestMethod.GET)
	public String modifyForm() {
		return "/user/modifyForm";
	}
	
	@RequestMapping(value="/getUser", method=RequestMethod.POST)
	@ResponseBody
	public JSONObject getUser(@RequestParam String id) {
		UserDTO userDTO = userService.getUser(id);
		
		JSONObject json = new JSONObject();
		if(userDTO != null) {
			json.put("name", userDTO.getName());
			json.put("id", userDTO.getId());
			json.put("pwd", userDTO.getPwd());
		}
		
		return json;
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	@ResponseBody
	public void modify(@ModelAttribute UserDTO userDTO) {
		userService.modify(userDTO);
	}
	
	@RequestMapping(value="/deleteForm", method=RequestMethod.GET)
	public String deleteForm() {
		return "/user/deleteForm";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	@ResponseBody
	public void delete(@RequestParam String id) {
		userService.delete(id);
	}
	
	@RequestMapping(value="/search", method=RequestMethod.POST)
	@ResponseBody
	//public JSONObject search(@RequestParam String searchOption, @RequestParam String searchText){
	//public JSONObject search(@RequestParam Map<String, String> map){
	//------------------
	public JSONObject search(@RequestBody Map<String, String> map) {
		System.out.println(map);
		
		//List<UserDTO> list = userService.search(searchOption, searchText);
		List<UserDTO> list = userService.search(map);
		
		JSONObject json = new JSONObject();
		if(list != null) {
			JSONArray array = new JSONArray();
			
			for(int i=0; i<list.size(); i++) {
				UserDTO userDTO = list.get(i);
				
				JSONObject temp = new JSONObject();
				temp.put("name", userDTO.getName());
				temp.put("id", userDTO.getId());
				temp.put("pwd", userDTO.getPwd());
				
				array.add(i, temp);
			}//for
			
			json.put("list", array);
		}
		
		System.out.println(json);
		return json;
	}
}

























