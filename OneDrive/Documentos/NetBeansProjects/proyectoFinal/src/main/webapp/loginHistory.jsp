<%-- 
    Document   : loginHistory
    Created on : 25 nov. 2022, 11:55:35
    Author     : piahe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <h4>Login history</h4><!-- comment -->
    <p>Ingresa el ID del usuario a buscar<p>
        <form action="/verLogins" method="post">
            <input type="text" name="userid" placeholder="userID">
            <input type="submit" value="Enviar">
        </form>
</html>
