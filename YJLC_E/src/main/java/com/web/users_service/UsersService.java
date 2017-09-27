package com.web.users_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.font_bean.Users;
import com.web.users_Dao.UsersDao;

@Service
@Transactional
public class UsersService {

	@Autowired
	private UsersDao usersDao;
	
	
	//登陆 根据账号密码手机号
	public Users getUsers(String user_name,String password,String mobile_Phone){
		return usersDao.getUsers(user_name, password, mobile_Phone);
	}
}
