/*
 * 
 * 
 */

package reclamosMuni.modelo;

/**
 *
 * @author piahe
 */
public class Administrador extends UsuarioDTO {

    public Administrador(int id, String nombre_usuario, String pass) {
        super(id, nombre_usuario, pass, 1);
    }
}
