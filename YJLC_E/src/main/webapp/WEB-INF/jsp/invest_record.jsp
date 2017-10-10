<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>投资记录</title>

	<link href="/YJLC_E/css/common.css" rel="stylesheet">
	<link href="/YJLC_E/css/jw.css" rel="stylesheet">
    <link href="/YJLC_E/css/iconfont.css" rel="stylesheet">
    <script src="/YJLC_E/js/hm.js"></script><script src="/YJLC_E/js/jquery.js"></script>
    <script src="/YJLC_E/js/echarts.js"></script>
	
	<script type="text/javascript" src="/YJLC_E/js/hm.js" ></script>

</head>
<body>

<!-- jsp动态导入font头.jsp  -->
<jsp:include page="/WEB-INF/jsp/fontTop.jsp" flush="false"></jsp:include>
	
	
	
<table height="160" class="peopleInfo" width="970" border="0" cellspacing="0" cellpadding="0">
    <tbody><tr>
        <td align="left" valign="middle" class="info">
            <a href="http://pro.ying158.com/account/security">
                <div class="img"><img src="/YJLC_E/images/img/userPic.jpg"></div>
                <h2>${member.name}，<span>您好!</span></h2>
            </a>
            <div class="safe">账户安全&nbsp;&nbsp;<span class="scroll"><em style="width:75%"></em></span></div>
            <ul class="listIco iconfont">
                <li class="active"><a href="http://pro.ying158.com/account/deposit/records#1"></a><em></em></li>
                <li class="active"><a href="http://pro.ying158.com/account/deposit/records#1"></a><em></em></li>
                <!-- <li class=""><a href="#1">&#xe61f;</a><em>&#xe61b;</em></li> -->
                <li class="active"><a href="http://pro.ying158.com/account/deposit/records#1"></a><em></em></li>                                
                <li class="active"><a href="http://pro.ying158.com/account/deposit/records#1"></a><em></em></li>
            </ul>
        </td>
        <td align="right">
            <a href="#" class="loginOut"><span class="iconfont"></span>安全退出</a>
        </td>
    </tr>
</tbody></table>
<div class="countBox">
    <ul>
        <c:if test="${empty member.member_account }">
    		<li><h2>0</h2><p>账户可用余额(元)<a href="javascript:;" class="iconfont"><span>账户可用余额</span><i></i></a></p></li>
    	</c:if>
    	<c:if test="${!empty member.member_account }">
    		<li><h2>${account.useable_balance }</h2><p>账户可用余额(元)<a href="javascript:;" class="iconfont"><span>账户可用余额</span><i></i></a></p></li>
    	</c:if>
    	
        <li><h2>${account.useable_balance+account.invest_amount+account.total_profit }</h2><p>账户总资产(元)<a href="javascript:;" class="iconfont"><span>可用余额+投资金额+累计收益</span><i></i></a></p></li>
       
        <c:if test="${empty member.member_account }">
        	<li><h2 style="color:#9d8440">0</h2><p>投资金额(元)<a href="javascript:;" class="iconfont"><span>投资总资金</span><i></i></a></p></li>
        </c:if>
        <c:if test="${!empty member.member_account }">
        	<li><h2 style="color:#9d8440">${account.invest_amount }</h2><p>投资金额(元)<a href="javascript:;" class="iconfont"><span>投资总资金</span><i></i></a></p></li>
        </c:if>
        
        <c:if test="${empty member.member_account }">
        	<li><h2 style="color:#9d8440">0</h2><p>累计收益(元)<a href="javascript:;" class="iconfont"><span>累计收益</span><i></i></a></p></li>
        </c:if>
        <c:if test="${!empty member.member_account }">
        	<li><h2 style="color:#9d8440">${account.total_profit }</h2><p>累计收益(元)<a href="javascript:;" class="iconfont"><span>累计收益</span><i></i></a></p></li>
        </c:if>
        
        <c:if test="${empty member.member_account }">
        	<li><h2 style="color:#9d8440">0</h2><p>冻结金额(元)<a href="javascript:;" class="iconfont"><span>提现冻结金额</span><i></i></a></p></li>
        </c:if>
        <c:if test="${!empty member.member_account }">
        	<li><h2 style="color:#9d8440">${account.imuseale_balance }</h2><p>冻结金额(元)<a href="javascript:;" class="iconfont"><span>提现冻结金额</span><i></i></a></p></li>
        </c:if>
    </ul>
    <a href="/YJLC_E/users/alipay" class="cz">充值</a>
    <a href="#" class="tk">提款</a>
