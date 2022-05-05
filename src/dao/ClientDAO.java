package dao;


import model.Client;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;

/**
 * Class for Clients in order to create and update ClientsTable
 */
public class ClientDAO extends AbstractDAO<Client> {

    /**
     * ClientDAO constructor
     */
    public ClientDAO() {
        super();
    }

    /**
     * Method for creating query for insert statement in client table
     * @return StringBuilder
     */
    public String createInsertQuery() {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO ");
        sb.append("client ");
        sb.append("(name,address,email) ");
        sb.append("VALUES (?,?,?)");
        return sb.toString();
    }

    /**
     * Method for creating query for update statement in client table
     * @return StringBuilder
     */
    public String createUpdateQuery() {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE ");
        sb.append("client ");
        sb.append("SET name=?, address=?, email=? WHERE id=?");
        return sb.toString();
    }

    /**
     * Method that set the values for the insert statement in client table
     * @param insertStatement statement to be inserted
     * @param client Client to be inserted
     */
    public void insertValues(PreparedStatement insertStatement, Client client) {

        try {
            insertStatement.setString(1, client.getName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            insertStatement.setString(2, client.getAddress());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            insertStatement.setString(3, client.getEmail());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * Method that set the values for the update statement in Client table
     * @param updateStatement statement to be updated
     * @param client client to be updated
     */
    public void updateValues(PreparedStatement updateStatement, Client client) {

        try {
            updateStatement.setString(1, client.getName());
            updateStatement.setString(2, client.getAddress());
            updateStatement.setString(3, client.getEmail());
            updateStatement.setInt(4, client.getId());

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ClientDAO:update " + e.getMessage());
        }
    }


}
