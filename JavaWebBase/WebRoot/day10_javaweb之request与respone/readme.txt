请求响应对象

request和response
  * 当服务器接收到请求后，服务器会创建request和response对象，把请求数据封装到request对象中；
  * 然后调用Servlet的service()方法时把这两个对象传递给service()方法；
  * 在service()方法中可以通过request对象获取请求数据，可以使用response对象向客户端完成响应；
  
  * 每次请求服务器都会创建新的request和response对象，即每个请求有自己独自的request和response对象。

==============================
==============================
==============================

response对象

1. response简介
  response是响应对象，用来在Servlet的service()方法中向客户端响应数据。
  response的功能如下：
  * 设置响应头
  * 发送状态码
  * 设置响应正文
  * 重定向

2. response响应正文
  * ServletOutputStream getOutputStream()：用来向客户端响应字节数据；
  * PrintWriter getWriter()：用来向客户端响应字符数据；

  response.getWriter().print("你好");//向客户端响应字符数据
  byte[] bytes = ...;
  response.getOutputStream().write(bytes);//向客户端响应字节数据

3. response字符编码
  * Tomcat响应数据默认使用ISO-8859-1
  * 通常浏览器默认使用GBK编码
  * response.setCharacterEncoding("utf-8");//设置response.getWriter()的字符编码

  1)
  response.getWriter().print("大家好");
  因为Tomcat默认使用的是ISO-8859-1编码，不支持中文。所以一定编码！

  2)
  response.setCharacterEncoding("utf-8");
  response.getWriter().print("大家好");
  因为已经设置了字符流编码为utf-8，所以响应给客户端的数据为utf-8编码！
  但因为浏览器默认使用的是gbk来解析响应数据，所以乱码！如果浏览器使用utf-8编码，那么就不会乱码了。

  3)
  response.setCharacterEncoding("gbk");
  response.getWriter().print("大家好");
  因为设置了字符流编码为gbk，所以响应给客户端的数据为gbk编码！
  因为浏览器默认使用gbk来解析数据，所以不会出现乱码！如果浏览器使用utf-8编码，那么就会出现乱码！

  4)
  response.setContentType("text/html;charset=utf-8");
  response.getWriter().print("大家好");
  setContentType()方法有两个作用：
  * 设置字符流编码。等同与调用了response.setCharacterEncoding("utf-8")；
  * 设置Content-type响应头，即通知浏览器响应数据的编码为utf-8。
  因为设置字符流的编码为utf-8，所以响应给客户端数据为utf-8编码
  因为设置了Content-type头为utf-8，所以浏览器会使用utf-8来解析响应数据
  没有乱码！

  5)
  response.setContentType("text/html;charset=gbk");
  response.getWriter().print("大家好");
  * 设置了字符流为gbk，所以响应给客户端的数据为gbk
  * 设置了Content-type头为gbk，所以通知浏览器响应数据为gbk编码
  没有乱码！

  6)
  response.setHeader("Content-type", "text/html;charset=utf-8")
  等同于
  repsonse.setContentType("text/html;charset=utf-8")

  7)
  response.getOutputStream().write("大家好".getBytes("gbk"));
  响应的数据是gbk编码
  客户端浏览器默认使用gbk编码
  所以没有乱码

======================

4. response字符流缓冲区
  response字符流缓冲区大小为8KB，当向字符流中写入数据后，数据可能只在缓冲区中，而没有发送到浏览器。
  可以调用response.flushBuffer()或response.getWriter().flush()方法刷新缓冲区，把数据发送到浏览器。

======================

5. 设置响应头

  response.setHeader("Content-type", "text/html;charset=utf-8");
  等同与
  response.setContentType("text/html;charset=utf-8");

  response.setHeader("Refresh", "5; URL=http://www.itcast.cn");

======================

6. 指定状态码

response.setStatus(200)：设置状态码为200
response.sendError(404, “您要查找的资源不存在”)：设置状态码为404
repsonse.sendError(500, “服务器出氏了”)：设置状态码为500

在调用sendError()方法时，不只是设置了状态码，而且还会给浏览器一个显示错误的页面。

======================

7. 重定向

response.sendStatus(302);
repsonse.setHeader("Location", "http://www.baidu.com");

快捷的方法重定向：

response.sendRedirect("http://www.baidu.com");

* 重定向是两次请求
* 重定向不局限与当前应用，也可以是其他应用，例如重定向到百度
* 重定向响应码为302，而且必须有Location响应头
* 重定向与response响应流同时使用。

======================
======================
======================

request

1. request功能介绍
 * 获取请求头
 * 获取请求参数
 * Servlet三大域对象之一
 * 请求包含和请求转发

2. request域方法
 * void setAttribute(String name, Object value)：添加或替换request域属性
 * Object getAttribute(String name)：获取request域指定名称的域属性
 * void removeAttribute(String name)：移除request域指定名称的域属性
 * Enumeration getAttributeNames()：获取所有request域的属性名称

3. request获取请求头
 * String getHeader(String name)：获取指定名称的请求头
 * int getIntHeader(String name)：获取指定名称的请求头，把值转换成int类型。
 * Enumeration getHeaderNames()：获取所有请求头名称

