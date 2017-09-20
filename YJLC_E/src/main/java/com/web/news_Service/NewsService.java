package com.web.news_Service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.news_Bean.News;
import com.web.news_Dao.NewsDao;
import com.web.news_type_Bean.News_type;

@Service
@Transactional
public class NewsService {

	@Autowired
	private NewsDao newsDao;

	//查询所有
	public List<News> listNews(Map map){
		return newsDao.listNews(map);
	}
	
	//查询所有类别
	public List<News_type> listNews_type(){
		return newsDao.list_news_type();
	}
	
	//添加
	public void add(News news){
		newsDao.add(news);
	}
	//查询news_type 对象
	public News_type getNews_type(int id){
		 return newsDao.getNews_Type(id);
	}
	
	//删除
	public void delete(int id){
		newsDao.delete(id);
	}
	
	//查询对象
	public News getNews(int id){
		return newsDao.getNews(id);
	}
	
	//修改
	public void update(News news){
		newsDao.update(news);
	}
}
