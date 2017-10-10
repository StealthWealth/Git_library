<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>体验金记录</title>
	<link href="http://www.ying158.com/images/icon.ico" type="image/x-icon" rel="shortcut icon">
	<link href="/YJLC_E/css/common.css" rel="stylesheet">
	<link href="/YJLC_E/css/jw.css" rel="stylesheet">
    <link href="/YJLC_E/css/iconfont.css" rel="stylesheet">
    <script src="/YJLC_E/js/hm.js"></script><script src="/YJLC_E/js/jquery.js"></script>
    <script src="/YJLC_E/js/echarts.js"></script>

</head>
<body>
<!-- jsp动态导入font头.jsp  -->
<jsp:include page="/WEB-INF/jsp/fontTop.jsp" flush="false"></jsp:include>
	

<table height="160" class="peopleInfo" width="970" border="0" cellspacing="0" cellpadding="0">
    <tbody><tr>
        <td align="left" valign="middle" class="info">
            <a href="http://pro.ying158.com/account/security">
                <div class="img"><img src="img/userPic.jpg"></div>
                <h2>${member.name}，<span>您好!</span></h2>
            </a>
            <div class="safe">账户安全&nbsp;&nbsp;<span class="scroll"><em style="width:100%"></em></span></div>
            <ul class="listIco iconfont">
                <li class="active"><a href="http://pro.ying158.com/account/deposit/records#1"></a><em></em></li>
                <li class="active"><a href="http://pro.ying158.com/account/deposit/records#1"></a><em></em></li>
                <!-- <li class=""><a href="#1">&#xe61f;</a><em>&#xe61b;</em></li> -->
                <li class="active"><a href="http://pro.ying158.com/account/deposit/records#1"></a><em></em></li>                                
                <li class="active"><a href="http://pro.ying158.com/account/deposit/records#1"></a><em></em></li>
            </ul>
        </td>
        <td align="right">
            <a href="http://pro.ying158.com/web/logout" class="loginOut"><span class="iconfont"></span>安全退出</a>
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
    <a href="" class="tk">提款</a>
</div><div class="proMain clearfix">
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
        <li><a id="member_center_menu_deposit" href="zhanghuchongzhi.html"><em class="iconfont"></em>账户充值</a></li>
        <li><a id="member_center_menu_security" href="anquanxinxi.html"><em class="iconfont"></em>安全信息</a></li>
        <li><a id="member_center_menu_withdraw" href="woyaotikuan.html"><em class="iconfont"></em>我要提款</a></li>
        <li><a id="member_center_menu_financial" href="woshilicaishi.html"><em class="iconfont"></em>我是理财师</a></li>
    </ul>
</div>
<script>
  var menu_item="";
 $("#"+menu_item).addClass("select");
</script>

    <div class="admin-right">
        <div class="tbConBox">
            <div class="tab">
                <a class="select" href="javascript:;">体验金记录</a>
            </div>
            <div id="conBox">
                <div class="box" style="display:block">
                    <div class="remind"><h4><strong><span style="color:#827E76">体验金余额(元)：</span><span style="color:#9d8440">8888</span>&nbsp;&nbsp;&nbsp;&nbsp;
                                <a href="http://pro.ying158.com/subject">立即使用</a>
                        </strong></h4></div>

                    <div>
                        <table class="tzlist" width="100%" border="1" bordercolor="#e9e9e9" cellspacing="0" cellpadding="0">
                            <tbody><tr>
                                <td>标的名称</td>
                                <td style="color:#9d8440;">${sbpr.subject.name}</td>
                                <td>状态</td>
                                <td style="color:#9d8440;">已结清</td>
                            </tr>
                            <tr>
                                <td>投资金额</td>
                                <td style="color:#9d8440;">￥${sbpr.amount}</td>
                                <td>期限</td>
                                <td style="color:#9d8440;">${sbpr.subject.period}天</td>
                            </tr>
                            <tr>
                                <td>收益方式</td>
                                <td style="color:#9d8440;">一次性还本付息</td>
                                <td>年化收益率</td>
                                <td style="color:#9d8440;">${sbpr.subject.year_rate}%</td>
                            </tr>
                            <tr>
                                <td>计息日</td>
                                <td style="color:#9d8440;">${sbpr.create_date}</td>
                                <td>预期收益</td>
                                <td style="color:#9d8440;">￥${sbpr.interest}</td>
                            </tr>
                            <tr>
                                <td>结束日</td>
                                <td style="color:#9d8440;">${ last_profit_day}</td>
                                <td>已获收益</td>
                                <td style="color:#9d8440;">${sbpr.interest}元</td>
                            </tr>
                        </tbody></table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

    <div class="security">
        <div class="item">
            <img src="img/indexSecurity1.png">
            <div class="detail">
                资金银行监管
                <div class="desc">
                    平台资金由第三方银行监管
                </div>
            </div>
        </div>
        <div class="item">
            <img src="img/indexSecurity2.png">
            <div class="detail">
                交易证监会监管
                <div class="desc">
                    投资交易由证监会监管
                </div>
            </div>
        </div>
        <div class="item">
            <img src="img/indexSecurity3.png">
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




	<div style="margin-top: 15px;">

		<!-- 示例-970 -->
		<ins class="adsbygoogle" style="display: inline-block; width: 970px; height: 90px" data-ad-client="ca-pub-6111334333458862"
			data-ad-slot="3820120620"></ins>

	</div>

	<div style="width: 100%; height: 659px; background: url(/YJLC_E/font/img/fontDown01.png);"></div>
</body>
</html>