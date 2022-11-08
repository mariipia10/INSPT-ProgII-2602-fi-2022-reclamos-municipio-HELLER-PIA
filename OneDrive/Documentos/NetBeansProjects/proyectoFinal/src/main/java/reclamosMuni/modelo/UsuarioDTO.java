/*
 * 
 * 
 */
package reclamosMuni.modelo;

/**
 *
 * @author piahe
 */
public class UsuarioDTO {

    private int id;
    private String nombre_usuario;
    private String pass;
    private int es_admin;
    public boolean es_valido;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getEs_admin() {
        return es_admin;
    }

    public boolean esValido() {
        return es_valido;
    }

    public void setValido(boolean valido) {
        this.es_valido = valido;
    }

}
