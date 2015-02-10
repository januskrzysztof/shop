<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<form:form method="post" action="/product/add" modelAttribute="productForm">
    <form:input path="name" />
    <form:input path="netPrice" />
    <form:textarea path="description" />
    <button>Submit</button>
</form:form>