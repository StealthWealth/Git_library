package com.web.font_service;


import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.web.finance_product_bean.Finance_product_funds;
import com.web.font_bean.Push_notice;
import com.web.font_bean.User_log;
import com.web.font_bean.User_login_token;
import com.web.font_bean.Users;
import com.web.font_dao.FontDao;
import com.web.member_account_Bean.Member_account;
import com.web.news_Bean.News;
import com.web.subject_Bean.Subject;
import com.web.subject_purchase_record_Bean.Subject_purchase_record;
import com.web.sublect_bbin_purchase_record_Bean.Subject_bbin_purchase_record;
import com.web.news_Bean.News;
import com.web.vip_auditing_Bean.Member;

@Service
@Transactional
public class FontService {

	@Autowired
	private FontDao fontDao;
	
	
	//前台注册
	public void addMemberSignIn(Member member,Member_account ma) {
		fontDao.MemberSignIn(member,ma);
	}
	
	//前台登录
	public boolean getMemberSignUp(Member member) {
		return	fontDao.MemberSignUp(member);
	}
	
	//前台登录 传值
	public Member getMemberCZ(Member member) {
		return fontDao.MemberCZ(member);
	}
	
	
	//产品中心 魔符查询
	public List<Subject> listCPZX(Map map){
		List<Subject> list=fontDao.listCPZX(map);
		for (Subject subject : list) {
			System.err.println(subject.getStatus());
		}
		return list;
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
	
	
	//点击产品中 固收类理财的购买按钮后调用dao的方法查询当前固收类理财产品的信息 
	public Subject getByIdSubject(int id) {
		return fontDao.getIdBySubject(id);
	}
	
	//点击产品中 固收类理财的购买按钮后调用dao的方法查询当前客户的账户信息
	public Member_account getByidMember_account(int mid) {
		return fontDao.getMember_account(mid);
	}
	
	
	//我的加法库--投资记录
	public List<Subject_purchase_record> listSPR(int mid){
		return fontDao.listSPR(mid);
	}
	
	
	//我的加法库--账号账户详情
	public Member_account getMember_account(int id){
		return fontDao.getMember_account2(id);
	}
	
	//我的加法库--多少条投资记录
	public long getCount(int mid) {
		return fontDao.getCount(mid);
	}
	
	//我的加法库--体验金
	public Subject_bbin_purchase_record listSbpr(int mid){
		return fontDao.listSBPR(mid);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
