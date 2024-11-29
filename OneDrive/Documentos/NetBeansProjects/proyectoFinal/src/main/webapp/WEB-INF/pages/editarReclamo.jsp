<%-- 
    Document   : editarReclamo
    Created on : 24 nov. 2024, 22:53:56
    Author     : 
--%>

<%@page import="java.time.LocalDate"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="../assets/css/style.css"/>
        <link rel="icon" type="image/x-icon" href="../assets/img/favicon.ico">
        <title>Editar reclamo: ${reclamo.descripcion}</title>
    </head>
    <body>
        <h1>Editar reclamo: ${reclamo.descripcion}</h1>

        <form id="formEditarReclamo" action="ReclamoController" method="post">

            <input type="hidden" name="accion" value="update" />
            <input type="hidden" name="id" value="${reclamo.id}" />
            <input type="hidden" name="persona_id" value="${reclamo.persona_id}" />

            <div>
                <label for="descripcion">Descripción:</label>
                <input type="text" id="descripcion" name="descripcion" value="${reclamo.descripcion}" required>
            </div>

            <div>
                <label for="direccion">Dirección del inmueble afectado:</label>
                <input type="text" id="direccion" name="direccion" value="${reclamo.direccion}" required>
            </div>

            <div>
                <label for="categoria">Categoría:</label>
                <select id="categoria" name="categoria" required>
                    <option value="alumbrado" ${reclamo.categoria == 'ALUMBRADO' ? 'selected' : ''}>Alumbrado</option>
                    <option value="arbolado" ${reclamo.categoria == 'ARBOLADO' ? 'selected' : ''}>Arbolado</option>
                    <option value="limpieza" ${reclamo.categoria == 'LIMPIEZA' ? 'selected' : ''}>Limpieza</option>
                    <option value="pluvial" ${reclamo.categoria == 'PLUVIAL' ? 'selected' : ''}>Pluvial</option>
                </select>
            </div>

            <div>
                <label for="fecha_inicio">Fecha de inicio:</label>
                <input type="date" id="fecha_inicio" name="fecha_inicio" value="${reclamo.fecha_inicio}" readonly>
            </div>

            <div>
                <label for="fecha_fin">Fecha de resolución:</label>
                <input type="date" id="fecha_fin" name="fecha_fin" min="<%= LocalDate.now() %>" value="${reclamo.fecha_fin}">
            </div>

            <div>                
                <input type="submit" value="Confirmar cambios" />
                <input type="reset" value="Reestablecer" />
            </div>
        </form>

       
    </body>
</html>

