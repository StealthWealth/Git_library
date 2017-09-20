package com.web.finance_product_controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.finance_product_bean.Finance_product_funds;
import com.web.finance_product_bean.Finance_product_subscribe;
import com.web.finance_product_service.FundsService;
import com.web.vip_auditing_Bean.Member;

@Controller(value="funds")
@RequestMapping("/funds")
public class FundsController {

	@Autowired
	private FundsService fundsService;
	
	@RequestMapping("/listfunds")
	public String listfunds(Model model,String qname,String wname,String ename){  //��ѯ˽ļ/��Ȩ����Ϣ
		Map map = new HashMap<>();
		map.put("qname", qname);
		map.put("wname", wname);
		map.put("ename", ename);
		List<Finance_product_funds> listfunds = this.fundsService.listfunds(map);
		model.addAttribute("listfunds", listfunds);
		model.addAttribute("qname", qname);
		model.addAttribute("wname", wname);
		model.addAttribute("ename", ename);
		
		return "finance_funds";
	}
	
	@RequestMapping("/listsubscribe/{id}")
	public String listsubscribe(@PathVariable("id")int id,Model model){   //��ѯǩ��״̬
		List<Finance_product_subscribe> listsubscribe = this.fundsService.listsubscribe(id);
		model.addAttribute("listsubscribe", listsubscribe);
		return "finance_subscribe";
	}
	

	@RequestMapping("/fundsadd")
	public String fundsadd(){  //��ת����� JSP 
		return "finance_funds_add";
	}
	
	@RequestMapping("/savefunds")
	public String savefunds(Finance_product_funds funds){  //���� ˽ļ/��Ȩ����Ϣ
		this.fundsService.fundssave(funds);
		return "redirect:/funds/listfunds";
	}
	
	@RequestMapping("/editfunds/{id}")
	public String editfunds(@PathVariable("id")int id,Model model){  //  ˽ļ /  ��Ȩ��  ����ID��ѯ��Ϣ���б༭
		Finance_product_funds funds = this.fundsService.getfundsid(id);
		model.addAttribute("funds", funds);
		return "finance_funds_edit";
	}
	
	@RequestMapping("/updatefunds")
	public String updatefunds(Finance_product_funds finance_product_funds){   //�޸�˽ļ��Ϣ
		this.fundsService.updatefunds(finance_product_funds);
		return "redirect:/funds/listfunds";
	}
	
	@RequestMapping("/updatesubscribe/{id}/{product_id}")
	public String updatesubscribe(@PathVariable("id")int did,@PathVariable("product_id")int pid){   // ǩ��ʧ��
		this.fundsService.updatesubscribe(did);
		return "redirect:/funds/listsubscribe/{product_id}";
	}
	
	
	//��ѯǩ��
	@RequestMapping("subscribeadd/{id}/{period}")
	public String subscribeadd(@PathVariable("id")int id,Model model,@PathVariable("period")int period){
		System.err.println("---------"+period);
		Finance_product_subscribe subscribe = this.fundsService.getsubscribeid(id);
		model.addAttribute("subscribe", subscribe);
		Date date = new Date();
		date.setDate(date.getDate()+period);
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		model.addAttribute("str", sim.format(new Date()));
		model.addAttribute("endtime", sim.format(date));
		return "finance_subscribe_add";
	}
	
	
	//ǩ���ͬ
	@RequestMapping("/update")
	public String savesubscribe(Finance_product_subscribe subscribe,int did,int member_id){
		System.out.println("-----------------did:"+did);
		Finance_product_funds funds = this.fundsService.getfundsid(did);
		Member member = this.fundsService.getmemberid(member_id);
		subscribe.setFunds(funds);
		subscribe.setMember(member);
		this.fundsService.updatesubscribe(subscribe);
		return "redirect:/funds/listsubscribe/"+did;
	}
}
