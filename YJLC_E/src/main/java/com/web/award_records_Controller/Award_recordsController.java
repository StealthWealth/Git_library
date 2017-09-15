package com.web.award_records_Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.award_records_Bean.Award_member_account;
import com.web.award_records_Bean.Award_records;
import com.web.award_records_Service.Award_recordsService;
import com.web.vip_auditing_Bean.Member;

@Controller
public class Award_recordsController {

	@Autowired
	private Award_recordsService award_recordsService;

	
	//查询所有
	@RequestMapping("/listAward_records")
	public String listAward_records(Model model,String MH_member_name,String MH_mobile_Phone,String MH_invitationCode,String MH_invitedCode,String MH_isAward_Zhu,String MH_isAward_Tou){
		
		if(MH_isAward_Zhu!=null && MH_isAward_Zhu.equals("-1")){
			MH_isAward_Zhu=null;
		}
		if(MH_isAward_Tou!=null && MH_isAward_Tou.equals("-1")){
			MH_isAward_Tou=null;
		}
		Map map = new HashMap<>();
		map.put("MH_member_name", MH_member_name);
		map.put("MH_mobile_Phone", MH_mobile_Phone);
		map.put("MH_invitationCode", MH_invitationCode);
		map.put("MH_invitedCode", MH_invitedCode);
		map.put("MH_isAward_Zhu", MH_isAward_Zhu);
		map.put("MH_isAward_Tou", MH_isAward_Tou);
		List<Award_records> award_records = award_recordsService.listAward_records(map);
		List<Award_member_account> award_memner = award_recordsService.getAward_member();
		model.addAttribute("award_memner", award_memner);
		model.addAttribute("award_records", award_records);
		
		if(MH_isAward_Zhu==null){
			MH_isAward_Zhu="-1";
		}
		if(MH_isAward_Tou==null){
			MH_isAward_Tou="-1";
		}
		
		model.addAttribute("MH_member_name", MH_member_name);
		model.addAttribute("MH_mobile_Phone", MH_mobile_Phone);
		model.addAttribute("MH_invitationCode", MH_invitationCode);
		model.addAttribute("MH_invitedCode", MH_invitedCode);
		model.addAttribute("MH_isAward_Zhu", MH_isAward_Zhu);
		model.addAttribute("MH_isAward_Tou", MH_isAward_Tou);
		return "vip_Invitation";
	}
	
	//奖励记录
	@RequestMapping("/reward_record/{id}/{byinvitingid}")
	public String reward_record(@PathVariable("id")int id,@PathVariable("byinvitingid")int byinvitingid,Model model){
		Award_records award = award_recordsService.getAward(id);
		Member member_ByinvitingName = award_recordsService.getByinvitingName(byinvitingid);
		model.addAttribute("award_inviting", award);
		model.addAttribute("member_ByinvitingName", member_ByinvitingName);
		return "reward_record";
	}
}
