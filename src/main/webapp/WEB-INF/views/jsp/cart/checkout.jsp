<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../layout/taglib.jsp" %>

<form class="form-horizontal">

    <fieldset>
        <legend>My cart</legend>
    </fieldset>
</form>

<div class="col-md-5 col-sm-12">
    <div class="bigcart"></div>
    <h1>Your shopping cart</h1>
</div>

<div class="col-md-7 col-sm-12 text-left">
    <ul>
        <li class="row list-inline columnCaptions">
            <span>QTY</span>
            <span>ITEM</span>
            <span>Price</span>
        </li>
        <c:forEach var="cartProduct" items="${cart.cartProducts}">
            <li class="row">
                <span class="quantity">${cartProduct.quantity}</span>
                <span class="itemName">
                    <a href="/product/detail/${cartProduct.product.id}">${cartProduct.product.name}</a>
                </span>
                <span class="popbtn"><a class="arrow"></a></span>
                <span class="price">$${cartProduct.product.netPrice}</span>
            </li>
        </c:forEach>
        <li class="row totals">
            <span class="itemName">Total:</span>
            <span class="price">$${cart.totalPrice}</span>

            <span class="order"> <a class="text-center" href="/cart/order">ORDER</a></span>
        </li>

    </ul>
</div>

<c:forEach var="cartProduct" items="${cart.cartProducts}">
    <div id="popover" style="display: none">
        <a href="/cart/remove/${cartProduct.product.id}"><span class="glyphicon glyphicon-remove"></span></a>
    </div>
</c:forEach>