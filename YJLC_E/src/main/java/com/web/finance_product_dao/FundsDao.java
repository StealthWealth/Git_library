package com.web.finance_product_dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.web.finance_product_bean.Finance_product_funds;
import com.web.finance_product_bean.Finance_product_subscribe;

@Component
public class FundsDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	public List<Finance_product_funds> listfuns(Map map){
		String hql = "from Finance_product_funds where 1=1";
		hql = this.getHql(map, hql);
		String hql2 = " order by period desc";
		hql+=hql2;
		Session session = this.getSession();
		List<Finance_product_funds> list = session.createQuery(hql).list();
		return list;
	}
	
	public String getHql(Map map,String hql){
		String qname = (String)map.get("qname");
		String wname = (String)map.get("wname");
		String ename = (String)map.get("ename");
		
		if (qname != null && !qname.equals("")) {
			hql += " and name like '%"+qname+"%'";
		}
		if (wname != null && !wname.equals("")) {
			hql += " and status ="+wname;
		}
		if (ename != null && !ename.equals("")) {
			hql += " and type = '"+ename+"'";
		}
		return hql;
	}
	
	public List<Finance_product_subscribe> listsubscribe(int id){
		String hql = "from Finance_product_subscribe where product_id="+id+" order by create_date desc";
		Session session = this.getSession();
		List<Finance_product_subscribe> list = session.createQuery(hql).list();
		return list;
	}
}
