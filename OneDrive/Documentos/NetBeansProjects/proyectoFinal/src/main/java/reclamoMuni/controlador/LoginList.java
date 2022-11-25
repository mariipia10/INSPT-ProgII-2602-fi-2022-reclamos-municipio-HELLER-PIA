/*
 * 
 * 
 */
package reclamoMuni.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import reclamosMuni.modelo.Modelo;
import reclamosMuni.modelo.UsuarioDAOMySQL;
import reclamosMuni.modelo.UsuarioDTO;
import reclamosMuni.modelo.daos.LoginDAO;
import reclamosMuni.modelo.daos.UsuarioDAO;
import reclamosMuni.modelo.daos.impl.LoginDAOMySQL;
import reclamosMuni.modelo.dtos.LoginDTO;

/**
 *
 * @author piahe
 */
@WebServlet(name = "LoginList", urlPatterns = {"/verLogins"})
public class LoginList extends HttpServlet {

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

        Modelo model = new Modelo(new LoginDAOMySQL(), new UsuarioDAOMySQL());
        UsuarioDTO user = (UsuarioDTO) request.getSession().getAttribute("usuario");
        int id = user.getId();
        boolean esValido = model.idValido(id);
        //System.out.println(user.toString());
        if (user.getEs_admin()) {
            if (esValido) {
                List<LoginDTO> logins = model.obtenerLogins(id);
                request.setAttribute("id", request.getParameter("id"));
                request.setAttribute("logins", logins);
                RequestDispatcher vista = request.getRequestDispatcher("WEB-INF/views/loginList.jsp");
                vista.forward(request, response);
            } else {
                request.setAttribute("mensajeError", "Usuario no encontrado");
                request.getRequestDispatcher("WEB-INF/views/error.jsp").forward(request, response);
            }

        } else {
            request.setAttribute("mensajeError", "No tenes permiso para acceder a esta pag");
            request.getRequestDispatcher("WEB-INF/views/error.jsp").forward(request, response);
        }
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
        UsuarioDTO usuario = (UsuarioDTO) request.getSession().getAttribute("usuario");

        if (!usuario.es_valido) {
            request.setAttribute("mensajeError", "No tenes permiso para acceder a esta pag");
            request.getRequestDispatcher("WEB-INF/views/error.jsp").forward(request, response);
        } else {
            request.getSession().setAttribute("usuario", usuario);
            processRequest(request, response);
        }
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
        processRequest(request, response);
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
