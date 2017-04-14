<!-- 它是jsp指令,也是一种特殊的标签 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- java代码的片段 -->
<%
	//获取项目的名称
	String path = request.getContextPath();
	//获取协议名+服务器地址+端口号 ：http://localhost:8080/JavaWebBase/
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<!-- 向页面输入basePth的值（http://localhost:8080/JavaWebBase/） -->
<base href="<%=basePath%>">

<title>My JSP 'introduce.jsp' starting page</title>

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
	This is my introduce JSP page.
	<br>
	<%=basePath%><br/>
	<%=path%><br/>
	<%
		int a = 10;
	%>
	<%=a%><br />
	<%
		out.print(a);
	%>


</body>
</html>
