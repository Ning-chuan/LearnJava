<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<html>
<head>
    <title>银行主页</title>
</head>
<body>
    <%
        String aname = request.getParameter("aname");
    %>
    ===============================<br>
    ======= 欢迎<%=aname%>进入银行系统 =======<br>
    ===============================<br>
    请输入操作项<br>
    <a href="inquiry?aname=<%=aname%>">查询</a><br>
    <a href="depositPage.jsp?aname=<%=aname%>">存款</a><br>
    <a href="">取款</a><br>
    <a href="">转账</a><br>
</body>
</html>
