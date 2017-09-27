<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新闻中心</title>
<body>
	<jsp:include page="/WEB-INF/jsp/fontTop.jsp" flush="false"></jsp:include>
	<div style="margin-top: 15px;">

		<!-- 示例-970 -->
		<ins class="adsbygoogle" style="display: inline-block; width: 970px; height: 90px" data-ad-client="ca-pub-6111334333458862"
			data-ad-slot="3820120620"></ins>

	</div>
	<h3 class="w3_agile_head">新闻中心</h3>
	<p class="augue_agile">We are all IT elites</p>

	<div style="margin-top: 15px;">

		<!-- 示例-970 -->
		<ins class="adsbygoogle" style="display: inline-block; width: 970px; height: 90px" data-ad-client="ca-pub-6111334333458862"
			data-ad-slot="3820120620"></ins>

	</div>

	<div class="layui-tab layui-tab-card" style="height: 1000px">
		<ul class="layui-tab-title">
			<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
			<li class="layui-this"><font size="3">&nbsp;&nbsp;平台公告&nbsp;&nbsp;</font></li>
			<li><font size="3">&nbsp;&nbsp;市场动态&nbsp;&nbsp;</font></li>
			<li><font size="3">&nbsp;&nbsp;趣味理财&nbsp;&nbsp;</font></li>
			<li><font size="3">&nbsp;&nbsp;新闻头条&nbsp;&nbsp;</font></li>
		</ul>

		<div class="layui-tab-content" style="height: 100%;">

			<!-- 1 -->
			<div class="layui-tab-item layui-show">
				<center>
					<div style="width: 700px" align="left">
						<br>
						<h3 align="center">平台公告</h3>
						<br>
						<ul class="layui-timeline">
							<c:forEach items="${listpush}" var="lp">
								<li class="layui-timeline-item"><i class="layui-icon layui-timeline-axis"></i>
									<div class="layui-timeline-content layui-text">
										<h3 class="layui-timeline-title">${fn:substring(lp.create_date,0,10)}</h3>
										<h4 class="layui-timeline-title">${fn:substring(lp.title,0,10)}</h4>
										<input type="hidden" name="push_notice.id" value="${lp.id}">
										<p>
											<a href="#">${fn:substring(lp.content,0,25)}...</a> </a>
										</p>
									</div></li>
							</c:forEach>

							<li class="layui-timeline-item"><i class="layui-icon layui-timeline-axis"></i>
								<div class="layui-timeline-content layui-text">
									<div class="layui-timeline-title">过去</div>
								</div></li>
						</ul>
					</div>
				</center>
			</div>


			<!-- 平台公告 -->
			<div class="layui-tab-item">
				<center>
					<div style="width: 700px" align="left">
						<br>
						<h3 align="center">平台公告</h3>
						<br>
						<ul class="layui-timeline">
							<c:forEach items="${listpush}" var="lp">
								<li class="layui-timeline-item"><i class="layui-icon layui-timeline-axis"></i>
									<div class="layui-timeline-content layui-text">
										<h3 class="layui-timeline-title">${fn:substring(lp.create_date,0,10)}</h3>
										<h4 class="layui-timeline-title">${fn:substring(lp.title,0,10)}</h4>
										<input type="hidden" name="push_notice.id" value="${lp.id}">
										<p>
											<a href="#">${fn:substring(lp.content,0,25)}...</a>
										</p>
									</div></li>
							</c:forEach>

							<li class="layui-timeline-item"><i class="layui-icon layui-timeline-axis"></i>
								<div class="layui-timeline-content layui-text">
									<div class="layui-timeline-title">过去</div>
								</div></li>
						</ul>
					</div>
				</center>
			</div>



			<!-- 市场动态 -->
			<div class="layui-tab-item">
				<center>
					<div style="width: 700px" align="left">
						<br>
						<h3 align="center">市场动态</h3>
						<br>
						<ul class="layui-timeline">
							<c:forEach items="${listpush}" var="lp">
								<li class="layui-timeline-item"><i class="layui-icon layui-timeline-axis"></i>
									<div class="layui-timeline-content layui-text">
										<h3 class="layui-timeline-title">${fn:substring(lp.create_date,0,10)}</h3>
										<h4 class="layui-timeline-title">${fn:substring(lp.title,0,10)}</h4>
										<input type="hidden" name="push_notice.id" value="${lp.id}">
										<p>
											<a href="#">${fn:substring(lp.content,0,25)}...</a>
										</p>
									</div></li>
							</c:forEach>

							<li class="layui-timeline-item"><i class="layui-icon layui-timeline-axis"></i>
								<div class="layui-timeline-content layui-text">
									<div class="layui-timeline-title">过去</div>
								</div></li>
						</ul>
					</div>
				</center>
			</div>


			<!-- 趣味理财 -->
			<div class="layui-tab-item">
				<center>
					<div style="width: 700px" align="left">
						<br>
						<h3 align="center">趣味理财</h3>
						<br>
						<ul class="layui-timeline">
							<c:forEach items="${listNews }" var="ln">
								<li class="layui-timeline-item"><i class="layui-icon layui-timeline-axis"></i>
									<div class="layui-timeline-content layui-text">
										<h3 class="layui-timeline-title">${fn:substring(ln.updTime,0,10)}</h3>
										<h4 class="layui-timeline-title">${fn:substring(ln.title,0,10) }</h4>
										<input type="hidden" name="push_notice.id" value="${lp.id}">
										<p>
											<a href="#">${fn:substring(ln.text,0,25)}...</a></a>
										</p>
									</div></li>
							</c:forEach>

							<li class="layui-timeline-item"><i class="layui-icon layui-timeline-axis"></i>
								<div class="layui-timeline-content layui-text">
									<div class="layui-timeline-title">过去</div>
								</div></li>
						</ul>
					</div>
				</center>
			</div>


			<!-- 新闻头条 -->
			<div class="layui-tab-item">
				<center>
					<div style="width: 700px" align="left">
						<br>
						<h3 align="center">新闻头条</h3>
						<br>
						<ul class="layui-timeline">
							<c:forEach items="${listpush}" var="lp">
								<li class="layui-timeline-item"><i class="layui-icon layui-timeline-axis"></i>
									<div class="layui-timeline-content layui-text">
										<h3 class="layui-timeline-title">${fn:substring(lp.create_date,0,10)}</h3>
										<h4 class="layui-timeline-title">${fn:substring(lp.title,0,10)}</h4>
										<input type="hidden" name="push_notice.id" value="${lp.id}">
										<p>
											<a href="#">${fn:substring(lp.content,0,25)}...</a>
										</p>
									</div></li>
							</c:forEach>

							<li class="layui-timeline-item"><i class="layui-icon layui-timeline-axis"></i>
								<div class="layui-timeline-content layui-text">
									<div class="layui-timeline-title">过去</div>
								</div></li>
						</ul>
					</div>
				</center>
			</div>


			<center>
				<br>
				<br>
				<div style="height: 150px; width: 975px; background: url(/YJLC_E/font/img/fk.png);"></div>
				<br> <br>
			</center>


		</div>
	</div>
	<script>
layui.use('element', function(){
  var $ = layui.jquery
  ,element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块
  
});
</script>




	<jsp:include page="/WEB-INF/jsp/fontDown.jsp" flush="false"></jsp:include>
</body>



</html>