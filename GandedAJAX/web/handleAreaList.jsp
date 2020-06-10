<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<option>==请选择==</option>
<c:forEach var="area" items="${requestScope.areaList}">
    <option value="${area.aid}">${area.aname}</option>
</c:forEach>
