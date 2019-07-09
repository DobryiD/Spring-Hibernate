<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <title>List Customers</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>

</head>

<body>

<div id="wrapper">
    <div id="header">
        <h2>CRM - Customer Relationship Manager</h2>
    </div>
</div>

<div id="container">

    <div id="content">

        <input type="button" value="Add Customer"
               onclick="window.location.href='showFormForAdd'; return false;" class="add-button"/>

        <form:form action="search" method="get">
            Search customer:<input type="text" name="theSearchName" />
            <input type="submit" value="Search" class="add-button" />
        </form:form>

        <table>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>E-mail</th>
                <th>Action</th>
            </tr>

            <c:forEach var="tempCustomer" items="${customers}">
            <tr>
                <td>${tempCustomer.firstName}</td>
                <td>${tempCustomer.lastName}</td>
                <td>${tempCustomer.email}</td>
                <td>
                    <form action="${pageContext.request.contextPath}/customer/showFormForUpdate" method="post" style="display: inline;">
                        <input type="hidden" name="customerId" value="${tempCustomer.id}"/>
                        <button type="submit">Update</button>
                    </form>
                    <form action="${pageContext.request.contextPath}/customer/delete" method="post" style="display: inline;">
                        <input type="hidden" name="customerId" value="${tempCustomer.id}"/>
                        <button type="submit" onclick="if(!(confirm('Are you sure you want to delete  this customer?')))return false;">Delete</button>
                    </form>

                </td>
            </tr>

            </c:forEach>
        </table>

    </div>
</div>

</body>
</html>