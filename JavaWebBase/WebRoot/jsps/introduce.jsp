<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!-- 导入el函数库(标签库) -->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!-- 当jsp报错的时候，指向指定的错误页面。如500tomcat有默认，这样就会指向我们设置的error.jsp -->
<%-- <%@page errorPage="error.jsp"%> --%>
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

	<%
		//写java代码，就像方法中，
		//这里测试一下请求包含
		out.println(request.getAttribute("name"));
	%>
	<%!//定义方法名和变量名，就像在类中
	int num = 0;
	int sum = 20;%>
	<br />
	<!-- 这样肯定会报500算法错误,由于我们上面配置了error.jsp -->
	<%=sum / num%>
</body>
</html>
