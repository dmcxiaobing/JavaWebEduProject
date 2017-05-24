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
    
    <title>My JSP 'showCountSum.jsp' starting page</title>
    
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
  	<h1 align="center">显示访问数量</h1>
	<!-- 用一个表格显示 -->
  <table align="center" width="60%" border="1">
  	<tr>
  		<th>IP</th>
  		<th>次数</th>
  	</tr>
  	<c:forEach items="${applicationScope.map }" var = "entry">
  		<tr>
  			<th>${entry.key }</th>
  			<th>${entry.value }</th>
  		</tr>
  	
  	</c:forEach>
  
  </table>
  </body>
</html>
