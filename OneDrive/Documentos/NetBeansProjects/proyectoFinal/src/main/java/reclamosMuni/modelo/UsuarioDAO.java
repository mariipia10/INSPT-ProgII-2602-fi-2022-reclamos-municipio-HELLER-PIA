///*
// * 
// * 
// */
//
//package reclamosMuni.modelo;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.Statement;
//
///**
// *
// * @author piahe
// */
//public class UsuarioDAO {
//    private static final String SQL_SELECT ="SELET * FROM usuario WHERE nombre_usuario=? AND pass=?";
//    
//    public UsuarioDTO login(UsuarioDTO user){
//    
//         Statement stmt = null;    
//	Connection conn=null;
//        PreparedStatement prep_stmt=null;
//     ResultSet rs=null;
//         String usuario = user.getNombre_usuario();    
//         String pass = user.getPass();   
//         System.out.println("Usuuario "+  usuario);
//         System.out.println("Pass + "+pass);
//         
//         try {
//         conn=Conexion.getConnection();
//         prep_stmt=conn.prepareStatement(SQL_SELECT);
//         prep_stmt.setString(1,usuario);
//         prep_stmt.setString(2, pass);
//         rs=prep_stmt.executeQuery();
//         boolean more = rs.next();
//         
//         if (!more) 
//         {
//            System.out.println("Usuario no registrado");
//            user.setValido(false);
//         }  else if (more) 
//         {
//	     	
//            System.out.println("Bienvenido " + usuario);
//            user.setValido(true);
//         }
//         
//         
//         while (rs.next()) {             
//             int id =rs.getInt("id");
//             String descripcion =rs.getString("descripcion");
//             int persona_id =rs.getInt("persona_id");
//             int categoria_id =rs.getInt("categoria_id");
//             String direccion =rs.getString("direccion");
//             System.out.println(id+" "+descripcion+" "+direccion);
//              
//           reclamos.add(new ReclamoDTO(id,descripcion,persona_id,categoria_id,direccion));
//         }
//         
//     } catch (Exception e) {
//         e.printStackTrace(System.out);
//     }finally{
//         Conexion.Close(rs);
//         Conexion.Close(stmt);
//         Conexion.Close(conn);
//                 
//     }
//    }
//}
