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
public class italian extends JFrame{
        P3demo f1;
    italian(){
		super.setTitle("Italian");
                setBounds(100, 100, 950, 600);
        setResizable(false);
        setLocationRelativeTo(null);                
        f1 = new P3demo();
        add(f1);
    }
    public static void main(String[] args){
        italian f1=new italian();
        f1.setVisible(true);
        f1.setDefaultCloseOperation(f1.EXIT_ON_CLOSE);
    }
    
    
}
class P3demo extends JPanel implements ActionListener{
      ImageIcon img1,img2,img3,img4;
      Image bg1;
        JButton b0,b,b1,b2,b3,b4,b5,b6,b7;
        JLabel l;
        JLabel l1,l2,l3,l4,l5;
        int pizza,pasta,burger,fries,hotdog;
        String item;
    
     
      P3demo(){
          setLayout(null);
		  Font f=new Font("Georgia",Font.BOLD,13);
         
                  b=new JButton(" ");
                  b.setBounds(100,100,5,5);
                  add(b);
                  
                  img1 = new ImageIcon(ClassLoader.getSystemResource("foodos/image/south1_bg.jpg"));
		  img2 = new ImageIcon(ClassLoader.getSystemResource("foodos/image/italian.jpg"));
		  img3 = new ImageIcon("image/punjabi.jpg");
		  img4 = new ImageIcon("image/chinese.jpg");
		  
          bg1 = img1.getImage();
          
          Border border = BorderFactory.createLineBorder(new Color(235,235,235));
          
	
    Image img100 = img2.getImage() ;  
   Image newimg100 = img100.getScaledInstance( 150,60,  java.awt.Image.SCALE_SMOOTH ) ;  
   img2 = new ImageIcon( newimg100 );
   
   
                l=new JLabel(img2);
                l.setBounds(500,100,150,60);
                l.setFont(f);
                add(l);
                
                l1=new JLabel("200");
                l1.setBounds(650,170,50,50);
                l1.setFont(f);
                add(l1);
                b1=new JButton("Pizza");
		b1.setBounds(420,190,120,20);
		b1.setFont(f);
		b1.setForeground(Color.black);
		b1.setBackground(new Color(235,235,235));
                b1.setBorder(border);
		add(b1);
                b1.addActionListener(this);

                l2=new JLabel("160");
                l2.setBounds(650,210,50,50);
                l2.setFont(f);
                add(l2);
		b2=new JButton("Pasta");
		b2.setBounds(420,230,120,20);
		b2.setFont(f);
		b2.setForeground(Color.black);
		b2.setBackground(new Color(235,235,235));
                b2.setBorder(border);
		add(b2);
                b2.addActionListener(this);

                l3=new JLabel("150");
                l3.setBounds(650,250,50,50);
                l3.setFont(f);
                add(l3);
		b3=new JButton("Burger");
		b3.setBounds(420,270,120,20);
		b3.setFont(f);
		b3.setForeground(Color.black);
		b3.setBackground(new Color(235,235,235));
                b3.setBorder(border);
		add(b3);
                b3.addActionListener(this);
                
                l4=new JLabel("110");
                l4.setBounds(650,290,50,50);
                l4.setFont(f);
                add(l4);
                b4=new JButton("Hot Dogs");
		b4.setBounds(420,310,120,20);
		b4.setFont(f);
		b4.setForeground(Color.black);
		b4.setBackground(new Color(235,235,235));
                b4.setBorder(border);
		add(b4);
                b4.addActionListener(this);
                
                l5=new JLabel("70");
                l5.setBounds(650,330,50,50);
                l5.setFont(f);
                add(l5);
                b5=new JButton("Fries");
		b5.setBounds(420,350,120,20);
		b5.setFont(f);
		b5.setForeground(Color.black);
		b5.setBackground(new Color(235,235,235));
                b5.setBorder(border);
		add(b5);
                b5.addActionListener(this);
                
		
		b6=new JButton("Back");
		b6.setBounds(630,450,100,50);
                b6.setFont(f);
		b6.setForeground(new Color(84,52,35));
		b6.setBackground(new Color(235,235,235));
		add(b6);
                b6.setBorder(border);
                b6.addActionListener(this);
                
		b7=new JButton("Cart");
		b7.setBounds(430,450,100,50);
                b7.setFont(f);
		b7.setForeground(new Color(84,52,35));
		b7.setBackground(new Color(235,235,235));
		add(b7);
                b7.setBorder(border);
                b7.addActionListener(this);
                


		
      }
      public void paintComponent(Graphics g){
          super.paintComponent(g);
          g.drawImage(bg1, 0, 0, this.getWidth(),this.getHeight(),null);
      }
      
      public void actionPerformed(ActionEvent e) {
    if (e.getSource() == b6) {
        // Code for handling "Back" button event
        italian f1 = (italian) SwingUtilities.getWindowAncestor(this);
        f1.dispose(); // Close the current frame

        // Open another class here
        cuisine f2 = new cuisine();
        f2.setVisible(true);
    }
     if (e.getSource() == b7) {
         FetchCart ft=new FetchCart();
         login.totalItem=ft.getTotalItems(login.cart);
         ft.fetchCartDetails(login.cart);
         ft.close();
        italian f1 = (italian) SwingUtilities.getWindowAncestor(this);
        f1.dispose(); // Close the current frame

        // Open another class here
        cart f2 = new cart();
        f2.setVisible(true);         
        
     }
        if (e.getSource() == b1) {
            item = "Pizza";
            String input = JOptionPane.showInputDialog(this, "Enter quantity for " + item + ":");
            if (input != null && !input.isEmpty())
            {
                pizza = Integer.parseInt(input);
                ConnCart cc=new ConnCart();
                cc.insert(login.cart,item, pizza,200);
                cc.close();
            }
        } 
        if (e.getSource() == b2) {
            item = "Pasta";
            String input = JOptionPane.showInputDialog(this, "Enter quantity for " + item + ":");
            if (input != null && !input.isEmpty())
            {    
                pasta = Integer.parseInt(input);
                ConnCart cc=new ConnCart();
                cc.insert(login.cart,item, pasta,160);
                cc.close();
                
            }    
        } if (e.getSource() == b3) {
            item = "Burger";
            String input = JOptionPane.showInputDialog(this, "Enter quantity for " + item + ":");
            if (input != null && !input.isEmpty())
            {
                burger = Integer.parseInt(input);
                ConnCart cc=new ConnCart();
                cc.insert(login.cart,item, burger,150);
                cc.close();

            }    
        } if (e.getSource() == b4) {
            item = "Hot Dogs";
            String input = JOptionPane.showInputDialog(this, "Enter quantity for " + item + ":");
            if (input != null && !input.isEmpty())
            {    
                hotdog = Integer.parseInt(input);
                ConnCart cc=new ConnCart();
                cc.insert(login.cart,item, hotdog,110);
                cc.close();

            }    
        } if (e.getSource() == b5) {
            item = "Fries";
            String input = JOptionPane.showInputDialog(this, "Enter quantity for " + item + ":");
            if (input != null && !input.isEmpty())
            {
                fries = Integer.parseInt(input);
                ConnCart cc=new ConnCart();
                cc.insert(login.cart,item, fries,70);
                cc.close();
 
            }
        }
        
    }
}

