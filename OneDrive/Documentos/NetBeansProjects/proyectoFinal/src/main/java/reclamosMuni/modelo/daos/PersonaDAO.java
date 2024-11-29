/*
 * 
 * 
 */

package reclamosMuni.modelo.daos;

import java.sql.Connection;
import reclamosMuni.modelo.dtos.PersonaDTO;
import reclamosMuni.modelo.dtos.UsuarioDTO;

/**
 *
 * @author piahe
 */
public interface PersonaDAO {

        public PersonaDTO buscarPersonaPorUserID(UsuarioDTO user);  
        public PersonaDTO crearPersona(String nombre, String apellido, String dni, String mail, String telefono, int ID); //,Connection conn);
        public PersonaDTO crearPersonaVacia(int userID);
        public PersonaDTO actualizarPersona(String nombre,String apellido, String dni, String mail, String telefono, int ID);
        public Boolean dniValido (String dni);
        public Boolean mailValido(String mail);
}
