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
import reclamosMuni.modelo.dtos.PersonaDTO;

/**
 *
 * @author piahe
 */
@WebFilter(filterName = "FiltroLogin", urlPatterns = {"/reclamos/all", "/verLogins"})
//@WebFilter(filterName = "FiltroLogin", urlPatterns = {"/verLogins","/loginHistory"})

public class FiltroLogin implements Filter {

    private static final boolean debug = true;
    private FilterConfig filterConfig = null;

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession();
        if (session != null && session.getAttribute("persona") != null) {
            chain.doFilter(request, response); 
        } else {
            request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
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


