<%@ page import="domain.Commodity" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>>
<html>
<head>
    <style type="text/css">
        td{
            text-align: center;
        }
    </style>
    <script type="text/javascript">
        window.onload = function () {
            var buttons = document.getElementsByClassName("button");
            for(var i = 0;i<buttons.length;i++){
                buttons[i].onclick = function () {
                    var formElement = document.getElementById("form");
                    var flag = document.getElementById("flag")
                    flag.value = this.value//把按钮的信息赋给隐含域一并提交
                    formElement.submit();
                }
            }
        }
    </script>
    <title>商品展示</title>
</head>
<body>
    <form id="form" action="saveCommodity" method="post">
        <table  border="1px" align="center" width="50%" height="50%">
            <tr>
                <th></th><th>商品名称</th><th>商品价格</th>
            </tr>
            <c:forEach var="commodity" items="${requestScope.commodityList}" >
                <tr>
                    <td><input type="checkbox" name="cid" value="${commodity.cid}"></td>
                    <td>${commodity.cname}</td>
                    <td>${commodity.cprice}</td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="3">
                    <input class="button" type="button" value="继续购物">
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input class="button" type="button" value="结算">
                </td>
            </tr>
        </table>
        <!-- 添加一个隐含域，把（继续购物/结算）也一并提交，方便后续处理 -->
        <input id="flag" type="hidden" name="flag" value="">
    </form>
</body>
</html>
