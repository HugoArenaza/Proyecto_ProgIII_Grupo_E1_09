package ventanas;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.*;

public class VentanaInicio extends JFrame{
	private JButton btnInicioSesion, btnRegistroTrabajador, btnRegistroPaciente, btnSalir;
	private JPanel  pSur, pCentro ,pCentroIzq, pCentroDcha;
	private JFrame vActual;
	
	/*Creamos la primera ventana que se viusualiza*/
	public VentanaInicio()
	{	
		vActual = this;
		setTitle("Bienvenido a Furwell!");
		setBounds(400, 100, 800, 600);
		setVisible(true);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		/*Creamos paneles y componentes*/
		pCentro = new JPanel();
		pCentroIzq = new JPanel();
		pCentroDcha = new JPanel();
		pSur = new JPanel();		
		
		pCentro.add(pCentroIzq);
		pCentro.add(pCentroDcha);
		btnInicioSesion = new JButton("Iniciar Sesion");
		btnRegistroTrabajador = new JButton("Registro (Trabajador)");
		btnRegistroPaciente = new JButton("Registro (Paciente)");
		btnSalir = new JButton("Salir");
		pCentroDcha.add(btnRegistroTrabajador);
		pCentroDcha.add(btnRegistroPaciente);
		pCentroIzq.add(btnInicioSesion);
		pSur.add(btnSalir);
		getContentPane().add(pCentro, BorderLayout.CENTER);
		getContentPane().add(pSur, BorderLayout.SOUTH);
		
		
		/*Eventos*/
		
		btnSalir.addActionListener((e)->{
			System.exit(0);
			
		});
		
		btnInicioSesion.addActionListener((e)->{
			
			/*Preguntar como abrir una ventana al clickar el boton*/
		});

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*Main*/
	
	
}

