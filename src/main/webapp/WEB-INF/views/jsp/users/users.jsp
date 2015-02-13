<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="../../layout/taglib.jsp" %>

<div class="col-xs-6 col-sm-6">
    <h2>Clients</h2>
</div>

<div class="col-xs-6 col-sm-6">
    <form class="form-inline" action="/users/findUser" method="post">
        <div class="form-group">
            <label for="userLastName">Find client by last name</label>
            <input type="text" class="form-control" id="userLastName" name="userLastName">
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
        <th>Username</th>
        <th>First name</th>
        <th>Last name</th>
        <th>Details</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.username}</td>
            <td>${user.person.firstName}</td>
            <td>${user.person.lastName}</td>
            <td>
                <a href="/users/details/${user.id}">
                    <button type="button" class="btn btn-primary btn-xs">Details</button>
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>