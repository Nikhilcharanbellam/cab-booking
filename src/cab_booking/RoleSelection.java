/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cab_booking;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
  

public class RoleSelection extends JFrame implements ActionListener {
    JButton adminButton, userButton;

    public RoleSelection() {
        super("Role Selection");
        setLayout(new GridLayout(2, 1));

        adminButton = new JButton("Admin Login");
        userButton = new JButton("User Login");

        adminButton.addActionListener(this);
        userButton.addActionListener(this);

        add(adminButton);
        add(userButton);

        setSize(300, 200);
        setLocationRelativeTo( null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == adminButton) {
            new Adminlogin().setVisible(true);
            dispose(); // Close the role selection window
        } else if (e.getSource() == userButton) {
            new Login().setVisible(true);
            dispose(); // Close the role selection window
        }
    }

    public static void main(String[] args) {
        new RoleSelection();
    }
}