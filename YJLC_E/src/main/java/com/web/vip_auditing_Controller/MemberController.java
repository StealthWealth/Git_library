package com.web.vip_auditing_Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.financial_planner_Bean.Financial_planner;
import com.web.member_account_Bean.Member_account;
import com.web.member_deposit_record_Bean.Member_deposit_record;
import com.web.member_trade_record_Bean.Member_trade_record;
import com.web.member_withdraw_record_Bean.Member_withdraw_record;
import com.web.subject_purchase_record_Bean.Subject_purchase_record;
import com.web.vip_auditing_Bean.Member;
import com.web.vip_auditing_Service.MemberService;

@Controller(value="MemberController")
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
		Member member = memberService.getMember(id); //用户基本信息
		Member_account member_account = memberService.getMember_account(id); //账号账户详情
		Financial_planner finan = memberService.getFinancial_planner(id); //理财师详情
		List<Subject_purchase_record> member_subject = memberService.listSubject_purchase_record(id); //投资详情
		List<Member_withdraw_record> member_withdraw = memberService.listMember_withdraw(id); //提现详情
		List<Member_deposit_record> member_deposit = memberService.listMember_deposit(id); //充值记录
		List<Member_trade_record> member_trade = memberService.listMember_trade_record(id); //交易详情
		model.addAttribute("member_trade", member_trade);
		model.addAttribute("member_deposit", member_deposit);
		model.addAttribute("member_withdraw", member_withdraw);
		model.addAttribute("member_subject", member_subject);
		model.addAttribute("member", member); 
		model.addAttribute("member_account", member_account);
		model.addAttribute("finan", finan);
		return "vip_Auditing_details";
	}
	
	//  查询个人充值记录
	@RequestMapping("/chongzhijilu")
	public String chongzhijilu(HttpSession session,Model model){
		int id = ((Member)session.getAttribute("member")).getId();
		System.out.println("------------++++++++++"+id);
		List<Member_deposit_record> chongzhi = this.memberService.listMember_deposit(id);
		Member_account account = this.memberService.getMember_account(id);
		session.setAttribute("chongzhi", chongzhi);
		model.addAttribute("account", account);
		return "chongzhijilu";
	}
	
	//  查询个人提现记录
	@RequestMapping("/tikuanjilu")
	public String tixianjilu(HttpSession session,Model model){
		int id = ((Member)session.getAttribute("member")).getId();
		System.out.println("------------++++++++++"+id);
		List<Member_withdraw_record> tixian = this.memberService.listMember_withdraw(id);
		Member_account account = this.memberService.getMember_account(id);
		session.setAttribute("tixian", tixian);
		model.addAttribute("account", account);
		return "tikuanjilu";
	}
}
