package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import model.Order;


/**
 * Class for Orders in order to create and update OrdersTable
 */
public class OrderDAO extends AbstractDAO<Order> {
    /**
     * OrderDAO constructor
     */
    public OrderDAO(){
        super();
    }

    /**
     * Method for creating query for insert statement in order table
     * @return StringBuilder
     */
    public String createInsertQuery() {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO ");
        sb.append("`order` ");
        sb.append("(idClient,idProduct,clientName,clientAddress,productName,orderSize) ");
        sb.append("VALUES (?,?,?,?,?,?)");
        return sb.toString();
    }

    /**
     * Method for creating query for update statement in order table
     * @return StringBuilder
     */
    public String createUpdateQuery() {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE ");
        sb.append("`order` ");
        sb.append("SET idClient=?, idProduct=?, clientName=?, productName=?, clientAddress=?, orderSize=? WHERE id=?");
        return sb.toString();
    }

    /**
     * Method that set the values for the insert statement in order table
     * @param insertStatement statement for insert order
     * @param order order to be inserted
     */
    public void insertValues(PreparedStatement insertStatement, Order order) {

        try {
            insertStatement.setInt(1, order.getIdClient());
            insertStatement.setInt(2, order.getIdProduct());
            insertStatement.setString(3, order.getClientName());
            insertStatement.setString(4, order.getClientAddress());
            insertStatement.setString(5, order.getProductName());
            insertStatement.setInt(6, order.getOrderSize());

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "OrderDAO:insert " + e.getMessage());
        }
    }

    /**
     * Method that set the values for the update statement in order table
     * @param updateStatement statement for update
     * @param order order to be updated
     */
    public void updateValues(PreparedStatement updateStatement, Order order) {

        try {
            updateStatement.setInt(1, order.getIdClient());
            updateStatement.setInt(2,order.getIdProduct());
            updateStatement.setString(3, order.getClientName());
            updateStatement.setString(4, order.getProductName());
            updateStatement.setString(5, order.getClientAddress());
            updateStatement.setInt(6, order.getOrderSize());
            updateStatement.setInt(7, order.getId());


        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "OrderDAO:update " + e.getMessage());
        }
    }
}
