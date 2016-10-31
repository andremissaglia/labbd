package labbd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConnection {
    private final static String CONNECTION_STRING = "jdbc:oracle:thin:@grad.icmc.usp.br:15215:orcl";
    private final static String USER = "a8066523";
    private final static String PASS = "1234567890";
    
    private static OracleConnection con;
    private Connection connection;
    
    
    private OracleConnection(){
        
    }
    private static OracleConnection obj(){
        if(con == null){
            con = new OracleConnection();
        }
        return con;
    }
    public static void connect() throws ClassNotFoundException, SQLException{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        System.out.println("[ORACLE] Connecting");
        obj().connection = DriverManager.getConnection(CONNECTION_STRING, USER,PASS);
        System.out.println("[ORACLE] Connected");
    }
    public static Connection connection(){
        return obj().connection;
    }
    public static void close() throws SQLException{
        obj().connection.close();
    }

}
