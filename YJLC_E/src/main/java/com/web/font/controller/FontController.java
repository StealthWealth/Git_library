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
		// ��ȡ�����ļ�,��ʼ��SecurityManager����
		Factory<SecurityManager> factory=new IniSecurityManagerFactory("classpath:jdbc_realm.ini"); 
		// ��ȡSecurityManagerʵ��
		SecurityManager securityManager=factory.getInstance();
		// ��SecurityManagerʵ���󶨵�SecurityUtils
		SecurityUtils.setSecurityManager(securityManager);
		// �õ���ǰִ�е��û�
		Subject currentUser=SecurityUtils.getSubject();
		// ����token����,�û���������ʽ
		UsernamePasswordToken token=new UsernamePasswordToken("admin", "123456");
	/*	try {
			// �����֤(��¼)
			currentUser.login(token);
			System.out.println("�����֤�ɹ�!");
		} catch (AuthenticationException e) {
			e.printStackTrace();
			System.out.println("�����֤ʧ��!");
		}
		*/
		
		return currentUser; 
	}
	
	
	//ע��
	@RequestMapping("/signIn")
	public String signIn(Users users){
		System.out.println(users.getUser_name());
		
		return "homePage";
	}
	
	
	//��¼
	@RequestMapping("/signUp")
	public String signUp(Users users) {
		System.out.println(users.getUser_name());
		System.out.println(users.getPassword());
		return "homePage";
	}
	
	//��ѯ��Ʊ��Ϣ
	@RequestMapping("/showStock")
	public String showStock(Model model) {
		List<Finance_product_funds> list=fontService.showStock();
		model.addAttribute("showStock", list);
		System.out.println("controller");
		return "homePage";
	}
	
	
 
	
}
