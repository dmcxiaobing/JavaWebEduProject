
day01

1、html的简介
	* 什么是html？
		- HyperText Markup Language：超文本标记语言，网页语言
		** 超文本：超出文本的范畴，使用html可以轻松实现这样操作
		** 标记：html所有的操作都是通过标记实现的，标记就是标签，<标签名称>
		** 网页语言：
	* 第一个html程序。
		- 创建java文件.java
			** 先编译，然后再运行（jvm）
		- html后缀是 .html .htm
			** 直接通过浏览器就可以运行
		- 代码
			** 这是我的<font size="5" color="red">第一个html程序！</font>

	* html的规范（遵循）
		1、一个html文件开始标签和结束的标签  <html>  </html>
			- 定义一个java方法 { }
		2、html包含两部分内容 
			（1）<head> 设置相关信息</head>
			（2）<body> 显示在页面上的内容都写在body里面</body>
		3、html的标签有开始标签，也要有结束标签
			- <head></head>
		4、html的代码不区分大小写的
		5、有些标签，没有结束标签 ，在标签内结束
			- 比如 换行  <br/>  <hr/>
	
	* html的操作思想（******理解）
		网页中有很多数据，不同的数据可能需要不同的显示效果，这个时候需要使用标签把要操作的数据包起来（封装起来），
		通过修改标签的属性值实现标签内数据样式的变化。
		一个标签相当于一个容器，想要修改容器内数据的样式，只需要改变容器的属性值，就可以实现容器内数据样式的变化。

html中常用的标签
2、文字标签和注释标签
	* 文字标签：修改文字的样式
		- <font></font>
		- 属性：
			* size: 文字的大小 取值范围 1-7,超出了7，默认还是7
			* color：文字颜色
				- 两种表示方式
					** 英文单词：red  green  blue  black  white  yellow   gray......
					** 使用十六进制数表示 #ffffff :  RGB
						- 通过工具实现不同的颜色   #66cc66

	* 注释标签
		- java注释几种？三种
		- html的注释 ： <!--  html的注释  -->

3、标题标签、水平线标签和特殊字符
	* 标题标签 
		- <h1></h1>  <h2></h2>  <h3></h3> .......<h6></h6>
		- 从h1到h6，大小是依次变小，同时会自动换行
	
	* 水平线标签
		- <hr/>
		- 属性
			** size: 水平线的粗细 取值范围 1-7
			** color: 颜色
		- 代码
			<hr size="5" color="blue"/>

	* 特殊字符
		- 想要在页面上显示这样的内容   <html>:是网页的开始！
		- 需要对特殊字符进行转义
			* <    &lt;
			* >    &gt;
			* 空格：&nbsp;
			* &  : &amp;
	
4、列表标签
	- 比如现在显示这样的效果
		传智播客
			  财务部
			  学工部
			  人事部
	** <dl> </dl>: 表示列表的范围
		** 在dl里面  <dt></dt>: 上层内容
		** 在dl里面  <dd></dd>：下层内容
	- 代码
		<dl>
			<dt>传智播客</dt>
			<dd>财务部</dd>			
			<dd>学工部</dd>
			<dd>人事部</dd>
		</dl>
	
	- 想要在页面上显示这样的效果
	  1. 财务部
	  2. 学工部
	  3. 人事部

	  a. 财务部
	  b. 学工部
	  c. 人事部

	  i. 财务部
	  ii. 学工部
	  iii. 人事部
	
	** <ol></ol> : 有序列表的范围
		- 属性 type：设置排序方式 1(默认)  a  i
	   ** 在ol标签里面 <li>具体内容</li>
	- 代码
		<ol>
			<li>财务部</li>
			<li>学工部</li>
			<li>人事部</li>
		</ol>
	
	- 想要在页面上显示这样的效果
		特殊符号（方框） 财务部
		特殊符号（方框） 学工部

		** <ul></ul> : 表示无序列表的范围
			属性： type: 空心圆circle 、实心圆disc 、实心方块square ，默认disc
			在ul里面  <li></li>
		- 代码
			<ul>
				<li>财务部</li>
				<li>学工部</li>
				<li>人事部</li>
			</ul>

5、图像标签（*******）
	* <img src="图片的路径"/>
		- src: 图片的路径
		- width：图片的宽度
		- height：图片的高度

		- alt: 图片上显示的文字，把鼠标移动到图片上，停留片刻显示内容
			** 有些浏览器下不显示（没有效果）


