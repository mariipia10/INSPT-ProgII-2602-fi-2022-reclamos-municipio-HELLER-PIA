/*
 * 
 * 
 */

package reclamosMuni.modelo.daos.impl;

import reclamosMuni.modelo.dtos.UsuarioDTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import reclamosMuni.modelo.Conexion;
import reclamosMuni.modelo.daos.UsuarioDAO;

/**
 *
 * @author piahe
 */
public class UsuarioDAOMySQL implements UsuarioDAO {
    private static final String SQL_SELECT ="SELECT * FROM usuario WHERE nombre_usuario=? AND pass=?";
    private static final String SQL_SELECT_BY_ID ="SELECT * FROM usuario WHERE id=?";
    public UsuarioDAOMySQL() {
        
    }
    
    public UsuarioDTO login(String usuario,String pass){
    
         Statement stmt = null;    
	 Connection conn=null;
         PreparedStatement prep_stmt=null;
         ResultSet rs=null;
         UsuarioDTO user = new UsuarioDTO(usuario,pass);
         
         try {
         conn=Conexion.getConnection();
         prep_stmt=conn.prepareStatement(SQL_SELECT);
         prep_stmt.setString(1,usuario);
         prep_stmt.setString(2, pass);
         rs=prep_stmt.executeQuery();
         boolean more = rs.next();
         
         if (!more) 
         {
            System.out.println("Usuario no registrado");
            user.setValido(false);
         }  else if (more) 
         {
	     	
            System.out.println("Bienvenido " + usuario);
            user.setValido(true);
            int esAdmin = rs.getInt(4);
            user.setEs_admin(esAdmin);
            user.setNombre_usuario(usuario);
            user.setPass(pass);
            user.setId(rs.getInt("id"));
         }
         
         
         
         
     } catch (Exception e) {
         e.printStackTrace(System.out);
     }finally{
         Conexion.Close(rs);
         Conexion.Close(prep_stmt);
         Conexion.Close(conn);
                 
     }
         return user;
    }

    @Override
    public boolean idValido(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        UsuarioDTO usuario = new UsuarioDTO();
        boolean esValido=false;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                if (id == rs.getInt(1)) {
                    esValido = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.Close(rs);
            Conexion.Close(stmt);
            Conexion.Close(conn);

        }

        return esValido;
    }
    public static void main(String[] args) {
        //UsuarioDAOMySQL u = new UsuarioDAOMySQL();
        //reclamo.listarPorUser(1);
        //boolean b = u.idValido(500);
        //System.out.println(b);
        //Date n = new Date(1011, 2, 1);
        //System.out.println(n);
    }
}
