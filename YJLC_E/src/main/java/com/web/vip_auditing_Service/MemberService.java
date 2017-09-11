package com.web.vip_auditing_Service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.financial_planner_Bean.Financial_planner;
import com.web.member_account_Bean.Member_account;
import com.web.vip_auditing_Bean.Member;
import com.web.vip_auditing_Dao.MemberDao;

@Service
@Transactional
public class MemberService {

	@Autowired
	private MemberDao auditingDao;

	
	//查询所有
	public List<Member> listAuditiongAll(Map map){
		return auditingDao.listAuditionAll(map);
	}
	
	//账号详情
	public Member getMember(int id){
		return auditingDao.getMember(id);
	}
	
	//账号账户详情
	public Member_account getMember_account(int id){
		return auditingDao.getMember_account(id);
	}
	
	//理财师详情
	public Financial_planner getFinancial_planner(int id){
		return auditingDao.getFinancial_planner(id);
	}
}
