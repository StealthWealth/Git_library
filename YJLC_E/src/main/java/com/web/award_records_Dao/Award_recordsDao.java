package com.web.award_records_Dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.web.award_records_Bean.Award_member_account;
import com.web.award_records_Bean.Award_records;
import com.web.vip_auditing_Bean.Member;

@Component
public class Award_recordsDao {

	@Autowired
	private SessionFactory sessionFactory;

	
	//查询session
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	
	//查询所有
	public List<Award_records> listAward_records(Map map){
		Session session = getSession();
		String hql = "from Award_records  as aw where 0=0 ";
		hql=list_MHAward(map, hql);
		List<Award_records> award_records = session.createQuery(hql).list();
		return award_records;
				
	}
	
	//模糊查询
	public String list_MHAward(Map map,String hql){
		
		String MH_member_name = (String) map.get("MH_member_name");
		String MH_mobile_Phone = (String)map.get(" MH_mobile_Phone");
		String MH_invitationCode = (String) map.get("MH_invitationCode");
		String MH_invitedCode = (String) map.get("MH_invitedCode");
		String MH_isAward_Zhu = (String) map.get("MH_isAward_Zhu");
		String MH_isAward_Tou = (String) map.get("MH_isAward_Tou");
		
		if(MH_member_name!=null && !MH_member_name.equals("")){
			hql+=" and aw.member.member_name like '%"+MH_member_name+"%' ";
		}
		if(MH_mobile_Phone!=null && !MH_mobile_Phone.equals("")){
			hql+=" and aw.member.mobile_Phone="+MH_mobile_Phone;
		}
		if(MH_invitationCode!=null && !MH_invitationCode.equals("")){
			hql+=" and aw.member.invitationCode="+MH_invitationCode;
		}
		if(MH_invitedCode!=null && !MH_invitedCode.equals("")){
			hql+=" and aw.member.invitedCode="+MH_invitedCode;
		}
		if(MH_isAward_Zhu!=null && !MH_isAward_Zhu.equals("")){
			hql+=" and aw.type=0 and aw.isAward='"+MH_isAward_Zhu+"'";
		}
		if(MH_isAward_Tou!=null && !MH_isAward_Tou.equals("")){
			hql+=" and aw.type=1 and aw.isAward='"+MH_isAward_Tou+"'";
		}
		return hql;
	}
	
	//奖励记录
	public Award_records getAward(int id){
		Session session = getSession();
		String hql = "from Award_records where id="+id;
		List<Award_records> award = session.createQuery(hql).list();
		return award.get(0);
	}
	
	//奖励记录被邀请人
	public Member getByinvitingName(int id){
		Session session = getSession();
		String hql = "from Member where id="+id;
		List<Member> member = session.createQuery(hql).list();
		return member.get(0);
	}
	
	//查询投资金额
	public List<Award_member_account> getAward_member(){
		Session session = getSession();
		String sql = "select member_id,invest_amount from member_account";
		List list = session.createSQLQuery(sql).list();
		List<Award_member_account> award_memner = new ArrayList<>();
		for(int i=0;i<list.size();i++){
			Object[] obj = (Object[]) list.get(i);
			Award_member_account award = new Award_member_account();
			award.setMember_id(obj[0].toString());
			award.setMember_amount(obj[1].toString());
			award_memner.add(award);
		}
		return award_memner;
				
	}
	
}
