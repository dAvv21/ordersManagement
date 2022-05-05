package presentation;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

/**
 * UI Class for create an order in DB
 */
public class CreateOrderView extends JFrame {

    private JPanel contentPane;
    private JButton createBtn;
    private JTextField quantityTxt;
    private JButton backBtn;
    private JPanel productPanel;
    private JScrollPane scrollPaneProductsTable;
    private JTable productsTable;
    private JPanel clientsPanel;
    private JScrollPane scrollPaneClientsTable;
    private JTable clientsTable;
    private JPanel ordersPanel;
    private JScrollPane scrollPaneOrderTable;
    private JTable ordersTable;


    /**
     * CreateOrderView constructor
     */
    public CreateOrderView() {
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        setBounds(100, 100, 650, 519);
        contentPane = new JPanel();
        contentPane.setForeground(Color.GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        contentPane.setLayout(null);

        JLabel titleLbl = new JLabel("Create Order");
        titleLbl.setHorizontalAlignment(SwingConstants.CENTER);
        titleLbl.setFont(new Font("Arial", Font.BOLD, 27));
        titleLbl.setBounds(10, 20, 630, 52);
        contentPane.add(titleLbl);

        createBtn = new JButton("Create");
        createBtn.setFont(new Font("Arial", Font.PLAIN, 17));
        createBtn.setBounds(475, 99, 153, 44);
        contentPane.add(createBtn);

        JLabel lblX = new JLabel("X");
        lblX.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Are you sure you want to close this application?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0)
                    CreateOrderView.this.dispose();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                lblX.setForeground(Color.RED);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lblX.setForeground(Color.WHITE);
            }
        });
        lblX.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblX.setBounds(633, 5, 31, 23);
        contentPane.add(lblX);

        JLabel quantityLbl = new JLabel("Please introduce quantity  :");
        quantityLbl.setFont(new Font("Arial", Font.PLAIN, 20));
        quantityLbl.setBounds(26, 99, 252, 44);
        contentPane.add(quantityLbl);

        quantityTxt = new JTextField();
        quantityTxt.setFont(new Font("Arial", Font.PLAIN, 20));
        quantityTxt.setBounds(274, 102, 191, 36);
        contentPane.add(quantityTxt);
        quantityTxt.setColumns(10);

        backBtn = new JButton("Back");
        backBtn.setFont(new Font("Arial", Font.PLAIN, 17));
        backBtn.setBounds(0, 4, 75, 29);
        contentPane.add(backBtn);

        productPanel = new JPanel();
        productPanel.setBounds(327, 303, 313, 167);
        contentPane.add(productPanel);
        GridBagLayout gbl_productPanel = new GridBagLayout();
        gbl_productPanel.columnWidths = new int[]{0, 0};
        gbl_productPanel.rowHeights = new int[]{0, 0};
        gbl_productPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gbl_productPanel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
        productPanel.setLayout(gbl_productPanel);

        scrollPaneProductsTable = new JScrollPane();
        GridBagConstraints gbc_scrollPaneProductsTable = new GridBagConstraints();
        gbc_scrollPaneProductsTable.fill = GridBagConstraints.BOTH;
        gbc_scrollPaneProductsTable.gridx = 0;
        gbc_scrollPaneProductsTable.gridy = 0;
        productPanel.add(scrollPaneProductsTable, gbc_scrollPaneProductsTable);

        productsTable = new JTable();
        scrollPaneProductsTable.setViewportView(productsTable);

        clientsPanel = new JPanel();
        clientsPanel.setBounds(26, 300, 291, 170);
        contentPane.add(clientsPanel);
        GridBagLayout gbl_clientsPanel = new GridBagLayout();
        gbl_clientsPanel.columnWidths = new int[]{0, 0};
        gbl_clientsPanel.rowHeights = new int[]{0, 0};
        gbl_clientsPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gbl_clientsPanel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
        clientsPanel.setLayout(gbl_clientsPanel);

        scrollPaneClientsTable = new JScrollPane();
        GridBagConstraints gbc_scrollPaneClientsTable = new GridBagConstraints();
        gbc_scrollPaneClientsTable.fill = GridBagConstraints.BOTH;
        gbc_scrollPaneClientsTable.gridx = 0;
        gbc_scrollPaneClientsTable.gridy = 0;
        clientsPanel.add(scrollPaneClientsTable, gbc_scrollPaneClientsTable);

        clientsTable = new JTable();
        scrollPaneClientsTable.setViewportView(clientsTable);

        ordersPanel = new JPanel();
        ordersPanel.setBounds(26, 153, 602, 137);
        contentPane.add(ordersPanel);
        GridBagLayout gbl_ordersPanel = new GridBagLayout();
        gbl_ordersPanel.columnWidths = new int[]{0, 0};
        gbl_ordersPanel.rowHeights = new int[]{0, 0};
        gbl_ordersPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gbl_ordersPanel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
        ordersPanel.setLayout(gbl_ordersPanel);

        scrollPaneOrderTable = new JScrollPane();
        GridBagConstraints gbc_scrollPaneOrderTable = new GridBagConstraints();
        gbc_scrollPaneOrderTable.fill = GridBagConstraints.BOTH;
        gbc_scrollPaneOrderTable.gridx = 0;
        gbc_scrollPaneOrderTable.gridy = 0;
        ordersPanel.add(scrollPaneOrderTable, gbc_scrollPaneOrderTable);

        ordersTable = new JTable();
        scrollPaneOrderTable.setViewportView(ordersTable);


        this.setVisible(false);
    }

    /**
     * Method that show table of orders
     * @param tableO table of Orders
     */
    public void showOrdersTable(JTable tableO){
        scrollPaneOrderTable.setViewportView(tableO);
    }

    public JTable getProductsTable() {
        return productsTable;
    }

    public JTable getClientsTable() {
        return clientsTable;
    }

    public boolean isSelected(){
        if(clientsTable.getSelectedRow() >= 0 && productsTable.getSelectedRow() >= 0){
            return true;
        }
        return false;
    }


    /**
     * Method that show table of Clients
     * @param tableC table of Orders
     */
    public void showClientsTable(JTable tableC){
        scrollPaneClientsTable.setViewportView(tableC);
    }

    /**
     * Method that show table of products
     * @param tableP table of Orders
     */
    public void showProductsTable(JTable tableP){
        scrollPaneProductsTable.setViewportView(tableP);
    }


    /**
     * Method that create an order in Controller
     * @param actionListener
     */
    public void createOrder(ActionListener actionListener) {
        createBtn.addActionListener(actionListener);
    }

    public void getBack(ActionListener actionListener) {
        backBtn.addActionListener(actionListener);
    }

    public String getQuantityTxt() {
        return quantityTxt.getText();
    }

    /**
     * Method that sets Product Table
     * @param productsTable product table
     */
    public void setProductsTable(JTable productsTable) {
        this.productsTable = productsTable;
    }

    public void setClientsTable(JTable clientsTable) {
        this.clientsTable = clientsTable;
    }
}
