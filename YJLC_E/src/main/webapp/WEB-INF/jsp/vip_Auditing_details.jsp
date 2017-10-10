<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Typography</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- bootstrap-css -->
<!-- bootstrap-css -->
<link rel="stylesheet" href="/YJLC_E/css/bootstrap.min.css">
<!-- //bootstrap-css -->
<!-- Custom CSS -->
<link href="/YJLC_E/css/style.css" rel='stylesheet' type='text/css' />
<link href="/YJLC_E/css/style-responsive.css" rel="stylesheet" />
<!-- font CSS -->
<link href='http://fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900,900italic'
	rel='stylesheet' type='text/css'>
<!-- font-awesome icons -->
<link href="/YJLC_E/css/font-awesome.css" rel="stylesheet">
<!-- //font-awesome icons -->
<script src="/YJLC_E/js/jquery2.0.3.min.js"></script>
</head>

<!-- 表格剧中  
<style type="text/css">
table{
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
}

</style>
-->


</style>

<body>
	<section id="container"> <!--header start--> <header class="header fixed-top clearfix"> <!--logo start-->
	<div class="brand">
		<a href="/YJLC_E/addLogin" class="logo"> VISITORS </a>
		<div class="sidebar-toggle-box">
			<div class="fa fa-bars"></div>
		</div>
	</div>
	<!--logo end-->
	<div class="top-nav clearfix">
		<!--search & user info start-->
		<ul class="nav pull-right top-menu">
			<!-- user login dropdown start-->
			<li class="dropdown"><a data-toggle="dropdown" class="dropdown-toggle" href="#"> <img alt="" src="images/2.png"> <span
					class="username"></span>
			</a></li>
			<!-- user login dropdown end -->

		</ul>
		<!--search & user info end-->
	</div>
	</header> <!--header end--> <!--sidebar start--> <aside>
	<div id="sidebar" class="nav-collapse">
		<!-- sidebar menu start-->
		<div class="leftside-navigation">
			<ul class="sidebar-menu" id="nav-accordion">

				<li class="sub-menu"><a href="javascript:;"> <i class="fa fa-book"></i> <span>理财产品</span>
				</a>
					<ul class="sub">
						<li><a href="/YJLC_E/subject/listsubject">固收类/P2P</a></li>
						<li><a href="/YJLC_E/funds/listfunds">私募/股权类</a></li>
						<li><a href="/YJLC_E/config/listconfig">海外配置</a></li>
					</ul></li>
				<li class="sub-menu"><a href="javascript:;"> <i class="fa fa-th"></i> <span>学院管理</span>
				</a>
					<ul class="sub">
						<li><a href="/YJLC_E/listNews">资讯管理</a></li>
						<li><a href="/YJLC_E/listnewstype">资讯分类</a></li>
					</ul></li>
				<li class="sub-menu"><a class="active" href="javascript:;"> <i class="fa fa-th"></i> <span>会员管理</span>
				</a>
					<ul class="sub">
						<li><a class="active" href="/YJLC_E/listAuditingAll">账号管理</a></li>
						<li><a href="/YJLC_E/listMember_Bankcards">绑卡管理</a></li>
						<li><a href="/YJLC_E/listAward_records">邀请管理</a></li>
						<li><a href="/YJLC_E/listSubject">付息计划</a></li>
						<li><a href="/YJLC_E/listMember_deposit_record">充值管理</a></li>
						<li><a href="/YJLC_E/listMember_withdraw">体现管理</a></li>
					</ul></li>
				<li class="sub-menu"><a href="javascript:;"> <i class="fa fa-th"></i> <span>盈+管理</span>
				</a>
					<ul class="sub">
						<li><a href="/YJLC_E/notice/listnotice">公告管理</a></li>
						<li><a href="/YJLC_E/feedback/listfeedback">意见反馈</a></li>
					</ul></li>
				<li class="sub-menu"><a href="javascript:;"> <i class="fa fa-th"></i> <span>系统管理</span>
				</a>
					<ul class="sub">
						<li><a href="system_Account.jsp">账户管理</a></li>
						<li><a href="system_Password.jsp">密码修改</a></li>
						<li><a href="system_Role.jsp">角色管理</a></li>
					</ul></li>


			</ul>
		</div>

	</div>
	</aside> <section id="main-content"> <section class="wrapper">



	<table border="0" width="100%">
		<tr>
			<td>
				<table class="table" style="text-align: center; font-size: 6">
					<thead>
						<tr>
							<td colspan="8" align="center"><font color="black"><h2>账号详情</h2></font></td>
						</tr>
						<tr>
							<td align="right"><font color="black">姓名:</font></td>
							<td align="left"><font color="black">${member.member_name }</font></td>
							<td align="right"><font color="black">用户名:</font></td>
							<td align="left"><font color="black">${member.name }</font></td>
							<td align="right"><font color="black">电话:</font></td>
							<td align="left"><font color="black">${member.mobile_Phone }</font></td>
							<td align="right"><font color="black">身份证:</font></td>
							<td align="left"><font color="black">${member.identity }</font></td>
						</tr>
						<tr>
							<td align="right"><font color="black">创建时间:</font></td>
							<td align="left"><font color="black">${member.create_date }</font></td>
							<td align="right"><font color="black">邀请码:</font></td>
							<td align="left"><font color="black">${member.invitationCode }</font></td>
							<td align="right"><font color="black">被邀请码:</font></td>
							<td align="left"><font color="black">${member.invitedCode }</font></td>
							<td></td>
							<td></td>
						</tr>
					</thead>
				</table>
			</td>
		</tr>
	</table>

	<table width="100%" border="0">
		<tr>
			<td>
				<table class="table" style="text-align: center; font-size: 6">
					<tr>
						<td colspan="8" align="center">><font color="black"><h2>账户详情</h2></font></td>
					</tr>
					<tr>
						<td align="right"><font color="black">姓名:</font></td>
						<td align="left"><font color="black">${member_account.member.member_name }</font></td>
						<td align="right"><font color="black">可用余额:</font></td>
						<td align="left"><font color="black">${member_account.useable_balance }</font></td>
						<td align="right"><font color="black">冻结金额:</font></td>
						<td align="left"><font color="black">${member_account.imuseale_balance }</font></td>
						<td align="right"><font color="black">累计收益:</font></td>
						<td align="left"><font color="black">${member_account.total_profit }</font></td>
					</tr>
					<tr>
						<td align="right"><font color="black">创建时间:</font></td>
						<td align="left"><font color="black">${member_account.create_date }</font></td>
						<td align="right"><font color="black">红包金额:</font></td>
						<td align="left"><font color="black">${member_account.bonus_amount }</font></td>
						<td align="right"><font color="black">投资总额:</font></td>
						<td align="left"><font color="black">${member_account.invest_amount }</font></td>
						<td align="right"><font color="black">体验金:</font></td>
						<td align="left"><font color="black">${member_account.bbin_amount }</font></td>
					</tr>
				</table>
			</td>

		</tr>
	</table>
	<table width="100%">
		<tr>
			<td>
				<table class="table" style="text-align: center; font-size: 6">
					<tr>
						<td colspan="8" align="center">><font color="black"><h2>理财师详情</h2></font></td>
					</tr>
					<tr>
						<td align="right"><font color="black">真实姓名:</font></td>
						<td align="left"><font color="black">${finan.member.member_name }</font></td>
						<td align="right"><font color="black">机构名称:</font></td>
						<td align="left"><font color="black">${finan.orgname }</font></td>

						<!-- <td align="right"><font color="black">我的名片:</font></td>
						<td align="left"><font color="black">${finan.mycard }</font></td> -->
						<td align="right"><font color="black">邮寄地址:</font></td>
						<td align="left"><font color="black">${finan.address }</font></td>
						<td align="right"><font color="black">添加时间:</font></td>
						<td align="left"><font color="black">${finan.create_date }</font></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<table width="100%" border="0">
		<tr>
			<td>
				<table class="table" style="text-align: center; font-size: 6">
					<thead>
						<tr>
							<td colspan="7" align="center">><font color="black"><h2>投资详情</h2></font></td>
						</tr>
						<tr align="center">
							<td align="center"><font color="black">序号</font></td>
							<td><font color="black">投资编号</font></td>
							<td><font color="black">投资金额</font></td>
							<td><font color="black">投资状态</font></td>
							<td><font color="black">投资标名称</font></td>
							<td><font color="black">投资收益</font></td>
							<td><font color="black">投资时间</font></td>
						</tr>
					</thead>
					<c:forEach items="${member_subject }" var="su" varStatus="status">
						<tr>
							<td><font color="black">${status.index+1 }</font></td>
							<td><font color="black">${su.id }</font></td>
							<td><font color="black">${su.amount }</font></td>
							<td>
								<c:if test="${su.subject.status==0 }">
									<font color="black">未发布</font>	
								</c:if>
								<c:if test="${su.subject.status==1 }">
									<font color="black">募集中</font>	
								</c:if>
								<c:if test="${su.subject.status==2 }">
									<font color="black">募集结束</font>
								</c:if>
								</td>
							<td><font color="black">${su.subject.name }</font></td>
							<td><font color="black"><fmt:formatNumber type="number" value="${((su.amount*(su.subject.year_rate/100))/365)*su.subject.period }"
										pattern="0.00" maxFractionDigits="2"></fmt:formatNumber></font></td>
							<td><font color="black">${su.create_date }</font></td>
						</tr>
					</c:forEach>
				</table>
			</td>
		</tr>
	</table>
	<table width="100%" border="0">
		<tr>
			<td>
				<table class="table" style="text-align: center; font-size: 6">
					<tr>
						<td colspan="7" align="center">><font color="black"><h2>提现详情</h2></font></td>
					</tr>
					<tr>
						<td><font color="black">序号</font></td>
						<td><font color="black">提现编号</font></td>
						<td><font color="black">提现金额</font></td>
						<td><font color="black">提现状态</font></td>
						<td><font color="black">提现银行</font></td>
						<td><font color="black">提现卡号</font></td>
						<td><font color="black">提现时间</font></td>
					</tr>
					<c:forEach items="${member_withdraw }" var="with" varStatus="status">
						<tr>
							<td><font color="black">${status.index+1 }</font></td>
							<td><font color="black">${with.id }</font></td>
							<td><font color="black">${with.amount }</font></td>
							<td><c:if test="${with.status==0 }">
									<font color="red">待审核</font>
								</c:if> <c:if test="${with.status==1 }">
									<font color="green">已打款</font>
								</c:if> <c:if test="${with.status==2 }">
									<font color="red">打款中</font>
								</c:if> <c:if test="${with.status==3 }">
									<font color="red">打款失败</font>
								</c:if></td>
							<td><font color="black">${with.bank_name }</font></td>
							<td><font color="black">${with.bank_card }</font></td>
							<td><font color="black">${with.create_date }</font></td>
						</tr>
					</c:forEach>
				</table>
			</td>
		</tr>
	</table>

	<table width="100%" border="0">
		<tr>
			<td>
				<table class="table" style="text-align: center; font-size: 6">
					<tr>
						<td colspan="7" align="center">><font color="black"><h2>充值详情</h2></font></td>
					</tr>
					<tr>
						<td><font color="black">序号</font></td>
						<td><font color="black">充值编号</font></td>
						<td><font color="black">充值金额</font></td>
						<td><font color="black">充值状态</font></td>
						<td><font color="black">充值渠道</font></td>
						<td><font color="black">充值渠道编号</font></td>
						<td><font color="black">充值时间</font></td>
					</tr>
					<c:forEach items="${member_deposit }" var="depo" varStatus="status">
						<tr>
							<td><font color="black">${status.index+1 }</font></td>
							<td><font color="black">${depo.id }</font></td>
							<td><font color="black">${depo.amount }</font></td>
							<td><c:if test="${depo.status==0 }">
									<font color="red">充值失败</font>
								</c:if> <c:if test="${depo.status==1 }">
									<font color="green">充值成功</font>
								</c:if></td>
							<td><font color="black">${depo.pay_channel_name }</font></td>
							<td><font color="black">${depo.pay_channel_order_no }</font></td>
							<td><font color="black">${depo.create_date }</font></td>
						</tr>
					</c:forEach>
				</table>
			</td>
		</tr>
	</table>
	<table width="100%" border="0">
		<tr>
			<td>
				<table class="table" style="text-align: center; font-size: 6">
					<tr>
						<td colspan="7" align="center"><font color="black" size="7">交易详情</font></td>
					</tr>
					<tr>
						<td><font color="black">序号</font></td>
						<td><font color="black">交易编号</font></td>
						<td><font color="black">交易金额</font></td>
						<td><font color="black">交易状态</font></td>
						<td><font color="black">交易分类</font></td>
						<td><font color="black">交易名称</font></td>
						<td><font color="black">交易时间</font></td>
					</tr>
					<c:forEach items="${member_trade }" var="trade" varStatus="status">
						<tr>
							<td><font color="black">${status.index+1 }</font></td>
							<td><font color="black">${trade.id }</font></td>
							<td><font color="black">${trade.amount }</font></td>
							<td><c:if test="${trade.trade_status==0 }">
									<font color="green">交易成功</font>
								</c:if> <c:if test="${trade.trade_status==2 }">
									<font color="red">交易失败</font>
								</c:if></td>
							<td><font color="black">${trade.trade_type }</font></td>
							<td><font color="black">${trade.trade_name }</font></td>
							<td><font color="black">${trade.create_date }</font></td>
						</tr>
					</c:forEach>
				</table>
			</td>
		</tr>
	</table>


	</section> <!-- footer --> <!-- / footer --> </section> <script src="/YJLC_E/js/bootstrap.js"></script> <script src="/YJLC_E/js/jquery.dcjqaccordion.2.7.js"></script> <script
		src="/YJLC_E/js/scripts.js"></script> <script src="/YJLC_E/js/jquery.slimscroll.js"></script> <script src="/YJLC_E/js/jquery.nicescroll.js"></script>
	<!--[if lte IE 8]><script language="javascript" type="text/javascript" src="js/flot-chart/excanvas.min.js"></script><![endif]--> <script
		src="/YJLC_E/js/jquery.scrollTo.js"></script>
</body>
</html>