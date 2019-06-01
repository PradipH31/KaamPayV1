<%-- 
    Document   : index
    Created on : Jun 1, 2019, 2:00:57 PM
    Author     : HP B&O
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Email Templates</h1>
        <hr>    
        <p>
            <a href="${pageContext.request.contextPath}/admin/projects/add">Add</a>
        </p>
        <table border="1" style="width: 100%">
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Start Date</th>
                <th>Subject</th>
                <th>Created Date</th>
                <th>Status</th>
                <th>Action</th>
            </tr>
            <c:forEach var="project" items="${projects}">
                <tr>
                    <td>${project.id}</td>
                    <td>${project.name}</td>
                    <td>${project.startDate}</td>
                    <td>${project.endDate}</td>
                    <td>${project.createdDate}</td>
                    <td>${project.status}</td>
                    <td>
                        <c:if test="${sessionScope.loggedIn.id==project.createdBy.id}">
                            <a href="${pageContext.request.contextPath}/admin/projects/edit/${project.id}">Edit</a>
                            Delete
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
