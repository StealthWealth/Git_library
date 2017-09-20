package com.web.bean;

import java.util.Date;

public class Feedback {
// Feedback 意见反馈表
	private int id;      //id
	private int member_id;   //会员id
	private String content;   //意见反馈内容
	private Date create_date;  //创建时间
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMember_id() {
		return member_id;
	}
	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
}
