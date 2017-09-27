<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Typography</title>

<script type="text/javascript" charset="utf-8" src="/YJLC_E/js/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="/YJLC_E/js/ueditor/ueditor.all.min.js"></script>
<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
<script type="text/javascript" charset="utf-8" src="/YJLC_E/js/ueditor/lang/zh-cn/zh-cn.js"></script>

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
<link rel="stylesheet" href="/YJLC_E/css/layui.css" media="all">
<!-- font CSS -->
<link href='http://fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900,900italic'
	rel='stylesheet' type='text/css'>
<!-- font-awesome icons -->
<link href="/YJLC_E/css/font-awesome.css" rel="stylesheet">
<!-- //font-awesome icons -->
<script src="/YJLC_E/js/jquery2.0.3.min.js"></script>
<script src="/YJLC_E/js/layui.js" charset="utf-8"></script>
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
						<li><a href="/YJLC_E/subject/listsubject">固收类/P2P</a></li>
						<li><a href="/YJLC_E/funds/listfunds">私募/股权类</a></li>
						<li><a class="active" href="/YJLC_E/config/listconfig">海外配置</a></li>
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

	<div>
		<form action="/YJLC_E/config/saveconfig" method="post" enctype="multipart/form-data">
			<table border="0" width="100%">
				<tr>
					<td width="10%">图标：</td>
					<td><img src="/YJLC_E/upload/${photo.oversea_icon }" width="200" height="200" class="img-circle"><br>
						<div style="width: 100px;">
							<input type="hidden" name="oversea_icon" value="${photo.oversea_icon }"> <input type="file" name="file" onchange="upload()"><br>
						</div></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td width="10%">标题：</td>
					<td><input type="text" required name="title" value="${photo.title }" /></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td width="10%">子标题：</td>
					<td><input type="text" required name="child_title" value="${photo.child_title }" /></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td width="10%">描述：</td>
					<td><input type="text" required name="description" value="${photo.description }" /></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td width="10%">用户群体：</td>
					<td><input type="text" required name="user_type" value="${photo.user_type }" /></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td width="10%">排序值：</td>
					<td><input type="number" required name="sortColum" id="sortColum" value="${photo.sortColum }" /></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td width="10%">状态：</td>
					<td><select name="status">
							<option value="0">未发布</option>
							<option value="1">募集中</option>
					</select></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td width="10%">开始时间：</td>
					<td><input type="date" required name="start_date" value="${photo.start_date }" /></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td width="10%">结束时间：</td>
					<td><input type="date" required name="end_date" value="${photo.end_date }" /></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td colspan="2"><textarea rows="100%" cols="350" id="myUeditor" name="content">${photo.content }</textarea></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="保存" /></td>
				</tr>
			</table>
		</form>
	</div>

	</section> <!-- footer --> <!-- / footer --> </section> <script src="/YJLC_E/js/bootstrap.js"></script> <script src="/YJLC_E/js/jquery.dcjqaccordion.2.7.js"></script> <script
		src="/YJLC_E/js/scripts.js"></script> <script src="/YJLC_E/js/jquery.slimscroll.js"></script> <script src="/YJLC_E/js/jquery.nicescroll.js"></script>
	<!--[if lte IE 8]><script language="javascript" type="text/javascript" src="js/flot-chart/excanvas.min.js"></script><![endif]--> <script
		src="/YJLC_E/js/jquery.scrollTo.js"></script> <script type="text/javascript" charset="utf-8">
			var ue = UE.getEditor("myUeditor", {
				initialFrameWidth : 1200,
				initialFrameHeight : 400
			});
			function upload() {
				if ($("#sortColum").val() == null
						|| $("#sortColum").val() == "") {
					$("#sortColum").val(0);
				}
				document.forms[0].action = "/YJLC_E/config/uploadFile";
				document.forms[0].submit();
			}
		</script>
</body>
</html>