<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="../../layout/taglib.jsp" %>

<div class="col-xs-6 col-sm-6">
    <h2>Category: ${categoryName}</h2>
</div>

<div class="col-xs-6 col-sm-6">
    <form class="form-inline" action="/product/search" method="post">
        <div class="form-group">
            <label for="productName">Search in ${categoryName}</label>
            <input type="text" class="form-control" id="productName" name="productName">
            <input type="hidden" id="categoryName" name="categoryName" value="${categoryName}">
        </div>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <button type="submit" class="btn btn-default">
            <span class="glyphicon glyphicon-search"></span>
        </button>
    </form>
</div>

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
    <c:forEach var="product" items="${productsInCategory}">
        <tr>
            <td><img src="" class="img-responsive" alt="Product image"></td>
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