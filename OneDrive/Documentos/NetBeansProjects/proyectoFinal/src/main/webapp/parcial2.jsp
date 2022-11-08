<%-- 
    Document   : servlet
    Created on : 4 nov. 2022, 14:14:46
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
        <h1>Login pagina!</h1>
        <form>
            <label for="uname"><b>Usuario</b></label>
            <input type="text" placeholder="Ingrese usuario" name="user" required>

            <label for="psw"><b>Contrasenia</b></label>
            <input type="password" placeholder="Ingrese contra" name="pass" required>
            <input type="submit" value="Enviar">
        </form>
    </body>
</html>
