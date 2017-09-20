package com.web.award_records_Service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.award_records_Bean.Award_member_account;
import com.web.award_records_Bean.Award_records;
import com.web.award_records_Dao.Award_recordsDao;
import com.web.vip_auditing_Bean.Member;

@Service
@Transactional
public class Award_recordsService {

	@Autowired
	private Award_recordsDao award_recordsDao;

	
	//查询所有
	public List<Award_records> listAward_records(Map map){
		return award_recordsDao.listAward_records(map);
	}
	
	//奖励记录
	public Award_records getAward(int id){
		return award_recordsDao.getAward(id);
	}
	
	//被邀请人
	public Member getByinvitingName(int id){
		return award_recordsDao.getByinvitingName(id);
	}
	//投资金额
	public List<Award_member_account> getAward_member(){
		return award_recordsDao.getAward_member();
	}
}
