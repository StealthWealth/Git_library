package com.font.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.font.service.FontService;

@Controller
@RequestMapping("/user")
public class FontController {

	@Autowired
	private FontService fontService;
	

	
}
