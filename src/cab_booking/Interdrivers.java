package cab_booking;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Interdrivers extends JFrame {
    private JPanel contentPane;
    private JTable table;
    private JScrollPane scrollPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Interdrivers frame = new Interdrivers();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Interdrivers() throws SQLException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 220, 900, 680);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Heading label for the table
        JLabel lblHeading = new JLabel("Intercity Drivers");
        lblHeading.setFont(new Font("Tahoma", Font.BOLD, 24));  // Set font and size
        lblHeading.setBounds(20, 0, 250, 30);  // Set position and size
        contentPane.add(lblHeading);

        // Load and display images
        try {
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
        } catch (Exception e) {
            System.out.println("Image loading failed. Please check the image path.");
        }

        // Set up the table to display data
        table = new JTable();
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 50, 860, 350);  // Adjusted the y position
        contentPane.add(scrollPane);

        // Initialize the table model and populate it from the database
        DefaultTableModel model = new DefaultTableModel();
        table.setModel(model);

        // Set column headers
        model.addColumn("Source");
        model.addColumn("Destination");
        model.addColumn("Type");
        model.addColumn("Driver");
        model.addColumn("Price");
        model.addColumn("Car");

        // Load data from the database
        try {
            ConnectionClass c = new ConnectionClass();
            String displayDriversql = "SELECT source, destination, type, driver, price, car FROM intercitycabs";
            Statement stmt = c.stm;
            ResultSet rs = stmt.executeQuery(displayDriversql);

            // Get metadata to dynamically handle column count
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();

            // Iterate through the ResultSet and add data to the table model
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

        // Back button to close the frame
        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(e -> setVisible(false));
        btnBack.setBounds(390, 420, 120, 30);
        btnBack.setBackground(Color.BLACK);
        btnBack.setForeground(Color.WHITE);
        contentPane.add(btnBack);

        // Set background color
        getContentPane().setBackground(Color.WHITE);
    }
}
