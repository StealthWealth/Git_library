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
	
	//��ѯfinance_product_funds(���������Ʒ��)
	public List<Finance_product_funds> listStock(){
		List<Finance_product_funds> list=fontDao.listStock();
		return list;
	}
	
	
	//��ѯ����
	public List<Push_notice> listPush(){
		List<Push_notice> list=fontDao.listPush();
		return list;
	}
	
	
	
	
}
