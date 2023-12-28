/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodos;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.Border;

/**
 *
 * @author ayush mangal
 */
public class adminlogin extends JFrame {

    P444demo f1;
    static int totalcus;

    adminlogin() {
        super.setTitle("Admin LogIn");
        setBounds(100, 100, 950, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        f1 = new P444demo();
        add(f1);
    }

    public static void main(String[] args) {
        adminlogin f1 = new adminlogin();
        f1.setVisible(true);
        f1.setDefaultCloseOperation(f1.EXIT_ON_CLOSE);
    }

}

class P444demo extends JPanel implements ActionListener {

    JButton b1;
    JLabel l1, l2, l6, l7;
    JTextField t1, t2;

    P444demo() {
        setLayout(null);
        Font f = new Font("Georgia", Font.BOLD, 14);

        Border border = BorderFactory.createLineBorder(new Color(235, 235, 235));

        l1 = new JLabel("Admin Name");
        l1.setBounds(120, 140, 100, 40);
        l1.setFont(f);
        add(l1);

        t1 = new JTextField(20);
        t1.setBounds(250, 150, 150, 25);
        add(t1);

        l2 = new JLabel("Password");
        l2.setBounds(120, 210, 100, 40);
        l2.setFont(f);
        add(l2);

        t2 = new JTextField(20);
        t2.setBounds(250, 220, 150, 25);
        add(t2);

        b1 = new JButton("LogIn");
        b1.setBounds(200, 270, 100, 30);
        b1.setFont(f);
        b1.setForeground(new Color(84, 52, 35));
        b1.setBackground(new Color(255, 165, 105));
        add(b1);
        b1.setBorder(border);
        b1.addActionListener(this);

        l6 = new JLabel("Enter Both name and Password");
        l6.setBounds(200, 350, 300, 30);
        l6.setForeground(Color.red);
        l6.setFont(f);

        l7 = new JLabel("Enter valid name and Password");
        l7.setBounds(200, 350, 300, 30);
        l7.setForeground(Color.red);
        l7.setFont(f);

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            String s1 = t1.getText();
            String s2 = t2.getText();
            if (t1.getText() == null || t1.getText().isEmpty() || t2.getText() == null || t2.getText().isEmpty()) {
                add(l6);
                remove(l7);
                repaint();
            } else if (!s1.equals("surbhi") || !s2.equals("12345")) {
                add(l7);
                remove(l6);
                repaint();
            } else {

                remove(l6);
                remove(l7);
                repaint();

                adminlogin f1 = (adminlogin) SwingUtilities.getWindowAncestor(this);
                f1.dispose(); // Close the current frame

                fetchcus ft = new fetchcus();
                adminlogin.totalcus = ft.getCus();
                ft.fetchCustomer();
                ft.close();
                customer f2 = new customer();
                f2.setVisible(true);
            }
        }
    }
}
