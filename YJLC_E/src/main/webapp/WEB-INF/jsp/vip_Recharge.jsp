<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Typography</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
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
<script type="text/javascript">
	$(function(){
			$("#MH_status").val("${MH_status}");	
	});

</script>
</head>
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
						<li><a href="/YJLC_E/listAuditingAll">账号管理</a></li>
						<li><a href="/YJLC_E/listMember_Bankcards">绑卡管理</a></li>
						<li><a href="/YJLC_E/listAward_records">邀请管理</a></li>
						<li><a href="/YJLC_E/listSubject">付息计划</a></li>
						<li><a class="active" href="/YJLC_E/listMember_deposit_record">充值管理</a></li>
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
		<!-- sidebar menu end-->
	</div>
	</aside> <section id="main-content"> <section class="wrapper">
	<form action="/YJLC_E/listMember_deposit_record" method="post">
		<table width="100%" align="center" class="table">
			<tr>
				<th align="right"><font class="text-info" size="4">订单编号:</font></th>
				<th align="left"><input type="text" name="MH_serial_number" class="form-control" value="${MH_serial_number }"></th>
				<th align="right"><font class="text-info" size="4">手机号:</font></th>
				<th align="left"><input type="text" name="MH_mobile_Phone" value="${MH_mobile_Phone }" class="form-control"></th>
				<th align="right"><font class="text-info" size="4">订单状态:</font></th>
				<th align="left"><select name="MH_status" id="MH_status" class="form-control">
						<option value="2" selected="selected">请选择</option>
						<option value="0">充值失败</option>
						<option value="1">充值成功</option>
				</select></th>
				<th align="right"><font class="text-info" size="4">充值渠道订单号:</font></th>
				<th align="left"><input type="text" name="MH_pay_channel_order_no" value="${MH_pay_channel_order_no }" class="form-control"></th>
			</tr>
			<tr>
				<th align="right"><font class="text-info" size="4">订单时间前:</font></th>
				<th align="left"><input type="date" name="MH_QDate" value="${MH_QDate }" class="form-control"></th>
				<th></th>
				<th></th>
				<th></th>
				<th></th>
				<th><font class="text-info" size="4">订单时间后:</font></th>
				<th><input type="date" name="MH_HDate" value="${MH_HDate }" class="form-control"></th>
				<th><input type="submit" class="btn btn-info" value="查 询"></th>
			</tr>
		</table>

	</form>
	<br>
	<hr>
	<br>
	<div align="right" style="width: 100%;">
		<a href="/YJLC_E/listMember_deposit_record">更新列表</a>
	</div>
	<table width="100%" align="center" border="1">
		<tr align="center">
			<td>序号</td>
			<td>订单编号</td>
			<td>手机号</td>
			<td>订单金额</td>
			<td>订单状态</td>
			<td>充值渠道</td>
			<td>充值渠道订单号</td>
			<td>订单时间</td>
		</tr>
		<c:forEach items="${member_deposit_record }" var="member" varStatus="status">
			<tr align="center">
				<td>${status.index+1 }</td>
				<td>${member.serial_number }</td>
				<td>${member.member.mobile_Phone }</td>
				<td>${member.amount }</td>
				<td><c:if test="${member.status==0 }">
						<font color="red">充值失败</font>
					</c:if> <c:if test="${member.status==1 }">
						<font color="green">充值成功</font>
					</c:if></td>
				<td>${member.pay_channel_name }</td>
				<td>${member.pay_channel_order_no }</td>
				<td>${member.create_date }</td>
			</tr>
		</c:forEach>
	</table>

	</section> </section> <script src="/YJLC_E/js/bootstrap.js"></script> <script src="/YJLC_E/js/jquery.dcjqaccordion.2.7.js"></script> <script src="/YJLC_E/js/scripts.js"></script>
	<script src="/YJLC_E/js/jquery.slimscroll.js"></script> <script src="/YJLC_E/js/jquery.nicescroll.js"></script> <!--[if lte IE 8]><script language="javascript" type="text/javascript" src="js/flot-chart/excanvas.min.js"></script><![endif]-->
	<script src="/YJLC_E/js/jquery.scrollTo.js"></script>
</body>