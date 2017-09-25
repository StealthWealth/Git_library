package com.web.subject_Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.subject_Bean.Subject;
import com.web.subject_Bean.Sum_Subject;
import com.web.subject_Dao.SubjectDao;
import com.web.subject_purchase_record_Bean.Subject_purchase_record;
import com.web.sublect_bbin_purchase_record_Bean.Subject_bbin_purchase_record;

@Service
@Transactional
public class SubjectService {

	@Autowired
	private SubjectDao subjectDao;

	
	//查询所有
	public List<Subject> listSubject(){
		return subjectDao.listSubject();
	}
	
	//复习列表
	public List<Subject_purchase_record> listSubject_Purchase_Record(int id){
		return subjectDao.listSubject_Purchase_Record(id);
	}
	
	//付息列表还款
	public void updateSubject_purchase(int id){
		subjectDao.updateSubject_Purchase(id);
	}
	
	//已投金额
	public List<Sum_Subject> listSum_subject(){
		return subjectDao.listSum_subject();
	}
	
	//体验金列表
	public List<Subject_bbin_purchase_record> listSubject_bbin(int id){
		return subjectDao.listSubject_bbin(id);
	}
	//修改体验金还款
	public void updateSubject_bbin(int id){
		subjectDao.updateSubject_bbin(id);
	}
}
