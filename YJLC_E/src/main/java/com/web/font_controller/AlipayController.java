package com.web.font_controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.web.alipay.config.AlipayConfig;
import com.web.font_bean.Member_tally;
import com.web.font_service.AlipayService;
import com.web.member_account_Bean.Member_account;
import com.web.member_deposit_record_Bean.Member_deposit_record;
import com.web.member_trade_record_Bean.Member_trade_record;
import com.web.subject_Bean.Subject;
import com.web.subject_purchase_record_Bean.Subject_purchase_record;
import com.web.vip_auditing_Bean.Member;

@Controller
@RequestMapping("/alipay")
public class AlipayController {
	
	@Autowired
	private AlipayService alipayservlce;
	
	
	//ȥ��֧��ҳ��
	@RequestMapping("/alipay_pag")
	public String alipay_pag() {
		return "alipay.trade.page.pay";
	}
	
	
	@RequestMapping("/notifu")
	public String quyibuu() {
		return "notify_url";
	}
	
	@RequestMapping("/return")
	public String qutongbu() {
		return "return_url";
	}
	
	
	
	
	//ͬ��
	@RequestMapping("/tongbu")
	public String tongbu(HttpServletRequest request,HttpServletResponse response,Member_account ma,Member_deposit_record mdr,HttpSession session) 
			throws IOException, AlipayApiException {
		PrintWriter out=response.getWriter();
		/* *
		 * ���ܣ�֧����������ͬ��֪ͨҳ��
		 * ���ڣ�2017-03-30
		 * ˵����
		 * ���´���ֻ��Ϊ�˷����̻����Զ��ṩ���������룬�̻����Ը����Լ���վ����Ҫ�����ռ����ĵ���д,����һ��Ҫʹ�øô��롣
		 * �ô������ѧϰ���о�֧�����ӿ�ʹ�ã�ֻ���ṩһ���ο���


		 *************************ҳ�湦��˵��*************************
		 * ��ҳ�����ҳ��չʾ��ҵ���߼����������ڸ�ҳ��ִ��
		 */
		 System.out.println("rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
			//��ȡ֧����GET����������Ϣ
			Map<String,String> params = new HashMap<String,String>();
			Map<String,String[]> requestParams = request.getParameterMap();
			for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
				String name = (String) iter.next();
				String[] values = (String[]) requestParams.get(name);
				String valueStr = "";
				for (int i = 0; i < values.length; i++) {
					valueStr = (i == values.length - 1) ? valueStr + values[i]
							: valueStr + values[i] + ",";
				}
				//����������δ����ڳ�������ʱʹ��
				valueStr = new String(valueStr.getBytes("utf-8"), "utf-8");
				params.put(name, valueStr);
			}
			
			boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type); //����SDK��֤ǩ��
			System.out.println("rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
			//�������������д���ĳ������´�������ο�������
			if(signVerified) {
				//�̻�������
				String out_trade_no = new String(request.getParameter("out_trade_no"));
			
				//֧�������׺�
				String trade_no = new String(request.getParameter("trade_no"));
			
				//������
				String total_amount = new String(request.getParameter("total_amount"));
				
				
				System.out.println("-----------------------------------------------------");
				System.out.println("�̻�������:"+out_trade_no);
				System.out.println("֧�������׺�:"+trade_no);
				System.out.println("������:"+total_amount);
				
				Member member=(Member) session.getAttribute("member");
				System.out.println(member.getId());
				Member_account mema=this.alipayservlce.getMa(member.getId());//��ѯ�˻���
				session.setAttribute("member", mema); 
				
				mdr.setSerial_number(out_trade_no);//��ˮ��
				mdr.setPay_channel_name("֧����");//֧����������
				mdr.setPay_channel_order_no(trade_no);//֧������������
				mdr.setCreate_date(Calendar.getInstance().getTime());//����ʱ��
				mdr.setAmount(Double.valueOf(total_amount));//���
				mdr.setStatus(1);//����״̬ 1����֧���ɹ�
				mdr.setUpdate_date(Calendar.getInstance().getTime());//�޸�ʱ��
				ma=mema;
				
				//�����ױ���ӽ��׼�¼
				Member_trade_record mtr=new Member_trade_record();//���׼�¼��
				mtr.setTrade_no(Getnum());//��ˮ�� ���׺�
				mtr.setTrade_name("֧������ֵ  ���:"+total_amount);//��������
				mtr.setCounterpart(member.getName());//���׶Է�
				mtr.setAmount(total_amount);//���׽��
				//FINANCE��Ʋ�Ʒ     MOBILE_RECHARGE�ֻ���ֵ     SINOPEC_RECHARGEʯ������ֵ     ALIPAY_RECHARGE֧������ֵ
				mtr.setTrade_type("ALIPAY_RECHARGE");//������� ֧������ֵ
				mtr.setFund_flow("1");//�ʽ����� 0:����  1:����
				mtr.setTrade_status("1");//����״̬
				mtr.setExt_field_1("֧������ֵ��ע1");
				mtr.setExt_field_2("֧������ֵ��ע2");
				mtr.setExt_field_3("֧������ֵ��ע3");
				mtr.setCreate_date(Calendar.getInstance().getTime());//����ʱ��
				mtr.setUpdate_date(Calendar.getInstance().getTime());//�޸�ʱ��
				
				if (mema.getUseable_balance() == 0) {//�жϿ�������Ƿ�Ϊ0
					ma.setUseable_balance(Double.valueOf(total_amount));//�޸Ľ��
					this.alipayservlce.updateMA(ma, mdr,member,mtr);
				}else {
					ma.setUseable_balance(Double.valueOf(total_amount)+mema.getUseable_balance());//�޸Ľ��
					this.alipayservlce.updateMA(ma, mdr,member,mtr);
				}
								
				
				//out.println("trade_no:"+trade_no+"<br/>out_trade_no:"+out_trade_no+"<br/>total_amount:"+total_amount);
			}else {
				out.println("��ǩʧ��");
			}
			//�������������д���ĳ������ϴ�������ο�������
			System.out.println("rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
			
			
			
			return "homePage";//��ֵ�ɹ��󷵻ص�ҳ��
	}
	
	
	

	@RequestMapping(value="/buygsl",method=RequestMethod.POST)
	public String BUY_Solid_closed_class(HttpServletRequest request,int member_id,HttpSession session) throws UnknownHostException {
		String sid=request.getParameter("sid");
		Subject subject=alipayservlce.getByIdSubject(Integer.valueOf(sid));//��ù��������Ϣ
		//1.�޸��˻���Ŀ������  �޸�ʱ��   �޸�Ͷ���ܶ�
		Member_account ma=alipayservlce.getMa(member_id);//��ó�Ա�˻���		
		String gmje=request.getParameter("totalFee");//����ı���������Ľ��
		ma.setUpdate_date(Calendar.getInstance().getTime());//�޸�ʱ��
		ma.setUseable_balance(ma.getUseable_balance()-Double.valueOf(gmje));//�޸Ľ��
		ma.setInvest_amount(ma.getInvest_amount()+Double.valueOf(gmje));//�޸�Ͷ���ܽ��
		
		
		//2.��ӽ��׼�¼
		Member_trade_record mtr=new Member_trade_record();//���׼�¼��
		mtr.setTrade_no(Getnum());//�����ˮ�� 
		mtr.setTrade_name("����"+subject.getName()+"; ��"+gmje);//��������
		Member member=(Member) session.getAttribute("member");
		mtr.setCounterpart(member.getName());//���׶Է�
		mtr.setAmount(gmje);//���׽��
		//FINANCE��Ʋ�Ʒ     MOBILE_RECHARGE�ֻ���ֵ     SINOPEC_RECHARGEʯ������ֵ     ALIPAY_RECHARGE֧������ֵ
		mtr.setTrade_type("FINANCE");//���׼�¼
		mtr.setFund_flow("1");//�ʽ�����
		mtr.setTrade_status("0");//����״̬ 0Ϊ�ɹ� 1Ϊʧ��
		mtr.setExt_field_1("�����ߵ绰:"+member.getMobile_Phone());//��չ1 λ�绰�� 
		mtr.setExt_field_2("����:"+subject.getName()+"��ע2");
		mtr.setExt_field_3("����:"+subject.getName()+"��ע3");
		mtr.setCreate_date(Calendar.getInstance().getTime());//����ʱ��
		mtr.setUpdate_date(Calendar.getInstance().getTime());//�޸�ʱ��
		
		
		//3.��Ĺ����¼
		subject.setBought(subject.getBought()+1);//subject�ĺ�������+1
		Subject_purchase_record spr=new Subject_purchase_record();//��Ĺ����
		spr.setSerial_number(Getnum());//��ˮ��
		spr.setAmount(Double.valueOf(gmje));//���׽��
		String ip=InetAddress.getLocalHost().toString();//��ñ���ip������
		String cip=ip.substring(ip.lastIndexOf("/")+1);// ��ȡ�ַ���ֻ����ip��ַ   �ַ���.substring(�ַ���.lastIndexOf("\\")+1) 
		spr.setDeal_ip(cip);//����ip
		Date cusj=Calendar.getInstance().getTime();//��õ�ǰʱ��
		spr.setCreate_date(cusj);//����ʱ��
		spr.setUpdate_date(cusj);//�޸�ʱ��
		//������Ϣ=������x����/365x����ʱ��
		double amm=Double.valueOf(gmje);//������
		double yhl=subject.getYear_rate();//����
		int zqsj=subject.getPeriod();//����ʱ��
		double interest=amm*yhl/365*zqsj;//������Ϣ
		spr.setInterest(interest);//��ֵ������Ϣ
		spr.setIspayment(1);//���� 
		spr.setPay_interest_times(subject.getBought()+1);//�������
		//��������Ϣ��
        Date currentTime = new Date();  
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");  
        String dateString = formatter.format(currentTime);  
		spr.setLast_profit_day(Integer.valueOf(dateString));//����Ϣ����
		
		
		//4.���˱�
		Member_tally mt=new Member_tally();
		mt.setType_id(subject.getId());//�������id
		mt.setType_name(subject.getName());//������������
		mt.setAmount(Double.valueOf(gmje));//���ѽ��
		mt.setPay_date(cusj);//֧��ʱ��
		mt.setCreate_date(cusj);//����ʱ��
		
		
		this.alipayservlce.updatema(ma,member,mtr,subject,spr,mt);//�����޸ķ���
		
		return "homePage";//����ɹ��󷵻ص�ҳ��
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	 /** 
     * ��ȡ����ʱ�� 
     * @return�����ַ�����ʽyyyyMMddHHmmss 
     */  
      public static String getStringDate() {  
             Date currentTime = new Date();  
             SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");  
             String dateString = formatter.format(currentTime);  
             System.out.println("TIME:::"+dateString);  
             return dateString;  
          }  
      
      
      /** 
       * ��������ʱ����+3λ����� 
       * ������ˮ�� 
       * @return 
       */  
      public static String Getnum(){  
          String t = getStringDate();  
          int x=(int)(Math.random()*900)+100;  
          String serial = t + x;  
          return serial;  
      }       
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
