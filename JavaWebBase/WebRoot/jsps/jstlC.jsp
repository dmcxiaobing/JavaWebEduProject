<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'jstlC.jsp' starting page</title>
    
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
  <!-- 设置一个js代码 -->
 <c:set var = "code" value = "<script> alert('scrhello')</script>" scope = "request"/>  
 <c:out value = "${code }" escapeXml ="true"/>  <br/>
  <!-- 输入项目名和servlet路径名 -->
  ${pageContext.request.contextPath }/JSTLServlet  <br/>
 <!-- c标签的一个超链接 -->
  <a href = "<c:url value = '/login.html'/>">点击回到login.html</a> <br/>
<c:url value = "/jstlC.jsp">
	<c:param name = "username" value ="zhangsan"/>
</c:url> <br/>
<c:if test = "${empty param.username }">
	<!-- 如果为null，则不会出现 -->
	您没有给出名为username的参数
</c:if> <br/>
  
  
  </body>
</html>
