package com.web.vip_auditing_Dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.web.financial_planner_Bean.Financial_planner;
import com.web.member_account_Bean.Member_account;
import com.web.member_deposit_record_Bean.Member_deposit_record;
import com.web.member_trade_record_Bean.Member_trade_record;
import com.web.member_withdraw_record_Bean.Member_withdraw_record;
import com.web.subject_purchase_record_Bean.Subject_purchase_record;
import com.web.vip_auditing_Bean.Member;

@Component
public class MemberDao {

	@Autowired
	private SessionFactory sessionFactory;

	//��ȡSession
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	//��ѯ�˺Ź���
	public List<Member> listAuditionAll(Map map){
		Session session  = getSession();
		String hql="from Member where 0=0 ";
		hql=setHql(map, hql);
		List<Member> listAudition = session.createQuery(hql).list();
		return listAudition;
	}
	
	
	//��ѯ�˺Ź��� ���� ģ����ѯ
	public String setHql(Map map,String hql){
		//��ȡ ǰ̨�ı���ֵ
		String MH_name = (String) map.get("MH_name"); //�û���
		String MH_mobile_Phone = (String) map.get("MH_mobile_Phone"); //�ֻ���
		String MH_member_name = (String) map.get("MH_member_name"); //��������
		String MH_invitationCode = (String) map.get("MH_invitationCode"); //������
		String MH_QDate = (String) map.get("MH_QDate"); //ע��ʱ�� ǰ
		String MH_HDate = (String) map.get("MH_HDate"); //ע��ʱ�� ��
		
		
		if(MH_name!=null && !MH_name.equals("")){
			hql+=" and name like '%"+MH_name+"%'";
		}
		if(MH_mobile_Phone!=null && !MH_mobile_Phone.equals("")){
			hql+=" and mobile_Phone="+MH_mobile_Phone;
		}
		if(MH_member_name!=null && !MH_member_name.equals("")){
			hql+=" and member_name like '%"+MH_member_name+"%'";
		}
		if(MH_invitationCode!=null && !MH_invitationCode.equals("")){
			hql+=" and invitationCode="+MH_invitationCode;
		}
		if(MH_QDate!=null && !MH_QDate.equals("")){
			hql+=" and create_date>='"+MH_QDate+"'";
		}
		if(MH_HDate!=null && !MH_HDate.equals("")){
			hql+=" and create_date<='"+MH_HDate+"'";
		}
		
		return hql;
	}
	

	//��ѯ�˺�����
	public Member getMember(int id){
		Session session = getSession();
		Member member =(Member)session.get(Member.class, id);
		return member;
	}
	
	//��ѯ�˺��˻�����
	public Member_account getMember_account(int id){
		Session session = getSession();
		String hql = "from Member_account as memberAcc  where memberAcc.member.id="+id;
		List<Member_account> List_Member_account = session.createQuery(hql).list();
		if(List_Member_account.size()>0){
			return List_Member_account.get(0);
		}
		return null;
		
	}
	
	//��ѯ���ʦ����
	public Financial_planner getFinancial_planner(int id){
		Session session = getSession();
		String hql = "from Financial_planner as finan where finan.member.id="+id;
		List<Financial_planner> listFinancial_planner = session.createQuery(hql).list();
		if(listFinancial_planner.size()>0){
			return listFinancial_planner.get(0);
		}
		return null;
	}
	
	//��ѯͶ������
	public List<Subject_purchase_record> listSubject_purchase_record(int id){
		Session session = getSession();
		String hql = "from Subject_purchase_record as su where su.member.id="+id;
		List<Subject_purchase_record> member_subject = session.createQuery(hql).list();
		return member_subject;
	}
	
	//��ѯ��������
	public List<Member_withdraw_record> listMember_withdraw(int id){
		Session session = getSession();
		String hql  = "from Member_withdraw_record as mem where mem.member.id="+id;
		List<Member_withdraw_record> member_withdraw = session.createQuery(hql).list();
		return member_withdraw;
	}

	//��ѯ��ֵ��¼
	public List<Member_deposit_record> listMember_deposit(int id){
		Session session = getSession();
		String hql = "from Member_deposit_record as mem where mem.member.id="+id;
		List<Member_deposit_record> member_deposit = session.createQuery(hql).list();
		return member_deposit;
	}
	//��ѯ���׼�¼
	public List<Member_trade_record> listMember_trade(int id){
		Session session = getSession();
		String hql = "from Member_trade_record as mem where mem.member.id="+id;
		List<Member_trade_record> member_trade = session.createQuery(hql).list();
		return member_trade;
	}
}
