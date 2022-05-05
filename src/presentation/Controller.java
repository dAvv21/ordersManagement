package presentation;

import bll.ClientBLL;
import bll.OrderBLL;
import bll.ProductBLL;
import model.Client;
import model.Order;
import model.Product;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Class that controll the UI Classes and implements ActionListener interface
 */
public class Controller {
    private AddClientView addEditClientView;
    private AddProductView addProductView;
    private ClientOperationsView clientOperationsView;
    private CreateOrderView createOrderView;
    private ProductOperationsView productOperationsView;
    private SelectionView selectionView;
    private EditClientView editClientView;
    private DeleteClientView deleteClientView;
    private EditProductView editProductView;
    private Client client;
    private Order order;
    private Product product;
    private ClientBLL clientBLL;
    private OrderBLL orderBLL;
    private ProductBLL productBLL;
    private JTable table;  //customers table
    private JTable productsTable; // products table
    private JTable ordersTable;  //orders table


    public Controller(AddClientView addEditClientView, EditClientView editClientView, DeleteClientView deleteClientView, AddProductView addProductView, ClientOperationsView clientOperationsView, CreateOrderView createOrderView, ProductOperationsView productOperationsView, SelectionView selectionView, Client client, Order order, Product product, ClientBLL clientBLL,ProductBLL productBLL,OrderBLL orderBLL, EditProductView editProductView) {
        this.addEditClientView = addEditClientView;
        this.addProductView = addProductView;
        this.clientOperationsView = clientOperationsView;
        this.deleteClientView = deleteClientView;
        this.createOrderView = createOrderView;
        this.productOperationsView = productOperationsView;
        this.editProductView = editProductView;
        this.editClientView = editClientView;
        this.selectionView = selectionView;
        this.client = client;
        this.clientBLL = clientBLL;
        this.productBLL = productBLL;
        this.orderBLL = orderBLL;
        this.order = order;
        this.product = product;
        this.selectionView.selectClientInterface(new SelectClientInterface());
        this.selectionView.selectProductInterface(new SelectProductInterface());
        this.selectionView.selectOrderInterface(new SelectOrderInterface());
        this.clientOperationsView.addClient(new AddClient());
        this.clientOperationsView.editClient(new EditClient());
        this.productOperationsView.addProduct(new AddProduct());
        this.productOperationsView.editProduct(new EditProduct());
        this.addEditClientView.getBack(new GetBacktToClientsOp());
        this.addProductView.getBack(new GetBackToProductOp());
        this.clientOperationsView.getBack(new GetBackToSelection());
        this.productOperationsView.getBack(new GetBackToSelection());
        this.editClientView.getBackToClientOpView(new GetBackToClientOpView());
        this.createOrderView.getBack(new GetBackToSelection());
        this.addEditClientView.addClientsBtn(new AddClientBtn());
        this.clientOperationsView.deleteClient(new DeleteClient());
        this.productOperationsView.deleteProduct(new DeleteProduct());
        this.clientOperationsView.viewAllClients(new ViewAllClients());
        this.productOperationsView.viewAllProducts(new ViewAllProducts());
        this.editClientView.editClientsBtn(new EditClientBtn());
        this.deleteClientView.getBack(new GetBackToClientOpViewFromDelete());
        this.deleteClientView.goDeleteBtn(new GoDeleteClient());  //butonul de deleteClient
        this.addProductView.addProductToDB(new AddProductToDB());
        this.editProductView.getBackToClientOpView(new getFromEditProductToProductOp());
        this.editProductView.updateProductsInDB(new UpdateProductsToDB());


    }

