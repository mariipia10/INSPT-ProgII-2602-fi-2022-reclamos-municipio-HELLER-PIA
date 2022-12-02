/*
 * 
 * 
 */
package reclamosMuni.modelo.daos.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import reclamosMuni.modelo.Conexion;
import reclamosMuni.modelo.daos.PersonaDAO;
import reclamosMuni.modelo.dtos.AdministradorDTO;
import reclamosMuni.modelo.dtos.ContribuyenteDTO;
import reclamosMuni.modelo.dtos.PersonaDTO;
import reclamosMuni.modelo.dtos.ReclamoDTO;
import reclamosMuni.modelo.dtos.UsuarioDTO;

/**
 *
 * @author piahe
 */
public class PersonaDAOMySQL implements PersonaDAO {

    private final static String SQL_SELECT_BY_ID = "SELECT * FROM persona WHERE id_usuario=?";

    @Override
    public PersonaDTO crearPersona(UsuarioDTO usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        PersonaDTO persona = null;
        int id;
        String nombre, apellido, dni, mail, telefono;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, usuario.getId());
            rs = stmt.executeQuery();
            if (rs.next()) {
                id = rs.getInt("id");
                nombre = rs.getString("nombre");
                apellido = rs.getString("apellido");
                dni = rs.getString("dni");
                mail = rs.getString("mail");
                telefono = rs.getString("telefono");
                if(usuario.getEs_admin()){
                    persona = new AdministradorDTO(id, nombre, apellido, mail, telefono, usuario.getId(), dni);
                }else{
                    persona = new ContribuyenteDTO(id, nombre, apellido, mail, telefono, usuario.getId(), dni);
                }
            }

        }catch (SQLException ex) {
            throw new RuntimeException("Error al crear persona", ex);
        } finally {
            Conexion.Close(rs);
            Conexion.Close(stmt);
            Conexion.Close(conn);

        }
        return persona;
    }

}
