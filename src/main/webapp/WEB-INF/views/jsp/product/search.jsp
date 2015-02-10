<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="../../layout/taglib.jsp" %>

<div class="row"><h2>Search for products</h2></div>

<form class="form-inline" action="/product/search" method="post">
    <div class="form-group">
        <label for="productName">Search</label>
        <input type="text" class="form-control" id="productName" name="productName" placeholder="key words">
    </div>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <button type="submit" class="btn btn-default">
        <span class="glyphicon glyphicon-search"></span>
    </button>
</form>

<br><br>

<div class="row"><h2>Results for: ${productName}</h2></div>

<table class="table table-hover">
    <thead>
    <tr>
        <th>Photo</th>
        <th>Product name</th>
        <th>Price</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="product" items="${products}">
        <tr>
            <td>Foto not available yet</td>
            <td><a href="product/detail/${product.id}">${product.name}</a></td>
            <td>${product.netPrice}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>