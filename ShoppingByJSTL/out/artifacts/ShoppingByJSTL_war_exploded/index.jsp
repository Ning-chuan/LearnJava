<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <script>
        window.onload = function () {
            var registerButton = document.getElementById("register");
            registerButton.onclick = function () {
                window.location.href = "register.html";
            }
        }
    </script>
    <title>Title</title>
</head>
<body>
        欢迎进入购物系统，请登录：<br>
        ${requestScope.result}
        <form action="login" method="post">
            请输入账号：<input type="text" name="uname" value=""><br>
            请输入密码：<input type="password" name="upassword" value=""><br>
            <input type="submit" value="登录">
            <input id="register" type="button" value="注册">
        </form>
</body>
</html>