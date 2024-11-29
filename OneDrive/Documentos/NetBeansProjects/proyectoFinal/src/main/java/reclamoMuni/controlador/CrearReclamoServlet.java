/*
 * 
 * 
 */
package reclamoMuni.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import reclamosMuni.modelo.Modelo;
import reclamosMuni.modelo.daos.impl.ReclamoDAOMySQL;
import reclamosMuni.modelo.dtos.PersonaDTO;
import reclamosMuni.modelo.dtos.ReclamoDTO;

/**
 *
 * @author piahe
 */
@WebServlet("/crearReclamo")
public class CrearReclamoServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet test</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet test at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recupera los datos del formulario
        String descripcion = request.getParameter("descripcion");
        String categoria = request.getParameter("categoria");
        String direccion = request.getParameter("direccion");
        LocalDate fecha_inicio = LocalDate.now();
        // Recupera la persona logueada
        PersonaDTO persona = (PersonaDTO) request.getSession().getAttribute("persona");

        // Crea el DTO del reclamo
        ReclamoDTO reclamo = new ReclamoDTO(descripcion, fecha_inicio, persona.getId(), categoria, direccion);

        // Inserta el reclamo en la base de datos
        Modelo model = new Modelo(new ReclamoDAOMySQL());
        model.insertar(reclamo);
        // Redirige al listado de reclamos
        response.sendRedirect("reclamos/all");  // Esto volverá al servlet que lista los reclamos

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         RequestDispatcher vista = request.getRequestDispatcher("/WEB-INF/pages/crearReclamo.jsp");
            vista.forward(request, response);
    }

}
