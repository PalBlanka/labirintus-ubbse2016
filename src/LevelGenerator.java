import java.util.ArrayList;
import java.util.Random;

public class LevelGenerator {
	ArrayList<ArrayList<Integer>> level = new ArrayList<ArrayList<Integer>>(); 
	ArrayList<Integer> inner = new ArrayList<Integer>();
	Random rand = new Random();
	int x1=60,y1=60,x2=580,y2=580;
	int szin=2;	
	//Itt a szinteket, vagyis a palya suruseget allitsuk be ami lehet: 1 3 5 7
	int aktszint;
	//ez fogja tarolni az aktualis kort
	int aktkorszam=0;
	//ez fogja tarolni a nehezsegi szintet
	int levelpoint;
	//ez tarolja majd a szintek nehezseget
	ArrayList<Integer> nehezsegiFokszam = new ArrayList<Integer>();
	
	// jatekos koordinatai
	int xgamer=0,ygamer=0;
	
	//Ez irja ki a file-ba a palya
	private void writeInFile() {
		// TODO Auto-generated method stub
		FileManager output=new FileManager("level.txt");
		FileManager.openFileWrite();
		for(ArrayList<Integer> valami: level ){
			for(int valami2: valami){
				FileManager.writeInFile(Integer.toString(valami2));
			}
			FileManager.writeLn();
		}
		FileManager.closeFileWrite();
	}
	
	private void BaseDraw() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				inner.add(szin);
				inner.add(1);
				inner.add(x1);
				inner.add(y1);
				inner.add(x2);
				inner.add(y2);
				level.add(inner);
			
				inner = new ArrayList<Integer>(inner);
				inner.clear();
				
				szin=1;
				
				inner.add(szin);
				inner.add(3);
				inner.add(x1);
				inner.add(x1);
				inner.add(x2);
				inner.add(x2);
				inner.add(0);
				inner.add(180-(2*aktszint));
				inner.add(4*aktszint);
				
				level.add(inner);
			
			
				
				inner = new ArrayList<Integer>(inner);
				inner.clear();
				szin=5;
				inner.add(szin);
				inner.add(3);
				inner.add(x1);
				inner.add(x1);
				inner.add(x2);
				inner.add(x2);
				inner.add(0);
				inner.add(360-(2*aktszint));
				inner.add(4*aktszint);
				
				level.add(inner);
			
			
				x1=x1+aktszint*10*1;
				y1=y1+aktszint*10*1;
				x2=x2-aktszint*10*2;
				y2=y2-aktszint*10*2;
				
				inner = new ArrayList<Integer>(inner);
				inner.clear();
				
