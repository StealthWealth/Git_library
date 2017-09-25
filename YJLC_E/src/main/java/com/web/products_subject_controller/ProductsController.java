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
	
	//��ѯ������
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
	
	//�鿴Ͷ��
	@RequestMapping("/listrecord/{id}")
	public String listrecord(Model model,@PathVariable("id")int id){
		List<Subject_purchase_record> listrecord = this.subjectService.listrecord(id);
		model.addAttribute("listrecord", listrecord);
		return "products_record";
	}
	
	//��ѯһ������
	@RequestMapping("/editsubject/{id}")
	public String editsubject(@PathVariable("id")int id,Model model){
		Subject subject = this.subjectService.getsubjectid(id);
		model.addAttribute("subject", subject);
		return "products_edit";
	}
	
	//�޸Ĺ�����
	@RequestMapping("/updatesubject")
	public String updatesubject(Subject subject,Subject_file subject_file,@RequestParam("file")MultipartFile file,HttpServletRequest request)throws Exception{
		this.subjectService.updatesubject(subject);
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmssssss");
		String type=file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
		String file_name=sdf.format(new Date())+type;
		
		//��ȡ�ļ���
		String filename = file.getOriginalFilename();
		//��ȡ�ϴ��ľ���·��  upload �ֶ�����
		String path = request.getRealPath("/upload/");
		//��ȡ�µ��ļ�����
		File newFile = new File(path, filename);
		if(!newFile.exists()){ //�ļ�������
			//�����ļ�
			newFile.createNewFile();
		}
		//���ļ����ݷ����µ��ļ�
		file.transferTo(newFile);
		subject_file.setFile_name(file_name);
		this.subjectService.save_subject_file(subject_file);
		
		return "redirect:/subject/listsubject";
	}
	
	//��ת���jsp
	@RequestMapping("/addsubject")
	public String addsubject(){
		return "products_add";
	}
	
	//���������
	@RequestMapping("/savesubject")
	public String savesubject(Subject subject,Subject_file subject_file,@RequestParam("file")MultipartFile file,HttpServletRequest request)throws Exception{
		this.subjectService.savesubject(subject);
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmssssss");
		String type=file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
		String file_name=sdf.format(new Date())+type;
		
		//��ȡ�ļ���
		String filename = file.getOriginalFilename();
		//��ȡ�ϴ��ľ���·��  upload �ֶ�����
		String path = request.getRealPath("/upload/");
		//��ȡ�µ��ļ�����
		File newFile = new File(path, filename);
		if(!newFile.exists()){ //�ļ�������
			//�����ļ�
			newFile.createNewFile();
		}
		//���ļ����ݷ����µ��ļ�
		file.transferTo(newFile);
		subject_file.setFile_name(file_name);
		this.subjectService.save_subject_file(subject_file);
		
		return "redirect:/subject/listsubject";
	}
	
	
	
		
	//����Ͷ�ܽ��
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
