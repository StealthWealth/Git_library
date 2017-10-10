package com.web.member_withdraw_record_Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.member_withdraw_record_Bean.Member_withdraw_record;
import com.web.member_withdraw_record_Service.Member_withdraw_recordService;

@Controller
public class Member_withdraw_recordController {

	@Autowired
	private Member_withdraw_recordService member_withdrawService;

	
	@RequestMapping("/listMember_withdraw")
	public String listMember_withdraw(Model model,String MH_member_name,String MH_mobile_Phone,String MH_bank_card,String MH_status,String MH_QDate,String MH_HDate){
		Map map = new HashMap<>();
		
		if(MH_status!=null && MH_status.equals("-1")){
			MH_status=null;
		}
		
		map.put("MH_member_name",MH_member_name);
		map.put("MH_mobile_Phone", MH_mobile_Phone);
		map.put("MH_bank_card",MH_bank_card);
		map.put("MH_status", MH_status);
		map.put("MH_QDate", MH_QDate);
		map.put("MH_HDate", MH_HDate);
		
		List<Member_withdraw_record> member_withdraw = member_withdrawService.listMember_withdraw(map);
		
		if(MH_status==null){
			MH_status="-1";
		}
		for (Member_withdraw_record member_withdraw_record : member_withdraw) {
			if(member_withdraw_record.getMember().getIdentity()!=null){
				member_withdraw_record.getMember().setIdentity(member_withdraw_record.getMember().getIdentity().replaceAll("(\\d{4})\\d{10}(\\d{4})","$1****$2"));
			}
			
		}
		
		model.addAttribute("member_withdraw", member_withdraw);
		model.addAttribute("MH_member_name", MH_member_name);
		model.addAttribute("MH_mobile_Phone", MH_mobile_Phone);
		model.addAttribute("MH_bank_card", MH_bank_card);
		model.addAttribute("MH_status", MH_status);
		model.addAttribute("MH_QDate",MH_QDate);
		model.addAttribute("MH_HDate", MH_HDate);
		
		return "vip_Withdrawals";
	}
	
	
	//…Û∫À
	@RequestMapping("/update_with/{id}")
	public String update_with(@PathVariable("id")int id){
		member_withdrawService.update_with(id);
		return "redirect:/listMember_withdraw";
	}
}
