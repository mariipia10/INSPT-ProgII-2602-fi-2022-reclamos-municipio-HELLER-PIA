/*
 * 
 * 
 */
package reclamosMuni.modelo;

import java.sql.Connection;
import reclamosMuni.modelo.daos.impl.ReclamoDAOMySQL;
import reclamosMuni.modelo.dtos.ReclamoDTO;
import reclamosMuni.modelo.dtos.UsuarioDTO;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import reclamosMuni.modelo.daos.LoginDAO;
import reclamosMuni.modelo.daos.PersonaDAO;
import reclamosMuni.modelo.daos.ReclamoDAO;
import reclamosMuni.modelo.daos.UsuarioDAO;
import reclamosMuni.modelo.dtos.LoginDTO;
import reclamosMuni.modelo.dtos.PersonaDTO;

/**
 *
 * @author piahe
 */
public class Modelo {

    private ReclamoDAO reclamoDAO;
    private LoginDAO loginDAO;
    private UsuarioDAO usuarioDAO;
    private PersonaDAO personaDAO;

    //Constructors
    public Modelo(LoginDAO loginDAO, UsuarioDAO usuarioDAO, PersonaDAO personaDAO) {
        this.loginDAO = loginDAO;
        this.usuarioDAO = usuarioDAO;
        this.personaDAO = personaDAO;
    }

    public Modelo(PersonaDAO personaDAO) {
        this.personaDAO = personaDAO;
    }
    
    public Modelo(ReclamoDAO reclamoDAO) {
        this.reclamoDAO = reclamoDAO;
    }

    public Modelo(ReclamoDAOMySQL reclamo, LoginDAO loginDAO, UsuarioDAO usuarioDAO, PersonaDAO personaDAO) {
        this.reclamoDAO = reclamo;
        this.loginDAO = loginDAO;
        this.usuarioDAO = usuarioDAO;
        this.personaDAO = personaDAO;
    }

    public Modelo(LoginDAO loginDAO, UsuarioDAO usuarioDAO) {
        this.loginDAO = loginDAO;
        this.usuarioDAO = usuarioDAO;
    }

    public Modelo(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    public Modelo(ReclamoDAOMySQL reclamo, UsuarioDAO usuarioDAO) {
        this.reclamoDAO = reclamo;
        this.usuarioDAO = usuarioDAO;
    }

    public Modelo(PersonaDAO personaDAO, UsuarioDAO usuarioDAO) {
        this.personaDAO = personaDAO;
        this.usuarioDAO = usuarioDAO;
    }

    //Reclamo
    public List<ReclamoDTO> obtenerReclamos(PersonaDTO persona) {
        return reclamoDAO.listar(persona);
    }

    public List<ReclamoDTO> getReclamos() {
        List<ReclamoDTO> lista;
        lista = new ArrayList<>();
        return lista;
    }
    
    public int insertar(ReclamoDTO reclamo){
          return reclamoDAO.insertar(reclamo);
    }
    
    public int actualizar(ReclamoDTO reclamo){
        return reclamoDAO.actualizar(reclamo);
    }
    
        public int eliminar(int reclamoID){
            return reclamoDAO.eliminar(reclamoID);
        }
        public int resolver(int reclamoID){
            return reclamoDAO.resolver(reclamoID);
        }


    
    public ReclamoDTO buscarPorId(int reclamoID){
        return reclamoDAO.buscarPorId(reclamoID);
    } 

    //LOGIN 
    public List<ReclamoDTO> listarPorUser(UsuarioDTO user) {
        return reclamoDAO.listarPorUser(user);
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

    public UsuarioDTO login(String usuario, String pass) {
        return usuarioDAO.login(usuario, pass);
    }

    public UsuarioDTO register(String usuario, String pass) {
        return usuarioDAO.register(usuario, pass);

    }

    /*public UsuarioDTO register(String usuario, String pass,Connection conn) {
        return usuarioDAO.register(usuario, pass,conn);
                
    }*/
    //Persona
    public PersonaDTO buscarPersonaPorUserID(UsuarioDTO usuario) {
        return personaDAO.buscarPersonaPorUserID(usuario);
    }

    public PersonaDTO crearPersona(String nombre, String apellido, String dni, String mail, String telefono, int ID, Connection conn) {
        return personaDAO.crearPersona(nombre, apellido, dni, mail, telefono, ID);
    }

    public PersonaDTO crearPersonaVacia(int userID) {
        return personaDAO.crearPersonaVacia(userID);
    }

    public PersonaDTO actualizarPersona(String nombre, String apellido, String dni, String mail, String telefono, int ID) {
        return personaDAO.actualizarPersona(nombre, apellido, dni, mail, telefono, ID);
    }

    public boolean personaEstaCompleta(UsuarioDTO user) {
        PersonaDTO persona = personaDAO.buscarPersonaPorUserID(user);
        return persona != null && persona.esta_completa(); // Devuelve si está completada
    }



}
