import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


public class Hiba {

	public void uzenet(String hibaUzenet) {
		// TODO Auto-generated method stub
		JDialog hibaAblak = new JDialog();
		JLabel uzenet = new JLabel(hibaUzenet, SwingConstants.CENTER);
		hibaAblak.setTitle("Hiba!");
		hibaAblak.setBounds(350, 350, 400, 100);
		hibaAblak.add(uzenet);
		
		hibaAblak.setVisible(true);
	}

}
