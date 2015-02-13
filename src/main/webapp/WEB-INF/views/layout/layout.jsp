<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>

    <%@ include file="taglib.jsp" %>

    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/bootstrap-theme.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/signin.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/dashboard.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/cart.css" />" rel="stylesheet">

    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>

    <script src="<c:url value="/resources/js/jquery.min.js" />"></script>
    <script src="<c:url value="/resources/js/jquery.validate.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
    <script src="<c:url value="/resources/js/cart.js" />"></script>

    <title><tiles:getAsString name="title" defaultValue=""/></title>
</head>
<body>

<tilesx:useAttribute name="current"/>

<div class="container">

    <!-- Static navbar -->
    <nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                        aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href='<spring:url value="/" />'>Shop</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li class="${current == 'index' ? 'active' : ''}"><a href='<spring:url value="/" />'>Home</a></li>
                    <li class="${current == 'about' ? 'active' : ''}"><a href="/about">About</a></li>
                    <li class="${current == 'contact' ? 'active' : ''}"><a href="/contact">Contact</a></li>
                </ul>

                <ul class="nav navbar-nav navbar-center">
                    <li>
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
        </li>
        </ul>

        <ul class="nav navbar-nav navbar-right">
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <li class="${current == 'account' ? 'admin' : ''}"><a href="/admin">Admin Dashboard</a></li>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                <li class="${current == 'account' ? 'active' : ''}"><a href="/account">My account</a></li>
                <li class="${current == 'cart' ? 'active' : ''}"><a href="/cart/checkout">My cart</a></li>
                <li><a href="/logout">Sign Out</a></li>
            </sec:authorize>
            <sec:authorize access="isAnonymous()">
                <li class="${current == 'login' ? 'active' : ''}"><a href="/login">Sign In</a></li>
                <li class="${current == 'registration' ? 'active' : ''}"><a href="/registration">Register</a>
                </li>
            </sec:authorize>
        </ul>
    </div>
</div>
</nav>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <ul class="nav nav-sidebar">
                    <li>ADMIN DASHBOARD</li>
                    <li class="${current == 'add' ? 'active' : ''}"><a href="/product/add">Add product</a></li>
                    <li class="${current == 'edit' ? 'active' : ''}"><a href="/product/search">Edit product</a></li>
                    <li class="${current == 'users' ? 'active' : ''}"><a href="/users/users">Users</a></li>
                    <li class="${current == 'orders' ? 'active' : ''}"><a href="">Orders</a></li>
                </ul>
            </sec:authorize>
            <ul class="nav nav-sidebar">
                <li>MAIN</li>
                <li class="${current == 'search' ? 'active' : ''}"><a href="/product/search">Search products</a>
                </li>
            </ul>
            <ul class="nav nav-sidebar">
                <li>CATEGORIES</li>
                <li class="${current == 'books' ? 'active' : ''}"><a href="/categories/books">Books</a></li>
                <li class="${current == 'e-books' ? 'active' : ''}"><a href="/categories/e-books">E-books</a></li>
                <li class="${current == 'music' ? 'active' : ''}"><a href="/categories/music">Music</a></li>
                <li class="${current == 'movies' ? 'active' : ''}"><a href="/categories/movies">Movies</a></li>
                <li class="${current == 'games' ? 'active' : ''}"><a href="/categories/games">Games</a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li>OTHER</li>
                <li class="${current == 'contact' ? 'active' : ''}"><a href="/contact">Contact</a></li>
                <li class="${current == 'help' ? 'active' : ''}"><a href="/help">Help</a></li>
                <li class="${current == 'about' ? 'active' : ''}"><a href="/about">About us</a></li>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

            <tiles:insertAttribute name="body"/>

            <br><br>

            <div style="text-align: center;">
                <tiles:insertAttribute name="footer"/>
            </div>

        </div>

        </div>
    </div>
</div>

</body>
</html>