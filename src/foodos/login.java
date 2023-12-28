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


public class login extends JFrame{
        P4demo f1;
        static String name,mobile,cart;
        static int table,orderId,totalItem;        
    login(){
            super.setTitle("Customer Details");
            setBounds(100, 100, 950, 600);
        setResizable(false);
        setLocationRelativeTo(null);            
            f1 = new P4demo();
            add(f1);
    }
    public static void main(String[] args){
        login f1=new login();
        f1.setVisible(true);
        f1.setDefaultCloseOperation(f1.EXIT_ON_CLOSE);
    }

}
class P4demo extends JPanel implements ActionListener{
      ImageIcon img1,img2,img3,img4;
      Image bg1;
        JButton b1;
        JLabel l1,l2,l3,l4,l5,l6,l7;     
        JTextField t1,t2;

      P4demo(){
          setLayout(null);
		  Font f=new Font("Georgia",Font.BOLD,11);
         
                  img1 = new ImageIcon(ClassLoader.getSystemResource("foodos/image/login.jpg"));
		  img2 = new ImageIcon(ClassLoader.getSystemResource("foodos/image/OurLogo1.jpg"));
		  img3 = new ImageIcon(ClassLoader.getSystemResource("foodos/image/hii.jpg"));
		  //img4 = new ImageIcon("image/chinese.jpg");
		  
          bg1 = img1.getImage();
          
          Border border = BorderFactory.createLineBorder(new Color(235,235,235));
          
	
    Image img100 = img2.getImage() ;  
   Image newimg100 = img100.getScaledInstance( 372,160,  java.awt.Image.SCALE_SMOOTH ) ;  
   img2 = new ImageIcon( newimg100 );
   
    Image img101 = img3.getImage() ;  
   Image newimg101 = img101.getScaledInstance( 162,90,  java.awt.Image.SCALE_SMOOTH ) ;  
   img3 = new ImageIcon( newimg101 );
   
   
                l3=new JLabel(img2);
                l3.setBounds(0,0,372,160);
                add(l3);

                l4=new JLabel(img3);
                l4.setBounds(0,160,162,90);
                add(l4);
                
   
                l1=new JLabel("Your Good Name");
                l1.setBounds(20,250,150,60);
                l1.setFont(f);
                add(l1);
                
                t1=new JTextField(20);
                t1.setBounds(20,300, 250, 25);
                add(t1);
                
                l2=new JLabel("Mobile No.");
                l2.setBounds(20,340,150,50);
                l2.setFont(f);
                add(l2);

                t2=new JTextField(20);
                t2.setBounds(20,380, 250, 25);
                add(t2);
                
		b1=new JButton("Continue");
		b1.setBounds(20,450,100,30);
                b1.setFont(f);
		b1.setForeground(new Color(84,52,35));
		b1.setBackground(new Color(255,165,105));
		add(b1);
                b1.setBorder(border);
                b1.addActionListener(this);
                
                login.table=1;
                l5=new JLabel("Table No. 0"+login.table);
                l5.setBounds(260,540,100,20);
                l5.setFont(f);
                add(l5);

                l6=new JLabel("Enter Both name and Mobile");
                l6.setBounds(20, 500, 300, 30);
                l6.setForeground(Color.red);
                l6.setFont(f);
                
                l7=new JLabel("Enter valid Mobile No.");
                l7.setBounds(20, 500, 300, 30);
                l7.setForeground(Color.red);
                l7.setFont(f);
                
      }
      public void paintComponent(Graphics g){
          super.paintComponent(g);
          g.drawImage(bg1, 0, 0, this.getWidth(),this.getHeight(),null);
        }
      
      
      
          public void actionPerformed(ActionEvent e) {
              if(e.getSource()==b1)
              {
        if (t1.getText()==null ||t1.getText().isEmpty() || t2.getText()==null || t2.getText().isEmpty()) 
        {
            add(l6);
            remove(l7);
            repaint();                
        }       
        else
        {

            remove(l6);
            repaint();
            login.name=t1.getText();
            login.mobile=t2.getText();
            if(login.mobile.length()==10)
            {
            remove(l7);
            repaint();                
            connReg con=new connReg();
            con.insert(login.name,login.mobile,login.table);
            login.orderId=con.getOrderId(login.name);
            System.out.println(login.orderId);
            con.close();
            
            CartTable ct=new CartTable();
            login.cart=ct.createTable(login.orderId);
            System.out.println(login.cart);
            ct.close();
            
            login f1 = (login) SwingUtilities.getWindowAncestor(this);
            f1.dispose(); // Close the current frame

            // Open another class here
            LoadingLogin f2 = new LoadingLogin();
            f2.setVisible(true);
            }
            else
            {
                add(l7);
                repaint();
            }
            
        }
       }
    }
}