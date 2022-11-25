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
        Modelo model = new Modelo(new LoginDAOMySQL(), new UsuarioDAOMySQL(),new ReclamoDAOMySQL());
        UsuarioDTO usuario  =model.login(user, pass);
        System.out.println(usuario);
        if (usuario.es_valido) {
            List<ReclamoDTO> reclamos;
            LoginDTO login = new LoginDTO(usuario.getId(), LocalDate.now(), LocalTime.now());
            model.cargarLogin(login);
            if(usuario.getEs_admin()){
                reclamos = model.obtenerReclamos();
            }else{
                reclamos = model.listarPorUser(usuario);
            }
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(20);
            request.getSession().setAttribute("usuario", usuario);
            request.getSession().setAttribute("reclamos", reclamos);
            request.getRequestDispatcher("/WEB-INF/views/reclamos.jsp").forward(request, response);
        } else {
            request.setAttribute("mensajeError", "401: Usuario no encontrado");
            request.getRequestDispatcher("WEB-INF/views/error.jsp").forward(request, response);
        }
    }
}

