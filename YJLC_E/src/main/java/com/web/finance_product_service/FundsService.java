package com.web.finance_product_service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.finance_product_bean.Finance_product_funds;
import com.web.finance_product_bean.Finance_product_subscribe;
import com.web.finance_product_dao.FundsDao;
import com.web.vip_auditing_Bean.Member;

@Service
@Transactional
public class FundsService {

	@Autowired
	private FundsDao fundsDao;
	
	public List<Finance_product_funds> listfunds(Map map){  //查询私募/股权类信息
		return this.fundsDao.listfuns(map);
	}
	
	public List<Finance_product_subscribe> listsubscribe(int id){  //查询签署状态信息
		return this.fundsDao.listsubscribe(id);
	}
	
	public void fundssave(Finance_product_funds funds){ //保存私募/股权类信息
		this.fundsDao.fundsSave(funds);
	}
	
	public Finance_product_funds getfundsid(int id){  //根据ID查询一行数据
		return this.fundsDao.getfundsid(id);
	}
	
	public void updatefunds(Finance_product_funds funds){  //  修改 私募/股权类信息
		this.fundsDao.updatefunds(funds);
	}
	
	public Finance_product_subscribe getsubscribeid(int id){
		return this.fundsDao.getsubscribeid(id);
	}
	
	public void updatesubscribe(int id){   //签署失败
		this.fundsDao.updatesubscribe(id);
	}
	
	public void updatesubscribe(Finance_product_subscribe subscribe){
		this.fundsDao.updatesubscribe(subscribe);
	}
	
	public Member getmemberid(int id){
		return this.fundsDao.getmemberid(id);
	}
}
