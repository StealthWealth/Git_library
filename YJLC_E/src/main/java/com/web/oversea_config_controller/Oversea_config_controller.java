package com.web.oversea_config_controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.oversea_config_bean.Oversea_config;
import com.web.oversea_config_bean.Oversea_config_subscribe;
import com.web.oversea_config_service.Oversea_config_service;

@Controller
@RequestMapping("/config")
public class Oversea_config_controller {

	@Autowired
	private Oversea_config_service configservice;
	
	@RequestMapping("/listconfig")
	public String listconfig(Model model){   //查询海外配置信息
		List<Oversea_config> listconfig = this.configservice.listconfig();
		model.addAttribute("listconfig", listconfig);
		return "oversea_config";
	}
	
	@RequestMapping("/configadd")
	public String configadd(){   //跳转到添加jsp
		return "oversea_config_add";
	}
	
	@RequestMapping("/saveconfig")
	public String saveconfig(Oversea_config config){   //保存信息
		this.configservice.saveconfig(config);
		return "redirect:/config/listconfig";
	}
	
	@RequestMapping("/editconfig/{id}")
	public String configedit(@PathVariable("id")int id,Model model){   //  根据ID查询数据进行编辑
		Oversea_config oversea_config = this.configservice.getconfigid(id);
		model.addAttribute("oversea_config", oversea_config);
		return "oversea_config_edit";
	}
	
	@RequestMapping("/updateconfig")
	public String updateconfig(Oversea_config oversea_config){  // 修改海外配置信息
		this.configservice.editconfig(oversea_config);
		return "redirect:/config/listconfig";
	}
	
	@RequestMapping("/listsubscribe/{id}")
	public String listsubscribe(@PathVariable("id")int id,Model model){  //查询预约记录
		List<Oversea_config_subscribe> listsubscribe = this.configservice.listsubscribe(id);
		model.addAttribute("listsubscribe", listsubscribe);
		return "oversea_subscribe";
	}
}
