package com.web.news_Controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
	public String listNews(Model model){
		List<News> listNews = newsService.listNews();
		model.addAttribute("listNews",listNews);
		return "college_Consultation_Administration";
	}
	
	//查询所有类别
	@RequestMapping("/getAddCollege")
	public String getAddCollege(Model model){
		List<News_type> listNews_type = newsService.listNews_type();
		model.addAttribute("listNews_type", listNews_type);
		return "addCollege";
	}
	
	
	//添加
	@RequestMapping("/add")
	public String add(HttpServletRequest request){
		//获取表单数据
		String title = request.getParameter("title");
		String typeId = request.getParameter("typeId");
		String subTitle = request.getParameter("subTitle");
		String sort = request.getParameter("sort");
		String link = request.getParameter("link");
		String author = request.getParameter("author");
		String source = request.getParameter("source");
		String label = request.getParameter("label");
		String text = request.getParameter("text");
		String filelink = request.getParameter("filelink");
		String seoTitle = request.getParameter("seoTitle");
		String seoKey = request.getParameter("seoKey");
		String seoDes = request.getParameter("seoDes");
		String placTop = request.getParameter("placTop");
		String recommend = request.getParameter("recommend");
		String editor = request.getParameter("editor"); //简介
		String fileName = request.getParameter("fileName");  //图片
		
		News news = new News();
		news.setTitle(title);
		News_type news_type = newsService.getNews_type(Integer.valueOf(typeId));
		news.setNews_type(news_type);
		news.setSubTitle(subTitle);
		news.setSort(Integer.valueOf(sort));
		news.setInfo(editor);
		news.setLink(link);
		news.setAuthor(author);
		news.setSource(source);
		news.setLabel(label);
		news.setClickNumber(0);
		news.setText(text); //内容
		news.setFilelink(filelink);
		news.setSeoTitle(seoTitle);
		news.setSeoKey(seoKey);
		news.setSeoDes(seoDes);
		news.setPlacTop(Integer.valueOf(placTop));
		news.setRecommend(Integer.valueOf(recommend));
		news.setAudit(0);
		news.setUpdId(0);
		news.setcPhoto("/upload/"+fileName);
		Date date = new Date();
		news.setAddTime(date);
		newsService.add(news);
		
		
		return "redirect:/listNews";
	}
	
	
	//单个文件上传
		@RequestMapping("/uploadFile")
		public String upload(@RequestParam(value="cPhoto")MultipartFile cPhoto,HttpServletRequest request,Model model) throws IOException{
			
			//获取表单数据
			String title = request.getParameter("title");
			String typeId = request.getParameter("typeId");
			String subTitle = request.getParameter("subTitle");
			String sort = request.getParameter("sort");
			String link = request.getParameter("link");
			String author = request.getParameter("author");
			String source = request.getParameter("source");
			String label = request.getParameter("label");
			String text = request.getParameter("text");
			String filelink = request.getParameter("filelink");
			String seoTitle = request.getParameter("seoTitle");
			String seoKey = request.getParameter("seoKey");
			String seoDes = request.getParameter("seoDes");
			String placTop = request.getParameter("placTop");
			String recommend = request.getParameter("recommend");
			String audit = request.getParameter("audit");
			String editor = request.getParameter("editor"); //简介
			
			if(placTop==null){
				placTop="0";
			}
			if(recommend==null){
				recommend="0";
			}
			
			List<News_type> listNews_type = newsService.listNews_type();
			model.addAttribute("listNews_type", listNews_type);
			model.addAttribute("editor", editor);
			model.addAttribute("audit", audit);
			model.addAttribute("recommend", recommend);
			model.addAttribute("placTop", placTop);
			model.addAttribute("seoDes", seoDes);
			model.addAttribute("seoKey", seoKey);
			model.addAttribute("seoTitle", seoTitle);
			model.addAttribute("filelink", filelink);
			model.addAttribute("text", text);
			model.addAttribute("label", label);
			model.addAttribute("source", source);
			model.addAttribute("author", author);
			model.addAttribute("link", link);
			model.addAttribute("sort", sort);
			model.addAttribute("subTitle", subTitle);
			model.addAttribute("typeId", typeId);
			model.addAttribute("title", title);
			
			//获取文件名
			String filename = cPhoto.getOriginalFilename();
			System.out.println("filename:"+filename);
			//获取上传的绝对路径  upload 手动创建
			String path = request.getRealPath("/upload/");
			System.out.println("path:"+path);
			//获取新的文件对象
			File newFile = new File(path, filename);
			if(!newFile.exists()){ //文件不存在
				//创建文件
				newFile.createNewFile();
			}
			//System.out.println("----------"+news.getTitle());
			System.out.println("-------"+newFile.getName());
			//将文件内容放入新的文件
			cPhoto.transferTo(newFile);
			model.addAttribute("fileName", newFile.getName());
			
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
			
			//获取表单数据
			String title = news.getTitle();
			String typeId = String.valueOf(news.getNews_type().getId());
			String subTitle = news.getSubTitle();
			String sort = String.valueOf(news.getSort());
			String link = news.getLink();
			String author = news.getAuthor();
			String source = news.getSource();
			String label = news.getLabel();
			String text = news.getText();
			String filelink = news.getFilelink();
			String seoTitle = news.getSeoTitle();
			String seoKey = news.getSeoKey();
			String seoDes = news.getSeoDes();
			String placTop = String.valueOf(news.getPlacTop());
			String recommend = String.valueOf(news.getRecommend());
			String audit = String.valueOf(news.getAudit());
			String editor = news.getInfo();
			String fileName = news.getcPhoto();
			String addTime = String.valueOf(news.getAddTime());
			int news_id =news.getId();
			
			List<News_type> listNews_type = newsService.listNews_type();
			model.addAttribute("news_id", news_id);
			model.addAttribute("addTime", addTime);
			model.addAttribute("listNews_type", listNews_type);
			model.addAttribute("fileName", fileName);
			model.addAttribute("editor", editor);
			model.addAttribute("audit", audit);
			model.addAttribute("recommend", recommend);
			model.addAttribute("placTop", placTop);
			model.addAttribute("seoDes", seoDes);
			model.addAttribute("seoKey", seoKey);
			model.addAttribute("seoTitle", seoTitle);
			model.addAttribute("filelink", filelink);
			model.addAttribute("text", text);
			model.addAttribute("label", label);
			model.addAttribute("source", source);
			model.addAttribute("author", author);
			model.addAttribute("link", link);
			model.addAttribute("sort", sort);
			model.addAttribute("subTitle", subTitle);
			model.addAttribute("typeId", typeId);
			System.out.println("------------------"+typeId);
			model.addAttribute("title", title);
			return "updateNews";
		}
		
		//修改图片预览
			@RequestMapping("/updateFile")
			public String updateFile(@RequestParam(value="cPhoto")MultipartFile cPhoto,HttpServletRequest request,Model model) throws IOException{
				
				//获取表单数据
				String title = request.getParameter("title");
				String typeId = request.getParameter("typeId");
				String subTitle = request.getParameter("subTitle");
				String sort = request.getParameter("sort");
				String link = request.getParameter("link");
				String author = request.getParameter("author");
				String source = request.getParameter("source");
				String label = request.getParameter("label");
				String text = request.getParameter("text");
				String filelink = request.getParameter("filelink");
				String seoTitle = request.getParameter("seoTitle");
				String seoKey = request.getParameter("seoKey");
				String seoDes = request.getParameter("seoDes");
				String placTop = request.getParameter("placTop");
				String recommend = request.getParameter("recommend");
				String audit = request.getParameter("audit");
				String editor = request.getParameter("editor"); //简介
				String news_id =request.getParameter("news_id");
				String addTime = request.getParameter("addTime");
				
				if(placTop==null){
					placTop="0";
				}
				if(recommend==null){
					recommend="0";
				}
				
				List<News_type> listNews_type = newsService.listNews_type();
				model.addAttribute("addTime", addTime);
				model.addAttribute("news_id", news_id);
				model.addAttribute("listNews_type", listNews_type);
				model.addAttribute("editor", editor);
				model.addAttribute("audit", audit);
				model.addAttribute("recommend", recommend);
				model.addAttribute("placTop", placTop);
				model.addAttribute("seoDes", seoDes);
				model.addAttribute("seoKey", seoKey);
				model.addAttribute("seoTitle", seoTitle);
				model.addAttribute("filelink", filelink);
				model.addAttribute("text", text);
				model.addAttribute("label", label);
				model.addAttribute("source", source);
				model.addAttribute("author", author);
				model.addAttribute("link", link);
				model.addAttribute("sort", sort);
				model.addAttribute("subTitle", subTitle);
				model.addAttribute("typeId", typeId);
				model.addAttribute("title", title);
				
				//获取文件名
				String filename = cPhoto.getOriginalFilename();
				System.out.println("filename:"+filename);
				//获取上传的绝对路径  upload 手动创建
				String path = request.getRealPath("/upload/");
				System.out.println("path:"+path);
				//获取新的文件对象
				File newFile = new File(path, filename);
				if(!newFile.exists()){ //文件不存在
					//创建文件
					newFile.createNewFile();
				}
				System.out.println("-------"+newFile.getName());
				//将文件内容放入新的文件
				cPhoto.transferTo(newFile);
				model.addAttribute("fileName", "upload/"+newFile.getName());
				return "updateNews";
			}
			
			
			//修改
			@RequestMapping("/update")
			public String update(HttpServletRequest request) throws ParseException{
				
				//获取表单数据
				String title = request.getParameter("title");
				String typeId = request.getParameter("typeId");
				String subTitle = request.getParameter("subTitle");
				String sort = request.getParameter("sort");
				String link = request.getParameter("link");
				String author = request.getParameter("author");
				String source = request.getParameter("source");
				String label = request.getParameter("label");
				String text = request.getParameter("text");
				String filelink = request.getParameter("filelink");
				String seoTitle = request.getParameter("seoTitle");
				String seoKey = request.getParameter("seoKey");
				String seoDes = request.getParameter("seoDes");
				String placTop = request.getParameter("placTop");
				String recommend = request.getParameter("recommend");
				String editor = request.getParameter("editor"); //简介
				String news_id =request.getParameter("news_id");
				String fileName = request.getParameter("fileName");
				String addTime = request.getParameter("addTime");
				News news = new News();
				news.setId(Integer.valueOf(news_id));
				news.setTitle(title);
				News_type news_type = newsService.getNews_type(Integer.valueOf(typeId));
				news.setNews_type(news_type);
				news.setSubTitle(subTitle);
				news.setSort(Integer.valueOf(sort));
				news.setInfo(editor);
				news.setLink(link);
				news.setAuthor(author);
				news.setSource(source);
				news.setLabel(label);
				news.setClickNumber(0);
				news.setText(text); //内容
				news.setFilelink(filelink);
				news.setSeoTitle(seoTitle);
				news.setSeoKey(seoKey);
				news.setSeoDes(seoDes);
				news.setPlacTop(Integer.valueOf(placTop));
				news.setRecommend(Integer.valueOf(recommend));
				news.setAudit(0);
				news.setUpdId(0);
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				
				news.setAddTime(format.parse(addTime));
				Date date = new Date();
				news.setUpdTime(date);
				news.setcPhoto(fileName);
				newsService.update(news);
				return "redirect:/listNews";
			}
		
}
