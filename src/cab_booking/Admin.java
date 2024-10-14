package cab_booking;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Admin extends JFrame{
     String username;
     JButton logoutButton;
    public static void main(String[] args) {
        new Admin("").setVisible(true);
    }
    
    public Admin(String username)
    {
     this.username = username;
        setForeground(Color.CYAN);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("cab_booking/images/admin.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1500,768,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2); 
	JLabel NewLabel = new JLabel(i3);
	NewLabel.setBounds(0, 0, 1500, 700); 
        add(NewLabel);
        
    JMenuBar menuBar1 = new JMenuBar();
    setJMenuBar(menuBar1);
	
        JMenu m1 = new JMenu("CUSTOMER");
        m1.setForeground(Color.BLACK);
	menuBar1.add(m1);
    
    JMenuItem mi1 = new JMenuItem("ADD CUSTOMER");
    m1.add(mi1);
    
    JMenuItem mi3 = new JMenuItem("VIEW CUSTOMER DETAILS");
    m1.add(mi3);
    
    JMenuItem mi4 = new JMenuItem("DELETE CUSTOMER DETAILS");
    m1.add(mi4);
    
    JMenu m2 = new JMenu("ADD DRIVER");
    m1.setForeground(Color.BLACK);
    menuBar1.add(m2);
    
    JMenuItem mi2 = new JMenuItem("ADD intracity cab Driver");
    m2.add(mi2);
    
    JMenuItem mi5 = new JMenuItem("ADD intercity cab Driver");
    m2.add(mi5);
    
    JMenuItem mi6 = new JMenuItem("ADD Truck Driver");
    m2.add(mi6);
    
    JMenu m3 = new JMenu("DELETE DRIVER");
    m1.setForeground(Color.BLACK);
    menuBar1.add(m3);
    
    JMenuItem mi7 = new JMenuItem("DELETE intracity cab Driver");
    m3.add(mi7);
    
    JMenuItem mi8 = new JMenuItem("DELETE intercity cab Driver");
    m3.add(mi8);
    
    JMenuItem mi9 = new JMenuItem("DELETE Truck Driver");
    m3.add(mi9);
    
    JMenu m4 = new JMenu("DRIVERS");
    m1.setForeground(Color.BLACK);
    menuBar1.add(m4);
        
    JMenuItem mi10 = new JMenuItem("Intercity cab driers");
    m4.add(mi10);
    
    JMenuItem mi11 = new JMenuItem("Intracity cab drivers");
    m4.add(mi11);
    
    JMenuItem mi12 = new JMenuItem("Truck drivers");
    m4.add(mi12);
    
     JMenu m5 = new JMenu("BOOKINGS");
    m1.setForeground(Color.BLACK);
    menuBar1.add(m5);
        
    JMenuItem mi13 = new JMenuItem("Intercity cab driers");
    m5.add(mi13);
    
    JMenuItem mi14 = new JMenuItem("Intracity cab drivers");
    m5.add(mi14);
    
    JMenuItem mi15 = new JMenuItem("Truck drivers");
    m5.add(mi15);
    
    
       mi1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new AddCustomer(username).setVisible(true);
                }catch(Exception e ){}
            }
	}); 
       mi2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new AddintracityDriver(username).setVisible(true);
                }catch(Exception e ){}
            }
	});
       mi3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new ViewCustomerDetailsAdmin().setVisible(true);
                }catch(Exception e ){}
            }
	});
    
          mi4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new DeleteCustomer().setVisible(true);
                }catch(Exception e ){}
            }
	});
         
          
           mi5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new AddintercityDriver(username).setVisible(true);
                }catch(Exception e ){}
            }
	}); 
           
           mi6.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new AddTruckDriver(username).setVisible(true);
                }catch(Exception e ){}
            }
	}); 
        mi7.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new DeleteIntracitydriver().setVisible(true);
                }catch(Exception e ){}
            }
	}); 
        
        mi8.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new DeleteIntercityDriver().setVisible(true);
                }catch(Exception e ){}
            }
	}); 
        
        mi9.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new DeleteTruckDriver().setVisible(true);
                }catch(Exception e ){}
            }
	});
        
         mi10.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new Interdrivers().setVisible(true);
                }catch(Exception e ){}
            }
	});
         
          mi11.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new Intradrivers().setVisible(true);
                }catch(Exception e ){}
            }
	});
          
          
          
           mi12.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    Truckdrivers truckdriversInstance = new Truckdrivers();
                    truckdriversInstance.setVisible(true);
                }catch(Exception e ){}
            }
	});
           
           mi13.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    Intracabbokkings truckdriversInstance1 = new Intracabbokkings();
                    truckdriversInstance1.setVisible(true);
                }catch(Exception e ){}
            }
	});
           mi14.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    Intercabbookings truckdriversInstance2 = new Intercabbookings();
                    truckdriversInstance2.setVisible(true);
                }catch(Exception e ){}
            }
	});
           mi15.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    Truckbookings truckdriversInstance3 = new Truckbookings();
                    truckdriversInstance3.setVisible(true);
                }catch(Exception e ){}
            }
	});
         logoutButton = new JButton("Logout");
        logoutButton.setBounds(1180, 0, 120, 30);
        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(Admin.this, "Are you sure you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    new Login();
                    dispose();
                }
            }
        });
        add(logoutButton);
          setExtendedState(JFrame.MAXIMIZED_BOTH);
	setVisible(true);
        getContentPane().setBackground(Color.WHITE);
}
}