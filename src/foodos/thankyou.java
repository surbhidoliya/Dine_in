/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodos;

import javax.swing.*;
import javax.swing.JLabel;
import java.awt.*;
public class thankyou extends JFrame {
    TYPanel panel;
    thankyou() {
        setTitle("SAYAS CAFE");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100,100,950, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        panel = new TYPanel();
        add(panel);
    }
       public static void main(String[] args) {
        thankyou frame = new thankyou();
        frame.setVisible(true);
    } 
}

class TYPanel extends JPanel {
    ImageIcon bgIcon, fgIcon;
    Image bgImage;
    JLabel label;

    TYPanel() {
        setLayout(null);
        bgIcon = new ImageIcon(ClassLoader.getSystemResource("foodos/image/bgTY.jpg"));
        bgImage = bgIcon.getImage();

        fgIcon = new ImageIcon(ClassLoader.getSystemResource("foodos/image/ty.png"));

        label = new JLabel(fgIcon);
        label.setBounds(80, 50, 392, 490);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setOpaque(false);
        label.setBackground(new Color(0, 0, 0, 0));
        add(label);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bgImage, 0, 0, this.getWidth(), this.getHeight(), null);
    }
}

