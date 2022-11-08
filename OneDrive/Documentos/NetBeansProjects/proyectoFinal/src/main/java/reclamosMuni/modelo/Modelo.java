/*
 * 
 * 
 */

package reclamosMuni.modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author piahe
 */
public class Modelo {
    private ReclamoDAOMySQL reclamo;
    public Collection<ReclamoDTO> obtenerReclamos() {
        return reclamo.listar();
    }
    public List <ReclamoDTO> getReclamos(){
        List<ReclamoDTO> lista;
        lista = new ArrayList<>();
        return lista;
    }
    
    
}
