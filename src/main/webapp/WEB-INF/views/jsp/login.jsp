<%@ include file="../layout/taglib.jsp"%>

<div class="container">

    <form class="form-signin" role="form" method="post" action="<c:url value='/j_spring_security_check' />">
        <div>${error}</div>
        ${param.error}

        <c:if test="${register_success == 1}">
        <div class="alert alert-success">
            Your registered successfully
        </div>
        </c:if>

        <h2 class="form-signin-heading">Please sign in</h2>

        <label for="username" class="sr-only">User name</label>
        <input type="text" id="username" name="username" class="form-control" placeholder="User name" required
               autofocus>

        <label for="password" class="sr-only">Password</label>
        <input type="password" id="password" name="password" class="form-control" placeholder="Password" required>

        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    </form>

</div>