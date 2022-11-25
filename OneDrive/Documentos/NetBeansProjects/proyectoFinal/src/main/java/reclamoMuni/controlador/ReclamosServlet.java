/*
 * 
 * 
 */
package reclamoMuni.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import reclamosMuni.modelo.Modelo;
import reclamosMuni.modelo.ReclamoDAOMySQL;
import reclamosMuni.modelo.ReclamoDTO;

/**
 *
 * @author piahe
 */
@WebServlet(name = "ReclamosServlet", urlPatterns = {"/reclamos/all"})
public class ReclamosServlet extends HttpServlet {
    private Modelo model;
    @Override
    public void init() throws ServletException{
        //this.model = new Modelo();
    }

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
            out.println("<title>Servlet ReclamosServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ReclamosServlet at " + request.getContextPath() + "</h1>");
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
        List<ReclamoDTO> reclamos = new ReclamoDAOMySQL().listar();
        System.out.println("reclamos = " + reclamos);
        request.setAttribute("reclamos", reclamos);
        request.getRequestDispatcher("/reclamos.jsp").forward(request, response);
        PrintWriter out = response.getWriter();
        out.println("HOLA");
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
        System.out.println("Estoy en dopost");
        //request.getRequestDispatcher("/reclamos.jsp").forward(request, response);
        //request.setAttribute("listaReclamos", model.getReclamos());
        //processRequest(request, response);
        PrintWriter out = response.getWriter();
              //out.println("<html>Hola "+nom+" " + apellido + " </html>");
               out.println("HOLADOPOST");
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
