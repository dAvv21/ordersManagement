package model;


/**
 * Class that contains data for a product stored in product table
 */
public class Product {
    private int id;
    private String name;
    private int stock;

    /**
     * Product constructor with no parameters
     */
    public Product() {
        this.id = id;
        this.name = name;
        this.stock = stock;
    }

    /**
     * Product constructor with parameters
     * @param name name of the product
     * @param stock stock of the product
     */
    public Product(String name,int stock){
        this.name = name;
        this.stock = stock;
    }

    public Product(int id, String name, int stock) {
        this.id = id;
        this.name = name;
        this.stock = stock;
    }


    /**
     * Method that returns the id of a product
     * @return int
     */
    public int getId() {
        return id;
    }

    /**
     * Method that set the id of a product
     * @param idProduct id to be set
     */
    public void setId(int idProduct) {
        this.id = idProduct;
    }

    /**
     * Method that return the name of a product
     * @return String
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method that return the stock of a product
     * @return int
     */
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * Method for printing data of product
     * @return String
     */
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", stock=" + stock +
                '}';
    }
}
