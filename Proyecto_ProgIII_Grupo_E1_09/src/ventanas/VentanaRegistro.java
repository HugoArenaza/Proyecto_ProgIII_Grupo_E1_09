package ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.*;

import domain.Paciente;

public class VentanaRegistro extends JFrame{
	
	private JPanel panel, panelSur, panelCentro, pCInformacion, pcIzq;
	private JLabel lblNomR, lblDniR, lblApeR, lblFNacR ,lblUsuR, lblConR, lblConR2;
	private JTextField txtNomR, txtDniR, txtFNacR, txtApeR, txtUsuR;
	private JPasswordField txtConR, txtConR2;
	private JButton btnRegistrarse, btnSalir;
	private JFrame vActual;
	
	private static Paciente paciente;
	
	public static Paciente getPaciente() {
		return paciente;
	}
	
	
	
	public VentanaRegistro() {
		
		
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panelCentro = new JPanel();
		panelCentro.setLayout(new BorderLayout());
		panelSur = new JPanel(new FlowLayout());
		
		pcIzq = new JPanel();
		pcIzq.setLayout(new BoxLayout(pcIzq, BoxLayout.Y_AXIS));
		
		pCInformacion = new JPanel();
		pCInformacion.setLayout(new BoxLayout(pCInformacion, BoxLayout.Y_AXIS));
		
		btnRegistrarse = new JButton("Registrarse");
		btnSalir = new JButton("Salir");
		
		lblDniR = new JLabel("DNI: ");
		lblNomR = new JLabel("NOMBRE: ");
		lblApeR = new JLabel("APELLIDOS: ");
		lblFNacR = new JLabel("FECHA DE NACIMIENTO: ");
		lblUsuR = new JLabel("USUARIO: ");
		lblConR = new JLabel("CONTRASEÑA: ");
		lblConR2 = new JLabel("REPITE CONTRASEÑA: ");
		
	
		txtDniR = new JTextField();
		txtNomR = new JTextField();
		txtApeR = new JTextField();
		txtFNacR = new JTextField();
		txtUsuR = new JTextField();
		txtConR = new JPasswordField();
		txtConR2 = new JPasswordField();
		
		txtNomR.setMaximumSize(new Dimension(Integer.MAX_VALUE, 20));
		txtApeR.setMaximumSize(new Dimension(Integer.MAX_VALUE, 20));
		txtDniR.setMaximumSize(new Dimension(Integer.MAX_VALUE, 20));
		txtFNacR.setMaximumSize(new Dimension(Integer.MAX_VALUE, 20));
		txtUsuR.setMaximumSize(new Dimension(Integer.MAX_VALUE, 20));
		txtConR.setMaximumSize(new Dimension(Integer.MAX_VALUE, 20));
		txtConR2.setMaximumSize(new Dimension(Integer.MAX_VALUE, 20));
		
		
		
		pcIzq.add(lblNomR);
		pcIzq.add(txtNomR);
		pcIzq.add(lblApeR);
		pcIzq.add(txtApeR);
		pcIzq.add(lblDniR);
		pcIzq.add(txtDniR);
		pcIzq.add(lblFNacR);
		pcIzq.add(txtFNacR);
		pcIzq.add(lblUsuR);
		pcIzq.add(txtUsuR);
		pcIzq.add(lblConR);
		pcIzq.add(txtConR);
		pcIzq.add(lblConR2);
		pcIzq.add(txtConR2);
		
		panelSur.add(btnRegistrarse);
		panelSur.add(btnSalir);
		
		panelCentro.add(pcIzq, BorderLayout.WEST);
		
		
		panel.add(panelCentro, BorderLayout.CENTER);
		
		panel.add(panelSur, BorderLayout.SOUTH);
		
		
		
		getContentPane().add(panel);
		btnRegistrarse.addActionListener((e)->{
			String dni = txtDniR.getText();
			String nom = txtNomR.getText();
			String fNac = txtFNacR.getText();
			String con = txtConR.getText();
		});
		btnSalir.addActionListener((e)->{
			dispose();
		});
		
		vActual = this;
		setBounds(400, 100, 800, 500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}
	
	
	

}