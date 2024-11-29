/*
 * 
 * 
 */
package reclamoMuni.servicio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import reclamoMuni.exceptions.DNIAlreadyExistsException;
import reclamoMuni.exceptions.EmailAlreadyExistsException;
import static reclamosMuni.modelo.Conexion.getDataSource;
import reclamosMuni.modelo.daos.impl.PersonaDAOMySQL;
import reclamosMuni.modelo.daos.impl.UsuarioDAOMySQL;
import reclamosMuni.modelo.dtos.PersonaDTO;
import reclamosMuni.modelo.dtos.UsuarioDTO;

/**
 *
 * @author piahe
 */
public class RegisterServicio {
    //Arme este servicio para manejar la logica de registrar un nuevo usuario si y solo si los datos son validos
    //Tengo que crear en orden usuario y luego persona
    //Evito tener datos duplicados, vacios o incompletos
    //Tengo que compartitr la conexion en ambas funciones para poder hacer el rollback if needed.
    
    
    private final PersonaDAOMySQL personaSQL = new PersonaDAOMySQL();
    private final UsuarioDAOMySQL userSQL = new UsuarioDAOMySQL();
    private PersonaDTO personaDTO = new PersonaDTO();
    private UsuarioDTO usuarioDTO = new UsuarioDTO();
    
    public boolean registrar(PersonaDTO persona, UsuarioDTO usuario) throws SQLException {
    Connection conn = null;
    boolean b = true;
    try {
        conn = getDataSource().getConnection();
        conn.setAutoCommit(false); // Desactivamos el autocommit para controlar la transacción manualmente
        //usuarioDTO = userSQL.register(usuario.getNombre_usuario(), usuario.getPass(),conn);
        //personaDTO = personaSQL.crearPersona(persona.getNombre(), persona.getApellido(), persona.getDni(), persona.getMail(), persona.getTelefono(), usuarioDTO.getId(),conn);
        // Si todo va bien, commit
        conn.commit();
        System.out.println("Transacción exitosa");
    } catch (DNIAlreadyExistsException | EmailAlreadyExistsException e) {
        System.out.println("Error al registrar: " + e.getMessage());
        if (conn != null) {
            try {
                conn.rollback(); // Si ocurre un error, hacemos rollback
                System.out.println("Rollback realizado debido a excepción personalizada");
            } catch (SQLException rollbackEx) {
                System.out.println("Error al hacer rollback: " + rollbackEx.toString());
            }
        }
        b = false; // Indicamos que ocurrió un error

    } catch (SQLException e) {
        // Si ocurre una excepción SQL, hacemos rollback
        System.out.println("Error SQL: " + e.toString());
        if (conn != null) {
            try {
                conn.rollback();
                System.out.println("Rollback realizado debido a un error SQL");
            } catch (SQLException rollbackEx) {
                System.out.println("Error al hacer rollback: " + rollbackEx.toString());
            }
        }
        b = false; // Indicamos que ocurrió un error

    } catch (Exception e) {
        // Si ocurre una excepción inesperada, hacemos rollback
        System.out.println("Error inesperado: " + e.toString());
        if (conn != null) {
            try {
                conn.rollback();
                System.out.println("Rollback realizado debido a un error inesperado");
            } catch (SQLException rollbackEx) {
                System.out.println("Error al hacer rollback: " + rollbackEx.toString());
            }
        }
        b = false; // Indicamos que ocurrió un error

    } finally {
        // Siempre restaurar autoCommit y cerrar la conexión
        try {
            if (conn != null) {
                conn.setAutoCommit(true);  // Restauramos el auto-commit
                conn.close();  // Cerramos la conexión
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.toString());
        }
    }

    return b;
}
    
    public static void main(String[] args) throws SQLException {
        RegisterServicio p = new RegisterServicio();
        p.registrar(new PersonaDTO(0, "lala", "pop", "popa@gmail.com", "54652655",5,"otra cosa"), new UsuarioDTO("pipipopo", "passcita"));
    }
}
