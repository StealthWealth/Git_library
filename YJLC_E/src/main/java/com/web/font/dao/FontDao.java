package com.web.font.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.web.finance_product_bean.Finance_product_funds;
import com.web.font.bean.Push_notice;
import com.web.font.bean.Users;

@Component
public class FontDao {

	@Autowired
	private SessionFactory sessionFactory;  
	
	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
	
	
	public void signIn(Users users) {
		
		
	}
	
	public void sifnUp(Users users) {
		
		
	}
	
	
	//查询finance_product_funds(理财类基金产品表)
	public List<Finance_product_funds> listStock(){
		Session session=this.getSession();
		String hql="from Finance_product_funds";
		List<Finance_product_funds> list=session.createQuery(hql).list();
		return list;
	}
	
	//查询公告
	public List<Push_notice> listPush(){
		Session session=this.getSession();
		String hql="from Push_notice";
		List<Push_notice> list=session.createQuery(hql).list();
		return list;
	}
	

	
	
}
