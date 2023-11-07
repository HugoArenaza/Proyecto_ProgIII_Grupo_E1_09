package ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.*;

import domain.Paciente;
import domain.Veterinario;

public class VentanaRegistroTrabajador extends JFrame{
	
	private JPanel panel, panelSur, panelCentro, pCInformacion, pcIzq;
	private JLabel lblNomR, lblDniR, lblApeR, lblFNacR ,lblUsuR, lblConR, lblConR2, lblCorreo;
	private JTextField txtNomR, txtDniR, txtFNacR, txtApeR, txtUsuR, txtCorreo;
	private JPasswordField txtConR, txtConR2;
	private JButton btnRegistrarse, btnSalir;
	private JFrame vActual;
	private Veterinario veterinario;
	
	private static Paciente paciente;
	
	public static Paciente getPaciente() {
		return paciente;
	}
	
	
	
	public VentanaRegistroTrabajador() {
		
		
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
		lblCorreo = new JLabel("CORREO: ((modifica 'example' para crear tu correo correctamente)");
		lblUsuR = new JLabel("USUARIO: ");
		lblConR = new JLabel("CONTRASEÑA: ");
		lblConR2 = new JLabel("REPITE CONTRASEÑA: ");
		
	
		txtDniR = new JTextField();
		txtNomR = new JTextField();
		txtApeR = new JTextField();
		txtFNacR = new JTextField();
		txtCorreo = new JTextField("example@veterinariofurwell.com");
		txtUsuR = new JTextField();
		txtConR = new JPasswordField();
		txtConR2 = new JPasswordField();
		
		txtNomR.setMaximumSize(new Dimension(Integer.MAX_VALUE, 20));
		txtApeR.setMaximumSize(new Dimension(Integer.MAX_VALUE, 20));
		txtDniR.setMaximumSize(new Dimension(Integer.MAX_VALUE, 20));
		txtFNacR.setMaximumSize(new Dimension(Integer.MAX_VALUE, 20));
		txtCorreo.setMaximumSize(new Dimension(Integer.MAX_VALUE, 20));
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
		pcIzq.add(lblCorreo);
		pcIzq.add(txtCorreo);
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
			
			String nom = txtNomR.getText();
			String apell = txtApeR.getText();
			String User = txtUsuR.getText();
			String con = txtConR.getText();
			String con2 = txtConR2.getText();
			String dni = txtDniR.getText();
			String fNac = txtFNacR.getText();
			String correo = txtCorreo.getText();
				
			Veterinario v = new Veterinario(nom, apell, User, con, null, paciente, null, null, dni);
			
			String correoNoValido = "example@veterinariofurwell.com";
			if (nom.isEmpty() || User.isEmpty() || con.isEmpty() || con2.isEmpty() || dni.isEmpty() || correo.isEmpty())  {
					JOptionPane.showMessageDialog(null, "No dejes ningun campo vacio","ERROR",JOptionPane.WARNING_MESSAGE);
			}else if(correo.equals(correoNoValido)){
				JOptionPane.showMessageDialog(null, "Cambia el correo de ejemplo","ERROR",JOptionPane.WARNING_MESSAGE);
				
					
			}else if(con.equals(con2)) {
					JOptionPane.showMessageDialog(null, "Veterinario registrado con éxito","REGISTRADO",JOptionPane.INFORMATION_MESSAGE);
					new VentanaJefe();
			}else {
					JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden","ERROR",JOptionPane.WARNING_MESSAGE);
					txtConR.setText("");
					txtConR2.setText("");
				
					}
				/*
				 * if(Veterinario.buscarVeterinario(dni)!=null) {
					JOptionPane.showMessageDialog(null, "Ya existe un veterinario con ese dni","ERROR",JOptionPane.ERROR_MESSAGE);
				}else {
					Veterinario.aniadirVeterinario(c);
					JOptionPane.showMessageDialog(null, "Cliente registrado con éxito","REGISTRADO",JOptionPane.INFORMATION_MESSAGE);
			}*/
				/*new VentanaTrabajador();*/	
			
				
			
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
