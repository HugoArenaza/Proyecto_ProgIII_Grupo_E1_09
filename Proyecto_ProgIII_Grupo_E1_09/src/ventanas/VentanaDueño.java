package ventanas;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaDueño extends JFrame{
	private JButton btnSalir, btnVolverInicio;
	private JPanel pAbajo, pCentro;
	private JLabel lblEspera;	
	
	
	public VentanaDueño(){
		
	pAbajo = new JPanel();
	pCentro = new JPanel();
		
	btnSalir = new JButton("Salir");
	btnVolverInicio = new JButton("Inicio");
	
	lblEspera = new JLabel("pagina por crear");
	Font fuenteInventada = new Font("Arial", Font.BOLD, 56);
	lblEspera.setFont(fuenteInventada);
	
	getContentPane().add(pAbajo, BorderLayout.SOUTH);
	getContentPane().add(pCentro, BorderLayout.NORTH);
	
	
	pAbajo.add(btnSalir);
	pAbajo.add(btnVolverInicio);
	pCentro.add(lblEspera);
	
	btnSalir.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
			
		}
	});
	btnVolverInicio.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
			new VentanaInicio();
			
		}
	});
	
	
	int anchoPantalla = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth();
	int altoPantalla = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight();
	setSize(anchoPantalla, altoPantalla);
	setExtendedState(MAXIMIZED_BOTH);
	setResizable(false);
	setVisible(true);
	
	
	
	}

}
