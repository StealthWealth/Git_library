package com.web.products_subject_controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.web.bean.Subject_file;
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
	public String updatesubject(Subject subject,Subject_file subject_file,@RequestParam("file")MultipartFile file,HttpServletRequest request)throws Exception{
		this.subjectService.updatesubject(subject);
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmssssss");
		String type=file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
		String file_name=sdf.format(new Date())+type;
		
		//获取文件名
		String filename = file.getOriginalFilename();
		//获取上传的绝对路径  upload 手动创建
		String path = request.getRealPath("/upload/");
		//获取新的文件对象
		File newFile = new File(path, filename);
		if(!newFile.exists()){ //文件不存在
			//创建文件
			newFile.createNewFile();
		}
		//将文件内容放入新的文件
		file.transferTo(newFile);
		subject_file.setFile_name(file_name);
		this.subjectService.save_subject_file(subject_file);
		
		return "redirect:/subject/listsubject";
	}
	
	//跳转添加jsp
	@RequestMapping("/addsubject")
	public String addsubject(){
		return "products_add";
	}
	
	//保存固收类
	@RequestMapping("/savesubject")
	public String savesubject(Subject subject,Subject_file subject_file,@RequestParam("file")MultipartFile file,HttpServletRequest request)throws Exception{
		this.subjectService.savesubject(subject);
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmssssss");
		String type=file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
		String file_name=sdf.format(new Date())+type;
		
		//获取文件名
		String filename = file.getOriginalFilename();
		//获取上传的绝对路径  upload 手动创建
		String path = request.getRealPath("/upload/");
		//获取新的文件对象
		File newFile = new File(path, filename);
		if(!newFile.exists()){ //文件不存在
			//创建文件
			newFile.createNewFile();
		}
		//将文件内容放入新的文件
		file.transferTo(newFile);
		subject_file.setFile_name(file_name);
		this.subjectService.save_subject_file(subject_file);
		
		return "redirect:/subject/listsubject";
	}
	
	
	
		
	//算已投总金额
	@RequestMapping("/getTotalMoney")
	@ResponseBody
	public double getTotalMoney(int id){
		Subject subject = this.subjectService.getsubjectid(id);
		double num=0;
		Set<Subject_purchase_record> set = subject.getRecord();
		if (set.size()!=0) {
			Iterator<Subject_purchase_record> records = set.iterator();
			while(records.hasNext()){
				Subject_purchase_record record = records.next();
				num+=record.getAmount();
			}
		}
		return num;
	}
	
	
	
	
	
	
}
