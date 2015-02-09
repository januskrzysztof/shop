<%@include file="/WEB-INF/views/layout/taglib.jsp" %>

<div class="container">

    <div class="row"><h2>Registration</h2></div>

    <form:form method="post" class="form-horizontal" action="/registration" commandName="user">

        <form:errors>
            <div class="alert alert-danger"><form:errors htmlEscape="false"/></div>
        </form:errors>

        <fieldset>
            <legend>Personal Info</legend>

            <div class="form-group">
                <label for="username" class="col-lg-2 control-label">E-mail</label>

                <div class="col-lg-4">
                    <form:input id="username" path="username" cssClass="form-control" placeholder="E-mail"/>
                    <div>
                        <form:errors path="username">
                            <div class="alert alert-danger"><form:errors path="username" htmlEscape="false"/></div>
                        </form:errors>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label for="firstName" class="col-lg-2 control-label">First name</label>

                <div class="col-lg-4">
                    <form:input id="firstName" path="person.firstName" cssClass="form-control"
                                placeholder="First name"/>
                    <div>
                        <form:errors path="person.firstName">
                            <div class="alert alert-danger"><form:errors path="person.firstName"/></div>
                        </form:errors>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label for="lastName" class="col-lg-2 control-label">Last name</label>

                <div class="col-lg-4">
                    <form:input id="lastName" path="person.lastName" cssClass="form-control"
                                placeholder="Last name"/>
                    <div>
                        <form:errors path="person.lastName">
                            <div class="alert alert-danger"><form:errors path="person.lastName"/></div>
                        </form:errors>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label for="phoneNumber" class="col-lg-2 control-label">Phone number</label>

                <div class="col-lg-4">
                    <form:input id="phoneNumber" path="person.phoneNumber" cssClass="form-control"
                                placeholder="Phone number"/>
                    <div>
                        <form:errors path="person.phoneNumber">
                            <div class="alert alert-danger"><form:errors path="person.phoneNumber"/></div>
                        </form:errors>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label for="password" class="col-lg-2 control-label">Password</label>

                <div class="col-lg-4">
                    <form:input id="password" path="password" type="password" cssClass="form-control"
                                placeholder="Password"/>
                    <div>
                        <form:errors path="password">
                            <div class="alert alert-danger"><form:errors path="password"/></div>
                        </form:errors>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label for="confirmPassword" class="col-lg-2 control-label">Confirm password</label>

                <div class="col-lg-4">
                    <form:input id="confirmPassword" path="confirmPassword" type="password" cssClass="form-control"
                                placeholder="Password"/>
                    <div>
                        <form:errors path="confirmPassword">
                            <div class="alert alert-danger"><form:errors path="confirmPassword"/></div>
                        </form:errors>
                    </div>
                </div>
            </div>

        </fieldset>

        <fieldset>
            <legend>Address Info</legend>

            <div class="form-group">
                <label for="country" class="col-lg-2 control-label">Country</label>

                <div class="col-lg-4">
                    <form:input id="country" path="person.address.country" cssClass="form-control"
                                placeholder="Country"/>
                    <div>
                        <form:errors path="person.address.country">
                            <div class="alert alert-danger"><form:errors path="person.address.country"/></div>
                        </form:errors>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label for="postalCode" class="col-lg-2 control-label">Postal code</label>

                <div class="col-lg-4">
                    <form:input id="postalCode" path="person.address.postalCode" cssClass="form-control"
                                placeholder="Postal code (e.g. 12345 or 12345-6789)"/>
                    <div>
                        <form:errors path="person.address.postalCode">
                            <div class="alert alert-danger"><form:errors path="person.address.postalCode"/></div>
                        </form:errors>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label for="city" class="col-lg-2 control-label">City</label>

                <div class="col-lg-4">
                    <form:input id="city" path="person.address.city" cssClass="form-control"
                                placeholder="City"/>
                    <div>
                        <form:errors path="person.address.city">
                            <div class="alert alert-danger"><form:errors path="person.address.city"/></div>
                        </form:errors>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label for="street" class="col-lg-2 control-label">Street</label>

                <div class="col-lg-4">
                    <form:input id="street" path="person.address.street" cssClass="form-control"
                                placeholder="Street (optional)"/>
                    <div>
                        <form:errors path="person.address.street">
                            <div class="alert alert-danger"><form:errors path="person.address.street"/></div>
                        </form:errors>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label for="houseNumber" class="col-lg-2 control-label">House number</label>

                <div class="col-lg-4">
                    <form:input id="houseNumber" path="person.address.houseNumber" cssClass="form-control"
                                placeholder="House number"/>
                    <div>
                        <form:errors path="person.address.houseNumber">
                            <div class="alert alert-danger"><form:errors path="person.address.houseNumber"/></div>
                        </form:errors>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label for="flatNumber" class="col-lg-2 control-label">Flat number</label>

                <div class="col-lg-4">
                    <form:input id="flatNumber" path="person.address.flatNumber" cssClass="form-control"
                                placeholder="Flat number (optional)"/>
                    <div>
                        <form:errors path="person.address.flatNumber">
                            <div class="alert alert-danger"><form:errors path="person.address.flatNumber"/></div>
                        </form:errors>
                    </div>
                </div>
            </div>

        </fieldset>

        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

        <hr/>
        <div class="col-lg-4" align="center">
            <p>
                <button type="submit" class="btn btn-primary">Submit</button>
            </p>
        </div>
    </form:form>

</div>