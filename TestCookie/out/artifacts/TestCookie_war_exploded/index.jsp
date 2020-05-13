<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <%
      Cookie cookie = new Cookie("test","testValue");
      response.addCookie(cookie);
    %>
    <a href="test">测试链接</a>
  </body>
</html>
