<%-- 
    Document   : loginList.jsp
    Created on : 25 nov. 2022, 14:52:08
    Author     : piahe
--%>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"  %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="../common/header.jsp" />
    <body>
        <jsp:include page="../common/navbar.jsp" />
        <section class="py-4">
            <div class="container">
                <div class="row">
                    <h1 class="h3">Listado de logins del id ${id}:</h1>
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
                </div>
            </div>
        </section>

    </body>
    <jsp:include page="../common/footer.jsp"/>

</html>
<!--
<section class="py-3">
    <div class="container">
        <div class="row">
            <h1 class="h3">Listado de alumnos</h1>
            <p class="lead">Se listan todos los alumnos existentes en la base de datos</p>
            <p class="small">Los datos de la personas aquí listadas son ficticios. Sus rostros fueron generados con inteligencia artificial.</p>
            <div>
                <a href="#" class="btn btn-success"
                   data-bs-toggle="modal" data-bs-target="#modalAgregarAlumno">Agregar alumno</a>
            </div>
        </div>

    </div>
</section>
-->


<script src="https://cdn.jsdelivr.net/npm/masonry-layout@4.2.2/dist/masonry.pkgd.min.js" integrity="sha384-GNFwBvfVxBkLMJpYMOABq3c+d3KnQxudP/mGPkzpZSTYykLBNsZEnG2D9G/X/+7D" crossorigin="anonymous" async></script>
