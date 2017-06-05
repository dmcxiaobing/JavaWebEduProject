<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'jsonIntroduce.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<script type="text/javascript">
function createXMLHttpRequest() {
	try {
		return new XMLHttpRequest();//大多数浏览器
	} catch (e) {
		try {
			return ActvieXObject("Msxml2.XMLHTTP");//IE6.0
		} catch (e) {
			try {
				return ActvieXObject("Microsoft.XMLHTTP");//IE5.5及更早版本	
			} catch (e) {
				alert("哥们儿，您用的是什么浏览器啊？");
				throw e;
			}
		}
	}
}
/*
window.onload = function(){
	/* var str = "1+2";
	var sum = eval("("+str+")");
	alert(sum); */
	/**
	json应用的解析
	*/
	var strJson = "{\"name\":\"zhangsan\"}";
	var person = eval("("+strJson+")");
	alert(person.name);

/*};*/

window.onload = function(){
	//获取button元素
	var btn = document.getElementById("btn");
	//给按钮的点击事件添加监听
	btn.onclick = function(){
		//使用ajax得到服务器端响应，把结果显示到h2中
		//得到request 并连接 发送
		var xmlHttpRequst = createXMLHttpRequest();
		xmlHttpRequst.open("GET","<c:url value = '/servlet/JsonIntroduceServlet'/>",true);
		xmlHttpRequst.send(null);
		//给XmlHttpRequest的状态改变事件上添加监听
		xmlHttpRequst.onreadystatechange = function(){
			//双重判断
			if(xmlHttpRequst.readyState == 4 && xmlHttpRequst.status == 200){
				var text = xmlHttpRequst.responseText;
				//执行json字符串 转换
				var person = eval("("+text+")");
				var s = person.name+","+person.age+","+person.sex;
				document.getElementById("h2").innerHTML = s;
			
			}

		
		};
	
	
	};

};


</script>

</head>

<body>
	<h1>json的应用</h1>
	<br />
	<button id="btn">点击获取json数据</button>
	<h2 id="h2"></h2>
</body>
</html>
