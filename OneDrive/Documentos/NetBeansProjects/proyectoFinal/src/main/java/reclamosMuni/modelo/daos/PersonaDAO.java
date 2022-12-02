/*
 * 
 * 
 */

package reclamosMuni.modelo.daos;

import reclamosMuni.modelo.dtos.PersonaDTO;
import reclamosMuni.modelo.dtos.UsuarioDTO;

/**
 *
 * @author piahe
 */
public interface PersonaDAO {

        public PersonaDTO crearPersona(UsuarioDTO user);
}
