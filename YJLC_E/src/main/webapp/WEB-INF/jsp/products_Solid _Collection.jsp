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
<link rel="stylesheet" href="/YJLC_E/css/layui.css" media="all">
<script src="/YJLC_E/js/jquery2.0.3.min.js"></script>
<script src="/YJLC_E/js/layui.js" charset="utf-8"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#btn1").click(function(){
			document.forms[0].action="/YJLC_E/subject/listsubject";
			document.forms[0].submit();
		});
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

				<li class="sub-menu"><a class="active" href="javascript:;"> <i class="fa fa-book"></i> <span>理财产品</span>
				</a>
					<ul class="sub">
						<li><a class="active" href="/YJLC_E/subject/listsubject">固收类/P2P</a></li>
						<li><a href="/YJLC_E/funds/listfunds">私募/股权类</a></li>
						<li><a href="/YJLC_E/config/listconfig">海外配置</a></li>
					</ul></li>
				<li class="sub-menu"><a href="javascript:;"> <i class="fa fa-th"></i> <span>学院管理</span>
				</a>
					<ul class="sub">
						<li><a href="/YJLC_E/listNews">资讯管理</a></li>
						<li><a href="/YJLC_E/listnewstype">资讯分类</a></li>
					</ul></li>
				<li class="sub-menu"><a href="javascript:;"> <i class="fa fa-th"></i> <span>会员管理</span>
				</a>
					<ul class="sub">
						<li><a href="/YJLC_E/listAuditingAll">账号管理</a></li>
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
		<!-- sidebar menu end-->
	</div>
	</aside> <section id="main-content"> <section class="wrapper">

	<div align="center">
		<form method="post">
			名称：<input type="text" name="qname" value="" />&nbsp; 状态：<select name="wname">
				<option value="">全部</option>
				<option value="0">未发布</option>
				<option value="1">募集中</option>
				<option value="2">已结束</option>
			</select>&nbsp; 类别：<select name="ename">
				<option value="">全部</option>
				<option value="0">固收类</option>
				<option value="1">P2P车贷</option>
				<option value="2">P2P房贷</option>
			</select> <input class="layui-btn layui-btn-small layui-btn-normal" type="button" id="btn1" value="查询" /> <a
				class="layui-btn layui-btn-small layui-btn-normal" href="/YJLC_E/subject/addsubject">新增</a>
			<table width="100%" border="1">
				<tr>
					<td>序号</td>
					<td>ID</td>
					<td>合同编号</td>
					<td>类型</td>
					<td>名称</td>
					<td>标的总金额</td>
					<td>已投总金额</td>
					<td>投资期限</td>
					<td>起投金额</td>
					<td>年化收益</td>
					<td>状态</td>
					<td>可使用体验金</td>
					<td>添加时间</td>
					<td>操作</td>
				</tr>
				<c:forEach items="${listsubject }" var="subject" varStatus="num">
					<tr>
						<td>${num.index+1 }</td>
						<td>${subject.id }</td>
						<td>${subject.serial_no }</td>
						<c:if test="${subject.type==0 }">
							<td>固收类</td>
						</c:if>
						<c:if test="${subject.type==1 }">
							<td>P2P车贷</td>
						</c:if>
						<c:if test="${subject.type==2 }">
							<td>P2P房贷</td>
						</c:if>
						<td>${subject.name }</td>
						<td>￥${subject.amount }</td>
						<td><script type="text/javascript">
							var id = '${subject.id}';
							$.ajaxSetup({
								async:false
							});
							var num1 = 0;
							$.post("/YJLC_E/subject/getTotalMoney",{id:id},function(data){
								num1=data
							});
							document.write("￥"+num1);
						</script></td>
						<td>${subject.period }天</td>
						<td>${subject.floor_amount }元</td>
						<td>${subject.year_rate }%</td>
						<c:if test="${subject.status==0 }">
							<td>未发布</td>
						</c:if>
						<c:if test="${subject.status==1 }">
							<td>募集中</td>
						</c:if>
						<c:if test="${subject.status==2 }">
							<td>已结束</td>
						</c:if>
						<c:if test="${subject.exper_status==0 }">
							<td>否</td>
						</c:if>
						<c:if test="${subject.exper_status==1 }">
							<td>是</td>
						</c:if>
						<td>${subject.create_date }</td>
						<td><a class="layui-btn layui-btn-small layui-btn-normal" href="/YJLC_E/subject/editsubject/${subject.id }">编辑/查看</a> <a
							class="layui-btn layui-btn-small layui-btn-normal" href="/YJLC_E/subject/listrecord/${subject.id }">查看投资</a></td>
					</tr>
				</c:forEach>
			</table>
		</form>
	</div>

	</section> <!-- footer --> <!-- / footer --> </section> <script src="/YJLC_E/js/bootstrap.js"></script> <script src="/YJLC_E/js/jquery.dcjqaccordion.2.7.js"></script> <script
		src="/YJLC_E/js/scripts.js"></script> <script src="/YJLC_E/js/jquery.slimscroll.js"></script> <script src="/YJLC_E/js/jquery.nicescroll.js"></script>
	<!--[if lte IE 8]><script language="javascript" type="text/javascript" src="js/flot-chart/excanvas.min.js"></script><![endif]--> <script
		src="/YJLC_E/js/jquery.scrollTo.js"></script>
</body>
</html>