package com.web.subject_Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.subject_Bean.Subject;
import com.web.subject_Dao.SubjectDao;
import com.web.subject_purchase_record_Bean.Subject_purchase_record;

@Service
@Transactional
public class SubjectService {

	@Autowired
	private SubjectDao subjectDao;

	
	//��ѯ����
	public List<Subject> listSubject(){
		return subjectDao.listSubject();
	}
	
	//��ϰ�б�
	public List<Subject_purchase_record> listSubject_Purchase_Record(int id){
		return subjectDao.listSubject_Purchase_Record(id);
	}
	
	//��Ϣ�б���
	public void updateSubject_purchase(int id){
		subjectDao.updateSubject_Purchase(id);
	}
}
