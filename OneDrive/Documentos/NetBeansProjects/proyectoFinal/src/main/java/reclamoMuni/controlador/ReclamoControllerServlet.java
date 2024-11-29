/*
 * 
 * 
 */
package reclamoMuni.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import reclamosMuni.modelo.Modelo;
import reclamosMuni.modelo.daos.ReclamoDAO;
import reclamosMuni.modelo.daos.impl.LoginDAOMySQL;
import reclamosMuni.modelo.daos.impl.PersonaDAOMySQL;
import reclamosMuni.modelo.daos.impl.ReclamoDAOMySQL;
import reclamosMuni.modelo.daos.impl.UsuarioDAOMySQL;
import reclamosMuni.modelo.dtos.ReclamoDTO;

/**
 *
 * @author piahe
 */
@WebServlet(name = "ReclamoControllerServlet", urlPatterns = {"/ReclamoController"})
public class ReclamoControllerServlet extends HttpServlet {

    private Modelo model;

    public ReclamoControllerServlet() {
        this.model = new Modelo(new ReclamoDAOMySQL());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String destino = null;
        String accion = req.getParameter("accion");
        accion = accion == null ? "" : accion;

        switch (accion) {
            case "create": // Formulario de creación
                destino = "/WEB-INF/jsp/crearReclamo.jsp";
                break;
            case "resolve":
                System.out.println("HOLA, ,servletpost");

                int idResolver = Integer.parseInt(req.getParameter("id"));
                model.resolver(idResolver);
                resp.sendRedirect("reclamos/all");

                //destino = "/WEB-INF/views/reclamos.jsp";
                break;
            /*case "read": // Ver detalle de un reclamo
                String idStr = req.getParameter("id");
                if (idStr != null) {
                    ReclamoDTO reclamo = model.buscarPorId(Integer.parseInt(idStr));
                    req.setAttribute("reclamo", reclamo);
                    destino = "/WEB-INF/jsp/reclamoDetail.jsp";
                } else {
                    destino = "/reclamos/all";
                }
                break;*/
            case "update": // Formulario de edición
                String idEditStr = req.getParameter("id");
                if (idEditStr != null) {
                    ReclamoDTO reclamo = model.buscarPorId(Integer.parseInt(idEditStr));
                    req.setAttribute("reclamo", reclamo);
                    destino = "/WEB-INF/pages/editarReclamo.jsp";
                } else {
                    destino = "/WEB-INF/jsp/error.jsp";
                }
                break;
            case "delete": // Confirmación de eliminación
                /*String idDeleteStr = req.getParameter("id");
                if (idDeleteStr != null) {
                    ReclamoDTO reclamo = model.buscarPorId(Integer.parseInt(idDeleteStr));
                    req.setAttribute("reclamo", reclamo);
                    destino = "/WEB-INF/jsp/reclamoDeleteConf.jsp";
                } else {
                    destino = "/WEB-INF/views/error.jsp";
                }
                break;*/
                int idEliminar = Integer.parseInt(req.getParameter("id"));
                model.eliminar(idEliminar);
                resp.sendRedirect("reclamos/all");
                break;
            default: // Listar todos los reclamos
                destino = "/WEB-INF/views/reclamos.jsp";
        }

        //req.getRequestDispatcher(destino).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accion = req.getParameter("accion");
        accion = accion == null ? "" : accion;

        switch (accion) {
            case "create":
                ReclamoDTO nuevoReclamo = new ReclamoDTO();
                nuevoReclamo.setDescripcion(req.getParameter("descripcion"));
                nuevoReclamo.setCategoria(req.getParameter("categoria"));
                nuevoReclamo.setDireccion(req.getParameter("direccion"));
                nuevoReclamo.setFecha_inicio(LocalDate.now());

                model.insertar(nuevoReclamo);
                resp.sendRedirect("ReclamoController?accion=read");
                break;
            case "resolve":
                int idResolver = Integer.parseInt(req.getParameter("id"));
                System.out.println("HOLA, ,servletpost");
                model.resolver(idResolver);
                resp.sendRedirect("ReclamoController?accion=read");
                break;
            case "update":
                ReclamoDTO reclamoActualizado = new ReclamoDTO();
                reclamoActualizado.setPersona_id(Integer.parseInt(req.getParameter("persona_id")));
                reclamoActualizado.setId(Integer.parseInt(req.getParameter("id")));
                reclamoActualizado.setDescripcion(req.getParameter("descripcion"));
                reclamoActualizado.setCategoria(req.getParameter("categoria"));
                reclamoActualizado.setDireccion(req.getParameter("direccion"));
                reclamoActualizado.setFecha_inicio(req.getParameter("fecha_inicio") != null
                        ? LocalDate.parse(req.getParameter("fecha_inicio"))
                        : null);
                //reclamoActualizado.setFecha_fin(req.getParameter("fecha_fin") != null
                //? LocalDate.parse(req.getParameter("fecha_fin"))
                //: null);

                String fechaFinStr = req.getParameter("fecha_fin");
                if (fechaFinStr != null && !fechaFinStr.isEmpty()) {
                    reclamoActualizado.setFecha_fin(LocalDate.parse(fechaFinStr));
                } else {
                    reclamoActualizado.setFecha_fin(null); // Si no se seleccionó una fecha, se asigna null
                }
                model.actualizar(reclamoActualizado);
                resp.sendRedirect("ReclamoController?accion=read");
                break;
            case "delete":
                int idEliminar = Integer.parseInt(req.getParameter("id"));
                model.eliminar(idEliminar);
                resp.sendRedirect("ReclamoController?accion=read");
                break;

            default:
                resp.sendRedirect("ReclamoController?accion=read");
        }
    }
}
