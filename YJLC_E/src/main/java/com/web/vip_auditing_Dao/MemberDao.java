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
			hql+=" and member_name like '"+MH_member_name+"%'";
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
		return List_Member_account.get(0);
		
	}
	
	//��ѯ���ʦ����
	public Financial_planner getFinancial_planner(int id){
		Session session = getSession();
		String hql = "from Financial_planner as finan where finan.member.id="+id;
		List<Financial_planner> listFinancial_planner = session.createQuery(hql).list();
		return listFinancial_planner.get(0);
	}
	
	//��ѯͶ������
	

}
