package com.web.subject_Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.subject_Bean.Subject;
import com.web.subject_Bean.Sum_Subject;
import com.web.subject_Service.SubjectService;
import com.web.subject_purchase_record_Bean.Subject_purchase_record;
import com.web.sublect_bbin_purchase_record_Bean.Subject_bbin_purchase_record;

@Controller
public class SubjectController {

	@Autowired
	private SubjectService subjectService;

	
	
	//查询所有
	@RequestMapping("/listSubject")
	public String listSubject(Model model){
		List<Subject> listSubject = subjectService.listSubject();
		List<Sum_Subject> sum_subject = subjectService.listSum_subject();
		model.addAttribute("listSubject", listSubject);
		model.addAttribute("sum_subject", sum_subject);
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
		subjectService.updateSubject_purchase(id);
		return "redirect:/listSubject_Purchase_Record/"+subject_id;
	}
	
	//体验金购买列表
	@RequestMapping("/listSubject_bbin/{subject_id}")
	public String listSubject_bbin(@PathVariable("subject_id")int id,Model model){
		List<Subject_bbin_purchase_record> subject_bbin = subjectService.listSubject_bbin(id);
		model.addAttribute("subject_bbin", subject_bbin);
		return "listSubject_bbin";
	}
	
	//修改体验金还款
	@RequestMapping("/updateSubject_bbin/{id}/{subject_id}")
	public String updateSubject_bbin(@PathVariable("id")int id,@PathVariable("subject_id")int subject_id){
		subjectService.updateSubject_bbin(id);
		return "redirect:/listSubject_bbin/"+subject_id;
	}
	
}
