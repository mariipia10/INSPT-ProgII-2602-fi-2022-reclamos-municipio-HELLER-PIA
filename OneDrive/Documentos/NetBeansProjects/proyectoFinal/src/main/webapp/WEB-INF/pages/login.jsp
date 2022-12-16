<%-- 
    Document   : registro
    Created on : 30 oct. 2022, 23:39:29
    Author     : piahe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <jsp:include page="../common/navbar.jsp" />
        <h1>Bienvenido!</h1>
        <h3>Ingrese sus credenciales</h3>  
        <br/>  
        <form name="login" action="${pageContext.request.contextPath}parcial2" method="post">
            <div class="form-group-row">
                <div class="col-xs-2">
                    <input type="text"  class="form-control" placeholder="Usuario" name="user" required>
                </div>
                <div class="col-xs-2">
                    <input type="password" class="form-control" placeholder="Contrasenia" name="pass" required>
                </div>
            </div>
            <input type="hidden" name="deDondeViene" value="${param.origen}">
            <br>
            <input type="submit" value="Ver reclamos"/>
        </form>
        <!--
    <form action="${pageContext.request.contextPath}parcial2" method="post">  
        Usuario: <input type="text" name="user"/><br/><br/>  
        Contrasenia: <input type="password" name="pass"/><br/><br/>  

    </form> --> 

    </body>
</html>
