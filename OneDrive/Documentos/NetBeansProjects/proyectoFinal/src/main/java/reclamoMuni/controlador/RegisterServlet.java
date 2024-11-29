/*
 * 
 * 
 */
package reclamoMuni.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import reclamoMuni.exceptions.DNIAlreadyExistsException;
import reclamoMuni.exceptions.EmailAlreadyExistsException;
import reclamosMuni.modelo.dtos.UsuarioDTO;
import reclamosMuni.modelo.Modelo;
import reclamosMuni.modelo.daos.impl.LoginDAOMySQL;
import reclamosMuni.modelo.daos.impl.PersonaDAOMySQL;
import reclamosMuni.modelo.daos.impl.ReclamoDAOMySQL;
import reclamosMuni.modelo.daos.impl.UsuarioDAOMySQL;
import reclamosMuni.modelo.dtos.PersonaDTO;

/**
 *
 * @author piahe
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegisterServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegisterServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        UsuarioDTO user;
        user = new UsuarioDTO();
        String username = request.getParameter("username");
        String pass = request.getParameter("pass");
        request.getSession().setAttribute("usuario", username);
        request.getRequestDispatcher("WEB-INF/pages/register.jsp").forward(request, response);
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
        UsuarioDTO user = new UsuarioDTO();
        PersonaDTO persona = new PersonaDTO();
        String username = request.getParameter("username");
        String pass = request.getParameter("pass");

        Modelo model = new Modelo(new PersonaDAOMySQL(), new UsuarioDAOMySQL());

        try {
            user = model.register(username, pass);
            System.out.println("chalala servlet register usuario creado?");
            persona = model.crearPersonaVacia(user.getId());
            request.getSession().setAttribute("usuario", user);
            System.out.println(user.toString());
            System.out.println(persona.toString());
            System.out.println("chalalalala completar persona");

            request.getRequestDispatcher("/WEB-INF/pages/completarPersona.jsp").forward(request, response);

        } catch (DNIAlreadyExistsException e) {
            request.setAttribute("errorMessage", "DNI ya esta cargado, utiliza otro");
            request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);
        } catch (EmailAlreadyExistsException e) {
            request.setAttribute("errorMessage", "Email ya esta cargado, utiliza otro");
            request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("errorMessage", "Ha ocurrido un error inesperado");
            request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);
        }
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
