1. Servlet生命周期方法是
  * init(ServletConfig)：只被调用一次
  * service(ServletRequest,ServletResponse)：被调用0~N次
  * destory()：只被调用一次

2. Http缺省请求方法是：GET

3. HttpServlet对GET请求的处理方法是：doGet()

4. <servlet>的子标签有：
  * <servlet-name>
  * <servlet-class>
  * <init-param>
  * <load-on-startup>

5. ServletConfig的作用：
  * 对应<servlet>的配置信息
  * 可以获取<servlet>中配置的<init-param>信息

6. Http响应头Content-type用来说明响应数据的MIME类型

7. HttpServlet理解
  * HttpServlet是GenericServlet的子类，实现了GenericServlet中的抽象方法
  * service(ServletRequest, ServletResponse)会调用本类的service(HttpServletRequest,HttpServletResponse)
  * service(HttpServletRequest,HttpServletResponse)方法会根请求方式来调用相对的处理方法，例如请求方式为GET，那么该方法会调用doGet()方法，请求方式是POST，那么会调用doPost()方法。所以我们应该去重写HttpServlet的doGet()或doPost()方法。

8. <url-pattern>通配符配置
  * <url-pattern>中可以使用通配符
  * 通配符要么在最前面，要么在最后，例如：*.do、/*都是正确的，但/*.jsp是错误的，因为*在中间，不是在最前面，也不是在最后面。
  * 必须以“/”或“*”开头

9. ServletContext理解
  * 一个Web应用只有一个ServletContext对象，它会在服务器启动时创建，会在服务器关闭时被销毁，它的生命与服务器相同。
  * 通常在整个Web应用中共享数据时可以使用ServletContext对象
  * 还可以使用ServletContext来获取Web资源的真实路径，servletContext.getRealPath("/WEB-INF/a.jpg");
  * ServletContext可以用来资源的MIME类型，例如：servletContext.getMimeType("a.jpg")，它会返回image/jpeg

10. <url-pattern>作用
  * 使用访问路径与Servlet绑定在一起

11. 请求转发和重定向的异同
  * 请求转发是通过RequestDispatcher对象的forward()方法完成的
  * 重定向是通过HttpServletResponse对象的sendRediect()方法完成的
  * 请求转发是在一个请求中跨越多个动态资源（jsp/servlet），所以多个动态资源之间可以共享request数据
  * 重定向是两次请求，第一次请求服务器响应给客户端的是302，以及Location响应头，通知客户端再次去请求新的资源，所以客户端又发出第二次请求。所以重定向中被请求的多个动态资源之间不能共享request数据。
  * 请求转发后，地址栏的url不会改变，因为是一个请求；
  * 重定向后，地址的rul会改变，因为是两个请求

12. 编写一个Servlet的可以通过哪些方式完成
  * 实现Servlet接口
  * 继承GenericServlet类
  * 继承HttpServlet类

13. 在HttpServlet中获取ServletContext对象的方法有：
  * 通过ServletConfig类的getServletContext()方法；
  * HttpServlet类也提供了getServletContext()方法


