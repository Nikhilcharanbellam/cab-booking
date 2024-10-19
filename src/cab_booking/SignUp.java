 
package cab_booking;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SignUp extends JFrame implements ActionListener 
{
    JFrame f;
    JLabel l1,l2,l3;
    JTextField tf1,tf2;
    JPasswordField p1;
    JButton b1,b2;
    SignUp()
    {
        f=new JFrame("CREATE NEW ACCOUNT ");
        f.setBackground(Color.GREEN);
        f.setLayout(null);
        
        l1=new JLabel("UserName");
        l1.setBounds(40,40,100,30);
        f.add(l1);
        
        l2=new JLabel("Name");
        l2.setBounds(40,80,100,30);
        f.add(l2);
        
        l3=new JLabel("Password");
        l3.setBounds(40,120,100,30);
        f.add(l3);
        
        tf1=new JTextField();
        tf1.setBounds(150,40,150,30);
        f.add(tf1);
        
        tf2=new JTextField();
        tf2.setBounds(150,80,150,30);
        f.add(tf2);
        
        
        p1=new JPasswordField();
        p1.setBounds(150,120,150,30);
        f.add(p1);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("cab_booking/images/login.png"));
        Image i2=i1.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l5=new JLabel(i3);
        l5.setBounds(350,70,150,150);
        f.add(l5);
        
        b1=new JButton("SignUp");
        b1.setBackground(Color.red);
        b1.setForeground(Color.BLACK);
        b1.setBounds(60, 200, 120, 30);
        
        b2=new JButton("Return");
        b2.setBackground(Color.red);
        b2.setForeground(Color.BLACK);
        b2.setBounds(200,200, 120, 30);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        f.add(b1);
        f.add(b2);
        
        f.getContentPane();
        
        f.setVisible(true);
        f.setSize(550,340);
        f.setLocation(300,100);
        
    }
    @Override
    public void actionPerformed(ActionEvent ee)
    {
        if(ee.getSource()==b1)
        {
            String username=tf1.getText();
            String name=tf2.getText();
            String password=p1.getText();
        try
        {
            ConnectionClass obj=new ConnectionClass();
            String q = "INSERT INTO signup (username,name, password) VALUES ('" + username + "','" + name + "', '" + password + "')";
            int a =obj.stm.executeUpdate(q);
            if(a==1)
            {
                JOptionPane.showMessageDialog(null,"Account created");
                this.setVisible(false);
                new Login();
            }
            else
            {
                 JOptionPane.showMessageDialog(null,"Fill all the details");
                this.setVisible(false);
                this.setVisible(true);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        if(ee.getSource()==b2)
        {
            this.f.setVisible(false);
            new Login();
        }
    }
    }
    public static void main(String args[])
    {
        new SignUp();
    }
}
