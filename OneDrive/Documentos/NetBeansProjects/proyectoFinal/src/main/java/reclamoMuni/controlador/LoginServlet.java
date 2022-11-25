/*
 * 
 * 
 */
package reclamoMuni.controlador;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import reclamosMuni.modelo.Modelo;
import reclamosMuni.modelo.ReclamoDAOMySQL;
import reclamosMuni.modelo.ReclamoDTO;
import reclamosMuni.modelo.UsuarioDAOMySQL;
import reclamosMuni.modelo.UsuarioDTO;
import reclamosMuni.modelo.daos.impl.LoginDAOMySQL;
import reclamosMuni.modelo.dtos.LoginDTO;

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet("/LoginServlet") 
@WebServlet(name = "Parcial2", urlPatterns = {"/parcial2"})

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/pages/login.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException {

        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        //UsuarioDTO usuario = usuarioDAO.login(user, pass);

        Modelo model = new Modelo(new LoginDAOMySQL(), new UsuarioDAOMySQL());
        UsuarioDTO usuario  =model.login(user, pass);
        System.out.println(usuario);
        if (usuario.es_valido) {

            LoginDTO login = new LoginDTO(usuario.getId(), LocalDate.now(), LocalTime.now());
            model.cargarLogin(login);
            System.out.println("login");
            //Guardandando y seteando los datos y configuracion del usuario
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(20);
            request.getSession().setAttribute("usuario", usuario);
            request.getRequestDispatcher("/WEB-INF/views/reclamos.jsp").forward(request, response);

            //String haciaDondeIba = request.getParameter("deDondeViene");
            //response.sendRedirect(request.getContextPath() + haciaDondeIba);
        } else {
            request.setAttribute("mensajeError", "401: Usuario no encontrado");
            request.getRequestDispatcher("WEB-INF/views/error.jsp").forward(request, response);
        }
    }
    /*
        try {
            LoginDTO login = new LoginDTO(usuario.getId(), LocalDate.now(), LocalTime.now());                     
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(35);
            request.getSession().setAttribute("usuario", usuario);
            String haciaDondeIba = request.getParameter("deDondeViene");
            response.sendRedirect(request.getContextPath() + haciaDondeIba);
            //request.setAttribute("id", usuario.getId());
        } catch (NullPointerException ex) {
            request.setAttribute("mensajeError", "No existe usuario/contraseña");
            v = request.getRequestDispatcher("error.jsp");
        } finally {
            v.forward(request, response);
        }
    if(usuario.es_valido

    
        ){
            List<ReclamoDTO> reclamos = null;
        ReclamoDAOMySQL reclamoDAO = new ReclamoDAOMySQL();
        if (usuario.getEs_admin() == 1) {
            reclamos = reclamoDAO.listar();
        } else {
            reclamos = reclamoDAO.listarPorUser(usuario);
        }

        request.setAttribute("reclamos", reclamos);
        request.getRequestDispatcher("/WEB-INF/views/reclamos.jsp").forward(request, response);
    }

    
        else{
            request.setAttribute("mensajeError", "No existe ese user o contrasenia");
        v = request.getRequestDispatcher("WEB-INF/views/error.jsp");
        v.forward(request, response);

    }        //response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Login invalido");
*/
}

