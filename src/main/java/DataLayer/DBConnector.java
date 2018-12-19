package DataLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 The purpose of DBConnector is to...

 @author kasper
 */
public class DBConnector {

    private static final String URL = "jdbc:mysql://104.248.32.211:3306/Carport";
    private static final String USERNAME = "henrik";
    private static final String PASSWORD = "Henrik+01";

    private static Connection singleton;

    public static void setConnection( Connection con ) {
        singleton = con;
    }

    public static Connection connection() throws ClassNotFoundException, SQLException {
        if ( singleton == null ) {
            Class.forName( "com.mysql.cj.jdbc.Driver" );
            singleton = DriverManager.getConnection( URL, USERNAME, PASSWORD );
        }
        return singleton;
    }

}
