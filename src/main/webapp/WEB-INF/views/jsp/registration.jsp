<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<form:form method="post" action="/registration" commandName="user">
    <div>
        <form:input path="username" />
        <form:errors path="username" />
    </div>
    <div>
        <form:password path="password" />
        <form:errors path="password" />
    </div>
    <div>
        <form:password path="confirmPassword" />
        <form:errors path="confirmPassword" />
    </div>
    <button type="submit">Submit</button>
</form:form>