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
public class User_login_token {
	//user_login_token 用户登陆令牌表
	private String token;            //令牌号
	private int user_id;             //用户id
	private String user_name;        //登录时的用户名，可以是用户名，手机号等
	private String password;         //密码
	private Date expire_time;        //有效时间
	private Date create_date;        //创建时间
	private Date update_date;        //修改时间
//	private Users users   ;  		//用户基本bean
	
	/*	@OneToOne(cascade=CascadeType.ALL,mappedBy="user_login_token",optional=false)
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	*/
	
	@Id
	@GeneratedValue
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getExpire_time() {
		return expire_time;
	}
	public void setExpire_time(Date expire_time) {
		this.expire_time = expire_time;
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
