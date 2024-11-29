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
        <!-- Filtro de categoría  NO FUNCIONAAAAAAAAAAAAAA-->
        <label for="categoria">Filtrar por categoría:</label>
        <select id="categoria" name="categoria">
            <option value="">Todas</option>
            <option value="alumbrado">Alumbrado</option>
            <option value="arbolado">Arbolado</option>
            <option value="limpieza">Limpieza</option>
            <option value="pluvial">Pluvial</option>
        </select>
        <table   id="reclamosTable" style="width:100%" border='1' style='border-collapse:collapse'>
            <tr>
                <th>descripcion </th>
                <th>Fecha inicio</th>
                <th>Categoria</th>
                <th>Direccion</th>
                <th>Fecha finalizacion</th>
            </tr>
            <c:forEach var="reclamo" items="${reclamos}">
                <tr style="border: 1px solid black;">
                                        <td>${reclamo.descripcion}</td>
                    <td>${reclamo.fecha_inicio}</td>
                    <td>${reclamo.categoria.toLowerCase()}</td>
                    <td>${reclamo.direccion}</td>
                    <td>${reclamo.fecha_fin}</td>
                    <c:if test="${persona.puedeVerLogin()}">
                         <td>
                    <!-- Botón para eliminar -->
                   <a href="ReclamoController?accion=delete&id=${reclamo.id}">Eliminar</a>


                    <!-- Botón para marcar como resuelto -->
                    <a href="ReclamoController?accion=resolve&id=${reclamo.id}">Resuelto</a>


                    <!-- Botón para modificar -->
                    <a href="ReclamoController?accion=update&id=${reclamo.id}">Editar</a>

                </td>
                    </c:if> 
                </tr>
            </c:forEach>
        </table>
    </div>

    <!-- Incluir los archivos de DataTables -->
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.min.css">
    <script type="text/javascript" charset="utf8" src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>

    <script>
        // Inicializar DataTable
        $(document).ready(function () {
            var table = $('#reclamosTable').DataTable({
                "columnDefs": [
                    {
                        // Asegura que la columna de categoría se filtre sin importar mayúsculas/minúsculas
                        "targets": 1, // Índice de la columna "Categoría"
                        "render": function (data, type, row) {
                            return data.toLowerCase();  // Convertir a minúsculas para el filtrado
                        }
                    }
                ]
            });

            // Filtrar por categoría usando un select
            $('#categoria').on('change', function () {
                var selectedCategory = this.value.toLowerCase(); // Obtener el valor del filtro y convertir a minúsculas
                if (selectedCategory === "") {
                    table.column(0).search('').draw();  // Si el valor es vacío, no se aplica filtro
                } else {
                    table.column(0).search(selectedCategory).draw();  // Filtrar según la categoría
                }
            });
        });
    </script>
</body>
<jsp:include page="../common/footer.jsp"/>
</html>
