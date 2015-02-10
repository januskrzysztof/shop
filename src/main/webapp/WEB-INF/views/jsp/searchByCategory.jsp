<%@ include file="../layout/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search by category</title>
</head>
<body>

<h1>Choose category</h1>

<form action="/searchByCategory" method="POST">
    Find Product <input type="text" id="categoryName" name="categoryName"/>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <input type="submit" value="Search">
</form>

<h2>Results for: ${categoryName}</h2>

<c:forEach var="product" items="${productsInCategory}">
    <tr>
        <td>${product.getName()}</td>
        <td>${product.getNetPrice()}</td>
        <td>Foto not available yet</td>
        <br><br>
    </tr>
</c:forEach>

</body>
</html>
