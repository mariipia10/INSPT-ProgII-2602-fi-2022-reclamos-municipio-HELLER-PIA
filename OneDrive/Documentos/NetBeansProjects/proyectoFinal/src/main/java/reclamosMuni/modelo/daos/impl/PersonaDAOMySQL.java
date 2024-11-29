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
import java.sql.Statement;
import reclamosMuni.modelo.Conexion;
import reclamosMuni.modelo.daos.PersonaDAO;
import reclamosMuni.modelo.dtos.AdministradorDTO;
import reclamosMuni.modelo.dtos.ContribuyenteDTO;
import reclamosMuni.modelo.dtos.PersonaDTO;
import reclamosMuni.modelo.dtos.ReclamoDTO;
import reclamosMuni.modelo.dtos.UsuarioDTO;
import reclamoMuni.exceptions.DNIAlreadyExistsException;
import reclamoMuni.exceptions.EmailAlreadyExistsException;

/**
 *
 * @author piahe
 */
public class PersonaDAOMySQL implements PersonaDAO {

    private final static String SQL_SELECT_BY_ID = "SELECT * FROM persona WHERE id_usuario=?";
    private static final String SQL_INSERT_NEW_PERSONA = "INSERT INTO persona (nombre,apellido,dni,mail,telefono,id_usuario) VALUES (?,?,?,?,?,?)";
    private static final String SQL_INSERT_NEW_EMPTY_PERSONA = "INSERT INTO persona (id_usuario,esta_completa) VALUES (?,?)";
    private final static String SQL_SELECT_BY_DNI = "SELECT * FROM persona WHERE dni=?";
    private final static String SQL_SELECT_BY_MAIL = "SELECT * FROM persona WHERE mail=?";
    private static final String SQL_UPDATE = "UPDATE persona SET nombre=?,apellido=?,dni=?,mail=?,telefono=?,esta_completa=? WHERE id_usuario=?";

