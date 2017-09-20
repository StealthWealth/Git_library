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
	//Award_records½±Àø¼ÇÂ¼±í
	private int id;			//id
	//private int invitingid; //ÑûÇëÈËid
	private int byinvitingid; //±»ÑûÇëÈËid
	private int type; 		//½±ÀøÀàĞÍ(0:×¢²á½±Àø,1:Í¶×Ê½±Àø)
	private int isAward;    //½±Àø×´Ì¬(0:Î´½±Àø 1:ÒÑ½±Àø)
	private String amount; //½±Àø½ğ¶î
	private Date addTime;	//Ìí¼ÓÊ±¼ä
	
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
