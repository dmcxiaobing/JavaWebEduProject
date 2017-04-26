<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'userRegist.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">

	function _change() {
		//这是一个更换验证码的js
		//获取img的元素
		var imgelement = document.getElementById("imgCode");
		//加上时间，以防缓存不显示
		imgelement.src = "< c:url value = '/day11VerifyCodeServlet'/>?xxx=" + new Date().getTime();


	}
</script>
</head>

<body>
	<h1>注册</h1>
	<h1 style="color: red;font-weight: 900">${msg}</h1>
	<form action='<c:url value = "/UserRegistServlet"/>' method="post">
		用户名：<input type="text" name="username" value="${user.username}" />${errors.username }<br />
		密 码：<input type="password" name="password" value="${user.password}" />${errors.password }<br />
		验证码：<input type="text" name="verifycode" value="${user.verifycode}"
			size="3">
			<img id="imgCode" src='<c:url value = "/day11VerifyCodeServlet"/>'
			border="2" /> <a href="javascript:_change()">换一张</a>${errors.verifyCode} <br />
		<input type="submit" value="注册" />


	</form>
</body>
</html>
