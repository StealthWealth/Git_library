<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
<link
	href='http://fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900,900italic'
	rel='stylesheet' type='text/css'>
<!-- font-awesome icons -->
<link href="/YJLC_E/css/font-awesome.css" rel="stylesheet">
<!-- //font-awesome icons -->
<script src="/YJLC_E/js/jquery2.0.3.min.js"></script>
<script type="text/javascript" src="/YJLC_E/js/ueditor.config.js"></script>
<script type="text/javascript" src="/YJLC_E/js/ueditor.all.min.js"></script>
<script type="text/javascript" src="/YJLC_E/js/zh-cn.js"></script>
</head>
<style type="text/css">

</style>
<body>
	<section id="container"> <!--header start--> <header
		class="header fixed-top clearfix"> <!--logo start-->
	<div class="brand">

		<a href="index.jsp" class="logo"> VISITORS </a>
		<div class="sidebar-toggle-box">
			<div class="fa fa-bars"></div>
		</div>
	</div>
	<!--logo end-->

	<div class="nav notify-row" id="top_menu">
		<!--  notification start -->
		<ul class="nav top-menu">
			<!-- settings start -->
			<li class="dropdown"><a data-toggle="dropdown"
				class="dropdown-toggle" href="#"> <i class="fa fa-tasks"></i> <span
					class="badge bg-success">8</span>
			</a>
				<ul class="dropdown-menu extended tasks-bar">
					<li>
						<p class="">You have 8 pending tasks</p>
					</li>
					<li><a href="#">
							<div class="task-info clearfix">
								<div class="desc pull-left">
									<h5>Target Sell</h5>
									<p>25% , Deadline 12 June’13</p>
								</div>
								<span class="notification-pie-chart pull-right"
									data-percent="45"> <span class="percent"></span>
								</span>
							</div>
					</a></li>
					<li><a href="#">
							<div class="task-info clearfix">
								<div class="desc pull-left">
									<h5>Product Delivery</h5>
									<p>45% , Deadline 12 June’13</p>
								</div>
								<span class="notification-pie-chart pull-right"
									data-percent="78"> <span class="percent"></span>
								</span>
							</div>
					</a></li>
					<li><a href="#">
							<div class="task-info clearfix">
								<div class="desc pull-left">
									<h5>Payment collection</h5>
									<p>87% , Deadline 12 June’13</p>
								</div>
								<span class="notification-pie-chart pull-right"
									data-percent="60"> <span class="percent"></span>
								</span>
							</div>
					</a></li>
					<li><a href="#">
							<div class="task-info clearfix">
								<div class="desc pull-left">
									<h5>Target Sell</h5>
									<p>33% , Deadline 12 June’13</p>
								</div>
								<span class="notification-pie-chart pull-right"
									data-percent="90"> <span class="percent"></span>
								</span>
							</div>
					</a></li>

					<li class="external"><a href="#">See All Tasks</a></li>
				</ul></li>
			<!-- settings end -->
			<!-- inbox dropdown start-->
			<li id="header_inbox_bar" class="dropdown"><a
				data-toggle="dropdown" class="dropdown-toggle" href="#"> <i
					class="fa fa-envelope-o"></i> <span class="badge bg-important">4</span>
			</a>
				<ul class="dropdown-menu extended inbox">
					<li>
						<p class="red">You have 4 Mails</p>
					</li>
					<li><a href="#"> <span class="photo"><img
								alt="avatar" src="/YJLC_E/images/3.png"></span> <span class="subject">
								<span class="from">Jonathan Smith</span> <span class="time">Just
									now</span>
						</span> <span class="message"> Hello, this is an example msg. </span>
					</a></li>
					<li><a href="#"> <span class="photo"><img
								alt="avatar" src="/YJLC_E/images/1.png"></span> <span class="subject">
								<span class="from">Jane Doe</span> <span class="time">2
									min ago</span>
						</span> <span class="message"> Nice admin template </span>
					</a></li>
					<li><a href="#"> <span class="photo"><img
								alt="avatar" src="/YJLC_E/images/3.png"></span> <span class="subject">
								<span class="from">Tasi sam</span> <span class="time">2
									days ago</span>
						</span> <span class="message"> This is an example msg. </span>
					</a></li>
					<li><a href="#"> <span class="photo"><img
								alt="avatar" src="/YJLC_E/images/2.png"></span> <span class="subject">
								<span class="from">Mr. Perfect</span> <span class="time">2
									hour ago</span>
						</span> <span class="message"> Hi there, its a test </span>
					</a></li>
					<li><a href="#">See all messages</a></li>
				</ul></li>
			<!-- inbox dropdown end -->
			<!-- notification dropdown start-->
			<li id="header_notification_bar" class="dropdown"><a
				data-toggle="dropdown" class="dropdown-toggle" href="#"> <i
					class="fa fa-bell-o"></i> <span class="badge bg-warning">3</span>
			</a>
				<ul class="dropdown-menu extended notification">
					<li>
						<p>Notifications</p>
					</li>
					<li>
						<div class="alert alert-info clearfix">
							<span class="alert-icon"><i class="fa fa-bolt"></i></span>
							<div class="noti-info">
								<a href="#"> Server #1 overloaded.</a>
							</div>
						</div>
					</li>
					<li>
						<div class="alert alert-danger clearfix">
							<span class="alert-icon"><i class="fa fa-bolt"></i></span>
							<div class="noti-info">
								<a href="#"> Server #2 overloaded.</a>
							</div>
						</div>
					</li>
					<li>
						<div class="alert alert-success clearfix">
							<span class="alert-icon"><i class="fa fa-bolt"></i></span>
							<div class="noti-info">
								<a href="#"> Server #3 overloaded.</a>
							</div>
						</div>
					</li>

				</ul></li>
			<!-- notification dropdown end -->
		</ul>
		<!--  notification end -->
	</div>
	<div class="top-nav clearfix">
		<!--search & user info start-->
		<ul class="nav pull-right top-menu">
			<li><input type="text" class="form-control search"
				placeholder=" Search"></li>
			<!-- user login dropdown start-->
			<li class="dropdown"><a data-toggle="dropdown"
				class="dropdown-toggle" href="#"> <img alt="" src="images/2.png">
					<span class="username">John Doe</span> <b class="caret"></b>
			</a>
				<ul class="dropdown-menu extended logout">
					<li><a href="#"><i class=" fa fa-suitcase"></i>Profile</a></li>
					<li><a href="#"><i class="fa fa-cog"></i> Settings</a></li>
					<li><a href="login.html"><i class="fa fa-key"></i> Log Out</a></li>
				</ul></li>
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

				<li class="sub-menu"><a href="javascript:;"> <i
						class="fa fa-book"></i> <span>理财产品</span>
				</a>
					<ul class="sub">
						<li><a href="products_Solid _Collection.jsp">固收类/P2P</a></li>
						<li><a href="/YJLC_E/funds/listfunds">私募/股权类</a></li>
						<li><a href="products_Solid _Collection.jsp">海外配置</a></li>
					</ul></li>
				<li class="sub-menu"><a class="active" href="javascript:;">
						<i class="fa fa-th"></i> <span>学院管理</span>
				</a>
					<ul class="sub">
						<li><a class="active"
							href="/YJLC_E/listNews">资讯管理</a></li>
						<li><a href="college_Consultation_Type.jsp">资讯分类</a></li>
					</ul></li>
				<li class="sub-menu"><a href="javascript:;"> <i
						class="fa fa-th"></i> <span>会员管理</span>
				</a>
					<ul class="sub">
						<li><a href="/YJLC_E/listAuditingAll">账号管理</a></li>
						<li><a href="/YJLC_E/listMember_Bankcards">绑卡管理</a></li>
						<li><a href="/YJLC_E/listAward_records">邀请管理</a></li>
						<li><a href="/YJLC_E/listSubject">付息计划</a></li>
						<li><a href="/YJLC_E/listMember_deposit_record">充值管理</a></li>
						<li><a href="/YJLC_E/listMember_withdraw">体现管理</a></li>
					</ul></li>
				<li class="sub-menu"><a href="javascript:;"> <i
						class="fa fa-th"></i> <span>盈+管理</span>
				</a>
					<ul class="sub">
						<li><a href="setUp_Announcement.jsp">公告管理</a></li>
						<li><a href="setUp_Opinion.jsp">意见反馈</a></li>
					</ul></li>
				<li class="sub-menu"><a href="javascript:;"> <i
						class="fa fa-th"></i> <span>系统管理</span>
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
	
	
	<form id="formFile" method="post" enctype="multipart/form-data">
			<table border="1" class="table">
				<tr>
					
						
						<td colspan="8" align="center">
						<c:if test="${not empty fileName }">
						<img  src="/YJLC_E/upload/${fileName }" width="200" height="200"   class="img-circle" >
						<input type="hidden" name="fileName"  id="fileName" value="${fileName }">
						</c:if>
						<br>
						<input type="file" name="cPhoto" onchange="upload()"><br>
					</td>
				</tr>
				<tr>
					<td>标题:</td>
					<td><input type="text" name="title" value="${title }"></td>
					<td>副标题:</td>
					<td><input type="text" name="subTitle" value="${subTitle }"></td>
					<td>排序:</td>
					<td><input type="text" name="sort" value="${sort }"></td>
					<td>链接地址:</td>
					<td><input type="text" name="link" value="${link }"></td>
				</tr>
				<tr>
					<td>作者:</td>
					<td><input type="text" name="author" value="${author }"></td>
					<td>来源:</td>
					<td><input type="text" name="source" value="${source }"></td>
					<td>标签:</td>
					<td><input type="text" name="label" value="${label }"></td>
					<td>附件地址:</td>
					<td><input type="text" name="filelink" value="${filelink }"></td>
				</tr>
				<tr>
					<td>是否置顶:</td>
					<td>
						<select name="placTop" id="placTop">
							<option value="0" selected="selected">否</option>
							<option value="1">是</option>
						</select>
					</td>
					<td>页面seo标题:</td>
					<td><input type="text" name="seoTitle" value="${seoTitle }"></td>
					<td>seo关键字:</td>
					<td><input type="text" name="seoKey" value="${seoKey }"></td>
					<td>seo描述:</td>
					<td><input type="text" name="seoDes" value="${seoDes }"></td>
				</tr>
				<tr>
					<td>是否推荐:</td>
					<td>
						<select name="recommend" id="recommend">
							<option value="0" selected="selected">否</option>
							<option value="1">是</option>
						</select>
					</td>
					<td>类别:</td>
					<td>
						<select name="typeId" name="typeId">
							<c:forEach items="${listNews_type }" var="list">
								<option value="${list.id }">${list.name }</option>
							</c:forEach>
						</select>
						
					</td>	
					<td></td>
					<td>
					
				</tr>
				
				
			</table>
			<table width="100%" align="center" border="1">
				<tr align="center">
					<td align="center">简介: <script id="editor" type="text/plain" style="width:100%;height:100px;" name="editor">${editor}</script></td>
					
					
				</tr>
				<tr>
					<td align="center">
						内容:<script id="text" type="text/plain" style="width:100%;height:100px;" name="text">${text}</script>
					</td>
				</tr>
				<tr>
					<td  colspan="4"  align="center"><input type="button" id="but" onclick="add()" value="添  加"></td>
				</tr>
			</table>
			<div style="width: 100px;height: 400px;">
						<br>
						
						
		</div><td>
		</form>
		
		<script>
		 var ue = UE.getEditor('editor');
		 var t = UE.getEditor('text');
			$(function(){
			 var rec=$("#recommend").val("${recommend}");
			 var plac=$("#placTop").val("${placTop}");
			 
			 if(rec.val()==null){
					$("#recommend").val("0");
				}
			if(plac.val()==null){
				$("#placTop").val("0");
			} 
			})
			function upload(){
				 document.forms[0].action="/YJLC_E/uploadFile";
				 document.forms[0].submit();
			}
			function add(){
				 document.forms[0].action="/YJLC_E/add";
				 document.forms[0].submit();
			}
		</script>
	 </section> <!-- footer --> <!-- / footer --> </section> <script
		src="/YJLC_E/js/bootstrap.js"></script> <script
		src="/YJLC_E/js/jquery.dcjqaccordion.2.7.js"></script> <script
		src="/YJLC_E/js/scripts.js"></script> <script
		src="/YJLC_E/js/jquery.slimscroll.js"></script> <script
		src="/YJLC_E/js/jquery.nicescroll.js"></script> <!--[if lte IE 8]><script language="javascript" type="text/javascript" src="js/flot-chart/excanvas.min.js"></script><![endif]-->
	<script src="/YJLC_E/js/jquery.scrollTo.js"></script>
</body>
</html>