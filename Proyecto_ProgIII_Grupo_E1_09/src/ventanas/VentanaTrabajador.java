package ventanas;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import domain.Cita;
import domain.Contenedora;

public class VentanaTrabajador extends JFrame{
	private Logger logger = java.util.logging.Logger.getLogger("Logger");
	protected JButton btnSalir, btnAniadirCita, btnAnularCita, btnVerCalendario, btnVerPacientes;
	protected JPanel pNorte, pCentro, pSur;
	protected JFrame vActual;
	

	public VentanaTrabajador() {
		
		pSur = new JPanel();
		getContentPane().add(pSur, BorderLayout.SOUTH);
		
		pCentro = new JPanel();
		getContentPane().add(pCentro, BorderLayout.CENTER);
		
		btnSalir = new JButton("Salir");
		pSur.add(btnSalir);
		
		btnVerPacientes = new JButton("Visualizar los pacientes");
		
	
		btnAniadirCita = new JButton("Añadir cita");
		
		
		btnSalir.addActionListener((e)->{
			dispose();
		});
		/*btnAniadirCita.addActionListener((e)->{
			//Contenedora.aniadirCita(null);
			logger.info("Se ha agregado una nueva cita");
			
		});*/
		
		/*btnAnularCita.addActionListener((e)->{
			//Contenedora.eliminarCita(null);
			logger.info("Se ha eliminado una cita");
		});*/
		btnVerPacientes.addActionListener((e)->{
			Contenedora.imprimirListaPacientes();
			logger.info("Se ha impreso la lista de pacientes");
		});

		
		setBounds(400, 100, 800, 500);
		setVisible(true);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setTitle("Trabajador");
	
	}
}
