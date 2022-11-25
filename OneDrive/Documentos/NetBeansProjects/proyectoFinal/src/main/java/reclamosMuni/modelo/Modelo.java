/*
 * 
 * 
 */

package reclamosMuni.modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import reclamosMuni.modelo.daos.LoginDAO;
import reclamosMuni.modelo.daos.UsuarioDAO;
import reclamosMuni.modelo.dtos.LoginDTO;

/**
 *
 * @author piahe
 */
public class Modelo {
    private ReclamoDAOMySQL reclamo;
    private LoginDAO loginDAO;
    private UsuarioDAO usuarioDAO;

    public Modelo(LoginDAO loginDAO, UsuarioDAO usuarioDAO) {
        this.loginDAO = loginDAO;
        this.usuarioDAO = usuarioDAO;
    }
    

    
    
    public Collection<ReclamoDTO> obtenerReclamos() {
        return reclamo.listar();
    }
    public List <ReclamoDTO> getReclamos(){
        List<ReclamoDTO> lista;
        lista = new ArrayList<>();
        return lista;
    }
    public void cargarLogin(LoginDTO login) {
        loginDAO.cargarLogin(login);
    }
    public List<LoginDTO> obtenerLogins(int id) {
        return loginDAO.obtenerLoginsPorID(id);
    }
    public boolean idValido(int id) {
        return usuarioDAO.idValido(id);
    }
    public UsuarioDTO login(String usuario, String contraseña) {
        return usuarioDAO.login(usuario, usuario);
    }
    
    
}
