package com.web.Member_bankcards_Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.Member_bankcards_Service.Member_bankcardsService;
import com.web.member_bankcards_Bean.Member_bankcards;

@Controller
public class Member_bankcardsController {

	@Autowired
	private Member_bankcardsService member_bankcardsService;
	
	@RequestMapping("/listMember_Bankcards")
	public String listMember_bankcards(Model model,String MH_mobile_Phone,String MH_member_name,String MH_card_no,String MH_QDate,String MH_HDate){
		Map map = new HashMap<>();
		map.put("MH_mobile_Phone", MH_mobile_Phone);
		map.put("MH_member_name", MH_member_name);
		map.put("MH_card_no", MH_card_no);
		map.put("MH_QDate", MH_QDate);
		map.put("MH_HDate", MH_HDate);
		List<Member_bankcards> member_bankcards = member_bankcardsService.listMember_bankcards(map);
		model.addAttribute("member_bankcards", member_bankcards);
		model.addAttribute("MH_mobile_Phone", MH_mobile_Phone);
		model.addAttribute("MH_member_name", MH_member_name);
		model.addAttribute("MH_card_no", MH_card_no);
		model.addAttribute("MH_QDate", MH_QDate);
		model.addAttribute("MH_HDate", MH_HDate);
		return "vip_Bangker";
	}
	
	
	//ÐÞ¸ÄÊÇ·ñ½â°ó
	@RequestMapping("/updateDelflag/{id}")
	public String updateDelflag(@PathVariable("id")int id){
		member_bankcardsService.updateDelflag(id);
		return "redirect:/listMember_Bankcards";
	}
}
