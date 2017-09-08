<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="stylesheet" type="text/css"
	href="/YJLC_E/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css"
	href="/YJLC_E/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css"
	href="/YJLC_E/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css"
	href="/YJLC_E/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css"
	href="/YJLC_E/static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script><![endif]-->
<!--/meta 作为公共模版分离出去-->

<title>盈+后台</title>
</head>
<body>
<header class="navbar-wrapper">
	<div class="navbar navbar-fixed-top" style="height: 500px">
		<div class="container-fluid cl">
				<font size="6" color="white">盈+系统</font>
			<nav id="Hui-userbar" class="nav navbar-nav navbar-userbar hidden-xs">
			<ul class="cl">
				<li>超级管理员</li>
				<li class="dropDown dropDown_hover"><a href="#"
					class="dropDown_A">admin <i class="Hui-iconfont">&#xe6d5;</i></a>
					<ul class="dropDown-menu menu radius box-shadow">
						<li><a href="javascript:;" onClick="myselfinfo()">个人信息</a></li>
						<li><a href="#">切换账户</a></li>
						<li><a href="#">退出</a></li>
					</ul></li>
				<li id="Hui-msg"><a href="#" title="消息"> <span
						class="badge badge-danger">1</span> <i class="Hui-iconfont"
						style="font-size: 18px">&#xe68a;</i></a></li>
				<li id="Hui-skin" class="dropDown right dropDown_hover"><a
					href="javascript:;" class="dropDown_A" title="换肤"><i
						class="Hui-iconfont" style="font-size: 18px">&#xe62a;</i></a>
					<ul class="dropDown-menu menu radius box-shadow">
						<li><a href="javascript:;" data-val="default" title="默认（黑色）">默认（黑色）</a>
						</li>
						<li><a href="javascript:;" data-val="blue" title="蓝色">蓝色</a>
						</li>
						<li><a href="javascript:;" data-val="green" title="绿色">绿色</a>
						</li>
						<li><a href="javascript:;" data-val="red" title="红色">红色</a></li>
						<li><a href="javascript:;" data-val="yellow" title="黄色">黄色</a>
						</li>
						<li><a href="javascript:;" data-val="orange" title="橙色">橙色</a></li>
					</ul></li>
			</ul>
			</nav>
		</div>
	</div>
	</header>
	<aside class="Hui-aside">

	<div class="menu_dropdown bk_2">

		<dl id="menu-article">
			<dt>
				<i class="Hui-iconfont">&#xe616;</i> 理财产品<i
					class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a href="products_Solid _Collection.jsp" title="理财产品">固收类/P2P</a></li>
				</ul>
			</dd>
		</dl>
		<dl id="menu-article">
			<dt>
				<i class="Hui-iconfont">&#xe616;</i> 学院管理<i
					class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a href="college_Consultation_Type.jsp" title="学院管理">资讯分类</a></li>
					<li><a href="college_Consultation_Administration.jsp"
						title="学院管理">资讯管理</a></li>
				</ul>
			</dd>
		</dl>
		<dl id="menu-article">
			<dt>
				<i class="Hui-iconfont">&#xe616;</i> 会员管理<i
					class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a href="/YJLC_E/listAuditingAll" title="会员管理">账号管理</a></li>
					<li><a href="vip_examine.jsp" title="会员管理">理财师审核</a></li>
					<li><a href="vip_Bangker.jsp" title="会员管理">绑卡管理</a></li>
					<li><a href="vip_plan.jsp" title="会员管理">付息计划</a></li>
					<li><a href="vip_Recharge.jsp" title="会员管理">充值管理</a></li>
					<li><a href="vip_Withdrawals.jsp" title="会员管理">提现管理</a></li>
					<li><a href="vip_Invitation.jsp" title="会员管理">邀请奖励</a></li>
				</ul>
			</dd>
		</dl>
		<dl id="menu-article">
			<dt>
				<i class="Hui-iconfont">&#xe616;</i> 盈+管理<i
					class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd style="display: block">
				<ul>
					<li class="current"><a href="setUp_Announcement.jsp"
						title="盈+管理">公告管理</a></li>
					<li><a href="setUp_Opinion.jsp" title="盈+管理">意见反馈</a></li>
				</ul>
			</dd>
		</dl>
		<dl id="menu-article">
			<dt>
				<i class="Hui-iconfont">&#xe616;</i> 系统管理<i
					class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a href="system_Account.jsp" title="系统设置">账户管理</a></li>
					<li><a href="system_Role.jsp" title="系统设置">角色管理</a></li>
					<li><a href="system_Password.jsp" title="系统设置">密码修改</a></li>
				</ul>
			</dd>
		</dl>

	</div>
	</aside>
	<div class="dislpayArrow hidden-xs">
		<a class="pngfix" href="javascript:void(0);"
			onClick="displaynavbar(this)"></a>
	</div>
	<!--/_menu 作为公共模版分离出去-->

	<section class="Hui-article-box"> <nav class="breadcrumb">
	<i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>
	盈+管理 <span class="c-gray en">&gt;</span> 公告管理 <a
		class="btn btn-success radius r"
		style="line-height: 1.6em; margin-top: 3px"
		href="javascript:location.replace(location.href);" title="刷新"><i
		class="Hui-iconfont">&#xe68f;</i></a> </nav>
	<div class="Hui-article">
		<article class="cl pd-20">


		<div class="mt-20"></div>
		</article>
	</div>
	</section>

	<!--_footer 作为公共模版分离出去-->
	<script type="text/javascript" src="/YJLC_E/lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="/YJLC_E/lib/layer/2.4/layer.js"></script>
	<script type="text/javascript" src="/YJLC_E/static/h-ui/js/H-ui.js"></script>
	<script type="text/javascript"
		src="/YJLC_E/static/h-ui.admin/js/H-ui.admin.page.js"></script>
	<!--/_footer /作为公共模版分离出去-->

	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript"
		src="/YJLC_E/lib/My97DatePicker/4.8/WdatePicker.js"></script>
	<script type="text/javascript"
		src="/YJLC_E/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="/YJLC_E/lib/laypage/1.2/laypage.js"></script>

</body>
</html>