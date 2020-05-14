<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <%
      Cookie cookie1 = new Cookie("test1","testValue1");
      Cookie cookie2 = new Cookie("test2","testValue2");
      response.addCookie(cookie1);
      response.addCookie(cookie2);
    %>
    <script type="text/javascript">
      var cookieObject = document.cookie;
      alert(cookieObject);
    </script>
    <a href="test">测试链接</a>
  </body>
</html>
