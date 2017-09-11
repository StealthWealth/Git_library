package com.web.Member_bankcards_Service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.Member_bankcards_Dao.Member_bankcardsDao;
import com.web.member_bankcards_Bean.Member_bankcards;
import com.web.vip_auditing_Bean.Member;

@Service
@Transactional
public class Member_bankcardsService {

	@Autowired
	private Member_bankcardsDao member_bankacrdsDao;
	
	//查询所有
	public List<Member_bankcards> listMember_bankcards(Map map){
		return member_bankacrdsDao.listMember_bankcards(map);
	}
	
	//解绑
	public void updateDelflag(int id){
		Member_bankcards member_bankcards = member_bankacrdsDao.getMember_bankcards(id);
		member_bankcards.setDelflag(2);
		member_bankacrdsDao.updateDelflag(member_bankcards);
	}
}
