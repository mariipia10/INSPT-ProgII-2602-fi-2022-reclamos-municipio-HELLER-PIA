/*
 * 
 * 
 */
package reclamosMuni.modelo.dtos;

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

    public UsuarioDTO(){
    }

    public UsuarioDTO(String nombre_usuario, String pass, int es_admin) {
        this.nombre_usuario = nombre_usuario;
        this.pass = pass;
        this.es_admin = es_admin;
        this.es_valido = true;
    }
    public UsuarioDTO(String nombre_usuario, String pass) {
        this.nombre_usuario = nombre_usuario;
        this.pass = pass;
        this.es_valido = true;

    }

    public void setId(int id) {
        if(id>0){
            this.id = id;
        }
    }

    
    public int getId() {
        return id;
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

    public boolean getEs_admin() {
        return es_admin==1;
    }

    public void setEs_admin(int es_admin) {
        this.es_admin = es_admin;
    }

    public boolean esValido() {
        return es_valido;
    }

    public void setValido(boolean valido) {
        this.es_valido = valido;
    }

    @Override
    public String toString() {
        return "UsuarioDTO{" + "id=" + id + ", nombre_usuario=" + nombre_usuario + ", pass=" + pass + ", es_admin=" + es_admin + ", es_valido=" + es_valido + '}';
    }

}
