

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="WEB-INF/common/header.jsp" />
    <jsp:include page="WEB-INF/common/navbar.jsp" />
    <body>
        <div class="p-5 mb-4 bg-light rounded-3">
            <div class="container-fluid py-5 col-8">
                <h1 class="display-5 fw-bold">Sitio de reclamos de la Municipalidad</h1>
                <p class="fs-4">Ejercicio final</p>
            </div>
        </div>
        <a class="navbar-brand" href="${pageContext.request.contextPath}/">
            <img width="50px" class="d-inline-block align-text-center" src="assets/utn-2.svg" alt="brand"/>
            Java MVC
        </a>
    </body>
    <jsp:include page="WEB-INF/common/footer.jsp"/>
</html>


