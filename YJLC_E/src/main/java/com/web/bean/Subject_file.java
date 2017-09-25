package com.web.bean;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Subject_file {
	// subject_file  附件表
	private int id;           //id
//	private int folder_id;    //附件主表id
	private String path;      //文件路径
	private String file_name; //文件名
	private String original_name;   //原文件名
	private String create_date; //创建时间
	private String update_date; //修改时间
	
	
	private Subject_folder folder;
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
//	public int getFolder_id() {
//		return folder_id;
//	}
//	public void setFolder_id(int folder_id) {
//		this.folder_id = folder_id;
//	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	public String getOriginal_name() {
		return original_name;
	}
	public void setOriginal_name(String original_name) {
		this.original_name = original_name;
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
	
	@ManyToOne
	@JoinColumn(name="folder_id")
	public Subject_folder getFolder() {
		return folder;
	}
	public void setFolder(Subject_folder folder) {
		this.folder = folder;
	}
}
