package presentation;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

/**
 * UI Class for editing a product in DB
 */
public class EditProductView extends JFrame {

    private JPanel contentPane;
    private JButton backBtn;
    private JTextField nameTxt;
    private JTextField stockTxt;
    private JButton updateProductButton;
    private JLabel idLbl;
    private JTextField idProductForEditTxt;


    /**
     * EditProductView constructor
     */
    public EditProductView() {
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        setBounds(100, 100, 650, 519);
        contentPane = new JPanel();
        contentPane.setForeground(Color.GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        contentPane.setLayout(null);

        JLabel titleLbl = new JLabel("Edit Product");
        titleLbl.setHorizontalAlignment(SwingConstants.CENTER);
        titleLbl.setFont(new Font("Arial", Font.BOLD, 27));
        titleLbl.setBounds(10, 74, 630, 52);
        contentPane.add(titleLbl);

        backBtn = new JButton("Back");
        backBtn.setFont(new Font("Arial", Font.PLAIN, 17));
        backBtn.setBounds(10, 31, 134, 36);
        contentPane.add(backBtn);

        JLabel lblX = new JLabel("X");
        lblX.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Are you sure you want to close this application?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0)
                    EditProductView.this.dispose();
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
        nameLbl.setBounds(126, 247, 109, 44);
        contentPane.add(nameLbl);

        nameTxt = new JTextField();
        nameTxt.setFont(new Font("Arial", Font.PLAIN, 20));
        nameTxt.setBounds(245, 251, 274, 36);
        contentPane.add(nameTxt);
        nameTxt.setColumns(10);

        JLabel stockLbl = new JLabel("Stock");
        stockLbl.setFont(new Font("Arial", Font.PLAIN, 20));
        stockLbl.setBounds(126, 327, 114, 44);
        contentPane.add(stockLbl);

        stockTxt = new JTextField();
        stockTxt.setFont(new Font("Arial", Font.PLAIN, 20));
        stockTxt.setColumns(10);
        stockTxt.setBounds(245, 331, 274, 36);
        contentPane.add(stockTxt);

        updateProductButton = new JButton("UPDATE");
        updateProductButton.setFont(new Font("Arial", Font.PLAIN, 15));
        updateProductButton.setBounds(126, 403, 393, 52);
        contentPane.add(updateProductButton);

        idLbl = new JLabel("Insert product id you want to update :");
        idLbl.setFont(new Font("Arial", Font.PLAIN, 16));
        idLbl.setBounds(126, 165, 292, 44);
        contentPane.add(idLbl);

        idProductForEditTxt = new JTextField();
        idProductForEditTxt.setFont(new Font("Arial", Font.PLAIN, 20));
        idProductForEditTxt.setColumns(10);
        idProductForEditTxt.setBounds(405, 168, 114, 36);
        contentPane.add(idProductForEditTxt);

        this.setVisible(false);
    }

    /**
     * The method that returns the id of product that the user entered in the textfield
     * @return int
     */
    public int getIdTxt() {
        return Integer.parseInt(idProductForEditTxt.getText());
    }

    /**
     * The method that returns the name of product that the user entered in the textfield
     * @return String
     */
    public String getNameTxt() {
        return nameTxt.getText();
    }


    /**
     * The method that returns the stock of product that the user entered in the textfield
     * @return String
     */
    public String getStock() {
        return stockTxt.getText();
    }


    public void getBackToClientOpView(ActionListener actionListener) {
        backBtn.addActionListener(actionListener);
    }

    /**
     * Method that is used in Controller to update products in DB
     * @param actionListener
     */
    public void updateProductsInDB(ActionListener actionListener){
        updateProductButton.addActionListener(actionListener);
    }


}
