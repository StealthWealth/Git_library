package com.web.font.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.font.bean.Finance_product_funds;
import com.web.font.dao.FontDao;

@Service
@Transactional
public class FontService {

	@Autowired
	private FontDao fontDao;
	
	//��ѯfinance_product_funds(���������Ʒ��)
	public List<Finance_product_funds> showStock(){
		List<Finance_product_funds> list=fontDao.showStock();
		System.out.println("service");
		return list;
	}
	
	
}
