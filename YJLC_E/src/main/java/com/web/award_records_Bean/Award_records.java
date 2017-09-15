package com.web.award_records_Bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.web.member_account_Bean.Member_account;
import com.web.vip_auditing_Bean.Member;

@Entity
@Table
public class Award_records {
	//Award_records������¼��
	private int id;			//id
	//private int invitingid; //������id
	private int byinvitingid; //��������id
	private int type; 		//��������(0:ע�ά��,1:Ͷ�ʽ���)
	private int isAward;    //����״̬(0:δ���� 1:�ѽ���)
	private String amount; //�������
	private Date addTime;	//���ʱ��
	
	private Member member;
	
	
	@ManyToOne
	@JoinColumn(name="invitingid")
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getByinvitingid() {
		return byinvitingid;
	}
	public void setByinvitingid(int byinvitingid) {
		this.byinvitingid = byinvitingid;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getIsAward() {
		return isAward;
	}
	public void setIsAward(int isAward) {
		this.isAward = isAward;
	}
	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	
	
	
	
	
}
