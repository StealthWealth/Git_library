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
		// ��ȡ�����ļ�,��ʼ��SecurityManager����
		Factory<SecurityManager> factory=new IniSecurityManagerFactory("classpath:jdbc_realm.ini"); 
		// ��ȡSecurityManagerʵ��
		SecurityManager securityManager=factory.getInstance();
		// ��SecurityManagerʵ���󶨵�SecurityUtils
		SecurityUtils.setSecurityManager(securityManager);
		// �õ���ǰִ�е��û�
		Subject currentUser=(Subject) SecurityUtils.getSubject();
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
	public String MemberSignIn(Member member,Member_account ma) {
		member.setStatus("0");//�˺�״̬
		member.setDel_flag("0");//ɾ�����
		member.setCreate_date(Calendar.getInstance().getTime());//����ʱ��
		ma.setBbin_amount(1000.00);//Ĭ�ϸ�ÿ��ע����û�����1000Ԫ�Ľ�����
		ma.setCreate_date(member.getCreate_date());
		fontService.addMemberSignIn(member,ma);
		return "redirect:/users/showStock";
	}
	
	
	//ǰ̨��¼
	@RequestMapping("/MemberSignUp")
	public String MemberSignUpp(Member member,Model model,HttpSession session) {
		boolean fal=fontService.getMemberSignUp(member);
		Member member2=null;
		if (fal) {
			 member2=fontService.getMemberCZ(member);
			System.err.println("name="+member2.getName()+"  password="+member2.getPassword());
			session.setAttribute("member", member2);
			List<Finance_product_funds> list=fontService.listStock();//��Ʋ�Ʒ��Ϣ
			List<Push_notice> listPush=fontService.listPush();//������Ϣ
			model.addAttribute("showStock", list);
			model.addAttribute("listPush", listPush);
		}else {
			member2=null;
			model.addAttribute("dlyz", "�˺Ż��������");
			System.out.println("�˺Ż��������");
			List<Finance_product_funds> list=fontService.listStock();//��Ʋ�Ʒ��Ϣ
			List<Push_notice> listPush=fontService.listPush();//������Ϣ
			model.addAttribute("showStock", list);
			model.addAttribute("listPush", listPush);
			model.addAttribute("member", null);
		}
		return "homePage";
	}
	
	//ǰ̨�˳�
	@RequestMapping("/tuile")
	public String TuiLe(HttpSession session) {
		session.setAttribute("member",null);
		return "redirect:/users/showStock";
	}
	
	
	
	//��ת��֧��
	@RequestMapping("/alipay")
	public String alipay() {
		return "alipay.index";
	}
	
	//��ת����ֵҳ��
	@RequestMapping("/alipay_pag")
	public String alipay_pag() {
		return "alipay.trade.page.pay";
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
	public String product_Solid(HttpServletRequest request,HttpServletResponse response,Model model) {
		
		Map map=new HashMap();//�½�һ��map����
		String status=request.getParameter("stutas");//���״̬
		String year_rate=request.getParameter("year_rate");//�껯����
		map=initMap(request, map);
		List<Subject>list=fontService.listCPZX(map);//��ѯ����
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
		model.addAttribute("listCPZX",list);
		return "product_center";
		
	}
	
	
	//ƴ�Ӳ�Ʒ����
	public Map initMap(HttpServletRequest request,Map map){
		String type=request.getParameter("type");
		String year_rate=request.getParameter("year_rate");//�껯����
		String period_start=request.getParameter("period_start");//��ʼ����
		String period_end=request.getParameter("period_end");//��������
		String status=request.getParameter("status");//���״̬
		String flag=request.getParameter("flag"); //��־
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
	
	
	
	
	
	//��Ʒ����-���������-����������ת�Ĺ���ҳ��
	@RequestMapping("/productbuy")
	public String product_buy(int id,Model model,int mid,HttpSession session) {
		 Subject subject=fontService.getByIdSubject(id);
		 Member_account ma=null;
		  if (mid != 0) {
			  ma=fontService.getByidMember_account(mid);
		}
		Date s=Calendar.getInstance().getTime();
		String jxrq=new SimpleDateFormat("yyyy-MM-dd").format(s);
		
		
		
		//���û�������1
		Format f = new SimpleDateFormat("yyyy-MM-dd"); 
		Date today = new Date();  
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(s);
		calendar.add(Calendar.DAY_OF_MONTH, subject.getPeriod());//��������ڼ��ϱ������
		Date hkrq1=calendar.getTime();//��������
		//���û������ڶ�
		Calendar calendar2=Calendar.getInstance();
		calendar2.setTime(s);
		calendar2.add(Calendar.DAY_OF_MONTH, subject.getPeriod()+1);//��������ڼ��ϱ������ ���Ͽ��ܻ��ӳٵ�һ��
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
	

	//�ҵļӷ���--Ͷ�ʼ�¼
	@RequestMapping("/listSPR")
	public String listSpr(int mid,Model model,HttpSession session) {
		Member member=(Member)session.getAttribute("member");
		int mmid=member.getId();
		List<Subject_purchase_record> list=fontService.listSPR(mmid);//Ͷ�ʼ�¼��������
		Member_account account = this.fontService.getMember_account(mmid);//ͷ���������һ������ �˻�����
		long investCount = this.fontService.getCount(mmid);//Ͷ�ʼ�¼��¼��
		model.addAttribute("listSpr", list);
		model.addAttribute("account", account);
		model.addAttribute("investCount", investCount);
		return "invest_record";
	}
	
	//�ҵļӷ���--�����
	@RequestMapping("/listSBPR")
	public String listSbpr(int mid,Model model) {
		Subject_bbin_purchase_record sbpr=fontService.listSbpr(mid);
		Member_account account = this.fontService.getMember_account(mid);//ͷ���������һ������ �˻�����
		model.addAttribute("account", account);
		model.addAttribute("sbpr", sbpr);
		return "bbin_record";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
