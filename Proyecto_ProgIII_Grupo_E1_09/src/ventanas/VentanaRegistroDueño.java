package ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.sql.Connection;
//import java.awt.GraphicsEnvironment;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.swing.*;

import base_de_datos.BD;
import domain.Contenedora;
import domain.Dueño;
import domain.Paciente;
//import domain.Veterinario;

public class VentanaRegistroDueño extends JFrame{	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Logger logger = java.util.logging.Logger.getLogger("Logger");
	
	private JPanel panel, panelSur, panelCentro, pCInformacion, pcIzq;
	private JLabel lblNomR, lblDniR, lblApeR, lblFNacR ,lblUsuR, lblConR, lblConR2, lblCorreo, lblTelf;
	private JTextField txtNomR, txtDniR, txtFNacR, txtApeR, txtUsuR, txtCorreo, txtTelf;
	private JPasswordField txtConR, txtConR2;
	private JButton btnRegistrarse, btnSalir;
	private JFrame vActual;
	private Dueño dueño;
	private List<Dueño> listaDueños = new ArrayList<>();
	private Contenedora c;
	
	private static Paciente paciente;
	
	public static Paciente getPaciente() {
		return paciente;
	}
	
	
	
	public VentanaRegistroDueño() {
		
		
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
		lblCorreo = new JLabel("CORREO: ");
		lblUsuR = new JLabel("USUARIO: ");
		lblConR = new JLabel("CONTRASEÑA: ");
		lblConR2 = new JLabel("REPITE CONTRASEÑA: ");
		lblTelf = new JLabel("NUMERO DE TELEFONO; ");
		
		txtDniR = new JTextField();
		txtNomR = new JTextField();
		txtApeR = new JTextField();
		txtFNacR = new JTextField();
		txtUsuR = new JTextField();
		txtCorreo = new JTextField();
		txtConR = new JPasswordField();
		txtConR2 = new JPasswordField();
		txtTelf = new JTextField();
		
		
		txtNomR.setMaximumSize(new Dimension(Integer.MAX_VALUE, 20));
		txtApeR.setMaximumSize(new Dimension(Integer.MAX_VALUE, 20));
		txtDniR.setMaximumSize(new Dimension(Integer.MAX_VALUE, 20));
		txtFNacR.setMaximumSize(new Dimension(Integer.MAX_VALUE, 20));
		txtUsuR.setMaximumSize(new Dimension(Integer.MAX_VALUE, 20));
		txtCorreo.setMaximumSize(new Dimension(Integer.MAX_VALUE, 20));
		txtConR.setMaximumSize(new Dimension(Integer.MAX_VALUE, 20));
		txtConR2.setMaximumSize(new Dimension(Integer.MAX_VALUE, 20));
		txtTelf.setMaximumSize(new Dimension(Integer.MAX_VALUE, 20));
		
		
		pcIzq.add(lblNomR);
		pcIzq.add(txtNomR);
		pcIzq.add(lblApeR);
		pcIzq.add(txtApeR);
		pcIzq.add(lblDniR);
		pcIzq.add(txtDniR);
		pcIzq.add(lblFNacR);
		pcIzq.add(txtFNacR);
		pcIzq.add(lblTelf);
		pcIzq.add(txtTelf);
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
			String dni = txtDniR.getText().toUpperCase();
			String fNac = txtFNacR.getText();
			String correo = txtCorreo.getText();
			int  telefono = 0;
			if(!txtTelf.getText().isEmpty()) {
				telefono = Integer.parseInt(txtTelf.getText());
			}
			
				
			
			Dueño dLista = new Dueño(nom, apell, dni, null, fNac, telefono, correo, con);			
			c = new Contenedora();
			c.GuardarDueñoRegistrado(dLista);
			
			if (nom.isEmpty() || User.isEmpty() || con.isEmpty() || con2.isEmpty() || dni.isEmpty() || correo.isEmpty() || txtTelf.getText().isEmpty()) {
			    JOptionPane.showMessageDialog(null, "No dejes ningún campo vacío", "ERROR", JOptionPane.WARNING_MESSAGE);
			    logger.warning("Se ha intentado registrar un dueño con un campo vacío");
			} else if (!con.equals(con2)) {
			    JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden", "ERROR", JOptionPane.WARNING_MESSAGE);
			    txtConR.setText("");
			    txtConR.setText("");
			    logger.warning("Se ha introducido una contraseña que no coincide");
			    
			} else {
			    Dueño d = new Dueño(nom, apell, dni, null, fNac, telefono, correo, con2);
			    Connection conn = BD.initBD("clinicaFurwell.db");
			    logger.warning("Se ha guardado un dueño en la base de datos");


			    if (BD.buscarDueño(conn, dni) != null) {
			        JOptionPane.showMessageDialog(null, "Ya existe un dueño con ese DNI", "ERROR", JOptionPane.ERROR_MESSAGE);
			        logger.warning("Se ha introducido un DNI ya existente");
			    } else {
			        
			    	boolean telefonoValido = txtTelf.getText().length() == 9;

			        if (!telefonoValido) {
			            JOptionPane.showMessageDialog(null, "Ese número de teléfono es incorrecto", "ERROR", JOptionPane.ERROR_MESSAGE);
			            txtTelf.setText("");
					    logger.warning("Se ha intentado registrar un dueño un numero incorrecto");

			        } else {
			            boolean registroInsertado = BD.insertarDueño(nom, apell, dni, null, fNac, telefono, correo, con2);

			            if (registroInsertado) {
			                JOptionPane.showMessageDialog(null, "Dueño registrado con éxito", "REGISTRADO", JOptionPane.INFORMATION_MESSAGE);
			                logger.info("Se ha registrado un dueño");
			                dispose();
			                new VentanaInicioSesion();
			            } else {
			                JOptionPane.showMessageDialog(null, "Error al registrar el dueño", "ERROR", JOptionPane.ERROR_MESSAGE);
			                logger.warning("Error al registrar el dueño");
			            }
			        }
			    }
			}
			
			
			
				
				
			
		});
		btnSalir.addActionListener((e)->{
			dispose();
			new VentanaInicio();
		});
		
		vActual = this;
		setBounds(800, 350, 350, 400);
		
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
	}
	
	
	

}
