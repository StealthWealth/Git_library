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

	//查询所有
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
	
	//查询所有类别
	@RequestMapping("/getAddCollege")
	public String getAddCollege(Model model){
		List<News_type> listNews_type = newsService.listNews_type();
		model.addAttribute("listNews_type", listNews_type);
		model.addAttribute("typeId", 1);
		return "addCollege";
	}
	
	
	//添加
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
	
	
	//单个文件上传
		@RequestMapping("/uploadFile")
		public String upload(@RequestParam(value="file")MultipartFile file,String typeId,HttpServletRequest request,News news,Model model) throws IOException{
			List<News_type> listNews_type = newsService.listNews_type();
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
			news.setcPhoto(newFile.getName());
			model.addAttribute("typeId", typeId);
			model.addAttribute("listNews_type", listNews_type);
			model.addAttribute("news", news);
			return "addCollege";
		}
		
		
		//删除
		@RequestMapping("/delete/{id}")
		public String delete(@PathVariable("id")int id){
			newsService.delete(id);
			return "redirect:/listNews";
		}
		
		
		//修改前的查询
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
		
		//修改图片预览
			@RequestMapping("/updateFile")
			public String updateFile(@RequestParam(value="file")MultipartFile file,News news,String typeId,HttpServletRequest request,Model model) throws IOException{
				
				
				List<News_type> listNews_type = newsService.listNews_type();
				
				//获取文件名
				String filename = file.getOriginalFilename();
				//获取上传的绝对路径  upload 手动创建
				String path = request.getRealPath("/upload/");
				System.out.println("-------path:"+path);
				//获取新的文件对象
				File newFile = new File(path, filename);
				if(!newFile.exists()){ //文件不存在
					//创建文件
					newFile.createNewFile();
				}
				//将文件内容放入新的文件
				file.transferTo(newFile);
				news.setcPhoto("upload/"+newFile.getName());
				model.addAttribute("typeId", typeId);
				model.addAttribute("listNews_type", listNews_type);
			//	model.addAttribute("news",news);
				return "updateNews";
			}
			
			
			//修改
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
