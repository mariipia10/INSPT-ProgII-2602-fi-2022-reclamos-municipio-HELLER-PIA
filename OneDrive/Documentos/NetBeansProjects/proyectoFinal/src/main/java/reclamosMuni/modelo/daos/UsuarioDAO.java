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
public interface UsuarioDAO {

     public UsuarioDTO login(String usuario,String pass);
     public UsuarioDTO register(String usuario,String pass); //,Connection conn);
     public boolean idValido(int id);
     public boolean usernameValido (String usuario);
}
