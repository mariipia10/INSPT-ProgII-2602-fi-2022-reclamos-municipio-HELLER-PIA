<%-- 
    Document   : register
    Created on : 24 ago. 2024, 22:56:36
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
        <jsp:include page="../common/navbar.jsp" />
        <h1>Bienvenido!</h1>
        <h3>Complete el formulario de registro para avanzar</h3>  
        <br/>  
        <form name ="completarPersona" action="${pageContext.request.contextPath}completarPersona" method="post">
            <div class="form-group-row">
                 <div class="col-sm-6">
                    <input type="text"  class="form-control" placeholder="Nombre" name="name" required>
                </div>
                 <div class="col-sm-6">
                    <input type="text"  class="form-control" placeholder="Apellido" name="surname" required>
                </div>
                 <div class="col-sm-6">
                    <input type="text"  class="form-control" placeholder="DNI" name="dni" required>
                </div>
                 <div class="col-sm-6">
                     <input type="email" class="form-control" placeholder="mail" name="mail" required>
                </div>
                 <div class="col-sm-6">
                    <input type="text"  class="form-control" placeholder="telefono" name="phone" required>
                </div> 
            </div>
            <!-- <input type="hidden" name="deDondeViene" value="${param.origen}">
            --> 
            <br>
            <input type="submit" value="Crear usuario"/>
        </form>
            

</body>
</html>
