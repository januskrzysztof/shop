<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h1>Login page</h1>

<form method="post" action="<c:url value='/j_spring_security_check' />">
    <div>${error}</div>
    ${param.error}
    <div>
        <label>
            Login: <input type="text" name="username" />
        </label>
    </div>
    <div>
        <label>
            Password: <input type="password" name="password" />
        </label>
    </div>

    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

    <button type="submit">Login</button>
</form>