<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1><fmt:message key="welcomeinfo"/></h1>
    <form>
        <fmt:message key="username"/>:<input type="text"><br>
        <fmt:message key="password"/>:<input type="text"><br>
        <input type="button" value='<fmt:message key="loginBtn"/>'>
    </form>
</body>
</html>