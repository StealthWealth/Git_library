package com.web.font.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.finance_product_bean.Finance_product_funds;
import com.web.font.bean.Push_notice;
import com.web.font.dao.FontDao;

@Service
@Transactional
public class FontService {

	@Autowired
	private FontDao fontDao;
	
	//查询finance_product_funds(理财类基金产品表)
	public List<Finance_product_funds> listStock(){
		List<Finance_product_funds> list=fontDao.listStock();
		return list;
	}
	
	
	//查询公告
	public List<Push_notice> listPush(){
		List<Push_notice> list=fontDao.listPush();
		return list;
	}
	
	
	
	
}
