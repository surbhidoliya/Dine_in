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


public class punjabi extends JFrame{
        P1demo f1;
    punjabi(){
		super.setTitle("Punjabi");
                setBounds(100, 100, 950, 600);
        setResizable(false);
        setLocationRelativeTo(null);                
        f1 = new P1demo();
        add(f1);
    }
    public static void main(String[] args){
        punjabi f1=new punjabi();
        f1.setVisible(true);
        f1.setDefaultCloseOperation(f1.EXIT_ON_CLOSE);
    }
    
    
}
class P1demo extends JPanel implements ActionListener{
      ImageIcon img1,img2,img3,img4;
      Image bg1;
        JButton b0,b,b1,b2,b3,b4,b5,b6,b7;
        JLabel l;
        JLabel l1,l2,l3,l4,l5;
        int chhole,Pyaaz,Paneer,ChholeKulcha,Daal;
        String item;    
        
     
      P1demo(){
          setLayout(null);
		  Font f=new Font("Georgia",Font.BOLD,13);
         
                  b=new JButton(" ");
                  b.setBounds(100,100,5,5);
                  add(b);
                  
                  img1 = new ImageIcon(ClassLoader.getSystemResource("foodos/image/south1_bg.jpg"));
		  img2 = new ImageIcon(ClassLoader.getSystemResource("foodos/image/punjabi.jpg"));
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
                
                l1=new JLabel("150");
                l1.setBounds(650,170,50,50);
                l1.setFont(f);
                add(l1);
                b1=new JButton("Chhole Bhature");
		b1.setBounds(420,190,120,20);
		b1.setFont(f);
		b1.setForeground(Color.black);
		b1.setBackground(new Color(235,235,235));
                b1.setBorder(border);
                b1.addActionListener(this);
                add(b1);

                l2=new JLabel("70");
                l2.setBounds(650,210,50,50);
                l2.setFont(f);
                add(l2);
		b2=new JButton("Pyaaz Paratha");
		b2.setBounds(420,230,120,20);
		b2.setFont(f);
		b2.setForeground(Color.black);
		b2.setBackground(new Color(235,235,235));
                b2.setBorder(border);
                b2.addActionListener(this);
                add(b2);

                l3=new JLabel("100");
                l3.setBounds(650,250,50,50);
                l3.setFont(f);
                add(l3);
		b3=new JButton("Paneer Paratha");
		b3.setBounds(420,270,120,20);
		b3.setFont(f);
		b3.setForeground(Color.black);
		b3.setBackground(new Color(235,235,235));
                b3.setBorder(border);
                b3.addActionListener(this);
                add(b3);
                
                l4=new JLabel("150");
                l4.setBounds(650,290,50,50);
                l4.setFont(f);
                add(l4);
                b4=new JButton("Chhole Kulcha");
		b4.setBounds(420,310,120,20);
		b4.setFont(f);
		b4.setForeground(Color.black);
		b4.setBackground(new Color(235,235,235));
                b4.setBorder(border);
                b4.addActionListener(this);
      		add(b4);

                l5=new JLabel("170");
                l5.setBounds(650,330,50,50);
                l5.setFont(f);
                add(l5);
                b5=new JButton("Daal Makhani");
		b5.setBounds(420,350,120,20);
		b5.setFont(f);
		b5.setForeground(Color.black);
		b5.setBackground(new Color(235,235,235));
                b5.setBorder(border);
                b5.addActionListener(this);                
		add(b5);
                
		
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
            punjabi f1 = (punjabi) SwingUtilities.getWindowAncestor(this);
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
            punjabi f1 = (punjabi) SwingUtilities.getWindowAncestor(this);
         f1.dispose(); // Close the current frame

        // Open another class here
        cart f2 = new cart();
        f2.setVisible(true); 

     }            
        if (e.getSource() == b1) {
            item = "Chhole Bhature";
            String input = JOptionPane.showInputDialog(this, "Enter quantity for " + item + ":");
            if (input != null && !input.isEmpty())
            {
                chhole = Integer.parseInt(input);
                ConnCart cc=new ConnCart();
                cc.insert(login.cart,item, chhole,150);
                cc.close();
            }
        } 
        if (e.getSource() == b2) {
            item = "Pyaaz Paratha";
            String input = JOptionPane.showInputDialog(this, "Enter quantity for " + item + ":");
            if (input != null && !input.isEmpty())
            {    
                Pyaaz = Integer.parseInt(input);
                ConnCart cc=new ConnCart();
                cc.insert(login.cart,item,Pyaaz,70);
                cc.close();
                
            }    
        } if (e.getSource() == b3) {
            item = "Paneer Paratha";
            String input = JOptionPane.showInputDialog(this, "Enter quantity for " + item + ":");
            if (input != null && !input.isEmpty())
            {
                Paneer = Integer.parseInt(input);
                ConnCart cc=new ConnCart();
                cc.insert(login.cart,item, Paneer,100);
                cc.close();

            }    
        } if (e.getSource() == b4) {
            item = "Chhole Kulcha";
            String input = JOptionPane.showInputDialog(this, "Enter quantity for " + item + ":");
            if (input != null && !input.isEmpty())
            {    
                ChholeKulcha = Integer.parseInt(input);
                ConnCart cc=new ConnCart();
                cc.insert(login.cart,item, ChholeKulcha,150);
                cc.close();

            }    
        } if (e.getSource() == b5) {
            item = "Daal Makhani";
            String input = JOptionPane.showInputDialog(this, "Enter quantity for " + item + ":");
            if (input != null && !input.isEmpty())
            {
                Daal = Integer.parseInt(input);
                ConnCart cc=new ConnCart();
                cc.insert(login.cart,item,Daal,170);
                cc.close();
 
            }
        }
            

        
    }
}