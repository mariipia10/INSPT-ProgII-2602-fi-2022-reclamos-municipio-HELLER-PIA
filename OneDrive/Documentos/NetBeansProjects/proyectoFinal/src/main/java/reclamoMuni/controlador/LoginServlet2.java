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
import reclamosMuni.modelo.dtos.*;
import reclamosMuni.modelo.daos.*;
import reclamosMuni.modelo.daos.impl.*;

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet("/LoginServlet") 
@WebServlet(name = "Parcial2", urlPatterns = {"/parcial22"})

public class LoginServlet2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UsuarioDTO user = (UsuarioDTO) request.getSession().getAttribute("usuario");
        request.getSession().setAttribute("usuario", user);
        request.getRequestDispatcher("WEB-INF/pages/login.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException {
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        Modelo model = new Modelo(new ReclamoDAOMySQL(), new LoginDAOMySQL(), new UsuarioDAOMySQL(), new PersonaDAOMySQL());
        UsuarioDTO usuario = model.login(user, pass);
        if (usuario.es_valido) {
            List<ReclamoDTO> reclamos;
            PersonaDTO persona = model.crearPersona(usuario);
            LoginDTO login = new LoginDTO(usuario.getId(), LocalDate.now(), LocalTime.now());
            model.cargarLogin(login);
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(20);
            request.getSession().setAttribute("persona", persona);
            reclamos = model.obtenerReclamos(persona);
            request.getSession().setAttribute("reclamos", reclamos);
            request.getRequestDispatcher("/WEB-INF/views/reclamos.jsp").forward(request, response);
        } else {
            request.setAttribute("mensajeError", "401: Usuario no encontrado");
            request.getRequestDispatcher("WEB-INF/views/error.jsp").forward(request, response);
        }
    }
}

