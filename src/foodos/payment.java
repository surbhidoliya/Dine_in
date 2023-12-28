package foodos;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class payment extends JFrame {

    PaymentPanel panel;

    public payment() {
        setTitle("Payment");
        setBounds(100, 100, 950, 600);
        panel = new PaymentPanel();
        add(panel);
    }

    public static void main(String[] args) {
        payment frame = new payment();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

    }
}

class PaymentPanel extends JPanel implements ActionListener {

    JButton b1, b2, b3, b4, b5;
    ImageIcon icon, icon1, icon2, icon3, icon4;
    Image bgImage;
    JFrame frame;
    JDialog statusPopup;
    Font f = new Font("Georgia", Font.BOLD, 13);

    PaymentPanel() {

        setLayout(null);

        icon = new ImageIcon(ClassLoader.getSystemResource("foodos/image/PaymentBG.jpg"));
        bgImage = icon.getImage();

        icon1 = new ImageIcon(ClassLoader.getSystemResource("foodos/image/card.png"));
        icon2 = new ImageIcon(ClassLoader.getSystemResource("foodos/image/phonepe.png"));
        icon3 = new ImageIcon(ClassLoader.getSystemResource("foodos/image/paytm.png"));
        icon4 = new ImageIcon(ClassLoader.getSystemResource("foodos/image/cash.png"));

        Image img100 = icon1.getImage();
        Image newimg100 = img100.getScaledInstance(150, 60, java.awt.Image.SCALE_SMOOTH);
        icon1 = new ImageIcon(newimg100);

        b1 = new JButton(icon1);
        b1.setBounds(40, 135, 240, 66);
        b1.setHorizontalAlignment(SwingConstants.CENTER);
        b1.setOpaque(false);
        b1.setBackground(new Color(0, 0, 0, 0));
        b1.setBorderPainted(false);
        add(b1);
        b1.addActionListener(this);

        b2 = new JButton(icon2);
        b2.setBounds(300, 135, 240, 66);
        b2.setHorizontalAlignment(SwingConstants.CENTER);
        b2.setOpaque(false);
        b2.setBackground(new Color(0, 0, 0, 0));
        b2.setBorderPainted(false);
        add(b2);
        b2.addActionListener(this);

        b3 = new JButton(icon3);
        b3.setBounds(40, 290, 240, 66);
        b3.setHorizontalAlignment(SwingConstants.CENTER);
        b3.setOpaque(false);
        b3.setBackground(new Color(0, 0, 0, 0));
        b3.setBorderPainted(false);
        add(b3);
        b3.addActionListener(this);

        Image img101 = icon4.getImage();
        Image newimg101 = img101.getScaledInstance(150, 60, java.awt.Image.SCALE_SMOOTH);
        icon4 = new ImageIcon(newimg101);

        b4 = new JButton(icon4);
        b4.setBounds(300, 290, 240, 66);
        b4.setHorizontalAlignment(SwingConstants.CENTER);
        b4.setOpaque(false);
        b4.setBackground(new Color(0, 0, 0, 0));
        b4.setBorderPainted(false);
        add(b4);
        b4.addActionListener(this);

        b5 = new JButton("Back");
        b5.setBounds(820, 500, 100, 30);
        b5.setForeground(new Color(84, 52, 35));
        b5.setBackground(new Color(235, 235, 235));
        b5.setFont(f);
        b5.addActionListener(this);
        add(b5);

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bgImage, 0, 0, this.getWidth(), this.getHeight(), null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == b1) {

            frame = new JFrame();
            frame.setSize(950, 600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            statusPopup = new JDialog(frame, "Payment Status", true);
            statusPopup.setSize(550, 250);
            statusPopup.setLocationRelativeTo(null);
            JPanel panel = new JPanel();
            panel.setLayout(null);
            JLabel label1 = new JLabel("CardHolder Name");
            label1.setForeground(new Color(84, 52, 35));
            label1.setBackground(new Color(235, 235, 235));
            label1.setBounds(20, 20, 200, 20);
            label1.setHorizontalAlignment(SwingConstants.CENTER);
            label1.setFont(new Font("Arial", Font.BOLD, 15));
            panel.add(label1);

            JTextField j1 = new JTextField();
            j1.setBounds(240, 20, 250, 20);
            panel.add(j1);

            JLabel label2 = new JLabel("Card Number");
            label2.setForeground(new Color(84, 52, 35));
            label2.setBackground(new Color(235, 235, 235));
            label2.setBounds(20, 50, 170, 20);
            label2.setHorizontalAlignment(SwingConstants.CENTER);
            label2.setFont(new Font("Arial", Font.BOLD, 15));
            panel.add(label2);

            JTextField j2 = new JTextField();
            j2.setBounds(240, 50, 250, 20);
            panel.add(j2);

            JLabel label3 = new JLabel("Expiry Date");
            label3.setForeground(new Color(84, 52, 35));
            label3.setBackground(new Color(235, 235, 235));
            label3.setBounds(20, 80, 160, 20);
            label3.setHorizontalAlignment(SwingConstants.CENTER);
            label3.setFont(new Font("Arial", Font.BOLD, 15));
            panel.add(label3);

            JTextField j3 = new JTextField();
            j3.setBounds(240, 80, 50, 20);
            panel.add(j3);

            JLabel label4 = new JLabel("CVV");
            label4.setForeground(new Color(84, 52, 35));
            label4.setBackground(new Color(235, 235, 235));
            label4.setBounds(20, 110, 110, 20);
            label4.setHorizontalAlignment(SwingConstants.CENTER);
            label4.setFont(new Font("Arial", Font.BOLD, 15));
            panel.add(label4);

            JTextField j4 = new JTextField();
            j4.setBounds(240, 110, 50, 20);
            panel.add(j4);

            JButton b = new JButton("Done");
            b.setBounds(245, 150, 100, 30);
            b.setHorizontalAlignment(SwingConstants.CENTER);
            b.setFont(new Font("Arial", Font.PLAIN, 30));
            b.setOpaque(false);
            b.setForeground(new Color(84, 52, 35));
            b.setBackground(new Color(235, 235, 235));
            b.setBorder(new LineBorder(Color.BLACK));
            panel.add(b);
            b.addActionListener(this);
            statusPopup.getContentPane().add(panel);
            statusPopup.setVisible(true);

        } else if (e.getSource() == b2 || e.getSource() == b3) {

            frame = new JFrame();
            frame.setSize(950, 600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            statusPopup = new JDialog(frame, "Payment Status", true);
            statusPopup.setSize(600, 300);
            statusPopup.setLocationRelativeTo(null);
            JPanel panel = new JPanel();
            panel.setLayout(null);
            JLabel label1 = new JLabel("Scan QR Code");
            label1.setFont(f);
            label1.setForeground(new Color(84, 52, 35));
            label1.setBackground(new Color(235, 235, 235));
            label1.setBounds(150, 145, 300, 50);
            label1.setHorizontalAlignment(SwingConstants.CENTER);
            label1.setFont(new Font("Arial", Font.BOLD, 30));
            //label1.setBorder(new LineBorder(Color.BLACK));
            panel.add(label1);
            ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("foodos/image/qr.png"));

            Image img100 = icon.getImage();
            Image newimg100 = img100.getScaledInstance(130, 130, java.awt.Image.SCALE_SMOOTH);
            icon = new ImageIcon(newimg100);

            JLabel label2 = new JLabel(icon);
            label2.setBounds(240, 15, 130, 130);
            label2.setHorizontalAlignment(SwingConstants.CENTER);
            label2.setOpaque(false);
            label2.setBackground(new Color(0, 0, 0, 0));
            panel.add(label2);
            JButton b = new JButton("Done");
            b.setBounds(245, 210, 100, 30);
            b.setHorizontalAlignment(SwingConstants.CENTER);
            b.setFont(new Font("Arial", Font.PLAIN, 30));
            b.setOpaque(false);
            b.setForeground(new Color(84, 52, 35));
            b.setBackground(new Color(235, 235, 235));
            b.setBorder(new LineBorder(Color.BLACK));
            panel.add(b);
            b.addActionListener(this);
            statusPopup.getContentPane().add(panel);
            statusPopup.setVisible(true);
        } else if (e.getSource() == b4) {

            frame = new JFrame();
            frame.setSize(950, 600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            statusPopup = new JDialog(frame, "Payment Status", true);
            statusPopup.setSize(600, 300);
            statusPopup.setLocationRelativeTo(null);
            JPanel panel = new JPanel();
            panel.setLayout(null);
            JLabel label1 = new JLabel("Pay At Counter");
            label1.setBounds(140, 115, 300, 50);
            label1.setHorizontalAlignment(SwingConstants.CENTER);
            label1.setFont(new Font("Arial", Font.BOLD, 30));
            //label1.setBorder(new LineBorder(Color.BLACK));
            panel.add(label1);
            ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("foodos/image/cash.png"));

            Image img100 = icon.getImage();
            Image newimg100 = img100.getScaledInstance(150, 60, java.awt.Image.SCALE_SMOOTH);
            icon = new ImageIcon(newimg100);

            JLabel label2 = new JLabel(icon);
            label2.setBounds(180, 25, 240, 66);
            label2.setHorizontalAlignment(SwingConstants.CENTER);
            label2.setOpaque(false);
            label2.setBackground(new Color(0, 0, 0, 0));
            panel.add(label2);
            JButton b = new JButton("Done");
            b.setBounds(215, 180, 150, 50);
            b.setHorizontalAlignment(SwingConstants.CENTER);
            b.setFont(new Font("Arial", Font.PLAIN, 30));
            b.setOpaque(false);
            b.setBackground(new Color(0, 0, 0, 0));
            b.setBorder(new LineBorder(Color.BLACK));
            panel.add(b);
            b.addActionListener(this);
            statusPopup.getContentPane().add(panel);
            statusPopup.setVisible(true);
        } else if (e.getSource() instanceof JButton && ((JButton) e.getSource()).getText().equals("Done")) {
            // Code for the "Done" button in the payment status dialog
            statusPopup.setVisible(false);
            payment f1 = (payment) SwingUtilities.getWindowAncestor(this);
            f1.dispose(); // Close the current frame

            // Open another class here
         FetchCart ft=new FetchCart();
         login.totalItem=ft.getTotalItems(login.cart);
         ft.fetchCartDetails(login.cart);
         ft.close();
            timer f2 = new timer();
            f2.setVisible(true);
        } else if (e.getSource() == b5) {
            payment f1 = (payment) SwingUtilities.getWindowAncestor(this);
            f1.dispose(); // Close the current frame

            // Open another class here
            cuisine f2 = new cuisine();
            f2.setVisible(true);
        }
    }
}
