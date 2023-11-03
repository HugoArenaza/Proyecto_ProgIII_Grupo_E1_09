package ventanas;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaJefeClinica extends JFrame{
	protected JPanel pNorte, pSur, pCentro;
	protected JButton btnSalir;
	
	
	public VentanaJefeClinica() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(400, 100, 800, 500);
		setTitle("Jefe de CLinica");
		pNorte = new JPanel();
		pSur  = new JPanel();
		pCentro = new JPanel();
		
		pSur.add(btnSalir);
		getContentPane().add(pSur, BorderLayout.SOUTH);
		
		
		/*Eventos*/
		btnSalir.addActionListener((e)->{
			dispose();
		});
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		setVisible(true);
		
	}

}
