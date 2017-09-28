package com.web.font_service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.font_bean.Member_tally;
import com.web.font_dao.AlipayDao;
import com.web.member_account_Bean.Member_account;
import com.web.member_deposit_record_Bean.Member_deposit_record;
import com.web.member_trade_record_Bean.Member_trade_record;
import com.web.subject_Bean.Subject;
import com.web.subject_purchase_record_Bean.Subject_purchase_record;
import com.web.vip_auditing_Bean.Member;

@Service
@Transactional
public class AlipayService {

	@Autowired
	private AlipayDao alipayDao;
	
	
	
	//�޸Ľ�� ��ӳ�ֵ��¼
	public void updateMA(Member_account ma,Member_deposit_record mdr,Member member,Member_trade_record mtr) {
		alipayDao.updateUseable_balance(ma);
		alipayDao.addMember_deposit_record(mdr,member);
		alipayDao.addGSLjl(mtr, member);
	}
	
	
	//��ѯ�˻���
	public Member_account getMa(int member_id) {
		return alipayDao.getMember_account(member_id);
	}
	
	
	//���������--�޸Ĺ���������Ʒ��Ľ�� �ܽ��  ʱ��
	public void updatema(Member_account ma,Member member,Member_trade_record mtr,Subject subject,Subject_purchase_record spr,Member_tally mt) {
		alipayDao.yjpayGSL(ma);//�޸Ľ��
		alipayDao.addGSLjl(mtr, member);//���׼�¼����Ӽ�¼
		alipayDao.updateSubject(subject);//�޸�subject��Ĺ�������
		alipayDao.addGSL_Subject_purchase_record(spr, subject, member);//��Ĺ����
		alipayDao.addGSL_Member_tally(mt, member);//���˱�
	}
	
	//���������--��ѯ�������Ʒ��Ϣ
	public Subject getByIdSubject(int sid) {
		return alipayDao.getIdBySubject(sid);
	}
	
	
	
}
