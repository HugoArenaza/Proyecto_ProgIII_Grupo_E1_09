package ventanas;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaTrabajador extends JFrame{
	private Logger logger = java.util.logging.Logger.getLogger("Logger");
	protected JButton btnSalir, btnAniadirCita, btnAnularCita, btnVerCalendario, btnVerPacientes;
	protected JPanel pNorte, pCentro, pSur;
	protected JFrame vActual;
	

	public VentanaTrabajador() {
		
		pSur = new JPanel();
		getContentPane().add(pSur, BorderLayout.SOUTH);
		
		btnSalir = new JButton("Salir");
		pSur.add(btnSalir);
		
		btnSalir.addActionListener((e)->{
			dispose();
		});
		/*btnAniadirCita.addActionListener((e)->{
			/*Cita c = new Cita();
			 * ListaCitas.add(c);
			Crear list vacia donde meter citas
			logger.info("Se ha agregado una nueva cita");
			
		});
		
		btnAnularCita.addActionListener((e)->{
			/*ListaCitas.remove(c);
			Crear list vacia donde meter/borrar citas
			logger.info("Se ha quitado una cita");
		});
		btnVerPacientes.addActionListener((e)->{
			/*Empezaremos con un syso de la lista de pacientes
			 * mas tarde se visualizará en la ventana
		});*/
		
		setBounds(400, 100, 800, 500);
		setVisible(true);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setTitle("Trabajador");
	
	}
}
