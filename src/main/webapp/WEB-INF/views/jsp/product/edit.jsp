<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="../../layout/taglib.jsp" %>

<form:form method="post" class="form-horizontal" modelAttribute="productForm">
    <form:errors/>

    <fieldset>
        <legend>Edit product</legend>

        <div class="form-group">
            <label for="categoryName" class="col-lg-2 control-label">Category</label>

            <div class="col-lg-4">
                <select class="form-control" id="categoryName" name="categoryName">
                    <option value="books" ${categoryName == 'Books' ? 'selected' : ''}>Books</option>
                    <option value="e-books" ${categoryName == 'E-books' ? 'selected' : ''}>E-books</option>
                    <option value="music" ${categoryName == 'Music' ? 'selected' : ''}>Music</option>
                    <option value="movies" ${categoryName == 'Movies' ? 'selected' : ''}>Movies</option>
                    <option value="games" ${categoryName == 'Games' ? 'selected' : ''}>Games</option>
                </select>
            </div>
        </div>

        <div class="form-group">
            <label for="name" class="col-lg-2 control-label">Product name</label>

            <div class="col-lg-4">
                <form:input id="name" path="name" cssClass="form-control" placeholder="Product name"/>
                <div>
                    <form:errors path="name">
                        <div class="alert alert-danger"><form:errors path="name" htmlEscape="false"/></div>
                    </form:errors>
                </div>
            </div>
        </div>

        <div class="form-group">
            <label for="netPrice" class="col-lg-2 control-label">Net price</label>

            <div class="col-lg-4">
                <form:input id="netPrice" path="netPrice" cssClass="form-control" placeholder="Net price"/>
                <div>
                    <form:errors path="netPrice">
                        <div class="alert alert-danger"><form:errors path="netPrice" htmlEscape="false"/></div>
                    </form:errors>
                </div>
            </div>
        </div>

        <div class="form-group">
            <label for="description" class="col-lg-2 control-label">Description</label>

            <div class="col-lg-4">
                <form:textarea id="description" path="description" cssClass="form-control" placeholder="Description"/>
                <div>
                    <form:errors path="description">
                        <div class="alert alert-danger"><form:errors path="description" htmlEscape="false"/></div>
                    </form:errors>
                </div>
            </div>
        </div>

        <div class="form-group">
            <label for="photoUrl" class="col-lg-2 control-label">Photo URL</label>

            <div class="col-lg-4">
                <form:input id="photoUrl" path="photoUrl" cssClass="form-control" placeholder="Photo URL"/>
                <div>
                    <form:errors path="photoUrl">
                        <div class="alert alert-danger"><form:errors path="photoUrl" htmlEscape="false"/></div>
                    </form:errors>
                </div>
            </div>
        </div>
    </fieldset>

    <hr/>
    <div class="col-lg-4" align="center">
        <p>
            <button type="submit" class="btn btn-primary">Edit</button>
        </p>
    </div>
</form:form>