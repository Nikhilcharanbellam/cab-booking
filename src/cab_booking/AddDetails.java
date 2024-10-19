package cab_booking;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
public class AddDetails extends JFrame {
	private final JPanel contentPane;
	private JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9;	
        JComboBox comboBox;
        JRadioButton r1,r2;
		public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
                    try {
                        AddDetails frame;
                        frame = new AddDetails("");
                        frame.setVisible(true);
                    } catch (SQLException e) {
                    }
                });
	}
	public AddDetails(String username) throws SQLException {
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
		JLabel lblName = new JLabel("CUSTOMER DETAILS");
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
                r1 = new JRadioButton("Male");
                r1.setFont(new Font("Raleway", Font.BOLD, 14));
                r1.setBackground(Color.WHITE);
                r1.setBounds(271, 230, 80, 12);
                add(r1);
                r2 = new JRadioButton("Female");
                r2.setFont(new Font("Raleway", Font.BOLD, 14));
                r2.setBackground(Color.WHITE);
                r2.setBounds(350, 230, 100, 12);
		add(r2); 
                
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
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener((ActionEvent e) -> {
                ConnectionClass c = new ConnectionClass();
                String radio = null;                    
                    if(r1.isSelected()){
                        radio = "Male";
                    }
                    else if(r2.isSelected()){
                        radio = "Female";
                    }
String s4 = t4.getText();

t5 = new JTextField();
t5.setBounds(271, 270, 150, 20);
contentPane.add(t5);
t5.setColumns(10);

 try{
                    ConnectionClass cc = new ConnectionClass();
                    ResultSet rs = cc.stm.executeQuery("select * from signup where username = '"+username+"'");
                    while(rs.next()){
                        t7.setText(rs.getString("username"));  
                        t4.setText(rs.getString("name"));
                    }
 }                  catch (SQLException ex) {
                        Logger.getLogger(AddDetails.class.getName()).log(Level.SEVERE, null, ex);
                    }
		
                try{
                    
                        String s1=t1.getText();
                        String s2 = (String)comboBox.getSelectedItem();
                        String s3=t3.getText();
                      //  String s4=t4.getText();
                        String s5=radio;
                        String s6=t6.getText();
                        String s7=t7.getText();
                        String s8=t8.getText();
                        String s9=t9.getText();
                        String q1 = "insert into user_details values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"','"+s9+"')";
                        c.stm.executeUpdate(q1);
                    }catch(SQLException e1){   
                    }
                });
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener((ActionEvent e) -> {
                    setVisible(false);
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
}