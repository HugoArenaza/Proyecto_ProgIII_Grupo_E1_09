package ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class VentanaInicioSesion extends JFrame{
	
	private JFrame vActual;
	private JPanel panel, panelCentro, panelSur, pCInformacion, pcIzq;
	private JLabel labelUsuraio, labelContraseña;
	private JTextField textUsuario; 
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
		textUsuario = new JTextField(20);
		textContraseña = new JPasswordField();
		btnAceptar = new JButton("Aceptar");
		btnCancelar = new JButton("Cancelar");
		
		textUsuario.setMaximumSize(new Dimension(Integer.MAX_VALUE, 20));
		textContraseña.setMaximumSize(new Dimension(Integer.MAX_VALUE, 20));
		
		
		
		pcIzq.setBorder(new EmptyBorder(50, 250, 500, 500));
		

	
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
				
				
			}
		});
		
		btnCancelar.addActionListener((e)->{
			dispose();
			
		});
		
		vActual = this;
		setTitle("Bienvenido a Furwell!");
		setBounds(300, 50, 700, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

}
