package com.web.font_bean;

import java.util.Date;

public class User_role_relation {
	// user_role_relation  �û���ɫ������
	private int user_id;          //�û�id
	private int role_id;          //��ɫid
	private Date create_date;     //����ʱ��
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
}
