<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<option>==请选择==</option>
<c:forEach var="city" items="${requestScope.cityList}">
    <option value="${city.cityId}">${city.cityName}</option>
</c:forEach>
