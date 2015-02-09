<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
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
    <title><tiles:getAsString name="title"/></title>
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
                <ul class="nav navbar-nav navbar-right">
                    <li class="${current == 'account' ? 'active' : ''}"><a href="/account">My account</a></li>
                    <li class="${current == 'cart' ? 'active' : ''}"><a href="/cart">My cart</a></li>
                    <li class="${current == 'login' ? 'active' : ''}"><a href="/login">Sign In</a></li>
                    <li class="${current == 'registration' ? 'active' : ''}"><a href="/registration">Register</a></li>
                </ul>
            </div>
        </div>
    </nav>

    <tiles:insertAttribute name="body"/>

    <br>
    <br>

    <div style="text-align: center;">
        <tiles:insertAttribute name="footer"/>
    </div>

</div>

</body>
</html>