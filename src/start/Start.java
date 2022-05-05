package start;

import bll.ClientBLL;
import bll.OrderBLL;
import bll.ProductBLL;
import model.Client;
import model.Order;
import model.Product;
import presentation.*;

/**
 * Class that contain main method
 */
public class Start {

    /**
     * main method
     * @param args
     */
    public static void main(String[] args) {
        Client client = new Client();
        Order order = new Order();
        Product product = new Product();
        ClientBLL clientBLL = new ClientBLL();
        ProductBLL productBLL = new ProductBLL();
        OrderBLL orderBLL = new OrderBLL();
        AddClientView addEditClientView = new AddClientView();
        DeleteClientView deleteClientView = new DeleteClientView();
        EditProductView editProductView = new EditProductView();

        AddProductView addProductView = new AddProductView();
        EditClientView editClientView = new EditClientView();
        ClientOperationsView clientOperationsView = new ClientOperationsView();
        CreateOrderView createOrderView = new CreateOrderView();
        ProductOperationsView productOperationsView = new ProductOperationsView();
        SelectionView selectionView = new SelectionView();
        Controller controller = new Controller(addEditClientView,editClientView,deleteClientView, addProductView,clientOperationsView,createOrderView,productOperationsView,selectionView,client,order,product,clientBLL,productBLL,orderBLL,editProductView);
    }
}
