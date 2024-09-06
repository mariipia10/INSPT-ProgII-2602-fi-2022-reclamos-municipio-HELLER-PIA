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
import java.sql.SQLException;
import java.sql.Statement;
import reclamosMuni.modelo.Conexion;
import reclamosMuni.modelo.daos.UsuarioDAO;

/**
 *
 * @author piahe
 */
public class UsuarioDAOMySQL implements UsuarioDAO {

    private static final String SQL_SELECT = "SELECT * FROM usuario WHERE nombre_usuario=? AND pass=?";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM usuario WHERE id=?";
    private static final String SQL_SELECT_BY_USERNAME = "SELECT * FROM usuario WHERE nombre_usuario=?";
    private static final String SQL_INSERT_NEW_USER = "INSERT INTO usuario (nombre_usuario,pass,es_admin) VALUES (?,?,?)";

    //private static final String es_admin_false = "0";
    public UsuarioDAOMySQL() {

    }

    @Override
    public UsuarioDTO login(String usuario, String pass) {

        Statement stmt = null;
        Connection conn = null;
        PreparedStatement prep_stmt = null;
        ResultSet rs = null;
        UsuarioDTO user = new UsuarioDTO(usuario, pass);

        try {
            conn = Conexion.getConnection();
            prep_stmt = conn.prepareStatement(SQL_SELECT);
            prep_stmt.setString(1, usuario);
            prep_stmt.setString(2, pass);
            rs = prep_stmt.executeQuery();
            boolean more = rs.next();
            System.out.println("pass es " + pass);
            System.out.println(prep_stmt.toString());
            if (!more) {
                System.out.println("Usuario no registrado");
                user.setValido(false);
            } else if (more) {

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
        } finally {
            Conexion.Close(rs);
            Conexion.Close(prep_stmt);
            Conexion.Close(conn);
        }
        return user;
    }

    @Override
    public UsuarioDTO register(String usuario, String pass) { //DONE - Solo vamos a registrar nuevos usuarios, el admin esta creado 'a mano'
        
        Statement stmt = null;
        Connection conn = null;
        PreparedStatement prep_stmt = null;
        int rs = 0;      
        UsuarioDTO user = new UsuarioDTO(usuario, pass);
        if (usernameValido(usuario)) {
            try {
                conn = Conexion.getConnection();
                prep_stmt = conn.prepareStatement(SQL_INSERT_NEW_USER);
                prep_stmt.setString(1, usuario);
                prep_stmt.setString(2, pass);
                prep_stmt.setString(3, "0");
                System.out.println(prep_stmt);
                rs = prep_stmt.executeUpdate();

            } catch (Exception e) {
                e.printStackTrace(System.out);
            } finally {
                //Conexion.Close(rs); -> there is no result set when executing an update, no need to close
                Conexion.Close(prep_stmt);
                Conexion.Close(conn);
            }
        }else{
            System.out.println("User repetido loco, no lo guardo :D");
        }

        return user;
    }

    @Override
    public boolean idValido(int id) { // DONE
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        UsuarioDTO usuario = new UsuarioDTO();
        boolean esValido = false;
        if (id > 0) {
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
            } catch (SQLException ex) {
                throw new RuntimeException("Error al validar ID usuario", ex);
            } finally {
                Conexion.Close(rs);
                Conexion.Close(stmt);
                Conexion.Close(conn);
            }
        }

        return esValido;
    }

    @Override
    public boolean usernameValido(String username) { // DONE
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean esValido = true;
        if (username != null || username != "") {
            try {
                conn = Conexion.getConnection();
                stmt = conn.prepareStatement(SQL_SELECT_BY_USERNAME);
                stmt.setString(1, username);
                rs = stmt.executeQuery();
                System.out.println(stmt.toString());
                if (rs.next()){
                   esValido = false;
                }
            } catch (SQLException ex) {
                throw new RuntimeException("Error al validar ID usuario", ex);
            } finally {
                Conexion.Close(rs);
                Conexion.Close(stmt);
                Conexion.Close(conn);
            }
        }

        return esValido;
    }

    public static void main(String[] args) {
//        UsuarioDAOMySQL u = new UsuarioDAOMySQL();
//        System.out.println(u.usernameValido("pia"));
//        System.out.println(u.usernameValido("usuario"));
    }

}
