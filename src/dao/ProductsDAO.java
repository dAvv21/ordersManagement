package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import model.Product;

/**
 * Class for Products in order to create and update OrdersTable
 */
public class ProductsDAO extends AbstractDAO<Product> {

    /**
     *ProductsDAO constructor
     */
    public ProductsDAO(){
        super();
    }

    /**
     * Method for creating query for insert statement in product table
     * @return StringBuilder
     */
    public String createInsertQuery(){
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO ");
        sb.append("product ");
        sb.append("(name,stock) ");
        sb.append("VALUES (?,?)");
        return sb.toString();
    }

    /**
     * Method for creating query for update statement in product table
     * @return StringBuilder
     */
    public String createUpdateQuery(){
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE ");
        sb.append("product ");
        sb.append("SET name=?, stock=? WHERE id=?");
        return sb.toString();
    }


    /**
     * Method that set the values for the insert statement in order table
     * @param insertStatement statement for insert product
     * @param product product to be inserted
     */
    public void insertValues(PreparedStatement insertStatement,Product product) {

        try {
            insertStatement.setString(1, product.getName());
            insertStatement.setInt(2, product.getStock());

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ProductDAO:insert " + e.getMessage());
        }
    }


    /**
     * Method that set the values for the update statement in order table
     * @param updateStatement update statement
     * @param product product to be updated
     */
    public void updateValues(PreparedStatement updateStatement,Product product) {

        try {

            updateStatement.setString(1, product.getName());
            updateStatement.setInt(2, product.getStock());
            updateStatement.setInt(3, product.getId());

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ProductDAO:update " + e.getMessage());
        }
    }

}
