/*
 * 
 * 
 */
package reclamosMuni.modelo.daos.impl;

import reclamosMuni.modelo.dtos.ReclamoDTO;
import reclamosMuni.modelo.dtos.UsuarioDTO;
import reclamosMuni.modelo.dtos.PersonaDTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import reclamosMuni.modelo.Conexion;
import reclamosMuni.modelo.daos.ReclamoDAO;
import reclamosMuni.modelo.dtos.*;

/**
 *
 * @author piahe
 */
public class ReclamoDAOMySQL implements ReclamoDAO {

    private static final String SQL_SELECT = "SELECT id,descripcion,persona_id,categoria,direccion,fecha_inicio,fecha_fin FROM reclamo";
    private static final String SQL_SELECT_BY_ID = "SELECT id,descripcion,persona_id,categoria,direccion,fecha_inicio,fecha_fin FROM reclamo WHERE id = ?";
    private static final String SQL_SELECT_BY_PERSONA_ID = "SELECT reclamo.id, descripcion, persona_id, categoria, direccion, fecha_inicio, fecha_fin FROM reclamo INNER JOIN persona ON persona.id= reclamo.persona_id WHERE persona.id_usuario=?";
    private static final String SQL_INSERT = "INSERT INTO reclamo(descripcion,fecha_inicio,fecha_fin,persona_id,categoria,direccion) VALUES (?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE reclamo SET descripcion=?,fecha_inicio=?,fecha_fin=?,persona_id=?,categoria=?,direccion=? WHERE id =?";
    private static final String SQL_DELETE = "DELETE FROM reclamo WHERE id=?";
    private static final String SQL_SOLVED = "UPDATE reclamo SET fecha_fin=?WHERE id =?";
    //DONE
    @Override
    public List<ReclamoDTO> listar(PersonaDTO persona) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<ReclamoDTO> reclamos = new ArrayList<ReclamoDTO>();
        LocalDate fecha_inicio, fecha_fin;
        Date f_in, f_fin;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(persona.getReclamosSQL());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String descripcion = rs.getString("descripcion");
                int persona_id = rs.getInt("persona_id");
                String categoria = rs.getString("categoria");
                String direccion = rs.getString("direccion");
                f_in = rs.getDate("fecha_inicio"); //getDate devuelve null si asi esta en la DB, tengo que manejarlo
                f_fin = rs.getDate("fecha_fin");
                fecha_inicio = (f_in == null) ? null : f_in.toLocalDate();  //si no es null lo convierto a localDate
                fecha_fin = (f_fin == null) ? null : f_fin.toLocalDate();
                System.out.println(id + " " + descripcion + " " + direccion + " " + fecha_fin);
                ReclamoDTO r = new ReclamoDTO(id, descripcion, fecha_inicio, fecha_fin, persona_id, categoria, direccion);
                reclamos.add(r);
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Error de SQL ", ex);
        } catch (Exception ex) {
            throw new RuntimeException("Error al buscar la lista de reclamos", ex);
        } finally {
            Conexion.Close(rs);
            Conexion.Close(stmt);
            Conexion.Close(conn);

        }

        return reclamos;
    }

    //DONE
    @Override
    public ReclamoDTO buscarPorId(int reclamoID) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ReclamoDTO reclamo;
        Date aux;
        LocalDate fecha_fin;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, reclamoID);
            System.out.println(stmt);
            rs = stmt.executeQuery();
            rs.next();
            int id = rs.getInt("id");
            String descripcion = rs.getString("descripcion");
            int persona_id = rs.getInt("persona_id");
            String categoria = rs.getString("categoria");
            String direccion = rs.getString("direccion");
            LocalDate fecha_inicio = rs.getDate("fecha_inicio").toLocalDate();
            aux = rs.getDate("fecha_fin");
            if (aux != null) {
                fecha_fin = aux.toLocalDate();
                reclamo = new ReclamoDTO(id, descripcion, fecha_inicio, fecha_fin, persona_id, categoria, direccion);
            } else {
                reclamo = new ReclamoDTO(id, descripcion, fecha_inicio, persona_id, categoria, direccion);

            }

            System.out.println(id + " " + descripcion + " " + direccion + " " + fecha_inicio);

        } catch (SQLException ex) {
            throw new RuntimeException("Error de SQL ", ex);
        } catch (Exception ex) {
            throw new RuntimeException("Error al buscar reclamo", ex);
        } finally {
            Conexion.Close(rs);
            Conexion.Close(stmt);
            Conexion.Close(conn);

        }

        return reclamo;
    }

    //NOT DONE
    @Override
    public int insertar(ReclamoDTO reclamo) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, reclamo.getDescripcion());
            stmt.setObject(2, reclamo.getFecha_inicio());
            stmt.setObject(3, reclamo.getFecha_fin());
            stmt.setInt(4, reclamo.getPersona_id());
            stmt.setString(5, reclamo.getCategoria());
            stmt.setString(6, reclamo.getDireccion());
            //"INSERT INTO reclamo(descripcion,fecha_inicio,fecha_fin,persona_id,categoria,direccion) VALUES (?,?,?,?,?,?,?)"
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Error de SQL ", ex);
        } catch (Exception ex) {
            throw new RuntimeException("Error al insertar reclamo", ex);
        } finally {
            Conexion.Close(stmt);
            Conexion.Close(conn);
        }
        return rows;
    }

    //DONE
    @Override
    public List<ReclamoDTO> listarPorUser(UsuarioDTO user) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<ReclamoDTO> reclamos = new ArrayList<ReclamoDTO>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_PERSONA_ID);
            stmt.setInt(1, user.getId());
            rs = stmt.executeQuery();
            int aux = user.getId();
            System.out.println("userid->" + aux);
            while (rs.next()) {
                int id = rs.getInt("id");
                String descripcion = rs.getString("descripcion");
                int persona_id = rs.getInt("persona_id");
                String categoria = rs.getString("categoria");
                String direccion = rs.getString("direccion");
                LocalDate fecha_inicio = rs.getDate("fecha_inicio").toLocalDate();
                LocalDate fecha_fin = rs.getDate("fecha_fin").toLocalDate();
                System.out.println(id + " " + descripcion + " " + direccion + "  " + fecha_inicio + "  " + fecha_fin);
                ReclamoDTO r = new ReclamoDTO(id, descripcion, fecha_inicio, fecha_fin, persona_id, categoria, direccion);
                reclamos.add(r);
            }

        } catch (SQLException ex) {
            throw new RuntimeException("Error de SQL ", ex);
        } catch (Exception ex) {
            throw new RuntimeException("Error al listar reclamos segun user", ex);
        } finally {
            Conexion.Close(rs);
            Conexion.Close(stmt);
            Conexion.Close(conn);
        }
        return reclamos;
    }

    //DONE
    @Override
    public int actualizar(ReclamoDTO reclamo) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, reclamo.getDescripcion());
            stmt.setObject(2, reclamo.getFecha_inicio());
            stmt.setObject(3, reclamo.getFecha_fin());
            stmt.setInt(4, reclamo.getPersona_id());
            stmt.setString(5, reclamo.getCategoria());
            stmt.setString(6, reclamo.getDireccion());
            stmt.setInt(7, reclamo.getId());
            System.out.println(stmt);
            System.out.println(stmt.toString());
            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException("Error de SQL ", ex);
        } catch (Exception ex) {
            throw new RuntimeException("Error al actualizar reclamo", ex);
        } finally {
            Conexion.Close(stmt);
            Conexion.Close(conn);
        }
        return rows;

    }
    
    @Override
    public int resolver(int reclamoID) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SOLVED);
            LocalDate LD = LocalDate.now();
                        stmt.setObject(1, LD);

            stmt.setInt(2, reclamoID);
            System.out.println("HOLAAAAAAAAAAAs");
            System.out.println(stmt);
            System.out.println(stmt.toString());
            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException("Error de SQL ", ex);
        } catch (Exception ex) {
            throw new RuntimeException("Error al actualizar reclamo", ex);
        } finally {
            Conexion.Close(stmt);
            Conexion.Close(conn);
        }
        return rows;

    }

    @Override
    public int eliminar(int reclamoID) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, reclamoID);
            

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Error de SQL ", ex);
        } catch (Exception ex) {
            throw new RuntimeException("Error al eliminar reclamo", ex);
        } finally {
            Conexion.Close(stmt);
            Conexion.Close(conn);
        }
        return rows;
    }

    //TEST
    public static void main(String[] args) {
        PersonaDTO p;
        p = new ContribuyenteDTO(1, "Maria", "Maria", "sasa", "ss", 2, "123");
        ReclamoDAOMySQL reclamo = new ReclamoDAOMySQL();
        ReclamoDTO reclamin = new ReclamoDTO("palala", LocalDate.now(), LocalDate.now(), 1, "alumbrado", "casasa");
        //reclamo.insertar(reclamin);
        //reclamo.listarPorUser(1);
       reclamo.eliminar(4);
        //Date n = new Date(1011, 2, 1);
        //System.out.println(n);
    }

}
