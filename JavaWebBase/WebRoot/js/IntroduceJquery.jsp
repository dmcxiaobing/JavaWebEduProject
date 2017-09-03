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

<title></title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
</head>
<!-- 引入jQuery。当然也可以下载到本地后，引入。将url改为本地文件路径即可 -->
<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js">
</script>

<!-- 禁用右键功能 -->
 <script type="text/javascript">
	//禁用右键菜单
	$(document).ready(function() {
		$(document).bind('contextmenu', function(e) {
			return false;
		})
	})
</script> 
<!-- 新窗口打开界面 -->
<script type="text/javascript">
//新窗口打开界面
    $(document).ready(function(){
        //1.href='https://github.com/qq986945193'的超链接将会在新窗口打开连接
        $('a[href^="https://https://github.com/qq986945193"]').attr("target","_blank")
        //rel='external'的超链接将会在新窗口打开连接
        $('a[rel$="external"]').click(function(){
            this.target = "_blank";
        })
    })
</script>
<!-- 判断浏览器类型 -->
<script type="text/javascript">
//判断浏览器类型[/align]            
			$(document).ready(function(){
             if(/firefox/.test(navigator.userAgent.toLowerCase())){
                 console.log('火狐')
             }
             if(/webkit/.test(navigator.userAgent.toLowerCase())){
                 console.log('Safari, Google Chrome,傲游3,猎豹浏览器,百度浏览器 opera浏览器')
             }
             if(/opera/.test(navigator.userAgent.toLowerCase())){
                 console.log('欧朋浏览器')
             }
             if(/msie/.test(navigator.userAgent.toLowerCase())){
                 console.log('ie')
             }
             //IE 6
             if ('undefined' == typeof(document.body.style.maxHeight)) {
                 //
             }
             //IE 6-8
             if (!$.support.leadingWhitespace) {
                 //
             }
             //IE11的检测方法
             var ua=navigator.userAgent.toLowerCase();  
 
             if (ua.match(/msie/) != null || ua.match(/trident/) != null) {   
             //浏览器类型  
             browserType = "IE";  
             //浏览器版本  
             browserVersion = ua.match(/msie ([\d.]+)/) != null ? ua.match(/msie ([\d.]+)/)[1] : ua.match(/rv:([\d.]+)/)[1];   
             }  
         })
</script>
输入文本框获取或者失去焦点
<script type="text/javascript">
            
           //当获取焦点的时候
            $('#address').focus(function(){
                var tex = $(this).val();
                if(tex == '请输入邮箱地址'){
                    $(this).val('');
                }
            })
            //当失去焦点的时候
            $('#address').blur(function(){
                var tex = $(this).val();
                if(tex == ''){
                    $(this).val('请输入邮箱地址');
                }
            })
       </script>
       <!-- 回车提交表单 -->
       <script type="text/javascript">
         //回车提交表单
        $(document).ready(function(){
            $('input').keyup(function(e){
                if(e.which=='13'){
                    alert('回车提交')
                }
            })
        })</script>
<body>	
<h1>这只是一个jQuery的使用简单介绍，包含一些常用的jquery特效代码</h1><br>
<a rel="external" href="https://github.com/qq986945193"">检测新窗口打开界面的jQuery </a><br>
 <input type="text" id="address" value="检测获取焦点和失去焦点。请输入邮箱地址"/><br>
</body>
</html>
