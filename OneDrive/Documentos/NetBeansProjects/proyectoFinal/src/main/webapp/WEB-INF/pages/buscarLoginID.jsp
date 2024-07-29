<%-- 
    Document   : loginHistory
    Created on : 25 nov. 2022, 11:55:35
    Author     : piahe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="../common/header.jsp" />
    <jsp:include page="../common/navbar.jsp" />

    <h4>Login history</h4><!-- comment -->
    <p>Ingresa el ID del usuario a buscar<p>
    <form name="inputLoginID" onsubmit="return validateForm()"action="/verLogins" method="post">
        <input type="text" name="id" placeholder="id" mandatory>
        <input type="submit" value="Enviar">
    </form>
    <jsp:include page="../common/footer.jsp"/>

</html>
