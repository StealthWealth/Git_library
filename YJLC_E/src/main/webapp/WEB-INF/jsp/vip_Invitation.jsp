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
<script type="text/javascript">
		$(function(){
			$("#MH_isAward_Zhu").val("${MH_isAward_Zhu}");
			$("#MH_isAward_Tou").val("${MH_isAward_Tou}");
		});
	</script>

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
						<li><a class="active" href="/YJLC_E/listAward_records">邀请管理</a></li>
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
		<!-- sidebar menu end-->
	</div>
	</aside> <section id="main-content"> <section class="wrapper">
	<form action="/YJLC_E/listAward_records" method="post">
		<h1 align="left">邀请管理</h1>
		<hr>
		<br>
		<table width="100%" class="table">
			<tr>
				<td align="right"><font class="text-info" size="4">姓名:</font></td>
				<td align="left"><input type="text" class="form-control" name="MH_member_name" value="${MH_member_name }" id="MH_member_name"></td>
				<td align="right"><font class="text-info" size="4">手机号:</font></td>
				<td align="left"><input type="text" name="MH_mobile_Phone" class="form-control" value="${MH_mobile_Phone }" id="MH_mobile_Phone"></td>
				<td align="right"><font class="text-info" size="4">邀请码:</font></td>
				<td align="left"><input type="text" class="form-control" name="MH_invitationCode" value="${MH_invitationCode }" id="MH_invitationCode"></td>
				<td></td>
			</tr>
			<tr>
				<td align="right"><font class="text-info" size="4">被邀请码:</font></td>
				<td align="left"><input type="text" name="MH_invitedCode" class="form-control" value="${MH_invitedCode }" id="MH_invitedCode"></td>
				<td align="right"><font class="text-info" size="4">是否已注册奖励:</font></td>
				<td align="left"><select name="MH_isAward_Zhu" id="MH_isAward_Zhu" class="form-control">
						<option value="-1" selected="selected">请选择</option>
						<option value="已注册奖励">是</option>
						<option value="未注册奖励">否</option>
				</select></td>
				<td align="right"><font class="text-info" size="4">是否已投资奖励:</font></td>
				<td align="left"><select name="MH_isAward_Tou" id="MH_isAward_Tou" class="form-control">
						<option value="-1" selected="selected">请选择</option>
						<option value="已投资奖励">是</option>
						<option value="未投资奖励">否</option>
				</select></td>
				<td><input type="submit" class="btn btn-info" value="查 询"></td>
			</tr>
		</table>
	</form>
	<br>
	<table width="100%" border="1">
		<tr align="center">
			<td>序号</td>
			<td>手机号</td>
			<td>姓名</td>
			<td>邀请码</td>
			<td>被邀请码</td>
			<td>被邀请人姓名</td>
			<td>奖励金额</td>
			<td>注册奖励</td>
			<td>投资奖励</td>
			<td>注册时间</td>
			<td>奖励记录</td>
		</tr>
		<c:forEach items="${award_records }" var="award" varStatus="status">
			<tr align="center">
				<td>${status.index+1 }</td>
				<td>${award.mobile_Phone }</td>
				<td>${award.member_name }</td>
				<td>${award.invitationCode }</td>
				<td>${award.invitedCode }</td>
				<td><c:forEach items="${listMember_Name }" var="m_name">
						<c:if test="${award.byinvitingid==m_name.id }">
									${m_name.member_name }
								</c:if>
					</c:forEach></td>
				<td>${award.amount }</td>
				<td>${award.enroll }</td>
				<td>${award.invest }</td>
				<td>${award.create_date }</td>
				<td><c:if test="${award.enroll=='已注册奖励' && award.invest=='已投资奖励' }">
						<a href="/YJLC_E//reward_record/${award.byinvitingid}"  class="btn btn-info">奖励记录</a>
					</c:if>
					<c:if test="${award.enroll!='已注册奖励' || award.invest!='已投资奖励' }">
						<a  class="btn btn-info disabled">奖励记录</a>
					</c:if>
					</td>
			</tr>
		</c:forEach>
	</table>
	</section> </section> <script src="/YJLC_E/js/bootstrap.js"></script> <script src="/YJLC_E/js/jquery.dcjqaccordion.2.7.js"></script> <script src="/YJLC_E/js/scripts.js"></script>
	<script src="/YJLC_E/js/jquery.slimscroll.js"></script> <script src="/YJLC_E/js/jquery.nicescroll.js"></script> <!--[if lte IE 8]><script language="javascript" type="text/javascript" src="js/flot-chart/excanvas.min.js"></script><![endif]-->
	<script src="/YJLC_E/js/jquery.scrollTo.js"></script>
</body>
</html>