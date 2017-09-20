package com.web.products_subject_controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.products_subject_service.ProductsService;
import com.web.subject_Bean.Subject;
import com.web.subject_purchase_record_Bean.Subject_purchase_record;

@Controller
@RequestMapping("/subject")
public class ProductsController {

	@Autowired
	private ProductsService subjectService;
	
	//查询固收类
	@RequestMapping("/listsubject")
	public String listsubject(Model model,String qname,String wname,String ename){
		Map map = new HashMap<>();
		map.put("qname", qname);
		map.put("wname", wname);
		map.put("ename", ename);
		List<Subject> listsubject = this.subjectService.listsubject(map);
		model.addAttribute("listsubject", listsubject);
		model.addAttribute("qname", qname);
		model.addAttribute("wname", wname);
		model.addAttribute("ename", ename);
		return "products_Solid _Collection";
	}
	
	//查看投资
	@RequestMapping("/listrecord/{id}")
	public String listrecord(Model model,@PathVariable("id")int id){
		List<Subject_purchase_record> listrecord = this.subjectService.listrecord(id);
		model.addAttribute("listrecord", listrecord);
		return "products_record";
	}
	
	//查询一行数据
	@RequestMapping("/editsubject/{id}")
	public String editsubject(@PathVariable("id")int id,Model model){
		Subject subject = this.subjectService.getsubjectid(id);
		model.addAttribute("subject", subject);
		return "products_edit";
	}
	
	//修改固收类
	@RequestMapping("/updatesubject")
	public String updatesubject(Subject subject){
		this.subjectService.updatesubject(subject);
		return "redirect:/subject/listsubject";
	}
	
	//跳转添加jsp
	@RequestMapping("/addsubject")
	public String addsubject(){
		return "products_add";
	}
	
	//保存固收类
	@RequestMapping("/savesubject")
	public String savesubject(Subject subject){
		this.subjectService.savesubject(subject);
		return "redirect:/subject/listsubject";
	}
}
