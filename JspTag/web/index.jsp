<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="includeHTML.html" %>
<%-- 上面导入html资源时 html资源中的中文会乱码 而导入jsp文件不会 --%>
<%-- 原因: tomcat会对jsp资源进行解析并编译 这个过程会遵循pageEncoding设置的字符集 --%>
<%--       但是当导入的是html资源时 tomcat不需要编译 直接给到浏览器展示 --%>
<%--       这个过程会使用平台默认字符集 而window默认字符集是GBK 所以会产生乱码 --%>
<%-- 解决: 在web.xml文件中配置相关的拦截信息 让jsp文件导入html文件时使用UTF-8字符集 --%>
<%@include file="includeJSP.jsp" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  我是主页jsp资源<br>
  </body>
</html>
