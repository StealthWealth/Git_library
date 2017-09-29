package com.web.vip_auditing_Bean;

import javax.persistence.Table;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table
public class Member_profit_record {

	private int id;            // ��Ա�����¼��
	private String serial_number;        // ��ˮ��
	private int type;          // ����
	private double amount;     // ���
	private int delflag;       // 
	private String create_date;          // ����ʱ��
	private String update_date;          // �޸�ʱ��
	private String comment;    // ��ע
	private int purchase_id;   // ���ID
	private int profit_year;   // ��Ϣ��
	private int profit_month;  // ��Ϣ��
	private int profit_day;    // ��Ϣ��
	
	private Member member;     // �����ԱID

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSerial_number() {
		return serial_number;
	}

	public void setSerial_number(String serial_number) {
		this.serial_number = serial_number;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getDelflag() {
		return delflag;
	}

	public void setDelflag(int delflag) {
		this.delflag = delflag;
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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getPurchase_id() {
		return purchase_id;
	}

	public void setPurchase_id(int purchase_id) {
		this.purchase_id = purchase_id;
	}

	public int getProfit_year() {
		return profit_year;
	}

	public void setProfit_year(int profit_year) {
		this.profit_year = profit_year;
	}

	public int getProfit_month() {
		return profit_month;
	}

	public void setProfit_month(int profit_month) {
		this.profit_month = profit_month;
	}

	public int getProfit_day() {
		return profit_day;
	}

	public void setProfit_day(int profit_day) {
		this.profit_day = profit_day;
	}

	@ManyToOne
	@JoinColumn(name="member_id")
	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}
}
