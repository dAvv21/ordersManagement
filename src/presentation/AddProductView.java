package presentation;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

/**
 * UI Class for adding a product in DB
 */
public class AddProductView extends JFrame {

    private JPanel contentPane;
    private JButton backBtn;
    private JTextField nameTxt;
    private JTextField stockTxt;
    private JButton btnNewButton;


    /**
     * AddProductView constructor
     */
    public AddProductView() {
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        setBounds(100, 100, 650, 519);
        contentPane = new JPanel();
        contentPane.setForeground(Color.GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        contentPane.setLayout(null);

        JLabel titleLbl = new JLabel("Add  Product");
        titleLbl.setHorizontalAlignment(SwingConstants.CENTER);
        titleLbl.setFont(new Font("Arial", Font.BOLD, 27));
        titleLbl.setBounds(40, 76, 539, 52);
        contentPane.add(titleLbl);

        backBtn = new JButton("Back");
        backBtn.setFont(new Font("Arial", Font.PLAIN, 17));
        backBtn.setBounds(10, 5, 114, 36);
        contentPane.add(backBtn);

        JLabel lblX = new JLabel("X");
        lblX.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Are you sure you want to close this application?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0)
                    AddProductView.this.dispose();
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

        JLabel nameLbl = new JLabel("Name");
        nameLbl.setFont(new Font("Arial", Font.PLAIN, 20));
        nameLbl.setBounds(126, 209, 109, 44);
        contentPane.add(nameLbl);

        nameTxt = new JTextField();
        nameTxt.setFont(new Font("Arial", Font.PLAIN, 20));
        nameTxt.setBounds(245, 209, 274, 36);
        contentPane.add(nameTxt);
        nameTxt.setColumns(10);

        JLabel stockLbl = new JLabel("Stock");
        stockLbl.setFont(new Font("Arial", Font.PLAIN, 20));
        stockLbl.setBounds(126, 304, 114, 44);
        contentPane.add(stockLbl);

        stockTxt = new JTextField();
        stockTxt.setFont(new Font("Arial", Font.PLAIN, 20));
        stockTxt.setColumns(10);
        stockTxt.setBounds(245, 308, 274, 36);
        contentPane.add(stockTxt);

        btnNewButton = new JButton("ADD PRODUCT");
        btnNewButton.setFont(new Font("Arial", Font.PLAIN, 17));
        btnNewButton.setBounds(126, 407, 393, 36);
        contentPane.add(btnNewButton);

        this.setVisible(false);
    }

    /**
     * The method that returns the name that the user entered in the textfield
     * @return String
     */
    public String getNameTxt() {
        return nameTxt.getText();
    }

    /**
     * The method that returns the stock of a product that the user entered in the textfield
     * @return String
     */
    public String getStockTxt() {
        return stockTxt.getText();
    }

    /**
     * Method that link the AddProductView to ProductOperationsView
     * @param actionListener
     */
    public void getBack(ActionListener actionListener) {
        backBtn.addActionListener(actionListener);
    }

    /**
     * The method that is used in Controller for adding product
     * @param actionListener
     */
    public void addProductToDB(ActionListener actionListener){btnNewButton.addActionListener(actionListener);}

}
