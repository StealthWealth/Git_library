package com.web.font_controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.finance_product_bean.Finance_product_funds;
import com.web.font_bean.News;
import com.web.font_bean.Push_notice;
import com.web.font_bean.User_log;
import com.web.font_bean.User_login_token;
import com.web.font_bean.Users;
import com.web.font_service.FontService;
import com.web.vip_auditing_Bean.Member;

@Controller(value="users")
@RequestMapping("/users")
public class FontController {
	
	@Autowired
	private FontService fontService;
	private DateFormat formatter;
	private DateFormat dateformatter;

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
		UsernamePasswordToken token=new UsernamePasswordToken(userName, password);
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
	
	
	
	//MD5����
	public static String MD5(String str,String salt) {
		
		return new Md5Hash(str,salt).toString();
	}
	
	
	
	//ǰ̨ע��
	@RequestMapping("/MemberSignIn")
	public String MemberSignIn(Member member) {
		member.setStatus("0");//�˺�״̬
		member.setDel_flag("0");//ɾ�����
		member.setCreate_date(Calendar.getInstance().getTime());//����ʱ��
		fontService.addMemberSignIn(member);
		return "redirect:/users/showStock";
	}
	
	
	//ǰ̨��¼
	@RequestMapping("/MemberSignUp")
	public String MemberSignUpp(Member member,Model model) {
		Member member2=fontService.getMemberSignUp(member);
		if (member2 != null) {
			model.addAttribute("member", member2);
			System.out.println(member2.getPassword()+"  "+member2.getName());
		}else {
			model.addAttribute("dlyz", "�˺Ż��������");
			System.out.println("aaaa");
		}
		return "redirect:/users/showStock";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	

	
	//��ѯ��Ʊ��Ϣ       ��ѯ������Ϣ
	@RequestMapping("/showStock")
	public String showStock(Model model) {
		List<Finance_product_funds> list=fontService.listStock();//��Ʋ�Ʒ��Ϣ
		List<Push_notice> listPush=fontService.listPush();//������Ϣ
		model.addAttribute("showStock", list);
		model.addAttribute("listPush", listPush);
		System.out.println(new SimpleDateFormat("yyyy-mm-dd HH:mm:ss").format(Calendar.getInstance().getTime()));//��ʾ��ǰʱ��
		System.out.println(Calendar.getInstance().getTime());
		return "homePage";
	}
	
	
	
	//��ת����������ҳ��
	@RequestMapping("/pressCenter")
	public String pressCenter(Model model) {
		List<News> listNews=fontService.listNews();
		List<Push_notice> listPush=fontService.listPush();
		model.addAttribute("listNews", listNews);
		model.addAttribute("listpush", listPush);
		return "press_centre";
	}
	
	//��ת��ӯ+��ѧԺ
	@RequestMapping("/YJcommercial_college")
	public String YJcommercial_college() {
		return "YJcommercial_college";
	}
	
	//��ת����������ҳ��
	@RequestMapping("/download_center")
	public String download_center() {
		return "download_center";
	}
	
	//��ת��Ͷ������
	@RequestMapping("/study_center")
	public String study_center() {
		return "study_center";
	}
	
	//��ת����Ʒ����-���������
	@RequestMapping("/product")
	public String product_Solid() {
		
		return "product_center";
	}
	
	//��Ʒ����-���������-����������ת�Ĺ���ҳ��
	@RequestMapping("/productbuy")
	public String product_buy() {
		
		return "product_buy";
	}
	
	
	//�˻�����ҳ��
	@RequestMapping("/sys_Account")
	public String sys_Account(Model model) {
		List< Users> list=fontService.listUsers();
		model.addAttribute("listUsers",list);
		return "system_Account";
	}
	
	@RequestMapping("/sin")
	public String sin() {
		return "Users_signIn";
	}
	
	
	//��̨ע��
	@RequestMapping("/signIn")
	public String signIn(Users users,User_log user_log,User_login_token user_login_token) throws ParseException, UnknownHostException {
		users.setCreate_date(Calendar.getInstance().getTime());//���û�������һ������ʱ��
		user_log.setCreate_date(Calendar.getInstance().getTime());//����¼��־��һ������ʱ��
		String ip=InetAddress.getLocalHost().toString();//��ñ���ip������
		System.out.println("������������ƺ�ip��ַ:"+ip);
		String cip=ip.substring(ip.lastIndexOf("/")+1);// ��ȡ�ַ���ֻ����ip��ַ   �ַ���.substring(�ַ���.lastIndexOf("\\")+1) 
		user_log.setLogin_ip(cip);//���û���¼����ip��ַ
		users.setStatus(0);//0��ʾ����״̬   1����  2ɾ��״̬
		users.setSalt("1");
		fontService.addSignUp(users, user_log, user_login_token);
		return "redirect:/users/sys_Account";
	}
	
	
	//��̨��¼
	@RequestMapping("/signUp")
	public String signUp(Users users,User_log ul,Model model) throws UnknownHostException {
		ul.setUpdate_date(Calendar.getInstance().getTime()); //��¼ʱ��
		String ip=InetAddress.getLocalHost().toString();//��ñ���ip�͵�������
		String cip=ip.substring(ip.lastIndexOf("/")+1);//��ȡ ֻҪip
		ul.setLogin_ip(cip);//��ֵ��ʵ����
		Users users2=fontService.getUsers(users);
		if (users2 != null) {
			model.addAttribute("SignInUsers", users2);
		}else {
			model.addAttribute("mmcw", "�˺Ż��������");
		}
		
		return "redirect:/users/showStock";
	}
	
	
	
	//��̨׼���˻��޸�
	@RequestMapping("updateusers")
	public String updateusers(int id,Model model) {
		Users users=fontService.getByIdusers(id);
		model.addAttribute("users", users);
		return "UpdateUsers";
	}
	
	//��̨�˻��޸�
	@RequestMapping("/updateu")
	public String uppdateu(Users users) {
		System.out.println(users.getMobile_Phone());
		System.out.println(users.getPassword());
		users.setUpdate_date(Calendar.getInstance().getTime());//���û�������һ���޸�ʱ��
		users.setCreate_date(Calendar.getInstance().getTime());//���û�������һ������ʱ��
		fontService.updateusers(users);
		return "redirect:/users/sys_Account";
	}
	
	
	//��̨�˻�����ɾ��
	@RequestMapping("/deleteus")
	public String deleteusers(Users users) {
		users.setUpdate_date(Calendar.getInstance().getTime());//���û�������һ���޸�ʱ��
		users.setStatus(2);
		fontService.deleteusers(users);
		return "redirect:/users/sys_Account";
	}
	
	
	
}
