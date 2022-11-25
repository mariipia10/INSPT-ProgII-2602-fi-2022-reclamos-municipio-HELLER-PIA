/*
 * 
 * 
 */

package reclamosMuni.modelo.daos;

import java.util.List;
import reclamosMuni.modelo.dtos.LoginDTO;

/**
 *
 * @author piahe
 */
public interface LoginDAO {
    public List<LoginDTO> obtenerLogins();
    public List<LoginDTO> obtenerLoginsPorID(int id);
    public void cargarLogin(LoginDTO login);
}
