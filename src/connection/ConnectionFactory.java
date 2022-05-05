package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

/**
 * Class that creates connection with a database
 */
public class ConnectionFactory {
    private static final Logger LOGGER =Logger.getLogger(ConnectionFactory.class.getName());
    private static final String DRIVER ="com.mysql.cj.jdbc.Driver";
    private static final String DBURL ="jdbc:mysql://localhost:3306/";
    private static final String DBNAME = "ordersmanagement?autoReconnect=true&useSSL=false";
    private static final String USER ="root";
    private static final String PASS ="Salceadavid21";


    private static ConnectionFactory singleInstance = new ConnectionFactory();

    /**
     * ConnectionFactory constructor
     */
    private ConnectionFactory() {
        try {
            Class.forName(DRIVER);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    /**
     * Method that create connection with database
     * @return Connection
     */
    private Connection createConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DBURL + DBNAME, USER, PASS);
        } catch (SQLException e) {
            System.out.println("An error occurred while trying to connect to the database");
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * Method that creates a instance of connection with database
     * @return singleInstance
     */
    public static Connection getConnection() {
        return singleInstance.createConnection();
    }

    /**
     * Method that closes connection with database
     * @param connection connection with db
     */
    public static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("An error occurred while trying to connect to the database");
                e.printStackTrace();
            }
        }
    }

    /**
     * Method for closing a statement
     * @param statement statement to be closed
     */
    public static void close(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Error while trying to close the statement.");
                e.printStackTrace();
            }
        }
    }

    /**
     * Method that clases a resultSet
     * @param resultSet resultSet to be close
     */
    public static void close(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                System.out.println("An error occurred while trying to close the ResultSet");
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ConnectionFactory db = new ConnectionFactory();
        try{
            Connection connection = db.createConnection();
            System.out.println("DB successfully connected!");
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("ER while connecting DB!");
        }
    }
}
