<%-- 
    Document   : header
    Created on : Jun 1, 2019, 8:43:56 AM
    Author     : HP B&O
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="SITE_URL" value="${pageContext.request.getContextPath()}"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome World!</h1>
        <ul>
            <li><a href="${SITE_URL}/register">Sign Up</a></li>
            <li><a href="${SITE_URL}/login">Login</a></li>
        </ul>