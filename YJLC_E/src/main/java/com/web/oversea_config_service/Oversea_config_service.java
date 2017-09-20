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
	
	//��ѯ����������Ϣ
	public List<Oversea_config> listconfig(){
		return this.config.listconfig();
	}
	
	//���溣��������Ϣ
	public void saveconfig(Oversea_config config){
		this.config.saveconfig(config);
	}
	
	//����ID�õ�һ������
	public Oversea_config getconfigid(int id){
		return this.config.getconfigid(id);
	}
	
	//�޸ĺ���������Ϣ
	public void editconfig(Oversea_config oversea_config){
		this.config.editconfig(oversea_config);
	}
	
	//�鿴ԤԼ��Ϣ��¼
	public List<Oversea_config_subscribe> listsubscribe(int id){
		return this.config.listsubscribe(id);
	}
}
