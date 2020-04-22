<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <script type="text/javascript">
        window.onload = function () {
            var backButton = document.getElementById('back');
            backButton.onclick = function () {
                window.history.back();
            }
        }
    </script>
</head>
<body>
    <%
        String aname = request.getParameter("aname");
        Float abalance = (Float)request.getAttribute("abalance");
    %>
    ==== 尊敬的<%=aname%>，您的余额为：====<br>
    <%=abalance%><br>
    <input id="back" type="button" value="返回">
</body>
</html>
