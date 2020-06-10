<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>LOGIN</title>
    <script type="text/javascript">
      window.onload = function () {
        var registerEle = document.getElementById("register");
        registerEle.onclick = function () {
          window.location.href = "selectAllCountry";
        }
      }
    </script>
  </head>
  <body>
    <form>
      账号：<input type="text" name="name" value=""><br>
      密码：<input type="text" name="password" value=""><br>
      <input type="submit" value="登录">
      <input id="register" type="button" value="注册">
    </form>
  </body>
</html>
