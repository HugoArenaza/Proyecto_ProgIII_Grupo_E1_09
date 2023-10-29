package ventanas;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaJefeClinica extends JFrame{
	protected JPanel pNorte, pSur, pCentro;
	protected JButton btnSalir;
	
	
	public VentanaJefeClinica() {
		setBounds(400, 100, 800, 500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}

}
