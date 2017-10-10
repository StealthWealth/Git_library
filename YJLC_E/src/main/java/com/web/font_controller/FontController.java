package com.web.font_controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.util.Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.finance_product_bean.Finance_product_funds;
import com.web.font_bean.Push_notice;
import com.web.font_bean.User_log;
import com.web.font_bean.User_login_token;
import com.web.font_bean.Users;
import com.web.font_service.FontService;
import com.web.member_account_Bean.Member_account;
import com.web.news_Bean.News;
import com.web.subject_Bean.Subject;
import com.web.subject_purchase_record_Bean.Subject_purchase_record;
import com.web.sublect_bbin_purchase_record_Bean.Subject_bbin_purchase_record;
import com.web.news_Bean.News;
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
		Subject currentUser=(Subject) SecurityUtils.getSubject();
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
	public String MemberSignIn(Member member,Member_account ma) {
		member.setStatus("0");//账号状态
		member.setDel_flag("0");//删除标记
		member.setCreate_date(Calendar.getInstance().getTime());//创建时间
		ma.setBbin_amount(1000.00);//默认给每个注册的用户发放1000元的奖励金
		ma.setCreate_date(member.getCreate_date());
		fontService.addMemberSignIn(member,ma);
		return "redirect:/users/showStock";
	}
	
	
	//前台登录
	@RequestMapping("/MemberSignUp")
	public String MemberSignUpp(Member member,Model model,HttpSession session) {
		boolean fal=fontService.getMemberSignUp(member);
		Member member2=null;
		if (fal) {
			 member2=fontService.getMemberCZ(member);
			System.err.println("name="+member2.getName()+"  password="+member2.getPassword());
			session.setAttribute("member", member2);
			List<Finance_product_funds> list=fontService.listStock();//理财产品信息
			List<Push_notice> listPush=fontService.listPush();//公告信息
			model.addAttribute("showStock", list);
			model.addAttribute("listPush", listPush);
		}else {
			member2=null;
			model.addAttribute("dlyz", "账号或密码错误");
			System.out.println("账号或密码错误");
			List<Finance_product_funds> list=fontService.listStock();//理财产品信息
			List<Push_notice> listPush=fontService.listPush();//公告信息
			model.addAttribute("showStock", list);
			model.addAttribute("listPush", listPush);
			model.addAttribute("member", null);
		}
		return "homePage";
	}
	
	//前台退出
	@RequestMapping("/tuile")
	public String TuiLe(HttpSession session) {
		session.setAttribute("member",null);
		return "redirect:/users/showStock";
	}
	
	
	
	//跳转到支付
	@RequestMapping("/alipay")
	public String alipay() {
		return "alipay.index";
	}
	
	//跳转到充值页面
	@RequestMapping("/alipay_pag")
	public String alipay_pag() {
		return "alipay.trade.page.pay";
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
	public String product_Solid(HttpServletRequest request,HttpServletResponse response,Model model) {
		
		Map map=new HashMap();//新建一个map集合
		String status=request.getParameter("stutas");//标的状态
		String year_rate=request.getParameter("year_rate");//年化收益
		map=initMap(request, map);
		List<Subject>list=fontService.listCPZX(map);//查询所有
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
		model.addAttribute("listCPZX",list);
		return "product_center";
		
	}
	
	
	//拼接产品中心
	public Map initMap(HttpServletRequest request,Map map){
		String type=request.getParameter("type");
		String year_rate=request.getParameter("year_rate");//年化收益
		String period_start=request.getParameter("period_start");//开始期限
		String period_end=request.getParameter("period_end");//结束期限
		String status=request.getParameter("status");//标的状态
		String flag=request.getParameter("flag"); //标志
        map.put("type",type);
		map.put("year_rate",year_rate);
		map.put("period_start",period_start);
		map.put("period_end",period_end);
		map.put("status",status);
		map.put("flag",flag);
	  if(type!=null){
			request.setAttribute("type",type);
		}
		if(year_rate!=null){
			request.setAttribute("year_date",year_rate);
		}
		if(period_start!=null){
			request.setAttribute("period_start",period_start);
		}
		if(period_end!=null){
			request.setAttribute("period_end",period_end);
		}
		if(status!=null){
			request.setAttribute("status",status);
		}
		if(flag!=null){
			request.setAttribute("flag",flag);
		}
		return map;

	}
	
	
	
	
	
	//产品中心-固收类理财-点击购买后跳转的购买页面
	@RequestMapping("/productbuy")
	public String product_buy(int id,Model model,int mid,HttpSession session) {
		 Subject subject=fontService.getByIdSubject(id);
		 Member_account ma=null;
		  if (mid != 0) {
			  ma=fontService.getByidMember_account(mid);
		}
		Date s=Calendar.getInstance().getTime();
		String jxrq=new SimpleDateFormat("yyyy-MM-dd").format(s);
		
		
		
		//设置还款日期1
		Format f = new SimpleDateFormat("yyyy-MM-dd"); 
		Date today = new Date();  
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(s);
		calendar.add(Calendar.DAY_OF_MONTH, subject.getPeriod());//今天的日期加上标的周期
		Date hkrq1=calendar.getTime();//还款日期
		//设置还款日期二
		Calendar calendar2=Calendar.getInstance();
		calendar2.setTime(s);
		calendar2.add(Calendar.DAY_OF_MONTH, subject.getPeriod()+1);//今天的日期加上标的周期 加上可能会延迟的一天
		Date hkrq2=calendar2.getTime();
		
		model.addAttribute("subject", subject);
		if (mid != 0) {
			session.setAttribute("ma", ma);
		}
		model.addAttribute("jxrq", jxrq);
		model.addAttribute("hkrq1", f.format(hkrq1));
		model.addAttribute("hkrq2", f.format(hkrq2));
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
	

	//我的加法库--投资记录
	@RequestMapping("/listSPR")
	public String listSpr(int mid,Model model,HttpSession session) {
		Member member=(Member)session.getAttribute("member");
		int mmid=member.getId();
		List<Subject_purchase_record> list=fontService.listSPR(mmid);//投资记录所需内容
		Member_account account = this.fontService.getMember_account(mmid);//头像下面的那一排数字 账户金额等
		long investCount = this.fontService.getCount(mmid);//投资记录记录数
		model.addAttribute("listSpr", list);
		model.addAttribute("account", account);
		model.addAttribute("investCount", investCount);
		return "invest_record";
	}
	
	//我的加法库--体验金
	@RequestMapping("/listSBPR")
	public String listSbpr(int mid,Model model) {
		Subject_bbin_purchase_record sbpr=fontService.listSbpr(mid);
		Member_account account = this.fontService.getMember_account(mid);//头像下面的那一排数字 账户金额等
		model.addAttribute("account", account);
		model.addAttribute("sbpr", sbpr);
		return "bbin_record";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
