<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!-- 导入el函数库(标签库) -->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	//request.getContextPath(); 得到项目的名称映射  如：/JavaWebBase
	String path = request.getContextPath();
	//request.getScheme();得到请求的协议名如：http ftp
	//request.getServerName;得到服务器名称 如localhost
	//request.getServerPort() 得到服务器端口号
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'introduce.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

</head>

<body>
	This is my introduce JSP page.
	<br> 这是一个介绍jsp的一些常用属性的jsp页面
	<br />
	<% //这里测试一下请求包含
		out.println(request.getAttribute("name"));
	 %>
</body>
</html>
