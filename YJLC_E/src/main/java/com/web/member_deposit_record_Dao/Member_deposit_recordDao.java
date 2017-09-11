package com.web.member_deposit_record_Dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.web.member_deposit_record_Bean.Member_deposit_record;

@Component
public class Member_deposit_recordDao {

	@Autowired
	private SessionFactory sessionFactory;

	//获取session
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	
	//查询所有
	public List<Member_deposit_record>  listMember_deposit_record(Map map){
		Session session = getSession();
		String hql = "from Member_deposit_record as mem where mem.pay_channel_name='FUIOU' and 0=0 ";
		hql=list_MHMember_deposit(map, hql);
		List<Member_deposit_record> member_deposit_record = session.createQuery(hql).list();
		return member_deposit_record;
	}
	
	
	//模糊查询
	public String list_MHMember_deposit(Map map,String hql){
		
		//接受map值
		String MH_serial_number = (String) map.get("MH_serial_number");
		String MH_mobile_Phone = (String) map.get("MH_mobile_Phone");
		String MH_status = (String) map.get("MH_status");
		String MH_pay_channel_order_no = (String) map.get("MH_pay_channel_order_no");
		String MH_QDate = (String) map.get("MH_QDate");
		String MH_HDate = (String) map.get("MH_HDate");
		
		if(MH_serial_number!=null && !MH_serial_number.equals("")){
			hql+=" and mem.serial_number="+MH_serial_number;
		}
		if(MH_mobile_Phone!=null && !MH_mobile_Phone.equals("")){
			hql+=" and mem.member.mobile_Phone="+MH_mobile_Phone;
		}
		if(MH_status!=null && !MH_status.equals("")){
			hql+=" and mem.status="+MH_status;
		}
		if(MH_pay_channel_order_no!=null && !MH_pay_channel_order_no.equals("")){
			hql+=" and mem.pay_channel_order_no="+MH_pay_channel_order_no;
		}
		if(MH_QDate!=null && !MH_QDate.equals("")){
			hql+=" and mem.create_date>='"+MH_QDate+"'";
		}
		if(MH_HDate!=null && !MH_HDate.equals("")){
			hql+=" and mem.create_date<='"+MH_HDate+"'";
		}
		
		return hql;
	}
}
