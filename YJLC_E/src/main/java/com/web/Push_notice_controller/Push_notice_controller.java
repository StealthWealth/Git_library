package com.web.Push_notice_controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.Push_notice_service.Push_notice_service;
import com.web.font_bean.Push_notice;

@Controller
@RequestMapping("/notice")
public class Push_notice_controller {

	@Autowired
	private Push_notice_service pns;
	
	@RequestMapping("/listnotice")
	public String listnotice(Push_notice notice,Model model,String qname){
		Map map = new HashMap<>();
		map.put("qname", qname);
		
		List<Push_notice> list = this.pns.listnotice(map);
		model.addAttribute("listnotice", list);
		model.addAttribute("qname", qname);
		
		return "setUp_Announcement";
	}
	
	@RequestMapping("/addnotice")
	public String addnotice(){
		return "add_push_notice";
	}
	
	@RequestMapping("/savenotice")
	public String savenotice(Push_notice notice){
		this.pns.savenotice(notice);
		return "redirect:/notice/listnotice";
	}
	
	@RequestMapping("/edit/{id}")
	public String editnotice(@PathVariable("id")int id,Model model){
		Push_notice notice = this.pns.getNoticeId(id);
		model.addAttribute("editnotice", notice);
		return "update_push_notice";
	}
	
	@RequestMapping("/updatenotice")
	public String updatenotice(Push_notice notice){
		this.pns.updatenotice(notice);
		return "redirect:/notice/listnotice";
	}
}
