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

</head>
<script type="text/javascript">
		$(function(){
		 	    $("#MH_status").val("${MH_status}");
		});
		function fun(id){
			$.messager.confirm("修改","确认修改吗？",function(msg){
				if(msg){
					location="themeServlet?state=update_themeIsTop&themeId="+themeId+"&themeSign="+value+"&classId="+classId;
				}
			});  
		}
	</script>
<body>
	<section id="container"> <!--header start--> <header class="header fixed-top clearfix"> <!-- logo start-->
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
				<li><a href="index.html"> <i class="fa fa-dashboard"></i> <span>Dashboard</span>
				</a></li>

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
						<li><a href="/YJLC_E/listMember_deposit_record">充值管理</a></li>
						<li><a class="active" href="/YJLC_E/listMember_withdraw">体现管理</a></li>
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
	<h1 align="left">提现管理</h1>
	<hr>
	<br>
	<form action="/YJLC_E/listMember_withdraw" method="post">
		<table width="90%" align="center" class="table">
			<tr>
				<td align="right"><font class="text-info" size="4">姓名:</font></td>
				<td align="left"><input type="text" name="MH_member_name" class="form-control" value="${MH_member_name }"></td>
				<td align="right"><font class="text-info" size="4">手机号:</font></td>
				<td align="left"><input type="text" name="MH_mobile_Phone" class="form-control" value="${MH_mobile_Phone }"></td>
				<td align="right"><font class="text-info" size="4">绑卡卡号:</font></td>
				<td align="left"><input type="text" name="MH_bank_card" value="${MH_bank_card }" class="form-control"></td>
				<td></td>
				<td></td>

			</tr>
			<tr>
				<td align="right"><font class="text-info" size="4">状态:</font></td>
				<td><select name="MH_status" id="MH_status" class="form-control">
						<option value="-1">请选择</option>
						<option value="0">待申请</option>
						<option value="1">已打款</option>
						<option value="2">打款中</option>
						<option value="3">打款失败</option>
				</select></td>
				<td align="right"><font class="text-info" size="4">提现时间:</font></td>
				<td align="left"><input type="date" name="MH_QDate" class="form-control" value="${MH_QDate }"></td>
				<td align="right"><font class="text-info" size="4">提现时间:</font></td>
				<td align="left"><input type="date" name="MH_HDate" value="${MH_HDate }" class="form-control"></td>
				<td><input type="submit" class="btn btn-info" value="查 询"></td>
			</tr>
		</table>
	</form>
	<br>
	<hr>
	<br>
	<table width="100%" border="1">
		<tr align="center">
			<td>序号</td>
			<td>手机号</td>
			<td>姓名</td>
			<td>身份证</td>
			<td>提现金额</td>
			<td>提现银行</td>
			<td>提现卡号</td>
			<td>提现开户行地址</td>
			<td>提现状态</td>
			<td>提现时间</td>
			<td>审 核</td>
			<td>账号详情</td>
		</tr>
		<c:forEach items="${member_withdraw }" var="member_with" varStatus="status">
			<tr align="center">
				<td>${status.index+1 }</td>
				<td>${member_with.member.mobile_Phone }</td>
				<td>${member_with.member.member_name }</td>
				<td>${member_with.member.identity}</td>
				<td>${member_with.amount }</td>
				<td>${member_with.bank_name }</td>
				<td>${member_with.bank_card }</td>
				<td>${member_with.cardaddress }</td>
				<td><c:if test="${member_with.status==0 }">
						<font color="red">待审核</font>
					</c:if> <c:if test="${member_with.status==1 }">
						<font color="green">已打款</font>
					</c:if> <c:if test="${member_with.status==2 }">
						<font color="green">打款中</font>
					</c:if> <c:if test="${member_with.status==3 }">
						<font color="red">打款失败</font>
					</c:if></td>
				<td>${member_with.create_date }</td>
				<td><c:if test="${member_with.status==0 }">
						<button class="btn btn-primary btn-lg" data-toggle="modal" onclick="myButtion(${member_with.id})">审核</button>
					</c:if> <c:if test="${member_with.status==1 }">
						<font color="green">已打款</font>
					</c:if> <c:if test="${member_with.status==2 }">
						<font color="green">打款中</font>
					</c:if> <c:if test="${member_with.status==3 }">
						<font color="red">打款失败</font>
					</c:if></td>
				<td><a href="/YJLC_E/getMember/${member_with.member.id}"  class="btn btn-info"><b>账号详情</b> </a></td>
			</tr>
		</c:forEach>

	</table>

	<!-- 模态框（Modal） -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">审核</h4>
				</div>
				<div class="modal-body">
					<select>
						<option>富有</option>
						<option>呗付</option>
					</select>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="up">提交更改</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
	</div>
	<script>
 
 		function myButtion(id){ 			
 			$('#myModal').modal('show');
 			$("#up").click(function(){
 				location="/YJLC_E/update_with/"+id;
 			});
 			
 		}
 		

</script> </section> </section> <script src="/YJLC_E/js/bootstrap.js"></script> <script src="/YJLC_E/js/jquery.dcjqaccordion.2.7.js"></script> <script src="/YJLC_E/js/scripts.js"></script>
	<script src="/YJLC_E/js/jquery.slimscroll.js"></script> <script src="/YJLC_E/js/jquery.nicescroll.js"></script> <!--[if lte IE 8]><script language="javascript" type="text/javascript" src="js/flot-chart/excanvas.min.js"></script><![endif]-->
	<script src="/YJLC_E/js/jquery.scrollTo.js"></script> </section>
</body>