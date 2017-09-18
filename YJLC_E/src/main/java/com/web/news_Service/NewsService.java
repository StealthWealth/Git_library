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

	//��ѯ����
	public List<News> listNews(Map map){
		return newsDao.listNews(map);
	}
	
	//��ѯ�������
	public List<News_type> listNews_type(){
		return newsDao.list_news_type();
	}
	
	//���
	public void add(News news){
		newsDao.add(news);
	}
	//��ѯnews_type ����
	public News_type getNews_type(int id){
		 return newsDao.getNews_Type(id);
	}
	
	//ɾ��
	public void delete(int id){
		newsDao.delete(id);
	}
	
	//��ѯ����
	public News getNews(int id){
		return newsDao.getNews(id);
	}
	
	//�޸�
	public void update(News news){
		newsDao.update(news);
	}
}
