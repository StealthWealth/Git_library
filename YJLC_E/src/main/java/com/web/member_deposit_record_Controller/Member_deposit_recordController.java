package com.web.member_deposit_record_Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.member_deposit_record_Bean.Member_deposit_record;
import com.web.member_deposit_record_Service.Member_deposit_recordService;

@Controller
public class Member_deposit_recordController {

	@Autowired
	private Member_deposit_recordService member_deposit_recordService;

	@RequestMapping("/listMember_deposit_record")
	public String listMember_deposit_record(Model model,String MH_serial_number,String MH_mobile_Phone,String MH_status,String MH_pay_channel_order_no,String MH_QDate,String MH_HDate){
		if( MH_status!=null && MH_status.equals("2")){
			MH_status=null;
		}
		
		Map map = new HashMap<>();
		map.put("MH_serial_number", MH_serial_number);
		map.put("MH_mobile_Phone", MH_mobile_Phone);
		map.put("MH_status", MH_status);
		map.put("MH_pay_channel_order_no", MH_pay_channel_order_no);
		map.put("MH_QDate", MH_QDate);
		map.put("MH_HDate", MH_HDate);
		List<Member_deposit_record> member_deposit_record = member_deposit_recordService.listMember_deposit_record(map);
		model.addAttribute("member_deposit_record", member_deposit_record);
		
		if(MH_status==null){
			MH_status="2";
		}
		
		model.addAttribute("MH_serial_number", MH_serial_number);
		model.addAttribute("MH_mobile_Phone", MH_mobile_Phone);
		model.addAttribute("MH_status", MH_status);
		model.addAttribute("MH_pay_channel_order_no", MH_pay_channel_order_no);
		model.addAttribute("MH_QDate", MH_QDate);
		model.addAttribute("MH_HDate", MH_HDate);
		return "vip_Recharge";
	}
}
