package com.web.products_subject_service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.bean.Subject_file;
import com.web.products_subject_dao.ProductsDao;
import com.web.subject_Bean.Subject;
import com.web.subject_purchase_record_Bean.Subject_purchase_record;

@Service
@Transactional
public class ProductsService {

	@Autowired
	private ProductsDao subjectDao;
	
	//��ѯ������
	public List<Subject> listsubject(Map map){
		return this.subjectDao.listsubject(map);
	}
	
	//�鿴Ͷ��
	public List<Subject_purchase_record> listrecord(int id){
		return this.subjectDao.listrecord(id);
	}
	
	//��ѯһ������
	public Subject getsubjectid(int id){
		return this.subjectDao.getsubjectid(id);
	}
	
	//�޸�   ������
	public void updatesubject(Subject subject){
		this.subjectDao.updatesubject(subject);
	}
	
	//���   ������
	public void savesubject(Subject subject){
		this.subjectDao.savesubject(subject);
	}
	
	//����ļ��ϴ�
	public void save_subject_file(Subject_file subject_file){
		this.subjectDao.save_subject_file(subject_file);
	}
}
