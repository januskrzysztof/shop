<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="../../layout/taglib.jsp" %>

<div class="row"><h2>Search for products</h2></div>

<form class="form-inline" action="/product/search" method="post">
    <div class="form-group">
        <label for="productName">Search</label>
        <input type="text" class="form-control" id="productName" name="productName" placeholder="key words">
        <select class="form-control" id="categoryName" name="categoryName">
            <option value="All">All</option>
            <option value="Books">Books</option>
            <option value="E-books">E-books</option>
            <option value="Music">Music</option>
            <option value="Video">Video</option>
            <option value="Games">Games</option>
        </select>
    </div>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <button type="submit" class="btn btn-default">
        <span class="glyphicon glyphicon-search"></span>
    </button>
</form>

<br><br>

<div class="row"><h2>Results for: ${productName} in category ${categoryName}</h2></div>

<table class="table table-hover">
    <thead>
    <tr>
        <th>Photo</th>
        <th>Product name</th>
        <th>Price</th>
        <sec:authorize access="hasRole('ROLE_ADMIN')">
            <th>Admin Action</th>
        </sec:authorize>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="product" items="${products}">
        <tr>
            <td>Foto not available yet</td>
            <td><a href="/product/detail/${product.id}">${product.name}</a></td>
            <td>${product.netPrice}</td>
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <td>
                    <a href="/product/edit/${product.id}">
                        <button type="button" class="btn btn-primary btn-xs">Edit</button>
                    </a>
                    <a href="/product/remove/${product.id}">
                        <button type="button" class="btn btn-primary btn-xs btn-danger">Remove</button>
                    </a>
                </td>
            </sec:authorize>
        </tr>
    </c:forEach>
    </tbody>
</table>