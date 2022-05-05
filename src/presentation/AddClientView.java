package presentation;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

/**
 * UI Class for adding a client in DB
 */
public class AddClientView extends JFrame {

    private JPanel contentPane;
    private JButton backBtn;
    private JTextField nameTxt;
    private JTextField addressTxt;
    private JTextField emaiField;
    private JButton addButton;


    /**
     * AddClientView constructor
     */
    public AddClientView() {
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        setBounds(100, 100, 650, 519);
        contentPane = new JPanel();
        contentPane.setForeground(Color.GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        contentPane.setLayout(null);

        JLabel titleLbl = new JLabel("Add or Edit Client");
        titleLbl.setHorizontalAlignment(SwingConstants.CENTER);
        titleLbl.setFont(new Font("Arial", Font.BOLD, 27));
        titleLbl.setBounds(101, 20, 539, 52);
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
                    AddClientView.this.dispose();
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
        nameLbl.setBounds(126, 185, 109, 44);
        contentPane.add(nameLbl);

        nameTxt = new JTextField();
        nameTxt.setFont(new Font("Arial", Font.PLAIN, 20));
        nameTxt.setBounds(245, 189, 274, 36);
        contentPane.add(nameTxt);
        nameTxt.setColumns(10);

        JLabel addressLbl = new JLabel("Address");
        addressLbl.setFont(new Font("Arial", Font.PLAIN, 20));
        addressLbl.setBounds(126, 268, 114, 44);
        contentPane.add(addressLbl);

        JLabel emailLbl = new JLabel("Email");
        emailLbl.setFont(new Font("Arial", Font.PLAIN, 20));
        emailLbl.setBounds(126, 359, 97, 44);
        contentPane.add(emailLbl);

        addressTxt = new JTextField();
        addressTxt.setFont(new Font("Arial", Font.PLAIN, 20));
        addressTxt.setColumns(10);
        addressTxt.setBounds(245, 276, 274, 36);
        contentPane.add(addressTxt);

        emaiField = new JTextField();
        emaiField.setFont(new Font("Arial", Font.PLAIN, 20));
        emaiField.setColumns(10);
        emaiField.setBounds(245, 363, 274, 36);
        contentPane.add(emaiField);

        addButton = new JButton("ADD");
        addButton.setFont(new Font("Arial", Font.PLAIN, 15));
        addButton.setBounds(126, 429, 393, 28);
        contentPane.add(addButton);

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
     * The method that returns the address that the user entered in the textfield
     * @return String
     */
    public String getAddressTxt() {
        return addressTxt.getText();
    }


    /**
     * The method that returns the email that the user entered in the textfield
     * @return String
     */
    public String getEmaiField() {
        return emaiField.getText();
    }


    /**
     * Method that link the AddClientView to ClientOperationsView
     * @param actionListener
     */
    public void getBack(ActionListener actionListener) {
        backBtn.addActionListener(actionListener);
    }

    /**
     * The method that is used in Controller for adding clients
     * @param actionListener
     */
    public void addClientsBtn(ActionListener actionListener){
        addButton.addActionListener(actionListener);
    }


}
