<%-- 
    Document   : index
    Created on : Jun 1, 2019, 1:38:08 PM
    Author     : HP B&O
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="SITE_URL" value="${pageContext.request.getContextPath()}"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Users</h1>
        <table border="1">
            <thead>
            <th>Id</th>
            <th>Email</th>
            <th>Created Date</th>
            <th>Modified Date</th>
            <th>Status</th>
            <th>Action</th>
        </thead>
        <tbody>
            <c:forEach var="user" items="${users}">
            <td>${user.id}</td>
            <td>${user.email}</td>
            <td>${user.createdDate}</td>
            <td>${user.modifiedDate}</td>
            <td>${user.status}</td>
            <td>
                Edit Delete
            </td>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
