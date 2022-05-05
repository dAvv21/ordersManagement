package presentation;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

/**
 * UI Class for deleting a client in DB
 */
public class DeleteClientView extends JFrame {

    private JPanel contentPane;
    private JButton backBtn;
    private JButton deleteBtn;
    private JLabel idLbl;
    private JTextField idTxt;


    /**
     * DeleteClientView constructor
     */
    public DeleteClientView() {
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
        titleLbl.setBounds(126, 20, 514, 52);
        contentPane.add(titleLbl);

        backBtn = new JButton("Back");
        backBtn.setFont(new Font("Arial", Font.PLAIN, 17));
        backBtn.setBounds(10, 20, 134, 36);
        contentPane.add(backBtn);

        JLabel lblX = new JLabel("X");
        lblX.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Are you sure you want to close this application?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0)
                    DeleteClientView.this.dispose();
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

        deleteBtn = new JButton("DELETE");
        deleteBtn.setFont(new Font("Arial", Font.PLAIN, 18));
        deleteBtn.setBounds(126, 405, 393, 52);
        contentPane.add(deleteBtn);

        idLbl = new JLabel("Inser customer id you want to delete :");
        idLbl.setHorizontalAlignment(SwingConstants.CENTER);
        idLbl.setFont(new Font("Arial", Font.PLAIN, 20));
        idLbl.setBounds(10, 144, 630, 44);
        contentPane.add(idLbl);

        idTxt = new JTextField();
        idTxt.setFont(new Font("Arial", Font.PLAIN, 20));
        idTxt.setColumns(10);
        idTxt.setBounds(253, 216, 114, 36);
        contentPane.add(idTxt);

        this.setVisible(false);
    }

    /**
     * The method that returns the id that the user entered in the textfield
     * @return int
     */
    public int getIdForDeletingTxt() {
        return Integer.parseInt(idTxt.getText());
    }


    public void getBack(ActionListener actionListener) {
        backBtn.addActionListener(actionListener);
    }

    /**
     * Method that is used in Controller to delete a client from DB
     * @param actionListener
     */
    public void goDeleteBtn(ActionListener actionListener){
        deleteBtn.addActionListener(actionListener);
    }


}
