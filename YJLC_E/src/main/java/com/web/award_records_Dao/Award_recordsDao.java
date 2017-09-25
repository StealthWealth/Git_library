package com.web.award_records_Dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.web.award_records_Bean.Award_Bean;
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
	public List<Award_Bean> listAward_records(Map map){
		Session session = getSession();
		String sql="select * from (select byinvitingid,mobile_Phone,member_name,invitationCode,invitedCode,sum(amount) amount,case when max(enroll)=1 then '已注册奖励'else '未注册奖励' end enroll, case when max(invest)=1 then '已投资奖励'else '未投资奖励' end invest,max(create_date) create_date from(select byinvitingid,m.mobile_Phone,m.member_name,m.invitationCode,m.invitedCode,a.amount,case when a.type=0 and a.isAward=1 then '1'else '0' end enroll,case when a.type=1  and a.isAward=1 then '1'else '0' end invest,m.create_date from award_records a,member m where a.invitingid=m.id )t group by  t.byinvitingid,t.mobile_Phone,t.member_name,t.invitationCode,t.invitedCode)tt where 0=0 ";
		sql=list_MHAward(map, sql);
		List list = session.createSQLQuery(sql).list();
		List<Award_Bean> award_records = new ArrayList<>();
		for (int i=0;i<list.size();i++) {
			Object[] obj = (Object[]) list.get(i);
			Award_Bean award = new Award_Bean();
			award.setByinvitingid(obj[0].toString());
			award.setMobile_Phone(obj[1].toString());
			award.setMember_name(obj[2].toString());
			award.setInvitationCode(obj[3].toString());
			award.setInvitedCode(obj[4].toString());
			award.setAmount(obj[5].toString());
			award.setEnroll(obj[6].toString());
			award.setInvest(obj[7].toString());
			award.setCreate_date(obj[8].toString());
			award_records.add(award);
		}
		return award_records;
	}
	
	//模糊查询
	public String list_MHAward(Map map,String sql){
		
		String MH_member_name = (String) map.get("MH_member_name");
		String MH_mobile_Phone = (String)map.get("MH_mobile_Phone");
		String MH_invitationCode = (String) map.get("MH_invitationCode");
		String MH_invitedCode = (String) map.get("MH_invitedCode");
		String MH_isAward_Zhu = (String) map.get("MH_isAward_Zhu");
		String MH_isAward_Tou = (String) map.get("MH_isAward_Tou");
		
		if(MH_member_name!=null && !MH_member_name.equals("")){
			sql+=" and member_name like '%"+MH_member_name+"%' ";
		}
		if(MH_mobile_Phone!=null && !MH_mobile_Phone.equals("")){
			sql+=" and mobile_Phone="+MH_mobile_Phone;
		}
		if(MH_invitationCode!=null && !MH_invitationCode.equals("")){
			sql+=" and invitationCode='"+MH_invitationCode+"'";
		}
		if(MH_invitedCode!=null && !MH_invitedCode.equals("")){
			sql+=" and invitedCode='"+MH_invitedCode+"'";
		}
		if(MH_isAward_Zhu!=null && !MH_isAward_Zhu.equals("")){
			sql+=" and enroll='"+MH_isAward_Zhu+"'";
		}
		if(MH_isAward_Tou!=null && !MH_isAward_Tou.equals("")){
			sql+=" and invest='"+MH_isAward_Tou+"'";
		}
		return sql;
	}
	
	//奖励记录
	public List<Award_records> getAwardList(String byinvitingid){
		Session session = getSession();
		String hql = "from Award_records as aw where aw.byinvitingid="+byinvitingid;
		System.out.println("------hql:"+hql);
		List<Award_records> award = session.createQuery(hql).list();
		return award;
	}
	
	//奖励记录被邀请人
	public Member getByinvitingName(int id){
		Session session = getSession();
		String hql = "from Member where id="+id;
		List<Member> member = session.createQuery(hql).list();
		return member.get(0);
	}
	
	//查询所有被邀请人名字
	public List<Member> listMember_Name(){
		Session session = getSession();
		List<Member> listMember_Name = session.createQuery("from Member").list();
		return listMember_Name;
	}
	
}
