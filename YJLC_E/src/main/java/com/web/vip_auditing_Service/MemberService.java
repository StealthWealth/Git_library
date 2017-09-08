package com.web.vip_auditing_Service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.vip_auditing_Bean.Member;
import com.web.vip_auditing_Dao.MemberDao;

@Service
@Transactional
public class MemberService {

	@Autowired
	private MemberDao auditingDao;

	
	//查询所有
	public List<Member> listAuditiongAll(Map map){
		return auditingDao.listAuditionAll(map);
	}
	
	//账号详情
	public Member getMember(int id){
		return auditingDao.getMember(id);
	}
}
