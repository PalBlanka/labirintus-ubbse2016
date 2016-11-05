import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NewWind {
	private JFrame frame1 = new JFrame();
	private JPanel fopanel = new JPanel();
	private JPanel jPanel1 = new JPanel();
	
	//bbe a alabelbe szurjuk be a buffered imaget
	 JLabel jLabelPic =  new JLabel();
	
	JButton jButton1 = new JButton();
	JButton jButton2 = new JButton();
	JButton jButton3 = new JButton();
	
	BufferedImage startImage = new BufferedImage(100,100,BufferedImage.TYPE_INT_ARGB);;
	String linkName = "http://i.imgur.com/tksp0pk.png";
	

	
	public NewWind(){
		frame1 = new JFrame();
		frame1.setTitle("Labirintus");
		//x, y, width, height
		frame1.setBounds(500,100,405,430);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//igy barhova szurhatok be elemeket 
		frame1.setLayout(null);
		
		fopanel =(JPanel) frame1.getContentPane();
		fopanel.setBackground(Color.WHITE);
		
		jPanel1= new JPanel();
		jPanel1.setBounds(0, 0, 390, 400);
		jPanel1.setLayout(null);
		jPanel1.setBackground(Color.LIGHT_GRAY);
		
		
		//uploadImageFromUrl();
		jLabelPic = new JLabel();
		
		
		//itt adjuk hozza az url alapjan a kepet
		URL url1;
		try {
			url1 = new URL(linkName);
			 startImage = ImageIO.read(url1);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
		
		jLabelPic.setIcon(new ImageIcon(startImage));
		jLabelPic.setBounds(0, 0,390,400);
		
		
		
	
		
		jButton1 = new JButton("Login");
        jButton1.setBounds(120, 100, 150, 40);
       
        jButton2 = new JButton("Registration");
        jButton2.setBounds(120, 150, 150, 40);
        
        jButton3 = new JButton("Quest");
        jButton3.setBounds(120, 200, 150, 40);
        
        jPanel1.add(jButton1);
		jPanel1.add(jButton2);
		jPanel1.add(jButton3);
        
        fopanel.add(jPanel1);
		jPanel1.add(jLabelPic);
		
		
		
		frame1.setVisible(true);
	}
	
	
}
