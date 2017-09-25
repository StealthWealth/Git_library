package com.web.Push_notice_service;

import org.springframework.transaction.annotation.Transactional;

import com.web.Push_notice_dao.Push_notice_dao;
import com.web.font_bean.Push_notice;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class Push_notice_service {

	@Autowired
	private Push_notice_dao pnd;
	
	public List<Push_notice> listnotice(Map map){
		return this.pnd.listnotice(map);
	}
	
	public void savenotice(Push_notice notice){
		this.pnd.savenotice(notice);
	}
	
	public Push_notice getNoticeId(int id){
		return this.pnd.getNoticeId(id);
	}
	
	public void updatenotice(Push_notice notice){
		this.pnd.updatenotice(notice);
	}
}
