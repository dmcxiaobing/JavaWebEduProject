<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>客户列表</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
	function _change(){
	//alert("msg");
		var select = document.getElementById("select");
		location = "<c:url value = '/demo/servlet/CustomerServlet?${pb.url}'/>&pc="+select.value;
	}
</script>
</head>

<body>
	<h3 align="center">客户列表</h3>
	<table border="1" width="70%" align="center">
		<tr>
			<th>客户姓名</th>
			<th>性别</th>
			<th>生日</th>
			<th>手机</th>
			<th>邮箱</th>
			<th>描述</th>
			<th>操作</th>
		</tr>

		<c:forEach items="${pb.datas }" var="cstm">
			<tr>
				<td>${cstm.cname }</td>
				<td>${cstm.gender }</td>
				<td>${cstm.birthday }</td>
				<td>${cstm.cellphone }</td>
				<td>${cstm.email }</td>
				<td>${cstm.description }</td>
				<td><a
					href="<c:url value='/demo/servlet/CustomerServlet?method=preEdit&cid=${cstm.cid }'/>">编辑</a>
					<a href="<c:url value='/demo/customer/jsps/msg.jsp'/>">删除</a></td>
			</tr>
		</c:forEach>
	</table>
	
<p style = "text-align: center;">
第${pb.pc }页/共${pb.tp }页
<a href="<c:url value = '/demo/servlet/CustomerServlet?${pb.url }&pc=1'/>">首页</a>
<!-- 如果当前页大于1，才会显示上一页 -->
<c:if test="${pb.pc>1 }">
	<a href="<c:url value = '/demo/servlet/CustomerServlet?${pb.url }&pc=${pb.pc-1 }'/>">上一页</a>
</c:if>
<%------------- --%>
<%--页码列表的长度自己定，10个长 --%>
<c:choose>
<%--第一条：如果总页数<=10，那么页码列表1~tp --%>
	<c:when test="${pb.tp <= 10 }">
		<c:set var = "begin" value = "1"/>
		<c:set var = "end" value = "${pb.tp }"/>
	</c:when>

	<c:otherwise>
		<%--第二条，按公式计算，让列表的头为当前页-4，列表的尾为当前页+5 --%>
		<c:set var = "begin" value = "${pb.pc-4 }"/>
		<c:set var = "end" value = "${pb.pc+5 }"/>
		<%--第三条，第二条只适合用于中间，而两端会出现问题，这里处理begin出界。如：当前页为3，则begin就为了负值 --%>
		 <%-- 如果begin<1，那么让begin=1，相应end=10 --%>
		<c:if test="${begin<1 }">
			<c:set var="begin" value = "1"/>
			<c:set var = "end" value = "10"/>
		</c:if>
		<%--第四条，处理end出界。如果end>tp,那么让end=tp，相应begin=tp-9 --%>
		<c:if test="${end>pb.tp }">
			<c:set var = "begin" value = "${pb.tp-9}"/>
			<c:set var = "end" value = "${pb.tp }"/>
		</c:if>>
	</c:otherwise>
	
</c:choose>
<%--循环显示页码列表 --%>
<c:forEach begin="${begin }" end="${end }" var = "i">
	<c:choose>
		<c:when test="${i eq pb.pc }">${i}</c:when>
		<c:otherwise>
			<a href="<c:url value = '/demo/servlet/CustomerServlet?${pb.url }&pc=${i}'/>">[${i }]</a>
		</c:otherwise>
	
	</c:choose>
</c:forEach>

<c:if test="${pb.pc < pb.tp }">
	<a href = "<c:url value = '/demo/servlet/CustomerServlet?${pb.url }&pc=${pb.pc+1 }'/>">下一页</a>
</c:if>
<a href="<c:url value = '/demo/servlet/CustomerServlet?${pb.url }&pc=${pb.tp }'/>">尾页</a>
<select name = "pc" onchange="_change()" id = "select">
	<c:forEach begin="1" end = "${pb.tp }" var = "i">
		<option value="${i }" <c:if test = "${i eq pb.pc }">selected = "selected"</c:if> >${i }</option>
	</c:forEach>
</select> 
</p>
</body>
</html>
