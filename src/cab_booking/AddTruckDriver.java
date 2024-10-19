/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cab_booking;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author nikhi
 */


public class AddTruckDriver extends JFrame {
    private JPanel contentPane;
	private JTextField t1,t2,t3,t4,t6,t7;
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
                    try {
                        AddTruckDriver frame;
                        frame = new AddTruckDriver("");
                        frame.setVisible(true);
                    } catch (SQLException e) {
                    }
                });
	}

	public AddTruckDriver(String username) throws SQLException {
		System.out.println(username);
                setBounds(75,75, 850, 550);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
                
                ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("cab_booking/images/cab1.png"));
                Image i3 = i1.getImage().getScaledInstance(450, 500,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel l1 = new JLabel(i2);
                l1.setBounds(400,20,450,420);
                add(l1);
		
		JLabel lblName = new JLabel("NEW TRUCK DRIVER");
		lblName.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
		lblName.setBounds(118, 11, 260, 53);
		contentPane.add(lblName);
                
                JLabel l3 = new JLabel("Drivername :");
		l3.setBounds(35, 100, 200, 14);
		contentPane.add(l3);
                
                t7 = new JTextField();
		t7.setBounds(271, 100, 150, 20);
		contentPane.add(t7);
		t7.setColumns(10);
                
                JLabel l2 = new JLabel("Distance :");
		l2.setBounds(35, 150, 200, 14);
		contentPane.add(l2);
                
                t1 = new JTextField();
		t1.setBounds(271, 150, 150, 20);
		contentPane.add(t1);
		t1.setColumns(10);
                
		
		JLabel lblName_1 = new JLabel("Truck :");
		lblName_1.setBounds(35, 200, 200, 14);
		contentPane.add(lblName_1);
		
		t2 = new JTextField();
		t2.setBounds(271, 200, 150, 20);
		contentPane.add(t2);
		t2.setColumns(10);

                
		JLabel lblCountry = new JLabel("Source :");
		lblCountry.setBounds(35, 250, 200, 14);
		contentPane.add(lblCountry);
                
                t3 = new JTextField();
		t3.setBounds(271, 250, 150, 20);
		contentPane.add(t3);
		t3.setColumns(10);
		
		
           	
		JLabel lblCheckInStatus = new JLabel("Destination :");
		lblCheckInStatus.setBounds(35, 300, 200, 14);
		contentPane.add(lblCheckInStatus);
                
                t6 = new JTextField();
		t6.setBounds(271, 300, 150, 20);
		contentPane.add(t6);
		t6.setColumns(10);
                
                
                JLabel lblDeposite = new JLabel("Price :");
		lblDeposite.setBounds(35, 350, 200, 14);
		contentPane.add(lblDeposite);
		
		t4 = new JTextField();
		t4.setBounds(271, 350, 150, 20);
		contentPane.add(t4);
		t4.setColumns(10);
                
		
		
                try{
                    ConnectionClass c = new ConnectionClass();
                    ResultSet rs = c.stm.executeQuery("select * from signup where username = '"+username+"'");
                    while(rs.next()){
                        t7.setText(rs.getString("username"));  
                        t2.setText(rs.getString("name"));
                    }
                }catch(SQLException e){ }
		
		

		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener((ActionEvent e) -> {
                    ConnectionClass c = new ConnectionClass();
                    
                    
                    try{
                        String s7 = t7.getText(); 
                        String s4 = t4.getText();
                        String s1 =  t1.getText();
                        String s2 =  t2.getText();
                        String s3 =  t3.getText();
                        
                        String s6 =  t6.getText();
                       
                        
                        String q1 = "insert into transport_trucks values('"+s3+"','"+s6+"','"+s7+"','"+s4+"','"+s2+"','"+s1+"')";
                        c.stm.executeUpdate(q1);
                        
                        JOptionPane.showMessageDialog(null, "Driver Added Successfully");
                        setVisible(false);
                    }catch(SQLException e1){
                        System.out.println(e1.getMessage());
                    }
                });
		btnNewButton.setBounds(100, 430, 120, 30);
                btnNewButton.setBackground(Color.BLACK);
                btnNewButton.setForeground(Color.WHITE);
		contentPane.add(btnNewButton);
		
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener((ActionEvent e) -> {
                    setVisible(false);
                }); 
		btnExit.setBounds(260, 430, 120, 30);
                btnExit.setBackground(Color.BLACK);
                btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);
                
                getContentPane().setBackground(Color.WHITE);
	}
}