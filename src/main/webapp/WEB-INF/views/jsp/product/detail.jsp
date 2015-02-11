<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="row placeholders">
    <div class="col-md-4">
        <img src="" class="img-responsive" alt="Product image">
    </div>
    <div class="col-md-4">
        <h4>Title: ${product.name}</h4>

        <h2>Description: ${product.description}</h2>
    </div>
    <div class="col-md-4">
        <a href="product/search">
            <button type="button" class="btn btn-primary btn-lg">Orders</button>
        </a>
        <h4>Orders</h4>
    </div>
</div>