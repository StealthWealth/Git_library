package com.web.font_dao;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.web.finance_product_bean.Finance_product_funds;
import com.web.font_bean.News;
import com.web.font_bean.Push_notice;
import com.web.font_bean.User_log;
import com.web.font_bean.User_login_token;
import com.web.font_bean.Users;
import com.web.vip_auditing_Bean.Member;

@Component
public class FontDao {

	@Autowired
	private SessionFactory sessionFactory;  
	
	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	
	
	//前台注册
	public void MemberSignIn(Member member) {
		Session session=this.getSession();
		session.save(member);
	}
	
	//前台登录
	public Member MemberSignUp(Member member) {
		Session session=this.getSession();
			
		
		
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//后台登录	
	public Users signIn(Users users) {
		Session session=this.getSession();
		String hql="from Users where user_name="+users.getUser_name()+" and password="+users.getPassword()+" ";
		Users users2=(Users)session.createQuery(hql);
		return users2;
		
	}
	
	
	//后台注册
	public void sifnUp(Users users,User_log user_log,User_login_token user_login_token) {
		Session session=this.getSession();
		users.setUser_log(user_log);
	//	session.save(user_login_token);
		session.save(user_log);
		session.save(users);
		
	}
	
	
	//查询finance_product_funds(理财类基金产品表)
	public List<Finance_product_funds> listStock(){
		Session session=this.getSession();
		String hql="from Finance_product_funds";
		List<Finance_product_funds> list=session.createQuery(hql).list();
		return list;
	}
	
	//查询公告
	public List<Push_notice> listPush(){
		Session session=this.getSession();
		String hql="from Push_notice";
		List<Push_notice> list=session.createQuery(hql).list();
		return list;
	}
	
	
	//查询新闻
	public List<News> listNews(){
		Session session=this.getSession();
		String hql="from News ";
		List<News> list=session.createQuery(hql).setMaxResults(6).list();
		return list;
	}
	
	
	//账户设置  查询所有
	public List<Users> listUsers(){
		Session session=this.getSession();
		String hql="from Users where status!=2";
		List<Users> list=session.createQuery(hql).list();
		return list;
	}
	
	
	//更具传的id查询后台账户设置  准备修改
	public Users getByIdUsers(int id) {
		Session session=this.getSession();
		Users users=(Users)session.get(Users.class, id);
		return users;
	}
	
	//后台账户设置修改
	public void updateusers(Users users) {
		Session session=this.getSession();
		session.update(users);
	}
	
	//后台账户设置删除
	public void deleteusers(Users users) {
		Session session=this.getSession();
		session.update(users.getStatus());
	}
	
	
	
}
