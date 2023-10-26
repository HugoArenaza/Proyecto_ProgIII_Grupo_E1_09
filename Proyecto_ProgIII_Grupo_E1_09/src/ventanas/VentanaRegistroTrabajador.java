package ventanas;

import javax.swing.*;
import javax.swing.JFrame;

import domain.Paciente;

public class VentanaRegistroTrabajador extends JFrame{
	
	private JPanel PanelNorte, PanelSur, PanelCentro, PanelCentroDcha, PanelCentroIzq;
	private JLabel lblNomR, lblDniR, lblApeR, lblFNacR ,lblUsuR, lblConR;
	private JTextField txtNomR, txtDniR, txtFNacR, txtApeR, txtUsuR;
	private JPasswordField txtConR;
	private JButton btnRegistrarse, btnSalir;
	private JFrame vActual;
	
	private static Paciente paciente;
	
	public static Paciente getPaciente() {
		return paciente;
	}
	
	
	
	public VentanaRegistroTrabajador() {
		
		lblDniR = new JLabel("DNI: ");
		lblNomR = new JLabel("NOMBRE: ");
		lblApeR = new JLabel("APELLIDOS: ");
		lblFNacR = new JLabel("FECHA DE NACIMIENTO: ");
		lblConR = new JLabel("USUARIO: ");
		lblConR = new JLabel("CONTRASEÑA: ");
		
	
		txtDniR = new JTextField();
		txtNomR = new JTextField();
		txtApeR = new JTextField();
		txtFNacR = new JTextField();
		txtUsuR = new JTextField();
		txtConR = new JPasswordField();
		
		
		vActual = this;
		setBounds(400, 100, 800, 500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}
	
	
	

}
