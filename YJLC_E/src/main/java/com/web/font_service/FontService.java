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
	
	
	//ǰ̨ע��
	public void addMemberSignIn(Member member,Member_account ma) {
		fontDao.MemberSignIn(member,ma);
	}
	
	//ǰ̨��¼
	public boolean getMemberSignUp(Member member) {
		return	fontDao.MemberSignUp(member);
	}
	
	//ǰ̨��¼ ��ֵ
	public Member getMemberCZ(Member member) {
		return fontDao.MemberCZ(member);
	}
	
	
	//��Ʒ���� ħ����ѯ
	public List<Subject> listCPZX(Map map){
		List<Subject> list=fontDao.listCPZX(map);
		for (Subject subject : list) {
			System.err.println(subject.getStatus());
		}
		return list;
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
	
	
	//�����Ʒ�� ��������ƵĹ���ť�����dao�ķ�����ѯ��ǰ��������Ʋ�Ʒ����Ϣ 
	public Subject getByIdSubject(int id) {
		return fontDao.getIdBySubject(id);
	}
	
	//�����Ʒ�� ��������ƵĹ���ť�����dao�ķ�����ѯ��ǰ�ͻ����˻���Ϣ
	public Member_account getByidMember_account(int mid) {
		return fontDao.getMember_account(mid);
	}
	
	
	//�ҵļӷ���--Ͷ�ʼ�¼
	public List<Subject_purchase_record> listSPR(int mid){
		return fontDao.listSPR(mid);
	}
	
	
	//�ҵļӷ���--�˺��˻�����
	public Member_account getMember_account(int id){
		return fontDao.getMember_account2(id);
	}
	
	//�ҵļӷ���--������Ͷ�ʼ�¼
	public long getCount(int mid) {
		return fontDao.getCount(mid);
	}
	
	//�ҵļӷ���--�����
	public Subject_bbin_purchase_record listSbpr(int mid){
		return fontDao.listSBPR(mid);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
