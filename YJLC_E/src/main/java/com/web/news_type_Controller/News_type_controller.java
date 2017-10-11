package com.web.news_type_Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.news_type_Bean.News_type;
import com.web.news_type_Service.News_type_service;

@Controller
public class News_type_controller {

	@Autowired
	private News_type_service nts;
	
	//   咨询分类 查看所有
	@RequestMapping("/listnewstype")
	public String listAll(Model model){
		List<News_type> listAll=nts.listAll();
		model.addAttribute("listAll", listAll);
		return "college_Consultation_Type";
	}
	
	//   咨询分类 添加
	@RequestMapping("/addnewstype")
	public String addnewstype(News_type nt){
		nts.addnewstype(nt);
		return "redirect:/listnewstype";
	}
	
//	  //咨询分类 修改前的编辑
//	@RequestMapping("/getNews_type/{id}")
//	public String getNews_type(@PathVariable("id")int id,Model model){
//		News_type nt=nts.getNews_type(id);
//		model.addAttribute("nt", nt);
//		System.out.println(nt.getAddTime());
//		List<News_type> listAll=nts.listAll();
//		model.addAttribute("listAll", listAll);
//		return "updatecollege_Consultation_Type";
//	}
	
	//   咨询分类 修改
	@RequestMapping("/updatenewstype")
	public String updatenewstype(News_type nt){
		nts.updatenewstype(nt);
		return "redirect:/listnewstype";
	}
	//修改钱的查询
		@RequestMapping("/getNews_type/{id}")
		@ResponseBody
		public News_type getNews_type(@PathVariable("id")int id){
			News_type nt = nts.getNews_type(id);
			return nt;
		}
	
	
}
