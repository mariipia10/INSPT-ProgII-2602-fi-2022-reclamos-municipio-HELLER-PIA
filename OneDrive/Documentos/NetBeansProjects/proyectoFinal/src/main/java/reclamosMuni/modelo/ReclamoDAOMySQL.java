/*
 * 
 * 
 */

package reclamosMuni.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author piahe
 */
public class ReclamoDAOMySQL {
    private static final String SQL_SELECT = "SELECT id,descripcion,persona_id,categoria_id,direccion FROM reclamo";
    private static final String SQL_SELECT_BY_ID ="SELECT id,descripcion,persona_id,categoria_id,direccion FROM reclamo WHERE id = ?";
    private static final String SQL_INSERT = "INSERT INTO reclamo(id,descripcion,fecha_inicio,fecha_fin,persona_id,categoria_id,direccion) VALUES (?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE reclamo SET descripcion=?,fecha_inicio=?,fecha_fin=?,persona_id=?,categoria_id=?,direccion=?";
    private static final String SQL_DELETE = "";
    
     public List<ReclamoDTO> listar(){
     Connection conn=null;
     PreparedStatement stmt=null;
     ResultSet rs=null;
     List<ReclamoDTO> reclamos= new ArrayList<ReclamoDTO>();
     
     try {
         conn=Conexion.getConnection();
         stmt=conn.prepareStatement(SQL_SELECT);
         rs=stmt.executeQuery();
         while (rs.next()) {             
             int id =rs.getInt("id");
             String descripcion =rs.getString("descripcion");
             int persona_id =rs.getInt("persona_id");
             int categoria_id =rs.getInt("categoria_id");
             String direccion =rs.getString("direccion");
             System.out.println(id+" "+descripcion+" "+direccion);
              
           reclamos.add(new ReclamoDTO(id,descripcion,persona_id,categoria_id,direccion));
         }
         
     } catch (Exception e) {
         e.printStackTrace(System.out);
     }finally{
         Conexion.Close(rs);
         Conexion.Close(stmt);
         Conexion.Close(conn);
                 
     }
     
     return reclamos;
 }
     public static void main(String[] args) {
        ReclamoDAOMySQL reclamo= new ReclamoDAOMySQL();
        reclamo.listar();
    }
}
