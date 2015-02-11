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
                <td colspan="2" align="center"><b>BUY </b><span class="glyphicon glyphicon-shopping-cart"></td>
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
                    <select>
                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                        <option>4</option>
                        <option>5</option>
                        <option>6</option>
                        <option>7</option>
                        <option>8</option>
                        <option>9</option>
                        <option>10</option>
                    </select>
                </td>
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
</div>