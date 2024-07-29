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
    private static final String SQL_SELECT = "SELECT id,descripcion,persona_id,categoria,direccion,fecha_inicio,fecha_fin FROM reclamo";

    public AdministradorDTO(int id, String nombre, String apellido, String mail, String telefono, int id_usuario, String dni) {
        super(id, nombre, apellido, mail, telefono, id_usuario, dni);
    }
    
    @Override
    public String getReclamosSQL(){
        return SQL_SELECT;
    }
    @Override
    public boolean puedeVerLogin(){
        return true;
    }
    public boolean esAdmin(){
        return true;
    }
}
