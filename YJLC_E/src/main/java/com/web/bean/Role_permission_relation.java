package com.web.bean;

import java.util.Date;

public class Role_permission_relation {
//role_permission_relation   角色权限表
	private int role_id;  //角色id'
	private String permission_ename; //权限名称
	private Date create_date;   //创建时间
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public String getPermission_ename() {
		return permission_ename;
	}
	public void setPermission_ename(String permission_ename) {
		this.permission_ename = permission_ename;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
}
