package com.web.award_records_Service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.award_records_Bean.Award_Bean;
import com.web.award_records_Bean.Award_records;
import com.web.award_records_Dao.Award_recordsDao;
import com.web.vip_auditing_Bean.Member;

@Service
@Transactional
public class Award_recordsService {

	@Autowired
	private Award_recordsDao award_recordsDao;

	
	//��ѯ����
	public List<Award_Bean> listAward_records(Map map){
		return award_recordsDao.listAward_records(map);
	}
	
	//������¼
	public List<Award_records> getAwardList(String byinvitingid){
		return award_recordsDao.getAwardList(byinvitingid);
	}
	
	//������¼��������
		public Member getByinvitingName(int id){
			return award_recordsDao.getByinvitingName(id);
		}
	
		//������������
		public List<Member> listMember_Name(){
			return award_recordsDao.listMember_Name();
		}

}
