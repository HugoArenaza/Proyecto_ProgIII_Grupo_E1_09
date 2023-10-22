package ventanas;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.*;

public class VentanaInicio extends JFrame{
	private JButton btnInicioSesion, btnRegistroTrabajador, btnRegistroPaciente, btnSalir;
	private JPanel  pSur, pCentro ,pCentroIzq, pCentroDcha;
	
	
	/*Creamos la primera ventana que se viusualiza*/
	public VentanaInicio()
	{	
		setBounds(400, 100, 800, 600);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		/*Creamos paneles y componentes*/
		pCentro = new JPanel(new GridLayout(1,2));
		pCentroIzq = new JPanel(new GridLayout(2, 2));
		pCentroDcha = new JPanel(new GridLayout(4, 2));
		
		pCentroDcha.setBackground(Color.RED);
		pCentro.add(pCentroIzq);
		pCentro.add(pCentroDcha);
		
		getContentPane().add(pCentro, BorderLayout.CENTER);
		
		
		btnInicioSesion = new JButton("Iniciar Sesion");
		btnRegistroTrabajador = new JButton("Registro (Trabajador)");
		btnRegistroPaciente = new JButton("Registro (Paciente)");
		pCentroDcha.add(btnRegistroTrabajador);
		pCentroDcha.add(btnRegistroPaciente);
		pCentroIzq.add(btnInicioSesion);

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*Main*/
	
	
}

