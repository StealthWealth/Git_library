package com.web.finance_product_controller;

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

@Controller(value="funds")
@RequestMapping("/funds")
public class FundsController {

	@Autowired
	private FundsService fundsService;
	
	@RequestMapping("/listfunds")
	public String listfunds(Model model,String qname,String wname,String ename){
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
	public String listsubscribe(@PathVariable("id")int id,Model model){
		List<Finance_product_subscribe> listsubscribe = this.fundsService.listsubscribe(id);
		model.addAttribute("listsubscribe", listsubscribe);
		return "finance_subscribe";
	}
	
	@RequestMapping("/updatesubscribe/${id}")
	public String updatesubscribe(Finance_product_subscribe subscribe){
		subscribe.setStatus(3);
		this.fundsService.savesubscribe(subscribe);
		return "redirect:/funds/listsubscribe";
	}
}
