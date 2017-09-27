package com.web.users_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.font_bean.Users;
import com.web.users_service.UsersService;

@Controller
public class UsersController {

	@Autowired
	private UsersService usersService;

	
	//进入登陆页面
	@RequestMapping("/HTLogin")
	public String HTLogin(){
		return "HTLogin";
	}
	
	//登陆
	@RequestMapping("/login")
	public String getUsers(String user_name,String password,String mobile_Phone,Model model){
		Users users = usersService.getUsers(user_name, password, mobile_Phone);
		if(users!=null){
			
			if(users.getDel_flag()==1){
				model.addAttribute("login", "2"); //账号已锁定
			}
			if(users.getDel_flag()==0){
				model.addAttribute("login", "1"); //账号正常
			}
			
			
		}else{
			model.addAttribute("login","0");
		}
		model.addAttribute("user_name",user_name);
		model.addAttribute("password", password);
		model.addAttribute("mobile_Phone", mobile_Phone);
		return "HTLogin";
	}
	
	//登陆成功
	@RequestMapping("/addLogin")
	public String addLogin(){
		return "index"; 
	}
}
