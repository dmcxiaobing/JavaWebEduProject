<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'success.jsp' starting page</title>

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
	<%
   		HttpSession sessionSuccess = request.getSession();
   		String successMsg = (String)sessionSuccess.getAttribute("username");
   		if(successMsg == null || successMsg.equals("")){
   		/* 	out.print("请先登录。登陆成功后才可观看。"); */
   			request.setAttribute("msg", "请先登录。登陆成功后才可观看。");
   			request.getRequestDispatcher("login.jsp").forward(request, response);
   			//response.sendRedirect("login.jsp");
   		}else{
   		out.print("欢迎"+successMsg+"登陆系统");
   		}
    %>
</body>
</html>
