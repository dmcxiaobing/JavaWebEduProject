<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'userwelcome.jsp' starting page</title>

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
	<%--  <%
   	String usersession = (String)session.getAttribute("sessionUser");
   	if(usersession == null || usersession.equals("")){
   		out.write("请登录,程序将在2秒钟后进行跳转");
   		response.setHeader("refresh", "2,userlogin.jsp");
   		return;
   	}
   
    %> 
    --%>
	<c:choose>
		<c:when test="${empty sessionScope.sessionUser }">请登录</c:when>
		<c:otherwise>
    		${sessionScope.sessionUser}
    	</c:otherwise>

	</c:choose>
	<br>
</body>
</html>
