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
	
	
	//去到支付页面
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
	
	
	
	
	//同步
	@RequestMapping("/tongbu")
	public String tongbu(HttpServletRequest request,HttpServletResponse response,Member_account ma,Member_deposit_record mdr,HttpSession session) 
			throws IOException, AlipayApiException {
		PrintWriter out=response.getWriter();
		/* *
		 * 功能：支付宝服务器同步通知页面
		 * 日期：2017-03-30
		 * 说明：
		 * 以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
		 * 该代码仅供学习和研究支付宝接口使用，只是提供一个参考。


		 *************************页面功能说明*************************
		 * 该页面仅做页面展示，业务逻辑处理请勿在该页面执行
		 */
		 System.out.println("rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
			//获取支付宝GET过来反馈信息
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
				//乱码解决，这段代码在出现乱码时使用
				valueStr = new String(valueStr.getBytes("utf-8"), "utf-8");
				params.put(name, valueStr);
			}
			
			boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type); //调用SDK验证签名
			System.out.println("rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
			//——请在这里编写您的程序（以下代码仅作参考）——
			if(signVerified) {
				//商户订单号
				String out_trade_no = new String(request.getParameter("out_trade_no"));
			
				//支付宝交易号
				String trade_no = new String(request.getParameter("trade_no"));
			
				//付款金额
				String total_amount = new String(request.getParameter("total_amount"));
				
				
				System.out.println("-----------------------------------------------------");
				System.out.println("商户订单号:"+out_trade_no);
				System.out.println("支付宝交易号:"+trade_no);
				System.out.println("付款金额:"+total_amount);
				
				Member member=(Member) session.getAttribute("member");
				System.out.println(member.getId());
				Member_account mema=this.alipayservlce.getMa(member.getId());//查询账户表
				session.setAttribute("member", mema); 
				
				mdr.setSerial_number(out_trade_no);//流水号
				mdr.setPay_channel_name("支付宝");//支付渠道名称
				mdr.setPay_channel_order_no(trade_no);//支付渠道订单号
				mdr.setCreate_date(Calendar.getInstance().getTime());//创建时间
				mdr.setAmount(Double.valueOf(total_amount));//金额
				mdr.setStatus(1);//付款状态 1代表支付成功
				mdr.setUpdate_date(Calendar.getInstance().getTime());//修改时间
				ma=mema;
				
				//给交易表添加交易记录
				Member_trade_record mtr=new Member_trade_record();//交易记录表
				mtr.setTrade_no(Getnum());//流水号 交易号
				mtr.setTrade_name("支付宝充值  金额:"+total_amount);//交易名称
				mtr.setCounterpart(member.getName());//交易对方
				mtr.setAmount(total_amount);//交易金额
				//FINANCE理财产品     MOBILE_RECHARGE手机充值     SINOPEC_RECHARGE石化卡充值     ALIPAY_RECHARGE支付宝充值
				mtr.setTrade_type("ALIPAY_RECHARGE");//交易类别 支付宝充值
				mtr.setFund_flow("1");//资金流向 0:流出  1:流入
				mtr.setTrade_status("1");//交易状态
				mtr.setExt_field_1("支付宝充值备注1");
				mtr.setExt_field_2("支付宝充值备注2");
				mtr.setExt_field_3("支付宝充值备注3");
				mtr.setCreate_date(Calendar.getInstance().getTime());//创建时间
				mtr.setUpdate_date(Calendar.getInstance().getTime());//修改时间
				
				if (mema.getUseable_balance() == 0) {//判断可用余额是否为0
					ma.setUseable_balance(Double.valueOf(total_amount));//修改金额
					this.alipayservlce.updateMA(ma, mdr,member,mtr);
				}else {
					ma.setUseable_balance(Double.valueOf(total_amount)+mema.getUseable_balance());//修改金额
					this.alipayservlce.updateMA(ma, mdr,member,mtr);
				}
								
				
				//out.println("trade_no:"+trade_no+"<br/>out_trade_no:"+out_trade_no+"<br/>total_amount:"+total_amount);
			}else {
				out.println("验签失败");
			}
			//——请在这里编写您的程序（以上代码仅作参考）——
			System.out.println("rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
			
			
			
			return "homePage";//充值成功后返回的页面
	}
	
	
	

	@RequestMapping(value="/buygsl",method=RequestMethod.POST)
	public String BUY_Solid_closed_class(HttpServletRequest request,int member_id,HttpSession session) throws UnknownHostException {
		String sid=request.getParameter("sid");
		Subject subject=alipayservlce.getByIdSubject(Integer.valueOf(sid));//获得固收类的信息
		//1.修改账户表的可用余额  修改时间   修改投资总额
		Member_account ma=alipayservlce.getMa(member_id);//获得成员账户表		
		String gmje=request.getParameter("totalFee");//获得文本框中输入的金额
		ma.setUpdate_date(Calendar.getInstance().getTime());//修改时间
		ma.setUseable_balance(ma.getUseable_balance()-Double.valueOf(gmje));//修改金额
		ma.setInvest_amount(ma.getInvest_amount()+Double.valueOf(gmje));//修改投资总金额
		
		
		//2.添加交易记录
		Member_trade_record mtr=new Member_trade_record();//交易记录表
		mtr.setTrade_no(Getnum());//获得流水号 
		mtr.setTrade_name("购买："+subject.getName()+"; 金额："+gmje);//购买名称
		Member member=(Member) session.getAttribute("member");
		mtr.setCounterpart(member.getName());//交易对方
		mtr.setAmount(gmje);//交易金额
		//FINANCE理财产品     MOBILE_RECHARGE手机充值     SINOPEC_RECHARGE石化卡充值     ALIPAY_RECHARGE支付宝充值
		mtr.setTrade_type("FINANCE");//交易记录
		mtr.setFund_flow("1");//资金流向
		mtr.setTrade_status("0");//交易状态 0为成功 1为失败
		mtr.setExt_field_1("购买者电话:"+member.getMobile_Phone());//扩展1 位电话号 
		mtr.setExt_field_2("购买:"+subject.getName()+"备注2");
		mtr.setExt_field_3("购买:"+subject.getName()+"备注3");
		mtr.setCreate_date(Calendar.getInstance().getTime());//创建时间
		mtr.setUpdate_date(Calendar.getInstance().getTime());//修改时间
		
		
		//3.标的购买记录
		subject.setBought(subject.getBought()+1);//subject的后买人数+1
		Subject_purchase_record spr=new Subject_purchase_record();//标的购买表
		spr.setSerial_number(Getnum());//流水号
		spr.setAmount(Double.valueOf(gmje));//交易金额
		String ip=InetAddress.getLocalHost().toString();//获得本机ip和名字
		String cip=ip.substring(ip.lastIndexOf("/")+1);// 截取字符串只留下ip地址   字符串.substring(字符串.lastIndexOf("\\")+1) 
		spr.setDeal_ip(cip);//交易ip
		Date cusj=Calendar.getInstance().getTime();//获得当前时间
		spr.setCreate_date(cusj);//创建时间
		spr.setUpdate_date(cusj);//修改时间
		//结算利息=购买金额x利率/365x周期时间
		double amm=Double.valueOf(gmje);//购买金额
		double yhl=subject.getYear_rate();//利率
		int zqsj=subject.getPeriod();//周期时间
		double interest=amm*yhl/365*zqsj;//结算利息
		spr.setInterest(interest);//赋值结算利息
		spr.setIspayment(1);//还款 
		spr.setPay_interest_times(subject.getBought()+1);//购买次数
		//设置最后计息日
        Date currentTime = new Date();  
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");  
        String dateString = formatter.format(currentTime);  
		spr.setLast_profit_day(Integer.valueOf(dateString));//最后计息日期
		
		
		//4.记账表
		Member_tally mt=new Member_tally();
		mt.setType_id(subject.getId());//标的类型id
		mt.setType_name(subject.getName());//消费类型名称
		mt.setAmount(Double.valueOf(gmje));//消费金额
		mt.setPay_date(cusj);//支付时间
		mt.setCreate_date(cusj);//创建时间
		
		
		this.alipayservlce.updatema(ma,member,mtr,subject,spr,mt);//调用修改方法
		
		return "homePage";//购买成功后返回的页面
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	 /** 
     * 获取现在时间 
     * @return返回字符串格式yyyyMMddHHmmss 
     */  
      public static String getStringDate() {  
             Date currentTime = new Date();  
             SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");  
             String dateString = formatter.format(currentTime);  
             System.out.println("TIME:::"+dateString);  
             return dateString;  
          }  
      
      
      /** 
       * 由年月日时分秒+3位随机数 
       * 生成流水号 
       * @return 
       */  
      public static String Getnum(){  
          String t = getStringDate();  
          int x=(int)(Math.random()*900)+100;  
          String serial = t + x;  
          return serial;  
      }       
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
