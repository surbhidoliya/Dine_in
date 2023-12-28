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

public class cuisine extends JFrame {

    Pdemo f1;

    cuisine() {
        super.setTitle("cuisine Page");
        setBounds(100, 100, 950, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        f1 = new Pdemo();
        add(f1);
    }

    public static void main(String[] args) {
        cuisine f1 = new cuisine();
        f1.setVisible(true);
        f1.setDefaultCloseOperation(f1.EXIT_ON_CLOSE);
    }
}

class Pdemo extends JPanel implements ActionListener {

    ImageIcon img1, img2, img3, img4, img5;
    Image bg1;
    JButton b1, b2, b3, b4, b5;
    JLabel l1, l2;

    Pdemo() {
        setLayout(null);
        Font f = new Font("Georgia", Font.BOLD, 40);

        img1 = new ImageIcon(ClassLoader.getSystemResource("foodos/image/bg_cuisine.jpg"));
        img2 = new ImageIcon(ClassLoader.getSystemResource("foodos/image/south_ind.jpg"));
        img3 = new ImageIcon(ClassLoader.getSystemResource("foodos/image/punjabi.jpg"));
        img4 = new ImageIcon(ClassLoader.getSystemResource("foodos/image/chinese.jpg"));
        img5 = new ImageIcon(ClassLoader.getSystemResource("foodos/image/italian.jpg"));

        bg1 = img1.getImage();

        l1 = new JLabel(login.name);
        l1.setFont(f);
        l1.setHorizontalAlignment(SwingConstants.CENTER);
        l1.setBounds(275, 80, 350, 50);
        add(l1);
        l2 = new JLabel("Welcome");
        l2.setFont(f);
        l2.setBounds(350, 30, 200, 50);
        add(l2);

        Image img100 = img2.getImage();
        Image newimg100 = img100.getScaledInstance(150, 60, java.awt.Image.SCALE_SMOOTH);
        img2 = new ImageIcon(newimg100);

        b1 = new JButton(img2);
        b1.setBounds(40, 420, 150, 60);
        b1.setForeground(Color.red);
        b1.setBackground(Color.black);
        add(b1);
        b1.addActionListener(this);

        Image img101 = img3.getImage();
        Image newimg101 = img101.getScaledInstance(150, 60, java.awt.Image.SCALE_SMOOTH);
        img3 = new ImageIcon(newimg101);

        b2 = new JButton(img3);
        b2.setBounds(270, 420, 150, 60);
        b2.setForeground(Color.red);
        b2.setBackground(Color.black);
        add(b2);
        b2.addActionListener(this);

        Image img102 = img4.getImage();
        Image newimg102 = img102.getScaledInstance(150, 60, java.awt.Image.SCALE_SMOOTH);
        img4 = new ImageIcon(newimg102);

        b3 = new JButton(img4);
        b3.setBounds(500, 420, 150, 60);
        b3.setForeground(Color.red);
        b3.setBackground(Color.black);
        b3.addActionListener(this);
        add(b3);

        Image img103 = img5.getImage();
        Image newimg103 = img103.getScaledInstance(150, 60, java.awt.Image.SCALE_SMOOTH);
        img5 = new ImageIcon(newimg103);

        b4 = new JButton(img5);
        b4.setBounds(730, 420, 150, 60);
        b4.setForeground(Color.red);
        b4.setBackground(Color.black);
        b4.addActionListener(this);
        add(b4);

        Border border = BorderFactory.createLineBorder(new Color(235, 235, 235));

        b5 = new JButton("Cart");
        b5.setFont(new Font("Georgia", Font.BOLD, 20));
        b5.setBounds(840, 15, 70, 30);
        b5.setForeground(new Color(84, 52, 35));
        b5.setBackground(new Color(235, 235, 235));
        b5.addActionListener(this);
        b5.setBorder(border);
        add(b5);

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bg1, 0, 0, this.getWidth(), this.getHeight(), null);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            cuisine f1 = (cuisine) SwingUtilities.getWindowAncestor(this);
            f1.dispose(); // Close the current frame

            // Open another class here
            south_ind f2 = new south_ind();
            f2.setVisible(true);

        }
        if (e.getSource() == b2) {
            cuisine f1 = (cuisine) SwingUtilities.getWindowAncestor(this);
            f1.dispose(); // Close the current frame

            // Open another class here
            punjabi f2 = new punjabi();
            f2.setVisible(true);
        }

        if (e.getSource() == b3) {
            cuisine f1 = (cuisine) SwingUtilities.getWindowAncestor(this);
            f1.dispose(); // Close the current frame

            // Open another class here
            chinese f2 = new chinese();
            f2.setVisible(true);

        }
        if (e.getSource() == b4) {
            cuisine f1 = (cuisine) SwingUtilities.getWindowAncestor(this);
            f1.dispose(); // Close the current frame

            // Open another class here
            italian f2 = new italian();
            f2.setVisible(true);

        }
        if (e.getSource() == b5) {
            FetchCart ft = new FetchCart();
            login.totalItem = ft.getTotalItems(login.cart);
            ft.fetchCartDetails(login.cart);
            ft.close();
            cuisine f1 = (cuisine) SwingUtilities.getWindowAncestor(this);
            f1.dispose(); // Close the current frame

            // Open another class here
            cart f2 = new cart();
            f2.setVisible(true);

        }
    }
}
