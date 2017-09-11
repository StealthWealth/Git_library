package com.web.font.controller;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.font.bean.Finance_product_funds;
import com.web.font.bean.Users;
import com.web.font.service.FontService;

@Controller
@RequestMapping("/users")
public class FontController {
	
	@Autowired
	private FontService fontService;

	public static Subject login(String configFile,String userName,String password){
		// 读取配置文件,初始化SecurityManager工厂
		Factory<SecurityManager> factory=new IniSecurityManagerFactory("classpath:jdbc_realm.ini"); 
		// 获取SecurityManager实例
		SecurityManager securityManager=factory.getInstance();
		// 把SecurityManager实例绑定到SecurityUtils
		SecurityUtils.setSecurityManager(securityManager);
		// 得到当前执行的用户
		Subject currentUser=SecurityUtils.getSubject();
		// 创建token令牌,用户名密码形式
		UsernamePasswordToken token=new UsernamePasswordToken("admin", "123456");
	/*	try {
			// 身份认证(登录)
			currentUser.login(token);
			System.out.println("身份认证成功!");
		} catch (AuthenticationException e) {
			e.printStackTrace();
			System.out.println("身份认证失败!");
		}
		*/
		
		return currentUser; 
	}
	
	
	//注册
	@RequestMapping("/signIn")
	public String signIn(Users users){
		System.out.println(users.getUser_name());
		
		return "homePage";
	}
	
	
	//登录
	@RequestMapping("/signUp")
	public String signUp(Users users) {
		System.out.println(users.getUser_name());
		System.out.println(users.getPassword());
		return "homePage";
	}
	
	//查询股票信息
	@RequestMapping("/showStock")
	public String showStock(Model model) {
		List<Finance_product_funds> list=fontService.showStock();
		model.addAttribute("showStock", list);
		System.out.println("controller");
		return "homePage";
	}
	
	
 
	
}
