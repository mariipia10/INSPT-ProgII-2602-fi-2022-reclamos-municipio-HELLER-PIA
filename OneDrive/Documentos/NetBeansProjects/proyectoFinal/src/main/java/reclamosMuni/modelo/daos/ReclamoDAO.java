/*
 * 
 * 
 */

package reclamosMuni.modelo.daos;

import java.util.Collection;
import reclamosMuni.modelo.ReclamoDTO;

/**
 *
 * @author piahe
 */
public interface ReclamoDAO {
    public Collection<ReclamoDTO> obtenerReclamos();
    public ReclamoDTO obtenerReclamo(int id_reclamo); 
}
