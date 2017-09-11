package com.web.member_deposit_record_Service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.member_deposit_record_Bean.Member_deposit_record;
import com.web.member_deposit_record_Dao.Member_deposit_recordDao;

@Service
@Transactional
public class Member_deposit_recordService {

	@Autowired
	private Member_deposit_recordDao member_deposit_recordDao;

	public List<Member_deposit_record> listMember_deposit_record(Map map){
		return member_deposit_recordDao.listMember_deposit_record(map);
	}
}
