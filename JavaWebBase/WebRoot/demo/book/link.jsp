<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP 'link.jsp' starting page</title>

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
	<h1>链接页面</h1>
	<a href="<c:url value='/servlet/DemoBookServlet?method=findAll'/>">查询所有</a>
	<br />
	<a
		href="<c:url value='/servlet/DemoBookServlet?method=findByCid&cid=1'/>">查询SE</a>
	<br />
	<a
		href="<c:url value='/servlet/DemoBookServlet?method=findByCid&cid=2'/>">查询EE</a>
	<br />
	<a
		href="<c:url value='/servlet/DemoBookServlet?method=findByCid&cid=3'/>">查询Framework</a>
	<br />
</body>
</html>
