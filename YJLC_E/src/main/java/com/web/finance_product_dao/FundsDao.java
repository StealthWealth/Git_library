package com.web.finance_product_dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.web.finance_product_bean.Finance_product_funds;
import com.web.finance_product_bean.Finance_product_subscribe;
import com.web.vip_auditing_Bean.Member;

@Component
public class FundsDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	public List<Finance_product_funds> listfuns(Map map){  //查看私募/股权类
		String hql = "from Finance_product_funds where 1=1";
		hql = this.getHql(map, hql);
		String hql2 = " order by period desc";
		hql+=hql2;
		Session session = this.getSession();
		List<Finance_product_funds> list = session.createQuery(hql).list();
		return list;
	}
	
	public String getHql(Map map,String hql){   //私募/股权类  模糊查询
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
	
	public List<Finance_product_subscribe> listsubscribe(int id){   //查看签署状态
		String hql = "from Finance_product_subscribe where funds.id="+id+" order by create_date desc";
		Session session = this.getSession();
		List<Finance_product_subscribe> list = session.createQuery(hql).list();
		return list;
	}
	
	public void fundsSave(Finance_product_funds funds){ //保存理财项目信息
		Session session = this.getSession();
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str = sim.format(new Date());
		funds.setCreate_date(str);
		funds.setUpdate_date(str);
		session.save(funds);
	}
	
	public Finance_product_funds getfundsid(int id){  //  私募  根据ID查询一行数据
		Session session = this.getSession();
		Finance_product_funds funds = (Finance_product_funds)session.get(Finance_product_funds.class, id);
		return funds;
	}
	
	public void updatefunds(Finance_product_funds funds){   //修改 私募/股权类信息
		Session session = this.getSession();
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str = sim.format(new Date());
		funds.setUpdate_date(str);
		session.update(funds);
	}
	
	public Finance_product_subscribe getsubscribeid(int id){  //查询数据
		Session session = this.getSession();
		Finance_product_subscribe subscribe = (Finance_product_subscribe)session.get(Finance_product_subscribe.class, id);
		return subscribe;
	}
	
	public void updatesubscribe(int id){  //签署失败
		Session session = this.getSession();
		Finance_product_subscribe subscribe = this.getsubscribeid(id);
		subscribe.setStatus(3);
		session.update(subscribe);
	}
	
	public void updatesubscribe(Finance_product_subscribe subscribe){
		Session session = this.getSession();
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str = sim.format(new Date());
		subscribe.setUpdate_date(str);
		subscribe.setStatus(1);
		session.update(subscribe);
	}
	
	
	public Member getmemberid(int id){
		Session session = this.getSession();
		Member member = (Member)session.get(Member.class, id);
		return member;
	}
}
