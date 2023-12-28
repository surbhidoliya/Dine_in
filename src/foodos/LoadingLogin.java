package foodos;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class LoadingLogin extends JFrame implements Runnable {

	private JPanel contentPane;
	private JProgressBar progressBar;
	Connection conn;
	int s;
	Thread th;

	public static void main(String[] args) {
            new LoadingLogin().setVisible(true);
            System.out.println("aa");
	}

	public void setUploading() {
            setVisible(false);
            th.start();
	}

	public void run() {
            try {
                for (int i = 0; i < 200; i++) {
                    s = s + 1;
                    int m = progressBar.getMaximum();
                    int v = progressBar.getValue();
                    if (v < m) {
                        progressBar.setValue(progressBar.getValue() + 1);
                    } else {
                        i = 201;
                        setVisible(false);
                        cuisine f2 = new cuisine();
                        f2.setVisible(true);  
                    }
                    Thread.sleep(25);
                }
            } catch (Exception e) {
		e.printStackTrace();
            }
	}

	public LoadingLogin() {
           
            super("Loading");
            th = new Thread((Runnable) this);

            setBounds(100, 100, 950, 600);
            contentPane = new JPanel();
            setContentPane(contentPane);
            contentPane.setLayout(null);
            
            ImageIcon  img2 = new ImageIcon(ClassLoader.getSystemResource("foodos/image/OurLogo1.jpg"));
            Image img100 = img2.getImage() ;  
            Image newimg100 = img100.getScaledInstance( 372,160,  java.awt.Image.SCALE_SMOOTH ) ;  
            img2 = new ImageIcon( newimg100 );
   
            JLabel l1 = new JLabel(img2);
            l1.setForeground(new Color(72, 209, 204));
            l1.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
            l1.setBounds(220, 50, 500, 100);
            contentPane.add(l1);
	
            progressBar = new JProgressBar();
            progressBar.setFont(new Font("Tahoma", Font.BOLD, 12));
            progressBar.setStringPainted(true);
            progressBar.setBounds(300, 250, 350, 30);
            contentPane.add(progressBar);

            JLabel lblNewLabel_2 = new JLabel("Please Wait....");
            lblNewLabel_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
            lblNewLabel_2.setForeground(new Color(160, 82, 45));
            lblNewLabel_2.setBounds(400, 300, 150, 20);
            contentPane.add(lblNewLabel_2);

            JPanel panel = new JPanel();
            panel.setBackground(Color.WHITE);
            panel.setBounds(0, 0, 950, 600);
            contentPane.add(panel);
                
            setUploading();
	}
}
