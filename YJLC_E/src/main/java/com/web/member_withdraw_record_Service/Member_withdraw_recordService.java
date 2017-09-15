package com.web.member_withdraw_record_Service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.member_withdraw_record_Bean.Member_withdraw_record;
import com.web.member_withdraw_record_Dao.Member_withdraw_recordDao;

@Service
@Transactional
public class Member_withdraw_recordService {

	@Autowired
	private Member_withdraw_recordDao member_withdraw_recordDao;

	
	//≤È—ØÀ˘”–
	public List<Member_withdraw_record> listMember_withdraw(Map map){
		return member_withdraw_recordDao.listMember_withdraw(map);
	}
	
	//…Û∫À
	public void update_with(int id){
		member_withdraw_recordDao.updateMember_with(id);
	}
}
