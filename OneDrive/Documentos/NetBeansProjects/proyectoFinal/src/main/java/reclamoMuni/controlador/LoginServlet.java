/*
 * 
 * 
 */
package reclamoMuni.controlador;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import reclamosMuni.modelo.Modelo;
import reclamosMuni.modelo.dtos.*;
import reclamosMuni.modelo.daos.*;
import reclamosMuni.modelo.daos.impl.*;

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet("/LoginServlet") 
@WebServlet(name = "Parcial2", urlPatterns = {"/parcial2"})

public class LoginServlet extends HttpServlet {

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
        Modelo model = new Modelo(new LoginDAOMySQL(), new UsuarioDAOMySQL(), new PersonaDAOMySQL());
        UsuarioDTO usuario = model.login(user, pass);
        PersonaDTO persona = model.buscarPersonaPorUserID(usuario);
        System.out.println(usuario.toString());
        System.out.println(persona.toString());
        if (usuario == null || !usuario.es_valido) {  // Verificamos que el usuario no sea null y que sea válido
        request.setAttribute("mensajeError", "401: Usuario no encontrado");
        request.getRequestDispatcher("WEB-INF/views/error.jsp").forward(request, response);
        return;  // Si el usuario no es válido, redirigimos al error y terminamos la ejecución
    }
        request.getSession().setAttribute("usuario", usuario);

        if (usuario.es_valido) { //solo es valido si el user existe, es un flag manual
            System.out.println(usuario.toString());
            
            if (persona == null) { //persona no fue cargada, la creo y mando a completar
                model.crearPersonaVacia(usuario.getId());
                request.getRequestDispatcher("/WEB-INF/pages/completarPersona.jsp").forward(request, response);
            }
            if (!model.personaEstaCompleta(usuario)) {//persona existe, incompleta
                request.getRequestDispatcher("/WEB-INF/pages/completarPersona.jsp").forward(request, response);
            }
            //persona completa, mando a home y registro login
            LoginDTO login = new LoginDTO(usuario.getId(), LocalDate.now(), LocalTime.now());
            model.cargarLogin(login);
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(120);
            request.getSession().setAttribute("persona", persona);
            request.getRequestDispatcher("reclamos/all").forward(request, response);
        } else {
            request.setAttribute("mensajeError", "401: Usuario no encontrado");
            request.getRequestDispatcher("WEB-INF/views/error.jsp").forward(request, response);
        }
    }
}
