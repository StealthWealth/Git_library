package com.web.font.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.web.font.bean.Finance_product_funds;
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
	public List<Finance_product_funds> showStock(){
		Session session=getSession();
		String hql="from Finance_product_funds";
		List<Finance_product_funds> list=session.createQuery(hql).list();
		System.out.println("dao");
		return list;
	}
	
	
}
