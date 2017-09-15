package com.web.news_Dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.web.news_Bean.News;
import com.web.news_type_Bean.News_type;

@Component
public class NewsDao {

	@Autowired
	private SessionFactory sessionFactory;

	//��ȡsession
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	
	//��ѯ����
	public List<News> listNews(){
		Session session = getSession();
		String hql = "from News ";
		List<News> listNews = session.createQuery(hql).list();
		return listNews;
	}
	
	//��ѯ�������
	public List<News_type> list_news_type(){
		Session session = getSession();
		String hql = "from News_type";
		List<News_type> listNews_type = session.createQuery(hql).list();
		return listNews_type;
	}
	
	
	//��ѯ������
	public News_type getNews_Type(int id){
		Session session = getSession();
		News_type news_type = (News_type) session.get(News_type.class, id);
		return news_type;
	}
	
	//���
	public void add(News news){
		Session session = getSession();
		session.save(news);
	}
	
	//ɾ��
	public void delete(int id){
		Session session = getSession();
		News news = (News) session.get(News.class, id);
		session.delete(news);
	}
	
	//��ѯ����
	public News getNews(int id){
		Session session = getSession();
		News news = (News) session.get(News.class, id);
		return news;
	}
	
	//�޸�
	public void update(News news){
		Session session = getSession();
		session.update(news);
	}
}
