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

	<div>
		<form action="/YJLC_E/subject/updatesubject" method="post" enctype="multipart/form-data">
			<table border="0" width="100%">
				<input type="hidden" name="id" value="${subject.id }" />
				<input type="hidden" name="serial_number" value="${subject.serial_number }" />
				<input type="hidden" name="raise_start" value="${subject.raise_start }" />
				<input type="hidden" name="create_date" value="${subject.create_date }" />


				<%-- 			<input type="hidden" name="folder_id" value="${subject.folder_id }" /> --%>
				<tr>
					<td width="10%">名称：</td>
					<td><input type="text" name="name" value="${subject.name }" /></td>
					<td width="10%">合同编号：</td>
					<td><input type="text" name="serial_no" value="${subject.serial_no }" /></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td width="10%">起投金额(元)：</td>
					<td><input type="text" name="floor_amount" value="${subject.floor_amount }" /></td>
					<td width="10%">年化率(%)：</td>
					<td><input type="text" name="year_rate" value="${subject.year_rate }" /></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td width="10%">状态：</td>
					<td><select name="status">
							<option value="0" ${subject.status=="0"?'selected':'' }>未发布</option>
							<option value="1" ${subject.status=="1"?'selected':'' }>募集中</option>
							<option value="2" ${subject.status=="2"?'selected':'' }>已结束</option>
					</select></td>
					<td width="10%">投资期限(天)：</td>
					<td><input type="text" name="period" value="${subject.period }" /></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td width="10%">借款人姓名：</td>
					<td><input type="text" name="borrowername" value="${subject.borrowername }" /></td>
					<td width="10%">类型：</td>
					<td><select name="type">
							<option value="0" ${subject.type=="0"?'selected':'' }>固收类</option>
							<option value="1" ${subject.type=="1"?'selected':'' }>P2P车贷</option>
							<option value="2" ${subject.type=="2"?'selected':'' }>P2P房贷</option>
					</select></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td width="10%">借款用途：</td>
					<td><input type="text" name="purpose" value="${subject.purpose }" /></td>
					<td width="10%">保障方式：</td>
					<td><select name="safeGuard_way">
							<option value="0" ${subject.safeGuard_way=="0"?'selected':'' }>企业担保</option>
							<option value="1" ${subject.safeGuard_way=="1"?'selected':'' }>银行保障</option>
					</select></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td width="10%">可否使用体验金：</td>
					<td><select name="exper_status">
							<option value="0" ${subject.exper_status=="0"?'selected':'' }>否</option>
							<option value="1" ${subject.exper_status=="1"?'selected':'' }>是</option>
					</select></td>
					<td width="10%">&nbsp;</td>
					<td><input type="hidden" name="bought" value="${subject.bought }" /></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td width="10%">标的金额(￥):</td>
					<td><input type="text" name="amount" value="${subject.amount }" /></td>
					<td width="10%">&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td colspan="4">
					<div>
						<input type="hidden" />
						文件：<input type="file" name="file" required />
					</div>
				</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td colspan="4">▶▶产品速览</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td colspan="4"><textarea id="myUeditor1" name="comment">${subject.comment }</textarea></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td colspan="4">▶▶项目详情</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td colspan="4"><textarea id="myUeditor2" name="projectDetails">${subject.projectDetails }</textarea></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td colspan="4">▶▶安全保障</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td colspan="4"><textarea id="myUeditor3" name="safetyControl">${subject.safetyControl }</textarea></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td colspan="4"><input type="submit" value="保存" /></td>
				</tr>
			</table>
		</form>
	</div>

	</section> <!-- footer --> <!-- / footer --> </section> <script src="/YJLC_E/js/bootstrap.js"></script> <script src="/YJLC_E/js/jquery.dcjqaccordion.2.7.js"></script> <script
		src="/YJLC_E/js/scripts.js"></script> <script src="/YJLC_E/js/jquery.slimscroll.js"></script> <script src="/YJLC_E/js/jquery.nicescroll.js"></script>
	<!--[if lte IE 8]><script language="javascript" type="text/javascript" src="js/flot-chart/excanvas.min.js"></script><![endif]--> <script
		src="/YJLC_E/js/jquery.scrollTo.js"></script> <script type="text/javascript" charset="utf-8">
			var ue = UE.getEditor("myUeditor1", {
				initialFrameWidth : 1200,
				initialFrameHeight : 400
			});
			var ue = UE.getEditor("myUeditor2", {
				initialFrameWidth : 1200,
				initialFrameHeight : 400
			});
			var ue = UE.getEditor("myUeditor3", {
				initialFrameWidth : 1200,
				initialFrameHeight : 400
			});
		</script>
</body>
</html>