<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>盈+ 收益记录</title>
<link href="http://www.ying158.com/images/icon.ico" type="image/x-icon" rel="shortcut icon">
<link href="/YJLC_E/css/common.css" rel="stylesheet">
<link href="/YJLC_E/css/jw.css" rel="stylesheet">
<link href="/YJLC_E/css/iconfont.css" rel="stylesheet">
<script src="/YJLC_E/js/hm.js"></script>
<script src="/YJLC_E/js/jquery.js"></script>
<script src="/YJLC_E/js/echarts.js"></script>
</head>
<body>
	<!-- jsp动态导入font头.jsp  -->
	<jsp:include page="/WEB-INF/jsp/fontTop.jsp" flush="false"></jsp:include>


	<table height="160" class="peopleInfo" width="970" border="0" cellspacing="0" cellpadding="0">
		<tbody>
			<tr>
				<td align="left" valign="middle" class="info"><a href="http://pro.ying158.com/account/security">
						<div class="img">
							<img src="/YJLC_E/images/img/userPic.jpg">
						</div>
						<h2>${member.member_name }<span>您好!</span>
						</h2>
				</a>
					<div class="safe">
						账户安全&nbsp;&nbsp;<span class="scroll"><em style="width: 100%"></em></span>
					</div>
					<ul class="listIco iconfont">
						<li class="active"><a href="http://pro.ying158.com/account/deposit/records#1"></a><em></em></li>
						<li class="active"><a href="http://pro.ying158.com/account/deposit/records#1"></a><em></em></li>
						<!-- <li class=""><a href="#1">&#xe61f;</a><em>&#xe61b;</em></li> -->
						<li class="active"><a href="http://pro.ying158.com/account/deposit/records#1"></a><em></em></li>
						<li class="active"><a href="http://pro.ying158.com/account/deposit/records#1"></a><em></em></li>
					</ul></td>
				<td align="right"><a href="/YJLC_E/users/tuile" class="loginOut"><span class="iconfont"></span>安全退出</a></td>
			</tr>
		</tbody>
	</table>
	<div class="countBox">
		<ul>
			<li><h2>${account.useable_balance }</h2>
				<p>
					账户可用余额(元)<a href="javascript:;" class="iconfont"><span>账户可用余额</span><i></i></a>
				</p></li>

			<li><h2>${account.useable_balance+account.invest_amount+account.total_profit }</h2>
				<p>
					账户总资产(元)<a href="javascript:;" class="iconfont"><span>可用余额+投资金额+累计收益</span><i></i></a>
				</p></li>

			<li><h2 style="color: #9d8440">${account.invest_amount }</h2>
				<p>
					投资金额(元)<a href="javascript:;" class="iconfont"><span>投资总资金</span><i></i></a>
				</p></li>

			<li><h2 style="color: #9d8440">${account.total_profit }</h2>
				<p>
					累计收益(元)<a href="javascript:;" class="iconfont"><span>累计收益</span><i></i></a>
				</p></li>
			<li><h2 style="color: #9d8440">${account.imuseale_balance }</h2>
				<p>
					冻结金额(元)<a href="javascript:;" class="iconfont"><span>提现冻结金额</span><i></i></a>
				</p></li>
		</ul>
		<a href="http://pro.ying158.com/account/deposit" class="cz">充值</a> <a href="http://pro.ying158.com/account/withdraw" class="tk">提款</a>
	</div>
	<div class="proMain clearfix">
		<div class="adminLeft">
			<h2>我的投资</h2>
			<ul>
				<li><a id="member_center_menu_invests" href="touzijilu.html"><em class="iconfont red"></em>投资记录</a></li>
				<li><a id="member_center_menu_profit_record" href="/YJLC_E/shouyijilu"><em class="iconfont red"></em>收益记录</a></li>
				<li><a id="member_center_menu_deposit_record" href="/YJLC_E/chongzhijilu"><em class="iconfont red"></em>充值记录</a></li>
				<li><a id="member_center_menu_withdraw_record" href="/YJLC_E/tikuanjilu"><em class="iconfont red"></em>提款记录</a></li>
				<li><a id="member_center_menu_bbinInfo_record" href="tiyanjinjilu.html"><em class="iconfont red"></em>体验金记录</a></li>
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
			var menu_item = "member_center_menu_profit_record";
			$("#" + menu_item).addClass("select");
		</script>

		<div class="admin-right">
			<div class="tbConBox">
				<div class="tab">
					<a class="select" href="javascript:;">收益记录</a>
				</div>
				<div id="conBox">
					<div class="box" style="display: block">

						<meta name="keywords"
							content="盈+，盈，社区金融，O2O社区金融，社区金融O2O，O2O，互联网+社区金融，O2O连锁，社区门店，首家社区金融，社区金融服务，综合金融，互联网金融，体验中心，普惠金融，金融创新，社区化，普惠化，全渠道化，互联网线上平台，O2O交易，全国首家，盈十，金融衍生品，固收类理财，私募基金，股权基金，股指期货，玩转股指，商品期货，国际期货，外盘，A50，沪深300，中证500，上证50">
						<meta name="description" content="盈+——全国首家互联网金融交流体验中心，与您共盈，给财富做加法。">
						<link href="http://pro.ying158.com/resources/web/images/icon.ico" type="image/x-icon" rel="shortcut icon">

						<div class="ajaxContainer">
							<table class="tzlist" width="100%" border="1" bordercolor="#e9e9e9" cellspacing="0" cellpadding="0">
								<tbody>
									<tr>
										<th width="20%">时间</th>
										<th width="30%">订单号</th>
										<th width="20%">金额</th>
										<th width="20%">备注</th>
									</tr>
									<c:forEach items="${shouyi }" var="yi">
										<tr>
											<td><script>document.write("${yi.create_date }".substring(0, 10));</script></td>
											<td>${yi.serial_number }</td>
											<td>${yi.amount }</td>
											<td>${yi.comment }</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<script type="text/javascript">
							function getJsonInfo(url) {
								$.get(url, 'json', function(data) {
									$(".ajaxContainer").empty();
									$(".ajaxContainer").append(data);
								});
							}
						</script>
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
				<div class="desc">平台资金由第三方银行监管</div>
			</div>
		</div>
		<div class="item">
			<img src="/YJLC_E/images/img/indexSecurity2.png">
			<div class="detail">
				交易证监会监管
				<div class="desc">投资交易由证监会监管</div>
			</div>
		</div>
		<div class="item">
			<img src="/YJLC_E/images/img/indexSecurity3.png">
			<div class="detail">
				风控盈+监管
				<div class="desc">盈+全自动风控系统为您保驾护航</div>
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


	<!-- 动态导入font尾.jsp -->
	<jsp:include page="/WEB-INF/jsp/fontDown.jsp" flush="false"></jsp:include>
</body>
</html>