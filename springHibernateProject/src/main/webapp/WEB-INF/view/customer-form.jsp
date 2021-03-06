
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
    <title>Add and save customer</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-customer-style.css"/>

</head>

<body>

<div id="wrapper">
    <div id="header">
        <h2>CRM - Customer Relationship Manager</h2>
    </div>
</div>

<div id="container">
    <h3>Save Customer</h3>

    <form:form action="saveCustomer" modelAttribute="customer" method="post">


        <form:hidden path="id"></form:hidden>
        <table>
            <tbody>
                <tr>
                    <td> <label>First name:</label></td>
                    <td><form:input path="firstName"/></td>
                </tr>
                <tr>
                    <td> <label>Last name:</label></td>
                    <td><form:input path="lastName"/></td>
                </tr>
                <tr>
                    <td> <label>E-mail:</label></td>
                    <td><form:input path="email"/></td>
                </tr>
                <tr>
                    <td> <label></label></td>
                    <td><input type="submit" value="Save" class="save"/></td>
                </tr>
            </tbody>
        </table>

    </form:form>
    <div style="clear: both;"></div>
    <p>

        <input type="button" onclick="window.location.href='list';return false;" class="add-button" value="Back to list"/>
    </p>

</div>

</body>
</html>