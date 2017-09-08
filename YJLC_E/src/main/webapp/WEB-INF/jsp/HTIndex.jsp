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
		<dl id="menu-picture">
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

		<dl id="menu-picture">
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
		<dl id="menu-picture">
			<dt>
				<i class="Hui-iconfont">&#xe616;</i> 盈+管理<i
					class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a href="setUp_Announcement.jsp" title="盈+设置">公告管理</a></li>
					<li><a href="setUp_Opinion.jsp" title="盈+设置">意见反馈</a></li>
				</ul>
			</dd>
		</dl>
		<dl id="menu-picture">
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
	<i class="Hui-iconfont"></i> <a href="/" class="maincolor">首页</a> <span
		class="c-999 en">&gt;</span> <span class="c-666">我的桌面</span> <a
		class="btn btn-success radius r"
		style="line-height: 1.6em; margin-top: 3px"
		href="javascript:location.replace(location.href);" title="刷新"><i
		class="Hui-iconfont">&#xe68f;</i></a></nav>
	<div class="Hui-article">
		<article class="cl pd-20">
		<p class="f-20 text-success">
			欢迎使用H-ui.admin <span class="f-14">v2.3</span> 后台模版！
		</p>
		<p>登录次数：18</p>
		<p>上次登录IP：222.35.131.79.1 上次登录时间：2014-6-14 11:19:55</p>
		<table class="table table-border table-bordered table-bg">
			<thead>
				<tr>
					<th colspan="7" scope="col">信息统计</th>
				</tr>
				<tr class="text-c">
					<th>统计</th>
					<th>资讯库</th>
					<th>图片库</th>
					<th>产品库</th>
					<th>用户</th>
					<th>管理员</th>
				</tr>
			</thead>
			<tbody>
				<tr class="text-c">
					<td>总数</td>
					<td>92</td>
					<td>9</td>
					<td>0</td>
					<td>8</td>
					<td>20</td>
				</tr>
				<tr class="text-c">
					<td>今日</td>
					<td>0</td>
					<td>0</td>
					<td>0</td>
					<td>0</td>
					<td>0</td>
				</tr>
				<tr class="text-c">
					<td>昨日</td>
					<td>0</td>
					<td>0</td>
					<td>0</td>
					<td>0</td>
					<td>0</td>
				</tr>
				<tr class="text-c">
					<td>本周</td>
					<td>2</td>
					<td>0</td>
					<td>0</td>
					<td>0</td>
					<td>0</td>
				</tr>
				<tr class="text-c">
					<td>本月</td>
					<td>2</td>
					<td>0</td>
					<td>0</td>
					<td>0</td>
					<td>0</td>
				</tr>
			</tbody>
		</table>
		<table class="table table-border table-bordered table-bg mt-20">
			<thead>
				<tr>
					<th colspan="2" scope="col">服务器信息</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th width="30%">服务器计算机名</th>
					<td><span id="lbServerName">http://127.0.0.1/</span></td>
				</tr>
				<tr>
					<td>服务器IP地址</td>
					<td>192.168.1.1</td>
				</tr>
				<tr>
					<td>服务器域名</td>
					<td>www.h-ui.net</td>
				</tr>
				<tr>
					<td>服务器端口</td>
					<td>80</td>
				</tr>
				<tr>
					<td>服务器IIS版本</td>
					<td>Microsoft-IIS/6.0</td>
				</tr>
				<tr>
					<td>本文件所在文件夹</td>
					<td>D:\WebSite\HanXiPuTai.com\XinYiCMS.Web\</td>
				</tr>
				<tr>
					<td>服务器操作系统</td>
					<td>Microsoft Windows NT 5.2.3790 Service Pack 2</td>
				</tr>
				<tr>
					<td>系统所在文件夹</td>
					<td>C:\WINDOWS\system32</td>
				</tr>
				<tr>
					<td>服务器脚本超时时间</td>
					<td>30000秒</td>
				</tr>
				<tr>
					<td>服务器的语言种类</td>
					<td>Chinese (People's Republic of China)</td>
				</tr>
				<tr>
					<td>.NET Framework 版本</td>
					<td>2.050727.3655</td>
				</tr>
				<tr>
					<td>服务器当前时间</td>
					<td>2014-6-14 12:06:23</td>
				</tr>
				<tr>
					<td>服务器IE版本</td>
					<td>6.0000</td>
				</tr>
				<tr>
					<td>服务器上次启动到现在已运行</td>
					<td>7210分钟</td>
				</tr>
				<tr>
					<td>逻辑驱动器</td>
					<td>C:\D:\</td>
				</tr>
				<tr>
					<td>CPU 总数</td>
					<td>4</td>
				</tr>
				<tr>
					<td>CPU 类型</td>
					<td>x86 Family 6 Model 42 Stepping 1, GenuineIntel</td>
				</tr>
				<tr>
					<td>虚拟内存</td>
					<td>52480M</td>
				</tr>
				<tr>
					<td>当前程序占用内存</td>
					<td>3.29M</td>
				</tr>
				<tr>
					<td>Asp.net所占内存</td>
					<td>51.46M</td>
				</tr>
				<tr>
					<td>当前Session数量</td>
					<td>8</td>
				</tr>
				<tr>
					<td>当前SessionID</td>
					<td>gznhpwmp34004345jz2q3l45</td>
				</tr>
				<tr>
					<td>当前系统用户名</td>
					<td>NETWORK SERVICE</td>
				</tr>
			</tbody>
		</table>
		</article>
		<footer class="footer">
		<p>
			感谢jQuery、layer、laypage、Validform、UEditor、My97DatePicker、iconfont、Datatables、WebUploaded、icheck、highcharts、bootstrap-Switch<br>
			Copyright &copy;2015 H-ui.admin 3.0 All Rights Reserved.<br>
			本后台系统由<a href="http://www.h-ui.net/" target="_blank" title="H-ui前端框架">H-ui前端框架</a>提供前端技术支持
			<a href="http://www.mycodes.net/" target="_blank">源码之家</a>
		</p>
		</footer>
	</div>
	</section>

	<!--_footer 作为公共模版分离出去-->
	<script type="text/javascript" src="/YJLC_E/lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="/YJLC_E/lib/layer/2.4/layer.js"></script>
	<script type="text/javascript" src="/YJLC_E/static/h-ui/js/H-ui.js"></script>
	<script type="text/javascript"
		src="/YJLC_E/static/h-ui.admin/js/H-ui.admin.page.js"></script>




</body>
</html>