</div>
	<div class="proMain clearfix">
		<div class="adminLeft">
			<h2>我的投资</h2>
			<ul>
				<li><a id="member_center_menu_invests" href="/YJLC_E/users/listSPR?mid=${member.id}"><em
						class="iconfont red"></em>投资记录</a></li>
				<li><a id="member_center_menu_profit_record"
					href="/YJLC_E/shouyijilu"><em class="iconfont red"></em>收益记录</a></li>
				<li><a id="member_center_menu_deposit_record"
					href="/YJLC_E/chongzhijilu"><em class="iconfont red"></em>充值记录</a></li>
				<li><a id="member_center_menu_withdraw_record"
					href="/YJLC_E/tikuanjilu"><em class="iconfont red"></em>提款记录</a></li>
				<li><a id="member_center_menu_bbinInfo_record"
					href="/YJLC_E/users/listSBPR?mid=${member.id}"><em class="iconfont red"></em>体验金记录</a></li>
			</ul>
			<h2>我的账户</h2>
			<ul>
				<li><a id="member_center_menu_deposit"
					href="zhanghuchongzhi.html"><em class="iconfont"></em>账户充值</a></li>
				<li><a id="member_center_menu_security" href="anquanxinxi.html"><em
						class="iconfont"></em>安全信息</a></li>
				<li><a id="member_center_menu_withdraw" href="woyaotikuan.html"><em
						class="iconfont"></em>我要提款</a></li>
				<li><a id="member_center_menu_financial"
					href="woshilicaishi.html"><em class="iconfont"></em>我是理财师</a></li>
			</ul>
		</div>
		<script>
  var menu_item="";
 $("#"+menu_item).addClass("select");
</script>

		<div class="admin-right">
			<div class="tbConBox">
				<div class="tab">
					<a class="select" href="javascript:;">投资记录</a>
				</div>
				<div id="conBox">
					<div class="box" style="display: block">


						<div class="ajaxContainer">
							<!-- 异步内容开始 -->
							<table class="tzlist" width="100%" border="1"
								bordercolor="#e9e9e9" cellspacing="0" cellpadding="0">
								<tbody>
									<tr>
										<th>订单编号</th>
										<th>标的名称</th>
										<th>金额</th>
										<th>预期收益</th>
										<th>状态</th>
										<th>购买时间</th>
									</tr>
									<c:forEach items="${listSpr}" var="ls">
										<tr>
											<td> ${ls.serial_number} </td>
											<td> ${ls.subject.name} </td>
											<td> ${ls.amount} </td>
											<td> ${ls.interest} </td>
											<td> <c:if test="${ls.ispayment == '1'}">未还款</c:if>
												 <c:if test="${ls.ispayment != '1'}">已还款</c:if>
											 </td>
											<td> ${ls.create_date} </td>
										</tr>
									</c:forEach>
				
								</tbody>
							</table>
							<div class="listCount">
								总计<font color="#ff503f">${investCount}</font>笔
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="security">
        <div class="item">
            <img src="/YJLC_E/images/img/indexSecurity1.png">
            <div class="detail">
                资金银行监管
                <div class="desc">
                    平台资金由第三方银行监管
                </div>
            </div>
        </div>
        <div class="item">
            <img src="/YJLC_E/images/img/indexSecurity2.png">
            <div class="detail">
                交易证监会监管
                <div class="desc">
                    投资交易由证监会监管
                </div>
            </div>
        </div>
        <div class="item">
            <img src="/YJLC_E/images/img/indexSecurity3.png">
            <div class="detail">
                风控盈+监管
                <div class="desc">
                    盈+全自动风控系统为您保驾护航
                </div>
            </div>
        </div>
    </div>
    
<script>
    var _hmt = _hmt || [];
    (function() {
        var hm = document.createElement("script");
        hm.src = "//hm.baidu.com/hm.js?06cf97732baac1a65bed8ae95f2384aa";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
    })();
</script>
</body>	
	
	
	
	
	
	
	
	
	
<!-- 尾部 -->
	<div style="margin-top: 15px;">

		<!-- 示例-970 -->
		<ins class="adsbygoogle" style="display: inline-block; width: 970px; height: 90px" data-ad-client="ca-pub-6111334333458862"
			data-ad-slot="3820120620"></ins>

	</div>

	<div style="width: 100%; height: 659px; background: url(/YJLC_E/font/img/fontDown01.png);"></div>

</body>
</html>