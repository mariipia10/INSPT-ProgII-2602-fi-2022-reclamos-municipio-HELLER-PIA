/*
 * 
 * 
 */

package reclamosMuni.modelo.daos;

import reclamosMuni.modelo.UsuarioDTO;

/**
 *
 * @author piahe
 */
public interface UsuarioDAO {

     public UsuarioDTO login(String usuario,String pass);
     public boolean idValido(int id);
}
