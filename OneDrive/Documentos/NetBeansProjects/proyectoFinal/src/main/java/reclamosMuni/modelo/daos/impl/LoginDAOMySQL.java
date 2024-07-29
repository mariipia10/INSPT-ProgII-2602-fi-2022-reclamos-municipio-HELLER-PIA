/*
 * 
 * 
 */
package reclamosMuni.modelo.daos.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import java.sql.SQLException;
import reclamosMuni.modelo.Conexion;
import reclamosMuni.modelo.dtos.ReclamoDTO;
import reclamosMuni.modelo.daos.LoginDAO;
import reclamosMuni.modelo.dtos.LoginDTO;

/**
 *
 * @author piahe
 */
public class LoginDAOMySQL implements LoginDAO {

    private final static String SQL_INSERT = "INSERT INTO login (id,dia,hora) VALUES (?,?,?)";
    private final static String SQL_SELECT = "SELECT * FROM reclamo.login";
    private final static String SQL_SELECT_BY_ID = "SELECT * FROM reclamo.login WHERE id=? ORDER BY dia DESC";

    public LocalDate convertToLocalDateViaSqlDate(Date dateToConvert) {
        return new java.sql.Date(dateToConvert.getTime()).toLocalDate();
    }

    @Override
    public List<LoginDTO> obtenerLogins() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<LoginDTO> logins = new ArrayList<LoginDTO>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                LocalDate dia = convertToLocalDateViaSqlDate(rs.getDate("dia"));
                LocalTime hora = rs.getTime("hora").toLocalTime();
                LoginDTO l = new LoginDTO(id, dia, hora);
                System.out.println(id + " " + dia + " " + hora);
                logins.add(l);
            }

        } catch (SQLException ex) {
            throw new RuntimeException("Error al obtener logins", ex);
        } finally {
            Conexion.Close(rs);
            Conexion.Close(stmt);
            Conexion.Close(conn);

        }
        return logins;
    }

    @Override
    public void cargarLogin(LoginDTO login) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, login.getId());
            stmt.setObject(2, login.getDia());
            stmt.setObject(3, login.getHora());
            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException("Error al cargar login", ex);
        } finally {
            Conexion.Close(stmt);
            Conexion.Close(conn);
        }
        //return rows;
    }

    @Override
    public List<LoginDTO> obtenerLoginsPorID(int idUser) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<LoginDTO> logins = new ArrayList<LoginDTO>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, idUser);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                LocalDate dia = rs.getDate("dia").toLocalDate();
                LocalTime hora = rs.getTime("hora").toLocalTime();
                LoginDTO l = new LoginDTO(id, dia, hora);
                System.out.println(id + " " + dia + " " + hora);
                logins.add(l);
            }

        }catch (SQLException ex) {
            throw new RuntimeException("Error al obtener login x ID", ex);
        } finally {
            Conexion.Close(rs);
            Conexion.Close(stmt);
            Conexion.Close(conn);

        }
        return logins;
    }

    public static void main(String[] args) {

    }
}
