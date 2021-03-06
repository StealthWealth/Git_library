package com.web.font_bean;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Users {
	//users 用户基本表
	private int id;                    //用户id
	private String user_name;          //用户名
	private String name;               //名称
	private String password;           //密码
	private String salt;               //密码盐
	private String mobile_Phone;       //手机号
	private int status;                //账号状态(正常，锁定，删除)
	private int del_flag;              //删除标志
	private int identity;              //身份
	private Date create_date;          //创建时间
	private Date update_date;          //修改时间
	private User_log user_log;         //登录日志bean
//	private User_login_token user_login_token;          //用户登录令牌bean
	private User_message User_message;  //用户消息bean
	
	
	//关联用户消息表
	@OneToOne(cascade=CascadeType.ALL)
	public User_message getUser_message() {
		return User_message;
	}
	public void setUser_message(User_message user_message) {
		User_message = user_message;
	}
	
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	//关联用户登录日志表
	@OneToOne(cascade=CascadeType.ALL)
	public User_log getUser_log() {
		return user_log;
	}
	public void setUser_log(User_log user_log) {
		this.user_log = user_log;
	}
	
	//关联用户令牌表
/*	@OneToOne(cascade=CascadeType.ALL,optional=true)
	public User_login_token getUser_login_token() {
		return user_login_token;
	}
	public void setUser_login_token(User_login_token user_login_token) {
		this.user_login_token = user_login_token;
	}
	*/
	
	
	
	
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getDel_flag() {
		return del_flag;
	}
	public void setDel_flag(int del_flag) {
		this.del_flag = del_flag;
	}
	public int getIdentity() {
		return identity;
	}
	public void setIdentity(int identity) {
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
}
