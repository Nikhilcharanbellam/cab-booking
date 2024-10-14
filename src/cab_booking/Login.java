
package cab_booking;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
public class Login extends JFrame implements ActionListener
{
    JPanel panel;
    JFrame f;
    JLabel l1,l2,l3,l4,l5;
    JTextField tf1;
    JPasswordField p1;
    JButton b1,b2,b3;
    Login()
    {
        f=new JFrame("LOGIN");
        f.setBackground(Color.white);
        f.setLayout(null);
        
        l1=new JLabel();
        l1.setBounds(0,0,500,350);
        l1.setLayout(null);
        
    
        
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("cab_booking/images/login.png"));
        Image i1=img.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
        ImageIcon img1=new ImageIcon(i1);
        JLabel l2= new JLabel(img1);
        l2.setBounds(250,1,300,220);
        l1.add(l2); 
        
        l2=new JLabel("LOGIN");
        l2.setBounds(190,30,500,50);
        l2.setFont(new Font("Airal",Font.BOLD,30));
        l2.setForeground(Color.pink);
        l1.add(l2);
        f.add(l1);
        
        l3=new JLabel("Username");
        l3.setFont(new Font("Airal",Font.BOLD,20));
        l3.setForeground(Color.green);
        l1.add(l3);
        
        l3.setBounds(40,40,100,30);
        l4=new JLabel("Password");
        l4.setBounds(40,120,100,30);
        l4.setFont(new Font("Airal",Font.BOLD,20));
        l4.setForeground(Color.green);
        l1.add(l4);
        
        
        tf1=new JTextField();
        tf1.setBounds(150,40,150,30);
        l1.add(tf1);
        p1=new JPasswordField();
        p1.setBounds(150,120,150,30);
        l1.add(p1);
         b1=new JButton("Login");
        b1.setBackground(Color.red);
        b1.setForeground(Color.BLACK);
        b1.setBounds(60, 200, 120, 30);
        
         b2=new JButton("SignUp");
        b2.setBackground(Color.red);
        b2.setForeground(Color.BLACK);
        b2.setBounds(200, 200, 120, 30);
        
        b3=new JButton("Forgot password");
        b3.setBackground(Color.red);
        b3.setForeground(Color.BLACK);
        b3.setBounds(350, 200, 150, 30);
        
        l1.add(b1);
        l1.add(b2);
        l1.add(b3);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        
        f.setVisible(true);
        f.setSize(580,350);
        f.setLocation(300,100);
        f.setResizable(false);
    }
    public void actionPerformed(ActionEvent ee)
    {
        if(ee.getSource()==b1)
        {
            try
            {
                ConnectionClass obj=new ConnectionClass();
                String name=tf1.getText();
                String pass=p1.getText();
                String q="SELECT * FROM signup WHERE username='" + name + "' AND password='" + pass + "'";
                ResultSet rs=obj.stm.executeQuery(q);
                if(rs.next())
                {
                    new Home(name).setVisible(true);
                    f.setVisible(false);
                }
                else
                {
                   JOptionPane.showMessageDialog(null,"wrong username or password");
                   f.setVisible(false);
                   f.setVisible(true);
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        if(ee.getSource()==b2)
        {
            f.setVisible(false);
            new SignUp();
        }
        if(ee.getSource()==b3)
        {
             ForgotPassword f1 = new ForgotPassword();
             f1.setVisible(true);
        }
    }
         public static void main(String args[])
         {
             new Login();
         }
}