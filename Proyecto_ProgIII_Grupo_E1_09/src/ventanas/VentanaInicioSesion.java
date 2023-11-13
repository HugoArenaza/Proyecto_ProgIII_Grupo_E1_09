package ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import domain.Contenedora;
import domain.Dueño;

public class VentanaInicioSesion extends JFrame{
	
	private JFrame vActual;
	private JPanel panel, panelCentro, panelSur, pCInformacion, pcIzq;
	private JLabel labelUsuraio, labelContraseña, labelDni;
	private JTextField textUsuario, txtDni; 
	private JPasswordField textContraseña;
	private JButton btnAceptar, btnCancelar;
	private Dueño dueño;
	
	
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
		
		btnAceptar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String User = textUsuario.getText();
				String dni = txtDni.getText();
				String con = textContraseña.getText();
				Dueño d = Contenedora.buscarCliente(dni);
				if(d == null) {
					JOptionPane.showMessageDialog(null, "Para poder iniciar sesión tienes que estar registrado","ERROR",JOptionPane.ERROR_MESSAGE);
					new VentanaRegistroDueño();
					dispose();
				}else {
					if(d.getContraseña().equals(con)) {
						JOptionPane.showMessageDialog(null, "Bienvenido!","SESIÓN INICIADA",JOptionPane.INFORMATION_MESSAGE);
						dueño = d; 
						dispose();
						new VentanaDueño();
						
						vActual.setVisible(false);
						textContraseña.setText("");
						textUsuario.setText("");
						txtDni.setText("");
					}else {
						JOptionPane.showMessageDialog(null, "Contraseña incorrecta","ERROR",JOptionPane.WARNING_MESSAGE);
					}
				
			}}
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
