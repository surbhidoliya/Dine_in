package foodos;

import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.event.*;
import java.awt.*;

public class timer extends JFrame {
    TimerPanel panel;
    public timer() {
        super.setTitle("Order Details");
        setBounds(100,100,950, 600);
        setResizable(false);
        setLocationRelativeTo(null);        
        panel = new TimerPanel();
        add(panel);
        panel.start();
    }
        public static void main(String[] args){
        timer f1=new timer();
        f1.setVisible(true);
        f1.setDefaultCloseOperation(f1.EXIT_ON_CLOSE);
    }
}

class TimerPanel extends JPanel implements ActionListener {
    JLabel timerLabel, l1, l2;
    Timer timer;
    int secondsLeft;
    ImageIcon icon;
    Image bgImage;
    TimerPanel() {
        setLayout(null);

        icon = new ImageIcon(ClassLoader.getSystemResource("foodos/image/bgImage1.jpg"));
        bgImage = icon.getImage();

        l1 = new JLabel("Order No. : "+login.orderId);
        l1.setBounds(175, 0, 600, 50);
        l1.setFont(new Font("Arial", Font.PLAIN, 30));
        l1.setHorizontalAlignment(SwingConstants.CENTER);
        l1.setBorder(new LineBorder(Color.WHITE));
        l1.setForeground(Color.white);
        add(l1);

        l2 = new JLabel("Order Summary");
        l2.setBounds(175, 80, 600, 50);
        l2.setFont(new Font("Arial", Font.PLAIN, 30));
        l2.setHorizontalAlignment(SwingConstants.CENTER);
        l2.setBorder(new LineBorder(Color.WHITE));
        l2.setForeground(Color.white);
        add(l2);


        String[][] data = new String[login.totalItem][3];
        for (int i = 0; i <login.totalItem; i++) {
            data[i][0] =""+(i+1);
            data[i][1] = FetchCart.itemName[i];
            data[i][2] = ""+FetchCart.quantity[i];
        }

        String[] columnNames = {"Item No.","Item Name", "Quantity"};
        JTable table = new JTable(data, columnNames);
        table.setBounds(175, 130, 600, 200);
        table.setOpaque(false);
        table.setFont(new Font("Arial", Font.PLAIN, 20));
        table.setForeground(Color.WHITE);
        table.setBackground(new Color(0, 0, 0, 0));
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 20));
       // table.getTableHeader().setForeground(Color.WHITE);
        table.getTableHeader().setOpaque(false);
        table.getTableHeader().setBackground(new Color(0, 0, 0, 0));
        table.setRowHeight(30);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(175, 130, 600, 200);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        add(scrollPane);

        timerLabel = new JLabel("Your Food Will Arrive In 00:10");
        timerLabel.setBounds(175, 350, 600, 60);
        timerLabel.setFont(new Font("Arial", Font.PLAIN, 40));
        timerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        timerLabel.setBorder(new LineBorder(Color.WHITE));
        timerLabel.setForeground(Color.white);
        add(timerLabel);

        timer = new Timer(1000, this);
        int sec=300*login.totalItem;
        secondsLeft = 600;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(bgImage, 0, 0, this.getWidth(),this.getHeight(),null);
    }

    public void start() {
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (secondsLeft > 0) {
            secondsLeft--;
            int minutes = secondsLeft / 60;
            int seconds = secondsLeft % 60;
            timerLabel.setText(String.format("Your Food Will Arrive In %02d:%02d", minutes, seconds));
        } else {
            timer.stop();
        timer f1 = (timer) SwingUtilities.getWindowAncestor(this);
        f1.dispose(); // Close the current frame

        // Open another class here
        thankyou f2 = new thankyou();
        f2.setVisible(true);
            //JOptionPane.showMessageDialog(this, "Time's up!");
        }
    }
}
