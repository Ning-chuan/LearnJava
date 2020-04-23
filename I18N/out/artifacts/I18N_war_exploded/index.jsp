<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.Properties" %>
<%@ page import="java.io.FileReader" %>
<%@ page import="java.io.InputStream" %>
<%@ page import="jdk.internal.util.xml.impl.Input" %>
<%@ page import="java.io.InputStreamReader" %>
<%@ page import="java.io.BufferedReader" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <%
      //实现国际化  浏览器第一语言设置的什么 就展示什么语言
      //1 获取语言类型
      String acceptLanguage = request.getHeader("accept-language");
      //accept-language  zh-CN,zh;q=0.9
      //2 解析字符串得到目标语言
      String[] languages = acceptLanguage.split(",");
      String language = languages[0].split(";")[0];
      //3 确定语言包对应的文件名
      //  语言包放置在src目录下
      String languageFileName = "language("+language+").properties";
      //4 用classLoader加载
      //  如果不使用类加载器加载 将无法找到对应的 xxx.properties 文件
      //  因为web项目执行的是经过部署编译后的那些程序
      //  如果我们把项目部署在了Tomcat中 那这些程序将在Tomcat中的webapps文件夹下
      //  如果我们没有部署 那编译后的文件默认在 当前工程>out>artifacts
      InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(languageFileName);
      InputStreamReader isr = new InputStreamReader(is);
      Properties pro = new Properties();
      pro.load(isr);
      //5 取值
      String account = pro.getProperty("account");
      String password = pro.getProperty("password");
      String login = pro.getProperty("login");
    %>

    <form action="test" method="post">
      <%=account%><input type="text" name="name" value="">
      <%=password%><input type="password" name="password" value="">
      <input type="submit" value="<%=login%>">
    </form>

  </body>
</html>
