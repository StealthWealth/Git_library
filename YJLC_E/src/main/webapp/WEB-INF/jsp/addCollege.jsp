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
<script type="text/javascript" src="/YJLC_E/js/ueditor.config.js"></script>
<script type="text/javascript" src="/YJLC_E/js/ueditor.all.min.js"></script>
<script type="text/javascript" src="/YJLC_E/js/zh-cn.js"></script>
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


	<form id="formFile" method="post" enctype="multipart/form-data">
		<table border="1" class="table">
			<tr>
				<td colspan="8" align="center"><c:if test="${not empty news.cPhoto }">
						<img src="/YJLC_E/upload/${news.cPhoto }" width="200" height="200" class="img-circle">
						<input type="hidden" name="cPhoto" id="cPhoto" value="${news.cPhoto }">
					</c:if> <br>
					<div style="width: 100px;">
						<input type="file" name="file" onchange="upload()" class="form-control"><br>
					</div></td>
			</tr>
			<tr>
				<td><font class="text-primary" size="5">标题:</font></td>
				<td><input type="text" name="title" value="${news.title }" class="form-control"></td>
				<td><font class="text-primary" size="5">副标题:</font></td>
				<td><input type="text" name="subTitle" value="${news.subTitle }" class="form-control"></td>
				<td><font class="text-primary" size="5">排序:</font></td>

				<td><input type="text" name="sort" value="${news.sort }" id="sort" class="form-control"></td>
				<td><font class="text-primary" size="5">链接地址:</font></td>
				<td><input type="text" name="link" value="${news.link }" class="form-control"></td>
			</tr>
			<tr>
				<td><font class="text-primary" size="5">作者:</font></td>
				<td><input type="text" name="author" value="${news.author }" class="form-control"></td>
				<td><font class="text-primary" size="5">来源:</font></td>
				<td><input type="text" name="source" value="${news.source }" class="form-control"></td>
				<td><font class="text-primary" size="5">标签:</font></td>
				<td><input type="text" name="label" value="${news.label }" class="form-control"></td>
				<td><font class="text-primary" size="5">附件地址:</font></td>
				<td><input type="text" name="filelink" value="${news.filelink }" class="form-control"></td>
			</tr>
			<tr>
				<td><font class="text-primary" size="5">是否置顶:</font></td>
				<td><select name="placTop" id="placTop" class="form-control">
						<option value="0" selected="selected">否</option>
						<option value="1">是</option>
				</select></td>
				<td><font class="text-primary" size="5">页面seo标题:</font></td>
				<td><input type="text" name="seoTitle" value="${news.seoTitle }" class="form-control"></td>
				<td><font class="text-primary" size="5">seo关键字:</font></td>
				<td><input type="text" name="seoKey" value="${news.seoKey }" class="form-control"></td>
				<td><font class="text-primary" size="5">seo描述:</font></td>
				<td><input type="text" name="seoDes" value="${news.seoDes }" class="form-control"></td>
			</tr>
			<tr>
				<td><font class="text-primary" size="5">是否推荐:</font></td>
				<td><select name="recommend" id="recommend" class="form-control">
						<option value="0" selected="selected">否</option>
						<option value="1">是</option>
				</select></td>
				<td><font class="text-primary" size="5">类别:</font></td>
				<td><select name="typeId" id="typeId" class="form-control">
						<c:forEach items="${listNews_type }" var="list">
							<option value="${list.id }">${list.name }</option>
						</c:forEach>
				</select></td>
				<td></td>
			</tr>
		</table>

		<table width="100%" align="center" border="1">
			<tr align="center">
				<td align="center"><font class="text-primary" size="5">简介:</font> <script id="editor" type="text/plain"
						style="width:100%;height:100px;" name="info">${news.info}</script></td>
			</tr>
			<tr>
				<td align="center"><font class="text-primary" size="5">内容:</font> <script id="text" type="text/plain"
						style="width:100%;height:100px;" name="text">${news.text}</script></td>
			</tr>
			<tr>
				<td colspan="4" align="center"><input type="button" id="but" onclick="add()" value="添   加"
					class="btn-lg btn-info"></td>
			</tr>
		</table>
	</form>

	<script>
		var ue = UE.getEditor('editor');
		var t = UE.getEditor('text');
		$(function() {
			var rec = $("#recommend").val("${news.recommend}");
			var plac = $("#placTop").val("${news.placTop}");
			var type = $("#typeId").val("${typeId}");
			if (rec.val() == null) {
				$("#recommend").val("0");
			}
			if (plac.val() == null) {
				$("#placTop").val("0");
			}
		})
		function upload() {
			if ($("#sort").val() == null || $("#sort").val() == "") {
				$("#sort").val(0);
			}
			document.forms[0].action = "/YJLC_E/uploadFile";
			document.forms[0].submit();
		}
		function add() {
			if ($("#sort").val() == null || $("#sort").val() == "") {
				alert("请填写排序序号");
			} else {
				document.forms[0].action = "/YJLC_E/add";
				document.forms[0].submit();
			}
		}
	</script> </section> <!-- footer --> <!-- / footer --> </section> <script src="/YJLC_E/js/bootstrap.js"></script> <script
		src="/YJLC_E/js/jquery.dcjqaccordion.2.7.js"></script> <script src="/YJLC_E/js/scripts.js"></script> <script
		src="/YJLC_E/js/jquery.slimscroll.js"></script> <script src="/YJLC_E/js/jquery.nicescroll.js"></script> <!--[if lte IE 8]><script language="javascript" type="text/javascript" src="js/flot-chart/excanvas.min.js"></script><![endif]-->
	<script src="/YJLC_E/js/jquery.scrollTo.js"></script>
</body>
</html>