    /**
     * Inner class that gets user from selectionView to ClientsOperationsView
     */
    class SelectClientInterface implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            selectionView.setVisible(false);
            clientOperationsView.setVisible(true);
        }
    }

    /**
     * Inner class that gets user from productOperationsView to selectionView
     */
    class SelectProductInterface implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            selectionView.setVisible(false);
            productOperationsView.setVisible(true);
        }
    }

    /**
     * Inner class that set the tables in the CreateOrderView and sets visibility for views
     */
    class SelectOrderInterface implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            selectionView.setVisible(false);
            createOrderView.setVisible(true);

            //setam tabelele din view ul Order
            List<Product> productList = productBLL.findAllProducts();
            productsTable = productBLL.createTableProduct(productList);
            createOrderView.showProductsTable(productsTable);

            List<Client> clientList = clientBLL.findAllClients();
            table = clientBLL.createTable(clientList);
            createOrderView.showClientsTable(table);

            createOrderView.setClientsTable(table);
            createOrderView.setProductsTable(productsTable);

            createOrderView.createOrder(new CreateOrder());



        }
    }

    /**
     * Inner class that gets user from clientOperationsView to addClientView
     */
    class AddClient implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            clientOperationsView.setVisible(false);
            addEditClientView.setVisible(true);

        }
    }

    /**
     * Inner class that implements ActionListener and sets addClient button
     */
    class AddClientBtn implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            addEditClientView.setVisible(false);
            clientOperationsView.setVisible(true);

            String name = addEditClientView.getNameTxt();
            String address = addEditClientView.getAddressTxt();
            String email = addEditClientView.getEmaiField();

            Client client = new Client(name,address,email);
            clientBLL.insertClient(client);

        }
    }


    class EditClient implements ActionListener {  //buton tranzitie EditClient de pe ClientOpView

        @Override
        public void actionPerformed(ActionEvent e) {
            clientOperationsView.setVisible(false);
            editClientView.setVisible(true);
        }
    }

    /**
     * Inner class that implements ActionListener and sets editClient button
     */
    class EditClientBtn implements ActionListener{  ////buton propriu-zis EDIT de pe editClientView

        @Override
        public void actionPerformed(ActionEvent e) {
            clientOperationsView.setVisible(true);
            editClientView.setVisible(false);

            int id = editClientView.getIdTxt();
            String name = editClientView.getNameTxt();
            String address = editClientView.getAddressTxt();
            String email = editClientView.getEmailField();

            Client client = new Client(id,name,address,email);
            clientBLL.editClient(client);
        }
    }




    /**
     * Inner class that implements ActionListener and sets deleteClient button
     */
    class GoDeleteClient implements ActionListener{  ///buton propriu-zis de pe deleteClientView;
        @Override
        public void actionPerformed(ActionEvent e) {
            clientOperationsView.setVisible(true);
            deleteClientView.setVisible(false);

            int id = deleteClientView.getIdForDeletingTxt();
            clientBLL.deleteClientById(id);

        }
    }


    class DeleteClient implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            clientOperationsView.setVisible(false);
            deleteClientView.setVisible(true);
        }
    }

    class GetBackToClientOpViewFromDelete implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            deleteClientView.setVisible(false);
            clientOperationsView.setVisible(true);
        }
    }

    /**
     * Inner class that gets user from editClientView to clientOperationsView
     */
    class GetBackToClientOpView implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            clientOperationsView.setVisible(true);
            editClientView.setVisible(false);
        }
    }

    /**
     * Inner class that displays all clients in a table
     */
    class ViewAllClients implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            List<Client> clientList = clientBLL.findAllClients();
            table = clientBLL.createTable(clientList);
            clientOperationsView.showClientTable(table);

        }
    }
  //------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Inner class that gets user from productOperationsView to addProductView
     */
    class AddProduct implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            productOperationsView.setVisible(false);
            addProductView.setVisible(true);
        }

    }


    /**
     * Inner class that implements ActionListener and sets addProduct button
     */
    class AddProductToDB implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            addProductView.setVisible(false);
            productOperationsView.setVisible(true);

            String name = addProductView.getNameTxt();
            int stock = Integer.parseInt(addProductView.getStockTxt());

            Product product = new Product(name,stock);
            productBLL.insertProduct(product);

        }
    }

    class EditProduct implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            productOperationsView.setVisible(false);
            editProductView.setVisible(true);
        }
    }

    class getFromEditProductToProductOp implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            editProductView.setVisible(false);
            productOperationsView.setVisible(true);
        }
    }


    /**
     * Inner class that implements ActionListener and sets updateProduct button
     */
    class UpdateProductsToDB implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            productOperationsView.setVisible(true);
            editProductView.setVisible(false);
            int id = editProductView.getIdTxt();
            String name = editProductView.getNameTxt();
            int stock = Integer.parseInt(editProductView.getStock());

            Product product = new Product(id,name,stock);
            productBLL.editProduct(product);

        }
    }


    /**
     * Inner class that implements ActionListener and sets deleteProduct button
     */
    class DeleteProduct implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int id = productOperationsView.getIdDeleteTxt();
            productBLL.deleteProductById(id);
        }
    }

    /**
     * Inner class that displays all products in a table
     */
    class ViewAllProducts implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            List<Product> productList = productBLL.findAllProducts();
            productsTable = productBLL.createTableProduct(productList);
            productOperationsView.showProductsTable(productsTable);

        }
    }

    //----------------------------------------------------------------------------------------------

    /**
     *
     * @param table table of Clients or Products
     * @return int
     */
    private int  getSelectedId(JTable table){
        int intId;
        String stringId = null;
        int row = table.getSelectedRow();
        int column = 0;
        stringId = table.getValueAt(row,column).toString();
        intId = Integer.parseInt(stringId);
        return intId;
    }


    /**
     * Inner class that create OrderTable in CreateOrderView
     */
    class CreateOrder implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String quantity = createOrderView.getQuantityTxt();
            if(!quantity.equals("")){
                int intQuantity = Integer.parseInt(quantity);
                if(intQuantity > 0){
                    if(createOrderView.isSelected()){
                        int idClient = getSelectedId(createOrderView.getClientsTable()); //retin id ul clientului pe care l am selectat
                        int idProduct = getSelectedId(createOrderView.getProductsTable()); //retin id ul produsului pe care l am selectat
                        Client client = clientBLL.findClientById(idClient);
                        Product product = productBLL.findProductById(idProduct);
                        if(intQuantity < product.getStock()){
                            orderBLL.insertOrder(new Order(idClient,idProduct,product.getName(),client.getName(),client.getAddress(),intQuantity));

                            List<Order> orderList = orderBLL.findAllOrders(); //aici crapa
                            ordersTable = orderBLL.createOrderTable(orderList);
                            createOrderView.showOrdersTable(ordersTable);

                            productBLL.editProduct(new Product(product.getId(),product.getName(),product.getStock() - intQuantity)); // updatam

                            List<Product> productList = productBLL.findAllProducts();
                            productsTable = productBLL.createTableProduct(productList);
                            createOrderView.showProductsTable(productsTable);

                        }else{
                            System.out.println("Under stock");
                        }

                    }
                }
            }else{
                System.out.println("Introduce something!!");
            }

        }
    }


    /**
     * Inner class that gets user from clientOperationsView to addEditClientView
     */
    class GetBacktToClientsOp implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            addEditClientView.setVisible(false);
            clientOperationsView.setVisible(true);
        }
    }

    class GetBackToProductOp implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            addProductView.setVisible(false);
            productOperationsView.setVisible(true);
        }
    }


    class GetBackToSelection implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            productOperationsView.setVisible(false);
            clientOperationsView.setVisible(false);
            createOrderView.setVisible(false);
            selectionView.setVisible(true);
        }
    }
}
