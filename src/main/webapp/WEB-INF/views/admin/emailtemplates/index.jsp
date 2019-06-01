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
            <a href="${pageContext.request.contextPath}/admin/emailtemplates/add">Add</a>
        </p>
        <table border="1" style="width: 100%">
            <tr>
                <th>Id</th>
                <th>Title</th>
                <th>Slug</th>
                <th>Subject</th>
                <th>Created Date</th>
                <th>Status</th>
                <th>Action</th>
            </tr>
            <c:forEach var="template" items="${templates}">
                <tr>
                    <td>${template.id}</td>
                    <td>${template.title}</td>
                    <td>${template.slug}</td>
                    <td>${template.subject}</td>
                    <td>${template.createdDate}</td>
                    <td>${template.status}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/admin/emailtemplates/edit/${template.id}">Edit</a>
                        Delete
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