6、路径的介绍
	* 分类：两类
	** 绝对路径
		- C:\Users\asus\Desktop\0413\day01\code\a.jpg
		- http://www.baidu.com/b.jpg

	** 相对路径
		- 一个文件相对于另外一个文件的位置
		- 三种：
			** html文件和图片在一个路径下，可以直接写文件名称
				- <img src="b1.jpg" alt="这是一个美女"/>

			** 图片在html的下层目录
				在html文件中，使用img文件夹下面的a.jpg

				-- C:\Users\asus\Desktop\0413\day01\code\   4.html
				-- C:\Users\asus\Desktop\0413\day01\code\   img\a.jpg
				*** 在html中使用图片 4.html和img在一个路径下
					img\a.jpg
			
			** 图片在html文件的上层目录
				
				--- C:\Users\asus\Desktop\0413\day01\   code\4.html
				--- C:\Users\asus\Desktop\0413\day01\   c.png

				*** html文件所在的目录和图片是一个目录
					** 图片和html文件是什么关系？
						- 图片在html的所在目录的上层目录 day01
					** 怎么表示上层路径  ../
					- ../: day01
						-- ../c.png
					** 想要表示上层的上层 ../../

7、案例一：列表标签的使用（作业：完成剩余的部分）

8、超链接标签（******）
	* 链接资源(******)
		- <a href="链接到资源的路径"> 显示在页面上的内容  </a>
			** href: 链接的资源的地址
			** target：设置打开的方式 ，默认是在当前页打开
				-- _blank : 在一个新窗口打开
				-- _self: 在当前页打开 默认
		- 当超链接不需要到任何的地址 在href里面加#
			- <a href="#">这是一个超链接2</a>

	* 定位资源
		** 如果想要定位资源：定义一个位置 
			<a name="top">顶部</a>
		** 回到这个位置
			<a href="#top">回到顶部</a>
		
		** 引入一个标签 pre：原样输出
	
9、表格标签（****重要的标签*****）
	* 可以对数据进行格式化，使数据显示更加清晰

	* <table></table>: 表示表格的范围
		- border：表格线
		- bordercolor：表格线的颜色
		- cellspacing：单元格直接的距离
		- width：表格的宽度
		- height：表格的高度

	** 在table里面 <tr></tr>
		- 设置对齐方式 align： left  center  right

	   *** 在tr里面 <td></td>
	   - 设置显示方式 align： left  center  right

	   *** 使用th也可以表示单元格
		- 表示可以实现居中和加粗

	* 代码
		<table border="1" bordercolor="blue" cellspacing="0" width="200" height="150">
	
	* 画图分析表格的写法
		- 首先定义一个表格的范围使用table
			- 定义一行使用 tr
			- 定义一个单元格使用 td
	** 操作技巧：
		- 首先数有多少行 ，数每行里面有多少个单元格
	
	** 表格的标题
		<caption></caption>

	** 合并单元格 
		- rowspan：跨行
			** <td rowspan="3">人员信息</td>
		- colspan：跨列
			** <td colspan="3">人员信息</td>

10、表单标签（****今天最重要的标签****）
	* 可以提交数据到开心网的服务器，这个过程可以使用表单标签实现

	* <form></form>: 定义一个表单的范围
		- 属性
			** action： 提交到地址，默认提交到当前的页面
			** method:  表单提交方式 
				- 常用的有两种  get和post，默认是get请求

			** 面试题目： get和post区别
				1、get请求地址栏会携带提交的数据，post不会携带（请求体里面。在第七天时候讲http协议时候）
				2、get请求安全级别较低，post较高
				3、get请求数据大小的限制，post没有限制
			
			** enctype：一般请求下不需要这个属性，做文件上传时候需要设置这个属性（第22天时候讲文件上传）

	** 输入项：可以输入内容或者选择内容的部分
		- 大部分的输入项 使用  <input type="输入项的类型"/>

		******* 在输入项里面需要有一个name属性

		*** 普通输入项：<input type="text"/>
		*** 密码输入项：<input type="password"/>


		*** 单选输入项：<input type="radio"/>
			- 在里面需要属性 name
			- name的属性值必须要相同
			- 必须有一个value值

			**** 实现默认选中的属性 
				-- checked="checked"

		*** 复选输入项：<input type="checkbox"/>
			- 在里面需要属性 name
			- name的属性值必须要相同
			- 必须有一个value值

			**** 实现默认选中的属性 
				-- checked="checked"
		
		*** 文件输入项（在后面上传时候用到）
			- <input type="file"/>
		

		*** 下拉输入项（不是在input标签里面的）
			<select name="birth">
				<option value="1991">1991</option>
				<option value="1992">1992</option>
				<option value="1993">1993</option>
			</select>

			- 默认选择
				*** selected="selected"
		
		*** 文本域
			<textarea cols="10" rows="10"></textarea>
		
		*** 隐藏项（不会显示在页面上，但是存在于html代码里面）
			<input type="hidden" />
		
		*** 提交按钮
			<input type="submit"/>
			<input type="submit" value="注册"/>
			
			- file:///C:/Users/asus/Desktop/0413/day01/code/10-表单标签一.html
			 ?sex=on&love=on&love=on&birth=1991
			
			当在输入项里面写了name属性之后 
			- file:///C:/Users/asus/Desktop/0413/day01/code/10-表单标签一.html
			?phone=2222&pwd=3333&sex=on&love=on&birth=1993&tex=aaaaaaaa&hid=

			- file:///C:/Users/asus/Desktop/0413/day01/code/10-表单标签一.html?
			phone=130111111&pwd=123456&sex=nv&love=y&love=p&love=pp&birth=1992&tex=good+love&hid=

			** ?输入项name的值=输入的值&
			** 参数类似于key-value形式

		*** 使用图片提交
			<input type="image" src="图片路径"/>
		
		*** 重置按钮： 回到输入项的初始状态
			<input type="reset"/>
		
		*** 普通按钮(和明天讲js在一起使用的)
			<input type="button" value=""/>

