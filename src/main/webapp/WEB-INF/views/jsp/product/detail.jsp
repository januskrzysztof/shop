<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="../../layout/taglib.jsp" %>

<div class="row placeholders">
    <div class="col-md-2">
        <img src="" class="img-responsive" alt="Product image">
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
                <td>Quantity</td>
                <td>
                    <select id="quantity" name="quantity">
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                        <option value="6">6</option>
                        <option value="7">7</option>
                        <option value="8">8</option>
                        <option value="9">9</option>
                        <option value="10">10</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <a href="/cart/add/${product.id}/${quantity}">
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