<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="row"><h2>User details</h2></div>

<table class="table">
    <tbody>
    <tr>
        <th scope="row">Username</th>
        <td>${user.username}</td>
    </tr>
    <tr>
        <th scope="row">First name</th>
        <td>${user.person.firstName}</td>
    </tr>
    <tr>
        <th scope="row">Last name</th>
        <td>${user.person.lastName}</td>
    </tr>
    <tr>
        <th scope="row">Phone number</th>
        <td>${user.person.phoneNumber}</td>
    </tr>
    <tr>
        <th scope="row">Country</th>
        <td>${user.person.address.country}</td>
    </tr>
    <tr>
        <th scope="row">Postal Code</th>
        <td>${user.person.address.postalCode}</td>
    </tr>
    <tr>
        <th scope="row">City</th>
        <td>${user.person.address.city}</td>
    </tr>
    <tr>
        <th scope="row">Street</th>
        <td>${user.person.address.street}</td>
    </tr>
    <tr>
        <th scope="row">House number</th>
        <td>${user.person.address.houseNumber}</td>
    </tr>
    <tr>
        <th scope="row">Flat number</th>
        <td>${user.person.address.flatNumber}</td>
    </tr>
    </tbody>
</table>
