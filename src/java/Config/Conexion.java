package Config;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.sql.DriverManager;

/**
 *
 * @author Andres Ramirez
 */
public class Conexion {
    Connection con;
    String bd = "proyecto_crud";
    String url = "jdbc:mysql://localhost:3306/" + bd + "?useUnicode=true&use" + "JDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&" + "serverTimezone=UTC";
    String usuario = "root";
    String pwd = "";
    String driver = "com.mysql.cj.jdbc.Driver";
    
    public Connection ConectarBaseDeDatos(){
        try{
            Class.forName(driver);
            con = (Connection) DriverManager.getConnection(url, usuario, pwd);
            System.out.println("Conexion establecida con exito con la base de datos: " + bd);
            
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println("No se logro establecer comunicacion con la base de datos: " + bd);
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
}
