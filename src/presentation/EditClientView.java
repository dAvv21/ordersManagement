package presentation;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

/**
 * UI Class for editing a client in DB
 */
public class EditClientView extends JFrame {

    private JPanel contentPane;
    private JButton backBtn;
    private JTextField nameTxt;
    private JTextField addressTxt;
    private JTextField emailField;
    private JButton editButton;
    private JLabel idLbl;
    private JTextField idTxt;


    /**
     * EditClientView constructor
     */
    public EditClientView() {
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
                    EditClientView.this.dispose();
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

        emailField = new JTextField();
        emailField.setFont(new Font("Arial", Font.PLAIN, 20));
        emailField.setColumns(10);
        emailField.setBounds(245, 363, 274, 36);
        contentPane.add(emailField);

        editButton = new JButton("UPDATE");
        editButton.setFont(new Font("Arial", Font.PLAIN, 15));
        editButton.setBounds(126, 429, 393, 28);
        contentPane.add(editButton);

        idLbl = new JLabel("Inser customer id you want to update :");
        idLbl.setFont(new Font("Arial", Font.PLAIN, 16));
        idLbl.setBounds(126, 95, 292, 44);
        contentPane.add(idLbl);

        idTxt = new JTextField();
        idTxt.setFont(new Font("Arial", Font.PLAIN, 20));
        idTxt.setColumns(10);
        idTxt.setBounds(405, 98, 114, 36);
        contentPane.add(idTxt);

        this.setVisible(false);
    }

    /**
     * The method that returns the id that the user entered in the textfield
     * @return int
     */
    public int getIdTxt() {
        return Integer.parseInt(idTxt.getText());
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
    public String getEmailField() {
        return emailField.getText();
    }


    public void getBackToClientOpView(ActionListener actionListener) {
        backBtn.addActionListener(actionListener);
    }

    public void editClientsBtn(ActionListener actionListener){
        editButton.addActionListener(actionListener);
    }


}
