<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="../../layout/taglib.jsp" %>

<div class="row placeholders">
    <div class="col-md-2">
        <img src="${product.photoUrl}" alt="Product image" width="150">
    </div>
    <div class="col-md-8">
        <h2>${product.name}</h2>

        <p>Description: ${product.description}</p>
    </div>
    <div class="col-md-2">
        <table class="table table-bordered">
            <thead>
            <tr>
                <td colspan="2" align="center"><b>BUY </b><span class="glyphicon glyphicon-shopping-cart"></span></td>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>Price:</td>
                <td>${product.netPrice}</td>
            </tr>
            <tr>
                <td colspan="2">
                    <a href="/cart/add/${product.id}">
                        <button type="button" class="btn btn-primary btn-xs">Add to cart</button>
                    </a>
                </td>
            </tr>
            </tbody>
        </table>
    </div>

    <sec:authorize access="hasRole('ROLE_ADMIN')">
        <td>
            <a href="/product/edit/${product.id}">
                <button type="button" class="btn btn-primary">Edit</button>
            </a>
            <a href="/product/remove/${product.id}">
                <button type="button" class="btn btn-primary btn-danger">Remove</button>
            </a>
        </td>
    </sec:authorize>

</div>