11、案例：使用表单标签实现注册页面
		- 使用表格实现页面效果
		- 超链接不想要他有效果 href="#"
		- 如果表格里面的单元格没有内容， 使用空格作为占位符 &nbsp;
		- 使用图片提交表单 <input type="image" src="图片的路径"/>

12、html中的其他的常用标签的使用
	b : 加粗
	s ：删除线
	u ：下划线
	i ：斜体
	
	pre ：原样输出
	
	sub : 下标
	sup : 上标

	p ：段落标签 比br标签多一行
	
	====明天css时候一直使用
	div ：自动换行
	span：在一行显示

13、html的头标签的使用
	* html两部分组成 head和body
	** 在head里面的标签就是头标签

	** title标签：表示在标签上显示的内容
	** <meta>标签：设置页面的一些相关内容
		- <meta name="keywords" content="毕姥爷，熊出没，刘翔">
		  <meta http-equiv="refresh" content="3;url=01-hello.html" />
	** base标签：设置超链接的基本设置
		- 可以统一设置超链接的打开方式 
		 <base target="_blank"/>
	** link标签：引入外部文件
		** 明天css，可以使用link标签引入css文件
		
14、框架标签的使用（会用）
	* <frameset>
		- rows:按照行进行划分
			** <frameset rows="80,*">

		- cols:按照列进行划分
			** <frameset cols="80,*">
	* <frame>
		- 具体显示的页面
			- <frame name="lower_left" src="b.html"> 
	
	***  使用框架标签时候，不能写在body里面，使用了框架标签，需要把body去掉

	* <frameset rows="80,*">                        //把页面划分成上下两部分 
	     <frame name="top" src="a.html">             //上面页面
	
		<frameset cols="150,*">                     //把下面部分划分成左右两部分
			<frame name="lower_left" src="b.html">  //左边的页面
			<frame name="lower_right" src="c.html"> //右边的页面
		</frameset> 
	</frameset> 

	* 如果在左边的页面超链接，想让内容显示在右边的页面中
		- 设置超链接里面属性 target值设置成名称
		- <a href="01-hello.html" target="right">超链接1</a>

15、a标签的扩展（了解）
	- 百度是网络资源
	- 当a标签里面访问网络资源时候，必须要加一个协议 http：表示一个网络的公共协议，
	 如果加上http协议之后，自动识别访问资源是一个网络资源

	- 当浏览器里面找到相关协议，首先看这个协议是不是公共协议http。
	如果不是公共协议，会去本地电脑找支持这个协议的应用程序。

16、今天内容的总结
	1、html操作思想（****）
		* 使用标签把要操作的数据包起来，通过修改标签的属性值，来实现标签内数据样式的变化
	2、font标签 属性：size 取值范围 1-7  color：英文单词，十六进制数 #ffffff
	3、标题标签 <h1></h1>.....<h6></h6> : 从h1到h6越来越小，自动换行
	4、注释 <!-- html的注释 -->

	5、列表标签
		** <dl> <dt></dt> <dd></dd></dl>
		** 有序 <ol><li></li></ol>
		** 无序 <ul><li></li></ul>
	
	6、图像标签(******)
		<img src="图片的路径" width="" height="" alt=""/>
		**  alt:浏览器兼容性很差
	
	7、路径（相对路径）(****)
		** 在同一级目录 ：直接写
		** 在下一层目录： images/1.jpg
		** 在上层目录： ../
	
	8、超链接标签（*****）
		<a href="路径">显示在页面上的内容</a>
		- 打开方式 target="_self  _ blank"
		- 默认是在当前页面打开
	
	9、表格标签（*****）
		<table>
			<tr>
				<td></td>
				<th></th>  //加粗和居中
			</tr>
		</table>
		- 技巧：先数有多少行，数每行里面有多少个单元格
	
	10、表单标签（*** 今天最重要的标签***）
		* <form></form>: 
			- action: 提交到地址
			- method：提交方式 ：常用的有两种 get和post
			- get和post区别

			- enctype属性（上传时候使用）
		* 输入项
			* 输入项里面写name属性
			* 普通输入项 <input type="text"/>
			* 密码：password
			* 单选框：radio
			* 复选框：checkbox
			* 下拉框
				<select name="">
					<option value=""></option>
				</select>
			* 文本域
				<textarea cols="" rows="" name=""></textarea>
			
			* 文件 file

			* 提交按钮 submit
			* 重置  reset
			* 使用图片提交 <input type="image" src=""/>

			* 隐藏项 hidden
			* 普通按钮 button
		
	11、div和span(******)

	12、框架标签（会用）
		