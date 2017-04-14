<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'Login.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	利用cookie和session实现一个小登陆.
	<br>
	<%
		String userNameCookie = "";
		//获取到保存的cookie
		Cookie[] cookies = request.getCookies();
		System.out.print("userNameCookie = ck.fdfddf();");
		if (cookies != null && cookies.length > 0) {
					System.out.print("asfdsdfafd");
			for (Cookie ck : cookies) {
			System.out.print("11111111"+ck.getName());
				if (ck.getName().equals("username")) {
					userNameCookie = ck.getValue();
					System.out.print("userNameCookie = ck.getValue();"+ ck.getValue());
				}
			}

		}
	%>
	<%
		//获取到登陆提示的信息，比如账号错误
		String message = "";
		String msg = (String) request.getAttribute("msg");
		if (!(msg == null) && !msg.equals("")) {
			message = msg;
		}
	%>

	<font color="red" size="25"><%=message%></font>
	<br />
	<form action=<%=path + "/day11LoginServlet"%> method="post">
		<!-- 将用户输入过的用户名利用cookie保存到输入框中 -->
		账 号:<input type="text" name="username" value="<%=userNameCookie %>"></input><br /> <input
			type="submit" name="login" value="登陆"></input>
	</form>
</body>
</html>
