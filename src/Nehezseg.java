
public class Nehezseg implements Kapu, Korok, Idokorlat, Ellenseg{

	@Override
	public int ido_korlat(int masodperc) {
		// TODO Auto-generated method stub
		int ido_egyutthato = 0;
		return (masodperc * ido_egyutthato);
	}

	@Override
	public int korok_nehezsege(int korok_szama) {
		// TODO Auto-generated method stub
		int kor_egyutthato = 0;
		return (korok_szama * kor_egyutthato);
	}

	@Override
	public int kapu_nehezsege(int meret) {
		// TODO Auto-generated method stub
		int kapu_egyutthato = 0;
		return (meret * kapu_egyutthato);
	}

	@Override
	public int ellenseg_nehezsege(int ellenseg_szama) {
		// TODO Auto-generated method stub
		int ellenseg_egyutthato = 0;
		return (ellenseg_szama * ellenseg_egyutthato);
	}
	
	public Nehezseg(){
		int nehezsegi_egyutthato = 0;
		int meret = 0, korok_szama = 0, idokorlat = 0, ellenseg_szama = 0;
		nehezsegi_egyutthato = ellenseg_nehezsege(ellenseg_szama) + ido_korlat(idokorlat) + korok_nehezsege(korok_szama) + kapu_nehezsege(meret);
	}

}
