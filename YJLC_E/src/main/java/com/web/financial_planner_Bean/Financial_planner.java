package com.web.financial_planner_Bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.web.vip_auditing_Bean.Member;

@Entity
@Table
public class Financial_planner {
//  Financial_planner  ���ʦ��
	private int id;     //id
	//private int member_id;   //��Աid
	private String name;       //��ʵ����
	private String orgname;    //��������
	private String mycard;     //�ҵ���Ƭ
	private String address;    //��ͥסַ
	private int status;     //״̬
	private Date create_date;     //����ʱ��
	private Date update_date;     //�޸�ʱ��
	
	private Member member;
	
	
	@OneToOne
	@JoinColumn(name="member_id")
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOrgname() {
		return orgname;
	}
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}
	public String getMycard() {
		return mycard;
	}
	public void setMycard(String mycard) {
		this.mycard = mycard;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
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
