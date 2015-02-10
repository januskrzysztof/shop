<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <link rel="stylesheet"
          href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">

    <link rel="stylesheet"
          href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">

    <link rel="stylesheet" href="//getbootstrap.com/examples/signin/signin.css">

    <link rel="stylesheet" href="//getbootstrap.com/examples/dashboard/dashboard.css">

    <script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>

    <script type="text/javascript"
            src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script>

    <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>

    <%@ include file="taglib.jsp" %>
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
                    <li class="${current == 'about' ? 'active' : ''}"><a href="#">About</a></li>
                    <li class="${current == 'contact' ? 'active' : ''}"><a href="#">Contact</a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Dropdown
                            <span class="caret"></span></a>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="#">Action</a></li>
                            <li><a href="#">Another action</a></li>
                            <li><a href="#">Something else here</a></li>
                            <li class="divider"></li>
                            <li class="dropdown-header">Nav header</li>
                            <li><a href="#">Separated link</a></li>
                            <li><a href="#">One more separated link</a></li>
                        </ul>
                    </li>
                </ul>

                <ul class="nav navbar-nav navbar-center">
                    <li>
                        <form class="navbar-form" action="/product/search" method="post">
                            <div class="form-group">
                                <label for="productName" style="color:darkgrey">Search</label>
                                <input type="text" class="form-control" id="productName" name="productName">
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
                        <li class="${current == 'cart' ? 'active' : ''}"><a href="/cart">My cart</a></li>
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
                        <li class="${current == 'clients' ? 'active' : ''}"><a href="">Clients</a></li>
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
                    <li class="${current == 'top' ? 'active' : ''}"><a href="#">Top sales</a></li>
                    <li class="${current == 'books' ? 'active' : ''}"><a href="#">Books</a></li>
                    <li class="${current == 'ebooks' ? 'active' : ''}"><a href="#">E-books</a></li>
                    <li class="${current == 'music' ? 'active' : ''}"><a href="#">Music</a></li>
                    <li class="${current == 'movies' ? 'active' : ''}"><a href="#">Movies</a></li>
                    <li class="${current == 'games' ? 'active' : ''}"><a href="#">Games</a></li>
                </ul>
                <ul class="nav nav-sidebar">
                    <li>OTHER</li>
                    <li class="${current == 'contact' ? 'active' : ''}"><a href="">Contact</a></li>
                    <li class="${current == 'help' ? 'active' : ''}"><a href="">Help</a></li>
                    <li class="${current == 'about' ? 'active' : ''}"><a href="">About us</a></li>
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