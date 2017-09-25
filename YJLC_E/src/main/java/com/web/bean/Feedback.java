package com.web.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.web.vip_auditing_Bean.Member;

@Entity
@Table
public class Feedback {
// Feedback 意见反馈表
	private int id;      //id
//	private int member_id;   //会员id
	private String content;   //意见反馈内容
	private String create_date;  //创建时间
	
	private Member member;
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
//	public int getMember_id() {
//		return member_id;
//	}
//	public void setMember_id(int member_id) {
//		this.member_id = member_id;
//	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
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
