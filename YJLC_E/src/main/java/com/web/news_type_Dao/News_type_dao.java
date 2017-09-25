package com.web.news_type_Dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.web.news_type_Bean.News_type;

@Component
public class News_type_dao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	//��ѯ��ѯ���������
		public List<News_type> listAll(){
			Session session=getSession();
			String hql="from News_type";
			List<News_type> listAll=session.createQuery(hql).list();
			return listAll;
		}
		//��ѯ��������
		public void addnewstype(News_type nt){
			Session session=getSession();
			Date date=new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String addtime = sdf.format(date);
			nt.setAddTime(addtime);
			session.save(nt);
		}
		//��ѯ������޸�ǰ�Ĳ�ѯ
		public News_type getNews_type(int id){
			Session session=getSession();
			News_type nt=(News_type)session.get(News_type.class, id);
			return nt;
			
		}
		
		//��ѯ������޸�
		public void updatenewstype(News_type nt){
			Session session=getSession();
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String update = sdf.format(date);
			nt.setUpdTime(update);
			session.update(nt);
		}
}
