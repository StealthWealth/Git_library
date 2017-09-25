package com.web.font_bean;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Push_notice {
//  push_notice  公告表
	private int id;    //id
	private String title;   //标题
	private String content;  //内容
	private int status;   //公告状态
	private String create_date;  //创建时间
	private String update_Date;    //修改时间
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	public String getUpdate_Date() {
		return update_Date;
	}
	public void setUpdate_Date(String update_Date) {
		this.update_Date = update_Date;
	}
}
