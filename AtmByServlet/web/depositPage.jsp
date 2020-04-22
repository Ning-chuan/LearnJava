<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>存款页</title>
</head>
<body>
    <%
        String aname = request.getParameter("aname");
    %>
    <form action="deposit" method="get">
        请输入存款金额：<input type="text" name="depositMoney" value=""><br>
        <input type="hidden" name="aname" value="<%=aname%>">
        <input type="submit" value="确定">
    </form>
</body>
</html>
