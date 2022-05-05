package bll;

import bll.validators.OrderSizeValidator;
import bll.validators.Validators;
import dao.OrderDAO;
import java.io.BufferedWriter;
import java.io.FileWriter;
import model.Order;
import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * In this class are made the calls for the query methods for the Order table.
 */

public class OrderBLL {

    private List<Validators<Order>> validators;
    private OrderDAO orderDAO;


    /**
     * Constructor without parameters
     */
    public OrderBLL(){
        validators = new ArrayList<>();
        validators.add(new OrderSizeValidator());
        orderDAO = new OrderDAO();
    }

    /**
     * This method calls the insert method in OrderDAO and the method from the above for creating orders table displayed view
     * @param ordersList list of orders
     * @return JTable
     */
    public JTable createOrderTable(List<Order> ordersList){
        return orderDAO.createTable(ordersList);
    }

    /**
     * Method for validate and insert an order
     * @param order order to be inserted
     * @return int
     */
    public int insertOrder(Order order) {
        for (Validators i : validators) {
            i.validate(order);
        }
        return orderDAO.insert(order);
    }

    /**
     * Method for validate and editing an order
     * @param order order to be edited
     * @return int
     */
    public int editOrder(Order order) {
        for (Validators i : validators) {
            i.validate(order);
        }

        return orderDAO.update(order);
    }

    /**
     * Method that delete an order
     * @param id id for order that will be deleted
     * @return int
     */
    public int deleteOrderById(int id) {
        int idDeleted = orderDAO.delete(id);
        return idDeleted;
    }

    /**
     * This method calls the insert method in OrderDAO and the method from the above for finding all orders into the database
     * @return list
     */
    public List<Order> findAllOrders() {
        List<Order> list = orderDAO.findAll();
        if (list.size() == 0) {
            throw new NoSuchElementException("Orders were not found!");
        }
        return list;
    }


    /**
     * Generates a bill (.txt) that contains all the orders inserted in the table.
     * @param order
     * @throws IOException
     */
    private static void generateBill(Order order) throws IOException {

        BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Giussepe\\Desktop\\TP\\ordersManagement\\output.txt"));
        bw.write("Client " + order.getClientName() + " a comandat " + order.getOrderSize() + " " + order.getProductName() + "la adresa " + order.getClientAddress());
        bw.close();
    }

}
