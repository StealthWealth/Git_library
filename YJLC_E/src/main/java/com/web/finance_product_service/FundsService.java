package com.web.finance_product_service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.finance_product_bean.Finance_product_funds;
import com.web.finance_product_bean.Finance_product_subscribe;
import com.web.finance_product_dao.FundsDao;

@Service
@Transactional
public class FundsService {

	@Autowired
	private FundsDao fundsDao;
	
	public List<Finance_product_funds> listfunds(Map map){
		return this.fundsDao.listfuns(map);
	}
	
	public List<Finance_product_subscribe> listsubscribe(int id){
		return this.fundsDao.listsubscribe(id);
	}
	
	public void savesubscribe(Finance_product_subscribe subscribe){
		this.fundsDao.saveSubscribe(subscribe);
	}
}
