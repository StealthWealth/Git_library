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
	
	// 获取 session 对象
	public Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	// 查询意见反馈
	public List<Feedback> listfeedback(){
		String hql = "from Feedback ";
		Session session = this.getSession();
		List<Feedback> list = session.createQuery(hql).list();
		return list;
	}
}
