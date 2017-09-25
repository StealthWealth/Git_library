package com.web.feedback_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.bean.Feedback;
import com.web.feedback_dao.Feedback_dao;

@Service
@Transactional
public class Feedback_service {

	@Autowired
	private Feedback_dao fd;
	
	// 查询意见反馈
	public List<Feedback> listfeedback(){
		return this.fd.listfeedback();
	}
}
