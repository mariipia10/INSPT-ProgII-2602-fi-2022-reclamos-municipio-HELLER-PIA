/*
 * 
 * 
 */
package reclamoMuni.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import reclamosMuni.modelo.Modelo;
import reclamosMuni.modelo.daos.impl.LoginDAOMySQL;
import reclamosMuni.modelo.daos.impl.PersonaDAOMySQL;
import reclamosMuni.modelo.daos.impl.UsuarioDAOMySQL;
import reclamosMuni.modelo.dtos.LoginDTO;
import reclamosMuni.modelo.dtos.PersonaDTO;
import reclamosMuni.modelo.dtos.UsuarioDTO;

/**
 *
 * @author piahe
 */
@WebServlet(name = "CompletarPersona", urlPatterns = {"/completarPersona"})
public class CompletarPersonaServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("estoy en do get");
        processRequest(request, response);
        request.getRequestDispatcher("WEB-INF/pages/completarPersona.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();  // Obtiene la sesión actual
        UsuarioDTO usuario = (UsuarioDTO) session.getAttribute("usuario");

System.out.println("Usuario en sesión: " + (usuario != null ? usuario.toString() : "null"));
        if (usuario == null) {  // Si el usuario no está en la sesión, hay un problema
            request.setAttribute("mensajeError", "Usuario no encontrado en la sesión");
            request.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(request, response);
            return;  // Salimos del método si no se encuentra el usuario en la sesión
        }
        System.out.println("completar peronsa");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String dni = request.getParameter("dni");
        String mail = request.getParameter("mail");
        String phone = request.getParameter("phone");
        Modelo model = new Modelo(new LoginDAOMySQL(), new UsuarioDAOMySQL(), new PersonaDAOMySQL());
        PersonaDTO persona = model.actualizarPersona(name, surname, dni, mail, phone, usuario.getId());
        LoginDTO login = new LoginDTO(usuario.getId(), LocalDate.now(), LocalTime.now());
        model.cargarLogin(login);
        session.setMaxInactiveInterval(120);
        request.getSession().setAttribute("persona", persona);
        System.out.println("persona en copmletar persona" + persona.toString());
        request.getRequestDispatcher("reclamos/all").forward(request, response);
        //processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
