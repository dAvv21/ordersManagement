package model;


/**
 * Class that contains data for a order stored in order table
 */
public class Order {

    private int id;
    private int idClient;
    private int idProduct;
    private String productName;
    private String clientName;
    private String clientAddress;
    private int orderSize;

    public Order(String productName, String clientName, String clientAddress, int orderSize) {
        this.productName = productName;
        this.clientName = clientName;
        this.clientAddress = clientAddress;
        this.orderSize = orderSize;
    }

    /**
     * Order constructor with parameters
     * @param idClient foreign key
     * @param idProduct foreign key
     * @param productName product name
     * @param clientName client name
     * @param clientAddress client address
     * @param orderSize order size
     */
    public Order(int idClient, int idProduct, String productName, String clientName, String clientAddress, int orderSize) {
        this.idClient = idClient;
        this.idProduct = idProduct;
        this.productName = productName;
        this.clientName = clientName;
        this.clientAddress = clientAddress;
        this.orderSize = orderSize;
    }

    /**
     * Order constructor with no parameters
     */
    public Order(){

    }

    /**
     * Returns id client that orders a product
     * @return int
     */
    public int getIdClient() {
        return idClient;
    }

    /**
     * Sets id of client that orders a product
     * @param idClient
     */
    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    /**
     * Id of product that is purchased
     * @return int
     */
    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    /**
     * Return id of order
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id of order
     * @param idOrder order
     */
    public void setId(int idOrder) {
        this.id = idOrder;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    /**
     * Returns size of an order
     * @return int
     */
    public int getOrderSize() {
        return orderSize;
    }

    public void setOrderSize(int orderSize) {
        this.orderSize = orderSize;
    }

    /**
     * Method for printing data of order
     * @return String
     */
    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", clientName='" + clientName + '\'' +
                ", clientAddress='" + clientAddress + '\'' +
                ", orderSize=" + orderSize +
                '}';
    }
}
