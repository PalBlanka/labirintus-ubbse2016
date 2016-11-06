import java.awt.Color;
import java.awt.event.ActionEvent;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class NewWind {
	private JFrame frame1 = new JFrame();
	private JPanel fopanel = new JPanel();
	//hatteret tartalmazza
	private JPanel jPanel1 = new JPanel();
	//Fo menut tartalmazza
	private JPanel jPanel2 = new JPanel();
	//Quest menut tartalmazza
	private JPanel jPanel3 = new JPanel();
	//Login menut tartalmazza
	private JPanel jPanel4 = new JPanel();
	
	//bbe a alabelbe szurjuk be a buffered imaget
	 JLabel jLabelPic =  new JLabel();
	
	//Fõ menü
	JButton jButton1 = new JButton();
	JButton jButton2 = new JButton();
	JButton jButton3 = new JButton();
	
	//Quest
	JButton jButton4 = new JButton();
	JButton jButton5 = new JButton();
	JButton jButton6 = new JButton();
	JButton jButton7 = new JButton();
	
	//Login
	JTextField jTextField1 = new JTextField();
	JTextField jTextField2 = new JTextField();
	JButton jButton8 = new JButton();
	JButton jButton9 = new JButton();
	
	
	//ezzel egy üres képet készitünk, amire késõbb rátesszük a nekünk szükséges képet
	BufferedImage startImage = new BufferedImage(100,100,BufferedImage.TYPE_INT_ARGB);
	//Ez a link cimét fogja tartalmazni, ez csak azért kell nekünk, hogy ne keljen mindig a hosszú kolbászra hivatkozzunk.
	String linkName = "http://i.imgur.com/tksp0pk.png";
	

	//ez fogja a kezdõ ablakot kirajzolni
	public NewWind(){
		//létrehozunk egy új keretet
		frame1 = new JFrame();
		//keret cimének beálitása
		frame1.setTitle("Labirintus");
		//x, y, width, height(keret méretének beálitása)
		frame1.setBounds(500,100,405,430);
		//beálitjuk, hogy mikor x re kattintunk az ablak bezárodjon
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//igy barhova szurhatok be elemeket 
		frame1.setLayout(null);
		
		//itt betesszük az alappanelt, erre fog kerülni az összes többi
		//ezután csak a fopanelre tesszük a többi komponenst
		fopanel =(JPanel) frame1.getContentPane();
		
		//ez fogja tartalmazni a képet
		jPanel1= new JPanel();
		jPanel1.setBounds(0, 0, 390, 400);
		//itt is bekell állitani a setLayoutut nullra, annak érdekében, hogy kedvünk szerint mozgathassuk a komponenseket
		// ha nem állitjuk be, akkor õ fogja rendezni.
		jPanel1.setLayout(null);
		//Panel háttérszinének beálitása
		jPanel1.setBackground(Color.LIGHT_GRAY);
		
		//ez fogja tartalmazni a fõ menüt.
		jPanel2= new JPanel();
		jPanel2.setBounds(0, 0, 390, 400);
		jPanel2.setLayout(null);
		jPanel2.setBackground(Color.LIGHT_GRAY);
		
		
		//ez a panel tartalmazza a Quest menüt
		jPanel3= new JPanel();
		jPanel3.setBounds(0, 0, 390, 400);
		jPanel3.setLayout(null);
		jPanel3.setBackground(Color.LIGHT_GRAY);
		
		//ez a panel tartalmazza a Login menüt
		jPanel4= new JPanel();
		jPanel4.setBounds(0, 0, 390, 400);
		jPanel4.setLayout(null);
		jPanel4.setBackground(Color.LIGHT_GRAY);
				
		
		//A JLabel azért kell nekünk, mert ennek segitségével adhatunk háttér képet
		// a Label Iconja lesz a kép, és a setIcon parancsal álithatjuk be
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
		
		
		
	
		//gombok szövegének, illetve méretének beálitása
		//ez a kezdokepernyo gombjai
		jButton1 = new JButton("Login");
        jButton1.setBounds(120, 100, 150, 40);
       
        jButton2 = new JButton("Registration");
        jButton2.setBounds(120, 150, 150, 40);
        
        jButton3 = new JButton("Quest");
        jButton3.setBounds(120, 200, 150, 40);
        
        //komponensek egybefûzése a kezdo kepernyon
        jPanel2.add(jButton1);
		jPanel2.add(jButton2);
		jPanel2.add(jButton3);
        
		
		
		//gombok szövegének, illetve méretének beálitása
		//ez a quest kepernyo gombjai
		jButton4 = new JButton("Beginner");
		jButton4.setBounds(10, 100, 120, 30);
		       
		jButton5 = new JButton("Advanced");
		jButton5.setBounds(135, 100, 120, 30);
		        
		jButton6 = new JButton("Professional");
		jButton6.setBounds(260, 100, 120, 30);
		
		jButton7 = new JButton("Back");
		jButton7.setBounds(120, 200, 150, 40);
		        
		//komponensek egybefûzése a quest kepernyon
		jPanel3.add(jButton4);
		jPanel3.add(jButton5);
		jPanel3.add(jButton6);
		jPanel3.add(jButton7);
		
				
		//komponensek bealitas a Login menuben
		
		//itt kozepre helyezzuk a szoveget
		jTextField1 = new JTextField("User Name", SwingConstants.CENTER);
		jTextField1.setBounds(120, 100, 160, 30);
		
		jTextField2 = new JTextField("Password", SwingConstants.CENTER);
		jTextField2.setBounds(120, 140, 160, 30);
		
		
		
		jButton8 = new JButton("Back");
		jButton8.setBounds(40, 230, 150, 40);
		jButton9 = new JButton("Login");
		jButton9.setBounds(200, 230, 150, 40);
		
	
		jPanel4.add(jTextField1);
		jPanel4.add(jTextField2);
		jPanel4.add(jButton8);
		jPanel4.add(jButton9);
		
        fopanel.add(jPanel1);
       fopanel.add(jPanel2);
		jPanel1.add(jLabelPic);
		
		
		//a keret láthatóvá tétele
		frame1.setVisible(true);
	
		
		//Quest gomb lekezelese
		jButton3.addActionListener((ActionEvent e) -> {
			//eltavolitsuk a fõ menut tartalmazo panelt, s beszurjuk a guset menut tartalmazot
			fopanel.remove(jPanel2);
			fopanel.add(jPanel3);
			fopanel.revalidate();
			fopanel.repaint();
        });
		
		//Back gomb lekezelese a quest menu alatt
		jButton7.addActionListener((ActionEvent e) -> {
			//eltavolitsuk a quest menut tartalmazo panelt, s beszurjuk a fõ menut tartalmazot
			fopanel.remove(jPanel3);
			fopanel.add(jPanel2);
			fopanel.revalidate();
			fopanel.repaint();    
        });
		
		//Login gomb lekezelese
		jButton1.addActionListener((ActionEvent e) -> {
		//eltavolitsuk a fõ menut tartalmazo panelt, s beszurjuk a guset menut tartalmazot
		fopanel.remove(jPanel2);
		fopanel.add(jPanel4);
		fopanel.revalidate();
		fopanel.repaint();
		});
		
		//Login/Back gomb lekezelese
		jButton8.addActionListener((ActionEvent e) -> {
		//eltavolitsuk a fõ menut tartalmazo panelt, s beszurjuk a guset menut tartalmazot
		fopanel.remove(jPanel4);
		fopanel.add(jPanel2);
		fopanel.revalidate();
		fopanel.repaint();
		});
	}
	
	
}
