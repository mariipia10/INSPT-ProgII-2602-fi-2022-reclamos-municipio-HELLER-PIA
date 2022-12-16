<%-- 
    Document   : loginList.jsp
    Created on : 25 nov. 2022, 14:52:08
    Author     : piahe
--%>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"  %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de logins</title>
    </head>
    <body>
                    <jsp:include page="../common/navbar.jsp" />

        <h1>Listado de logins del id ${id}:</h1>
        <table style="border: 1px solid black;">
            <tr>
                <th>Dia</th>
                <th>Hora</th>
            </tr>
            <c:forEach var="login" items="${logins}">
                <tr style="border: 1px solid black;">
                    <td>${login.dia}</td>
                    <td>${login.hora}</td>
                </tr>
            </c:forEach>
        </table>
        
    </body>
</html>
