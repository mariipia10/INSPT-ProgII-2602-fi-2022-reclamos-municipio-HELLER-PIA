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
    <script>
        function validateForm() {
            var x = document.forms["inputLoginID"]["id"].value;
            if (x < 1) {
                alert("Ingrese un ID válido");
                return false;
            }
        }
    </script>
    <jsp:include page="../common/navbar.jsp" />

    <h4>Login history</h4><!-- comment -->
    <p>Ingresa el ID del usuario a buscar<p>
    <form name="inputLoginID" onsubmit="return validateForm()"action="/verLogins" method="post">
        <input type="text" name="id" placeholder="id" mandatory>
        <input type="submit" value="Enviar">
    </form>
</html>
