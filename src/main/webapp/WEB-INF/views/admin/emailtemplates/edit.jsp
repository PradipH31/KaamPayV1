<%-- 
    Document   : add
    Created on : Jun 1, 2019, 3:39:43 PM
    Author     : HP B&O
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Edit Email Template</h1>
        <form action="" method="post">
            <div>
                <label>Title</label>
                <input type="text" name="title" value="${template.title}" required="required">
            </div>
            <div>
                <label>Slug</label>
                <input type="text" name="slug" value="${template.slug}" required="required">
            </div>
            <div>
                <label>Subject</label>
                <input type="text" name="subject" value="${template.subject}" required="required">
            </div>
            <div>
                <label>Body</label>
                <textarea name="body" required="required">${template.body}</textarea>
            </div>
            <input type="hidden" name="id" value="${template.id}">
            <button type="submit">Save</button>
            <a href="${pageContext.request.contextPath}/admin/emailtemplates">Back</a>
        </form>
    </body>
</html>
