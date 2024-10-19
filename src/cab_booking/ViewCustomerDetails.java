package cab_booking;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewCustomerDetails extends JFrame {
    private JPanel contentPane;
    private JTable table;
    private String username;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                ViewCustomerDetails frame = new ViewCustomerDetails("username");
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public ViewCustomerDetails(String username) {
        this.username = username;
        initializeUI();
        loadCustomerData();
    }

    private void initializeUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 1300, 680);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        addBackgroundImages();

        JLabel titleLabel = new JLabel("Customer Details");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBounds(350, 5, 300, 30);
        contentPane.add(titleLabel);

        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 40, 1000, 350);
        contentPane.add(scrollPane);
        
        setupTableModel();

        JButton btnBack = createBackButton();
        contentPane.add(btnBack);
        
        getContentPane().setBackground(Color.WHITE);
    }

    private void addBackgroundImages() {
        ImageIcon backgroundImage = new ImageIcon(ClassLoader.getSystemResource("cab_booking/images/viewall.jpg"));
        Image scaledImage = backgroundImage.getImage().getScaledInstance(626, 201, Image.SCALE_DEFAULT);
        JLabel label1 = new JLabel(new ImageIcon(scaledImage));
        label1.setBounds(0, 450, 626, 201);
        contentPane.add(label1);

        JLabel label2 = new JLabel(new ImageIcon(scaledImage));
        label2.setBounds(615, 450, 626, 201);
        contentPane.add(label2);
    }

    private void setupTableModel() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Username");
        model.addColumn("ID Type");
        model.addColumn("Number");
        model.addColumn("Name");
        model.addColumn("Gender");
        model.addColumn("Country");
        model.addColumn("Address");
        model.addColumn("Phone");
        model.addColumn("Email");
        
        table.setModel(model);
    }

    private void loadCustomerData() {
        try {
            ConnectionClass connectionClass = new ConnectionClass();
            String query = "SELECT * FROM user_details WHERE username='" + username + "'";
            ResultSet resultSet = connectionClass.stm.executeQuery(query);
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            if (resultSet.next()) {
                Object[] rowData = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    rowData[i - 1] = resultSet.getObject(i);
                }
                ((DefaultTableModel) table.getModel()).addRow(rowData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private JButton createBackButton() {
        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        btnBack.setBounds(390, 400, 120, 30);
        btnBack.setBackground(Color.BLACK);
        btnBack.setForeground(Color.WHITE);
        return btnBack;
    }
}
