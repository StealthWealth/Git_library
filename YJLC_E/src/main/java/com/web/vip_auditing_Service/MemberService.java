package com.web.vip_auditing_Service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.financial_planner_Bean.Financial_planner;
import com.web.member_account_Bean.Member_account;
import com.web.member_deposit_record_Bean.Member_deposit_record;
import com.web.member_trade_record_Bean.Member_trade_record;
import com.web.member_withdraw_record_Bean.Member_withdraw_record;
import com.web.subject_purchase_record_Bean.Subject_purchase_record;
import com.web.vip_auditing_Bean.Member;
import com.web.vip_auditing_Dao.MemberDao;

@Service
@Transactional
public class MemberService {

	@Autowired
	private MemberDao auditingDao;

	
	//��ѯ����
	public List<Member> listAuditiongAll(Map map){
		return auditingDao.listAuditionAll(map);
	}
	
	//�˺�����
	public Member getMember(int id){
		return auditingDao.getMember(id);
	}
	
	//�˺��˻�����
	public Member_account getMember_account(int id){
		return auditingDao.getMember_account(id);
	}
	
	//���ʦ����
	public Financial_planner getFinancial_planner(int id){
		return auditingDao.getFinancial_planner(id);
	}
	
	//Ͷ������
	public List<Subject_purchase_record> listSubject_purchase_record(int id){
		return auditingDao.listSubject_purchase_record(id);
	}
	
	//��������
	public List<Member_withdraw_record> listMember_withdraw(int id){
		return auditingDao.listMember_withdraw(id);
	}
	
	//��ֵ����
	public List<Member_deposit_record> listMember_deposit(int id){
		return auditingDao.listMember_deposit(id);
	}
	
	//��������
	public List<Member_trade_record> listMember_trade_record(int id){
		return auditingDao.listMember_trade(id);
	}
}
