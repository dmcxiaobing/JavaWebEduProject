<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'fmt.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>
<h1>jstl中fmt的简单使用</h1>
<body>
	<%
		Date date = new Date();
	request.setAttribute("date", date);
	
	 %>

<!-- 以时间进行格式化，并输出 -->
<fmt:formatDate value="${requestScope.date }" pattern="yyyy-MM-dd HH:MM:SS"/>

<%
	request.setAttribute("num1", 3.1415926);
 %>
 <br/>
 <!-- 直接取出request域中的值 -->
 ${num1 }
 
 <br/>
 <!-- 保留两位小数点 -->
 <fmt:formatNumber value="${requestScope.num1}" pattern="0.00"/><br/>
 <!-- 保留三位小数点 -->
 <fmt:formatNumber value="${requestScope.num1 }" pattern="#.###"/>
 
</body>
</html>
