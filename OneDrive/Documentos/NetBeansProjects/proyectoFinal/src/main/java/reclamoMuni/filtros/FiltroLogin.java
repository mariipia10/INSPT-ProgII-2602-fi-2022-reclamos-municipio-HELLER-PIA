/*
 * 
 * 
 */
package reclamoMuni.filtros;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author piahe
 */
@WebFilter(filterName = "FiltroLogin", urlPatterns = {"/reclamos/all", "/verLogins"})

public class FiltroLogin implements Filter {

    private static final boolean debug = true;
    private FilterConfig filterConfig = null;

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;

        HttpSession session = httpRequest.getSession();
        if (session != null && session.getAttribute("usuario") != null) {
            System.out.println("aca");
            chain.doFilter(request, response); // Ir al siguiente en la cadena de filters
            //en caso de que no haya uno va directo a una de esas paginas....
        } else {
            String origin = httpRequest.getServletPath();
            String query = "?origen=" + origin;
            request.getRequestDispatcher("/parcial2" + query).forward(request, response);
        }

    }
    //Abstract necessary methods, do not delete
    public void destroy() {
    }

    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
        if (filterConfig != null) {
            if (debug) {
                log("FiltroLogin:Inicializandos filter");
            }
        }
    }

    public void log(String msg) {
        filterConfig.getServletContext().log(msg);
    }

}


