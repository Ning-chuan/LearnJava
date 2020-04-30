<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="domain.Commodity" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        td{
            text-align:center;
        }
    </style>
    <script>
        window.onload = function () {
            var backElement = document.getElementById("backHomePage")
            backElement.onclick = function () {
                var formElement =document.getElementById("form")
                formElement.submit();
            }
        }
    </script>
    <title>结算页</title>
</head>
<body>
    <form id="form" action="index.jsp">
        <table border="1px" align="center" width="36%" height="50%">
        <tr>
            <th>商品名称</th><th>商品价格</th>
        </tr>
        <c:forEach var="commodity" items="${sessionScope.shoppingCar}">
            <tr>
                <td>${commodity.cname}</td>
                <td>${commodity.cprice}</td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="2">商品总价：${sessionScope.total}</td>
        </tr>
        <tr>
            <td>
                <input id="payment" type="button" name="payment" value="付款">
            </td>
            <td>
                <input id="backHomePage" type="button" name="backHomePage" value="返回首页">
            </td>
        </tr>
    </table>
    </form>
</body>
</html>