				inner.add(szin);
				inner.add(1);
				inner.add(x1);
				inner.add(x1);
				inner.add(x2);
				inner.add(x2);
				inner.add(x2);
				inner.add(x2);
				level.add(inner);

				
				x1=x1-aktszint*10*1;
				y1=y1-aktszint*10*1;
				x2=x2+aktszint*10*2;
				y2=y2+aktszint*10*2;
			
	}

	private void GenerateLevel(int actualCircle, int levelPoint) {
		// TODO Auto-generated method stub
		if(actualCircle == 0){
			//rand = new Random(4);
			int rand1= rand.nextInt(4);
			switch (rand1){
			case 0 : break;
			case 1 : {	inner.add(1); //forgo fal
						inner.add(3);
						inner.add(60);
						inner.add(60);
						inner.add(580);
						inner.add(580);
						inner.add(0);
						inner.add(357);
						inner.add(6);
						level.add(inner);
						inner = new ArrayList<Integer>(inner);
						inner.clear();
						levelPoint = levelPoint - 1;
						break;
					}
			case 2: {	inner.add(3); //piros potty
						inner.add(3);
						inner.add(60);
						inner.add(60);
						inner.add(580);
						inner.add(580);
						inner.add(1*rand.nextInt(4));
						inner.add(10*rand.nextInt(30));
						inner.add(1);
						level.add(inner);
						inner = new ArrayList<Integer>(inner);
						inner.clear();
						levelPoint = levelPoint - 2;
						break;
			}
			case 3: {	inner.add(3); //piros forgo fal
						inner.add(3);
						inner.add(70);
						inner.add(70);
						inner.add(560);
						inner.add(560);
						inner.add(1);
						inner.add(357);
						inner.add(1);
						level.add(inner);
						inner = new ArrayList<Integer>(inner);
						inner.clear();
						
						inner.add(2);
						inner.add(3);
						inner.add(70);
						inner.add(70);
						inner.add(560);
						inner.add(560);
						inner.add(1);
						inner.add(347);
						inner.add(10);
						level.add(inner);
						inner = new ArrayList<Integer>(inner);
						inner.clear();
						
						
						levelPoint = levelPoint - 3;
						break;
		}
			
			}
			
			actualCircle=1;
		}
		else{
			
			actualCircle=0;
		}
		if (levelPoint>0){
			GenerateLevel(actualCircle,levelPoint);
		}
	}

	private void szintszam() {
		// TODO Auto-generated method stub
		if (levelpoint < 13){
			aktszint = 7;
		}
		if((levelpoint > 12) && (levelpoint < 25)){
			aktszint = 5;
		}
		if((levelpoint > 24) && (levelpoint < 43)){
			aktszint = 3;
		}
		if((levelpoint > 42) && (levelpoint < 67)){
			aktszint = 2;
		}
		if(levelpoint > 67){
			aktszint = 1;
		}
			
	}

	private void feltoltNehezsegiFokszam() {
		// TODO Auto-generated method stub
		for(int i=0 ;i<26;i++){
			nehezsegiFokszam.add(0);
		}
	}
	
	private void Nehezsegfeltolt() {
		// TODO Auto-generated method stub
		switch(aktszint){
		case 1: {
					int ideiglenes = 1;
					int ideiglenes2;
					for (int i = 0; i< levelpoint; i++){
						ideiglenes2 = nehezsegiFokszam.get(ideiglenes);
						ideiglenes2 ++;
						nehezsegiFokszam.remove(ideiglenes);
						nehezsegiFokszam.add(ideiglenes, ideiglenes2);
						if (ideiglenes == 25)
							ideiglenes = 1;
						else ideiglenes ++;
					}
					break;
		}
		case 2:{
				int ideiglenes = 1;
				int ideiglenes2;
				for (int i = 0; i< levelpoint; i++){
					ideiglenes2 = nehezsegiFokszam.get(ideiglenes);
					ideiglenes2 ++;
					nehezsegiFokszam.remove(ideiglenes);
					nehezsegiFokszam.add(ideiglenes, ideiglenes2);
					if (ideiglenes == 11)
						ideiglenes = 1;
					else ideiglenes ++;
				}
			break;
			}
		case 3:{
				int ideiglenes = 1;
				int ideiglenes2;
				for (int i = 0; i< levelpoint; i++){
					ideiglenes2 = nehezsegiFokszam.get(ideiglenes);
					ideiglenes2 ++;
					nehezsegiFokszam.remove(ideiglenes);
					nehezsegiFokszam.add(ideiglenes, ideiglenes2);
					if (ideiglenes == 7)
						ideiglenes = 1;
					else ideiglenes ++;
				}
			break;
			}
		case 5:{
				int ideiglenes = 1;
				int ideiglenes2;
				for (int i = 0; i< levelpoint; i++){
					ideiglenes2 = nehezsegiFokszam.get(ideiglenes);
					ideiglenes2 ++;
					nehezsegiFokszam.remove(ideiglenes);
					nehezsegiFokszam.add(ideiglenes, ideiglenes2);
					if (ideiglenes == 4)
						ideiglenes = 1;
					else ideiglenes ++;
				}
				break;
			}
		case 7:{
				int ideiglenes = 1;
				int ideiglenes2;
				for (int i = 0; i< levelpoint; i++){
					ideiglenes2 = nehezsegiFokszam.get(ideiglenes);
					ideiglenes2 ++;
					nehezsegiFokszam.remove(ideiglenes);
					nehezsegiFokszam.add(ideiglenes, ideiglenes2);
					if (ideiglenes == 2)
						ideiglenes = 1;
					else ideiglenes ++;
				}
				break;
			}
		}
		
	}
	
	public void Generate(int szint) {
		levelpoint = szint;
		szintszam();
		feltoltNehezsegiFokszam();
		//private FileManager output;
		//ez a fugveny tolti fel a koronkenti nehezzsegeknek a pontszamat
		Nehezsegfeltolt();
		
		BaseDraw();
		
		CircleDraw();
		
		//0 kek koron vagyunk, fekete koron vagyunk)
		
		//GenerateLevel(0,levelpoint);
		
		dravGamer();
		drawKey();
		
		writeInFile();
		
		
		
		System.out.println(nehezsegiFokszam);
		
	}



	

	private void drawKey() {
		// TODO Auto-generated method stub
		szin=4;
		inner.add(szin);
		inner.add(5);
		inner.add(320);
		inner.add(320);
		inner.add(40);
		inner.add(40);
		inner.add(0);
		inner.add(355);
		inner.add(10);
		
		level.add(inner);
		
		inner = new ArrayList<Integer>(inner);
		inner.clear();
		
		inner.add(szin);
		inner.add(5);
		inner.add(335);
		inner.add(335);
		inner.add(10);
		inner.add(10);
		inner.add(0);
		inner.add(270);
		inner.add(4);
		
		level.add(inner);
		
		inner = new ArrayList<Integer>(inner);
		inner.clear();
		
		inner.add(szin);
		inner.add(5);
		inner.add(339);
		inner.add(335);
		inner.add(10);
		inner.add(10);
		inner.add(0);
		inner.add(270);
		inner.add(4);
		
		level.add(inner);
		
		inner = new ArrayList<Integer>(inner);
		inner.clear();
		
		inner = new ArrayList<Integer>(inner);
		inner.clear();
		
		inner.add(szin);
		inner.add(5);
		inner.add(337);
		inner.add(335);
		inner.add(10);
		inner.add(10);
		inner.add(0);
		inner.add(270);
		inner.add(4);
		
		level.add(inner);
	}

	private void dravGamer() {
		// TODO Auto-generated method stub
		inner.add(3);
		inner.add(4);
		inner.add(xgamer);
		inner.add(ygamer);
		inner.add(10);
		inner.add(10);
		level.add(inner);
	
		inner = new ArrayList<Integer>(inner);
		inner.clear();
	}

	private void CircleDraw() {
		// TODO Auto-generated method stub
			if  (szin==1)
				szin=2;
			else szin=1;
			
					inner.add(szin);
					inner.add(1);
					inner.add(x1);
					inner.add(y1);
					inner.add(x2);
					inner.add(y2);
					level.add(inner);
				
					inner = new ArrayList<Integer>(inner);
					inner.clear();
				
					
				Akadalyok akadaly= new Akadalyok();
				//if ((aktkorszam>0)&&(aktkorszam<24)){
					if (nehezsegiFokszam.get(aktkorszam)>0){
						ArrayList<Integer> help=akadaly.generateAkadaly(aktszint,x1,x2,szin,nehezsegiFokszam.get(aktkorszam));
						if (help != null){
							level.add(help);
						}
						int ideiglenes = nehezsegiFokszam.get(aktkorszam);
						nehezsegiFokszam.remove(aktkorszam);
						//ideiglenes = ideiglenes - akadaly.csokkentett;
						nehezsegiFokszam.add(aktkorszam, ideiglenes);
					}
				//}
				
				
				aktkorszam++;
			
				x1=x1+aktszint*10*1;
				y1=y1+aktszint*10*1;
				x2=x2-aktszint*10*2;
				y2=y2-aktszint*10*2;
				
			if (x1<320)
				CircleDraw();
	}
	
	
	
	
}
