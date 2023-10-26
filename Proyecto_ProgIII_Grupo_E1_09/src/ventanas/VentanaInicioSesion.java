package ventanas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class VentanaInicioSesion extends JFrame{
	
	private JFrame vActual;
	private JPanel panel, panelCentro, panelSur;
	private JLabel labelUsuraio, labelContraseña;
	private JTextField textUsuario; 
	private JPasswordField textContraseña;
	private JButton btnAceptar, btnCancelar;
	
	
	
	public VentanaInicioSesion(){
		
		panel = new JPanel();
		panelCentro = new JPanel(new GridLayout(2,2));
		panelSur = new JPanel(new FlowLayout());
		
		labelUsuraio = new JLabel("Usuario: ");
		labelContraseña = new JLabel("Contraseña: ");
		textUsuario = new JTextField();
		textContraseña = new JPasswordField();
		btnAceptar = new JButton("Aceptar");
		btnCancelar = new JButton("Cancelar");
		
		panelCentro.add(labelUsuraio);
		panelCentro.add(textUsuario);
		panelCentro.add(labelContraseña);
		panelCentro.add(textContraseña);
		panelSur.add(btnAceptar);
		panelSur.add(btnCancelar);
		
		this.add(panel);
		panel.setLayout(new BorderLayout());
		panel.add(panelCentro, BorderLayout.CENTER);
		panel.add(panelSur, BorderLayout.SOUTH);
		
		vActual = this;
		setTitle("Bienvenido a Furwell!");
		setBounds(300, 50, 700, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

}
