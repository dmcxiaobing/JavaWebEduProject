<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
<!-- 
<%
  	//这里就相当于java中方法内
  %>
<%=	//这里写java代码的输出 如:response.getWrite().print("我是jsp代码");
  %>
<%!
	//这里一般声明成员变量和成员方法
  %>
 -->
	
</head>

<body>
	This is my JSP page.
	<br>
</body>


</html>
