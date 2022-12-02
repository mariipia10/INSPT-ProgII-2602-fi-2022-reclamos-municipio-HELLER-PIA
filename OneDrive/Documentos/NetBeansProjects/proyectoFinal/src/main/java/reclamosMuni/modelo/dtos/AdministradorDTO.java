/*
 * 
 * 
 */

package reclamosMuni.modelo.dtos;

/**
 *
 * @author piahe
 */
public class AdministradorDTO extends PersonaDTO {

    public AdministradorDTO(int id, String nombre, String apellido, String mail, String telefono, int id_usuario, String dni) {
        super(id, nombre, apellido, mail, telefono, id_usuario, dni);
    }
}
