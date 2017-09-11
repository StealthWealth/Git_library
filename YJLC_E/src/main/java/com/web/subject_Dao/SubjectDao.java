package com.web.subject_Dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.web.subject_Bean.Subject;
import com.web.subject_purchase_record_Bean.Subject_purchase_record;

@Component
public class SubjectDao {

	@Autowired
	private SessionFactory sessionFactory;

	
	//获取session
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	
	//查询所有
	public List<Subject> listSubject(){
		Session session = getSession();
		String hql = "from Subject";
		List<Subject> subject = session.createQuery(hql).list();
		return subject;
	}
	
	//付息列表
	public List<Subject_purchase_record> listSubject_Purchase_Record(int id){
		Session session = getSession();
		String hql = "from Subject_purchase_record as subject_Pur where subject_Pur.subject.id="+id;
		List<Subject_purchase_record> listSubject = session.createQuery(hql).list();
	
		return listSubject;
	}
	
	//付息还款
	public void updateSubject_Purchase(int id){
		Session session = getSession();
		Subject_purchase_record purchase = (Subject_purchase_record) session.get(Subject_purchase_record.class, id);
		purchase.setIspayment(0);
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		purchase.setUpdate_date(date);
		session.update(purchase);
	}
}

