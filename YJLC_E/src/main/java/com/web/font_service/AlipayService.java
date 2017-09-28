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
	
	
	
	//修改金额 添加充值记录
	public void updateMA(Member_account ma,Member_deposit_record mdr,Member member,Member_trade_record mtr) {
		alipayDao.updateUseable_balance(ma);
		alipayDao.addMember_deposit_record(mdr,member);
		alipayDao.addGSLjl(mtr, member);
	}
	
	
	//查询账户表
	public Member_account getMa(int member_id) {
		return alipayDao.getMember_account(member_id);
	}
	
	
	//购买固收类--修改购买固收类产品后的金额 总金额  时间
	public void updatema(Member_account ma,Member member,Member_trade_record mtr,Subject subject,Subject_purchase_record spr,Member_tally mt) {
		alipayDao.yjpayGSL(ma);//修改金额
		alipayDao.addGSLjl(mtr, member);//向交易记录表添加记录
		alipayDao.updateSubject(subject);//修改subject表的购买人数
		alipayDao.addGSL_Subject_purchase_record(spr, subject, member);//表的购买表
		alipayDao.addGSL_Member_tally(mt, member);//记账表
	}
	
	//购买固收类--查询固收类产品信息
	public Subject getByIdSubject(int sid) {
		return alipayDao.getIdBySubject(sid);
	}
	
	
	
}
