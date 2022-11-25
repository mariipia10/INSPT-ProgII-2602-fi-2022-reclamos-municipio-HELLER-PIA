/*
 * 
 * 
 */

package reclamosMuni.modelo.daos;

import java.util.Collection;
import java.util.List;
import reclamosMuni.modelo.ReclamoDTO;
import reclamosMuni.modelo.UsuarioDTO;

/**
 *
 * @author piahe
 */
public interface ReclamoDAO {
    public List<ReclamoDTO> listar();
    public ReclamoDTO buscar(int reclamoID);
    public int insertar(ReclamoDTO reclamo);
    public List<ReclamoDTO> listarPorUser(UsuarioDTO user);
    public int actualizar(ReclamoDTO reclamo);
    public int eliminar(ReclamoDTO reclamo);
    }
