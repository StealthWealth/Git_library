package com.web.subject_Dao;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
	public List<Subject> listSubject(Map map){
		Session session = getSession();
		String hql = "from Subject where 0=0 ";
		hql=list_MHSubject(map, hql);
		System.out.println("hql:"+hql);
		List<Subject> subject = session.createQuery(hql).list();
		return subject;
	}
	
	//模糊查询
	public String list_MHSubject(Map map,String hql){
		String MH_name = (String) map.get("MH_name");
		String MH_stats = (String) map.get("MH_stats");
		String MH_type = (String) map.get("MH_type");
		
		if(MH_name!=null && !MH_name.equals("")){
			hql+=" and name like '%"+MH_name+"%'";
		}
		if(MH_stats!=null && !MH_stats.equals("")){
			hql+=" and status="+MH_stats;
		}
		if(MH_type!=null && !MH_type.equals("")){
			hql+=" and type="+MH_type;
		}
		return hql;
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
		session.update(subject_bbin);
	}
	
	//已投金额 已投人数
	public List<Sum_Subject> listSum_subject(){
		Session session = getSession();
		String sql = "select subject_id,SUM(amount) as sum_amount,count(distinct member_id) as getCount from subject_purchase_record GROUP BY subject_id";
		List list= session.createSQLQuery(sql).list();
		List<Sum_Subject> temp=new ArrayList<Sum_Subject>();
		for(int i=0;i<list.size();i++){
			Object[] obj=(Object[])list.get(i);
			Sum_Subject sum=new Sum_Subject();
			sum.setSubject_id(obj[0].toString());
			sum.setSum_amount(obj[1].toString());
			sum.setCount(obj[2].toString());
			temp.add(sum);
		}
		return temp;
	}
	
}

