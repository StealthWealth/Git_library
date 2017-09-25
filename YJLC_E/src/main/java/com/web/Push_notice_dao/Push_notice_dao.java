package com.web.Push_notice_dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.web.font_bean.Push_notice;

@Component
public class Push_notice_dao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	public List<Push_notice> listnotice(Map map){
		String hql = "from Push_notice where 1=1 ";
		hql = this.getHql(map, hql);
		Session session = this.getSession();
		List<Push_notice> list = session.createQuery(hql).list();
		return list;
	}
	
	public String getHql(Map map,String hql){
		String qname = (String)map.get("qname");
		if (qname!=null&&!qname.equals("")) {
			hql+=" and title like '%"+qname+"%'";
		}
		return hql;
	}
	
	public void savenotice(Push_notice notice){
		notice.setCreate_date(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		notice.setUpdate_Date(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		notice.setStatus(0);
		Session session = this.getSession();
		session.save(notice);
	}
	
	public Push_notice getNoticeId(int id){
		Session session = this.getSession();
		Push_notice notice = (Push_notice)session.get(Push_notice.class, id);
		return notice;
	}
	
	public void updatenotice(Push_notice notice){
		notice.setUpdate_Date(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		Session session = this.getSession();
		session.update(notice);
	}
}
