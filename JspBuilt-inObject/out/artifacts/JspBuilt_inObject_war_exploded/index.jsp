<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/22
  Time: 21:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <%
      String name = "于自言";
      String button = "按钮";
    %>
    <a href="">这是一个超链接</a>
    这是一个输入框：<input type="text" >
    <input type="button" value="<%=button%>">
    <%
      int i = 2;
    %>
    <%=name%>
  </body>
</html>
  <%!
    private String test = "测试属性";
    public void test(){
      System.out.println(test);
    }
  %>
