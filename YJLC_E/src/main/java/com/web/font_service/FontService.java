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
	
	
	//ǰ̨ע��
	public void addMemberSignIn(Member member) {
		fontDao.MemberSignIn(member);
	}
	
	//ǰ̨��¼
	public Member getMemberSignUp(Member member) {
		return	fontDao.MemberSignUp(member);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	//��ѯfinance_product_funds(���������Ʒ��)
	public List<Finance_product_funds> listStock(){
		List<Finance_product_funds> list=fontDao.listStock();
		return list;
	}
	
	
	//��ѯ����
	public List<Push_notice> listPush(){
		List<Push_notice> list=fontDao.listPush();
		return list;
	}
	
	//��ѯ����
	public List<News> listNews(){
		List<News> list=fontDao.listNews();
		return list;
	}
	
	
	//ע��
	public void addSignUp(Users users,User_log ul,User_login_token ult) {
		fontDao.sifnUp(users, ul, ult);
		
	}
	
	// ��̨��¼ 
	public Users getUsers(Users users) {
		Users users2=fontDao.signIn(users);
		return users2;
	}
	
	//��ʾ�˻��˻������е�����
	public List<Users> listUsers(){
		List<Users> list=fontDao.listUsers();
		return list;
	}
	
	//��ѯ��̨�˻�����Ҫ�޸ĵ��˻���Ϣ
	public Users getByIdusers(int id) {
		Users users=fontDao.getByIdUsers(id);
		return users;
	}
	
	//��̨�˻������޸�
	public void updateusers(Users users) {
		fontDao.updateusers(users);
	}
	
	//��̨�˻�����ɾ��
	public void deleteusers(Users users) {
		fontDao.updateusers(users);
		
	}
	
	
}
