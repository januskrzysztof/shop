<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="../../layout/taglib.jsp" %>

<div class="row"><h2>Search for products</h2></div>

<form class="navbar-form" action="/product/search" method="post">
    <div class="form-group">
        <label for="productName" style="color:darkgrey">Search</label>
        <input type="text" class="form-control" id="productName" name="productName">
        <select class="form-control" id="categoryName" name="categoryName">
            <option value="all">All</option>
            <option value="books">Books</option>
            <option value="e-books">E-books</option>
            <option value="music">Music</option>
            <option value="movies">Movies</option>
            <option value="games">Games</option>
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
            <td><img src="${product.photoUrl}" height="80"></td>
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
            <td>
                <a href="/cart/add/${product.id}">
                    <button type="button" class="btn btn-primary btn-xs">Add to cart</button>
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>