package com.web.member_trade_record_Bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.web.vip_auditing_Bean.Member;


@Entity
@Table
public class Member_trade_record {

	private int id;
	private String trade_no; //交易号
	private String trade_name; //交易名称
	private String counterpart;//交易对方
	private String amount; //交易金额
	private String trade_type; //交易分类
	private String fund_flow;// 资金流向
	private String trade_status; //交易状态
	private String ext_field_1;//扩展一
	private String ext_field_2;//扩展二
	private String ext_field_3;//扩展三
	private Date create_date;
	private Date update_date;
	
	private Member member;
	
	
	@ManyToOne
	@JoinColumn(name="member_id")
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTrade_no() {
		return trade_no;
	}
	public void setTrade_no(String trade_no) {
		this.trade_no = trade_no;
	}
	
	public String getTrade_name() {
		return trade_name;
	}
	public void setTrade_name(String trade_name) {
		this.trade_name = trade_name;
	}
	public String getCounterpart() {
		return counterpart;
	}
	public void setCounterpart(String counterpart) {
		this.counterpart = counterpart;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getTrade_type() {
		return trade_type;
	}
	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}
	public String getFund_flow() {
		return fund_flow;
	}
	public void setFund_flow(String fund_flow) {
		this.fund_flow = fund_flow;
	}
	public String getTrade_status() {
		return trade_status;
	}
	public void setTrade_status(String trade_status) {
		this.trade_status = trade_status;
	}
	public String getExt_field_1() {
		return ext_field_1;
	}
	public void setExt_field_1(String ext_field_1) {
		this.ext_field_1 = ext_field_1;
	}
	public String getExt_field_2() {
		return ext_field_2;
	}
	public void setExt_field_2(String ext_field_2) {
		this.ext_field_2 = ext_field_2;
	}
	public String getExt_field_3() {
		return ext_field_3;
	}
	public void setExt_field_3(String ext_field_3) {
		this.ext_field_3 = ext_field_3;
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
	
	
	
}
