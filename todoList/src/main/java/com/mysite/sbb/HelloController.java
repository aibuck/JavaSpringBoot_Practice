package com.mysite.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
	
	@GetMapping("/hello")
	@ResponseBody
	public String hellow() {
		return "반갑소";
	}
	
	@GetMapping("/")
	public String hello() {
		return "redirect:/todo";
	}
}
