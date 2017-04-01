<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- 导入el函数库(标签库) -->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	//request.getContextPath(); 得到项目的名称映射  如：/JavaWebBase
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<!-- 这三行代表设置浏览器不缓存 -->
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">


<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!-- 这里引入一个loading的js -->
<script type="text/javascript" src="js/loading.js"></script>
</head>

<body>

	This is my JSP page.
	<br>
	<a href="${pageContext.request.contextPath}/index.jsp">点击进行跳转index.jsp</a>
	<br />
	<a href="<%=request.getContextPath()%>/index.jsp">request.getContextPath()</a>
	<img src="imgs/android_.jpg" />
	<%=request.getServerName() %>
</body>



</html>
