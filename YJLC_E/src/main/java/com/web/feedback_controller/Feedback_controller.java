package com.web.feedback_controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.bean.Feedback;
import com.web.feedback_service.Feedback_service;

@Controller
@RequestMapping("/feedback")
public class Feedback_controller {

	@Autowired
	private Feedback_service fs;
	
	@RequestMapping("/listfeedback")
	public String listfeedback(Model model){
		List<Feedback> list = this.fs.listfeedback();
		model.addAttribute("listfeedback", list);
		return "setUp_Opinion";
	}
}
