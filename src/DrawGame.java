import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;



public class DrawGame extends JPanel implements ActionListener{
JFrame gameFrame = new JFrame();
JPanel gamePanel = new JPanel();
ArrayList arrayListGame = new ArrayList();
Integer sorokszama=0;

Timer t = new Timer(40,this);
int x=0;
	public void paint(Graphics g){
		
		g.setColor(Color.LIGHT_GRAY);
		g.clearRect(0, 0, 700, 700);
		
		g.setColor(Color.blue);
		setSize(700,700);
		
		/* 
		
		
		 
		 
		 
		 
		 
		
		 
		
		 */
		 
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
		DrawGame drawImage = new DrawGame();
		gameFrame.add(drawImage);
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
	}
	
}
