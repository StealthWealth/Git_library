<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


</head>


<body>

<c:if test="${!empty dlyz}">
<script type="text/javascript">
	alert("${dlyz}");
</script>
</c:if>



<!-- 验证码的样式  -->
<style type="text/css">  
.nocode {  
	display: inline-block;
    width: 100px;  
    height: 25px;  
}  
  
.code {  
	display: inline-block;
    color: #ff0000;  
    font-family: Tahoma, Geneva, sans-serif;  
    font-style: italic;  
    font-weight: bold;  
    text-align: center;  
    width: 100px;  
    height: 25px;  
    line-height: 25px;
    cursor: pointer;  
    border:1px solid #e2b4a2;
    background: #e2b4a2;
}  
  
.input {  
    width: 100px;  
}  
</style>  





<!--
	作者：504549658@qq.com
	时间：2017-09-06
	描述：导航栏
-->
<ul class="layui-nav">

<div >
  <li class="layui-nav-item">
    <a href=""><font color="#FFFFFF" >盈+理财&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    </font></a>
  </li>	
  <li class="layui-nav-item">
    <a href="/YJLC_E/users/showStock">首页</a>
  </li>
  <li class="layui-nav-item">
    <a href="">网上体验中心 </a>
  </li>
  <li class="layui-nav-item">
    <a href="/YJLC_E/users/product">产品中心</a>
  </li>
  <li class="layui-nav-item">
    <a href="/YJLC_E/users/pressCenter">新闻中心</a>
  </li>
  <li class="layui-nav-item">
    <a href="/YJLC_E/users/download_center">下载中心</a>
  </li>
  <li class="layui-nav-item">
    <a href="/YJLC_E/users/YJcommercial_college">盈+商学院</a>
  </li>
  <li class="layui-nav-item">
    <a href="/YJLC_E/users/study_center">投研中心</a>
  </li>
  
  <c:if test="${!empty member}">
  <li class="layui-nav-item">
    <a href="">我的加法库<span class="layui-badge">9</span></a>
  </li>
  </c:if>
  
  
  <c:if test="${empty member }">
  <a href="#" class="play-icon popup-with-zoom-anim">我的加法库<span class="layui-badge-dot"></span></a>
  </c:if>
  
  <c:if test="${!empty member }">
  <a href="#" class="play-icon popup-with-zoom-anim">个人中心<span class="layui-badge-dot"></span></a>
  
  </c:if>
  
  <c:if test="${empty member}">
  <li class="layui-nav-item" >
    <a href="#small-dialog" class="play-icon popup-with-zoom-anim">个人中心<span class="layui-badge-dot"></span></a>
  </li>
  </c:if>
  
  
  <c:if test="${!empty member}">
  <li class="layui-nav-item" >
    <a href="javascript:;"><img src="/YJLC_E/font/img/1.jpg" class="layui-nav-img">我</a>
    <dl class="layui-nav-child">
      <dd><a href="javascript:;">修改信息</a></dd>
      <dd><a href="javascript:;">安全管理</a></dd>
      <dd><a href="javascript:;">退了</a></dd>
    </dl>
  </li>
  </c:if>
  
  
  <c:if test="${empty member}">
  <li class="layui-nav-item">
  	<a href="#small-dialog" class="play-icon popup-with-zoom-anim">登录</a>
  </li>
  </c:if>
  
</div>
</ul>



<!-- -------------------------------- -->


	<script src="/YJLC_E/font/jQuer_GunDong/jquery-1.10.2.js"></script><script src="/YJLC_E/font/jQuer_GunDong/jquery.min.js"></script>
	<script src="/YJLC_E/font/jQuer_GunDong/jquery.liMarquee.js"></script>
	<script>
	$(window).load(function(){
		$('.str3-2').liMarquee();
		$('.str4').liMarquee();
	});

	</script> 
	
	
