<%-- 
    Document   : crearReclamo
    Created on : 22 nov. 2024, 16:12:13
    Author     : piahe
--%>
<!DOCTYPE html>
<html>
    <jsp:include page="../common/header.jsp" />
    <body>
        <jsp:include page="../common/navbar.jsp" />
        <h1>Crear Nuevo Reclamo</h1>

        <form action="crearReclamo" method="post">
            <label for="descripcion">Descripción</label>
            <input type="text" id="descripcion" name="descripcion" required>

            <label for="categoria">Categoría</label>
            <select id="categoria" name="categoria" required>
                <option value="alumbrado">Alumbrado</option>
                <option value="arbolado">Arbolado</option>
                <option value="limpieza">Limpieza</option>
                <option value="pluvial">Pluvial</option>
            </select>

            <label for="direccion">Dirección</label>
            <input type="text" id="direccion" name="direccion" required>

            <input type="submit" value="Crear Reclamo">
        </form>
    </body>
    <jsp:include page="../common/footer.jsp"/>
</html>
