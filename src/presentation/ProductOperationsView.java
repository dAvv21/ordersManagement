package presentation;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

/**
 * UI Class for selection operation for products in DB
 */
public class ProductOperationsView extends JFrame {

    private JPanel contentPane;
    private JButton addProductBtn;
    private JButton editProductBtn;
    private JButton deleteProductBtn;
    private JButton viewAllBtn;
    private JScrollPane scrollPane;
    private JTable table;
    private JButton backBtn;
    private JTextField idDeleteTxt;
    private JLabel idLbl;


    /**
     * ProductOperationsView constructor
     */
    public ProductOperationsView() {
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        setBounds(100, 100, 650, 519);
        contentPane = new JPanel();
        contentPane.setForeground(Color.GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        contentPane.setLayout(null);

        JLabel title2Lbl = new JLabel("Choose the operation you want to interact with!");
        title2Lbl.setFont(new Font("Arial", Font.ITALIC, 21));
        title2Lbl.setHorizontalAlignment(SwingConstants.CENTER);
        title2Lbl.setBounds(10, 108, 630, 23);
        contentPane.add(title2Lbl);

        JLabel titleLbl = new JLabel("Product Operations");
        titleLbl.setHorizontalAlignment(SwingConstants.CENTER);
        titleLbl.setFont(new Font("Arial", Font.BOLD, 27));
        titleLbl.setBounds(10, 20, 630, 52);
        contentPane.add(titleLbl);

        addProductBtn = new JButton("Add Product");
        addProductBtn.setFont(new Font("Arial", Font.PLAIN, 17));
        addProductBtn.setBounds(26, 170, 139, 44);
        contentPane.add(addProductBtn);

        JLabel lblX = new JLabel("X");
        lblX.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Are you sure you want to close this application?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0)
                    ProductOperationsView.this.dispose();
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

        editProductBtn = new JButton("Edit Product");
        editProductBtn.setFont(new Font("Arial", Font.PLAIN, 17));
        editProductBtn.setBounds(26, 253, 139, 44);
        contentPane.add(editProductBtn);

        deleteProductBtn = new JButton("Delete Product ");
        deleteProductBtn.setFont(new Font("Arial", Font.PLAIN, 17));
        deleteProductBtn.setBounds(31, 339, 134, 44);
        contentPane.add(deleteProductBtn);

        viewAllBtn = new JButton("View All");
        viewAllBtn.setFont(new Font("Arial", Font.PLAIN, 17));
        viewAllBtn.setBounds(26, 426, 139, 44);
        contentPane.add(viewAllBtn);

        backBtn = new JButton("Back");
        backBtn.setFont(new Font("Arial", Font.PLAIN, 17));
        backBtn.setBounds(0, 4, 75, 29);
        contentPane.add(backBtn);
        JPanel panel = new JPanel();
        panel.setBounds(264, 170, 352, 300);
        contentPane.add(panel);
        GridBagLayout gbl_panel = new GridBagLayout();
        gbl_panel.columnWidths = new int[]{0, 0};
        gbl_panel.rowHeights = new int[]{0, 0};
        gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gbl_panel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
        panel.setLayout(gbl_panel);

        scrollPane = new JScrollPane();
        GridBagConstraints gbc_scrollPane = new GridBagConstraints();
        gbc_scrollPane.fill = GridBagConstraints.BOTH;
        gbc_scrollPane.gridx = 0;
        gbc_scrollPane.gridy = 0;
        panel.add(scrollPane, gbc_scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);

        idDeleteTxt = new JTextField();
        idDeleteTxt.setFont(new Font("Arial", Font.PLAIN, 14));
        idDeleteTxt.setBounds(187, 344, 53, 37);
        contentPane.add(idDeleteTxt);
        idDeleteTxt.setColumns(10);

        idLbl = new JLabel("ID");
        idLbl.setHorizontalAlignment(SwingConstants.CENTER);
        idLbl.setFont(new Font("Arial", Font.PLAIN, 15));
        idLbl.setBounds(187, 321, 53, 13);
        contentPane.add(idLbl);

        this.setVisible(false);
    }

    /**
     * Method that shows products table
     * @param tableP
     */
    public void showProductsTable(JTable tableP){
        scrollPane.setViewportView(tableP);
    }


    public void addProduct(ActionListener actionListener) {
        addProductBtn.addActionListener(actionListener);
    }

    public void editProduct(ActionListener actionListener) {
        editProductBtn.addActionListener(actionListener);
    }

    /**
     * Method that is used in Controller to delete a product
     * @param actionListener
     */
    public void deleteProduct(ActionListener actionListener) {
        deleteProductBtn.addActionListener(actionListener);
    }

    /**
     * Method that displays the table of products in the view
     * @param actionListener
     */
    public void viewAllProducts(ActionListener actionListener) {
        viewAllBtn.addActionListener(actionListener);
    }

    public void getBack(ActionListener actionListener) {
        backBtn.addActionListener(actionListener);
    }

    /**
     * The method that returns the id of the product that the user entered in the textfield
     * @return
     */
    public int getIdDeleteTxt() {
        return Integer.parseInt(idDeleteTxt.getText());
    }
}
