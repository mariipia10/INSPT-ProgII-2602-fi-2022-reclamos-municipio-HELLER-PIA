<%-- 
    Document   : reclamos
    Created on : 21 oct. 2022, 15:54:33
    Author     : piahe
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"  %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="WEB-INF/pages/header.jsp"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de reclamos</title>
    </head>
    <body>
        <h1>Lista de reclamos</h1>
        <ul>
            <c:forEach var="reclamo" items="${reclamos}">
                <li>${reclamo.id} ${reclamo.descripcion} ${reclamo.direccion}</li>
            </c:forEach>
        </ul>
        
      </div>
    </body>
</html>
