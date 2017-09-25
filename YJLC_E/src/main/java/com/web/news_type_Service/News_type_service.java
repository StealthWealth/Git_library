package com.web.news_type_Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.news_type_Bean.News_type;
import com.web.news_type_Dao.News_type_dao;

@Service
@Transactional
public class News_type_service {

	@Autowired
	private News_type_dao ntd;
	
	//��ѯ��ѯ���������
		public List<News_type> listAll(){
			return ntd.listAll();	
		}
		
		//��ѯ��������
		public void addnewstype(News_type nt){
			ntd.addnewstype(nt);
		}
		//��ѯ������޸�ǰ�Ĳ�ѯ
		public News_type getNews_type(int id){
			return ntd.getNews_type(id);
		}
		//��ѯ������޸�
		public void updatenewstype(News_type nt){
			ntd.updatenewstype(nt);
		}
}
