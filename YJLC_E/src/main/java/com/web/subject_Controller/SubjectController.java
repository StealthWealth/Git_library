package com.web.subject_Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.subject_Bean.Subject;
import com.web.subject_Service.SubjectService;
import com.web.subject_purchase_record_Bean.Subject_purchase_record;

@Controller(value="SubjectController")
public class SubjectController {

	@Autowired
	private SubjectService subjectService;

	
	
	//查询所有
	@RequestMapping("/listSubject")
	public String listSubject(Model model){
		List<Subject> listSubject = subjectService.listSubject();
		model.addAttribute("listSubject", listSubject);
		return "vip_plan";
	}
	
	//付息列表
	@RequestMapping("/listSubject_Purchase_Record/{id}")
	public String listSubject_Purchase_Record(@PathVariable("id")int id,Model model){
		List<Subject_purchase_record> listSubject_Purchase = subjectService.listSubject_Purchase_Record(id);
		model.addAttribute("listSubject_Purchase", listSubject_Purchase);
		return "listSubject_Purchase_Record";
	}
	
	
	//付息列表还款
	@RequestMapping("/updateSubject_Purchase/{id}/{subject_id}")
	public String updateSubject_Purchase(@PathVariable("id")int id,@PathVariable("subject_id")int subject_id){
		System.out.println("-------------------------------"+id);
		subjectService.updateSubject_purchase(id);
		return "redirect:/listSubject_Purchase_Record/"+subject_id;
	}
	
	
}
