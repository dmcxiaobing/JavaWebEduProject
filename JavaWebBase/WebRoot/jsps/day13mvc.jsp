<%@page import="com.qq986945193.javaweb.servlet.day11.MvcClickServlet"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'day13mvc.jsp' starting page</title>
    
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
  <!-- 这里使用c标签 也可以不用c标签-->
  	<a href='<c:url value = "/MvcClickServlet"/>'>点击查看mvc 这里是使用c标签</a><br>
  	<a href="<%=request.getContextPath()+"/MvcClickServlet"%>">点击查看mvc,这里没有使用c标签</a>
  	
  </body>
</html>
