
package cab_booking;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SecurityPassword  extends JFrame {
	Connection conn = null;
	PreparedStatement pst = null;
	private JPanel contentPane;
	private JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
	
		public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
                    try {
                        SecurityPassword frame;
                        frame = new SecurityPassword("");
                        frame.setVisible(true);
                    } catch (SQLException e) {
                    }
                });
	}

	public SecurityPassword(String username) throws SQLException {
		System.out.println(username);
                setBounds(75, 75, 850, 550);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
                
                ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("cab_booking/images/update.png"));
                Image i3 = i1.getImage().getScaledInstance(200, 400,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel l1 = new JLabel(i2);
                l1.setBounds(500,40,200,400);
                add(l1);
		
		JLabel lblName = new JLabel("ENTER SECURITY QUESTION");
		lblName.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
		lblName.setBounds(118, 11, 300, 53);
		contentPane.add(lblName);
                
                JLabel l3 = new JLabel("name :");
		l3.setBounds(35, 70, 200, 14);
		contentPane.add(l3);
                
                t1 = new JTextField();
		t1.setBounds(271, 70, 150, 20);
		contentPane.add(t1);
		t1.setColumns(10);
                
                JLabel lblId = new JLabel("Username :");
		lblId.setBounds(35, 110, 200, 14);
		contentPane.add(lblId);
                
                t2 = new JTextField();
		t2.setBounds(271, 110, 150, 20);
		contentPane.add(t2);
		t2.setColumns(10);
                
                JLabel l2 = new JLabel("Password :");
		l2.setBounds(35, 150, 200, 14);
		contentPane.add(l2);
                
                t3 = new JTextField();
		t3.setBounds(271, 150, 150, 20);
		contentPane.add(t3);
		t3.setColumns(10);
		
		JLabel lblName_1 = new JLabel("Question :");
		lblName_1.setBounds(35, 190, 200, 14);
		contentPane.add(lblName_1);
		
		t4 = new JTextField();
		t4.setBounds(271, 190, 150, 20);
		contentPane.add(t4);
		t4.setColumns(10);

                
		JLabel lblGender = new JLabel("Answer :");
		lblGender.setBounds(35, 230, 200, 14);
		contentPane.add(lblGender);
                
                t5 = new JTextField();
		t5.setBounds(271, 230, 150, 20);
		contentPane.add(t5);
		t5.setColumns(10);
                
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener((ActionEvent e) -> {
                ConnectionClass c = new ConnectionClass();
		
                try{
                    
                        String s1=t1.getText();  
                        String s2=t2.getText();
                        String s3=t3.getText();
                        String s4=t4.getText();
                        String s5=t5.getText();
                        String q1 = "insert into save_password values('"+s2+"','"+s1+"','"+s3+"','"+s4+"','"+s5+"')";
                        c.stm.executeUpdate(q1);
                        JOptionPane.showMessageDialog(null, "Password details updated Successfully");
                        setVisible(false);
                    }catch(SQLException e1){
                       
                    }
                });
     
		
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            setVisible(false);
			}
		}); 
		btnNewButton.setBounds(100, 430, 120, 30);
                btnNewButton.setBackground(Color.BLACK);
                btnNewButton.setForeground(Color.WHITE);
		contentPane.add(btnNewButton);
		
		JButton btNExit = new JButton("Back");
		btNExit.addActionListener((ActionEvent e) -> {
                    setVisible(false);
                }); 
		btNExit.setBounds(260, 430, 120, 30);
                btNExit.setBackground(Color.BLACK);
                btNExit.setForeground(Color.WHITE);
		contentPane.add(btNExit);
                
                getContentPane().setBackground(Color.WHITE);
	}

    SecurityPassword() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}   
