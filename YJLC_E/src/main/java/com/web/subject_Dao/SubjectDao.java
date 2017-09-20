package com.web.subject_Dao;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.web.subject_Bean.Subject;
import com.web.subject_Bean.Sum_Subject;
import com.web.subject_purchase_record_Bean.Subject_purchase_record;
import com.web.sublect_bbin_purchase_record_Bean.Subject_bbin_purchase_record;

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
		purchase.setIspayment(1);
		Date date = new Date();
		purchase.setUpdate_date(date);
		session.update(purchase);
	}
	
	//体验金购买
	public List<Subject_bbin_purchase_record> listSubject_bbin(int id){
		Session session = getSession();
		String hql  = "from Subject_bbin_purchase_record as su where su.subject.id="+id;
		List<Subject_bbin_purchase_record> subject_bbin = session.createQuery(hql).list();
		return subject_bbin;
		
	}
	
	//修改体验金还款
	public void updateSubject_bbin(int id){
		Session session = getSession();
		Subject_bbin_purchase_record subject_bbin = (Subject_bbin_purchase_record) session.get(Subject_bbin_purchase_record.class, id);
		subject_bbin.setIspayment(1);
		Date date = new Date();
		subject_bbin.setUpdate_date(date);
		session.update(subject_bbin);
	}
	
	//已投金额
	public List<Sum_Subject> listSum_subject(){
		Session session = getSession();
		String sql = "select sum_subject.subject_id,sum_subject.sum_amount*sum_subject.sum_pay from  (select subject_id,SUM(amount) as sum_amount,SUM(pay_interest_times) as sum_pay from subject_purchase_record GROUP BY subject_id)as sum_subject";
		List list= session.createSQLQuery(sql).list();
		List<Sum_Subject> temp=new ArrayList<Sum_Subject>();
		for(int i=0;i<list.size();i++){
			Object[] obj=(Object[])list.get(i);
			Sum_Subject sum=new Sum_Subject();
			sum.setSubject_id(obj[0].toString());
			sum.setSum_amount(obj[1].toString());
			temp.add(sum);
		}
		return temp;
	}
	
	
}

