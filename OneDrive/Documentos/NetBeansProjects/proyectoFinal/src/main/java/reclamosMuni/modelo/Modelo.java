/*
 * 
 * 
 */

package reclamosMuni.modelo;

import reclamosMuni.modelo.daos.impl.ReclamoDAOMySQL;
import reclamosMuni.modelo.dtos.ReclamoDTO;
import reclamosMuni.modelo.dtos.UsuarioDTO;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import reclamosMuni.modelo.daos.LoginDAO;
import reclamosMuni.modelo.daos.PersonaDAO;
import reclamosMuni.modelo.daos.UsuarioDAO;
import reclamosMuni.modelo.dtos.LoginDTO;
import reclamosMuni.modelo.dtos.PersonaDTO;

/**
 *
 * @author piahe
 */
public class Modelo {
    private ReclamoDAOMySQL reclamo;
    private LoginDAO loginDAO;
    private UsuarioDAO usuarioDAO;
    private PersonaDAO personaDAO;

    //Constructors
    public Modelo(LoginDAO loginDAO, UsuarioDAO usuarioDAO,PersonaDAO personaDAO) {
        this.loginDAO = loginDAO;
        this.usuarioDAO = usuarioDAO;
        this.personaDAO = personaDAO;
    }

    public Modelo(ReclamoDAOMySQL reclamo, LoginDAO loginDAO, UsuarioDAO usuarioDAO, PersonaDAO personaDAO) {
        this.reclamo = reclamo;
        this.loginDAO = loginDAO;
        this.usuarioDAO = usuarioDAO;
        this.personaDAO = personaDAO;
    }
    
    public Modelo(LoginDAO loginDAO, UsuarioDAO usuarioDAO) {
        this.loginDAO = loginDAO;
        this.usuarioDAO = usuarioDAO;
    }

    public Modelo(ReclamoDAOMySQL reclamo, UsuarioDAO usuarioDAO) {
        this.reclamo = reclamo;
        this.usuarioDAO = usuarioDAO;
    }
     public Modelo(PersonaDAO personaDAO, UsuarioDAO usuarioDAO) {
        this.personaDAO = personaDAO;
        this.usuarioDAO = usuarioDAO;
    }
    
    
    //Reclamo
     public List<ReclamoDTO> obtenerReclamos(PersonaDTO persona) {
        return reclamo.listar(persona);
    }
    public List <ReclamoDTO> getReclamos(){
        List<ReclamoDTO> lista;
        lista = new ArrayList<>();
        return lista;
    }
    
    //LOGIN 
    public List<ReclamoDTO>listarPorUser(UsuarioDTO user){
        return reclamo.listarPorUser(user);
    }
    
    public void cargarLogin(LoginDTO login) {
        loginDAO.cargarLogin(login);
    }
    public List<LoginDTO> obtenerLogins(int id) {
        return loginDAO.obtenerLoginsPorID(id);
    }
    //Usuario
    public boolean idValido(int id) {
        return usuarioDAO.idValido(id);
    }
    public UsuarioDTO login(String usuario, String contraseña) {
        return usuarioDAO.login(usuario, usuario);
    }
    
    //Persona
     public PersonaDTO crearPersona(UsuarioDTO usuario) {
        return personaDAO.crearPersona(usuario);
    }
    
    
}
