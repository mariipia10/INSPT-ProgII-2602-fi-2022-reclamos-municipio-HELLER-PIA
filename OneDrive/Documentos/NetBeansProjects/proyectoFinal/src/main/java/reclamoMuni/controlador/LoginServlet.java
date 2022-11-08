///*
// * 
// * 
// */
//package reclamoMuni.controlador;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import reclamosMuni.modelo.UsuarioDTO;
//
///**
// * Servlet implementation class LoginServlet
// */
//public class LoginServlet extends HttpServlet {
//
//    public void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, java.io.IOException {
//
//        try {
//
//            UsuarioDTO user = new UsuarioDTO();
//            user.setNombre_usuario(request.getParameter("user"));
//            user.setPass(request.getParameter("pass"));
//
//            user = UserDAO.login(user);
//
//            if (user.isValid()) {
//
//                HttpSession session = request.getSession(true);
//                session.setAttribute("currentSessionUser", user);
//                response.sendRedirect("userLogged.jsp"); //logged-in page      		
//            } else {
//                response.sendRedirect("invalidLogin.jsp"); //error page 
//            }
//        } catch (Throwable theException) {
//            System.out.println(theException);
//        }
//    }
//}
