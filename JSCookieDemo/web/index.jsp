<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <%
    Cookie[] cookies = request.getCookies();
    if(cookies != null && cookies.length > 1){
      request.getRequestDispatcher("login").forward(request,response);
    }
    %>
    ${requestScope.result}
    <form action="login" method="post">
      账号：<input type="text" name="uname" value=""><br>
      密码：<input type="password" name="upassword" value=""><br>
      <input type="checkbox" name="flag" value="true">7天内免费登录<br>
      <input type="submit" value="登录">
    </form>
  </body>
</html>
