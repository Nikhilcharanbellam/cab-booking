package cab_booking;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Adminlogin  extends JFrame implements ActionListener
{
    JPanel panel;
    JFrame f;
    JLabel l1,l2,l3,l4,l5;
    JTextField tf1;
    JPasswordField p1;
    JButton b1,b2;
    Adminlogin()
    {
        f=new JFrame(" ADMIN LOGIN");
        f.setBackground(Color.black);
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
        
       l2=new JLabel("");
        l2.setBounds(190,30,200,50);
        l2.setFont(new Font("Airal",Font.BOLD,30));
        l2.setForeground(Color.pink);
        l1.add(l2);
        f.add(l1);
       
        l3=new JLabel("Username");
        l3.setBounds(40,40,100,30);
        l3.setFont(new Font("Airal",Font.BOLD,20));
        l3.setForeground(Color.green);
        l1.add(l3);
        
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
        
       
        l1.add(b1);
        
        b1.addActionListener(this);
        
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
                String q="SELECT * FROM admin_login WHERE username='" + name + "' AND password='" + pass + "'";
                ResultSet rs=obj.stm.executeQuery(q);
                if(rs.next())
                {
                    new Admin("").setVisible(true);
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
    }
         public static void main(String args[])
         {
             new Adminlogin();
         }
}