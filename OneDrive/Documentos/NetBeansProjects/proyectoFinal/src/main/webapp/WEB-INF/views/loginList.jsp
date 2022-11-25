<%-- 
    Document   : loginList.jsp
    Created on : 25 nov. 2022, 14:52:08
    Author     : piahe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de logins</title>
    </head>
    <body>
        <h1>Listado de logins:</h1>
        <table style="width:100%">
            <tr>
                <th>User</th>
                <th>Dia</th>
                <th>Hora</th>
            </tr>
            <c:forEach var="login" items="${logins}">
                <tr>
                    <td>${login.id}</td>
                    <td>${login.dia}</td>
                    <td>${login.hora}</td>
                </tr>
            </c:forEach>
        </table>
        
    </body>
</html>
