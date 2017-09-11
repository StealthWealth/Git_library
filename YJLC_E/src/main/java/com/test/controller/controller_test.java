package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class controller_test {

	@RequestMapping("/sy")
	public String sy() {
		return "homePage";		
	}
}
