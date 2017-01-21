import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class DrawGame extends JPanel implements ActionListener, KeyListener{
JFrame gameFrame = new JFrame();
JPanel gamePanel = new JPanel();
ArrayList arrayListGame = new ArrayList();
Integer sorokszama=0;

Timer t = new Timer(40, this);
int x=0;

// jatekos koordinata4
int xgamer=345,ygamer=345;
int R=280;
//double T=3.14;
double T=3.14;
//ez a valtozo jeloli, hogy felvett-k e a kulcsot vagy nem
boolean kulcs=true;
boolean atvive=false;
//a jatekos mozgatasahoz
public boolean fel, le, jobb, bal;

//buffered image a pixelek lekerdezesehez
BufferedImage bImage = new BufferedImage(700,700,BufferedImage.TYPE_INT_RGB);
boolean figyelo = true;

	public void paint(Graphics g){
		
		g.setColor(Color.LIGHT_GRAY);
		g.clearRect(0, 0, 700, 700);
		
		g.setColor(Color.blue);
		setSize(700,700); 
		
		 
		 sorokszama=0;
		 readTxt("level.txt");
		 for(int i=0;i<sorokszama;i++){
			 ArrayList<Integer> arrayListHelp = new ArrayList<Integer>();
			 arrayListHelp.clear();
			 arrayListHelp = felbontKomp((String) arrayListGame.get(i));
			 paintComponenet(arrayListHelp,g);
			
			 
			 
		 }
		 		 
		 
		
			 
		 
		 t.start();
		
	}
	
	private void paintComponenet(ArrayList<Integer> arrayListHelp, Graphics g) {
		// TODO Auto-generated method stub
		//szint alitsuk be
		switch (arrayListHelp.get(0)){
			case 1:		g.setColor (Color.blue);
						break;
			case 2:    	g.setColor (Color.black);
						break;
			case 3:		g.setColor (Color.red);
	 					break;
			case 4:		g.setColor (Color.green);
						break;
			case 5:		if (kulcs==true){
							g.setColor (Color.DARK_GRAY);
						}
						else{
							g.setColor (Color.blue);
						}
			
			break;
	 		default:	g.setColor (Color.yellow);
						break;
		}
		//ALAK ATIRASA
		switch (arrayListHelp.get(1)){
		//ez a karika
			case 1:		g.fillOval(arrayListHelp.get(2), arrayListHelp.get(3), arrayListHelp.get(4), arrayListHelp.get(5));
						break;
		//ez a negyzet(kulcs kapu)
			case 2:    	g.fillRect(arrayListHelp.get(2), arrayListHelp.get(3), arrayListHelp.get(4), arrayListHelp.get(5));
						break;
		//ez a korcikk
			case 3:		g.fillArc(arrayListHelp.get(2), arrayListHelp.get(3), arrayListHelp.get(4), arrayListHelp.get(5), (arrayListHelp.get(6)*x)+arrayListHelp.get(7), arrayListHelp.get(8));
						break;
		//ez a jatekos
			case 4:		g.fillOval((int)(xgamer+(R*Math.cos(T))), (int)(ygamer+(R*Math.sin(T))), arrayListHelp.get(4), arrayListHelp.get(5));
						break;
						//ez a korcikk
			case 5:		if (kulcs==true){
						g.fillArc(arrayListHelp.get(2), arrayListHelp.get(3), arrayListHelp.get(4), arrayListHelp.get(5), (arrayListHelp.get(6)*x)+arrayListHelp.get(7), arrayListHelp.get(8));
						}
						break;
						
			default:	
						break;
		}	
		
	}

	private ArrayList<Integer> felbontKomp(String string) {
		
		
		 ArrayList<Integer> arrayListHelpLocal = new ArrayList<Integer>();
		 for (String helpId:string.split(("\\s+"))){
			 	Integer integerLocalHelp = Integer.parseInt(helpId);
				arrayListHelpLocal.add(integerLocalHelp);
			}
			
		return arrayListHelpLocal;
	}

	private void readTxt(String string) {
		
		arrayListGame.clear();
		// TODO Auto-generated method stub
		try (BufferedReader bufferReader = new BufferedReader( new FileReader(string))){
			String line;
			int listener=0;
			while (( line = bufferReader.readLine()) != null) {
				
					arrayListGame.add(line);     
					sorokszama++;
               }
		}catch(IOException | NumberFormatException e){
	        System.out.println("Error while reading file line by line:" + ((Throwable) e).getMessage()); 
	        }	
		
	}
	
	
	public void PaintGame() {
		// TODO Auto-generated method stub
		
		gameFrame = new JFrame();
		gameFrame.setTitle("Labirintus Game ");
		gameFrame.setBounds(300,20,700,700);
		gameFrame.addKeyListener(this);
		DrawGame drawImage = new DrawGame();
		//gameFrame.add(drawImage);
		gameFrame.add(this);
		gameFrame.setVisible(true);
		
		
	}
	
	@Override
		public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
		
		if (x< 360){
			x++;
		}
		else {
			x=0;
		}
		
		//ideiglenesen kiveve
		
		
		Container c = getRootPane();
		BufferedImage im = new BufferedImage(700, 700, BufferedImage.TYPE_INT_ARGB);
		((Container) c).paint(im.getGraphics());
		int clr=  im.getRGB((int)(xgamer+(R*Math.cos(T))), (int)(ygamer+(R*Math.sin(T)))); 
		if (clr == -16776961){
		// System.out.println("kek "+ clr);
		}
		if (clr == -16777216){
		//	 System.out.println("Feket "+ clr);
		}
		//ha fekete a babu alatt a terulet akkor megnezi, hogy jobbra, vagy balra kek e es eltolja a babut
		if(clr == -16777216){
			int clr1=  im.getRGB((int)(xgamer+(R*Math.cos(T+0.06))), (int)(ygamer+(R*Math.sin(T+0.06))));
			int clr2=  im.getRGB((int)(xgamer+(R*Math.cos(T-0.06))), (int)(ygamer+(R*Math.sin(T-0.06))));
			if  (clr1 ==  -16776961){
				T=T+0.08;
			}
			if  (clr2 ==  -16776961){
				T=T-0.08;
			}
		}
		  if (atvive == false){
			  
			  if (R>275 && T<1.57 && T>-4.57){
				  atvive=true;
				  Vege grat = new Vege();
				  grat.Uzenet("Gratulalunk atvitted a palyat");
			  }
		  }

	}
	
	private Container getJFrame() {
		// TODO Auto-generated method stub
		return null;
	}

	private Container getJPanel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		//elkeszitti a kontrol kepet
		Container c = getRootPane();
		BufferedImage im = new BufferedImage(700, 700, BufferedImage.TYPE_INT_ARGB);
		((Container) c).paint(im.getGraphics());
		int clr=  im.getRGB((int)(xgamer+(R*Math.cos(T))), (int)(ygamer+(R*Math.sin(T))));
		
		//ez kezeli le a kulcs felveveset
			if(kulcs == true){
				System.out.println("kulcs ellenorzes");
				if (R<10){
					kulcs=false;
				}
			}
			
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
		    	System.out.println("bal");
		    	if (T-0.056<-6.3){
		    		int clr2=  im.getRGB((int)(xgamer+((R)*Math.cos(T-0.8))), (int)(ygamer+((R)*Math.sin(T-0.08))));
					if (clr2 == -16776961){
						T=0;
					}
		    	}
		    	else{
		    		int clr2=  im.getRGB((int)(xgamer+((R)*Math.cos(T-0.08))), (int)(ygamer+((R)*Math.sin(T-0.08))));
		    		if (clr2 == -16776961){
		    			T=T-0.04;
		    		}
		    		System.out.println("T:="+T);
		    	}
			}
			
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
		    	System.out.println("jobb");
		    	if (T+0.056>6.3){
		    		int clr2=  im.getRGB((int)(xgamer+(R*Math.cos(T+0.04))), (int)(ygamer+(R*Math.sin(T+0.04))));
					if (clr2 == -16776961){
						T=0;
					}
		    	}
		    	else{
		    		int clr2=  im.getRGB((int)(xgamer+(R*Math.cos(T+0.06))), (int)(ygamer+(R*Math.sin(T+0.06))));
		    		if (clr2 == -16776961){
		    			T=T+0.04;
		    		}
					System.out.println("T:="+T);
		    	}
			}

		    if (e.getKeyCode() == KeyEvent.VK_UP) {
		    	System.out.println("fel");
		    	int clr2=  im.getRGB((int)(xgamer+((R+8)*Math.cos(T))), (int)(ygamer+((R+8)*Math.sin(T))));
				if (clr2 == -16776961){
					R=R+8;
				}
		    	//fel=true;
		    	
		    	System.out.println("R:="+R);
		    }

		    if (e.getKeyCode() == KeyEvent.VK_DOWN) {
		    	System.out.println("le");
		    	//le=true;
		    	if (R-6>0){
		    	int clr2=  im.getRGB((int)(xgamer+((R-9)*Math.cos(T))), (int)(ygamer+((R-9)*Math.sin(T))));
				if (clr2 == -16776961){
						R=R-8;
				}
		    	System.out.println("R:="+R);
		    	}
		    }
		    
	
	}
	@Override
	public void keyTyped(KeyEvent e) {
		/*if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            System.out.println("Right key typed");
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            System.out.println("Left key typed");
        }*/
	}

	@Override
	public void keyReleased(KeyEvent e) {
		 /*if (e.getKeyCode() == KeyEvent.VK_LEFT) {
		    	System.out.println("bal");
		    	bal=false;
		        xgamer=xgamer-5;
		    }

		    if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
		    	System.out.println("jobb");
		    	jobb=false;
		    	xgamer=xgamer+5;
		    }

		    if (e.getKeyCode() == KeyEvent.VK_UP) {
		    	System.out.println("fel");
		    	fel=false;
		    	ygamer--;
		    }

		    if (e.getKeyCode() == KeyEvent.VK_DOWN) {
		    	System.out.println("le");
		    	le=false;
		    	ygamer++;
		    }
		    */
	}

	
}
