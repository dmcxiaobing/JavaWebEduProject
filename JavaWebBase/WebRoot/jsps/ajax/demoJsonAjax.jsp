<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'demoJsonAjax.jsp' starting page</title>

<script type="text/javascript">

function createXMLHttpRequest() {
		try {
			return new XMLHttpRequest();
		} catch (e) {
			try {
				return new ActiveXObject("Msxml2.XMLHTTP");
			} catch (e) {
				return new ActiveXObject("Micorsoft.XMLHTTP");
			}
		}
}

window.onload = function() {
		/**
		发送异步请求，获取到所有省，然后使用每个省生成一个option元素，添加到province中
		*/
		//得到核心对象 XmlHttpRequest
		var xmlHttp = createXMLHttpRequest();
		//打开连接
		xmlHttp.open("GET", "<c:url value = '/servlet/AjaxJsonProvinceServlet'/>", true);
		//发送
		xmlHttp.send(null);
		//添加数据返回监听
		xmlHttp.onreadystatechange = function() {
			if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
				//执行服务器发送过来的json字符串
				var json = xmlHttp.responseText;
				var proArray = eval("(" + json + ")");
				for (var i = 0; i < proArray.length; i++) {
					var pro = proArray[i]; //得到每一个pro对象
					//创建option元素
					var optionEle = document.createElement("option");
					//给option的元素赋值
					optionEle.value = pro.pid; //给option的实际值赋为pid,而不是name
					var textNode = document.createTextNode(pro.name); //使用省名称创建textNode
					optionEle.appendChild(textNode); //把textNode添加到option元素中
					//把option元素添加到select元素中
					document.getElementById("province").appendChild(optionEle);

				}
		}
		
		};
		/**
			给province添加onchange监听
		*/
		document.getElementById("province").onchange = function() {
			/*异步请求服务器，得到选择的省下所有市*/
			var xmlHttp = createXMLHttpRequest();
			xmlHttp.open("POST", "<c:url value = '/servlet/AjaxJsonCityServlet'/>", true);
			// 设置请求头
			xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
			//设置参数发送
			xmlHttp.send("pid="+this.value); //用户选择的省
			//添加监听
			xmlHttp.onreadystatechange = function() {
				if (xmlHttp.readyState == 4) {
					if (xmlHttp.status == 200) {
						/*
						0. 先要清空原来的<option>元素
						1. 得到服务器发送过来的所有市
						2. 使用每个市生成<option>元素添加到<select id="city">中
						*/
						/*
						清空<select id="city">中的选项
						*/
						
						var citySelect = document.getElementById("city");
						//获取select中所有的子元素
						var cityOptionArray = citySelect.getElementsByTagName("option");
						//循环删除里面的元素，只留下请选择
						while (cityOptionArray.length > 1) {
							citySelect.removeChild(cityOptionArray[1]); //循环删除下标为1的元素。
						}
						/*得到服务器发送过来的所有市*/
						var cityArray = eval("(" + xmlHttp.responseText + ")");
						//循环遍历每个city对象，用来生成option元素，添加到city中
						for (var i = 0; i < cityArray.length; i++) {
							var city = cityArray[i]; //得到每个city对象
							//创建option元素
							var optionEle = document.createElement("option");
							//给option元素的属性赋值
							optionEle.value = city.cid; //给option的实际值为cid,而不是name
							var textNode = document.createTextNode(city.name); //使用声明称来创建textNode
							optionEle.appendChild(textNode); //把textNode添加到option
							//把option元素添加到select中
							citySelect.appendChild(optionEle);
						}
				}
			}
		};
	};
};
</script>

</head>

<body>
	<h1>省市联动的json小demo</h1>
	省：
	<select id="province" name="province">
		<option value="">请选择</option>
	</select> 市：
	<select id="city" name="city">
		<option value="">请选择</option>
	</select>

</body>
</html>
