package com.web.vip_auditing_Bean;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.web.award_records_Bean.Award_records;
import com.web.financial_planner_Bean.Financial_planner;
import com.web.member_account_Bean.Member_account;

@Entity
@Table
public class Member {
//�û�������
	private int id; //���
	private String member_name;  //����
	private String name; //�˺�
	private String password; //����
	private String salt; //������
	private String mobile_Phone; //�绰
	private String status; //״̬
	private String del_flag; //ɾ����־
	private String identity; //���
	private Date create_date; //����ʱ��
	private Date update_date; //�޸�ʱ��
	private String weiBoAccount; //΢���˺Ź���
	private String weixinAccount;//΢���˺Ź���
	private String headid; //ͷ��
	private String invitationCode; //������
	private String withdraw_password; //�������
	private String qqAccount;  //QQ�˺Ź���
	private String invitedCode; //��������
	private String qqNumber; //QQ����
	
	private Member_account member_account;
	
	
	@OneToOne(cascade=CascadeType.ALL)
	public Member_account getMember_account() {
		return member_account;
	}
	public void setMember_account(Member_account ma) {
		this.member_account = ma;
	}
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getMobile_Phone() {
		return mobile_Phone;
	}
	public void setMobile_Phone(String mobile_Phone) {
		this.mobile_Phone = mobile_Phone;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDel_flag() {
		return del_flag;
	}
	public void setDel_flag(String del_flag) {
		this.del_flag = del_flag;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public Date getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}
	public String getWeiBoAccount() {
		return weiBoAccount;
	}
	public void setWeiBoAccount(String weiBoAccount) {
		this.weiBoAccount = weiBoAccount;
	}
	public String getWeixinAccount() {
		return weixinAccount;
	}
	public void setWeixinAccount(String weixinAccount) {
		this.weixinAccount = weixinAccount;
	}
	public String getHeadid() {
		return headid;
	}
	public void setHeadid(String headid) {
		this.headid = headid;
	}
	public String getInvitationCode() {
		return invitationCode;
	}
	public void setInvitationCode(String invitationCode) {
		this.invitationCode = invitationCode;
	}
	public String getWithdraw_password() {
		return withdraw_password;
	}
	public void setWithdraw_password(String withdraw_password) {
		this.withdraw_password = withdraw_password;
	}
	public String getQqAccount() {
		return qqAccount;
	}
	public void setQqAccount(String qqAccount) {
		this.qqAccount = qqAccount;
	}
	public String getInvitedCode() {
		return invitedCode;
	}
	public void setInvitedCode(String invitedCode) {
		this.invitedCode = invitedCode;
	}
	public String getQqNumber() {
		return qqNumber;
	}
	public void setQqNumber(String qqNumber) {
		this.qqNumber = qqNumber;
	}
	
	
	
	
}
