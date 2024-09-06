<%-- 
    Document   : registro
    Created on : 30 oct. 2022, 23:39:29
    Author     : piahe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="../common/header.jsp" />

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
            <!-- <input type="hidden" name="deDondeViene" value="${param.origen}">
            --> 
            <br>
            <input type="submit" value="Ver reclamos"/>
        </form>
    <li class="nav-item">               
        <a class="nav-link" aria-current="page" href="${pageContext.request.contextPath}/register"">Registrate!</a>
    </li>
</body>
<jsp:include page="../common/footer.jsp"/>
</html>
