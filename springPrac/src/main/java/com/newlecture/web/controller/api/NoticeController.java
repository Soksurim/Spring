package com.newlecture.web.controller.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("apiNoticeController") // 메소드에 @ResponseBody를 건 효과
@RequestMapping("/api/notice/")
public class NoticeController {

	@RequestMapping("list")
	public String list() {
		return "text";
	}
}