<!-- pop-up-box -->
	<div id="small-dialog" class="mfp-hide w3ls_small_dialog wthree_pop">
		<h3>登录</h3>		
		<div class="agileits_modal_body">
			<form action="/YJLC_E/users/MemberSignUp" method="post">
				<div class="agileits_w3layouts_user">
					<i class="fa fa-user" aria-hidden="true"></i>
					<input type="text" name="name" placeholder="用户名" required="">
				</div>
				<div class="agileits_w3layouts_user">
					<i class="fa fa-key" aria-hidden="true"></i>
					<input type="password" name="password" placeholder="密码" required="">
				</div>
				<div class="agile_remember">
					<div class="agile_remember_left">
						<div class="check">
							<label class="checkbox"><input type="checkbox" name="checkbox"><i> </i>记住我</label>
						</div>
					</div>
					<div class="agile_remember_right">
						<a href="#">忘记密码?</a>
					</div>
					<div class="clearfix"> </div>
				</div>
				<input type="submit" value="登  录">
			</form>
			<h5>没有一个账户吗? <a href="#small-dialog1" class="play-icon popup-with-zoom-anim">快速注册</a></h5>
		</div>
	</div>



	<div id="small-dialog1" class="mfp-hide w3ls_small_dialog wthree_pop">
		<h3>注册</h3>		
		<div class="agileits_modal_body">
			<form action="/YJLC_E/users/MemberSignIn" method="post">
				<h4>15秒快速注册 :</h4>
				<div class="agileits_w3layouts_user">
					<i class="fa fa-user" aria-hidden="true"></i>
					<input type="text" name="name" placeholder="用户名(需实名注册)" required="">
				</div>
				<div class="agileits_w3layouts_user">
					<i class="fa fa-volume-control-phone" aria-hidden="true"></i>
					<input type="text" name="mobile_Phone" placeholder="手机号" >
				</div>
		<!--	<div class="agileinfo_subscribe">
					<div class="check">
						<label class="checkbox"><input type="checkbox" name="checkbox"><i> </i>subscribe to newsletter</label>
				</div> 
		</div>--><br>
				<div class="agileits_w3layouts_user">
					<i class="fa fa-envelope-o" aria-hidden="true"></i>
					<input type="email" name="Email" placeholder="Email">
				</div><br />
				
				<div class="agileits_w3layouts_user">
					<i class="fa fa-picture-o"></i>
					<script type="text/javascript" src="/YJLC_E/font/js/code.js"></script>  
					<input type="text" id="yz" name="验证码" placeholder="请输入图片验证码" required style="width: 200px;">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<span id="code" class="nocode">验证码</span> 
				</div><br>
					
				<div class="agileits_w3layouts_user">
					<i class="fa fa-mobile-phone"></i>
					<input type="text" name="手机验证码" placeholder="获取手机验证码"  style="width: 250px;">&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="button" class="layui-btn layui-btn-danger" value="获取验证码"/>
				</div>	
				<div class="agileits_w3layouts_user agileits_w3layouts_user_agileits">
					<i class="fa fa-key" aria-hidden="true"></i>
					<input type="password" id="aaa" name="Password" placeholder="密码" required="">
				</div>
				<div class="agileits_w3layouts_user">
					<i class="fa fa-key" aria-hidden="true"></i>
					<input type="password" id="bbb" name="Password" placeholder="再次输入密码" required="">
				</div><br>
				<div class="agileits_w3layouts_user">
					<i class="fa fa-asl-interpreting" aria-hidden="true"></i> 
					<input type="text" name="invitationCode" placeholder="理财师邀请码" >
				</div>
				<br>
				<div class="agileits_w3layouts_user">
					<i class="fa fa-comment-o"></i>
					<input type="text" name="qqNumber" placeholder="qq号码" >
				</div>
				<div class="agileinfo_subscribe">
					<div class="check">
						<label class="checkbox"><input type="checkbox" name="checkbox" required=""><i> </i>我已阅读并同意<a href="">《本网站服务协议》</a></label>
					</div>
				</div>
				<input  type="submit" value="注  册" >
			</form>
			<h5>我已注册现在就 <a href="#small-dialog" class="play-icon popup-with-zoom-anim">登录</a></h5>
		</div>
	</div>






	
<script src="/YJLC_E/font/js/jquery.magnific-popup.js" type="text/javascript"></script>
<script>
	$(document).ready(function() {
	$('.popup-with-zoom-anim').magnificPopup({
		type: 'inline',
		fixedContentPos: false,
		fixedBgPos: true,
		overflowY: 'auto',
		closeBtnInside: true,
		preloader: false,
		midClick: true,
		removalDelay: 300,
		mainClass: 'my-mfp-zoom-in'
	});															
	});
</script>	


	

</body>

	
		<link rel="stylesheet" href="/YJLC_E/font/layui/css/layui.css" />
		<link href="/YJLC_E/font/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
		<link href="/YJLC_E/font/css/style.css" rel="stylesheet" type="text/css" media="all" />
		<link href="/YJLC_E/font/css/popuo-box.css" rel="stylesheet" type="text/css" media="all" />
		<link rel="stylesheet" href="/YJLC_E/font/css/font-awesome.min.css" />	
		<link rel="stylesheet" href="YJLC_E/font/css/style.css" />
		<link rel="stylesheet" type="text/css" href="/YJLC_E/font/jQuer_GunDong/normalize.css">
		<link rel="stylesheet" type="text/css" href="/YJLC_E/font/jQuer_GunDong/default.css">
		<link rel="stylesheet" href="/YJLC_E/font/jQuer_GunDong/liMarquee.css">
		
		
		

				
				
		
		<script src="/YJLC_E/font/layui/layui.js" ></script>
	
</html>