<%-- 
    Document   : error
    Created on : 25 nov. 2022, 05:23:46
    Author     : piahe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="../common/header.jsp" />
    <body>
        <jsp:include page="../common/navbar.jsp" />
        <h1>ERROR</h1>
        <p>
            ${mensajeError}
        </p>
    </body>
    <jsp:include page="../common/footer.jsp"/>
</html>
