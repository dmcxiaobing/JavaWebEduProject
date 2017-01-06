动态资源：需要转换成静态资源后再响应给客户端，例如：jsp、servlet，其他语言的动态资源有：asp、php
静态资源：无需转发即可直接响应给客户端，例如：html、css、javascript

------------------------

Tomcat：
1. 开源免费的web服务器
2. jsp/servlet容器，支持Servlet规范
3. Tomcat默认端口为8080，可以在server.xml文件中修改端口
4. Tomcat启动前必须配置JAVA_HOME环境变量
5. Tomcat不支持JavaEE规范

------------------------

Tomcat主要目录结构：
bin：二进制可执行文件，包含启动和关闭tomcat文件；
conf：配置文件，其中包含了server.xml、context.xml、web.xml等；
webapps：存放应用程序的目录

------------------------

JavaWeb应用程序的标准目录结构

应用目录/WEB-INF
应用目录/WEB-INF/web.xml
应用目录/WEB-INF/classes
应用目录/WEB-INF/lib

------------------------

创建JavaWeb应用程序流程：

1. 创建web项目目录
2. 设计web项目目录结构
3. 编写web项目代码
4. 部署web项目到Tomcat的webapps目录下
5. 运行web项目

------------------------

访问web项目资源：
例如：项目名为hello，有index.html文件在hello目录下
访问路径为：http://localhost:8080/hello/index.html

------------------------

发布项目的三种方式：
1. 把项目放到webapps下
2. 在server.xml中配置项目路径
3. 在conf/caalina/localhost/下创建xml，然后配置项目路径

------------------------

http协议的格式

1. 首行
2. 头
3. 空行
4. 体

------------------------

http请求头：
* Referer：请求来自哪里，如果是在http://www.baidu.com上点击链接发出的请求，那么Referer的值为http://www.baidu.com。如果是直接在浏览器地址栏中直接输入的地址发出的请求，那么Referer为空。
　　用途：
　　　　* 统计来源：例如通过百度访问本网站的次数
　　　　* 防盗链：例如防止非点击本站链接来直接访问本站资源的行为

------------------------

http响应头：
三种禁用浏览器缓存的响应头
* Expires: -1
* Cache-Control: no-cache
* Pragma: no-cache



------------------------

状态码：
200 --> 成功
302 --> 请求重定向
304 --> 请求资源没有改变
404 --> 请求的资源不存在，属性客户端错误。
500 --> 服务器内部错误


------------------------

GET请求：
1. 请求数据长度不能超过1K
2. 请求参数会在浏览器地址栏中显示出来
3. GET请求没有请求体（请求正文），参数是追加在url后面

POST请求：
1. 请求数据没有上限
2. 请求参数不会在浏览器地址栏中显示
3. 有请求体（请求正文）
4. 请求参数默认使用URL编码









