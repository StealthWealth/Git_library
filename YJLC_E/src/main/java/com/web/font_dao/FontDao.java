package com.web.font_dao;


import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Expression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.web.finance_product_bean.Finance_product_funds;
import com.web.font_bean.Push_notice;
import com.web.font_bean.User_log;
import com.web.font_bean.User_login_token;
import com.web.font_bean.Users;
import com.web.member_account_Bean.Member_account;
import com.web.news_Bean.News;
import com.web.subject_Bean.Subject;
import com.web.subject_purchase_record_Bean.Subject_purchase_record;
import com.web.sublect_bbin_purchase_record_Bean.Subject_bbin_purchase_record;
import com.web.vip_auditing_Bean.Member;

@Component
public class FontDao {

	@Autowired
	private SessionFactory sessionFactory;  
	
	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	
	
	//ǰ̨ע��   �û�������  ��  ��Ա�˻���
	public void MemberSignIn(Member member,Member_account ma) {
		Session session=this.getSession();
		ma.setMember(member);
		member.setMember_account(ma);
		session.save(member);
		session.save(ma);		
	}
	
	//ǰ̨��¼
	public boolean MemberSignUp(Member member) {
		Session session=this.getSession();
		String hql="from Member where name='"+member.getName()+"' and password='"+member.getPassword()+"'";
		List<Member> list=session.createQuery(hql).list();
		if (list.size()>0) {
			return true;
		}
		return false;
	}
	
	
	//ǰ̨��½��Ĵ�ֵ  
	public Member MemberCZ(Member member) {
		Session session=this.getSession();
		Criteria criteria=session.createCriteria(Member.class);
		criteria.add(Expression.eq("name", member.getName()));
		criteria.add(Expression.eq("password", member.getPassword()));
		List<Member> list=criteria.list();
		Member member2=null;
		if (list.size() > 0) {
			 member2=list.get(0);
		}
		return member2;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//��̨��¼	
	public Users signIn(Users users) {
		Session session=this.getSession();
		String hql="from Users where user_name="+users.getUser_name()+" and password="+users.getPassword()+" ";
		Users users2=(Users)session.createQuery(hql);
		return users2;
		
	}
	
	
	//��̨ע��
	public void sifnUp(Users users,User_log user_log,User_login_token user_login_token) {
		Session session=this.getSession();
		users.setUser_log(user_log);
	//	session.save(user_login_token);
		session.save(user_log);
		session.save(users);
		
	}
	
	
	//��ѯfinance_product_funds(���������Ʒ��)
	public List<Finance_product_funds> listStock(){
		Session session=this.getSession();
		String hql="from Finance_product_funds";
		List<Finance_product_funds> list=session.createQuery(hql).list();
		return list;
	}
	
	//��ѯ����
	public List<Push_notice> listPush(){
		Session session=this.getSession();
		String hql="from Push_notice";
		List<Push_notice> list=session.createQuery(hql).list();
		return list;
	}
	
	
	//��ѯ����
	public List<News> listNews(){
		Session session=this.getSession();
		String hql="from News ";
		List<News> list=session.createQuery(hql).setMaxResults(6).list();
		return list;
	}
	
	
	//�˻�����  ��ѯ����
	public List<Users> listUsers(){
		Session session=this.getSession();
		String hql="from Users where status!=2";
		List<Users> list=session.createQuery(hql).list();
		return list;
	}
	
	
	//���ߴ���id��ѯ��̨�˻�����  ׼���޸�
	public Users getByIdUsers(int id) {
		Session session=this.getSession();
		Users users=(Users)session.get(Users.class, id);
		return users;
	}
	
	//��̨�˻������޸�
	public void updateusers(Users users) {
		Session session=this.getSession();
		session.update(users);
	}
	
	//��̨�˻�����ɾ��
	public void deleteusers(Users users) {
		Session session=this.getSession();
		session.update(users.getStatus());
	}
	
	
	
	
	//��Ʒ���� ħ����ѯ
	public List<Subject> listCPZX(Map map) {
		String hql="from Subject  where 1=1 ";
		hql=listDataHql(hql, map);
         Session session=getSession();
  	    List<Subject> list=session.createQuery(hql).list();
		return list;
	}
	
	//ƴ�ӵ�ħ����ѯ
	 public String listDataHql(String hql,Map map){
		   String year_rate=(String)map.get("year_rate");
		   String period_start=(String)map.get("period_start");
		   String period_end=(String)map.get("period_end");
		   String type=(String)map.get("type");
		   String status=(String)map.get("status");
		   String flag=(String)map.get("flag");
		   
		   System.out.println("dao="+status);
		   if(year_rate!=null&&!year_rate.equals("")){
			   if("0".equals(flag)){
				   hql+=" and year_rate="+Double.valueOf(year_rate);
			 }else if("1".equals(flag)){
				   hql+=" and year_rate>"+Double.valueOf(year_rate);  
			   }
		   }
		   if((period_start!=null&&!period_start.equals(""))&&(period_end!=null&&!period_end.equals(""))){
			      if(period_end.equals("-1")){
			    	  hql+=" and period >="+Integer.valueOf(period_start);
			      }else{
				    hql+=" and period between "+Integer.valueOf(period_start)+ " and "+Integer.valueOf(period_end);
			      }
		   }
		   
		   if(status!=null&&!status.equals("")){
			     if(status.equals("-1")){
			     }else{
			    	  hql+=" and status="+Integer.valueOf(status); 
			     }
			  
		   }
		   System.out.println("hql===="+hql);
		   return hql;
	   }
	
	 
	 //��Ʒ���� ��������ƵĹ���ť֮���ѯ��ǰ�������Ʒ����Ϣ
	public Subject getIdBySubject(int id) {
		Session session=getSession();
		Subject subject=(Subject)session.get(Subject.class, id);
		return subject;
	}
	
	//��Ʒ���� ��������ƵĹ���ť֮���ѯ��ǰ �ͻ��Ľ����Ϣ
	public Member_account getMember_account(int member_id) {
		Session session=getSession();
		Criteria criteria=session.createCriteria(Member_account.class);
		criteria.add(Expression.eq("member.id", member_id) );
		System.out.println("member_id:"+member_id);
		List<Member_account> list=criteria.list();
		Member_account ma = null;
		if (list.size() > 0) {
			ma=list.get(0);
		}
		return ma;
	}
	
	
	//�ҵļӷ���--Ͷ�ʼ�¼
	public List<Subject_purchase_record> listSPR(int mid) {
		Session session=this.getSession();
		String hql="from Subject_purchase_record where member_id="+mid+"";
		List list=session.createQuery(hql).list();
		if (list.size() > 0) {
			return list;
		}
		return list=null;
	}
	//�ҵļӷ���--ͳ��Ͷ�ʼ�¼
	public long getCount(int mid) {
		Session session=this.getSession();
		List list=session.createQuery("select count(*) from Subject_purchase_record where member_id="+mid+"").list();
		if (list.size() > 0) {
			long count = (long) list.get(0);
			return count;
		}
		return 0;
	}
	
	//�ҵļӷ���--������¼
	public Subject_bbin_purchase_record listSBPR(int mid){
		Session session=this.getSession();
		String hql="from Subject_bbin_purchase_record where member_id="+mid+"";
		List list=session.createQuery(hql).list();
		Subject_bbin_purchase_record sbpr=null;
		if (list.size() > 0) {
			return sbpr=(Subject_bbin_purchase_record)list.get(0);
		}
		return sbpr;
	}
	
	
	//�ҵļӷ���--��ѯ�˺��˻�����
	public Member_account getMember_account2(int id){
		Session session = getSession();
		String hql = "from Member_account as memberAcc  where memberAcc.member.id="+id;
		List<Member_account> List_Member_account = session.createQuery(hql).list();
		if(List_Member_account.size()>0){
			return List_Member_account.get(0);
		}
		return null;
		
	}
	
	
}
