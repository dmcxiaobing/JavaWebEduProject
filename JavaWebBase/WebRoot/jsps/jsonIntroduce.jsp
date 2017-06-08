<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'jsonIntroduce.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<!-- 先引入我们的js -->
<script type="text/javascript" src = "<c:url value = '/js/ajaxutils.js'/>"></script>
<script type="text/javascript">
//得到XMLHttpRequest对象
/*
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
*/
//通过一个json字符串，转换为对象
/*
window.onload = function(){
	/* var str = "1+2";
	var sum = eval("("+str+")");
	alert(sum); */
	/**
	json应用的解析
	*/
	/* var strJson = "{\"name\":\"zhangsan\"}";
	var person = eval("("+strJson+")");
	alert(person.name); */

/*};*/
//通过ajax异步请求servlet，获取到json数据，并更新html页面中
/* window.onload = function(){
	//获取button元素
	//var btn = document.getElementById("btn");
	//给按钮的点击事件添加监听
	// btn.onclick = function(){
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

}; */
 //通过封装的一个小工具，实现ajax异步请求 。这个提前要引入我们的js
 window.onload = function(){
 	var btn1 = document.getElementById("btn");
 	btn1.onclick = function(){
 	/**
 	ajax方法
 	*/
 		ajax(
 			{
 				url:"<c:url value = '/servlet/JsonIntroduceServlet'/>",
 				type:"json",
 				callback:function(data){
				document.getElementById("h2").innerHTML = data.name;
 				}
			 			
 			
 			}
 		
 		
 		);
 	
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
