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
	private JFrame foframe = new JFrame();
	private JPanel fopanel = new JPanel();
	//hatteret tartalmazza
	//Fo menut tartalmazza
	private JPanel fomenuPanel =new JPanel();
	//Quest menut tartalmazza
	private JPanel loginPanel = new JPanel();
	//Login menut tartalmazza
	private JPanel questPanel = new JPanel();
	//Register
	private JPanel registerPanel = new JPanel();
	
	//bbe a alabelbe szurjuk be a buffered imaget
	 JLabel jLabelPicFomenu =  new JLabel();
	 JLabel jLabelPicQuest =  new JLabel();
	 JLabel jLabelPicLogin =  new JLabel();
	 JLabel jLabelPicRegister =  new JLabel();
	 
	//Fõ menü
	JButton loginButton = new JButton();
	JButton registrationButton = new JButton();
	JButton questButton = new JButton();
	
	//Quest
	JButton jButton4 = new JButton();
	JButton jButton5 = new JButton();
	JButton jButton6 = new JButton();
	JButton jButton7 = new JButton();
	
	//Login
	JTextField jTextField1 = new JTextField();
	JTextField jTextField2 = new JTextField();
	JButton jButton8 = new JButton();
	JButton jButtonLoginLogin = new JButton();
	JLabel jLabelLoginUserName = new JLabel();
	JLabel jLabelLoginPassword = new JLabel();
	
	//Register
		JTextField jTextFieldRegisterUserName = new JTextField();
		JTextField jTextFieldRegisterEmail = new JTextField();
		JTextField jTextFieldRegisterPassword1 = new JTextField();
		JTextField jTextFieldRegisterPassword2 = new JTextField();
		JLabel jLabelRegistrationUserName = new JLabel();
		JLabel jLabelRegistrationEmail = new JLabel();
		JLabel jLabelRegisterPassword = new JLabel();
		JLabel jLabelRegisterPasswordAgain = new JLabel();
		JButton jButtonRegisterBack = new JButton();
		JButton jButtonRegisterAccept = new JButton();
	
	
	//ezzel egy üres képet készitünk, amire késõbb rátesszük a nekünk szükséges képet
	BufferedImage startImage = new BufferedImage(100,100,BufferedImage.TYPE_INT_ARGB);
	//Ez a link cimét fogja tartalmazni, ez csak azért kell nekünk, hogy ne keljen mindig a hosszú kolbászra hivatkozzunk.
	String linkName = "http://i.imgur.com/tksp0pk.png";
	

	//ez fogja a kezdõ ablakot kirajzolni
	public NewWind(){
		//létrehozunk egy új keretet
		foframe = new JFrame();
		//keret cimének beálitása
		foframe.setTitle("Labirintus");
		//x, y, width, height(keret méretének beálitása)
		foframe.setBounds(500,100,405,430);
		//beálitjuk, hogy mikor x re kattintunk az ablak bezárodjon
		foframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//igy barhova szurhatok be elemeket 
		foframe.setLayout(null);
		
		//itt betesszük az alappanelt, erre fog kerülni az összes többi
		//ezután csak a fopanelre tesszük a többi komponenst
		fopanel =(JPanel) foframe.getContentPane();
		
		
		//ez fogja tartalmazni a fõ menüt.
		fomenuPanel= new JPanel();
		fomenuPanel.setBounds(0, 0, 390, 400);
		fomenuPanel.setLayout(null);
		fomenuPanel.setBackground(Color.LIGHT_GRAY);
		
		
		//ez a panel tartalmazza a Quest menüt
		loginPanel= new JPanel();
		loginPanel.setBounds(0, 0, 390, 400);
		loginPanel.setLayout(null);
		loginPanel.setBackground(Color.LIGHT_GRAY);
		
		//ez a panel tartalmazza a Login menüt
		questPanel= new JPanel();
		questPanel.setBounds(0, 0, 390, 400);
		questPanel.setLayout(null);
		questPanel.setBackground(Color.LIGHT_GRAY);
		
		//ez a panel tartalmazza a Register menüt
		registerPanel= new JPanel();
		registerPanel.setBounds(0, 0, 390, 400);
		registerPanel.setLayout(null);
		registerPanel.setBackground(Color.LIGHT_GRAY);
				
		
		//A JLabel azért kell nekünk, mert ennek segitségével adhatunk háttér képet
		// a Label Iconja lesz a kép, és a setIcon parancsal álithatjuk be
		
		
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
       
		
		jLabelPicFomenu.setIcon(new ImageIcon(startImage));
		jLabelPicFomenu.setBounds(0, 0,390,400);
		
		jLabelPicQuest.setIcon(new ImageIcon(startImage));
		jLabelPicQuest.setBounds(0, 0,390,400);
		
		
		jLabelPicLogin.setIcon(new ImageIcon(startImage));
		jLabelPicLogin.setBounds(0, 0,390,400);
		
		jLabelPicRegister.setIcon(new ImageIcon(startImage));
		jLabelPicRegister.setBounds(0, 0,390,400);
		
		
	
		//gombok szövegének, illetve méretének beálitása
		//ez a kezdokepernyo gombjai
		loginButton = new JButton("Login");
		loginButton.setBounds(120, 100, 150, 40);
       
		registrationButton = new JButton("Registration");
		registrationButton.setBounds(120, 150, 150, 40);
        
		questButton = new JButton("Quest");
		questButton.setBounds(120, 200, 150, 40);
        
        //komponensek egybefûzése a kezdo kepernyon
        fomenuPanel.add(loginButton);
        fomenuPanel.add(registrationButton);
        fomenuPanel.add(questButton);
        fomenuPanel.add(jLabelPicFomenu);
        
		
		
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
		questPanel.add(jButton4);
		questPanel.add(jButton5);
		questPanel.add(jButton6);
		questPanel.add(jButton7);
		questPanel.add(jLabelPicQuest);
		
				
		//komponensek bealitas a Login menuben
		
		//itt kozepre helyezzuk a szoveget
		jTextField1 = new JTextField();
		jTextField1.setBounds(160, 100, 160, 30);
		
		jLabelLoginUserName =new JLabel("User Name", SwingConstants.CENTER);
		jLabelLoginUserName.setBounds(50, 100, 110, 30);
		jLabelLoginUserName.setForeground(Color.WHITE);
		
		jTextField2 = new JTextField();
		jTextField2.setBounds(160, 140, 160, 30);
		
		jLabelLoginPassword =new JLabel("Password", SwingConstants.CENTER);
		jLabelLoginPassword.setBounds(50, 140, 110, 30);
		jLabelLoginPassword.setForeground(Color.WHITE);
		
		jButton8 = new JButton("Back");
		jButton8.setBounds(40, 230, 150, 40);
		jButtonLoginLogin = new JButton("Login");
		jButtonLoginLogin.setBounds(200, 230, 150, 40);
		
	
		loginPanel.add(jTextField1);
		loginPanel.add(jTextField2);
		loginPanel.add(jLabelLoginUserName);
		loginPanel.add(jLabelLoginPassword);
		loginPanel.add(jButton8);
		loginPanel.add(jButtonLoginLogin);
		loginPanel.add(jLabelPicLogin);
	
		
		//itt van a register menu
		jTextFieldRegisterUserName = new JTextField();
		jTextFieldRegisterUserName.setBounds(160, 50, 160, 30);
		
		jLabelRegistrationUserName =new JLabel("User Name", SwingConstants.CENTER);
		jLabelRegistrationUserName.setBounds(50, 50, 110, 30);
		jLabelRegistrationUserName.setForeground(Color.WHITE);
		
		jTextFieldRegisterEmail = new JTextField();
		jTextFieldRegisterEmail.setBounds(160, 90, 160, 30);
		
		jLabelRegistrationEmail =new JLabel("Email", SwingConstants.CENTER);
		jLabelRegistrationEmail.setBounds(50, 90, 110, 30);
		jLabelRegistrationEmail.setForeground(Color.WHITE);
		
		jTextFieldRegisterPassword1 = new JTextField();
		jTextFieldRegisterPassword1.setBounds(160, 130, 160, 30);
				
		jLabelRegisterPassword =new JLabel("Password", SwingConstants.CENTER);
		jLabelRegisterPassword.setBounds(50, 130, 110, 30);
		jLabelRegisterPassword.setForeground(Color.WHITE);
		
		jTextFieldRegisterPassword2 = new JTextField();
		jTextFieldRegisterPassword2.setBounds(160, 170, 160, 30);
		
		jLabelRegisterPasswordAgain =new JLabel("Password Again", SwingConstants.CENTER);
		jLabelRegisterPasswordAgain.setBounds(50, 170, 110, 30);
		jLabelRegisterPasswordAgain.setForeground(Color.WHITE);
				
				
		jButtonRegisterBack = new JButton("Back");
		jButtonRegisterBack.setBounds(40, 230, 150, 40);
		jButtonRegisterAccept = new JButton("Accept");
		jButtonRegisterAccept.setBounds(200, 230, 150, 40);
				
			

		registerPanel.add(jTextFieldRegisterUserName);
		registerPanel.add(jLabelRegistrationUserName);
		registerPanel.add(jLabelRegistrationEmail);
		registerPanel.add(jTextFieldRegisterEmail);
		registerPanel.add(jTextFieldRegisterPassword1);
		registerPanel.add(jLabelRegisterPassword);
		registerPanel.add(jTextFieldRegisterPassword2);
		registerPanel.add(jLabelRegisterPasswordAgain);
		registerPanel.add(jButtonRegisterBack);
		registerPanel.add(jButtonRegisterAccept);
		registerPanel.add(jLabelPicRegister);
		
			
		
		
        //fopanel.add(rajzPanel1);
       fopanel.add(fomenuPanel);
       //rajzPanel1.add(jLabelPic);
		
		
		//a keret láthatóvá tétele
		foframe.setVisible(true);
	
		
		//Quest gomb lekezelese
		questButton.addActionListener((ActionEvent e) -> {
			//eltavolitsuk a fõ menut tartalmazo panelt, s beszurjuk a guset menut tartalmazot
			fopanel.remove(fomenuPanel);
			fopanel.add(questPanel);
			fopanel.revalidate();
			fopanel.repaint();
        });
		
		//Back gomb lekezelese a quest menu alatt
		jButton7.addActionListener((ActionEvent e) -> {
			//eltavolitsuk a quest menut tartalmazo panelt, s beszurjuk a fõ menut tartalmazot
			fopanel.remove(questPanel);
			fopanel.add(fomenuPanel);
			fopanel.revalidate();
			fopanel.repaint();    
        });
		
		//Login gomb lekezelese
		loginButton.addActionListener((ActionEvent e) -> {
		//eltavolitsuk a fõ menut tartalmazo panelt, s beszurjuk a guset menut tartalmazot
		fopanel.remove(fomenuPanel);
		fopanel.add(loginPanel);
		fopanel.revalidate();
		fopanel.repaint();
		});
		
		//Login/Back gomb lekezelese
		jButton8.addActionListener((ActionEvent e) -> {
		//eltavolitsuk a fõ menut tartalmazo panelt, s beszurjuk a guset menut tartalmazot
		fopanel.remove(loginPanel);
		fopanel.add(fomenuPanel);
		fopanel.revalidate();
		fopanel.repaint();
		});
		
		//Register gomb lekezelese
		registrationButton.addActionListener((ActionEvent e) -> {
		//eltavolitsuk a fõ menut tartalmazo panelt, s beszurjuk a guset menut tartalmazot
		fopanel.remove(fomenuPanel);
		fopanel.add(registerPanel);
		fopanel.revalidate();
		fopanel.repaint();
		});
				
		//Register/Back gomb lekezelese
		jButtonRegisterBack.addActionListener((ActionEvent e) -> {
		//eltavolitsuk a fõ menut tartalmazo panelt, s beszurjuk a guset menut tartalmazot
		fopanel.remove(registerPanel);
		fopanel.add(fomenuPanel);
		fopanel.revalidate();
		fopanel.repaint();
		});
		
		//Login/login gomb lekezelese
		jButtonLoginLogin.addActionListener((ActionEvent e) -> {
		//eltavolitsuk a fõ menut tartalmazo panelt, s beszurjuk a guset menut tartalmazot
			//fopanel.setVisible(false);
			//fopanel.revalidate();
			//fopanel.repaint();
			//fopanel.setEnabled(false);
			
			DrawGame drawGame = new DrawGame();
			drawGame.PaintGame();
		});
	}
	
	
}
