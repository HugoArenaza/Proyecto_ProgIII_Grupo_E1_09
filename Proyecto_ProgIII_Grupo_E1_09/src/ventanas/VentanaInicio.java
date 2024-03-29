package ventanas;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
//import javax.swing.JPasswordField;

import domain.Dueño;

import java.awt.*;

public class VentanaInicio extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnInicioSesion, btnRegistro, btnSalir;
	private JPanel  pSur, pCentro ,pCentroIzq, pCentroDcha;
	private JLabel foto;
	private static Dueño dueño;
	
	public static Dueño getDueño() {
		return dueño;
	}
	
	public static void setDueño(Dueño d) {
		dueño = d;
	}
	
	/*Creamos la primera ventana que se viusualiza*/
	public VentanaInicio()
	{	
		ImageIcon imPortada = new ImageIcon("src/imagenes/fotoportada.png");
		setTitle("Bienvenido a Furwell!");
		setBounds(400, 100, 800, 600);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		/*Creamos paneles y componentes*/
		pCentro = new JPanel();
		pCentroIzq = new JPanel();
		pCentroDcha = new JPanel();
		pSur = new JPanel();
		foto = new JLabel(imPortada);
		
		pCentro.add(pCentroIzq);
		pCentro.add(pCentroDcha);
		
		foto.setPreferredSize(new Dimension(imPortada.getIconWidth(),imPortada.getIconHeight()));
		
		pCentro.add(foto);
		btnInicioSesion = new JButton("Iniciar Sesion");
		btnRegistro = new JButton("Registro");
		
		btnSalir = new JButton("Salir");
		pCentroDcha.add(btnRegistro);
		pCentroIzq.add(btnInicioSesion);
		pSur.add(btnSalir);
		getContentPane().add(pCentro, BorderLayout.CENTER);
		getContentPane().add(pSur, BorderLayout.SOUTH);
		
		
	
		
		
		
		
		
		/*Eventos*/
		
		btnSalir.addActionListener((e)->{
			System.exit(0);
			
		});
		
		btnInicioSesion.addActionListener((e)->{
			new VentanaInicioSesion();
			
			
		});
		btnRegistro.addActionListener((e)->{
			new VentanaRegistroDueño();
			
		});
		setVisible(true);
		int anchoPantalla = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth();
		int altoPantalla = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight();
		setSize(anchoPantalla, altoPantalla);
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setResizable(false);

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*Main*/
	
	
}

