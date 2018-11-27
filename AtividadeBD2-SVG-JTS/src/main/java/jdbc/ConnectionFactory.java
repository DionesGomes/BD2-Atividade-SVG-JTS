
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
    
    public static  Connection getConnection() throws ClassNotFoundException, SQLException{
       Class.forName("org.postgresql.Driver");
       
       String url = "jdbc:postgres://localhost:5432/BaseIBGE";
       String user = "postgres";
       String password = "falltopieces";
       
       return DriverManager.getConnection(url, user, password);
    
    }
}
