package com.web.feedback_dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.web.bean.Feedback;

@Component
public class Feedback_dao {

	@Autowired
	private SessionFactory sessionFactory;
	
	// ��ȡ session ����
	public Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	// ��ѯ�������
	public List<Feedback> listfeedback(){
		String hql = "from Feedback ";
		Session session = this.getSession();
		List<Feedback> list = session.createQuery(hql).list();
		return list;
	}
}
