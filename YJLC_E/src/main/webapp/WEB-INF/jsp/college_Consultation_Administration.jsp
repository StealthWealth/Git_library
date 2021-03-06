<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>Typography</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); }
</script>
<!-- bootstrap-css -->
<link rel="stylesheet" href="/YJLC_E/css/bootstrap.min.css">
<!-- //bootstrap-css -->
<!-- Custom CSS -->
<link href="/YJLC_E/css/style.css" rel='stylesheet' type='text/css' />
<link href="/YJLC_E/css/style-responsive.css" rel="stylesheet" />
<!-- font CSS -->
<link
	href='http://fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900,900italic'
	rel='stylesheet' type='text/css'>
<!-- font-awesome icons -->
<link href="/YJLC_E/css/font-awesome.css" rel="stylesheet">
<!-- //font-awesome icons -->
<script src="/YJLC_E/js/jquery2.0.3.min.js"></script>
</head>
<style type="text/css">
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
			<li class="dropdown"><a data-toggle="dropdown" class="dropdown-toggle" href="#"> <img alt=""
					src="images/2.png"> <span class="username"></span>
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
				<li class="sub-menu"><a class="active" href="javascript:;"> <i class="fa fa-th"></i> <span>学院管理</span>
				</a>
					<ul class="sub">
						<li><a class="active" href="/YJLC_E/listNews">资讯管理</a></li>
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

	</div>
	</aside> <section id="main-content"> <section class="wrapper">
	<font size="6">咨询管理</font>
	<hr>
	<br>
	<form action="/YJLC_E/listNews" method="post">
		<table width="50%" align="center" >
			<tr>
				<td align="right"><font class="text-info" size="4">标题:</font></td>
				<td align="left" width="200"><input type="text" name="MH_title" value="${MH_title }" class="form-control"></td>
				<td align="right"><font class="text-info" size="4">类别:</font></td>
				<td align="left" width="200"><select name="type_name" id="type_name" class="form-control">
						<option value="-1">请选择</option>
						<c:forEach items="${listNews_type }" var="t">
							<option value=${t.id }>${t.name }</option>
						</c:forEach>
				</select></td>
				<td align="center">&nbsp;<input type="submit" value="查  询" class="btn btn-info"></td>
			</tr>
		</table>
	</form>
	<br>
	<div align="right">
		<button class="btn btn-primary btn-lg" data-toggle="modal" onclick="addCollege()">添 加</button>
	</div>
	<table width="100%" border="1">
		<tr align="center">
			<td width="100" align="center">序号</td>
			<td width="10%" align="center">标题</td>
			<td width="100" align="center">副标题</td>
			<td width="10%" align="center">简介</td>
			<td width="100" align="center">类别</td>
			<td>封面</td>
			<td width="100" align="center">作者</td>
			<td width="100" align="center">来源</td>
			<td width="100" align="center">点击数量</td>
			<td width="100" align="center">是否置顶</td>
			<td width="100" align="center">是否推荐</td>
			<td width="100" align="center">是否审核</td>
			<td width="170" align="center">添加时间</td>
			<td width="100">操 作</td>
		</tr>
		<c:forEach items="${listNews }" var="news" varStatus="status">
			<tr align="center">
				<td>${status.index+1 }</td>
				<td>${news.title }</td>
				<td>${news.subTitle }</td>
				<td>${news.info }</td>
				<td>${news.news_type.name }</td>
				<td width="80"><img src="/YJLC_E/${news.cPhoto }" width="80px" height="100"></td>
				<td>${news.author }</td>
				<td>${news.source }</td>
				<td>${news.clickNumber }</td>
				<td><c:if test="${news.placTop==1 }">
							是
						</c:if> <c:if test="${news.placTop==0 }">
							否
						</c:if></td>
				<td><c:if test="${news.recommend==1 }">
								是
							</c:if> <c:if test="${news.recommend==0 }">
							 否
							</c:if></td>
				<td><c:if test="${news.audit==1 }">
								是
							</c:if> <c:if test="${news.audit==0 }">
								否
							</c:if></td>
				<td>${news.addTime }</td>
				<td><a class="btn btn-info" href="/YJLC_E/delete/${news.id }"><b>删 除</b></a> <a class="btn btn-info" href="/YJLC_E/updateNews/${news.id }"><b>修
							改</b></a></td>
			</tr>
		</c:forEach>
	</table>

	<script type="text/javascript">
		var type = $("#type_name").val("${type_name}")
		if (type.val() == null) {
			$("#type_name").val("-1");
		} else {
			$("#type_name").val("${type_name}")
		}

		function addCollege() {
			location = "/YJLC_E/getAddCollege";
		}
	</script> </section> <!-- footer --> <!-- / footer --> </section> <script src="/YJLC_E/js/bootstrap.js"></script> <script
		src="/YJLC_E/js/jquery.dcjqaccordion.2.7.js"></script> <script src="/YJLC_E/js/scripts.js"></script> <script
		src="/YJLC_E/js/jquery.slimscroll.js"></script> <script src="/YJLC_E/js/jquery.nicescroll.js"></script> <!--[if lte IE 8]><script language="javascript" type="text/javascript" src="js/flot-chart/excanvas.min.js"></script><![endif]-->
	<script src="/YJLC_E/js/jquery.scrollTo.js"></script>
</body>
</html>