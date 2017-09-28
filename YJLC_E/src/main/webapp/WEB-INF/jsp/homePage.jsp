<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>  


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>


</head>
    

<body>

	<!-- jsp动态导入font头.jsp  -->
	<jsp:include page="/WEB-INF/jsp/fontTop.jsp" flush="false"></jsp:include>





	<!-- 最新公告 -->
<script type="text/javascript">
		function timer(opj) {
			$(opj).find('ul').animate({
				marginTop : "-3.5rem"
			}, 500, function() {
				$(this).css({
					marginTop : "0.7rem"
				}).find("li:first").appendTo(this);
			})
		}
		$(function() {
			var num = $('.notice_active').find('li').length;
			if (num > 1) {
				var time = setInterval('timer(".notice_active")', 3500);
				$('.gg_more a').mousemove(function() {
					clearInterval(time);
				}).mouseout(function() {
					time = setInterval('timer(".notice_active")', 3500);
				});
			}

			$(".news_ck").click(
					function() {
						location.href = $(".notice_active .notice_active_ch")
								.children(":input").val();
					})
		});
	</script>

<style type="text/css">
/*border-bottom: 1px solid #F0F0F0;*/
.huadong {
	width: 60rem;
	height: 4rem;
	padding: 0.5rem 0 0.3rem 0;
	border-bottom: 1px solid #F0F0F0;
	position: relative;
	font: 12px/1.5 "Hiragino Sans GB", "Microsoft YaHei", simsun;
	margin: 0 auto;
}

.huadong .huabox {
	margin: 0 auto;
	width: 80%;
	line-height: 4rem;
}

.huadong .hdimg {
	float: left;
	line-height: 3.5rem;
}

.huadong .hdimg img {
	vertical-align: middle;
	width: 100%;
}

.huadong h5 {
	font-size: 1rem;
	float: left;
	line-height: 2.2rem;
	margin: 0.8rem 0 0 0;
}

.huadong .gg_more {
	float: left;
}

.huadong .gg_more a {
	font-size: 0.8rem;
	text-decoration: none;
}

.huadong .notice_active {
	float: left;
	width: 55%;
	height: 4rem;
	padding: 0;
	overflow: hidden;
	position: relative;
}

.huadong .notice_active li {
	list-style-type: none;
	line-height: 2.4rem;
	overflow: hidden;
}
/*.huadong .notice_active li.notice_active_ch {}*/
.huadong .notice_active li.notice_active_ch span {
	color: #656972;
	font-size: 1rem;
	display: block;
	overflow: hidden;
	width: 80%;
	float: left;
	overflow: hidden;
	margin: 0 0 2rem 0;
}

.huadong .gg_more .news_ck {
	float: left;
	margin: 0 1rem 0 1rem;
	color: #888;
	width: 5rem;
	height: 2rem;
	line-height: 2rem;
	display: block;
	border: 1px solid #656972;
	text-align: center;
	border-radius: 0.7rem;
	font-size: 0.8rem;
	margin-top: 1rem;
}

.huadong .gg_more .news_more {
	
}

