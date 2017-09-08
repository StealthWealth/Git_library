package com.web.vip_auditing_Controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.vip_auditing_Bean.Member;
import com.web.vip_auditing_Service.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;

	//查询所有
	@RequestMapping("/listAuditingAll")
	public String listAuditingAll(Model model,String MH_name,String MH_mobile_Phone,String MH_member_name,String MH_invitationCode,String MH_QDate,String MH_HDate){
		Map map = new HashMap<>();
		map.put("MH_name", MH_name);
		map.put("MH_mobile_Phone", MH_mobile_Phone);
		map.put("MH_member_name", MH_member_name);
		map.put("MH_invitationCode", MH_invitationCode);
		map.put("MH_QDate", MH_QDate);
		map.put("MH_HDate", MH_HDate);
		List<Member> listAuditing = memberService.listAuditiongAll(map);
		model.addAttribute("listAuditing", listAuditing);
		
		//将值存储 在页面显示
		model.addAttribute("MH_name", MH_name);
		model.addAttribute("MH_member_name",MH_member_name);
		model.addAttribute("MH_mobile_Phone", MH_mobile_Phone);
		model.addAttribute("MH_invitationCode", MH_invitationCode);
		model.addAttribute("MH_QDate", MH_QDate);
		model.addAttribute("MH_HDate", MH_HDate);
		return "vip_Auditing";
	}
	
	//账号详情
	@RequestMapping("/getMember/{id}")
	public String getMember(@PathVariable("id")int id,Model model){
		Member member = memberService.getMember(id);
		model.addAttribute("member", member);
		return "vip_Auditing_details";
	}
	
}
