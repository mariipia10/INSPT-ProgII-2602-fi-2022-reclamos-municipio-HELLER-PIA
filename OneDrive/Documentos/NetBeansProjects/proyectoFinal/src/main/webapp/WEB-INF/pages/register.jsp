<%-- 
    Document   : register
    Created on : 24 ago. 2024, 22:56:36
    Author     : piahe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="${pageContext.request.contextPath}register" method="post">
            <input type="text" name="username">
            <input type="text" name="pass">
            <input type="submit" value="Button">
        </form>
    </body>
</html>
