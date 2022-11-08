/*
 * 
 * 
 */

package reclamosMuni.modelo;

import reclamosMuni.modelo.Conexion;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import reclamosMuni.modelo.Conexion;

/**
 *
 * @author piahe
 */
public class ReclamoDTO implements Serializable{

//    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
//    private static final String URL = "jdbc:mysql://localhost:3306/reclamo";
//    private static final String USER = "root";
//    private static final String PASS = "1234";
    private int id;
    private String descripcion;
    private Date fecha_inicio;
    private Date fecha_fin;
    private int persona_id;
    private int categoria_id;
    private String direccion;
    
    public ReclamoDTO() {}

    public ReclamoDTO(int id, String descripcion, int persona_id, int categoria_id, String direccion) {
        this.id = id;
        this.descripcion = descripcion;
        this.persona_id = persona_id;
        this.categoria_id = categoria_id;
        this.direccion = direccion;
        //System.out.println("RECLAMO DTO CONSTRUCTORS");
    }

    public ReclamoDTO(int id,String descripcion,  Date fecha_inicio, Date fecha_fin, int persona_id, int categoria_id, String direccion) {
        setId(id);
        setDescripcion(descripcion);
        setFecha_inicio(fecha_inicio);
        setFecha_fin(fecha_fin);
        setPersona_id(persona_id);
        setCategoria_id(categoria_id);
        setDireccion(direccion);
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public int getPersona_id() {
        return persona_id;
    }

    public void setPersona_id(int persona_id) {
        this.persona_id = persona_id;
    }

    public int getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(int categoria_id) {
        this.categoria_id = categoria_id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
//    public Collection<ReclamoDTO> obtenerReclamos()  {
//        Collection<ReclamoDTO> reclamos = new ArrayList<ReclamoDTO>();
//        try {
//            Connection con = Conexion2.getConexion(DRIVER, URL, USER, PASS);
//            
//            PreparedStatement ps = con.prepareStatement("SELECT id,descripcion FROM reclamo");
//            ResultSet rs = ps.executeQuery();
//            
//            while (rs.next()) {
//                int id = rs.getInt(1);
//                String descripcion = rs.getString(2);
//                ReclamoDTO reclamo = new ReclamoDTO(descripcion, id);
//                reclamos.add(reclamo);
//            }
//        } catch (SQLException ex) {
//            throw new RuntimeException("Error al obtener reclamos", ex);
//        }
//        return reclamos;
//    }

    @Override
    public String toString() {
        return "ReclamoDTO{" + "id=" + id + ", descripcion=" + descripcion + ", fecha_inicio=" + fecha_inicio + ", fecha_fin=" + fecha_fin + ", persona_id=" + persona_id + ", categoria_id=" + categoria_id + ", direccion=" + direccion + '}';
    }
    

}