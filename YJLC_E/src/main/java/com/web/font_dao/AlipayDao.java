package com.web.font_dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Expression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.web.font_bean.Member_tally;
import com.web.member_account_Bean.Member_account;
import com.web.member_deposit_record_Bean.Member_deposit_record;
import com.web.member_trade_record_Bean.Member_trade_record;
import com.web.subject_Bean.Subject;
import com.web.subject_purchase_record_Bean.Subject_purchase_record;
import com.web.vip_auditing_Bean.Member;

@Component
public class AlipayDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	
	//�޸Ľ��
	public void updateUseable_balance(Member_account ma) {
		Session session=getSession();
		session.update(ma);
	}
	
	
	//���֧����¼
	public void addMember_deposit_record(Member_deposit_record mdr,Member member) {
		Session session=getSession();
		mdr.setMember(member);
		session.save(mdr);
	}
	
	
	
	//��ѯ�˻���
	public Member_account getMember_account(int member_id) {
		Session session=getSession();
		Criteria criteria=session.createCriteria(Member_account.class);
		criteria.add(Expression.eq("member.id", member_id) );
		System.out.println("member_id:"+member_id);
		List<Member_account> list=criteria.list();
		Member_account ma = null;
		if (list.size() > 0) {
			ma=list.get(0);
		}
		return ma;
	}


	//������������--����ǰ���Ĳ�ѯ  (Ŀǰû��  ��Ϊ�Ѿ������)
/*	public Member_account listma(Member member) {
		Session session=getSession();
		String hql="from Member_account ma where member_id="+member.getId()+"";
		List<Member_account> list=session.createQuery(hql).list();
		Member_account ma=null;
		if (list.size() > 0) {
			ma=list.get(0);
		}
		return ma;
	}
	*/
	
	
	//������������--�޸Ĺ����Ľ��
	public void  yjpayGSL(Member_account ma) {
		Session session=getSession();
		session.update(ma);
	}
	
	
	
	//���������--��ӽ��׼�¼
	public void addGSLjl(Member_trade_record mtr,Member member) {
		Session session=getSession();
		mtr.setMember(member);
		session.save(mtr);
	}
	
	
	
	 //����������Ʒ--��ѯ�������Ʒ����Ϣ
	public Subject getIdBySubject(int id) {
		Session session=getSession();
		Subject subject=(Subject)session.get(Subject.class, id);
		return subject;
	}
	
	//����������Ʒ--�����Ĺ���������һ
	public void updateSubject(Subject subject) {
		Session session=getSession();
		session.update(subject);
	}
	
	//����������Ʒ--��ӵı깺���¼
	public void addGSL_Subject_purchase_record(Subject_purchase_record spr,Subject subject,Member member) {
		Session session=getSession();
		spr.setMember(member);
		spr.setSubject(subject);
		session.save(spr);
	}
	
	
	
	//����������Ʒ--��Ӽ��˱�ļ�¼
	public void addGSL_Member_tally(Member_tally mt,Member member) {
		Session session=getSession();
		mt.setMember(member);
		session.save(mt);
	}
	
	
	
	
	
	
	
}
