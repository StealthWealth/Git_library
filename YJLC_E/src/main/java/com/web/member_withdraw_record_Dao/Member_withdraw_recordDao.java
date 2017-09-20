package com.web.member_withdraw_record_Dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.web.member_withdraw_record_Bean.Member_withdraw_record;

@Component
public class Member_withdraw_recordDao {

	@Autowired
	private SessionFactory sessionFactory;

	
	//获取session
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	//查询所有
	public List<Member_withdraw_record> listMember_withdraw(Map map){
		Session session = getSession();
		String hql = "from Member_withdraw_record as mem where 0=0 ";
		hql=MH_listMember(map, hql);
		List<Member_withdraw_record> member_withdraw = session.createQuery(hql).list();
		return member_withdraw;
	}
	
	
	//模糊查询
	public String MH_listMember(Map map,String hql){
		String MH_member_name = (String) map.get("MH_member_name");
		String MH_mobile_Phone = (String) map.get("MH_mobile_Phone");
		String MH_bank_card = (String) map.get("MH_bank_card");
		String MH_status = (String) map.get("MH_status");
		String MH_QDate = (String) map.get("MH_QDate");
		String MH_HDate = (String) map.get("MH_HDate");
		if(MH_member_name!=null && !MH_member_name.equals("")){
			hql+=" and mem.member.member_name like '%"+MH_member_name+"%'";
		}
		if(MH_mobile_Phone!=null && !MH_mobile_Phone.equals("")){
			hql+=" and mem.member.mobile_Phone="+MH_mobile_Phone;
		}
		if(MH_bank_card!=null && !MH_bank_card.equals("")){
			hql+=" and mem.bank_card="+MH_bank_card;
		}
		if(MH_status!=null && !MH_status.equals("")){
			hql+=" and mem.status="+MH_status;
		}
		if(MH_QDate!=null && !MH_QDate.equals("")){
			hql+=" and create_date>='"+MH_QDate+"'";
		}
		if(MH_HDate!=null && !MH_HDate.equals("")){
			hql+=" and create_date<='"+MH_HDate+"'";
		}
		return hql;
	}
	
	//审核
	public void updateMember_with(int id){
		Session session = getSession();
		Member_withdraw_record with = (Member_withdraw_record) session.get(Member_withdraw_record.class, id);
		with.setStatus(2);
		session.update(with);
	}
}
