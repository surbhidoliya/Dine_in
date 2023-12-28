package foodos;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class FoodOS extends JFrame{
        P7demo f1;
    FoodOS(){
		super.setTitle("SAYAS CAFE");
                setBounds(100, 100, 950, 600);
        setResizable(false);
        setLocationRelativeTo(null);                
        f1 = new P7demo();
        add(f1);
    }
    public static void main(String[] args){
        FoodOS f1=new FoodOS();
        f1.setVisible(true);
        f1.setDefaultCloseOperation(f1.EXIT_ON_CLOSE);
    }
}
class P7demo extends JPanel implements ActionListener{
    
            ImageIcon img1;
            Image bg1;
            JButton b1,b2;
            JLabel l1;

          P7demo(){
          setLayout(null);
		  Font f=new Font("Harrington",Font.BOLD,60);
                  img1 = new ImageIcon(ClassLoader.getSystemResource("foodos/image/sa.png"));
                  bg1 = img1.getImage();

        l1=new JLabel("Welcome To");
        l1.setBounds(430,8,350,50);
        l1.setFont(f);
        add(l1);
        
        b1=new JButton("Click to Continue...");
        b1.setBounds(600,500,240,30);
        b1.setFont(new Font("Georgia",Font.BOLD,20));
        b1.setBackground(new Color(255,165,105));
        b1.setForeground(Color.BLACK);
        b1.addActionListener(this);
        add(b1);
        
        b2=new JButton("Admin");
        b2.setBounds(60,500,240,30);
        b2.setFont(new Font("Georgia",Font.BOLD,20));
        b2.setBackground(new Color(255,165,105));
        b2.setForeground(Color.BLACK);
        b2.addActionListener(this);
        add(b2);
                
        
          }

      public void paintComponent(Graphics g){
          super.paintComponent(g);
          g.drawImage(bg1, 0, 0, this.getWidth(),this.getHeight(),null);
      }
 
          
          
public void actionPerformed(ActionEvent e)
{
    if(e.getSource()==b1){
        FoodOS f1 = (FoodOS) SwingUtilities.getWindowAncestor(this);
        f1.dispose(); // Close the current frame

        // Open another class here
        login f2 = new login();
        f2.setVisible(true);
    }
    if(e.getSource()==b2){
        FoodOS f1 = (FoodOS) SwingUtilities.getWindowAncestor(this);
        f1.dispose(); // Close the current frame

        // Open another class here
        adminlogin f2 = new adminlogin();
        f2.setVisible(true);
    }
    
}
}
