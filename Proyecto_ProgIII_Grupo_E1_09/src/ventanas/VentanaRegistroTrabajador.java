package ventanas;

import javax.swing.*;
import javax.swing.JFrame;

import domain.Paciente;

public class VentanaRegistroTrabajador extends JFrame 
{
	private JPanel PanelNorte, PanelSur, PanelCentro, PanelCentroDcha, PanelCentroIzq;
	private JLabel lblNomR, lblDniR, lblApeR, lblUsuR, lblConR;
	private JTextField txtNomR, txtDniR, txtApeR, txtUsuR;
	private JPasswordField txtConR;
	private JButton btnRegistrarse, btnSalir;
	private JFrame vActual;
	
	private static Paciente paciente;
	
	public static Paciente getPaciente() {
		return paciente;
	}
	
	
	
	public VentanaRegistroTrabajador() {
		super();
		vActual = this;
		setBounds(400, 100, 800, 500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}
	
	
	

}
