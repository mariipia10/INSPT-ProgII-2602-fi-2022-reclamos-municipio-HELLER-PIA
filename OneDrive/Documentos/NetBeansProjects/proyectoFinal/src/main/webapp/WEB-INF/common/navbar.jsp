<%-- 
    Document   : trueindex
    Created on : 9 nov. 2022, 22:35:51
    Author     : piahe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
        <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <title>Login</title>
        <script>
            // JavaScript para construir dinámicamente el enlace
            document.addEventListener("DOMContentLoaded", function () {
                if (${persona.puedeVerLogin()}) {
                    var contextPath = "${pageContext.request.contextPath}";
                    var link = document.createElement("a");
                    link.setAttribute("class", "nav-item nav-link");
                    link.setAttribute("href", contextPath + "/verLogins");
                    link.textContent = "Buscar logins";
                    document.getElementById("linkContainer").appendChild(link);
                }
            });
        </script>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container-fluid px-4 px-lg-5">
                <a class="navbar-brand" href="${pageContext.request.contextPath}/">
                    <img class="d-inline-block align-text-center" width="20" src="assets/utn-2.svg" alt="Logo de utn"/>
                    Java MVC
                </a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                        <li class="nav-item">               
                            <a class="nav-link" aria-current="page" href="${pageContext.request.contextPath}/parcial2"">Login</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/reclamos/all"">Ver reclamos</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/reclamos/all"">Ver reclamos</a>
                        </li>
                        <div id="linkContainer"></div> 
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/Logout">Logout</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </body>
</html>

