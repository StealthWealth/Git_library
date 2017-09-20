package com.web.oversea_config_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.oversea_config_bean.Oversea_config;
import com.web.oversea_config_bean.Oversea_config_subscribe;
import com.web.oversea_config_dao.Oversea_config_dao;

@Service
@Transactional
public class Oversea_config_service {

	@Autowired
	private Oversea_config_dao config;
	
	//查询海外配置信息
	public List<Oversea_config> listconfig(){
		return this.config.listconfig();
	}
	
	//保存海外配置信息
	public void saveconfig(Oversea_config config){
		this.config.saveconfig(config);
	}
	
	//根据ID得到一行数据
	public Oversea_config getconfigid(int id){
		return this.config.getconfigid(id);
	}
	
	//修改海外配置信息
	public void editconfig(Oversea_config oversea_config){
		this.config.editconfig(oversea_config);
	}
	
	//查看预约信息记录
	public List<Oversea_config_subscribe> listsubscribe(int id){
		return this.config.listsubscribe(id);
	}
}
