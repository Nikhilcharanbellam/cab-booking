package cab_booking;
import java.awt.*;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.sql.*;	
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
public class UpdateCustomer extends JFrame {
        JComboBox comboBox;
      //  JRadioButton r1,r2;
	private JPanel contentPane;
        private String radio; 
	private JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateCustomer frame = new UpdateCustomer("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public UpdateCustomer(String username) throws SQLException {
		System.out.println(username);
                setBounds(500, 220, 850, 550);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null); 
                ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("cab_booking/images/update.png"));
                Image i3 = i1.getImage().getScaledInstance(200, 400,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel l1 = new JLabel(i2);
                l1.setBounds(500,40,200,400);
                add(l1);
		JLabel lblName = new JLabel("UPDATE CUSTOMER DETAILS");
		lblName.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
		lblName.setBounds(118, 11, 300, 53);
		contentPane.add(lblName);
                
                JLabel l3 = new JLabel("Username :");
		l3.setBounds(35, 70, 200, 14);
		contentPane.add(l3);
                
                t1 = new JTextField();
		t1.setBounds(271, 70, 150, 20);
		contentPane.add(t1);
		t1.setColumns(10);
                JLabel lblId = new JLabel("ID :");
		lblId.setBounds(35, 110, 200, 14);
		contentPane.add(lblId);
                comboBox = new JComboBox(new String[] {"Passport", "Aadhar Card", "Voter Id", "Driving license"});
		comboBox.setBounds(271, 110, 150, 20);
		contentPane.add(comboBox); 
                
                t2 = new JTextField();
		t2.setBounds(271, 110, 150, 20);
		contentPane.add(t2);
		t2.setColumns(10);
                
                JLabel l2 = new JLabel("Number :");
		l2.setBounds(35, 150, 200, 14);
		contentPane.add(l2);
                
                t3 = new JTextField();
		t3.setBounds(271, 150, 150, 20);
		contentPane.add(t3);
		t3.setColumns(10);
		
		JLabel lblName_1 = new JLabel("Name :");
		lblName_1.setBounds(35, 190, 200, 14);
		contentPane.add(lblName_1);
		
		t4 = new JTextField();
		t4.setBounds(271, 190, 150, 20);
		contentPane.add(t4);
		t4.setColumns(10);

                
		JLabel lblGender = new JLabel("Gender :");
		lblGender.setBounds(35, 230, 200, 14);
		contentPane.add(lblGender);
                JTextField genderTextField = new JTextField();
genderTextField.setBounds(271, 230, 150, 20);
contentPane.add(genderTextField);
             /*   r1 = new JRadioButton("Male");
                r1.setFont(new Font("Raleway", Font.BOLD, 14));
                r1.setBackground(Color.WHITE);
                r1.setBounds(271, 230, 80, 12);
                add(r1);
                r2 = new JRadioButton("Female");
                r2.setFont(new Font("Raleway", Font.BOLD, 14));
                r2.setBackground(Color.WHITE);
                r2.setBounds(350, 230, 100, 12);
		add(r2); */
                
                
		JLabel lblCountry = new JLabel("Country :");
		lblCountry.setBounds(35, 270, 200, 14);
		contentPane.add(lblCountry);
                
                t6 = new JTextField();
		t6.setBounds(271, 270, 150, 20);
		contentPane.add(t6);
		t6.setColumns(10);
		
		JLabel lblReserveRoomNumber = new JLabel("Permanent Address :");
		lblReserveRoomNumber.setBounds(35, 310, 200, 14);
		contentPane.add(lblReserveRoomNumber);
                
                t7 = new JTextField();
		t7.setBounds(271, 310, 150, 20);
		contentPane.add(t7);
		t7.setColumns(10);
           	
		JLabel lblCheckInStatus = new JLabel("Phone :");
		lblCheckInStatus.setBounds(35, 350, 200, 14);
		contentPane.add(lblCheckInStatus);
                
                t8 = new JTextField();
		t8.setBounds(271, 350, 150, 20);
		contentPane.add(t8);
		t8.setColumns(10);
		
		JLabel lblDeposite = new JLabel("Email :");
		lblDeposite.setBounds(35, 390, 200, 14);
		contentPane.add(lblDeposite);
		
		t9 = new JTextField();
		t9.setBounds(271, 390, 150, 20);
		contentPane.add(t9);
		t9.setColumns(10);
                
                t5 = new JTextField();
t5.setBounds(271, 270, 150, 20);
contentPane.add(t5);
t5.setColumns(10);

 /*               r1.addItemListener(new ItemListener() {
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == 1) {
            radio = "Male";
        }
    }
});

r2.addItemListener(new ItemListener() {
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == 1) {
            radio = "Female";
        }
    }
});*/
                try{
                    ConnectionClass c = new ConnectionClass();
                    ResultSet rs = c.stm.executeQuery("select * from customer where username = '"+username+"'");
                    if(rs.next()){
                        t1.setText(rs.getString(1)); 
                        comboBox.setSelectedItem(rs.getString(2));
                        //t2.setText(rs.getString(2));
                        t3.setText(rs.getString(3));  
                        t4.setText(rs.getString(4));
                        genderTextField.setText(rs.getString(5));  
                        t6.setText(rs.getString(6));
                        t7.setText(rs.getString(7));  
                        t8.setText(rs.getString(8));
                        t9.setText(rs.getString(9));
                    }
                }catch(Exception e){ }
                JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
                    private String radio;
			public void actionPerformed(ActionEvent e) {
                            ConnectionClass c = new ConnectionClass();
                           
                          
                            try{
                                ConnectionClass cc = new ConnectionClass();
                                ResultSet rs = cc.stm.executeQuery("select * from customer where username = '"+username+"'");
                                String s1 = t1.getText();
                                String se = (String)comboBox.getSelectedItem();
                                String s2 = t2.getText(); 
	    			String s3 =  t3.getText();
	    			String s4 =  t4.getText();
                                
                               String gender = genderTextField.getText();
                          /*     if ("Male".equals(gender)) {
                               r1.setSelected(true);
                               r2.setSelected(false);
                               } else if ("Female".equals(gender)) {
                                r1.setSelected(false);
                                r2.setSelected(true);
                                }else {
                                r1.setSelected(false);
                                r2.setSelected(false);
                                }*/
    
	    			String s6 =  t6.getText();
	    			String s7 =  t7.getText(); 
                                String s8 =  t8.getText();
                                String s9 = t9.getText(); 
                                
                                String q1 = "update customer set id_type = '" + se + "', number = '" + s3 + "', name = '" + s4
                    + "', gender = '" + gender + "', country = '" + s6 + "', address = '" + s7 + "', phone = '"
                    + s8 + "', email = '" + s9 + "' where username = '" + s1 + "'";
            c.stm.executeUpdate(q1);
                              //  String q1 = "update customer set id_type = '"+s2+"', number = '"+s3+"', name = '"+s4+"', gender = '"+s10+"', country = '"+s6+"', address = '"+s7+"', phone = '"+s8+"', email = '"+s9+"' where username = '"+s1+"'";
                                c.stm.executeUpdate(q1);
                                
	    			JOptionPane.showMessageDialog(null, "Customer Detail Updated Successfully");
                                setVisible(false);
	    		}catch(SQLException e1){
	    			System.out.println(e1.getMessage());
	    		}
		    		catch(NumberFormatException s){
		    			JOptionPane.showMessageDialog(null, "Please enter a valid Number");
			}
			}
		});
		btnNewButton.setBounds(100, 430, 120, 30);
                btnNewButton.setBackground(Color.BLACK);
                btnNewButton.setForeground(Color.WHITE);
		contentPane.add(btnNewButton);
		
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            setVisible(false);
			}
		}); 
		btnExit.setBounds(260, 430, 120, 30);
                btnExit.setBackground(Color.BLACK);
                btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);
                getContentPane().setBackground(Color.WHITE);
	}
}