4. request请求数据相关其他方法
 重点：
 * String getMethod()：获取请求方式
 * String getContextPath()：获取上下文路径，即“/” + 应用名称，例如：/day05_1
 * void setCharacterEncoding(String)：设置请求体的编码
 * String getRemoteAddr()：获取客户端IP地址

 非重点：
 * int getContentLength()：获取请求体字节数
 * Locale getLocale()：获取请求Locale，例如zh_CN表示中文，中国
 * String getCharacterEncoding()：获取请求体编码，在没有调用setCharacterEncoding()之前该方法返回null
 * String getQueryString()：获取参数列表，例如：username=zhangSan&password=123
 * String getRequestURI()：返回请求URI路径，从应用名称开始，到参数之前这一段，例如：/day05_1/AServlet
 * StringBuffer getRequestURL()：整个请求URL，不包含参数部分
 * String getServletPath()：返回Servlet路径，从应用名称后开始，到参数之前这一段，不包含应用名称。
 * String getServerName()：返回主机名，例如：localhost
 * int getServerPort()：返回服务器端口号，例如：8080

5. 请求参数
 获取请求参数，即获取超链接上的参数和表单中的参数
 * String getParameter(String name)：获取指定名称的参数，如果存在同名参数，那么该方法只获取第一个参数值
 * String[] getParameterValues(String name)：获取指定名称的参数，因为同名参数的存在，所以返回值为String[]
 * Enumeration getParameterNames():获取所有参数名称
 * Map getParameterMap()：获取所有参数，封装到Map中，key为参数名称，value为参数值。

6. 请求包含和请求转发
 * 请求包含和请求转发都是在一个请求中，访问两个Servlet。
 * 请求包含和请求转发都是有一个Servlet去调用执行另一个Servlet
 * 请求包含和请求转发都可以共享request中的数据，因为都是一个请求。
 
 * 从AServlet请求转发到BServlet
   > 在AServlet中可以设置响应头
   > 在AServlet中不能使用响应流输出
 
 如果在AServlet中执行了响应操作，那么有两种可能：
 * 如果在AServlet中响应的数据导致response提交，那么在转发时抛出异常；
 * 如果在AServlet中响应的数据没有导致response提交，那么response中的数据会被清空。

 * 从AServlet请求包含BServlet
   > 在AServlet可以设置响应头
   > 在AServlet可以使用响应流输出

 * 请求转发和请求包含都要使用RequestDispatcher对象：RequestDispatcher rd = request.getRequestDispatcher("/BServlet");
 * 请求转发执行RequestDispatcher的forward()方法：rd.forward(request,response);
 * 请求包含执行RequestDispatcher的include()方法：rd.include(request,response);
 * 请求转发和请求包含的路径都是服务器端路径，相对当前应用


7. 请求转发与重定向
 * 请求转发是一个请求，而重定向是两个请求
 * 请求转发，是使用RequestDispatcher来完成，重定向使用response对象来完成
 * 请求转发的路径都是服务器端路径，而重定向是客户端路径，需要给出应用名称
 * 请求转发在浏览器地址栏中的地址是第一个Servlet的路径，而重定向在地址栏中的地址是第二个请求的Servlet的路径
 * 请求转发中的两个Servlet是可以共享request数据的，而重定向因为是两个请求，所以不能共享request数据
 * 请求转发只能转发到本应用的其他Servlet，而重定向可以重定向到其他应用中。

8. request.getParameter()和request.getAttribute()
 * getParameter()是获取客户端参数，它是从客户端传递给服务器的数据。
 * getAttribute()是获取服务器端自己设置的数据，而不是客户端的数据。
 * request没有setParameter()方法，不能自己设置参数，参数都由客户端传递
 * request有setAttribute()方法，在getAttribute()之前，需要先setAttribute()才能获取到。
 * getAttribute()和setAttribute()是用来在请求转发和请求包含中的多个Servlet中共享数据。

======================
======================
======================

路径

1. 客户端路径和服务器端路径
 * 客户端路径需要给出应用名称，例如：/day05_1/AServlet
 * 服务器端路径无需给出应用名称，例如：/AServlet

2. 客户端路径
 1). 页面中都是客户端路径：
 * 超链接的href
 * 表单的action
 * <img>的src
 2). 重定向也是客户端路径：response.sendRedirect("/day05_1/BServlet");

3. 服务器端路径
 * <url-pattern>
 * 请求转发和请求包含
 * ServletContext获取资源等

======================
======================
======================

乱码

1. 请求编码
 * 客户端发送的数据编码：由浏览器来决定：
  1). 如果是在地址栏中直接给出url，那么一般都是默认为GBK，但这个可能不太大。
  2). 如果是通过页面上的表单或超链接发出请求，那么由当前页面的编码来决定发送的参数的编码。

 * 无论浏览器发送过来的是什么编码的数据，Tomcat都默认使用ISO-8859-1来解码
  1). POST：可以使用request.setCharacterEncoding()方法来设置请求体数据的编码，因为POST请求参数在请求体中，所以是可以设置编码的。在使用request.getParameter()方法获取参数之前，先使用request.setCharacterEncoding()方法来设置编码即可。
  2). GET：没有方法可以设置它，因为参数在url中。所以使用request.getParameter()获取到的数据一定是错误的使用了iso-8859-1解码的。可以再使用iso-8859-1把字符串转回到byte[]，再重新使用正确的编码来解码即可。
  String s = request.getParameter("s");//使用iso-8859-1错误的解码了
  byte[] bytes = s.getBytes("iso-8859-1");//退回错误的解码，让字符串通过iso-8859-1返回到字节数据，即还原字节数据
  s = new String(bytes, "utf-8");//重新使用正确的utf-8来解码。
 
 






