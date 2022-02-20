import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MyConnector  {

        private static Connection connection;
        private static final String connectionString = "jdbc:mysql://localhost:3306/";

        private MyConnector() {}

        private static void createConnection( String dbName) throws SQLException {

            Properties properties = new Properties();
            properties.setProperty("user", "root");
            properties.setProperty("password", "*****");

            connection = DriverManager.getConnection(connectionString + dbName, properties);
        }


        public static Connection getConnection() throws SQLException {
            if (connection == null) {
                createConnection("minions_db");
            }
            return connection;
        }


}
