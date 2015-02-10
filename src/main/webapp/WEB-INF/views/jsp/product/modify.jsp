<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<form:form method="post" modelAttribute="productForm">
    <form:errors />

    <form:input path="name" />
    <form:errors path="name" />
    <form:input path="netPrice" />
    <form:errors path="netPrice" />
    <form:textarea path="description" />
    <button>Submit</button>
</form:form>