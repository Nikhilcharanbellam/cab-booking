package cab_booking;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Font;
import javax.swing.JFrame;
public class About extends JFrame implements ActionListener {
    public About() {
        setLayout(null);       
        Font f = new Font("RALEWAY", Font.BOLD, 180);
        setFont(f);
        String s ="* Online Cab Booking System specializing in Hiring cabs to "
                + "customers. It is an online system through which customers "
                + "can view available cabs; register the cabs, view profile and "
                + "book cabs\n"
                + " * With the taxi booking system, consumers will be able to "
                + "make reservations online as well as make it easier and save time\n"
                + " * It allows users to book their cabs online, manage their bookings and "
                + "\n * It enhances business processes since it makes use of internet "
                + "technology to increase their profits."
                + "\n * The software acts as a 24/7 office due to its all-time availability."
                + "\nIt increases the efficiency of the system in offering quality "
                + "services to its customers."
                + "\n * It’s user-friendly as they can book cabs from the comfort of "
                + "their homes or offices.";
        TextArea t1 = new TextArea(s, 10, 40, Scrollbar.VERTICAL);
        t1.setEditable(false);
        t1.setBounds(20, 70, 1250, 500);
        add(t1);
        Font f1 = new Font("RALEWAY", Font.BOLD, 16);
        t1.setFont(f1);
        Container contentPane = this.getContentPane();
        t1 = new TextArea();
        JLabel l1 = new JLabel("About Project");
        add(l1);
        l1.setBounds(500, 10, 180, 80);
        l1.setForeground(Color.red);
        Font f2 = new Font("RALEWAY", Font.BOLD, 20);
        l1.setFont(f2);
        setBounds(0,75, 1800, 500);
        setLayout(null);
        setVisible(true);   
    }
    public void actionPerformed(ActionEvent e) {
        dispose();
    }
    public static void main(String args[]) {
        new About().setVisible(true);
    }
}