package com.web.oversea_config_dao;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.web.oversea_config_bean.Oversea_config;
import com.web.oversea_config_bean.Oversea_config_subscribe;


@Component
public class Oversea_config_dao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	public List<Oversea_config> listconfig(){   //��ѯ����������ϸ��Ϣ
		String hql = "from Oversea_config order by sortColum desc";
		Session session = this.getSession();
		List<Oversea_config> list = session.createQuery(hql).list();
		return list;
	}
	
	public void saveconfig(Oversea_config config){  //������Ϣ
		Session session = this.getSession();
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str = sim.format(new Date());
		config.setAddTime(str);
		config.setUpdTime(str);
		session.save(config);
	}
	
	public Oversea_config getconfigid(int id){   //����ID��ѯһ������
		Session session = this.getSession();
		Oversea_config config = (Oversea_config)session.get(Oversea_config.class, id);
		return config;
	}
	
	public void editconfig(Oversea_config oversea_config){ //�޸�����
		Session session = this.getSession();
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str = sim.format(new Date());
		oversea_config.setUpdTime(str);
		session.update(oversea_config);
	}
	
	//�鿴ԤԼ��¼
	public List<Oversea_config_subscribe> listsubscribe(int id){
		String hql = "from Oversea_config_subscribe where oversea_id="+id+" order by create_date desc";
		Session session = this.getSession();
		List<Oversea_config_subscribe> list = session.createQuery(hql).list();
		return list;
	}
}
