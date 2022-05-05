package dao;

import connection.ConnectionFactory;
import model.Product;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class uses reflexion for sql query
 */
public class AbstractDAO<T> {
    protected static final Logger LOGGER = Logger.getLogger(AbstractDAO.class.getName());

    private final Class<T> type;

    @SuppressWarnings("unchecked")
    public AbstractDAO() {
        this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    /**
     * Method that creates a select query
     * @param field field for query
     * @return StringBuilder
     */
    private String createSelectQuery(String field) {  //generam query pt SELECT
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append("* ");
        sb.append("FROM ");
        sb.append("`" + type.getSimpleName() + "`");
        sb.append(" WHERE " + field + " =?");
        return sb.toString();
    }

    /**
     * Method that creates a find all query
     * @return StringBuilder
     */
    private String createFindAllQuery() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append("* ");
        sb.append("FROM ");
        sb.append("`" + type.getSimpleName() + "`"); //order e cuv cheie
        return sb.toString();
    }

    /**
     * Method that creates delete query
     * @param field field for query
     * @return StringBuilder
     */
    private String createDeleteQuery(String field) {
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE ");
        sb.append("FROM ");
        sb.append(type.getSimpleName());
        sb.append(" WHERE " + field + " =?");
        return sb.toString();
    }


    /**
     * Methods will be overwrited in ClientDAO, ProductDAO, OrderDAO
     * @return null
     */
    public String createInsertQuery() {
        return null;
    }
    /**
     * Methods will be overwrited in ClientDAO, ProductDAO, OrderDAO
     * @return null
     */
    public String createUpdateQuery() {
        return null;
    }

    /**
     * Methods will be overwrited in ClientDAO, ProductDAO, OrderDAO
     * @return null
     */
    public void insertValues(PreparedStatement statement, T t) {}

    /**
     * Methods will be overwrited in ClientDAO, ProductDAO, OrderDAO
     * @return null
     */
    public void updateValues(PreparedStatement statement, T t) {}

    /**
     * Method that use reflection to create java object from a resultSet
     * @param resultSet ResultSet
     * @return List<T>
     */
    List<T> createObjects(ResultSet resultSet) {
        List<T> list = new ArrayList<T>();
        Constructor[] ctors = type.getDeclaredConstructors();
        Constructor ctor = null;
        for (int i = 0; i < ctors.length; i++) {
            ctor = ctors[i];
            if (ctor.getGenericParameterTypes().length == 0)
                break;
        }
        try {
            while (resultSet.next()) {
                assert ctor != null;
                ctor.setAccessible(true);
                T instance = (T) ctor.newInstance();
                for (Field field : type.getDeclaredFields()) {
                    String fieldName = field.getName();
                    Object value = resultSet.getObject(fieldName);
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, type);
                    Method method = propertyDescriptor.getWriteMethod();
                    method.invoke(instance, value);
                }
                list.add(instance);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * Method that execute an insert query
     * @param t inserted Object
     * @return int
     */
    public int insert(T t) {
        Connection dbConnection = ConnectionFactory.getConnection();

        PreparedStatement insertStatement = null;
        int insertedId = -1;
        ResultSet rs = null;
        try {

            insertStatement = dbConnection.prepareStatement(createInsertQuery(), Statement.RETURN_GENERATED_KEYS);
            insertValues(insertStatement,t);
            insertStatement.executeUpdate();

            rs = insertStatement.getGeneratedKeys();
            if (rs.next()) {
                insertedId = rs.getInt(1);
            }
            return insertedId;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "AbstractDAO:insert " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(dbConnection);
        }
        return -1;
    }


    /**
     * Method that execute an update query
     * @param t updated Object
     * @return int
     */
    public int update(T t) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createUpdateQuery();
        int updatedId = -1;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            updateValues(statement, t);
            statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                updatedId = rs.getInt(1);
            }

            return updatedId;

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:update " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return -1;
    }

    /**
     * Method that execute an delete query
     * @param id id of Object
     * @return int
     */
    public int delete(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        //ResultSet resultSet = null;

        String query = createDeleteQuery("id");
        int deletedId = -1;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
            statement.execute();
            //resultSet = statement.getGeneratedKeys();
            return deletedId;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:delete " + e.getMessage());
        } finally {
            //ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return -1;
    }

    /**
     * Method that find all rows in a table
     * @return List<T>
     */
    public List<T> findAll() {   //echivalent la SELECT*
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createFindAllQuery();
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            return createObjects(resultSet);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findAll " + throwables.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }


    /**
     * Method that find an object by Id
     * @param id id of Object
     * @return null
     */
    public T findById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectQuery("id");
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            return createObjects(resultSet).get(0);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    /**
     * Method that creates a Jtable of Objects
     * @param list
     * @return Jtable
     */
    public JTable createTable(List<T> list) {
        ArrayList<String> columnNames = new ArrayList<String>();
        int noFields = 0;
        for (Field i : list.get(0).getClass().getDeclaredFields()) {
            i.setAccessible(true);
            columnNames.add(i.getName());
            noFields++;
        }
        Object[][] data = new Object[list.size()][noFields];
        for (int i = 0; i < list.size(); i++) {
            int j = 0;
            for (Field field : list.get(i).getClass().getDeclaredFields()) {
                try {
                    field.setAccessible(true);
                    data[i][j] = field.get(list.get(i));
                    j++;
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        DefaultTableModel tmodel = new DefaultTableModel(data, columnNames.toArray());
        JTable table = new JTable(tmodel);
        table.getTableHeader();
        System.out.println(table.getTableHeader());
        return table;
    }

}
