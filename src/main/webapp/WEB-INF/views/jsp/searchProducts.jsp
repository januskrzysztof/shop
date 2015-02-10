<%@ include file="../layout/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products</title>
</head>
<body>

<h1>Search for products in store</h1>


<form action="/searchProducts" method="POST">
    Find Product <input type="text" id="productName" name="productName"/>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <input type="submit" value="Search">
</form>

<h2>Results for: ${productName}</h2>


<c:forEach var="product" items="${products}">
    <tr>
        <td>${product.getName()}</td>
        <td>${product.getNetPrice()}</td>
        <td>Foto not available yet</td>
        <br><br>
    </tr>
</c:forEach>

</body>
</html>
