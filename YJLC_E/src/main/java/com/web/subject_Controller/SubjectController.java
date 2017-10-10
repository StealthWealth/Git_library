package com.web.subject_Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

@Controller(value="SubjectController")
public class SubjectController {

	@Autowired
	private SubjectService subjectService;

	
	
	//查询所有
	@RequestMapping("/listSubject")
	public String listSubject(Model model,String MH_name,String MH_stats,String MH_type){
		System.out.println("MH_name:"+MH_name);
		Map map = new HashMap<>();
		
		if(MH_stats!=null && MH_stats.equals("-1")){
			MH_stats=null;
		}
		if(MH_type!=null && MH_type.equals("-1")){
			MH_type=null;
		}
		
		System.out.println("--MH_st:"+MH_stats);
		System.out.println("--type:"+MH_type);
		map.put("MH_name", MH_name);
		map.put("MH_stats", MH_stats);
		map.put("MH_type", MH_type);
		List<Subject> listSubject = subjectService.listSubject(map);
		List<Sum_Subject> sum_subject = subjectService.listSum_subject();
		for (Subject s:  listSubject) {
			for (Sum_Subject sum : sum_subject) {
				if(s.getId()==Integer.valueOf(sum.getSubject_id())){
					s.setBought(Integer.valueOf(sum.getCount()));
				}
			}
		}
		
		if(MH_stats==null){
			MH_stats="-1";
		}
		if(MH_type==null){
			MH_type="-1";
		}
		
		model.addAttribute("MH_type",MH_type);
		model.addAttribute("MH_name", MH_name);
		model.addAttribute("MH_stats", MH_stats);
		model.addAttribute("listSubject", listSubject);
		model.addAttribute("sum_subject", sum_subject);
		return "vip_plan";
	}
	
	//付息列表
	@RequestMapping("/listSubject_Purchase_Record/{id}")
	public String listSubject_Purchase_Record(@PathVariable("id")int id,Model model){
		List<Subject_purchase_record> listSubject_Purchase = subjectService.listSubject_Purchase_Record(id);
		Map map = new HashMap<>();
		for (Subject_purchase_record s : listSubject_Purchase) {
			Date date = s.getCreate_date(); //创建时间
			Date sumDate =addDate(date,s.getSubject().getPeriod());
			map.put(s.getId(), sumDate);
		}
		model.addAttribute("map", map);
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
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Map map = new HashMap<>();
		for (Subject_bbin_purchase_record s : subject_bbin) {
			Date date =s.getCreate_date(); //创建时间
			Date sumDate =addDate(date,s.getSubject().getPeriod());
			map.put(s.getId(), sumDate);
		}
		model.addAttribute("map", map);
		model.addAttribute("subject_bbin", subject_bbin);
		return "listSubject_bbin";
	}
	
	public static Date addDate(Date d,long day) {
		  long time = d.getTime(); 
		  day = day*24*60*60*1000; 
		  time+=day; 
		  return new Date(time);
		  }
	//修改体验金还款
	@RequestMapping("/updateSubject_bbin/{id}/{subject_id}")
	public String updateSubject_bbin(@PathVariable("id")int id,@PathVariable("subject_id")int subject_id){
		subjectService.updateSubject_bbin(id);
		return "redirect:/listSubject_bbin/"+subject_id;
	}
	
}
