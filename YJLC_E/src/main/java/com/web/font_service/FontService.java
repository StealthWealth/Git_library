package com.web.font_service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.finance_product_bean.Finance_product_funds;
import com.web.font_bean.News;
import com.web.font_bean.Push_notice;
import com.web.font_bean.User_log;
import com.web.font_bean.User_login_token;
import com.web.font_bean.Users;
import com.web.font_dao.FontDao;
import com.web.vip_auditing_Bean.Member;

@Service
@Transactional
public class FontService {

	@Autowired
	private FontDao fontDao;
	
	
	//前台注册
	public void addMemberSignIn(Member member) {
		fontDao.MemberSignIn(member);
	}
	
	//前台登录
	public Member getMemberSignUp(Member member) {
		return	fontDao.MemberSignUp(member);
	}
	
	
	
	
	
	
	
	
	
	
	
	
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
	
	//查询新闻
	public List<News> listNews(){
		List<News> list=fontDao.listNews();
		return list;
	}
	
	
	//注册
	public void addSignUp(Users users,User_log ul,User_login_token ult) {
		fontDao.sifnUp(users, ul, ult);
		
	}
	
	// 后台登录 
	public Users getUsers(Users users) {
		Users users2=fontDao.signIn(users);
		return users2;
	}
	
	//显示账户账户设置中的内容
	public List<Users> listUsers(){
		List<Users> list=fontDao.listUsers();
		return list;
	}
	
	//查询后台账户设置要修改的账户信息
	public Users getByIdusers(int id) {
		Users users=fontDao.getByIdUsers(id);
		return users;
	}
	
	//后台账户设置修改
	public void updateusers(Users users) {
		fontDao.updateusers(users);
	}
	
	//后台账户设置删除
	public void deleteusers(Users users) {
		fontDao.updateusers(users);
		
	}
	
	
}
