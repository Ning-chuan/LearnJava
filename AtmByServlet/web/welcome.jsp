<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<html>
<head>
    <title>银行主页</title>
</head>
<body>
    <%
        String aname = (String)session.getAttribute("aname");
    %>
    ===============================<br>
    ======= 欢迎<%=aname%>进入银行系统 =======<br>
    ===============================<br>
    请输入操作项<br>
    <a href="inquiry">查询</a><br>
    <a href="depositPage.jsp">存款</a><br>
    <a href="">取款</a><br>
    <a href="">转账</a><br>
</body>
</html>