.huadong .notice_active li.notice_active_ch em {
	text-align: right;
	float: right;
	color: #888;
	font-size: 0.8rem;
	font-style: normal;
}
</style>
	<div class="huadong">
		<div class="huabox">
			<!-- <img src="/YJLC_E/font/jQuery_GongGao/lingdang.png">  ◄), ◄: , ◄∶、◄〕 ◄〉 ◄):-->
			<div class="hdimg">
				<font size="4"><li><span class="glyphicon glyphicon-bullhorn" aria-hidden="true"></span></font>&nbsp;
			</div>
			<h5>【最新公告】</h5>
			<div class="notice_active">
				<ul style="margin-top: 0.7rem;">
					<c:forEach items="${listPush}" var="lp">
						<li class="notice_active_ch"><span>${lp.title}</span> <!-- 使用fn标签在jsp页面截取字符串 --> <em>${fn:substring(lp.create_date,0,10)}</em></li>
					</c:forEach>
				</ul>
			</div>

			<div class="gg_more">
				<a class="news_ck" href="">查看详情</a> <a title="news_more" href="">更多+</a>
			</div>

		</div>
	</div>

	<!-- 公告结束 -->


	<!--
    	作者：504549658@qq.com
    	时间：2017-09-06
    	描述：--热门股 
    -->
	<div class="services">
		<div class="container">
			<h3 class="w3_agile_head">热门</h3>
			<p class="augue_agile">We are all IT elites</p>


			<div class="w3layouts_services_grids">

				<c:forEach items="${showStock}" var="ssk">
					<!--选股方框开始 -->
					<div class="col-md-4 w3layouts_services_grid">
						<div class="w3layouts_services_grid_main">
							<div class="w3layouts_services_grid1">
								<div class="w3layouts_services_grid1_pos">
									<h4>${ssk.type}</h4>
								</div>
							</div>
							<h5 align="center">${ssk.name}</h5>
							<div>
								<div align="center">
									<font size="7" color="red">${ssk.year_rate}</font><font size="4" color="red">%</font> &nbsp; &nbsp; &nbsp; &nbsp;<font size="7"
										color="#007DDB">${ssk.buyer_count}</font><font size="4" color="#007DDB">人</font><br> 年化收益&nbsp; &nbsp; &nbsp;/&nbsp; &nbsp; &nbsp;
									已购买人数
									<hr class="layui-bg-blue">

									<div>
										<font color="#00BAFF">起购金额:￥${ssk.floor_amount}</font>
									</div>
									<hr class="layui-bg-blue">
									<div>
										<font color="#808080">管理人:${ssk.product_manager_desc}</font>
									</div>
									<hr class="layui-bg-blue">
									<div>
										<button class="layui-btn layui-btn-danger aaa">
											<a href="#small-dialog" class="play-icon popup-with-zoom-anim"><font color="#ffffff">立即购买</font></a>
										</button>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!--选股方框结束 -->
				</c:forEach>

			</div>
		</div>
	</div>
	<!-- 热门股结束 -->

	<!-- 商业合作滚动条-->

	<style type="text/css">
.str_wrap {
	padding-left: 3em;
	padding-right: 3em;
	background: #fefefe;
	height: 10em;
	line-height: 2em;
	font-size: 1.2em;
}

.str3 {
	font-size: 0 !important
}

.str3-2 {
	background: none !important;
}

.str3-2 span {
	border: 5px solid #ccc;
	background: #f1f1f1;
	color: #999;
	margin: 0 5px;
	text-align: center;
	font: 40px/100px Arial, Helvetica, sans-serif;
	width: 100px;
	height: 100px;
	display: inline-block;
	vertical-align: top;
}

.str4 .str_item {
	font-size: 0;
	line-height: 0
}

.str4 img {
	opacity: 0.8
}

.str4 img:hover {
	opacity: 1
}

.str4.str_wrap.str_active {
	background: #fff;
}
</style>


	<center>
		<div style="width: 1090px;">
			<h3 class="w3_agile_head" align="center">商业合作</h3>
			<p class="augue_agile">We are all IT elites</p>

			<div class="str4 str_wrap" style="height: 161px;">
				<div class="str_move str_origin" style="left: -2728.3px;">
					<img src="/YJLC_E/font/jQuer_GunDong/1c0ae2205709722b62e843abc0471a55_S.jpg"> <img
						src="/YJLC_E/font/jQuer_GunDong/01f1a05053c6242fcfa23075e5b963c1_S.jpg"> <img
						src="/YJLC_E/font/jQuer_GunDong/6f43b5263fbba79c5962514b85d34738_S.jpg"> <img
						src="/YJLC_E/font/jQuer_GunDong/8b6e33345ac8d5ffd9cf0d107a7d9e9d_S.jpg"> <img
						src="/YJLC_E/font/jQuer_GunDong/9b2c4b44fb86522964124ed80d03c5e8_S.jpg"> <img
						src="/YJLC_E/font/jQuer_GunDong/9ecd376e5371efaef9aad9bc9143aed8_S.jpg"> <img
						src="/YJLC_E/font/jQuer_GunDong/9ecd376e5371efaef9aad9bc9143aed8_S.jpg">
				</div>
			</div>
		</div>
	</center>
	<!-- 商业合作结束-->


	<center>
		<br>
		<br>
		<div style="height: 150px; width: 975px; background: url(/YJLC_E/font/img/fk.png);"></div>
		<br> <br>
	</center>

	<div style="margin-top: 15px;">

		<!-- 示例-970 -->
		<ins class="adsbygoogle" style="display: inline-block; width: 970px; height: 90px" data-ad-client="ca-pub-6111334333458862"
			data-ad-slot="3820120620"></ins>

	</div>




	<!-- 动态导入font尾.jsp -->
	<jsp:include page="/WEB-INF/jsp/fontDown.jsp" flush="false"></jsp:include>


</body>
</html>