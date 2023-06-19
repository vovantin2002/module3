<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<br/>
<form:form action="email" modelAttribute="email" method="post">
<h1><%= "Settings " %></h1>
    <table>
        <tr>
            <td>Languages</td>
            <td><form:select path="language">
                <form:option value="English"/>English
                <form:option value="Vietnamese"/>Vietnamese
                <form:option value="Japanese"/>Japanese
                <form:option value="Chinese"/>Chinese
            </form:select></td>
        </tr>
        <br>
        <br>
        <tr>
            <td>Page Size:</td>
            <td> Show
                <form:select path="pageSize">
                    <form:option value="5"/>5
                    <form:option value="10"/>10
                    <form:option value="15"/>15
                    <form:option value="25"/>25
                    <form:option value="50"/>50
                    <form:option value="100"/>100
                </form:select> email per page
            </td>
        </tr>
        <br>
        <br>
        <tr>
            <td>Spams filter:</td>
            <td><form:checkbox path="spamsFilter"/> Enable spams filter</td>
        </tr>
        <br>
        <br>
        <tr>
            <td> Signature:</td>
            <td><form:input type="text" path="signature"/></td>
        </tr>
        <br>
        <br>
        <tr>
            <td>
                <form:button type="submit">Update</form:button>
                <form:button type="reset">Cancel</form:button>
            </td>
        </tr>
    </table>
</form:form>
${msg}
</body>
</html>