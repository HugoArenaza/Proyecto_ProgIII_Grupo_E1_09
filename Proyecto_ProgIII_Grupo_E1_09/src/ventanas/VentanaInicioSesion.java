package ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.util.logging.Logger;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import base_de_datos.BD;
import domain.Contenedora;
import domain.Dueño;

public class VentanaInicioSesion extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Logger logger = java.util.logging.Logger.getLogger("Logger");
	
	private JFrame vActual;
	private JPanel panel, panelCentro, panelSur, pCInformacion, pcIzq;
	private JLabel labelUsuraio, labelContraseña, labelDni;
	private JTextField textUsuario, txtDni; 
	private JPasswordField textContraseña;
	private JButton btnAceptar, btnCancelar;
	public VentanaInicioSesion(){
		//BoxLayout.X_AXIS
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panelCentro = new JPanel();
		panelCentro.setLayout(new BorderLayout());
		panelSur = new JPanel(new FlowLayout());
		
		pcIzq = new JPanel();
		pcIzq.setLayout(new BoxLayout(pcIzq, BoxLayout.Y_AXIS));
		
		
		pCInformacion = new JPanel();
		pCInformacion.setLayout(new BoxLayout(pCInformacion, BoxLayout.Y_AXIS));
		
		labelUsuraio = new JLabel("Usuario: ");
		labelContraseña = new JLabel("Contraseña: ");
		labelDni = new JLabel("Dni:");
		textUsuario = new JTextField(20);
		textContraseña = new JPasswordField();
		txtDni = new JTextField(20);
		btnAceptar = new JButton("Aceptar");
		btnCancelar = new JButton("Cancelar");
		
		textUsuario.setMaximumSize(new Dimension(Integer.MAX_VALUE, 20));
		textContraseña.setMaximumSize(new Dimension(Integer.MAX_VALUE, 20));
		txtDni.setMaximumSize(new Dimension(Integer.MAX_VALUE, 20));
		
		
		
		pcIzq.setBorder(new EmptyBorder(50, 250, 500, 500));
		

		pcIzq.add(labelDni);
		pcIzq.add(txtDni);
		pcIzq.add(labelUsuraio);
		pcIzq.add(labelUsuraio);
		pcIzq.add(textUsuario);
		pcIzq.add(labelContraseña);
		pcIzq.add(textContraseña);
		
		
		panelSur.add(btnAceptar);
		panelSur.add(btnCancelar);
		
		
		panelCentro.add(pcIzq, BorderLayout.WEST);
		
		
		panel.add(panelCentro, BorderLayout.CENTER);
		
		panel.add(panelSur, BorderLayout.SOUTH);
		
		
		
		getContentPane().add(panel);
		
		
		
		textContraseña.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String dni = txtDni.getText().toUpperCase();
		        @SuppressWarnings("deprecation")
		        String con = textContraseña.getText();

		        // Verificar si el DNI coincide con el de vet1
		        if (dni.equals("12345678")) { // Reemplaza con el DNI de vet1
		            if (con.equals("contraseña1")) { // Reemplaza con la contraseña de vet1
		                // Abre la ventana correspondiente al veterinario vet1
		                // Ejemplo:
		                new VentanaJefe();
		            } else {
		                JOptionPane.showMessageDialog(null, "La contraseña es incorrecta", "ERROR", JOptionPane.ERROR_MESSAGE);
		                textContraseña.setText("");
		                textUsuario.setText("");
		                txtDni.setText("");
		            }
		        }
		        // Verificar si el DNI coincide con el de vet2
		        else if (dni.equals("72345618")) { // Reemplaza con el DNI de vet2
		            if (con.equals("contraseña2")) { // Reemplaza con la contraseña de vet2
		                // Abre la ventana correspondiente al veterinario vet2
		                // Ejemplo:
		                new VentanaTrabajador();
		            } else {
		                JOptionPane.showMessageDialog(null, "La contraseña es incorrecta", "ERROR", JOptionPane.ERROR_MESSAGE);
		                textContraseña.setText("");
		                textUsuario.setText("");
		                txtDni.setText("");
		            }
		        }
		        // El DNI no coincide con ninguno de los veterinarios
		        else {
		            JOptionPane.showMessageDialog(null, "DNI incorrecto o no registrado", "ERROR", JOptionPane.ERROR_MESSAGE);
		            textContraseña.setText("");
		            textUsuario.setText("");
		            txtDni.setText("");
		        }
		    }
				
				/*
				@SuppressWarnings("unused")
				String User = textUsuario.getText();
				String dni = txtDni.getText().toUpperCase();
				@SuppressWarnings("deprecation")
				String con = textContraseña.getText();
				
				Connection conn = BD.initBD("clinicaFurwell.db");
				
				Dueño dueñoABuscar = BD.buscarDueño(conn, dni);
				if (dueñoABuscar != null) {
					
					String contraseña = dueñoABuscar.getContraseña();
					String apellidos = dueñoABuscar.getApellidos();
					String nombre = dueñoABuscar.getNombreDueño();
					String correo = dueñoABuscar.getCorreo();
					String dniRegistrado = dueñoABuscar.getDni();
					int numeroTlf = dueñoABuscar.getNumeroTlf();
					String fNac = dueñoABuscar.getfNac();
					
					Dueño d = new Dueño(nombre, apellidos, dniRegistrado, null, fNac, numeroTlf, correo, contraseña);
					if(contraseña.equals(con)) {
						JOptionPane.showMessageDialog(null, "Bienvenido!","SESIÓN INICIADA",JOptionPane.INFORMATION_MESSAGE);
						VentanaInicio.setDueño(d);
						dispose();
						
						
						new VentanaDueño();
					
					logger.info("Se ha iniciado sesión con un usuario");
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "La contraseña es incorrecta","ERROR",JOptionPane.ERROR_MESSAGE);
					logger.warning("Se ha introducido un usuario con la contraseña incorrecta");
					textContraseña.setText("");
					textUsuario.setText("");
					txtDni.setText("");
				}
					
					}else {
						int numero = JOptionPane.showConfirmDialog(null, "Ese dni es incorrecto o no esta registrado ¿Quieres registrarlo?", "Confirmación", JOptionPane.YES_NO_OPTION);
						if (numero == JOptionPane.YES_OPTION) {
				            new VentanaRegistroDueño();
				          
				        } else {
				        	textContraseña.setText("");
							textUsuario.setText("");
							txtDni.setText("");
				           
				        }
						logger.warning("Se ha introducido un usuario sin registrar");
						
					
					
						
							
						vActual.setVisible(false);
						
					
				
			}*/}
		);
		
		panel.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {

					@SuppressWarnings("unused")
					String User = textUsuario.getText();
					String dni = txtDni.getText().toUpperCase();
					@SuppressWarnings("deprecation")
					String con = textContraseña.getText();
					
					Connection conn = BD.initBD("clinicaFurwell.db");
					
					Dueño dueñoABuscar = BD.buscarDueño(conn, dni);
					if (dueñoABuscar != null) {
						
						String contraseña = dueñoABuscar.getContraseña();
						String apellidos = dueñoABuscar.getApellidos();
						String nombre = dueñoABuscar.getNombreDueño();
						String correo = dueñoABuscar.getCorreo();
						String dniRegistrado = dueñoABuscar.getDni();
						int numeroTlf = dueñoABuscar.getNumeroTlf();
						String fNac = dueñoABuscar.getfNac();
						
						Dueño d = new Dueño(nombre, apellidos, dniRegistrado, null, fNac, numeroTlf, correo, contraseña);
						if(contraseña.equals(con)) {
							JOptionPane.showMessageDialog(null, "Bienvenido!","SESIÓN INICIADA",JOptionPane.INFORMATION_MESSAGE);
							VentanaInicio.setDueño(d);
							dispose();
							
							
							new VentanaDueño();
						
						logger.info("Se ha iniciado sesión con un usuario");
						dispose();
					}else {
						JOptionPane.showMessageDialog(null, "La contraseña es incorrecta","ERROR",JOptionPane.ERROR_MESSAGE);
						logger.warning("Se ha introducido un usuario con la contraseña incorrecta");
						textContraseña.setText("");
						textUsuario.setText("");
						txtDni.setText("");
					}
						
						}else {
							int numero = JOptionPane.showConfirmDialog(null, "Ese dni es incorrecto o no esta registrado ¿Quieres registrarlo?", "Confirmación", JOptionPane.YES_NO_OPTION);
							if (numero == JOptionPane.YES_OPTION) {
					            new VentanaRegistroDueño();
					          
					        } else {
					        	textContraseña.setText("");
								textUsuario.setText("");
								txtDni.setText("");
					           
					        }
							logger.warning("Se ha introducido un usuario sin registrar");
							
						
						
							
								
							vActual.setVisible(false);
							}
				}else if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_PLUS) {
					System.out.println("CTRL +");
				}
			}
		});
		
		btnCancelar.addActionListener((e)->{
			dispose();
			
		});
		
		vActual = this;
		setBounds(600, 350, 750, 400);
		setTitle("Bienvenido a Furwell!");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
	}

}
