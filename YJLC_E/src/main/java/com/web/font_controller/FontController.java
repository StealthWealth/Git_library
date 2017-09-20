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
		// 读取配置文件,初始化SecurityManager工厂
		Factory<SecurityManager> factory=new IniSecurityManagerFactory("classpath:jdbc_realm.ini"); 
		// 获取SecurityManager实例
		SecurityManager securityManager=factory.getInstance();
		// 把SecurityManager实例绑定到SecurityUtils
		SecurityUtils.setSecurityManager(securityManager);
		// 得到当前执行的用户
		Subject currentUser=SecurityUtils.getSubject();
		// 创建token令牌,用户名密码形式
		UsernamePasswordToken token=new UsernamePasswordToken(userName, password);
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
	
	
	
	//MD5加密
	public static String MD5(String str,String salt) {
		
		return new Md5Hash(str,salt).toString();
	}
	
	
	
	//前台注册
	@RequestMapping("/MemberSignIn")
	public String MemberSignIn(Member member) {
		member.setStatus("0");//账号状态
		member.setDel_flag("0");//删除标记
		member.setCreate_date(Calendar.getInstance().getTime());//创建时间
		fontService.addMemberSignIn(member);
		return "redirect:/users/showStock";
	}
	
	
	//前台登录
	@RequestMapping("/MemberSignUp")
	public String MemberSignUpp(Member member,Model model) {
		Member member2=fontService.getMemberSignUp(member);
		if (member2 != null) {
			model.addAttribute("member", member2);
			System.out.println(member2.getPassword()+"  "+member2.getName());
		}else {
			model.addAttribute("dlyz", "账号或密码错误");
			System.out.println("aaaa");
		}
		return "redirect:/users/showStock";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	

	
	//查询股票信息       查询公告信息
	@RequestMapping("/showStock")
	public String showStock(Model model) {
		List<Finance_product_funds> list=fontService.listStock();//理财产品信息
		List<Push_notice> listPush=fontService.listPush();//公告信息
		model.addAttribute("showStock", list);
		model.addAttribute("listPush", listPush);
		System.out.println(new SimpleDateFormat("yyyy-mm-dd HH:mm:ss").format(Calendar.getInstance().getTime()));//显示当前时间
		System.out.println(Calendar.getInstance().getTime());
		return "homePage";
	}
	
	
	
	//跳转到新闻中心页面
	@RequestMapping("/pressCenter")
	public String pressCenter(Model model) {
		List<News> listNews=fontService.listNews();
		List<Push_notice> listPush=fontService.listPush();
		model.addAttribute("listNews", listNews);
		model.addAttribute("listpush", listPush);
		return "press_centre";
	}
	
	//跳转到盈+商学院
	@RequestMapping("/YJcommercial_college")
	public String YJcommercial_college() {
		return "YJcommercial_college";
	}
	
	//跳转到下载中心页面
	@RequestMapping("/download_center")
	public String download_center() {
		return "download_center";
	}
	
	//跳转到投研中心
	@RequestMapping("/study_center")
	public String study_center() {
		return "study_center";
	}
	
	//跳转到产品中心-固收类理财
	@RequestMapping("/product")
	public String product_Solid() {
		
		return "product_center";
	}
	
	//产品中心-固收类理财-点击购买后跳转的购买页面
	@RequestMapping("/productbuy")
	public String product_buy() {
		
		return "product_buy";
	}
	
	
	//账户管理页面
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
	
	
	//后台注册
	@RequestMapping("/signIn")
	public String signIn(Users users,User_log user_log,User_login_token user_login_token) throws ParseException, UnknownHostException {
		users.setCreate_date(Calendar.getInstance().getTime());//给用户基本表一个创建时间
		user_log.setCreate_date(Calendar.getInstance().getTime());//给登录日志表一个创建时间
		String ip=InetAddress.getLocalHost().toString();//获得本机ip和名字
		System.out.println("本机计算机名称和ip地址:"+ip);
		String cip=ip.substring(ip.lastIndexOf("/")+1);// 截取字符串只留下ip地址   字符串.substring(字符串.lastIndexOf("\\")+1) 
		user_log.setLogin_ip(cip);//给用户登录表本机ip地址
		users.setStatus(0);//0表示正常状态   1锁定  2删除状态
		users.setSalt("1");
		fontService.addSignUp(users, user_log, user_login_token);
		return "redirect:/users/sys_Account";
	}
	
	
	//后台登录
	@RequestMapping("/signUp")
	public String signUp(Users users,User_log ul,Model model) throws UnknownHostException {
		ul.setUpdate_date(Calendar.getInstance().getTime()); //登录时间
		String ip=InetAddress.getLocalHost().toString();//获得本机ip和电脑名称
		String cip=ip.substring(ip.lastIndexOf("/")+1);//截取 只要ip
		ul.setLogin_ip(cip);//赋值给实体类
		Users users2=fontService.getUsers(users);
		if (users2 != null) {
			model.addAttribute("SignInUsers", users2);
		}else {
			model.addAttribute("mmcw", "账号或密码错误");
		}
		
		return "redirect:/users/showStock";
	}
	
	
	
	//后台准备账户修改
	@RequestMapping("updateusers")
	public String updateusers(int id,Model model) {
		Users users=fontService.getByIdusers(id);
		model.addAttribute("users", users);
		return "UpdateUsers";
	}
	
	//后台账户修改
	@RequestMapping("/updateu")
	public String uppdateu(Users users) {
		System.out.println(users.getMobile_Phone());
		System.out.println(users.getPassword());
		users.setUpdate_date(Calendar.getInstance().getTime());//给用户基本表一个修改时间
		users.setCreate_date(Calendar.getInstance().getTime());//给用户基本表一个创建时间
		fontService.updateusers(users);
		return "redirect:/users/sys_Account";
	}
	
	
	//后台账户设置删除
	@RequestMapping("/deleteus")
	public String deleteusers(Users users) {
		users.setUpdate_date(Calendar.getInstance().getTime());//给用户基本表一个修改时间
		users.setStatus(2);
		fontService.deleteusers(users);
		return "redirect:/users/sys_Account";
	}
	
	
	
}
