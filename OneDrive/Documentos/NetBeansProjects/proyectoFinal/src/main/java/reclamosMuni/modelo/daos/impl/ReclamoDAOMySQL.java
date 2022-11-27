/*
 * 
 * 
 */
package reclamosMuni.modelo.daos.impl;

import reclamosMuni.modelo.dtos.ReclamoDTO;
import reclamosMuni.modelo.dtos.UsuarioDTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import reclamosMuni.modelo.Conexion;
import reclamosMuni.modelo.daos.ReclamoDAO;

/**
 *
 * @author piahe
 */
public class ReclamoDAOMySQL implements ReclamoDAO {

    private static final String SQL_SELECT = "SELECT id,descripcion,persona_id,categoria,direccion,fecha_inicio,fecha_fin FROM reclamo";
    private static final String SQL_SELECT_BY_ID = "SELECT id,descripcion,persona_id,categoria,direccion,fecha_inicio,fecha_fin FROM reclamo WHERE persona_id = ?";
    private static final String SQL_SELECT_BY_PERSONA_ID = "SELECT reclamo.id, descripcion, persona_id, categoria, direccion, fecha_inicio, fecha_fin FROM reclamo INNER JOIN persona ON persona.id= reclamo.persona_id WHERE persona.id_usuario=?";
    private static final String SQL_INSERT = "INSERT INTO reclamo(id,descripcion,fecha_inicio,fecha_fin,persona_id,categoria,direccion) VALUES (?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE reclamo SET descripcion=?,fecha_inicio=?,fecha_fin=?,persona_id=?,categoria=?,direccion=?";
    private static final String SQL_DELETE = "DELETE FROM reclamo WHERE id=?";

    //DONE
    @Override
    public List<ReclamoDTO> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<ReclamoDTO> reclamos = new ArrayList<ReclamoDTO>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String descripcion = rs.getString("descripcion");
                int persona_id = rs.getInt("persona_id");
                String categoria = rs.getString("categoria");
                String direccion = rs.getString("direccion");
                Date fecha_inicio = rs.getDate("fecha_inicio");
                Date fecha_fin = rs.getDate("fecha_fin");
                System.out.println(id + " " + descripcion + " " + direccion);
                ReclamoDTO r = new ReclamoDTO(id, descripcion, fecha_inicio, fecha_fin, persona_id, categoria, direccion);
                reclamos.add(r);
            }

        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.Close(rs);
            Conexion.Close(stmt);
            Conexion.Close(conn);

        }

        return reclamos;
    }

    //DONE
    @Override
    public ReclamoDTO buscar(int reclamoID) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ReclamoDTO reclamo = new ReclamoDTO();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, reclamoID);
            rs = stmt.executeQuery();
            rs.next();
            int id = rs.getInt("id");
            String descripcion = rs.getString("descripcion");
            int persona_id = rs.getInt("persona_id");
            String categoria = rs.getString("categoria");
            String direccion = rs.getString("direccion");
            Date fecha_inicio = rs.getDate("fecha_inicio");
            Date fecha_fin = rs.getDate("fecha_fin");
            reclamo.setDescripcion(descripcion);
            reclamo.setPersona_id(persona_id);
            reclamo.setCategoria(categoria);
            reclamo.setDireccion(direccion);
            reclamo.setFecha_inicio(fecha_inicio);
            reclamo.setFecha_fin(fecha_fin);

            System.out.println(id + " " + descripcion + " " + direccion + " " + fecha_inicio);

        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.Close(rs);
            Conexion.Close(stmt);
            Conexion.Close(conn);

        }

        return reclamo;
    }

    //DONE
    @Override
    public int insertar(ReclamoDTO reclamo) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, reclamo.getId());
            rows = stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
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
                Date fecha_inicio = rs.getDate("fecha_inicio");
                Date fecha_fin = rs.getDate("fecha_fin");
                System.out.println(id + " " + descripcion + " " + direccion + "  " + fecha_inicio + "  " + fecha_fin);
                ReclamoDTO r = new ReclamoDTO(id, descripcion, fecha_inicio, fecha_fin, persona_id, categoria, direccion);
                reclamos.add(r);
            }

        } catch (Exception e) {
            e.printStackTrace(System.out);
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
            stmt.setInt(1, reclamo.getId());
            stmt.setString(2, reclamo.getDescripcion());
            stmt.setDate(3, reclamo.getFecha_inicio());
            stmt.setDate(4, reclamo.getFecha_fin());
            stmt.setInt(5, reclamo.getPersona_id());
            stmt.setString(6, reclamo.getCategoria());
            stmt.setString(7, reclamo.getDireccion());

            rows = stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.Close(stmt);
            Conexion.Close(conn);
        }
        return rows;

    }
    @Override
    public int eliminar(ReclamoDTO reclamo) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, reclamo.getId());
            stmt.setString(2, reclamo.getDescripcion());
            stmt.setDate(3, reclamo.getFecha_inicio());
            stmt.setDate(4, reclamo.getFecha_fin());
            stmt.setInt(5, reclamo.getPersona_id());
            stmt.setString(6, reclamo.getCategoria());
            stmt.setString(7, reclamo.getDireccion());

            rows = stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.Close(stmt);
            Conexion.Close(conn);
        }
        return rows;
    }
    
    public static void main(String[] args) {
        ReclamoDAOMySQL reclamo = new ReclamoDAOMySQL();
        //reclamo.listarPorUser(1);
        reclamo.buscar(2);
        //Date n = new Date(1011, 2, 1);
        //System.out.println(n);
    }

   
}
