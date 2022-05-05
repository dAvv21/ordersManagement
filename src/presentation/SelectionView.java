package presentation;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;


/**
 * UI Class for selecting the type of user
 */
public class SelectionView extends JFrame {

    private JPanel contentPane;
    private JButton clientInterfaceBtn;
    private JButton productInterfaceBtn;
    private JButton orderInterfaceBtn;


    /**
     * SelectionView constructor
     */
    public SelectionView() {
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        setBounds(100, 100, 650, 519);
        contentPane = new JPanel();
        contentPane.setForeground(Color.GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        contentPane.setLayout(null);

        JLabel title2Lbl = new JLabel("Choose the interface you want to interact with!");
        title2Lbl.setFont(new Font("Arial", Font.ITALIC, 21));
        title2Lbl.setHorizontalAlignment(SwingConstants.CENTER);
        title2Lbl.setBounds(10, 108, 630, 23);
        contentPane.add(title2Lbl);

        JLabel titleLbl = new JLabel("Interface Selection");
        titleLbl.setHorizontalAlignment(SwingConstants.CENTER);
        titleLbl.setFont(new Font("Arial", Font.BOLD, 27));
        titleLbl.setBounds(10, 20, 630, 52);
        contentPane.add(titleLbl);

        clientInterfaceBtn = new JButton("Client Interface");
        clientInterfaceBtn.setFont(new Font("Arial", Font.PLAIN, 17));
        clientInterfaceBtn.setBounds(139, 194, 391, 52);
        contentPane.add(clientInterfaceBtn);

        JLabel lblX = new JLabel("X");
        lblX.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Are you sure you want to close this application?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0)
                    SelectionView.this.dispose();
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

        productInterfaceBtn = new JButton("Product Interface");
        productInterfaceBtn.setFont(new Font("Arial", Font.PLAIN, 17));
        productInterfaceBtn.setBounds(139, 288, 391, 52);
        contentPane.add(productInterfaceBtn);

        orderInterfaceBtn = new JButton("Order Interface");
        orderInterfaceBtn.setFont(new Font("Arial", Font.PLAIN, 17));
        orderInterfaceBtn.setBounds(139, 392, 391, 52);
        contentPane.add(orderInterfaceBtn);

        this.setVisible(true);
    }

    /**
     * Method that selects the client interface
     * @param actionListener
     */
    public void selectClientInterface(ActionListener actionListener) {
        clientInterfaceBtn.addActionListener(actionListener);
    }

    /**
     * Method that selects the products interface
     * @param actionListener
     */
    public void selectProductInterface(ActionListener actionListener) {
        productInterfaceBtn.addActionListener(actionListener);
    }

    /**
     * Method that selects the orders interface
     * @param actionListener
     */
    public void selectOrderInterface(ActionListener actionListener) {
        orderInterfaceBtn.addActionListener(actionListener);
    }


}