    @Override
    public PersonaDTO buscarPersonaPorUserID(UsuarioDTO usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        PersonaDTO persona = null;
        int id;
        String nombre, apellido, dni, mail, telefono;
        boolean esta_completa;
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
                esta_completa = rs.getBoolean("esta_completa");
                if (usuario.getEs_admin()) {
                    persona = new AdministradorDTO(id, nombre, apellido, mail, telefono, usuario.getId(), dni,true);
                } else {
                    persona = new ContribuyenteDTO(id, nombre, apellido, mail, telefono, usuario.getId(), dni,esta_completa);
                }

            }
        } catch (SQLException ex) {
            throw new RuntimeException("Error de SQL ", ex);
        } catch (Exception ex) {
            throw new RuntimeException("Error al crear persona", ex);
        } finally {
            Conexion.Close(rs);
            Conexion.Close(stmt);
            Conexion.Close(conn);

        }
        return persona;
    }

    @Override
    public Boolean dniValido(String dni) { // OK
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        PersonaDTO persona = null;
        Boolean esValido = true;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_DNI);
            stmt.setString(1, dni);
            rs = stmt.executeQuery();
            if (rs.next()) {
                esValido = false;
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Error de SQL ", ex);
        } catch (Exception ex) {
            throw new RuntimeException("Error al validar DNI de la persona", ex);
        } finally {
            Conexion.Close(rs);
            Conexion.Close(stmt);
            Conexion.Close(conn);
        }
        return esValido;
    }

    @Override
    public Boolean mailValido(String mail) { // OK
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        PersonaDTO persona = null;
        Boolean esValido = true;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_MAIL);
            stmt.setString(1, mail);
            rs = stmt.executeQuery();
            if (rs.next()) {
                esValido = false;
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Error de SQL ", ex);
        } catch (Exception ex) {
            throw new RuntimeException("Error al validar mail de la persona", ex);
        } finally {
            Conexion.Close(rs);
            Conexion.Close(stmt);
            Conexion.Close(conn);
        }
        return esValido;
    }

    @Override //WORKS!, rechaza DNI repetidos y mai lrepetido. Admins no se pueden crear asi que solo creo contribuyentes
    public PersonaDTO crearPersona(String nombre, String apellido, String dni, String mail, String telefono, int id) {

        Connection conn = null;
        PreparedStatement prep_stmt = null;
        int rs = 0;
        ContribuyenteDTO contribuyente = null;

        // Validaciones de DNI y Email
        if (!dniValido(dni)) {
            throw new DNIAlreadyExistsException("Ese DNI ya está registrado.");
        }

        if (!mailValido(mail)) {
            throw new EmailAlreadyExistsException("Ese mail ya está registrado.");
        }

        try {

            conn = Conexion.getConnection();
            prep_stmt = conn.prepareStatement(SQL_INSERT_NEW_PERSONA);
            prep_stmt.setString(1, nombre);
            prep_stmt.setString(2, apellido);
            prep_stmt.setString(3, dni);
            prep_stmt.setString(4, mail);
            prep_stmt.setString(5, telefono);
            prep_stmt.setInt(6, id);  // ID del usuario insertado previamente
            System.out.println(prep_stmt);

            rs = prep_stmt.executeUpdate();  // Ejecutamos la inserción

            if (rs > 0) {
                // Si rowsAffected es mayor que 0, el UPDATE fue exitoso
                System.out.println("Persona actualizada con éxito.");
                contribuyente.setNombre(nombre);
                contribuyente.setApellido(apellido);
                contribuyente.setDni(dni);
                contribuyente.setMail(mail);
                contribuyente.setTelefono(telefono);
                contribuyente.setId(id);
            } else {
                // Si no se actualizó ninguna fila, lanza una excepción o maneja el error de alguna manera
                System.out.println("No se creo ninguna persona.");
                throw new RuntimeException("Error: No se pudo crear la persona.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            throw new RuntimeException("Error de SQL", ex);
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            throw new RuntimeException("Error al registrar persona", ex);
        } finally {
            Conexion.Close(prep_stmt);
        }

        return contribuyente;
    }

    @Override
    public PersonaDTO crearPersonaVacia(int id) {

        Connection conn = null;
        PreparedStatement prep_stmt = null;
        int rs = 0;
        //ContribuyenteDTO contribuyente = (ContribuyenteDTO) new PersonaDTO();
        PersonaDTO persona = new ContribuyenteDTO();
        System.out.println("entre antes del try?");
        try {
            System.out.println("entre al try?");
            conn = Conexion.getConnection();
            prep_stmt = conn.prepareStatement(SQL_INSERT_NEW_EMPTY_PERSONA);
            prep_stmt.setInt(1, id);
            prep_stmt.setInt(2, 0);
            System.out.println(prep_stmt);

            rs = prep_stmt.executeUpdate();  // Ejecutamos la inserción
            if (rs > 0) {
                System.out.println("entre al if?");
                // Si rowsAffected es mayor que 0, el UPDATE fue exitoso
                System.out.println("Persona vacia creada con éxito.");
                //TO DO; no se que pasa que registra y no da error jelp. estoy tratando de encapsular las personas nuevas creadas como contribuyentes para a la hora de hacer un request en SQL traiga la query que coresponde
                //contribuyente.setId(id);
                persona.setId(id);
            } else {
                System.out.println("etre al else");
                // Si no se actualizó ninguna fila, lanza una excepción o maneja el error de alguna manera
                System.out.println("No se creo ninguna persona.");
                throw new RuntimeException("Error: No se pudo crear la persona.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            throw new RuntimeException("Error de SQL", ex);
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            throw new RuntimeException("Error al registrar persona", ex);
        } finally {
            Conexion.Close(prep_stmt);
        }

        return persona; //contribuyente;
    }

    @Override
    public PersonaDTO actualizarPersona(String nombre, String apellido, String dni, String mail, String telefono, int ID) {

        Connection conn = null;
        PreparedStatement prep_stmt = null;
        int rs = 0;
        PersonaDTO persona = new ContribuyenteDTO();
        System.out.println("chalala actualizar persona dto");

        // Validaciones de DNI y Email
        if (!dniValido(dni)) {
            throw new DNIAlreadyExistsException("Ese DNI ya está registrado.");
        }

        if (!mailValido(mail)) {
            throw new EmailAlreadyExistsException("Ese mail ya está registrado.");
        }

        try {
        System.out.println("chalala actualizar persona dtoadentro del try");

            conn = Conexion.getConnection();
            prep_stmt = conn.prepareStatement(SQL_UPDATE);
            prep_stmt.setString(1, nombre);
            prep_stmt.setString(2, apellido);
            prep_stmt.setString(3, dni);
            prep_stmt.setString(4, mail);
            prep_stmt.setString(5, telefono);
            prep_stmt.setInt(6, 1); //esta completa
            prep_stmt.setInt(7, ID);  // ID del usuario insertado previamente
            System.out.println(prep_stmt);

            rs = prep_stmt.executeUpdate();  // Ejecutamos la inserción

            if (rs > 0) {
                // Si rowsAffected es mayor que 0, el UPDATE fue exitoso
                System.out.println("Persona actualizada con éxito.");
                persona.setNombre(nombre);
                persona.setApellido(apellido);
                persona.setDni(dni);
                persona.setMail(mail);
                persona.setTelefono(telefono);
                persona.setId(ID);
                persona.setEstaCompleta(true);
            } else {
                // Si no se actualizó ninguna fila, lanza una excepción o maneja el error de alguna manera
                System.out.println("No se actualizó ninguna persona.");
                throw new RuntimeException("Error: No se pudo actualizar la persona.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            throw new RuntimeException("Error de SQL", ex);
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            throw new RuntimeException("Error al registrar persona", ex);
        } finally {
            Conexion.Close(prep_stmt);
        }

        return persona;
    }

    public static void main(String[] args) {
        PersonaDAOMySQL p = new PersonaDAOMySQL();
        Boolean b = p.dniValido("42444333");
        //PersonaDTO pipi = p.crearPersona("juana", "banana", "4244433", "LAL@GMAIL.COM", "11553322", 12);
        //PersonaDTO pepe = p.crearPersonaVacia(3);
        PersonaDTO pope = p.actualizarPersona("pan", "chita", "7898", "oo", "4423", 8);
        System.out.println(p);
    }

}
