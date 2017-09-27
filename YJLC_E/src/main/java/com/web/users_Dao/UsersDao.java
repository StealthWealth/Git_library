package com.web.users_Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.web.font_bean.Users;

@Component
public class UsersDao {

	@Autowired
	private SessionFactory sessionFactory;

	
	//��ȡSession
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	//��֤�˺������ֻ���
	public Users getUsers(String user_name,String password,String mobile_Phone){
		Session session = getSession();
		String hql = " from Users where user_name='"+user_name+"' and password='"+password+"' and mobile_Phone='"+mobile_Phone+"' and del_flag=0"; //del_flag=0 �����˺�û��ɾ��
		List<Users> list = session.createQuery(hql).list();
		Users users = null;
		if(list.size()>0){
			return list.get(0);
		}
		return users;
	}
}
