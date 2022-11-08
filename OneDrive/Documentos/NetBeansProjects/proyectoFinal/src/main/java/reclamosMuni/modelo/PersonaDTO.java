/*
 * 
 * 
 */

package reclamosMuni.modelo;

import java.sql.Date;

/**
 *
 * @author piahe
 */
public class PersonaDTO {
    private int id;
    private String nombre;
    private String apellido;
    private String mail;
    private String telefono;
    private int id_usuario;

    public PersonaDTO(int id, String nombre, String apellido, String mail, String telefono, int id_usuario) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
        this.telefono = telefono;
        this.id_usuario = id_usuario;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    @Override
    public String toString() {
        return "PersonaDTO{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", mail=" + mail + ", telefono=" + telefono + ", id_usuario=" + id_usuario + '}';
    }
    
    

}
