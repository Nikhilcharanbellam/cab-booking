package cab_booking;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class ViewCustomerDetailsAdmin extends JFrame {
    private JPanel contentPane;
    private JTable table;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                ViewCustomerDetailsAdmin frame = new ViewCustomerDetailsAdmin();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public ViewCustomerDetailsAdmin() throws SQLException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 1300, 680);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("cab_booking/images/viewall.jpg"));
        Image i3 = i1.getImage().getScaledInstance(626, 201, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(0, 450, 626, 201);
        contentPane.add(l1);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("cab_booking/images/viewall.jpg"));
        Image i5 = i4.getImage().getScaledInstance(626, 201, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel l2 = new JLabel(i6);
        l2.setBounds(615, 450, 626, 201);
        contentPane.add(l2);

        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 40, 900, 350);
        contentPane.add(scrollPane);

        DefaultTableModel model = new DefaultTableModel();
        table.setModel(model);
        model.addColumn("Username");
        model.addColumn("ID Type");
        model.addColumn("Number");
        model.addColumn("Name");
        model.addColumn("Gender");
        model.addColumn("Country");
        model.addColumn("Address");
        model.addColumn("Phone");
        model.addColumn("Email");

        try {
            ConnectionClass c = new ConnectionClass();
            String displayCustomersql = "SELECT * FROM user_details";
            ResultSet rs = c.stm.executeQuery(displayCustomersql);
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();

            while (rs.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = rs.getObject(i);
                }
                model.addRow(row);
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        JButton btnNewButton = new JButton("Back");
        btnNewButton.addActionListener(e -> setVisible(false));
        btnNewButton.setBounds(390, 400, 120, 30);
        btnNewButton.setBackground(Color.BLACK);
        btnNewButton.setForeground(Color.WHITE);
        contentPane.add(btnNewButton);

        JLabel titleLabel = new JLabel("Customer Details");
        titleLabel.setBounds(350, 10, 200, 30);
        titleLabel.setFont(titleLabel.getFont().deriveFont(18f));
        contentPane.add(titleLabel);

        getContentPane().setBackground(Color.WHITE);
    }
}
