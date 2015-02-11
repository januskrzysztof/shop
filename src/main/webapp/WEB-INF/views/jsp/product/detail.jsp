<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
                <th colspan="2" align="center">BUY</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>Price: </td>
                <td>${product.netPrice}</td>
            </tr>
            <tr>
                <td>Quantity</td>
                <td></td>
            </tr>
            <tr>
                <td colspan="2">Larry</td>
            </tr>
            </tbody>
        </table>
    </div>
</div>