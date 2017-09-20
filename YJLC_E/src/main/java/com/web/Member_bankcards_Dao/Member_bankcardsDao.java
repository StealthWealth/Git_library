package com.web.Member_bankcards_Dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.web.member_account_Bean.Member_account;
import com.web.member_bankcards_Bean.Member_bankcards;

@Component
public class Member_bankcardsDao {

	@Autowired
	private SessionFactory sessionFactory;

	
	//获取session
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	
	//查询所有
	public List<Member_bankcards> listMember_bankcards(Map map){
		Session session = getSession();
		String hql = "from Member_bankcards as MemberBan where 0=0 ";
		hql=list_MHMember_bankcards(map, hql);
		List<Member_bankcards> member_bankcards = session.createQuery(hql).list();
		return member_bankcards;
 	}
	
	
	//模糊查询
	public String list_MHMember_bankcards(Map map,String hql){
		//手机号
		String MH_mobile_Phone = (String) map.get("MH_mobile_Phone");
		String MH_member_name =(String) map.get("MH_member_name");
		String MH_card_no = (String) map.get("MH_card_no");
		String MH_QDate = (String) map.get("MH_QDate"); //注册时间 前
		String MH_HDate = (String) map.get("MH_HDate"); //注册时间 后
		
		if(MH_mobile_Phone!=null && !MH_mobile_Phone.equals("")){
			hql+=" and MemberBan.member.mobile_Phone="+MH_mobile_Phone;
		}
		if(MH_member_name!=null && !MH_member_name.equals("")){
			hql+=" and MemberBan.member.member_name='"+MH_member_name+"'";
		}
		if(MH_card_no!=null && !MH_card_no.equals("")){
			hql+=" and MemberBan.card_no="+MH_card_no;
		}
		if(MH_QDate!=null && !MH_QDate.equals("")){
			hql+=" and create_date>='"+MH_QDate+"'";
		}
		if(MH_HDate!=null && !MH_HDate.equals("")){
			hql+=" and create_date<='"+MH_HDate+"'";
		}
		return hql;
	}
	
	
	//查询对象
	public Member_bankcards getMember_bankcards(int id){
		Session session = getSession();
		Member_bankcards member_bankcards = (Member_bankcards) session.get(Member_bankcards.class, id);
		return  member_bankcards;
	}
	
	//解绑
	public void updateDelflag(Member_bankcards member_bankcards){
		Session session = getSession();
		Date date = new Date();
		member_bankcards.setUpdate_date(date);
		session.update(member_bankcards);
	}
	
}
