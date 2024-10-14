package cab_booking;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Home extends JFrame{
    JButton logoutButton;
    public static void main(String[] args) {
        new Home("username").setVisible(true);
    }
    public Home(String username) {
        super("Cab Booking System");
        setForeground(Color.CYAN); 
        setLayout(null); 
        logoutButton = new JButton("Logout");
        logoutButton.setBounds(1180, 0, 120, 30);
        logoutButton.addActionListener((ActionEvent e) -> {
            int option = JOptionPane.showConfirmDialog(Home.this,
           "Are you sure you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                new Login();
                dispose();
            }
        });
        add(logoutButton);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("cab_booking/images/user.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1920, 1080,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2); 
	JLabel NewLabel = new JLabel(i3);
	NewLabel.setBounds(0, 0, 1500, 700); 
        add(NewLabel);
        JLabel l1 = new JLabel("Cab Transpo");
	l1.setForeground(Color.WHITE);
        l1.setFont(new Font("Tahoma", Font.PLAIN, 55));
	l1.setBounds(780, 60, 1000, 100);
	NewLabel.add(l1);	
        JMenuBar menuBar = new JMenuBar();
	setJMenuBar(menuBar);	
        JMenu m1 = new JMenu("CUSTOMER PROFILE");
        m1.setForeground(Color.BLACK);
	menuBar.add(m1);	
        JMenuItem mi1 = new JMenuItem("ADD CUSTOMER DETAILS");
	m1.add(mi1); 
        JMenuItem mi2 = new JMenuItem("CUSTOMER PROFILE");
	m1.add(mi2);
        mi1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new AddDetails(username).setVisible(true);
                }catch(Exception e ){}
            }
	}); 
        mi2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new UpdateCustomer(username).setVisible(true);
                }catch(Exception e ){}
            }
	});
	JMenu m2 = new JMenu("BOOK INTRACITY CAB");
        m2.setForeground(Color.black);
	menuBar.add(m2);
        JMenuItem mi7 = new JMenuItem("BOOK CAB");
	m2.add(mi7);
        JMenuItem mi5 = new JMenuItem("VIEW BOOKED CAB");
	m2.add(mi5);
        mi7.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new BookCab(username).setVisible(true);
                }catch(Exception e ){}
            }
	});
        

	mi5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    ViewBookedCab viewBookedCab = new ViewBookedCab(username);
                    viewBookedCab.setVisible(true);
                    viewBookedCab.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                }catch(Exception e ){}
                
            }
	});
        
        
        JMenu m3 = new JMenu("BOOK INTERCITY CAB");
        m3.setForeground(Color.black);
	menuBar.add(m3);
        
        
        JMenuItem mi9 = new JMenuItem("BOOK CAB");
	m3.add(mi9);
        
        JMenuItem mi10 = new JMenuItem("VIEW BOOKED CAB");
	m3.add(mi10);
        
        
        
        
	mi9.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    BookInterCityCab bookInterCityCab = new BookInterCityCab(username);
                    bookInterCityCab.setVisible(true);
                    bookInterCityCab.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                }catch(Exception e ){}
            }
	});
        
        mi10.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new ViewInterCityBookedCab(username).setVisible(true);
                }catch(Exception e ){}
            }
	});
        
        JMenu m8 = new JMenu("TRANSPORT");
        m8.setForeground(Color.black);
	menuBar.add(m8);
        
        JMenuItem mi16 = new JMenuItem("BOOK PACKAGE");
	m8.add(mi16);
        
        JMenuItem mi17 = new JMenuItem("VIEW BOOKED PACKAGE");
	m8.add(mi17);
        
        mi16.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new Trucking(username).setVisible(true);
            }
	});
	mi17.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new ViewTruckingDetails(username).setVisible(true);
                }catch(Exception e ){}
            }
	});
        
        JMenu m9 = new JMenu("BILL");
        m9.setForeground(Color.black);
	menuBar.add(m9);
        
        JMenuItem mi18 = new JMenuItem("CHECK BILL");
	m9.add(mi18);
        
        mi18.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new CheckBill(username).setVisible(true);
                }catch(Exception e){ }
            }
	});
        
        
        JMenu m5 = new JMenu("PAYMENT");
        m5.setForeground(Color.black);
	menuBar.add(m5);
        
        JMenuItem mi12 = new JMenuItem("PAY THE PAYTM");
	m5.add(mi12);
        
        mi12.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new Payment().setVisible(true);
            }
	});
        
        JMenu m6 = new JMenu("UTILITY");
        m6.setForeground(Color.black);
	menuBar.add(m6);
        
        JMenuItem mi13 = new JMenuItem("NOTEPAD");
	m6.add(mi13);
        
        JMenuItem mi14 = new JMenuItem("CALCULATOR");
	m6.add(mi14);
        
        mi13.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    Runtime.getRuntime().exec("notepad.exe");
                }catch(Exception e){ }
            }
	});
        
        
        mi14.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    Runtime.getRuntime().exec("calc.exe");
                }catch(Exception e){ }
            }
	});
        
        JMenu m7 = new JMenu("ABOUT");
        m7.setForeground(Color.black);
	menuBar.add(m7);
        
        JMenuItem mi15 = new JMenuItem("ABOUT");
	m7.add(mi15);
        
        mi15.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new About().setVisible(true);
            }
	});
        
        JMenu m89 = new JMenu("PASSWORD");
        m89.setForeground(Color.black);
	menuBar.add(m89);
        

        JMenuItem mi88 = new JMenuItem("SAVE PASSWORD");
	m89.add(mi88);
        
        mi88.addActionListener((ActionEvent ae) -> {
            try {
                new SecurityPassword("username").setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        setExtendedState(JFrame.MAXIMIZED_BOTH);
	setVisible(true);
        getContentPane().setBackground(Color.WHITE);
    }
}
