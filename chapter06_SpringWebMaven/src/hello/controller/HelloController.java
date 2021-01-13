package hello.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class HelloController {
//	@RequestMapping(value="/hello", method=RequestMethod.GET)
//	public @ResponseBody String hello() {
//		return "안녕하세요 JSON!!";
//	}
	
//	@RequestMapping(value="/hello", method=RequestMethod.GET)
//	public @ResponseBody JSONObject hello() {
//		JSONObject json = new JSONObject();
//		json.put("name", "hong");
//		json.put("age", 25);
//		return json;
//	}
	
//	@RequestMapping(value="/hello", method=RequestMethod.GET)
//	public @ResponseBody Map<String, Object> hello() {
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("name", "홍길동");
//		map.put("age", 25);
//		return map;
//	}
	
//	@RequestMapping(value="/hello", method=RequestMethod.GET)
//	public @ResponseBody JSONArray hello() {
//		JSONArray array = new JSONArray();
//		
//		JSONObject temp = new JSONObject();
//		temp.put("name", "홍길동");
//		temp.put("age", 25);
//		array.add(0, temp);
//		
//		temp = new JSONObject();
//		temp.put("name", "코난");
//		temp.put("age", 17);
//		array.add(1, temp);
//		
//		return array;		
//	}
	
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public @ResponseBody JSONObject hello() {
		JSONArray array = new JSONArray();
		
		JSONObject temp = new JSONObject();
		temp.put("name", "홍길동");
		temp.put("age", 25);
		array.add(0, temp);
		
		temp = new JSONObject();
		temp.put("name", "코난");
		temp.put("age", 17);
		array.add(1, temp);
		
		JSONObject json = new JSONObject();
		json.put("json", array);
		return json;
	}
}












