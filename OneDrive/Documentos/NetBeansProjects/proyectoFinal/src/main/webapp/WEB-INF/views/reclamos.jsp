<%-- 
    Document   : reclamos
    Created on : 21 oct. 2022, 15:54:33
    Author     : piahe
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"  %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <jsp:include page="../common/header.jsp" />
    <body>
        <jsp:include page="../common/navbar.jsp" />
        <h1>Viendo reclamos...</h1>
        <table style="width:100%" border='1' style='border-collapse:collapse'>
            <tr>
                <th>Fecha inicio</th>
                <th>Categoria</th>
                <th>Direccion</th>
            </tr>
            <c:forEach var="reclamo" items="${reclamos}">
                <tr style="border: 1px solid black;">
                    <td>${reclamo.fecha_inicio}</td>
                    <td>${reclamo.categoria}</td>
                    <td>${reclamo.direccion}</td>
                </tr>
            </c:forEach>
        </table>
      </div>
    </body>
    <jsp:include page="../common/footer.jsp"/>
</html>
