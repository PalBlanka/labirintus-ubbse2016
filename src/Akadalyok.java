import java.util.ArrayList;
import java.util.Random;

public class Akadalyok {

	Random rand = new Random();
	ArrayList<Integer> inner = new ArrayList<Integer>();
	int csokkentett = 0;
	
	public ArrayList<Integer> generateAkadaly(int aktszint, int x1, int x2, int szin, Integer integer) {
		// TODO Auto-generated method stub

		//kek koron vagyunk
		if (szin==1){
			int rand1= rand.nextInt(2);
			switch(rand1){
			case 0:{if (integer > 0){
				 		inner.add(2);
				 		inner.add(3);
				 		inner.add(x1-1);
				 		inner.add(x1-1);
				 		inner.add(x2+2);
				 		inner.add(x2+2);
				 		inner.add(rand.nextInt(4)-1);
				 		inner.add(357);
				 		inner.add(10*rand.nextInt(30));
				 		inner = new ArrayList<Integer>(inner);
				 		csokkentett = 1;
					}
					break;
				
			}
			case 1:{if (integer > 0){
		 		inner.add(2);
		 		inner.add(3);
		 		inner.add(x1-1);
		 		inner.add(x1-1);
		 		inner.add(x2+2);
		 		inner.add(x2+2);
		 		inner.add(rand.nextInt(4)-1);
		 		inner.add(357);
		 		inner.add(10*rand.nextInt(30));
		 		inner = new ArrayList<Integer>(inner);
		 		csokkentett = 1;
			}
			break;
		
	}
			case 2:{if (integer > 0){
		 		inner.add(2);
		 		inner.add(3);
		 		inner.add(x1-1);
		 		inner.add(x1-1);
		 		inner.add(x2+2);
		 		inner.add(x2+2);
		 		inner.add(rand.nextInt(4)-1);
		 		inner.add(357);
		 		inner.add(10*rand.nextInt(30));
		 		inner = new ArrayList<Integer>(inner);
		 		csokkentett = 1;
			}
			break;
		
	}
			}
		}
		//fekete koron vagyunk
		else{
			int rand1= rand.nextInt(2);
			switch(rand1){
			case 0:{if (integer > 0){
				 		inner.add(1);
				 		inner.add(3);
				 		inner.add(x1-1);
				 		inner.add(x1-1);
				 		inner.add(x2+2);
				 		inner.add(x2+2);
				 		inner.add(rand.nextInt(4)-1);
				 		inner.add(10*rand.nextInt(30));
				 		inner.add(4*aktszint);
				 		inner = new ArrayList<Integer>(inner);
				 		csokkentett = 1;
					}
					break;
				
			}
			case 1:{if (integer > 0){
		 		inner.add(1);
		 		inner.add(3);
		 		inner.add(x1-1);
		 		inner.add(x1-1);
		 		inner.add(x2+2);
		 		inner.add(x2+2);
		 		inner.add(rand.nextInt(4)-1);
		 		inner.add(10*rand.nextInt(30));
		 		inner.add(4*aktszint);
		 		inner = new ArrayList<Integer>(inner);
		 		csokkentett = 1;
			}
			break;
		
	}
			case 2:{if (integer > 0){
		 		inner.add(1);
		 		inner.add(3);
		 		inner.add(x1-1);
		 		inner.add(x1-1);
		 		inner.add(x2+2);
		 		inner.add(x2+2);
		 		inner.add(rand.nextInt(4)-1);
		 		inner.add(10*rand.nextInt(30));
		 		inner.add(4*aktszint);
		 		inner = new ArrayList<Integer>(inner);
		 		csokkentett = 1;
			}
			break;
		
	}
			}
		}
		System.out.println("Inner:"+inner);
		return inner;
	}

}
