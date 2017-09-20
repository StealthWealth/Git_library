package com.web.bean;

import java.util.Date;

public class Subject_folder {
	// subject_folder 附件归属表
	private int id;          //id 
	private Date create_date;     //创建时间
	private Date update_date;     //修改时间
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
