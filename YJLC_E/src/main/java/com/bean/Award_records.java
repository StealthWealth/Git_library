package com.bean;

import java.util.Date;

public class Award_records {
	//Award_records½±Àø¼ÇÂ¼±í
	private int id;			//id
	private int invitingid; //ÑûÇëÈËid
	private int byinvitingid; //±»ÑûÇëÈËid
	private int type; 		//½±Àø×´Ì¬(0:Î´½±Àø    1:ÒÑ½±Àø)
	private Date addTime;	//Ìí¼ÓÊ±¼ä
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getInvitingid() {
		return invitingid;
	}
	public void setInvitingid(int invitingid) {
		this.invitingid = invitingid;
	}
	public int getByinvitingid() {
		return byinvitingid;
	}
	public void setByinvitingid(int byinvitingid) {
		this.byinvitingid = byinvitingid;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	
	
	
	
	
}
