package bll;

import bll.validators.StockValidator;
import bll.validators.Validators;
import dao.ProductsDAO;
import model.Product;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


/**
 * In this class are made the calls for the query methods for the Products table.
 */
public class ProductBLL {
    private List<Validators<Product>> validators;
    private ProductsDAO productsDAO;

    /**
     * ProductBLL no param constructor
     */
    public ProductBLL() {
        validators = new ArrayList<Validators<Product>>();
        validators.add(new StockValidator());
        productsDAO = new ProductsDAO();
    }

    /**
     *      * This method calls the insert method in ProductDAO and the method from the above for creating products table displayed view
     * @param productList list of products
     * @return Jtable
     */
    public JTable createTableProduct(List<Product> productList){
        return productsDAO.createTable(productList);
    }


    /**
     *This method calls the insert method in ProductDAO for finding a product by id into the database
     * @param id if of product that will be searched
     * @return Product
     */
    public Product findProductById(int id){
        Product product = productsDAO.findById(id);
        if(product == null){
            throw new NoSuchElementException("The product with id =\" + id + \" was not found!");
        }
        return product;
    }

    /**
     * This method calls the insert method in ProductDAO for inserting a product into the database
     * @param product product that will be inserted
     * @return int
     */
    public int insertProduct(Product product){
        for (Validators i : validators) {
            i.validate(product);
        }
        return productsDAO.insert(product);
    }


    /**
     * This method calls the insert method in ProductDAO for editing a product into the database
     * @param product product that will be edited
     * @return int
     */
    public int editProduct(Product product){
        for (Validators i : validators) {
            i.validate(product);
        }
        return productsDAO.update(product);
    }

    /**
     * This method calls the insert method in ProductDAO for deleting a product into the database
     * @param id id of product that will be deleted
     * @return int
     */
    public int deleteProductById(int id){
        int deletedId = productsDAO.delete(id);
        return deletedId;
    }

    /**
     * This method calls the insert method in ProductDAO for finding all products into the database
     * @return list
     */
    public List<Product> findAllProducts(){
        List<Product> list = productsDAO.findAll();
        if (list == null) {
            throw new NoSuchElementException("Products were not found!");
        }
        return list;
    }


}
