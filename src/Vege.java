import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Vege {

	public void Uzenet(String uzenetString) {
		// TODO Auto-generated method stub
				JDialog hibaAblak = new JDialog();
				JLabel uzenet = new JLabel(uzenetString, SwingConstants.CENTER);
				hibaAblak.setTitle("");
				hibaAblak.setBounds(350, 350, 400, 100);
				hibaAblak.add(uzenet);
				//hibaAblak.setDefaultCloseOperation();
				hibaAblak.setVisible(true);
				
				
	}

}
