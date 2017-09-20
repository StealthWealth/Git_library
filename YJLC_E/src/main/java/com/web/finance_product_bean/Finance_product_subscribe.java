package com.web.finance_product_bean;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.web.vip_auditing_Bean.Member;

@Entity
@Table
public class Finance_product_subscribe {
//  Finance_product_subscribe   ���������ƷԤԼ��¼��
	private int id;           //id
	private String name;      //����
	private String phone;     //��ϵ�绰
	private String addr;      //���ڵ���
	private int status;       //�Ƿ���(0:ǩ������|1:��ǩԼ|2:�����|3:ǩ��ʧ��)
	private String comment;   //����ǩ���ĵ���Ϣ
	private String risk_reveal;  //���ս�ʾ��
	private String create_date;   //����ʱ��
	private String update_date;    //�޸�ʱ��
	private Integer amount;    //˽ļ������
	private float interest;  //˽ļ��������
	private String start_date;    //��ʼʱ��
	private String end_date;      //����ʱ��
	private String signed_photos;  //ǩ������
	
	
	private Member member;
	private Finance_product_funds funds;
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getRisk_reveal() {
		return risk_reveal;
	}
	public void setRisk_reveal(String risk_reveal) {
		this.risk_reveal = risk_reveal;
	}
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	public String getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	public float getInterest() {
		return interest;
	}
	public void setInterest(float interest) {
		this.interest = interest;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public String getSigned_photos() {
		return signed_photos;
	}
	public void setSigned_photos(String signed_photos) {
		this.signed_photos = signed_photos;
	}
	
	@ManyToOne
	@JoinColumn(name="member_id")
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	
	
	@ManyToOne
	@JoinColumn(name="product_id")
	public Finance_product_funds getFunds() {
		return funds;
	}
	public void setFunds(Finance_product_funds funds) {
		this.funds = funds;
	}
}
