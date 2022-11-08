<%-- 
    Document   : listado-reclamos
    Created on : 3 nov. 2022, 00:34:15
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
        <ul>
            <c:forEach items="${reclamos}"  var="reclamo" >
                <li>${reclamo.id} </li>
            </c:forEach>
        </ul>
    </body>
</html>
