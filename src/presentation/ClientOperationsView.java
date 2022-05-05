package presentation;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

/**
 * UI Class for selecting operations with clients
 */
public class ClientOperationsView extends JFrame {

    private JPanel contentPane;
    private JButton addClientBtn;
    private JButton editClientBtn;
    private JButton deleteClientBtn;
    private JButton viewAllBtn;
    private JButton backBtn;
    private JTable table;
    private JScrollPane scrollPane;


    /**
     * ClientOperationsView constructor
     */
    public ClientOperationsView() {
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

        JLabel titleLbl = new JLabel("Client Operations");
        titleLbl.setHorizontalAlignment(SwingConstants.CENTER);
        titleLbl.setFont(new Font("Arial", Font.BOLD, 27));
        titleLbl.setBounds(10, 20, 630, 52);
        contentPane.add(titleLbl);

        addClientBtn = new JButton("Add Client");
        addClientBtn.setFont(new Font("Arial", Font.PLAIN, 17));
        addClientBtn.setBounds(26, 170, 139, 44);
        contentPane.add(addClientBtn);

        JLabel lblX = new JLabel("X");
        lblX.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Are you sure you want to close this application?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0)
                    ClientOperationsView.this.dispose();
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

        editClientBtn = new JButton("Edit Client");
        editClientBtn.setFont(new Font("Arial", Font.PLAIN, 17));
        editClientBtn.setBounds(26, 253, 139, 44);
        contentPane.add(editClientBtn);

        deleteClientBtn = new JButton("Delete Client");
        deleteClientBtn.setFont(new Font("Arial", Font.PLAIN, 17));
        deleteClientBtn.setBounds(26, 339, 139, 44);
        contentPane.add(deleteClientBtn);

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

        this.setVisible(false);
    }


    /**
     * Method that scrollPane
     * @param tableC table of clients
     */
    public void showClientTable(JTable tableC){
        scrollPane.setViewportView(tableC);
    }

    /**
     * Method that add client
     * @param actionListener
     */
    public void addClient(ActionListener actionListener) {
        addClientBtn.addActionListener(actionListener);
    }

    /**
     * Method that edit client
     * @param actionListener
     */
    public void editClient(ActionListener actionListener) {
        editClientBtn.addActionListener(actionListener);
    }

    public void deleteClient(ActionListener actionListener) {
        deleteClientBtn.addActionListener(actionListener);
    }

    public void viewAllClients(ActionListener actionListener) {
        viewAllBtn.addActionListener(actionListener);
    }


    public void getBack(ActionListener actionListener) {
        backBtn.addActionListener(actionListener);
    }
}
