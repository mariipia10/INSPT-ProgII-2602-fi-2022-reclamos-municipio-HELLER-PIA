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
    public List<LoginDTO> obtenerLogins(); //trae todo los logins
    public List<LoginDTO> obtenerLoginsPorID(int id); //Trae logins x id
    public void cargarLogin(LoginDTO login); //carga login en su tabla
}
