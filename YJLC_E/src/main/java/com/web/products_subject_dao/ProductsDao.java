package com.web.products_subject_dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.web.bean.Subject_file;
import com.web.subject_Bean.Subject;
import com.web.subject_purchase_record_Bean.Subject_purchase_record;

@Component
public class ProductsDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getsession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	public List<Subject> listsubject(Map map){   //  固收类查询
		String hql = "from Subject where 1=1 ";
		hql = this.getHql(map, hql);
		Session session = this.getsession();
		List<Subject> list = session.createQuery(hql).list();
		return list;
	}
	
	public String getHql(Map map,String hql){   //  固收类  模糊查询
		String qname = (String)map.get("qname");
		String wname = (String)map.get("wname");
		String ename = (String)map.get("ename");
		
		if (qname != null && !qname.equals("")) {
			hql += " and name like '%"+qname+"%'";
		}
		if (wname != null && !wname.equals("")) {
			hql += " and status ="+wname;
		}
		if (ename != null && !ename.equals("")) {
			hql += " and type = '"+ename+"'";
		}
		return hql;
	}
	
	//查看投资
	public List<Subject_purchase_record> listrecord(int id){
		String hql = "from Subject_purchase_record where subject_id =  "+id;
		Session session = this.getsession();
		List<Subject_purchase_record> list = session.createQuery(hql).list();
		return list;
	}
	
	//查询一行数据
	public Subject getsubjectid(int id){
		Session session = this.getsession();
		Subject subject = (Subject)session.get(Subject.class, id);
		return subject;
	}
	
	//修改   固收类
	public void updatesubject(Subject subject){
		Session session = this.getsession();
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str = sim.format(new Date());
		subject.setUpdate_date(str);
		subject.setRaise_end(str);
		session.update(subject);
	}
	
	//添加   固收类
	public void savesubject(Subject subject){
		Session session = this.getsession();
		SimpleDateFormat sim = new SimpleDateFormat("yyyyMMddHHmmssssss");
		SimpleDateFormat sim2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str = sim.format(new Date());
		String str2 = sim2.format(new Date());
		subject.setSerial_number("YJ"+str);
		subject.setCreate_date(str2);
		subject.setUpdate_date(str2);
		subject.setRaise_start(str2);
		subject.setRaise_end(str2);
		session.save(subject);
	}
	
	//新增时候的文件上传
	public void save_subject_file(Subject_file subject_file){
		Session session = this.getsession();
		SimpleDateFormat sim1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sim2 = new SimpleDateFormat("yyyyMMdd");
		subject_file.setCreate_date(sim1.format(new Date()));
		subject_file.setUpdate_date(sim1.format(new Date()));
		subject_file.setPath("upload/"+sim2.format(new Date()));
		session.save(subject_file);
	}
}
