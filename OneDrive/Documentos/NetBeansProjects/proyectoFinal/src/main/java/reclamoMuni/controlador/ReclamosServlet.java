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
import reclamosMuni.modelo.daos.impl.ReclamoDAOMySQL;
import reclamosMuni.modelo.dtos.ReclamoDTO;
import reclamosMuni.modelo.daos.impl.*;
import reclamosMuni.modelo.daos.*;
import reclamosMuni.modelo.dtos.*;

/**
 *
 * @author piahe
 */
@WebServlet(name = "ReclamosServlet", urlPatterns = {"/reclamos/all"})
public class ReclamosServlet extends HttpServlet {
    private Modelo model;
   

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
         System.out.println("help");

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
        processRequest(request, response);
                 System.out.println("help1");

        //Modelo model = new Modelo(new LoginDAOMySQL(), new UsuarioDAOMySQL(), new PersonaDAOMySQL());
        Modelo model = new Modelo(new ReclamoDAOMySQL(),new LoginDAOMySQL(), new UsuarioDAOMySQL(), new PersonaDAOMySQL());
        PersonaDTO persona = (PersonaDTO) request.getSession().getAttribute("persona");
        List<ReclamoDTO> reclamos = model.obtenerReclamos(persona);
        request.setAttribute("reclamos", reclamos);

        //Vísta de la Pagina
        RequestDispatcher vista = request.getRequestDispatcher("/WEB-INF/views/reclamos.jsp");
        vista.forward(request, response);

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
          System.out.println("help3");
       // doGet(request,response);
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
