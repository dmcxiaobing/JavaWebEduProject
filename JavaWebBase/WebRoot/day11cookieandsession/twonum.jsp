<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'twonum.jsp' starting page</title>
    
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
    这是一个测试加法运算的页面 表单. <br>
    <form action="/JavaWebBase/SumFunctionServlet" method="post">
    	<!-- 设置num只能输入数字 -->
    	整数1:<input type = "number" name = "num1"/><br/>
    	整数2:<input type = "text" name = "num2"/><br/>
    	<input type = "submit" value="相加的结果是"/>
    </form>
  </body>
</html>
