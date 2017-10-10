package com.web.news_Controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.web.news_Bean.News;
import com.web.news_Service.NewsService;
import com.web.news_type_Bean.News_type;

@Controller
public class NewsController {

	@Autowired
	private NewsService newsService;

	//��ѯ����
	@RequestMapping("/listNews")
	public String listNews(Model model,String MH_title,String type_name){
		
		if(type_name!=null && type_name.equals("-1")){
			type_name=null;
		}
		System.out.println("type_name:"+type_name);
		
		Map map = new HashMap<>();
		map.put("MH_title", MH_title);
		map.put("type_name", type_name);
		
		
		
		List<News> listNews = newsService.listNews(map);
		model.addAttribute("listNews",listNews);
		List<News_type> listNews_type = newsService.listNews_type();
		model.addAttribute("listNews_type", listNews_type);
		
		model.addAttribute("MH_title", MH_title);
		model.addAttribute("type_name", type_name);
		return "college_Consultation_Administration";
	}
	
	//��ѯ�������
	@RequestMapping("/getAddCollege")
	public String getAddCollege(Model model){
		List<News_type> listNews_type = newsService.listNews_type();
		model.addAttribute("listNews_type", listNews_type);
		model.addAttribute("typeId", 1);
		return "addCollege";
	}
	
	
	//���
	@RequestMapping("/add")
	public String add(News news,int typeId){

		News_type news_type = newsService.getNews_type(typeId);
		news.setNews_type(news_type);
		news.setClickNumber(0);
		news.setAddId(0);
		news.setAudit(0);
		news.setUpdId(0);
		Date date = new Date();
		
		news.setAddTime((new SimpleDateFormat("yyyy-MM-dd")).format(date));
		news.setcPhoto("/upload/"+news.getcPhoto());
		newsService.add(news);
		return "redirect:/listNews";
	}
	
	
	//�����ļ��ϴ�
		@RequestMapping("/uploadFile")
		public String upload(@RequestParam(value="file")MultipartFile file,String typeId,HttpServletRequest request,News news,Model model) throws IOException{
			List<News_type> listNews_type = newsService.listNews_type();
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
			news.setcPhoto(newFile.getName());
			model.addAttribute("typeId", typeId);
			model.addAttribute("listNews_type", listNews_type);
			model.addAttribute("news", news);
			return "addCollege";
		}
		
		
		//ɾ��
		@RequestMapping("/delete/{id}")
		public String delete(@PathVariable("id")int id){
			newsService.delete(id);
			return "redirect:/listNews";
		}
		
		
		//�޸�ǰ�Ĳ�ѯ
		@RequestMapping("/updateNews/{id}")
		public String getNews(@PathVariable("id")int id,Model model){
			News news = newsService.getNews(id);
			int  typeId = news.getNews_type().getId();
			List<News_type> listNews_type = newsService.listNews_type();
			model.addAttribute("listNews_type", listNews_type);
			model.addAttribute("news", news);
			model.addAttribute("typeId", typeId);
			return "updateNews";
		}
		
		//�޸�ͼƬԤ��
			@RequestMapping("/updateFile")
			public String updateFile(@RequestParam(value="file")MultipartFile file,News news,String typeId,HttpServletRequest request,Model model) throws IOException{
				
				
				List<News_type> listNews_type = newsService.listNews_type();
				
				//��ȡ�ļ���
				String filename = file.getOriginalFilename();
				//��ȡ�ϴ��ľ���·��  upload �ֶ�����
				String path = request.getRealPath("/upload/");
				System.out.println("-------path:"+path);
				//��ȡ�µ��ļ�����
				File newFile = new File(path, filename);
				if(!newFile.exists()){ //�ļ�������
					//�����ļ�
					newFile.createNewFile();
				}
				//���ļ����ݷ����µ��ļ�
				file.transferTo(newFile);
				news.setcPhoto("upload/"+newFile.getName());
				model.addAttribute("typeId", typeId);
				model.addAttribute("listNews_type", listNews_type);
			//	model.addAttribute("news",news);
				return "updateNews";
			}
			
			
			//�޸�
			@RequestMapping("/update")
			public String update(News news,int typeId) throws ParseException{
				
				News_type news_type = newsService.getNews_type(typeId);
				news.setNews_type(news_type);
				news.setClickNumber(0);
				news.setAudit(0);
				news.setUpdId(0);
				news.setAddId(0);
				Date date = new Date();
				news.setUpdTime(date);
				newsService.update(news);
				return "redirect:/listNews";
			}
		
}
