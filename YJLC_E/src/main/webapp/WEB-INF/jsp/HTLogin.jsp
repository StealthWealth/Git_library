<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<!-- CSS -->
<link rel='stylesheet' href='http://fonts.googleapis.com/css?family=PT+Sans:400,700'>
<link rel="stylesheet" href="/YJLC_E/css/css/reset.css">
<link rel="stylesheet" href="/YJLC_E/css/css/supersized.css">
<link rel="stylesheet" href="/YJLC_E/css/css/style.css">

</head>
<body>

	<c:if test="${!empty login }">
		<c:if test="${login==0 }">
			<script type="text/javascript">
				alert("账号或密码或手机号错误!")
			</script>
		</c:if>
		<c:if test="${login==2 }">
			<script type="text/javascript">
				alert("账号以锁定");
			</script>
		</c:if>
		<c:if test="${login==1 }">
			<script type="text/javascript">
				location = "/YJLC_E/addLogin";
			</script>
		</c:if>
	</c:if>
	<div class="page-container">
		<h1>Login</h1>
		<form action="/YJLC_E/login" method="post">
			<input type="text" name="user_name" value="${user_name }" placeholder="账户名"><br> 
			<input type="password" name="password" value="${password }" placeholder="密码"><br>
			<input type="text" name="mobile_Phone" value="${mobile_Phone }" placeholder="电话"><br>
			<button type="submit">Sign me in</button>
		</form>
	</div>

	<!-- Javascript -->
	<script src="/YJLC_E/js/js/jquery-1.8.2.min.js"></script>
	<script src="/YJLC_E/js/js/supersized.3.2.7.min.js"></script>
	<script src="/YJLC_E/js/js/supersized-init.js"></script>
	<script src="/YJLC_E/js/js/scripts.js"></script>
</body>
</html>